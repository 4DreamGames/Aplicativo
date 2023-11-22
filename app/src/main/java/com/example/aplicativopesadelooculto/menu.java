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
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.badge.BadgeDrawable;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class menu extends AppCompatActivity {

    private ImageView ImageView1, ImageView2;
    private ImageButton ImageButtonVideo1, ImageButtonVideo2;
    private TextView infoTextTitulo, infoText1, infoText2, infoText3 ;
    private BottomNavigationView bottomNavigationView;
    ListView listView;
    String txt;
    String devsList[] = {"Carlos Eduardo","Leo Kenzo", "Bruno Lima", "Pedro Guilherme","Jhonata Brito", "Davi Gonzaga"};
    String devsListFuncao[] = {"Full Stack/Analista","Front-End/Mobile", "Modelador & Design",  "Back-End/Unity", "Back-End/Unity & Design", "Back-End/Unity & Design"};
    String devsListStatus[] = {"Líder", "Co-Líder", "Colaborador", "Colaborador", "Colaborador", "Colaborador"};
    String devsListGitHub [] = {"Link GitHub", "Link GitHub", "Link GitHub", "Link GitHub", "Link GitHub", "Link GitHub"};
    String introducao = "";
    int devsImagens [] = {R.drawable.carlos,R.drawable.leo ,R.drawable.bruno,R.drawable.pedro,R.drawable.jhonata, R.drawable.davi};
    CustomAdapter customAdapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);
        ScrollView scrollViewMenu = findViewById(R.id.scrollViewMenu);

        String saudacaoText;
        Bundle extras = getIntent().getExtras();
        if (extras != null && extras.containsKey(MainActivity.EXTRA_MESSAGE)) {
            String msg = extras.getString(MainActivity.EXTRA_MESSAGE);
            saudacaoText = String.format("Olá <%s>,", msg);
        } else {
            saudacaoText = getResources().getString(R.string.saudacao);
        }

         introducao = getResources().getString(R.string.HomeIntroducao, saudacaoText);

        ImageButtonVideo1 = findViewById(R.id.imageVideo1);
        ImageButtonVideo2 = findViewById(R.id.imageVideo2);
        ImageView1 = findViewById(R.id.imageView1);
        ImageView2 = findViewById(R.id.imageView2);

        ImageButtonVideo1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ImageButtonVideo1 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/GfCenrDfe-I"));
                startActivity(ImageButtonVideo1);
            }
        });
        ImageButtonVideo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent ImageButtonVideo2 = new Intent(Intent.ACTION_VIEW, Uri.parse("https://youtu.be/NruFnaBRRuk"));
                startActivity(ImageButtonVideo2);
            }
        });

         customAdapter = new CustomAdapter(getApplicationContext(),devsList,devsListGitHub, devsListFuncao, devsListStatus, devsImagens);
        listView = (ListView) findViewById(R.id.customListView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent;

                // Verificar qual item foi clicado baseado na posição
                switch (position) {
                    case 0: // Ação para o primeiro item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/MartinsCarlos111"));
                        startActivity(intent);
                        break;

                    case 1: // Ação para o segundo item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/LeoMasago"));
                        startActivity(intent);
                        break;

                    case 2: // Ação para o terceiro item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Nikito-13"));
                        startActivity(intent);
                        break;
                    case 3: // Ação para o terceiro item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/pedroribeiro07"));
                        startActivity(intent);
                        break;

                    case 4: // Ação para o terceiro item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Jhonata-souza"));
                        startActivity(intent);
                        break;
                    case 5: // Ação para o terceiro item
                        intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://github.com/Davignz"));
                        startActivity(intent);
                        break;
                    // Adicione mais cases conforme a quantidade de itens no seu ListView

                    default:
                        Log.i("activity_menu", "Item não reconhecido: " + position);
                        break;
                }

                Log.i("activity_menu", "Item selecionado: " + position);
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
            verificaClique(item.getItemId());
            return true;
        });
        defineInicio();
    }

    private void verificaClique(int i) {
        if (i == R.id.inicioItem) {
            defineInicio();
        } else if (i == R.id.devsItem) {
            defineDevs();
        } else if (i== R.id.tremItem) {
            defineItem();
        } else if (i == R.id.instrucoesItem) {
            defineInstrucoes();
        } else if (i == R.id.sobreItem) {
            defineSobre();
        }
    }

    private void defineSobre() {
        infoTextTitulo.setText(R.string.sobre);
        infoText1.setText(R.string.conteudosobre);
        infoText2.setVisibility(View.GONE);
        infoText3.setVisibility(View.GONE);
        ImageButtonVideo2.setVisibility(View.GONE);
        ImageButtonVideo1.setVisibility(View.GONE);
        infoText1.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        ImageView1.setVisibility(View.GONE);
        ImageView2.setVisibility(View.GONE);
    }

    private void defineInstrucoes() {
        infoTextTitulo.setText(R.string.instrucoesGame);
        infoText3.setText(R.string.InstrucoesContinuacao);
        infoText2.setText(R.string.Instrucoes);
        infoText1.setText(R.string.IntroducaoInstrucoes);
        ImageView1.setImageResource(R.drawable.instrucoes);
        ImageView2.setImageResource(R.drawable.esconderijo);
        ImageView1.setVisibility(View.VISIBLE);
        ImageView2.setVisibility(View.VISIBLE);
        infoText3.setVisibility(View.VISIBLE);
        infoText2.setVisibility(View.VISIBLE);
        infoText1.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        ImageButtonVideo1.setVisibility(View.GONE);
        ImageButtonVideo2.setVisibility(View.GONE);
    }

    private void defineItem() {
        infoTextTitulo.setText(R.string.HistoriaTitulo);
        infoText3.setText(R.string.Historia);
        ImageView1.setImageResource(R.drawable.imagemtrem);
        infoText3.setVisibility(View.VISIBLE);
        ImageView1.setVisibility(View.VISIBLE);
        listView.setVisibility(View.GONE);
        ImageButtonVideo2.setVisibility(View.GONE);
        ImageButtonVideo1.setVisibility(View.GONE);
        ImageView2.setVisibility(View.GONE);
        infoText1.setVisibility(View.GONE);
        infoText2.setVisibility(View.GONE);
    }

    private void defineDevs() {
        infoTextTitulo.setText(R.string.devTitulo);
        infoText1.setVisibility(View.GONE);
        infoText2.setVisibility(View.GONE);
        infoText3.setVisibility(View.GONE);
        ImageButtonVideo1.setVisibility(View.GONE);
        ImageButtonVideo2.setVisibility(View.GONE);
        //chamando o Adapter do listview
        listView.setAdapter(customAdapter);
        listView.setVisibility(View.VISIBLE);
        ImageView1.setVisibility(View.GONE);
        ImageView2.setVisibility(View.GONE);
    }

    private void defineInicio() {
        infoTextTitulo.setText(R.string.titulo);
        infoText1.setText(introducao);
        infoText2.setText(R.string.home1);
        infoText3.setText(R.string.home2);
        ImageButtonVideo2.setImageResource(R.drawable.imagemvida);
        ImageButtonVideo1.setImageResource(R.drawable.agacharprint);
        listView.setVisibility(View.GONE);
        //infoText1.invalidate();
        infoText1.setVisibility(View.VISIBLE);
        infoText2.setVisibility(View.VISIBLE);
        infoText3.setVisibility(View.VISIBLE);
        ImageButtonVideo1.setVisibility(View.VISIBLE);
        ImageButtonVideo2.setVisibility(View.VISIBLE);
        ImageView1.setVisibility(View.GONE);
        ImageView2.setVisibility(View.GONE);
    }
}
