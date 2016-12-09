package com.syrdav.snowtamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Connexion extends AppCompatActivity implements View.OnClickListener {
    EditText email = null;
    EditText password = null;
    Button connexion = null;
    Button register = null;
    DatabaseHandler db;
    User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_connexion);

        db = new DatabaseHandler(this);
        email = (EditText)findViewById(R.id.email) ;
        password = (EditText)findViewById(R.id.password);
        connexion =(Button)findViewById(R.id.connectButton);
        connexion.setOnClickListener(this);
        register = (Button)findViewById(R.id.registButton);
        register.setOnClickListener(this);
        /**
         * CRUD Operations
         * */
        // Inserting Contacts
        Log.d("Insert: ", "Inserting ..");
        //db.addUser(new User("Ravi", "9100000000"));



    }

    @Override
    public void onClick(View v) {
        String mail = email.getText().toString();
        String psw = password.getText().toString();
        switch(v.getId()) {

            // Si l'identifiant de la vue est celui du premier bouton
            case R.id.connectButton:
                if((mail.equals("")||(psw.equals("")))){
                    Toast toast = Toast.makeText(this,"You have to enter email and password", Toast.LENGTH_SHORT);
                    toast.show();
                }
                else{
                    user = new User(mail,psw);
                    user = db.getUser(mail);
                    if(user!=null){
                        Intent versAsk = new Intent(this, AskSnowtam.class);
                        startActivity(versAsk);
                    }else{
                        Toast toast = Toast.makeText(this,"incorrect email or password", Toast.LENGTH_SHORT);
                        toast.show();
                    }

                }
    /* Agir pour bouton 1 */
                break;

            // Si l'identifiant de la vue est celui du deuxième bouton
            case R.id.registButton:
                Intent versAsk = new Intent(this, RegisterActivity.class);
                startActivity(versAsk);

    /* Agir pour bouton 2 */
                break;

    /* etc. */
        }


    }
}
