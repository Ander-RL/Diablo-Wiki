package com.example.diablowiki;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class FourthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    String[] weapon, damage, durability, requirements, price, quality;
    int[] images = {R.drawable.small_axe, R.drawable.axe, R.drawable.large_axe, R.drawable.broad_axe, R.drawable.battle_axe, R.drawable.great_axe,};

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        getIntent();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView_fourth);

        weapon = getResources().getStringArray(R.array.weapon);
        damage = getResources().getStringArray(R.array.damage);
        durability = getResources().getStringArray(R.array.durability);
        requirements = getResources().getStringArray(R.array.requirements);
        price = getResources().getStringArray(R.array.price);
        quality = getResources().getStringArray(R.array.quality);

        RecyclerViewFourth adapter = new RecyclerViewFourth(this, weapon, damage, durability, requirements, price, quality, images);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

    }
}
