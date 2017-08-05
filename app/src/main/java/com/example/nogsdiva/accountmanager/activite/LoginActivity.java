package com.example.nogsdiva.accountmanager.activite;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.nogsdiva.accountmanager.R;

public class LoginActivity extends AppCompatActivity {
    public final static String EXTRA_CODE = "com.example.nogsdiva.accountmanager.CODE";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


        Button bt = (Button) findViewById(R.id.connect);
        bt.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v4){
                EditText et = (EditText)findViewById(R.id.code);
                String code = et.getText().toString();
                int logg = Integer.parseInt(code);
                if(logg==30){
                  Intent intent = new Intent(LoginActivity.this,MainActivity.class);
                    intent.putExtra(EXTRA_CODE, code);
                     startActivity(intent);

                }
                else
                    Toast.makeText(LoginActivity.this, "mauvais identifiant", Toast.LENGTH_SHORT).show();

   }
});

        }
    }