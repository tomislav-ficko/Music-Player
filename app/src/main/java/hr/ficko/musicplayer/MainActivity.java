package hr.ficko.musicplayer;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mSong1;
    private MediaPlayer mSong2;
    private MediaPlayer mSong3;
    private MediaPlayer mSong4;
    private MediaPlayer mSong5;
    private MediaPlayer mSong6;
    private MediaPlayer mSong7;
    private MediaPlayer mSong8;
    private MediaPlayer currentSong;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        prepareSongs();
    }

    public void playSong1(View view) {
        playSong(mSong1);
    }

    public void playSong2(View view) {
        playSong(mSong2);
    }

    public void playSong3(View view) {
        playSong(mSong3);
    }

    public void playSong4(View view) {
        playSong(mSong4);
    }

    public void playSong5(View view) {
        playSong(mSong5);
    }

    public void playSong6(View view) {
        playSong(mSong6);
    }

    public void playSong7(View view) {
        playSong(mSong7);
    }

    public void playSong8(View view) {
        playSong(mSong8);
    }

    public void playButton(View view) {
        if (!currentSong.isPlaying()) {
            currentSong.start();
        }
    }

    public void pauseButton(View view) {
        currentSong.pause();
    }

    private void prepareSongs() {
        mSong1 = MediaPlayer.create(getApplicationContext(), R.raw.all_i_need);
        mSong2 = MediaPlayer.create(getApplicationContext(), R.raw.headrest_for_my_soul);
        mSong3 = MediaPlayer.create(getApplicationContext(), R.raw.i_am);
        mSong4 = MediaPlayer.create(getApplicationContext(), R.raw.jailbreak);
        mSong5 = MediaPlayer.create(getApplicationContext(), R.raw.kill_your_heroes);
        mSong6 = MediaPlayer.create(getApplicationContext(), R.raw.not_your_fault);
        mSong7 = MediaPlayer.create(getApplicationContext(), R.raw.sail);
        mSong8 = MediaPlayer.create(getApplicationContext(), R.raw.woman_woman);
    }

    private void playSong(MediaPlayer song) {
        song.start();
        currentSong = song;
    }

    @Override
    protected void onPause() {
        super.onPause();

    }
}
