package com.example.barbershop.Fragments;

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
import com.example.barbershop.R;
import com.squareup.picasso.Picasso;

import org.parceler.Parcels;

import java.util.zip.Inflater;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StylistDetailFragment extends Fragment {

    @BindView(R.id.imgBarber)
    ImageView imgBarber;
    @BindView(R.id.txtBarber)
    TextView txtBarber;
    @BindView(R.id.txtComment) TextView txtComment;

    public Hit mhits;

    public static StylistDetailFragment newInstance(Hit hits) {
        StylistDetailFragment stylistDetails = new StylistDetailFragment();
        Bundle args = new Bundle();
        args.putParcelable("hits", Parcels.wrap(hits));
        stylistDetails.setArguments(args);
        return stylistDetails;

    }



    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mhits = Parcels.unwrap(getArguments().getParcelable("hits"));
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.activity_stylist_details,container,false);
        ButterKnife.bind(this,view);

        Picasso.get().load(mhits.getWebformatURL()).into(imgBarber);

        return view;
    }
}

