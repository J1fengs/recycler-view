package com.example.tugasrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<ViewModel> viewModels = new ArrayList<>();
    MyAdapter adapter;
    Button add;

    int images[] = {R.drawable.windows,R.drawable.linux,R.drawable.ubuntu, R.drawable.chess,
    R.drawable.android,R.drawable.minecraft};
    int imagesTambahan [] = {R.drawable.elden_ring, R.drawable.twitter, R.drawable.whatsapp};



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        setUpViewModel();
        adapter = new MyAdapter(this, viewModels, this);

        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        add = findViewById(R.id.buttonAdd);

        add.setOnClickListener(new View.OnClickListener() {
            int counter = 0;
            @Override
            public void onClick(View view) {
                String[] viewName = getResources().getStringArray(R.array.applicationTambahan);
                viewModels.add(new ViewModel(viewName[counter], imagesTambahan[counter]));
                counter++;

            }

        });
    }

    private void setUpViewModel(){
        String[] viewName = getResources().getStringArray(R.array.application);

        for(int i = 0; i < viewName.length; i++){
            viewModels.add(new ViewModel(viewName[i], images[i]));
        }
    }

    @Override
    public void onItemClick(int position) {
        viewModels.remove(position);
        adapter.notifyItemRemoved(position);
    }

    @Override
    public void onItemLongClick(int position) {
        Intent intent = new Intent(MainActivity.this, MainActivity2.class);

        intent.putExtra("TITLE", viewModels.get(position).getNama());
        intent.putExtra("IMAGE", viewModels.get(position).getImage());

        startActivity(intent);


    }

}
