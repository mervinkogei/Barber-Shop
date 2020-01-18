package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.barbershop.Models.NameDetail;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {
    private static final String TAG = "ProfileActivity";

    @BindView(R.id.edt_address)
    TextView edt_address;
    @BindView(R.id.edt_name) TextView edt_name;
    @BindView(R.id.update)
    Button btnUpdate;

    FirebaseAuth mAuth;
    DatabaseReference databaseReference;

    private FirebaseFirestore db;
    private CollectionReference nameRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_information);

        ButterKnife.bind(this);
        db = FirebaseFirestore.getInstance();

        mAuth = FirebaseAuth.getInstance();
        FirebaseUser user = mAuth.getCurrentUser();
        String uid = user.getUid();
//        databaseReference = FirebaseDatabase.getInstance().getReference("USERDATA").child(uid);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUserData();
                Toast.makeText(ProfileActivity.this, "You have Successfully Updated Information", Toast.LENGTH_SHORT).show();

            }
        });
    }

    private void updateUserData() {
        String name = edt_name.getText().toString().trim();
        String address =edt_address.getText().toString().trim();
/*
        String id = databaseReference.push().getKey();
        NameDetail nameDetail = new NameDetail(name, address);
        databaseReference.child(id).setValue(nameDetail);*/

        db.collection("USERDATA")
                .add(new NameDetail(name, address))
                .addOnSuccessListener(new OnSuccessListener<DocumentReference>() {
                    @Override
                    public void onSuccess(DocumentReference documentReference) {
                        Log.d(TAG, "-------success-------");
                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                Log.d(TAG, "-------failure------");
            }
        });

    }

}

