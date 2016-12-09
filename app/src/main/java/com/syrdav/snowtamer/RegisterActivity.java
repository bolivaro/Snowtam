package com.syrdav.snowtamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener{
    EditText emailreg;
    EditText firstpsw;
    EditText secondpsw;
    Button signup;
    DatabaseHandler db;
    User user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        emailreg = (EditText)findViewById(R.id.emailreg);
        firstpsw = (EditText)findViewById(R.id.firstpsw);
        secondpsw = (EditText)findViewById(R.id.secondpsw);
        signup = (Button)findViewById(R.id.signupButton);
        signup.setOnClickListener(this);
        db = new DatabaseHandler(this);

    }

    @Override
    public void onClick(View v) {
        String mail = emailreg.getText().toString();
        String mdp1 = firstpsw.getText().toString();
        String mdp2 = secondpsw.getText().toString();
        user = db.getUser(mail);
        if(user!=null){
            Toast toast = Toast.makeText(this,getResources().getString(R.string.alreadyaccount), Toast.LENGTH_SHORT);
            toast.show();
        }else{
            user = new User(mail,mdp1);
            db.addUser(user);
            Toast toast = Toast.makeText(this,getResources().getString(R.string.accountcreated), Toast.LENGTH_SHORT);
            toast.show();
        }

    }
}
