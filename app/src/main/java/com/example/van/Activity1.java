package com.example.van;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Locale;

public class Activity1 extends AppCompatActivity {
    EditText t2;
    ImageView imageView;
    DatabaseHelper databaseHelper;
    TextToSpeech textToSpeech;
    Button txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity1);

        databaseHelper = new DatabaseHelper(this);

        String[] retrievedData = databaseHelper.getTextAndImageName(2);
        String retrievedText = retrievedData[0];
        String retrievedImageName = retrievedData[1];

        t2 = findViewById(R.id.editTextTextMultiLine);
        imageView = findViewById(R.id.imageView);
        txt1 = findViewById(R.id.txt1);
        t2.setText(retrievedText);

        int imageResId = getResources().getIdentifier(retrievedImageName, "drawable", getPackageName());
        if (imageResId != 0) {
            imageView.setImageResource(imageResId);
        }

        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setLanguage(Locale.getDefault());
            }
        });

        txt1.setOnClickListener(v -> {
            String textToRead = t2.getText().toString();
            textToSpeech.speak(textToRead, TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
