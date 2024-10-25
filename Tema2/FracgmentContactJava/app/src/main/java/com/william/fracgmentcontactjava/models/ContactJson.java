package com.william.fracgmentcontactjava.models;

import android.content.Context;
import android.util.JsonToken;
import android.util.Log;
import android.widget.Toast;

import com.william.fracgmentcontactjava.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONTokener;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class ContactJson {

    /**
     * Metodo para obtener una coleccion de contactos de un json.
     * @param context context para obtener los recursos del resource
     * @return devuelve una coleccion de contactos
     * @throws JSONException problemas con el json
     * @throws IOException problemas con la lectura del fichero
     */
    public static ArrayList<Contact> parse(Context context){
        ArrayList<Contact> listResult = null;
        InputStream in = context.getResources().openRawResource(R.raw.contacts);

        try{
            int size = in.available();
            byte[] buffer = new byte[size];
            in.read(buffer);
            String content = new String(buffer, StandardCharsets.UTF_8);
            JSONTokener jsonToken = new JSONTokener(content);
            JSONArray jsonArray = new JSONArray(jsonToken);
            listResult = new ArrayList<>(jsonArray.length());
            for(int i = 0; i < jsonArray.length(); i++){
                JSONObject obj = jsonArray.getJSONObject(i);
                String id = obj.getString("id");
                String name = obj.getString("name");
                String firstSurname = obj.getString("firstSurname");
                String secondSurname = obj.getString("secondSurname");
                String birth = obj.getString("birth");
                String company = obj.getString("company");
                String email = obj.getString("email");
                String phone1 = obj.getString("phone1");
                String phone2 = obj.getString("phone2");
                String address = obj.getString("address");
                Contact tmp = new Contact(Integer.parseInt(id), name, firstSurname, secondSurname, birth, company, email, phone1, phone2, address);
                listResult.add(tmp);
            }

        } catch (IOException e) {

            Log.e("Error", e.getMessage());

        } catch (JSONException e) {
            Log.e("Error", e.getMessage());
        }

        return listResult;

    }
}
