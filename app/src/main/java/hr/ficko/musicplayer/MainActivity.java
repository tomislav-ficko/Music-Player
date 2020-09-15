package hr.ficko.musicplayer;

import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private CustomMediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("MusicPlayer", "Entered onCreate");

        TextView song1 = findViewById(R.id.song1_text_view);
        song1.setOnClickListener(this);
        TextView song2 = findViewById(R.id.song2_text_view);
        song2.setOnClickListener(this);
        TextView song3 = findViewById(R.id.song3_text_view);
        song3.setOnClickListener(this);
        TextView song4 = findViewById(R.id.song4_text_view);
        song4.setOnClickListener(this);
        TextView song5 = findViewById(R.id.song5_text_view);
        song5.setOnClickListener(this);
        TextView song6 = findViewById(R.id.song6_text_view);
        song6.setOnClickListener(this);
        TextView song7 = findViewById(R.id.song7_text_view);
        song7.setOnClickListener(this);
        TextView song8 = findViewById(R.id.song8_text_view);
        song8.setOnClickListener(this);
    }

    public void playButton(View view) {
        if (!mMediaPlayer.isPlaying()) {
            mMediaPlayer.start();
        }
    }

    public void pauseButton(View view) {
        mMediaPlayer.pause();
    }

    // When any of the songs are clicked, this method is executed
    @Override
    public void onClick(View v) {
        if (mMediaPlayer != null) {
            mMediaPlayer.release();
        }

        // The uri could also have been declared as a member variable and used to store the uri of the currently playing song.
        // This would have eliminated the need to create the CustomMediaPlayer class and the code would be simpler, but I wanted to play around.
        Uri resourceUri = null;
        mMediaPlayer = new CustomMediaPlayer();

        switch (v.getId()) {
            case R.id.song1_text_view:
                resourceUri = createUri(R.raw.all_i_need);
                break;
            case R.id.song2_text_view:
                resourceUri = createUri(R.raw.headrest_for_my_soul);
                break;
            case R.id.song3_text_view:
                resourceUri = createUri(R.raw.i_am);
                break;
            case R.id.song4_text_view:
                resourceUri = createUri(R.raw.jailbreak);
                break;
            case R.id.song5_text_view:
                resourceUri = createUri(R.raw.kill_your_heroes);
                break;
            case R.id.song6_text_view:
                resourceUri = createUri(R.raw.not_your_fault);
                break;
            case R.id.song7_text_view:
                resourceUri = createUri(R.raw.sail);
                break;
            case R.id.song8_text_view:
                resourceUri = createUri(R.raw.woman_woman);
                break;
        }
        Log.d("MusicPlayer", "resource Uri: " + resourceUri);
        mMediaPlayer.setDataSource(getApplicationContext(), resourceUri);

        try {
            mMediaPlayer.prepare();
        } catch (IOException e) {
            Log.d("MusicPlayer", "IOException happened while preparing MediaPlayer");
            e.printStackTrace();
        }

        mMediaPlayer.start();
    }

    private Uri createUri(int resid) {
        return Uri.parse("android.resource://" + this.getPackageName() + "/" + resid);
    }


    @Override
    protected void onPause() {
        super.onPause();

        Log.d("MusicPlayer", "Entered onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();

        Log.d("MusicPlayer", "Entered onStop");
        mMediaPlayer.stop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        mMediaPlayer.release();
    }

    @Override
    protected void onStart() {
        super.onStart();

        Log.d("MusicPlayer", "Entered onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();

        Log.d("MusicPlayer", "Entered onResume");
    }


    // Called after onPause()
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        int position = mMediaPlayer.getCurrentPosition();
        outState.putInt("position", position);
        Uri uri = mMediaPlayer.getDataSource();
        outState.putString("uri", uri.toString());

        Log.d("MusicPlayer", "Entered onSaveInstanceState:");
        Log.d("MusicPlayer", "uri is " + uri);
        Log.d("MusicPlayer", "position is " + position);
    }

    // TODO This method is currently not called after onStart for some reason (even after going to the homescreen on the device).
    // TODO Because of this, songs don't continue to play at their previous positions.
    // Called after onStart()
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Uri resourceUri = Uri.parse(savedInstanceState.getString("uri"));
        int position = savedInstanceState.getInt("position");

        Log.d("MusicPlayer", "Entered onRestoreInstanceState:");
        Log.d("MusicPlayer", "uri is " + resourceUri);
        Log.d("MusicPlayer", "position is " + position);

        mMediaPlayer = new CustomMediaPlayer();
        mMediaPlayer.setDataSource(getApplicationContext(), resourceUri);
        mMediaPlayer.seekTo(position);
        mMediaPlayer.start();
    }
}
