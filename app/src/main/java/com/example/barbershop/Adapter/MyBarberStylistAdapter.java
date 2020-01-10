package com.example.barbershop.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershop.BookingActivity;
import com.example.barbershop.Models.Hit;
import com.example.barbershop.R;
import com.example.barbershop.StylistActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;



public class MyBarberStylistAdapter extends RecyclerView.Adapter<MyBarberStylistAdapter.HitsViewHolder> {


    public Context mContext;
    private List<Hit> mhits;

    public MyBarberStylistAdapter(Context mContext,List<Hit> mhits){
        this.mContext = mContext;
        this.mhits = mhits;

    }



    @NonNull
    @Override
    public HitsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.style_item,parent, false);
        mContext=parent.getContext();
        HitsViewHolder viewHolder = new HitsViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull MyBarberStylistAdapter.HitsViewHolder holder, int position) {
        holder.bindBarber(mhits.get(position));
    }

    @Override
    public int getItemCount() {
        return mhits.size();
    }

    public class HitsViewHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.txtComment) TextView txtComment;
        @BindView(R.id.txtBarber) TextView txtBarber;
        @BindView(R.id.imgBarber) ImageView imgBarber;



        public HitsViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
        }

        public void bindBarber(Hit hit) {

            txtComment.setText(String.valueOf(hit.getComments()));
            txtBarber.setText("Tags:" + hit.getTags());
            Picasso.get().load(hit.getWebformatURL()).into(imgBarber);


            imgBarber.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent = new Intent(mContext,BookingActivity.class);
                    mContext.startActivity(intent);
                }

            });
        }
    }
}

