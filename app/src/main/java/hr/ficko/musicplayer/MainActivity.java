package hr.ficko.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private MediaPlayer currentSong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView song1 = (TextView) findViewById(R.id.song1_text_view);
        song1.setOnClickListener(this);
        TextView song2 = (TextView) findViewById(R.id.song2_text_view);
        song2.setOnClickListener(this);
        TextView song3 = (TextView) findViewById(R.id.song3_text_view);
        song3.setOnClickListener(this);
        TextView song4 = (TextView) findViewById(R.id.song4_text_view);
        song4.setOnClickListener(this);
        TextView song5 = (TextView) findViewById(R.id.song5_text_view);
        song5.setOnClickListener(this);
        TextView song6 = (TextView) findViewById(R.id.song6_text_view);
        song6.setOnClickListener(this);
        TextView song7 = (TextView) findViewById(R.id.song7_text_view);
        song7.setOnClickListener(this);
        TextView song8 = (TextView) findViewById(R.id.song8_text_view);
        song8.setOnClickListener(this);
    }

    public void playButton(View view) {
        if (!currentSong.isPlaying()) {
            currentSong.start();
        }
    }

    public void pauseButton(View view) {
        currentSong.pause();
    }

    @Override
    protected void onPause() {
        super.onPause();

        currentSong.release();
    }

    // When any of the songs is clicked, this method is executed
    @Override
    public void onClick(View v) {
        if (currentSong != null) {
            currentSong.release();
        }

        switch (v.getId()) {
            case R.id.song1_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.all_i_need);
                break;
            case R.id.song2_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.headrest_for_my_soul);
                break;
            case R.id.song3_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.i_am);
                break;
            case R.id.song4_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.jailbreak);
                break;
            case R.id.song5_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.kill_your_heroes);
                break;
            case R.id.song6_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.not_your_fault);
                break;
            case R.id.song7_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.sail);
                break;
            case R.id.song8_text_view:
                currentSong = MediaPlayer.create(getApplicationContext(), R.raw.woman_woman);
                break;
        }

        currentSong.start();
    }
}
