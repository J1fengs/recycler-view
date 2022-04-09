package com.example.tugasrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        String title = getIntent().getStringExtra("TITLE");
        int images2 = getIntent().getIntExtra("IMAGE", 0);

        TextView mTitle= findViewById(R.id.textViewTitleMenu2);
        ImageView mImage = findViewById(R.id.imageViewMenu2);

        mTitle.setText(title);
        mImage.setImageResource(images2);
    }
}