package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UpdateDetail extends AppCompatActivity {

    EditText t1, t2, t3, t4, t5, t6;
    String t11, t22, t33, t44, t55, t66;
    Button button_update;
    DatabaseReference reference;
    String userid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_update_detail );
        button_update = findViewById( R.id.buttun_update );
        t1 = findViewById( R.id.ett_namE );
        t2 = findViewById( R.id.ett_emaiL );
        t3 = findViewById( R.id.ett_contacT );
        t4 = findViewById( R.id.ett_designation );
        t5 = findViewById( R.id.ett_Current );
        t6 = findViewById( R.id.ett_Perminent );

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        userid = user.getUid();

        reference = FirebaseDatabase.getInstance().getReference().child( "user" ).child( userid );

        reference.addValueEventListener( new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataHolder dataHolder = dataSnapshot.getValue( dataHolder.class );

                Log.d( "bcnxzmdfsdf", "User name: " + dataHolder.getCurrentAdress() + ", email " + dataHolder.getPerminentAddress() );
                Log.e( "xzcbnxcnnzx", "onComplete: " + dataHolder.getName() );
                t11 = dataHolder.getName();
                t22 = dataHolder.getEmail();
                t33 = dataHolder.getContact();
                t44 = dataHolder.getDesignation();
                t55 = dataHolder.getCurrentAdress();
                t66 = dataHolder.getPerminentAddress();
                t1.setText( t11 );
                t2.setText( t22 );
                t3.setText( t33 );
                t4.setText( t44 );
                t5.setText( t55 );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w( "vncbnvz", "Failed to read value.", error.toException() );
            }
        } );
        button_update.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateData();
            }
        } );

    }


    public void updateData() {

        FirebaseUser userr = FirebaseAuth.getInstance().getCurrentUser();
       String userid = userr.getUid();

      DatabaseReference  referencee = FirebaseDatabase.getInstance().getReference("user");

        referencee.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

               //dataHolder dataHolder = dataSnapshot.setV(dataHolder.class);
                String N,E,C,D,Cu,P;
                N = t1.getText().toString();
                E = t2.getText().toString();
                C= t3.getText().toString();
                D = t4.getText().toString();
                Cu = t5.getText().toString();
                P = t6.getText().toString();



                Toast.makeText( UpdateDetail.this, "Data Upload", Toast.LENGTH_SHORT ).show();

                referencee.child( userid ).child("name").setValue( N );
                referencee.child( userid ).child("email").setValue( E );
                referencee.child( userid ).child("contact").setValue( C);
                referencee.child( userid ).child("designation").setValue( D );
                referencee.child( userid ).child("currentAdress").setValue( Cu );
                referencee.child( userid ).child("perminentAddress").setValue( P );


            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("vncbnvz", "Failed to read value.", error.toException());
            }
        });

    }
}