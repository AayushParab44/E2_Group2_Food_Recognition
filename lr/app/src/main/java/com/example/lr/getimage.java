package com.example.lr;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.io.IOException;

public class getimage extends AppCompatActivity {
    private ImageView imgView;
    private Button select;
    private Bitmap img;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_getimage);

        select = (Button) findViewById(R.id.button1);
        imgView = (ImageView) findViewById(R.id.imageView);

        select.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
                intent.setType("image/*");
                startActivityForResult(intent, 100);


            }
        });
    }
    @Override
    protected void onActivityResult( int requestCode, int resultCode, @Nullable Intent data)
    {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == 100)
        {
            imgView.setImageURI(data.getData());

            Uri uri = data.getData();
            try
            {
                img = MediaStore.Images.Media.getBitmap(this.getContentResolver(), uri);
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

}