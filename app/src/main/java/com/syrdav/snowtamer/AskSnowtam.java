package com.syrdav.snowtamer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AskSnowtam extends AppCompatActivity implements View.OnClickListener{

        EditText OACI1  = null;
        EditText OACI2  = null;
        EditText OACI3  = null;
        Button send = null;
        static String lien = null;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ask_snowtam);
            OACI1 = (EditText)findViewById(R.id.snt1);
            OACI2 = (EditText)findViewById(R.id.snt2);
            OACI3 = (EditText)findViewById(R.id.snt3);
            send = (Button)findViewById(R.id.send);
            send.setOnClickListener(this);
        }
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            //ajoute les entrées de menu_test à l'ActionBar
            getMenuInflater().inflate(R.menu.menu, menu);
            return true;
        }

    @Override
    public void onClick(View v) {
        Toast toast;
        boolean go = false;
        String oaci1 = OACI1.getText().toString();
        String oaci2 = OACI2.getText().toString();
        String oaci3 = OACI3.getText().toString();
        Intent versvuesnow = new Intent(this, VueSnowtam.class);
        if((!oaci1.equals(""))||(!oaci2.equals(""))||(!oaci2.equals(""))){
            if(!oaci1.equals("")){
                if(oaci1.length()!=4){
                    toast = Toast.makeText(this,getResources().getString(R.string.oacisize), Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    String url1 = "https://pilotweb.nas.faa.gov/PilotWeb/notamRetrievalByICAOAction.do?method=displayByICAOs&reportType=RAW&formatType=DOMESTIC&" +
                            "retrieveLocId=" +oaci1+
                            "&actionType=notamRetrievalByICAOs";
                    versvuesnow.putExtra("lien1",url1);
                    versvuesnow.putExtra("OACI1",oaci1);
                    go = true;
                }
            }
            if(!oaci2.equals("")){
                if(oaci2.length()!=4){
                    toast = Toast.makeText(this,getResources().getString(R.string.oacisize), Toast.LENGTH_SHORT);
                    toast.show();
                }else{

                    String url2 = "https://pilotweb.nas.faa.gov/PilotWeb/notamRetrievalByICAOAction.do?method=displayByICAOs&reportType=RAW&formatType=DOMESTIC&" +
                            "retrieveLocId=" +oaci2+
                            "&actionType=notamRetrievalByICAOs";
                    versvuesnow.putExtra("lien2",url2);
                    versvuesnow.putExtra("OACI2",oaci2);
                    go = true;
                }
            }
            if(!oaci3.equals("")){
                if(oaci3.length()!=4){
                    toast = Toast.makeText(this,getResources().getString(R.string.oacisize), Toast.LENGTH_SHORT);
                    toast.show();
                }else{
                    String url3 = "https://pilotweb.nas.faa.gov/PilotWeb/notamRetrievalByICAOAction.do?method=displayByICAOs&reportType=RAW&formatType=DOMESTIC&" +
                            "retrieveLocId=" +oaci3+
                            "&actionType=notamRetrievalByICAOs";
                    versvuesnow.putExtra("lien3",url3);
                    versvuesnow.putExtra("OACI3",oaci3);
                    go = true;
                }
            }
            if(go){
                startActivity(versvuesnow);
            }


        }else{
            toast = Toast.makeText(this,getResources().getString(R.string.pleaseoaci), Toast.LENGTH_SHORT);
            toast.show();
        }



    }
}
