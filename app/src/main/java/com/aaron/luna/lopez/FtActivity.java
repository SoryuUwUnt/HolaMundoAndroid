package com.aaron.luna.lopez;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FtActivity extends AppCompatActivity {

    private EditText editTextMetros;
    private EditText editTextpies;
    private Button buttonconvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ft);
        editTextMetros = findViewById(R.id.editTextNumberMetros);
        editTextpies = findViewById(R.id.editTextNumberpies);
        editTextpies.setEnabled(false);
        buttonconvertir = findViewById(R.id.buttonconvertir);
        buttonconvertir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                realizaOperacion();
            }
        });
    }

    private void realizaOperacion() {
        double total = 0.00;
        if (editTextMetros.getText().toString() != null) {
            if (isEntero(editTextMetros.getText().toString())) {
                total = getEntero(editTextMetros.getText().toString()) * 3.2808;
            }
        }
        editTextpies.setText(String.valueOf(total), TextView.BufferType.SPANNABLE);
        editTextpies.setEnabled(false);
    }

    private int getEntero(String entero) {
        try {
            return Integer.parseInt(entero);
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return 0;
    }

    private boolean isEntero(String entero) {
        try {
            if (entero == null || entero.length() == 0) {
                return false;
            }
            Integer.parseInt(entero);
            return true;
        } catch (NumberFormatException ex) {
            ex.printStackTrace();
        }
        return false;
    }
}
