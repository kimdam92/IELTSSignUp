package com.example.ieltssignup;

import androidx.appcompat.app.AppCompatActivity;

import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.MediaController;
import android.widget.VideoView;

public class IELTS_TestList extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ielts__test_list);

        // Video loading from the resources
        VideoView tutorial = findViewById(R.id.tutorial);
        MediaController controller = new MediaController(this);
        tutorial.setMediaController(controller);

        tutorial.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.wario_laughing));
        tutorial.start();
    }

    public void OnYoutubePlugin(View view) {
    }
}
