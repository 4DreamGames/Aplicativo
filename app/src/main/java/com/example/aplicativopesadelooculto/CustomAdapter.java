package com.example.aplicativopesadelooculto;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends BaseAdapter {

    Context context;
    String devsList[], devsListFuncao[], devsListStatus[], devsListGitHub[];
    int devsImagens[];
    LayoutInflater inflater;


public  CustomAdapter(Context ctx, String [] devsList, String [] devsListStatus,String [] devsListGitHub, String [] devsListFuncao, int [] devsImagens){
    this.context = ctx;
    this.devsList = devsList;
    this.devsListFuncao = devsListFuncao;
    this.devsListStatus = devsListStatus;
    this.devsListGitHub = devsListGitHub;
    this.devsImagens = devsImagens;
    inflater = LayoutInflater.from(ctx);
}
    @Override
    public int getCount() {
        return devsList.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
    convertView = inflater.inflate(R.layout.activity_custom_list_view, null);
    TextView txtView = (TextView) convertView.findViewById(R.id.textView);
    TextView textViewFuncao = (TextView) convertView.findViewById(R.id.textViewFuncao);
    TextView textViewLinkGitHub = (TextView) convertView.findViewById(R.id.textViewLinkGitHub);
    TextView textViewEquipe = (TextView) convertView.findViewById(R.id.textViewEquipe);
    ImageView devsImg = (ImageView) convertView.findViewById(R.id.imageIcon);
    txtView.setText(devsList[position]);
    textViewFuncao.setText(devsListFuncao[position]);
    textViewLinkGitHub.setText(devsListStatus[position]);
    textViewEquipe.setText(devsListGitHub[position]);
    devsImg.setImageResource(devsImagens[position]);
    return convertView;
    }
}
