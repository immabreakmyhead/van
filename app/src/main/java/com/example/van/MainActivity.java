package com.example.van;

import android.os.Bundle;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.view.View;
import android.content.Intent;
import android.content.SharedPreferences;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        SharedPreferences sharedPreferences = getSharedPreferences("gallery", MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("key1", "Van Gogh hoped that a large work featuring several people would help prove himself to the outside world. Paintings of peasants having their daily meal were popular at that time. He practiced for months painting heads, and many studies preceded the Potato Eaters. He was satisfied with the result but his brother Theo and his artist friend Anthon van Rappard were very critical of his work. ");
        editor.putString("key2", "Vincent spent the final, highly productive months of his life in Auvers-sur-Oise, where he committed suicide.");
        editor.putString("key3", "Bridges across the Seine at Asnières was painted in open air. The light yellow of the embankment and the bridge walls shows the effect of bright sunlight.");
        editor.putString("key4", "Van Gogh's rolling night sky full of bright stars is probably one of the world's most famous artworks.");
        editor.apply();
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void go1(View view) {
    Intent intent = new Intent(MainActivity.this, Activity1.class);
    startActivity(intent);
    }
    public void go2(View view) {
        Intent intent = new Intent(MainActivity.this, Activity2.class);
        startActivity(intent);
    }
    public void go3(View view) {
        Intent intent = new Intent(MainActivity.this, Activity3.class);
        startActivity(intent);
    }
    public void go4(View view) {
        Intent intent = new Intent(MainActivity.this, Activity4.class);
        startActivity(intent);
    }
}