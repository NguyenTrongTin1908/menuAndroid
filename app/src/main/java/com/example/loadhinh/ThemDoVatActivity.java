package com.example.loadhinh;

import android.content.Intent;
import android.graphics.Bitmap;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.provider.MediaStore;
import android.text.TextPaint;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class ThemDoVatActivity extends AppCompatActivity {


    EditText   plainTen,plainMoTa;
    ImageButton imgbtFolder , imgbtCamera;
    ImageView   imgView;
    int REQUEST_CODE_CAMERA=123;
    int REQUEST_CODE_FOLDER;


    protected  void onCreate (Bundle savedInstanceState){
        
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_them_do_vat);

        imgbtCamera  = (ImageButton) findViewById(R.id.imgbuttonCamera);
        imgbtFolder =(ImageButton)  findViewById(R.id.imgbuttonFolder);
        imgView     =(ImageView)    findViewById(R.id.imageView);
        plainTen    =(EditText)     findViewById(R.id.plainTen);
        plainMoTa   =(EditText)     findViewById(R.id.plaintMoTa);

        imgbtCamera.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,REQUEST_CODE_CAMERA);


            }
        });





    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable @org.jetbrains.annotations.Nullable Intent data) {
        if(requestCode==REQUEST_CODE_CAMERA && resultCode == RESULT_OK && data !=null){
            super.onActivityResult(requestCode, resultCode, data);
            Bitmap bitmap = (Bitmap) data.getExtras().get("data");
            imgView.setImageBitmap(bitmap);

        }
    }
}
