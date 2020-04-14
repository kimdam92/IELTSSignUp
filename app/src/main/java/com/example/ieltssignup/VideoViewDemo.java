package com.example.ieltssignup;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

public class VideoViewDemo extends AppCompatActivity {

    VideoView sample;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video_view_demo);
        // Video loading from the resources
        sample = findViewById(R.id.samplevideo);

        MediaController controller = new MediaController(this);
        sample.setMediaController(controller);

        sample.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wario_laughing));
        sample.start();
    }
}
