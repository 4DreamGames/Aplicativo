package com.example.aplicativopesadelooculto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        // Retrieve the message from the intent and display it
        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView saudacao = findViewById(R.id.textNome);
        if (extras != null && extras.containsKey(MainActivity.EXTRA_MESSAGE)) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            String txt = String.format("Olá <%s>", msg);
            saudacao.setText(txt);
        }

        // Initialize infoTextView and BottomNavigationView
        infoTextView = findViewById(R.id.infoTextView);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        // Set the OnItemSelectedListener for BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.inicioItem) {
                infoTextView.setText(R.string.Home);
            } else if (item.getItemId() == R.id.devsItem) {
                infoTextView.setText(R.string.desenvolvedores);
            } else if (item.getItemId() == R.id.tremItem) {
                infoTextView.setText(R.string.historia);
            } else if (item.getItemId() == R.id.instrucoesItem) {
                infoTextView.setText(R.string.instrucoesGame);
            } else if (item.getItemId() == R.id.sobreItem) {
                infoTextView.setText(R.string.sobre);
            }
            return true;
        });
    }
}
