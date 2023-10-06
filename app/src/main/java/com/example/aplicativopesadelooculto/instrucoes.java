package com.example.aplicativopesadelooculto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class instrucoes extends AppCompatActivity {
    private BottomNavigationView bottomNavigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instrucoes);
        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.inicioItem) {

            } else if (item.getItemId() == R.id.devsItem) {

                Intent intent = new Intent(this, devs.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.tremItem) {

                Intent intent = new Intent(this, historia.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.instrucoesItem) {

                Intent intent = new Intent(this, instrucoes.class);
                startActivity(intent);
            } else if (item.getItemId() == R.id.sobreItem) {

                Intent intent = new Intent(this, sobre.class);
                startActivity(intent);
            }
            return true;
        });
    }
}