package com.example.lr;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.FileProvider;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Camera extends AppCompatActivity {

    String currentImagePath =  null;
    private static final int IMAGE_REQUEST = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camera);
    }

    public void location(View view){
        Intent intent =  new Intent(this,MapsActivity.class);
        startActivity(intent);


    }

    public void displayImage(View view) {
        Intent intent =  new Intent(this,getimage.class);
        intent.putExtra("image_path",currentImagePath);
        startActivity(intent);
    }

    public void captureImage(View view) {
        Intent cameraIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(cameraIntent.resolveActivity(getPackageManager())!=null)
        {
            File imageFile = null;
            try {
                imageFile = getImageFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
            if(imageFile!=null)
            {
                Uri imageUri = FileProvider.getUriForFile(this,"${applicationId}.provider",imageFile);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT,imageUri);
                startActivityForResult(cameraIntent,IMAGE_REQUEST);
            }
        }
    }


    private File getImageFile() throws IOException
    {
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        String imageName = "jpg_" +timeStamp+ "_";
        File storageDir = getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        File imageFile = File.createTempFile(imageName, ".jpg",storageDir);
        currentImagePath = imageFile.getAbsolutePath();
        return imageFile;

    }

    public void predictfood(View view) {
        Toast.makeText(this, "Lets predict the food item!", Toast.LENGTH_SHORT).show();
        gotoUrl("https://www.logmeal.es/api/demo/");
    }

    private void gotoUrl(String s) {
        Uri uri=Uri.parse(s);
        startActivity(new Intent(Intent.ACTION_VIEW,uri));
    }

    public void captureImage2(View view) {
        Intent intent=new Intent(this,captimg.class);
        startActivity(intent);
    }
}