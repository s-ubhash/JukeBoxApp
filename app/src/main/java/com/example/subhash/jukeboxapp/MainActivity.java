package com.example.subhash.jukeboxapp;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer player;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView list = (ListView)findViewById(R.id.songList);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String [] songTitles = getResources().getStringArray(R.array.song_titles);
                String song  = songTitles[i].toLowerCase();
                int songID = getResources().getIdentifier(song,"raw",getPackageName());
                if(player != null){
                    player.stop();
                    player = null;
                }
                player = MediaPlayer.create(MainActivity.this,songID);
                player.start();
            }
        });

    }


    public void onClickPlay(View view) {

    }

    public void onClickStop(View view) {
        player.stop();
        player = null;
    }
}
