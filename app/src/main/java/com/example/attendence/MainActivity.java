package com.example.attendence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.UUID;

import static java.security.AccessController.getContext;

public class MainActivity extends AppCompatActivity {

    EditText emaill, passwordd;
    String nameFromDB;

String Namee,Contactt,Emaill;
   TextView textView;
   Button login;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_main );

        emaill = findViewById( R.id.etEmail);
        passwordd = findViewById( R.id.etPwd );
        login = findViewById( R.id.btn_login);
        textView = findViewById( R.id.not_register);


        textView.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity( new Intent(MainActivity.this,Registration.class) );
            }
        } );

    }


    public void signUp(View view) {
        String Email =  emaill.getText().toString();
        String Password =  passwordd.getText().toString();


        FirebaseAuth  mAuth = FirebaseAuth.getInstance();;
        Log.e("nccvzncxz", "onComplete: "  );
        mAuth.signInWithEmailAndPassword(Email, Password)

                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String userid = user.getUid();

                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child( "user" ).child( userid );

                            reference.addValueEventListener(new ValueEventListener() {
                                @Override
                                public void onDataChange(DataSnapshot dataSnapshot) {

                                    dataHolder dataHolder = dataSnapshot.getValue(dataHolder.class);

                                    Log.d("bcnxzmdfsdf", "User name: " + dataHolder.getName() + ", email " + dataHolder.getContact());
                                   // Log.e( "xzcbnxcnnzx", "onComplete: "+dataHolder.getName()  );

                                    String title =dataSnapshot.child("user").child("name").getValue(String.class);
                                    Toast.makeText( MainActivity.this, "Success", Toast.LENGTH_SHORT ).show();
                                    Intent intent = new Intent(MainActivity.this,dashboard.class);
                                    intent.putExtra( "name",dataHolder.getName() );
                                    intent.putExtra( "email",dataHolder.getEmail());
                                    intent.putExtra( "contact",dataHolder.getContact());
                                    startActivity( intent );
                                }

                                @Override
                                public void onCancelled(DatabaseError error) {
                                    Log.w("vncbnvz", "Failed to read value.", error.toException());
                                }
                            });


                        } else {
                            // If sign in fails, display a message to the user.
                            Toast.makeText( MainActivity.this, "Failure", Toast.LENGTH_SHORT ).show();
                            Log.w("djkhkjzc", "signInWithEmail:failure", task.getException());

                        }

                        // ...
                    }
                });
}}