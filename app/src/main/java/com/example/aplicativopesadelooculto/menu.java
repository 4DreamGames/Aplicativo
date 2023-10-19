package com.example.aplicativopesadelooculto;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    private ImageButton ImageButtonVideo1, ImageButtonVideo2;
    private ScrollView scrollViewHistoria, scrollViewInstrucoes, scrollViewSobre;
    private TextView infoTextViewHomeIntroducao, infoTextViewDevs, infoTextViewDevs2, infoTextHistoria1, infoTextHistoria2, infoTextInstrucoes1 ,infoTextInstrucoes2, infoTextHome1, infoTextHome2, infoTextSobre1, infoTextSobre2;
    private BottomNavigationView bottomNavigationView;
    ListView listViewDevs;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ScrollView scrollViewMenu = findViewById(R.id.scrollViewMenu);
        ScrollView scrollViewDevs = findViewById(R.id.scrollViewDevs);
        ImageButtonVideo1 = findViewById(R.id.imageVideo1);
        ImageButtonVideo2 = findViewById(R.id.imageVideo2);

        // Retrieve the message from the intent and display it
        Bundle extras = getIntent().getExtras();
        String msg = null;
        TextView saudacao = findViewById(R.id.textNome);
        if (extras != null && extras.containsKey(MainActivity.EXTRA_MESSAGE)) {
            msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            String txt = String.format("Olá <%s>", msg);
            saudacao.setText(txt);
        }
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
        // scrollViewDevs.setVisibility(View.GONE);
        // Initialize infoTextView and BottomNavigationView
        infoTextHome1 = findViewById(R.id.infoTextViewHome1);
        infoTextHome2 = findViewById(R.id.infoTextViewHome2);
        infoTextViewHomeIntroducao = findViewById(R.id.infoTextViewHomeIntroducao);

        infoTextSobre1 = findViewById(R.id.infoTextViewSobre1);
        infoTextSobre2 = findViewById(R.id.infoTextViewSobre2);

        infoTextInstrucoes1 = findViewById(R.id.infoTextViewInstru2);
        infoTextInstrucoes2 = findViewById(R.id.infoTextViewInstru3);

        infoTextHistoria1 = findViewById(R.id.infoTextViewHistoriaTitulo);
        infoTextHistoria2 = findViewById(R.id.infoTextViewHistoria);

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
                infoTextViewHomeIntroducao.setText(R.string.HomeIntroducao);
                infoTextHome1.setText(R.string.Home);
                infoTextHome2.setText(R.string.Home);
                scrollViewMenu.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.devsItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                infoTextViewDevs2.setText(R.string.devTitulo);
                infoTextViewDevs.setText(R.string.desenvolvedores2);
                scrollViewDevs.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.tremItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                infoTextHistoria1.setText(R.string.historia);
                infoTextHistoria2.setText(R.string.Historia);
                scrollViewHistoria.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.instrucoesItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewSobre.setVisibility(View.INVISIBLE);
                infoTextInstrucoes1.setText(R.string.instrucoesGame);
                infoTextInstrucoes2.setText(R.string.Instrucoes);
                scrollViewInstrucoes.setVisibility(View.VISIBLE);

            } else if (item.getItemId() == R.id.sobreItem) {
                scrollViewMenu.setVisibility(View.INVISIBLE);
                scrollViewDevs.setVisibility(View.INVISIBLE);
                scrollViewHistoria.setVisibility(View.INVISIBLE);
                scrollViewInstrucoes.setVisibility(View.INVISIBLE);
                infoTextSobre1.setText(R.string.sobre);
                infoTextSobre2.setText(R.string.conteudosobre);
                scrollViewSobre.setVisibility(View.VISIBLE);
            }
            return true;
        });

        listViewDevs = findViewById(R.id.listViewDevs);
        listViewDevs.setAdapter(adapter);

        String[] itensDevs = new String[]{"Item 1", "Item 2", "Item 3", "Item 4", "Item 5"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, // Contexto
                android.R.layout.simple_list_item_1, // ID do layout do item da lista (layout padrão fornecido pelo Android)
                itensDevs // Dados
        );
    }
}
