package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity2 extends AppCompatActivity {

    private EditText editTextValorCambio, editTextNumber;
    private Button btnIncrementar, btnDecrementar;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        editTextValorCambio = findViewById(R.id.editTextNumber);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnDecrementar = findViewById(R.id);
        btnIncrementar = findViewById(R.id.btnIncrementar);

        editTextNumber.setText(String.valueOf(contador));

        btnIncrementar.setOnClickListener(v -> {
            int valorCambio = obtenerValorCambio();
            contador += valorCambio;
            editTextNumber.setText(String.valueOf(contador));
        });

        btnDecrementar.setOnClickListener(v -> {
            int valorCambio = obtenerValorCambio();
            contador -= valorCambio;
            editTextNumber.setText(String.valueOf(contador));
        });
    }

    private int obtenerValorCambio() {
        String texto = editTextValorCambio.getText().toString();
        if (texto.isEmpty()) {
            Toast.makeText(this, "Ingrese un valor de incremento/decremento", Toast.LENGTH_SHORT).show();
            return 1;  // Por defecto 1 si no se ingresa nada
        }
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor no válido, se usará 1", Toast.LENGTH_SHORT).show();
            return 1;
        }
    }
}

