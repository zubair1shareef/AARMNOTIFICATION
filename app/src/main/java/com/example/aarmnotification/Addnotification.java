package com.example.aarmnotification;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.text.SimpleDateFormat;
import java.util.Date;

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

        //date
        java.util.Date today = new Date();
        SimpleDateFormat format = new SimpleDateFormat("yy-MM-dd hh:mm:ss a");
        String dateToStr = format.format(today);
        //
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();

        Name=user.getDisplayName();
        Dept=deptclass.getText().toString();
        Totalstduent=totalstudent.getText().toString();
        Date=dateToStr;
        Classtime=classtime.getText().toString();
        Topic=topic.getText().toString();
        Comment=comment.getText().toString();
        Toast.makeText(Addnotification.this, Dept, Toast.LENGTH_SHORT).show();
        Data_adapter data=new Data_adapter(Name,Dept,Date,Totalstduent,Classtime,Topic,Comment);
        String key = myRef.push().getKey();
        myRef.child(key).setValue(data);

        Intent intentt=new Intent(Addnotification.this,Viewnotication.class);
        startActivity(intentt);
    }

}
