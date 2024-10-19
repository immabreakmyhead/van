package com.example.van;


import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;


public class Activity1 extends AppCompatActivity {
    EditText t2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_activity1);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity1), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;

        });


        SharedPreferences sharedPreferences = getSharedPreferences("gallery", MODE_PRIVATE);
        String retrievedText = sharedPreferences.getString("key_multiline_text", "Van Gogh hoped that a large work featuring several people would help prove himself to the outside world. Paintings of peasants having their daily meal were popular at that time. He practiced for months painting heads, and many studies preceded the Potato Eaters. He was satisfied with the result but his brother Theo and his artist friend Anthon van Rappard were very critical of his work. "); // Default to empty string if not found

        t2 = findViewById(R.id.editTextTextMultiLine);
        t2.setText(retrievedText);

    }





}
