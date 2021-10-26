package com.example.lr;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class welcomepage extends AppCompatActivity {
    Button clk;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcomepage);

        //getSupportActionBar().hide();

        Thread thread = new Thread(){
            public void run()
            {
                try
                {
                    sleep(1250);


                }
                catch(Exception e)
                {
                    e.printStackTrace();


                }
                finally
                {
                    Intent intent=new Intent(welcomepage.this,LoginActivity.class);
                    startActivity(intent);
                    finish();


                }
            }
        };thread.start();

    }



}