package com.example.calender;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class DateAdapter extends RecyclerView.Adapter<DateAdapter.ViewHolder> {

   private  List<DateObject> list;
   private ClickListener clickListener;

   DateAdapter(List<DateObject> list , ClickListener clickListener){
       this.list = list;
       this.clickListener = clickListener;
   }

    @NonNull
    @NotNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull @NotNull ViewGroup parent, int viewType) {
       View view  = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
       return new ViewHolder(view ,clickListener);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onBindViewHolder(@NonNull @NotNull DateAdapter.ViewHolder holder, int position) {
        String date = list.get(position).getDate();
        String event = list.get(position).getEvent();
        boolean isEvent = list.get(position).isEvent();
        boolean  isSunday = list.get(position).isSunday();
        holder.setDate(date);
        if(isSunday){
            holder.date_text.setTextColor(Color.parseColor("#ff0000"));
        }else if (isEvent){
            holder.event_name.setVisibility(View.VISIBLE);
            holder.event_name.setText(event);
            holder.event_name.setTextColor(Color.parseColor("#ff0000"));
            holder.date_text.setTextColor(Color.parseColor("#ff0000"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public  class ViewHolder extends  RecyclerView.ViewHolder implements  View.OnClickListener{
       private TextView date_text;
       private TextView event_name;
       ClickListener clickListener;


       public ViewHolder(@NonNull @NotNull View itemView,ClickListener clickListener) {
           super(itemView);
           date_text = itemView.findViewById(R.id.date);
           event_name = itemView.findViewById(R.id.event_name);
           this.clickListener = clickListener;

           itemView.setOnClickListener(this);

       }

       @SuppressLint("ResourceAsColor")
       public void  setDate(String date){

           date_text.setText( String.valueOf(date));
       }

        @Override
        public void onClick(View view) {
        clickListener.dateClicked(getAdapterPosition());
        }
    }

   public interface  ClickListener{
       void dateClicked(int Position);
   }
}
