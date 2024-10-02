package com.william.listviewpaisos;

import android.content.Context;
import android.util.Log;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.InputStream;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class CountryParse {

    public static  Country[] parseCountry(Context context){
        Country[] pasies;
        try{
            InputStream inputStream = context.getResources().openRawResource(R.raw.countries);
            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dbBuilder = dbFactory.newDocumentBuilder();

            Document doc = dbBuilder.parse(inputStream);
            doc.getDocumentElement().normalize();

            NodeList nList = doc.getElementsByTagName("country");
            pasies = new Country[nList.getLength()];

            for (int i = 0; i < nList.getLength(); i++) {
                Node node = nList.item(i);

                if(node.getNodeType() == Node.ELEMENT_NODE){
                    Element element = (Element) node;

                    String code = element.getAttribute("countryCode");
                    Log.i("Pais", String.valueOf(pasies.length) + " : PAISES");
                    String name = element.getAttribute("countryName");
                    String capital = element.getAttribute("capital");
                    String population =element.getAttribute("population");

                    pasies[i] = new Country(name, code, population, capital);
                }
            }
        } catch (Exception e){
           pasies = new Country[0];
            Log.e("Error",e.getMessage());
        }
        return pasies;
    }
}