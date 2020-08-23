package com.example.aarmnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Addnotification extends AppCompatActivity {
    EditText deptclass,totalstudent,classtime,topic,comment;
    String Name,Dept,Date,Totalstduent,Classtime,Topic,Comment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addnotification);
        deptclass=(EditText) findViewById(R.id.dept_class);
        totalstudent=(EditText) findViewById(R.id.total_student);
        classtime=(EditText) findViewById(R.id.class_time);
        topic=(EditText) findViewById(R.id.subject_topic);
        comment=(EditText) findViewById(R.id.comment_);
    }
    public void submit(View v)
    {    FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference("Class");

        Name="name here";
        Dept=deptclass.getText().toString();
        Totalstduent=totalstudent.getText().toString();
        Date="datehere";
        Classtime=classtime.getText().toString();
        Topic=topic.getText().toString();
        Comment=comment.getText().toString();
        Toast.makeText(Addnotification.this, Dept, Toast.LENGTH_SHORT).show();
        Data_adapter data=new Data_adapter(Name,Dept,Date,Totalstduent,Classtime,Topic,Comment);
        String key = myRef.push().getKey();
        myRef.child(key).setValue(data);
    }
}
