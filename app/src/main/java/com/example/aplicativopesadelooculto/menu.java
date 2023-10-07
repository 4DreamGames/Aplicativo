package com.example.aplicativopesadelooculto;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    private ScrollView scrollViewMenu,scrollViewDevs, scrollViewHistoria, scrollViewInstrucoes, scrollViewSobre;
    private TextView infoTextViewDevs, infoTextViewDevs2, devTitulo, infoTextView, textSaudacao, infoTextHome1, infoTextHome2;
    private BottomNavigationView bottomNavigationView;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ScrollView scrollViewMenu = findViewById(R.id.scrollViewMenu);
        ScrollView scrollViewDevs = findViewById(R.id.scrollViewDevs);

        // Retrieve the message from the intent and display it
        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView saudacao = findViewById(R.id.textNome);
        if (extras != null && extras.containsKey(MainActivity.EXTRA_MESSAGE)) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            String txt = String.format("Olá <%s>", msg);
            saudacao.setText(txt);
        }
       // scrollViewDevs.setVisibility(View.GONE);

        // Initialize infoTextView and BottomNavigationView
        infoTextHome1 = findViewById(R.id.infoTextViewHome1);
        infoTextHome2 = findViewById(R.id.infoTextViewHome2);

        infoTextViewDevs = findViewById(R.id.infoTextViewDevs1);
        infoTextViewDevs2 = findViewById(R.id.infoTextViewDevs2);

        bottomNavigationView = findViewById(R.id.bottomNavigationView);

        scrollViewSobre = findViewById(R.id.scrollViewSobre);
        scrollViewInstrucoes = findViewById(R.id.scrollViewInstrucoes);
        scrollViewHistoria = findViewById(R.id.scrollViewHistoria);



        // Set the OnItemSelectedListener for BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            //esses dois codigos apagam o conteudo da pagina toda *Caso Precise*
//            scrollViewMenu.setVisibility(View.GONE);
//            scrollViewDevs.setVisibility(View.GONE);
            if (item.getItemId() == R.id.inicioItem) {
                //invisible apaga o conteudo da tela dele perante a tela que vc pedir para exibir
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                infoTextHome1.setText(R.string.Home);
                infoTextHome2.setText(R.string.Home);
                scrollViewMenu.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.devsItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                infoTextViewDevs2.setText(R.string.devTitulo);
                infoTextViewDevs.setText(R.string.Home);
                scrollViewDevs.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.tremItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                infoTextViewDevs2.setText(R.string.devTitulo);
                infoTextViewDevs.setText(R.string.Home);
                scrollViewHistoria.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.instrucoesItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                infoTextViewDevs2.setText(R.string.devTitulo);
                infoTextViewDevs.setText(R.string.Home);
                scrollViewInstrucoes.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.sobreItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                infoTextViewDevs2.setText(R.string.devTitulo);
                infoTextViewDevs.setText(R.string.Home);
                scrollViewSobre.setVisibility(View.VISIBLE);
            }
            return true;
        });
    }
}
