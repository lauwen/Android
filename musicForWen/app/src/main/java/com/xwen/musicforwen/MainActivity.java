package com.xwen.musicforwen;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private MediaPlayer mediaPlayer;
    private List<String> audioList = new ArrayList<String>();
    private int currentItem = 0;
    private Button pause;
    private static String[] imageFormatSet = new String[]{"mp3","wav","3gp"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mediaPlayer = new MediaPlayer();
        Button play = (Button) findViewById(R.id.play);
        Button stop = (Button) findViewById(R.id.stop);
        pause = (Button) findViewById(R.id.pause);
        Button pre = (Button) findViewById(R.id.pre);
        Button next = (Button) findViewById(R.id.next);
        audioList();

        mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                nextMusic();
            }
        });
        pre.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                preMusic();
            }
        });
        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                nextMusic();
            }
        });
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                playMusic(audioList.get(currentItem));
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.pause();
                    ((Button) v).setText("继续");
                }else{
                    mediaPlayer.start();
                    ((Button) v).setText("暂停");
                }
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mediaPlayer.isPlaying()){
                    mediaPlayer.stop();
                }
                pause.setEnabled(false);
            }
        });
    }
    private void audioList(){
        getFiles("/sdcard/");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,audioList);
        ListView listview = (ListView) findViewById(R.id.list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> listView, View view, int position, long id) {
                currentItem = position;
                playMusic(audioList.get(currentItem));
            }
        });
    }
    @Override
    protected void onDestroy(){
        if(mediaPlayer.isPlaying()){
            mediaPlayer.stop();
        }
        mediaPlayer.release();
        super.onDestroy();
    }

    private void getFiles(String url) {
        File files = new File(url);
        File[] file = files.listFiles();
        try{
            for(File f:file){
                if(f.isDirectory()){
                    getFiles(f.getAbsolutePath());
                }else{
                    if(isAudioFile(f.getPath())){
                        audioList.add(f.getPath());
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    void playMusic(String path){
        try{
            if(mediaPlayer.isPlaying()){
                mediaPlayer.stop();
            }
            mediaPlayer.reset();
            mediaPlayer.setDataSource(path);
            mediaPlayer.prepare();
            mediaPlayer.start();
            pause.setText("暂停");
            pause.setEnabled(true);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    void nextMusic(){
        if (++currentItem >= audioList.size()){
            currentItem = 0;
        }
        playMusic(audioList.get(currentItem));
    }
    void preMusic(){
        if(--currentItem >= 0){
            if(currentItem >= audioList.size()){
                currentItem = 0;
            }
        }else{
            currentItem = audioList.size()-1;
        }
        playMusic(audioList.get(currentItem));
    }



    private static boolean isAudioFile(String path){
        for (String format:imageFormatSet){
            if(path.contains(format)){
                return true;
            }
        }
        return false;
    }






}
