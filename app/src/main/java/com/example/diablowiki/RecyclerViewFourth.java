package com.example.diablowiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewFourth extends RecyclerView.Adapter<RecyclerViewFourth.MyViewHolder> {

    String[] wp, dmg, dur, rq, pr, qlt;
    int[] img;
    Context ct;

    public RecyclerViewFourth (Context context, String[] weapons, String[] damage, String[] durability, String[] requirements, String[] price, String[] quality, int[] images){
        ct = context;
        wp = weapons;
        dmg = damage;
        dur = durability;
        rq = requirements;
        pr = price;
        qlt = quality;
        img = images;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(ct);
        View view = inflater.inflate(R.layout.activity_fourth_element_layout, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.weapons.setText(wp[position]);
        holder.damage.setText(dmg[position]);
        holder.durability.setText(dur[position]);
        holder.requirements.setText(rq[position]);
        holder.price.setText(pr[position]);
        holder.quality.setText(qlt[position]);
        holder.images.setImageResource(img[position]);
    }

    @Override
    public int getItemCount() {
        return wp.length;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView weapons, damage, durability, requirements, price, quality;
        ImageView images;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            weapons = itemView.findViewById(R.id.weapon_name);
            damage = itemView.findViewById(R.id.weapon_damage);
            durability = itemView.findViewById(R.id.weapon_durability);
            requirements = itemView.findViewById(R.id.weapon_requirements);
            price = itemView.findViewById(R.id.weapon_price);
            quality = itemView.findViewById(R.id.weapon_quality);
            images = itemView.findViewById(R.id.weapon_image);
        }
    }
}
