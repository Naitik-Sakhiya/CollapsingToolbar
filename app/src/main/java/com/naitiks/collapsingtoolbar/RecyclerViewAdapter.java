package com.naitiks.collapsingtoolbar;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Naitik on 9/4/2017.
 */

class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    ArrayList<MainActivity.Model> list = null;
    Context context = null;

    public RecyclerViewAdapter(Context context, ArrayList<MainActivity.Model> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {
        View childView =
                LayoutInflater.from(parent.getContext()).inflate(R.layout.row, parent, false);
        return new ViewHolder(childView);
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        String name = list.get(position).name;
        holder.first_letter.setText(name.substring(0,1).toUpperCase());
        holder.name.setText(name.substring(0,1)+name.substring(1));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView first_letter, name;
        CardView card;
        public ViewHolder(View itemView) {
            super(itemView);
            card = (CardView) itemView.findViewById(R.id.card);
            first_letter = (TextView) itemView.findViewById(R.id.first_letter);
            name = (TextView) itemView.findViewById(R.id.name);

            //A work around solution to implement item click in recycler view
            card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Toast.makeText(context, "I am position "+getAdapterPosition(),
                            Toast.LENGTH_SHORT).show();
                }
            });

        }

    }
}
