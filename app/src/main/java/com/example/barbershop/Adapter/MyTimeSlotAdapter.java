package com.example.barbershop.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.barbershop.Common.Common;
import com.example.barbershop.Models.TimeSlot;
import com.example.barbershop.R;

import java.util.ArrayList;
import java.util.List;

public class MyTimeSlotAdapter extends RecyclerView.Adapter<MyTimeSlotAdapter.MyViewHolder> {

    Context context;
    List<TimeSlot> timeSlotList;

    public MyTimeSlotAdapter(Context context) {
        this.context = context;
        this.timeSlotList = new ArrayList<>();
    }

    public MyTimeSlotAdapter(Context context, List<TimeSlot> timeSlotList) {
        this.context = context;
        this.timeSlotList = timeSlotList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_time_slot,viewGroup,false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder myViewHolder, int i) {
         myViewHolder.txt_time_slot.setText(new StringBuilder(Common.convertTimeToString(i).toString()));
         if (timeSlotList.size() == 0){
             myViewHolder.txt_time_slot_desc.setText("Available");
             myViewHolder.txt_time_slot_desc.setTextColor(context.getResources()
             .getColor(android.R.color.black));
             myViewHolder.txt_time_slot.setTextColor(context.getResources()
             .getColor(android.R.color.black));
             myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
             .getColor(android.R.color.white));
         }
         //when the position is fully booked
        else {
            for (TimeSlot slotValue:timeSlotList){
                //Loop for the timeslot
                int slot = Integer.parseInt(slotValue.getSlot().toString());
                if (slot == i){
                    myViewHolder.card_time_slot.setCardBackgroundColor(context.getResources()
                    .getColor(android.R.color.darker_gray));
                    myViewHolder.txt_time_slot_desc.setText("Full");
                    myViewHolder.txt_time_slot_desc.setTextColor(context.getResources()
                            .getColor(android.R.color.white));
                    myViewHolder.txt_time_slot.setTextColor(context.getResources()
                            .getColor(android.R.color.white));
                }
            }
         }
    }

    @Override
    public int getItemCount() {
        return Common.TIME_SLOT_TOTAL;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_time_slot, txt_time_slot_desc;
        CardView card_time_slot;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            card_time_slot = (CardView)itemView.findViewById(R.id.card_time_slot);
            txt_time_slot = (TextView)itemView.findViewById(R.id.txt_time_slot);
            txt_time_slot_desc = (TextView)itemView.findViewById(R.id.txt_time_slot_desc);

        }
    }
}
