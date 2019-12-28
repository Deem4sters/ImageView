package com.dee.imageview;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class GalleryActivity extends AppCompatActivity {
private ImageView IvGallaryImage;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode==RESULT_OK){
            if (data==null);{
                Toast.makeText(this, "Selected Image", Toast.LENGTH_SHORT).show();
            }
        }
        Uri uri = data.getData();
        IvGallaryImage.setImageURI(uri);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        IvGallaryImage = findViewById(R.id.IvGallaryImage);
        IvGallaryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            BrowseImage();
            }
        });


    }
    private void BrowseImage(){
        Intent intent = new Intent(Intent.ACTION_PICK);
        intent.setType("image/*");
        startActivityForResult(intent,0);
    }
}
