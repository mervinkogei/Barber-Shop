package com.example.barbershop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershop.Models.NameDetail;
import com.example.barbershop.R;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ProfileUpdateAdapter extends RecyclerView.Adapter<ProfileUpdateAdapter.NameDetailHolder> {

    Context context;
    ArrayList<NameDetail> nameDetails;

    public ProfileUpdateAdapter(Context context, ArrayList<NameDetail> nameDetails) {
        this.context = context;
        this.nameDetails = nameDetails;
    }

    @NonNull
    @Override
    public ProfileUpdateAdapter.NameDetailHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.single_profile, parent,false);
        NameDetailHolder nameDetailHolder = new NameDetailHolder(view);
        return nameDetailHolder;

    }

    @Override
    public void onBindViewHolder(@NonNull ProfileUpdateAdapter.NameDetailHolder holder, int position) {
        NameDetail nameDetail = nameDetails.get(position);

        String name= nameDetail.getName();
        String address = nameDetail.getAddress();

        holder.mNameUpdate.setText("Name" + " " + name);
        holder.mAddressUpdate.setText("Address" + " " + address);


    }

    @Override
    public int getItemCount() {
        return nameDetails.size();
    }


    public class NameDetailHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.name)
        TextView mNameUpdate;
        @BindView(R.id.address)
        TextView mAddressUpdate;

        public NameDetailHolder(View itemView){
            super(itemView);
            ButterKnife.bind(this,itemView);

        }
    }
}
