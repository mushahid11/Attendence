package com.example.attendence;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Detail extends AppCompatActivity {

    EditText t1,t2,t3,t4,t5,t6;
    String  t11,t22,t33,t44,t55,t66;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_detail );


        t1 = findViewById( R.id.ett_namE );
        t2 = findViewById( R.id.ett_emaiL );
        t3 = findViewById( R.id.ett_contacT );
        t4 = findViewById( R.id.ett_designation);
        t5 = findViewById( R.id.ett_Current);
        t6 = findViewById( R.id.ett_Perminent);

        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        String userid = user.getUid();

        DatabaseReference reference = FirebaseDatabase.getInstance().getReference().child( "user" ).child( userid );

        reference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                dataHolder dataHolder = dataSnapshot.getValue(dataHolder.class);

                Log.d("bcnxzmdfsdf", "User name: " + dataHolder.getCurrentAdress() + ", email " + dataHolder.getPerminentAddress());
                 Log.e( "xzcbnxcnnzx", "onComplete: "+dataHolder.getName()  );
         t11 = dataHolder.getName();
         t22 = dataHolder.getEmail();
         t33 = dataHolder.getContact();
         t44 = dataHolder.getDesignation();
         t55 = dataHolder.getCurrentAdress();
         t66 = dataHolder.getPerminentAddress();
         t1.setText( t11 );
         t2.setText( t22 );
         t3.setText( t33 );
         t4.setText( t44);
         t5.setText( t55 );
         t6.setText( t66 );
//                String title =dataSnapshot.child("user").child("name").getValue(String.class);
//                Toast.makeText( MainActivity.this, "Success", Toast.LENGTH_SHORT ).show();
//                Intent intent = new Intent(MainActivity.this,dashboard.class);
//                intent.putExtra( "name",dataHolder.getName() );
//                intent.putExtra( "email",dataHolder.getEmail());
//                intent.putExtra( "contact",dataHolder.getContact());
//                Log.e( "xzcbnxcnnzx", "onComplete: "+title  );
//                startActivity( intent );
            }

            @Override
            public void onCancelled(DatabaseError error) {
                Log.w("vncbnvz", "Failed to read value.", error.toException());
            }
        });
    }
}