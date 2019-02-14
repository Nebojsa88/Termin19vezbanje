package com.aad.termin19vezbanje.adapters;


import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.aad.termin19vezbanje.R;
import com.aad.termin19vezbanje.fragments.MasterFragment;

import java.util.List;


public class FruitAdapter extends RecyclerView.Adapter<FruitAdapter.ViewHolder> {
    private List<String> fruits;
    private MasterFragment.OnItemSelectedListener listener;

    public FruitAdapter(MasterFragment.OnItemSelectedListener listener, List<String> fruits) {
        this.fruits = fruits;
        this.listener = listener;
    }

    public static class ViewHolder extends  RecyclerView.ViewHolder{
        public TextView textView;

        public ViewHolder(View v){
            super(v);
            textView = v.findViewById(R.id.textCard);
        }
    }


    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_fruit_item, parent, false);
        ViewHolder vh = new ViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        final int pos = position;
        holder.textView.setText(fruits.get(position));
        holder.textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onItemSelected(pos);

            }
        });

    }
    @Override
    public int getItemCount() {
        return fruits.size();
    }

}
