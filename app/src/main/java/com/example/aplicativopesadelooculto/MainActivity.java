package com.example.aplicativopesadelooculto;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {

    private TextView infoTextView;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        infoTextView = findViewById(R.id.infoTextView);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.inicioItem) {
                infoTextView.setText(R.string.inicio);
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

        BadgeDrawable badge = bottomNavigationView.getOrCreateBadge(R.id.inicioItem);
        badge.setNumber(7);
        badge.setVisible(true);
    }
}