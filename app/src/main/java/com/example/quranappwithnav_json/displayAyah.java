package com.example.quranappwithnav_json;

import android.app.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class displayAyah extends AppCompatActivity {
    RecyclerView recycle ;
    ArrayList<ayah> dataHolder;
    RecyclerView.Adapter adapter;
    RecyclerView.LayoutManager layoutManager;
    TextView heading;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.display_ayah);
        Intent intent = getIntent();
        String format = intent.getStringExtra("format");
        String name = intent.getStringExtra("name");
        String number = intent.getStringExtra("number");

        recycle=(RecyclerView)findViewById(R.id.displayrecyclerView);
        dataHolder=new ArrayList<>();
        layoutManager = new LinearLayoutManager(displayAyah.this);
        recycle.setLayoutManager(layoutManager);

        if(format.equals("parah"))
        {
            heading.setText("Ayas of Parah number "+number);
            try {
                JSONObject obj=new JSONObject(loadJson());
                JSONArray array=obj.getJSONArray("data");
                for (int i=0;i<array.length();i++)
                {
                    JSONObject sbj=array.getJSONObject(i);
                    if(sbj.getString("juz").equals(number))
                    {

                        ayah a=new ayah();
                        a.setJuz(Integer.valueOf(number));
                        a.setSurahName(sbj.getString("surah_name"));
                        a.setText(sbj.getString("text"));
                        dataHolder.add(a);
                    }


                }

            } catch (JSONException e)
            {

            }

        }
        else
        {
            heading.setText("Ayas of Surah "+name);
            try {
                JSONObject obj=new JSONObject(loadJson());
                JSONArray array=obj.getJSONArray("data");
                for (int i=0;i<array.length();i++)
                {
                    JSONObject sbj=array.getJSONObject(i);
                    if(sbj.getString("surah_name").equals(name))
                    {

                        ayah a=new ayah();
                        a.setJuz(Integer.valueOf(sbj.getString("juz")));
                        a.setSurahName(sbj.getString("surah_name"));
                        a.setText(sbj.getString("text"));
                        dataHolder.add(a);
                    }


                }

            } catch (JSONException e)
            {

            }
        }


        adapter = new myRecyclerViewAdapterDisplay(dataHolder) ;
        recycle.setAdapter(adapter);
    }
    public String loadJson(){
        String json=null;
        try{
            InputStream in=getAssets().open("QuranMetaData.json");
            int size=in.available();
            byte[] buffer=new byte[size];
            in.read(buffer);
            in.close();
            json=new String(buffer,"UTF-8");
            Log.d("array","Done");


        }
        catch (IOException e)
        {
            e.printStackTrace();
            return null;
        }
        return json;
    }
}