package com.example.aarmnotification;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Newuser extends AppCompatActivity {
    EditText name,emailid,employid,password,repassword,dept;
    private FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_newuser);
        name=(EditText) findViewById(R.id.name_us);
        emailid=(EditText) findViewById(R.id.email_us);
        employid=(EditText) findViewById(R.id.idno_us);
        dept=(EditText) findViewById(R.id.dept_us);
        password=(EditText) findViewById(R.id.passwor1_us);
        repassword=(EditText) findViewById(R.id.passwor2_us);
    }

    public void create(View v)
    {  mAuth = FirebaseAuth.getInstance();
        final String Name,Email,Epid,Dept,Pass1,Pass2;
        Name=name.getText().toString();
        Email=emailid.getText().toString();
        Epid=employid.getText().toString();
        Dept=dept.getText().toString();
        Pass1=password.getText().toString();
        Pass2=repassword.getText().toString();


        if (Name.isEmpty()||Email.isEmpty()||Epid.isEmpty()||Dept.isEmpty()||Pass1.isEmpty()||Pass2.isEmpty())
        { Toast.makeText(Newuser.this, "Please fill all the details",
                Toast.LENGTH_SHORT).show();



        }
        else if (!Pass1.equals(Pass2))
        {
            Toast.makeText(Newuser.this, "the password doent match",
                    Toast.LENGTH_SHORT).show();

        }
      else
        {final ProgressDialog progDailog = ProgressDialog.show(this,
                "Creating account",
                "....please wait....", true);
            mAuth.createUserWithEmailAndPassword(Email, Pass1)
                    .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            if (task.isSuccessful()) {
                                // Sign in success, update UI with the signed-in user's information

                                FirebaseDatabase database = FirebaseDatabase.getInstance();
                                DatabaseReference myRef = database.getReference("Users");
                                Newuser_data data1=new Newuser_data(Name,Email,Epid,Dept);
                                String key = myRef.push().getKey();
                                myRef.child(key).setValue(data1);
                                FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                                user.sendEmailVerification();
                                UserProfileChangeRequest profileUpdates = new UserProfileChangeRequest.Builder().setDisplayName(Name).build();
                                user.updateProfile(profileUpdates);

                                Toast.makeText(Newuser.this, "verification link sended to your email",
                                        Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(Newuser.this,MainActivity.class);
                                startActivity(intent);
                                progDailog.dismiss();


                            } else {
                                // If sign in fails, display a message to the user.
                                progDailog.dismiss();
                                Toast.makeText(Newuser.this, "Authentication failed.",
                                        Toast.LENGTH_SHORT).show();

                            }

                            // ...
                        }
                    });


        }





    }
}
