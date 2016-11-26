package com.syrdav.snowtamer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;

public class AskSnowtam extends AppCompatActivity {


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ask_snowtam);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            //ajoute les entrées de menu_test à l'ActionBar
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }
}
