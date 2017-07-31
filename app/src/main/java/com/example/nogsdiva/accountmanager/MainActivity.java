package com.example.nogsdiva.accountmanager;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA_CHECK = "com.example.nogsdiva.accountmanager.CHECK";
    public final static String EXTRA_SAVE = "com.example.nogsdiva.accountmanager.SAVE";
    public final static String EXTRA_BUSS = "com.example.nogsdiva.accountmanager.BUSS";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // ca c pour le boutton checkingAccount
        Button bttn1 = (Button) findViewById(R.id.btn1);
        bttn1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
               Button c = (Button) findViewById(R.id.btn1);
                String check = c.getText().toString();
                intent.putExtra(EXTRA_CHECK, check);
                startActivity(intent);
            }

        });

        final Button bttn2 = (Button) findViewById(R.id.btn2);
        bttn2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
                Button c = (Button) findViewById(R.id.btn2);
                String save = c.getText().toString();
                intent.putExtra(EXTRA_SAVE, save);
                startActivity(intent);
            }

        });
         Button bttn3 = (Button) findViewById(R.id.btn3);
        bttn3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v3){
                // sendMessage(view);
                Intent intent = new Intent(MainActivity.this, OperationActivity.class);
              Button c = (Button) findViewById(R.id.btn3);
                String buss = c.getText().toString();
                intent.putExtra(EXTRA_BUSS, buss);
                startActivity(intent);
            }

        });

    }
}
