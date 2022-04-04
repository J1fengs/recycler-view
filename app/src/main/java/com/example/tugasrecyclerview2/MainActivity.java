package com.example.tugasrecyclerview2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements RecyclerViewInterface{
    ArrayList<ViewModel> viewModels = new ArrayList<>();
    MyAdapter adapter;

    int images[] = {R.drawable.windows,R.drawable.linux,R.drawable.ubuntu, R.drawable.chess,
    R.drawable.android,R.drawable.minecraft};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.recyclerview);

        setUpViewModel();
        adapter = new MyAdapter(this, viewModels, this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
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
}
