package com.example.van;

import android.os.Bundle;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {
    DatabaseHelper databaseHelper;
    ImageView imageViewMain;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViewMain = findViewById(R.id.imageView3);
        databaseHelper = new DatabaseHelper(this);

        String[] retrievedData = databaseHelper.getTextAndImageName(1);
        String retrievedImageName = retrievedData[1];

        int imageResId = getResources().getIdentifier(retrievedImageName, "drawable", getPackageName());
        if (imageResId != 0) {
            imageViewMain.setImageResource(imageResId);
        }

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
