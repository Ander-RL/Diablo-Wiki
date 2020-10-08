package com.example.diablowiki;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.DialogFragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class FourthActivity extends AppCompatActivity {

    private RecyclerView recyclerView;

    String[] weapon, damage, durability, requirements, price, quality;
    TypedArray imagesArray;
    int[] images;
    private ArrayList<Integer> selectedItems = new ArrayList<>(2);

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fourth);

        if (savedInstanceState != null) {
            selectedItems.addAll(savedInstanceState.getIntegerArrayList("selectedItems"));
        }

        getIntent();

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setTitle("");
        toolbar.setSubtitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        recyclerView = findViewById(R.id.recyclerView_fourth);

        imagesArray = getResources().obtainTypedArray(R.array.weapon_image);
        int[] images = new int[imagesArray.length()];

        for (int i = 0; i < imagesArray.length(); i++) {
            images[i] = imagesArray.getResourceId(i, 0);
        }

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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_fourthactivity, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        FourthActivityDialogFragment dialog = new FourthActivityDialogFragment(this);
        //if(selectedItems != null){ dialog.setmSelectedItems(selectedItems);}
        dialog.show(getSupportFragmentManager(), "Alert Dialog Fragment");
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle savedInstanceState) {
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putIntegerArrayList("selectedItems", getSelectedItems());
    }

    public void setSelectedItems(ArrayList<Integer> selectedItems) {
        //this.selectedItems = (ArrayList<Integer>)selectedItems.clone();
        //this.selectedItems.addAll(selectedItems);
        this.selectedItems = selectedItems;
    }

    public ArrayList<Integer> getSelectedItems() {
        return this.selectedItems;
    }

}
