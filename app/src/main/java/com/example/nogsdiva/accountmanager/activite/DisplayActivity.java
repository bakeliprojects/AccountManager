package com.example.nogsdiva.accountmanager.activite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.nogsdiva.accountmanager.R;

public class DisplayActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);


        Intent intcheck = getIntent();
        String mess = intcheck.getStringExtra(VersementActivity.EXTRA_MESSAGEV);

        Intent intc = getIntent();
        String mesr = intc.getStringExtra(RetraitActivity.EXTRA_MESSAGER);
                      //pour virement
        Intent in = getIntent();
        String me = in.getStringExtra(VirementActivity.EXTRA_MESSAGEM1);

      //  Intent in2 = getIntent();
       // String me2 = in2.getStringExtra(VirementActivity.EXTRA_MESSAGEM2);

        if(mess!=null){
            TextView textView = (TextView) findViewById(R.id.result1);
            textView.setText(mess);
        }

           else if(mesr!=null){
            TextView text = (TextView) findViewById(R.id.result1);
            text.setText(mesr);}

        else if(me!=null ){

            TextView text = (TextView) findViewById(R.id.result1);
            text.setText(me);

          //  TextView tex = (TextView) findViewById(R.id.result2);
          //  tex.setText(me2);
        }


    }
}
