package com.example.barbershop;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewStyleActivity extends AppCompatActivity {

    private final static int CAMERA_REQUEST_CODE = 1;
    private StorageReference mstorage;
    private ProgressDialog mProgress;

    @BindView(R.id.upload)
    Button upload;
    @BindView(R.id.image_upload)
    ImageView image_upload;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_style);
        ButterKnife.bind(this);

        mstorage = FirebaseStorage.getInstance().getReference();

        mProgress = new ProgressDialog(this);

        upload.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(intent,CAMERA_REQUEST_CODE);

            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == CAMERA_REQUEST_CODE && requestCode == RESULT_OK){
            mProgress.setMessage("Uploading Image");
            mProgress.show();

            Uri uri = data.getData();
            StorageReference filepath = mstorage.child("photos").child(uri.getLastPathSegment());
            filepath.putFile(uri).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
                @Override
                public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
                    mProgress.dismiss();
                    Toast.makeText(NewStyleActivity.this,"Uploading Successful.....",Toast.LENGTH_SHORT).show();
                }
            });
        }
    }
}
