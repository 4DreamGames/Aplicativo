package com.example.aplicativopesadelooculto;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.example.aplicativopesadelooculto.MESSAGE";

    private EditText editTextNome;
    private ImageButton identificacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNome = findViewById(R.id.editTextNome);
        identificacao = findViewById(R.id.identificacao);

        identificacao.setAlpha(0.5f);

        editTextNome.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().trim().length() > 0) {
                    identificacao.setAlpha(1.0f);  
                } else {
                    identificacao.setAlpha(0.5f);
                }
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });

        identificacao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String nome = editTextNome.getText().toString().trim();
                if (!nome.isEmpty()) {
                    Intent intent = new Intent(MainActivity.this, menu.class);
                    intent.putExtra(EXTRA_MESSAGE, nome);
                    startActivity(intent);
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, digite um nome.", Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
