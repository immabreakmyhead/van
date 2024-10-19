package com.example.van;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Activity4 extends AppCompatActivity{
    EditText t2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activity4);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity4), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        SharedPreferences sharedPreferences = getSharedPreferences("gallery", MODE_PRIVATE);
        String retrievedText = sharedPreferences.getString("key_multiline_text", "Van Gogh's rolling night sky full of bright stars is probably one of the world's most famous artworks. "); // Default to empty string if not found


        t2 = findViewById(R.id.editTextTextMultiLine4);
        t2.setText(retrievedText);
    }
}
