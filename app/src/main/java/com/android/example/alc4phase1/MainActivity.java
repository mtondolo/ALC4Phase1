package com.android.example.alc4phase1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find the reference for About ALC Button
        Button aboutALCButton = findViewById(R.id.tv_about_alc);

        // Click on About ALC Button
        aboutALCButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Url for our web page to be opened
                String url = "https://andela.com/alc/";
                openWebPage(url);
            }
        });
    }

    // Method to open our web page
    public void openWebPage(String url) {
        Context context = this;

        // Launch the AboutALCActivity using an Intent
        Class destinationClass = AboutALC.class;
        Intent intentToStartAboutALCActivity = new Intent(context, destinationClass);
        intentToStartAboutALCActivity.putExtra(Intent.EXTRA_TEXT, url);
        startActivity(intentToStartAboutALCActivity);
    }
}
