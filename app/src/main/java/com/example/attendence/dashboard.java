package com.example.attendence;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class dashboard extends AppCompatActivity {
          EditText name,email,contact;
        String  Name,Email,Contact;
          Button btn_show;
          TextView Profile;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );
        setContentView( R.layout.activity_dashboard );


        name = findViewById( R.id.ett_name);
        email = findViewById( R.id.ett_email );
        contact = findViewById( R.id.ett_contact );
        btn_show = findViewById( R.id.btn_show);
        Profile = findViewById( R.id.profile);

        Intent intent = getIntent();
         Name = intent.getStringExtra( "name" );
         Email = intent.getStringExtra( "email" );
         Contact = intent.getStringExtra( "contact" );

        name.setText(Name );
        email.setText(Email );
        contact.setText( Contact );
        Profile.setText( Name );

        btn_show.setOnClickListener( new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                String nameInput = name.getText().toString();
//                String emailInput = email.getText().toString();
//                String contactInput = contact.getText().toString();

                startActivity( new Intent(dashboard.this, Detail.class) );


            }
        } );



    }


    public void update(View view) {
        startActivity( new Intent(dashboard.this,UpdateDetail.class) );
    }

    public void markAttendance(View view) {
        startActivity( new Intent(dashboard.this,Attendance.class) );
    }
}



