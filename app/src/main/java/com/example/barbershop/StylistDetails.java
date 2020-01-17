package com.example.barbershop;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.barbershop.Models.Hit;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StylistDetails extends AppCompatActivity {

    private Hit mhit;


    @BindView(R.id.imgBarber)
    ImageView imgBarber;
    @BindView(R.id.txtBarber)
    TextView txtBarber;
    @BindView(R.id.txtComment) TextView txtComment;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stylist_details);
        ButterKnife.bind(this);


        mhit = Parcels.unwrap(getIntent().getParcelableExtra("hits"));
        txtComment.setText(String.valueOf(mhit.getComments()));
        txtBarber.setText("Tags:" + mhit.getTags());
        Picasso.get().load(mhit.getWebformatURL()).into(imgBarber);

    }


}

