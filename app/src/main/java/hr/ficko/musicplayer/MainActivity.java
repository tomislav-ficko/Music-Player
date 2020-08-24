package hr.ficko.musicplayer;

import android.media.SoundPool;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private final int PRIORITY = 0;
    private final float NORMAL_PLAY_RATE = 1.0f;
    private final float LEFT_VOLUME = 1.0f;
    private final float RIGHT_VOLUME = 1.0f;
    private final int NO_LOOP = 0;

    private SoundPool mSoundPool;
    private int mSong1;
    private int mSong2;
    private int mSong3;
    private int mSong4;
    private int mSong5;
    private int mSong6;
    private int mSong7;
    private int mSong8;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void playSong1(View view) {
    }
    public void playSong2(View view) {
    }
    public void playSong3(View view) {
    }
    public void playSong4(View view) {
    }
    public void playSong5(View view) {
    }
    public void playSong6(View view) {
    }
    public void playSong7(View view) {
    }
    public void playSong8(View view) {
    }
}
