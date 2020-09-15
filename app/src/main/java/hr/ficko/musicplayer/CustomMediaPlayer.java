package hr.ficko.musicplayer;

import android.content.Context;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;

import java.io.IOException;

class CustomMediaPlayer extends MediaPlayer {
    Uri uri;

    @Override
    public void setDataSource(Context context, Uri uri) {
        try {
            super.setDataSource(context, uri);
        } catch (IOException e) {
            Log.d("MusicPlayer", "IOException happened while adding data source to CustomMediaPlayer");
            e.printStackTrace();
        }

        this.uri = uri;
    }

    public Uri getDataSource() {
        return uri;
    }
}
