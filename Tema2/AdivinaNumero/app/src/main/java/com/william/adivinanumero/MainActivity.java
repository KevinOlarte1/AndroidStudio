package com.william.adivinanumero;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private int numeroAdivinar;
    private int intentosRestantes;
    private TextView intentosTextView;
    private TextView feedbackTextView;
    private TextView numeroAdivinarTextView;
    private Button[] buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        intentosTextView = findViewById(R.id.intentosRestantes);
        feedbackTextView = findViewById(R.id.feedbackTexto);
        numeroAdivinarTextView = findViewById(R.id.numeroAdivinar);


        buttons = new Button[10];
        buttons[0] = findViewById(R.id.button1);
        buttons[1] = findViewById(R.id.button2);
        buttons[2] = findViewById(R.id.button3);
        buttons[3] = findViewById(R.id.button4);
        buttons[4] = findViewById(R.id.button5);
        buttons[5] = findViewById(R.id.button6);
        buttons[6] = findViewById(R.id.button7);
        buttons[7] = findViewById(R.id.button8);
        buttons[8] = findViewById(R.id.button9);
        buttons[9] = findViewById(R.id.button10);


        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    buttonClicked(v);
                }
            });
        }


        nuevaPartida();
    }

    private void buttonClicked(View view) {
        Button boton = (Button) view;
        int numero = Integer.parseInt(boton.getText().toString());

        boton.setEnabled(false);
        intentosRestantes--;

        if (numero == numeroAdivinar) {
            numeroAdivinarTextView.setText(String.valueOf(numero));
            numeroAdivinarTextView.setTextColor(Color.BLUE);
            feedbackTextView.setText("¡Has ganado!");
            reiniciarPartida();
        } else if (intentosRestantes == 0) {
            numeroAdivinarTextView.setText(String.valueOf(numeroAdivinar));
            numeroAdivinarTextView.setTextColor(Color.RED);
            feedbackTextView.setText("Has perdido. Intenta de nuevo.");
            reiniciarPartida();
        } else {
            if (numero < numeroAdivinar) {
                feedbackTextView.setText("El número es mayor");
            } else {
                feedbackTextView.setText("El número es menor");
            }
        }

        intentosTextView.setText("Intentos restantes: " + intentosRestantes);
    }

    private void nuevaPartida() {
        Random random = new Random();
        numeroAdivinar = random.nextInt(10) + 1;  // Número aleatorio entre 1 y 10
        intentosRestantes = 3;

        intentosTextView.setText("Intentos restantes: " + intentosRestantes);
        feedbackTextView.setText("");
        numeroAdivinarTextView.setText("?");
        numeroAdivinarTextView.setTextColor(Color.BLACK);

        // Activamos todos los botones
        for (Button button : buttons) {
            button.setEnabled(true);
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    buttonClicked(view);
                }
            });
        }
    }

    private void reiniciarPartida() {
        // Permitimos iniciar una nueva partida haciendo clic en cualquier botón restante
        for (Button button : buttons) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    nuevaPartida();
                }
            });
        }
    }
}
