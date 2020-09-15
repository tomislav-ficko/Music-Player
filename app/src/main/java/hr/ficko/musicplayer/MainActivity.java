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

    //TODO SoundPool is not suitable for this kind of job, the files are too big. Should be replaced with MediaPlayer.
    private SoundPool mSoundPool;
    private int mSong1;
    private int mSong2;
    private int mSong3;
    private int mSong4;
    private int mSong5;
    private int mSong6;
    private int mSong7;
    private int mSong8;
    private int currentSongId;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mSoundPool = new SoundPool.Builder().build();
        loadSongs();
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
        mSoundPool.autoResume();
    }

    public void pauseButton(View view) {
        mSoundPool.autoPause();
    }

    private void loadSongs() {
        mSong1 = mSoundPool.load(getApplicationContext(), R.raw.all_i_need, PRIORITY);
        mSong2 = mSoundPool.load(getApplicationContext(), R.raw.headrest_for_my_soul, PRIORITY);
        mSong3 = mSoundPool.load(getApplicationContext(), R.raw.i_am, PRIORITY);
        mSong4 = mSoundPool.load(getApplicationContext(), R.raw.jailbreak, PRIORITY);
        mSong5 = mSoundPool.load(getApplicationContext(), R.raw.kill_your_heroes, PRIORITY);
        mSong6 = mSoundPool.load(getApplicationContext(), R.raw.not_your_fault, PRIORITY);
        mSong7 = mSoundPool.load(getApplicationContext(), R.raw.sail, PRIORITY);
        mSong8 = mSoundPool.load(getApplicationContext(), R.raw.woman_woman, PRIORITY);
    }

    private void playSong(int songId) {
        mSoundPool.play(songId, LEFT_VOLUME, RIGHT_VOLUME, PRIORITY, NO_LOOP, NORMAL_PLAY_RATE);
        currentSongId = songId;
    }

}
