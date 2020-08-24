package com.example.aarmnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class MainActivity extends AppCompatActivity {
    EditText Email,Password;
    private FirebaseAuth mAuth;
    Button Login;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Email=(EditText) findViewById(R.id.emialid);
        Password=(EditText) findViewById(R.id.password);

        Login=(Button)findViewById(R.id.login);


    }
    public void open(View v)
    {
        final String email,password;
        mAuth = FirebaseAuth.getInstance();
       email=Email.getText().toString().trim();
       password=Password.getText().toString().trim();

       if(email.isEmpty()||password.isEmpty())
       {
           Toast.makeText(MainActivity.this, "Enter email and password",
                   Toast.LENGTH_SHORT).show();

       }
       else
       {


           mAuth.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {
                           if (task.isSuccessful()) {
                               // Sign in success, update UI with the signed-in user's information

                               FirebaseUser user = mAuth.getCurrentUser();
                               Intent intent=new Intent(MainActivity.this,Viewnotication.class);
                               startActivity(intent);

                           } else {
                               // If sign in fails, display a message to the user.

                               Toast.makeText(MainActivity.this, "Authentication failed.",
                                       Toast.LENGTH_SHORT).show();

                           }

                           // ...
                       }
                   });





       }




    }
}
