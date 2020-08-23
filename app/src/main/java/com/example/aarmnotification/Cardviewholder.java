package com.example.aarmnotification;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Cardviewholder extends RecyclerView.ViewHolder {
    TextView Name,Deptclass,Date,Totalstudent,Classtime,Topic,Comment;
    public Cardviewholder(@NonNull View itemView) {
        super(itemView);
        Name=(TextView) itemView.findViewById(R.id.name);
        Deptclass=(TextView) itemView.findViewById(R.id.deptclass);
        Date=(TextView) itemView.findViewById(R.id.date);
        Totalstudent=(TextView) itemView.findViewById(R.id.totalstudent);
        Classtime=(TextView) itemView.findViewById(R.id.classtime);
        Topic=(TextView) itemView.findViewById(R.id.topic);
        Comment=(TextView) itemView.findViewById(R.id.comment);
    }
}
