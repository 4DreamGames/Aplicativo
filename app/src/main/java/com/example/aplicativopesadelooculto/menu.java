package com.example.aplicativopesadelooculto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    private ImageButton ImageButtonVideo1, ImageButtonVideo2;
    private TextView infoTextTitulo, infoText1, infoText2, infoText3 ;
    private BottomNavigationView bottomNavigationView;
    ListView listView;
    String txt;
    String devsList[] = {"Carlos Eduardo","Leo Kenzo", "Davi Gonzaga", "Bruno Lima", "Pedro Guilherme","Jhonata Brito"};
    int devsImagens [] = {R.drawable.carlos, R.drawable.davi,R.drawable.jhonata,R.drawable.pedro,R.drawable.bruno,R.drawable.leo };

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ScrollView scrollViewMenu = findViewById(R.id.scrollViewMenu);

        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView saudacao = findViewById(R.id.infoTextViewTitulo);
        if (extras != null && extras.containsKey(MainActivity.EXTRA_MESSAGE)) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            txt = String.format("Olá <%s>", msg);
            saudacao.setText(txt);
        }



        ImageButtonVideo1 = findViewById(R.id.imageVideo1);
        ImageButtonVideo2 = findViewById(R.id.imageVideo2);
        ImageButtonVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ImageButtonVideo1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                startActivity(ImageButtonVideo1);
            }
        });
        ImageButtonVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ImageButtonVideo2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.youtube.com/"));
                startActivity(ImageButtonVideo2);
            }
        });

        CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), devsList, devsImagens);
        listView = (ListView) findViewById(R.id.customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Log.i("activity_menu", "Item selecionado : : " + position);
            }
        });
        bottomNavigationView = findViewById(R.id.bottomNavigationView);
        infoTextTitulo = findViewById(R.id.infoTextViewTitulo);
        infoText1 = findViewById(R.id.infoTextView);
        infoText2 = findViewById(R.id.infoTextView2);
        infoText3 = findViewById(R.id.infoTextView3);
        listView.setVisibility(View.GONE);

        // Set the OnItemSelectedListener for BottomNavigationView
        bottomNavigationView.setOnItemSelectedListener(item -> {
            if (item.getItemId() == R.id.inicioItem) {
                //invisible apaga o conteudo da tela dele perante a tela que vc pedir para exibir
                infoTextTitulo.setText(txt);
                listView.setVisibility(View.GONE);
                infoText1.setText(R.string.HomeIntroducao);
                infoText2.setText(R.string.Home);
                infoText1.setVisibility(View.VISIBLE);
                infoText2.setVisibility(View.VISIBLE);
                ImageButtonVideo1.setVisibility(View.VISIBLE);
                ImageButtonVideo2.setVisibility(View.VISIBLE);
            } else if (item.getItemId() == R.id.devsItem) {
                infoTextTitulo.setText(R.string.devTitulo);
                infoText1.setVisibility(View.GONE);
                infoText2.setVisibility(View.GONE);
                infoText3.setVisibility(View.GONE);
                ImageButtonVideo1.setVisibility(View.GONE);
                ImageButtonVideo2.setVisibility(View.GONE);
                //chamando o Adapter do listview
                listView.setAdapter(customAdapter);
                listView.setVisibility(View.VISIBLE);
            } else if (item.getItemId() == R.id.tremItem) {
                infoTextTitulo.setText(R.string.HistoriaTitulo);
                infoText2.setText(R.string.Historia);
                ImageButtonVideo2.setVisibility(View.GONE);
                infoText1.setVisibility(View.GONE);
                infoText3.setVisibility(View.GONE);
                infoText2.setVisibility(View.VISIBLE);
                ImageButtonVideo1.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else if (item.getItemId() == R.id.instrucoesItem) {
                infoTextTitulo.setText(R.string.instrucoesGame);
                infoText1.setText(R.string.Instrucoes);
                infoText2.setVisibility(View.GONE);
                infoText3.setVisibility(View.GONE);
                ImageButtonVideo1.setVisibility(View.GONE);
                ImageButtonVideo2.setVisibility(View.GONE);
                infoText1.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            } else if (item.getItemId() == R.id.sobreItem) {
                infoTextTitulo.setText(R.string.sobre);
                infoText1.setText(R.string.conteudosobre);
                infoText2.setVisibility(View.GONE);
                infoText3.setVisibility(View.GONE);
                ImageButtonVideo2.setVisibility(View.GONE);
                ImageButtonVideo1.setVisibility(View.GONE);
                infoText1.setVisibility(View.VISIBLE);
                listView.setVisibility(View.GONE);
            }
            return true;
        });

    }
}
