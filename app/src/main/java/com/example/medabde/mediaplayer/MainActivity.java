package com.example.medabde.mediaplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Music> arrayList;
    private CustomMusicAdapter adapter;
    private ListView musicList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        musicList = findViewById(R.id.list_item);
        arrayList = new ArrayList<>();


        arrayList.add(new Music("don big baby","big",R.raw.donbigshit));


        adapter = new CustomMusicAdapter(this,R.layout.item,arrayList);

        musicList.setAdapter(adapter);

    }
}
