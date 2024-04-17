package com.example.frenchteacherapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    //ini. the 3 buttons
    Button blackb, greenb, purpleb, redb, yellowb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        blackb = findViewById(R.id.blackb);
        greenb = findViewById(R.id.greenb);
        purpleb = findViewById(R.id.purpleb);
        redb = findViewById(R.id.redb);
        yellowb = findViewById(R.id.yellowb);

        /*REMOVING ALL THIS AS NOW DOING IT BY THE SIMPLE WAY YOU FUCKING IDIOT!
        ASSOCIATING THESE BUTTONS WITH THE INTERFACE

        red.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MediaPlayer mediaPlayer = MediaPlayer.create(
                       getApplicationContext(), //context of this MainActivity
                       R.raw.red //second parameter is the audio/video/raw file that we need to play
                );
                mediaPlayer.start();
            }
        });*/

        //ASSOCIATING THESE BUTTONS WITH THE INTERFACE-------

        redb.setOnClickListener(this);
        blackb.setOnClickListener(this);
     yellowb.setOnClickListener(this);
        greenb.setOnClickListener(this);
        purpleb.setOnClickListener(this);

        //this- refers to the OnClickListener() method. ----
        // It redirects the call to the onClick() method that is implemented and override it there.--------
        //If not used 'this' here-> your call will not be directed to the onClick() method--------
    }

    @Override
    public void onClick(View v) {
        //Find the id of the button and play the correct sound by media player by-
        //We need the creation of a single instance of the media player to play the correct sound thus introducing the func playsound
        //without using a boilerplate code
        int clickedBtnId = v.getId();

        if(clickedBtnId == R.id.redb){
           PlaySounds(R.raw.red);
        } else if (clickedBtnId == R.id.blackb) {
            PlaySounds(R.raw.black);
        }else if (clickedBtnId == R.id.yellowb) {
            PlaySounds(R.raw.yellow);
        }else if (clickedBtnId == R.id.greenb) {
            PlaySounds(R.raw.green);
        }else if (clickedBtnId == R.id.purpleb) {
            PlaySounds(R.raw.purple);
        }


    }
    public void PlaySounds(int id){        //passing the id
        MediaPlayer mediaPlayer = MediaPlayer.create(
                this,
              id
        );
        mediaPlayer.start();
    }
    //REMEMBER BITCH==> The MediaPlayer func always NEEDS 2 PARAMETERS---- The context & --the resource id
}