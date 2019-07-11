package com.example.poc_app;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewholder> {

    private Context mCtx;
    private List<Event> eventList;

    public EventAdapter(Context mCtx, List<Event> eventList) {
        this.mCtx = mCtx;
        this.eventList = eventList;
    }

    @NonNull
    @Override
    public EventViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater=LayoutInflater.from(mCtx);
        View view= inflater.inflate(R.layout.card_list_layout,null);
        return new EventViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewholder holder, int position) {
        Event event = eventList.get(position);
        holder.textViewEventName.setText(event.getEventName());
        holder.textViewDate.setText(event.getEventDate());
    }

    @Override
    public int getItemCount() {
        return eventList.size();
    }

    class EventViewholder extends RecyclerView.ViewHolder{

        TextView textViewEventName,textViewDate;
        public EventViewholder(@NonNull View itemView) {
            super(itemView);

            textViewEventName = itemView.findViewById(R.id.textViewEventName);
            textViewDate = itemView.findViewById(R.id.textViewEventDate);

        }
    }
}
