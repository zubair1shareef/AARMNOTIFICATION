package com.example.aarmnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Viewnotication extends AppCompatActivity {
    DatabaseReference ref;
    private FirebaseRecyclerOptions<model> option;
    private FirebaseRecyclerAdapter<model,Cardviewholder> adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewnotication);
        recyclerView=findViewById(R.id.recylerview1);
        recyclerView.setHasFixedSize(true);
        ref= FirebaseDatabase.getInstance().getReference().child("Class");
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        option=new FirebaseRecyclerOptions.Builder<model>().setQuery(ref,model.class).build();
        adapter=new FirebaseRecyclerAdapter<model, Cardviewholder>(option) {
            @Override
            protected void onBindViewHolder(@NonNull Cardviewholder cardviewholder, int i, @NonNull model model) {
                cardviewholder.Name.setText(model.getName());
                cardviewholder.Comment.setText(model.getComment());
                cardviewholder.Topic.setText(model.getTopic());
                cardviewholder.Classtime.setText(model.getClasstime());
                cardviewholder.Totalstudent.setText(model.getTotalstudent());
                cardviewholder.Deptclass.setText(model.getDeptclass());
                cardviewholder.Date.setText(model.getDate());


            }

            @NonNull
            @Override
            public Cardviewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View v  =  LayoutInflater.from(parent.getContext()).inflate(R.layout.cardviewlayout,parent,false);
                return new Cardviewholder(v);
            }
        };
        adapter.startListening();
        recyclerView.setAdapter(adapter);
    }
}
