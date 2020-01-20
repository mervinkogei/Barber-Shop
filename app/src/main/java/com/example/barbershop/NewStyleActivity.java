package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Base64;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.squareup.picasso.Picasso;

import java.io.ByteArrayOutputStream;
import java.util.UUID;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewStyleActivity extends AppCompatActivity {

    private final static int CAMERA_REQUEST_CODE = 111;

    private FirebaseStorage storage;
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

        Bitmap bitmap = (Bitmap)data.getExtras().get("data");
        image_upload.setImageBitmap(bitmap);
    }

}
