package com.example.myapplication;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class mainContador extends AppCompatActivity {

    private EditText editTextValorCambio, editTextNumber;
    private Button btnIncrementar, btnDecrementar;
    private int contador = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_contador);

        editTextValorCambio = findViewById(R.id.editTextNumber2);
        editTextNumber = findViewById(R.id.editTextNumber);
        btnDecrementar = findViewById(R.id.btnDecrementar);
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
            return 1;
        }
        try {
            return Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Valor no válido, se usará 1", Toast.LENGTH_SHORT).show();
            return 1;
        }
    }
}