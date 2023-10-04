package com.example.aplicativopesadelooculto;

import static android.provider.AlarmClock.EXTRA_MESSAGE;

import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    public final static String EXTRA_MESSAGE = "com.example.aplicativopesadelooculto.MESSAGE";
ImageButton menuButton;
EditText NomeDigitado;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        menuButton = findViewById(R.id.identificacao);
        NomeDigitado = findViewById(R.id.editTextNome);
        menuButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                botaoClick(view);
                String textoNome = String.valueOf(NomeDigitado.getText());
                Intent backHome = new Intent(MainActivity.this, menu.class);
                backHome.putExtra(EXTRA_MESSAGE, textoNome);
                startActivity(backHome);
            }
        });
    }
    public void botaoClick(View v) {
        Vibrator vibrator = (Vibrator) getSystemService(VIBRATOR_SERVICE);
        long milliseconds = 500;
        if(vibrator != null && vibrator.hasVibrator()) {
            vibrator.vibrate(milliseconds);
        }
    }

}