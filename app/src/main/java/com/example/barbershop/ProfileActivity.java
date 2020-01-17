package com.example.barbershop;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProfileActivity extends AppCompatActivity {

    @BindView(R.id.edt_name)
    TextView edt_name;
    @BindView(R.id.edt_address) TextView edt_address;
    @BindView(R.id.btn_update)
    Button btn_update;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_update_information);
        ButterKnife.bind(this);


    }

    @OnClick(R.id.btn_update)
    public void onViewClicked(){

    }
}

