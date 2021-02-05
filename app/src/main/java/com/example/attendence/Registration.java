package com.example.attendence;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.common.data.DataHolder;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.OnProgressListener;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Registration extends AppCompatActivity {

    dataHolder obj;

    private FirebaseAuth mAuth;
    FirebaseStorage storage;
    StorageReference reference;
    EditText name, email, password,contact,designation,currentAddress,perminentAddress;
    Button signUp;

    String Name, Email, Password,Contact,Designation,CurrentAddress,PerminentAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_registration );

        name = findViewById( R.id.et_Name );
        email = findViewById( R.id.et_Email );
        password = findViewById( R.id.et_Password );
        contact= findViewById( R.id.phone_no);
        designation= findViewById( R.id.et_designation);
        currentAddress= findViewById( R.id.et_currentAddress);
        perminentAddress= findViewById( R.id.perminentAddresss);

        signUp = findViewById( R.id.btn_signup );
        signUp.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signUpHere();
            }
        } );

    }

    public void signUpHere() {

        Name =name.getText().toString();
        Email = email.getText().toString();
         Password = password.getText().toString();
        Contact =contact.getText().toString();
         Designation =designation.getText().toString();
         CurrentAddress =currentAddress.getText().toString();
        PerminentAddress =perminentAddress.getText().toString();

        obj = new dataHolder(Name,Email,Password,Contact,Designation,CurrentAddress,PerminentAddress);
        Log.e( "cbxznmbcn", "khaleeee "+Contact );
        mAuth = FirebaseAuth.getInstance();
        mAuth.createUserWithEmailAndPassword( Email, Password )
                .addOnCompleteListener( Registration.this, new OnCompleteListener< AuthResult >() {
                    @Override
                    public void onComplete(@NonNull Task< AuthResult > task) {
                        if (task.isSuccessful()) {

                            FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
                            String userid = user.getUid();

//

                            Log.e( "bxzbzmxb", "onComplete: "+obj );
                            Toast.makeText( Registration.this, "Register Successfull", Toast.LENGTH_SHORT ).show();
//                            Map< String, Object > map = new HashMap<>();
//                            map.put( "name", name.getText().toString() );
//                            map.put( "email", email.getText().toString() );
//                            map.put( "password", password.getText().toString() );
//                            map.put( "contact", contact.getText().toString() );
                            DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child( "user" ).child( userid );
                            reference.setValue( obj );
                        } else {
                            Toast.makeText( Registration.this, "Registeration Error", Toast.LENGTH_SHORT ).show();
                            Log.e( "cxnzdffd", "failure: " );
                        }

                        // ...
                    }
                } );
    }
}










