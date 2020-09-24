package com.example.diablowiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.widget.NestedScrollView;

import android.app.ActionBar;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ScrollView;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import org.w3c.dom.Text;

//THIS ACTIVITY IS FOR ABOUT THE GAME LORE
public class SecondActivity extends AppCompatActivity {

    private TextView mtextView1;
    private TextView mtextView2;
    private TextView mtextView3;
    private TextView mtextView4;
    private TextView mtextView5;
    private TextView mtextView6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        Toolbar toolbarSecond = findViewById(R.id.toolbarSecond);
        //To set the Toolbar to act as the ActionBar
        setSupportActionBar(toolbarSecond);

        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarSecond.setTitle("");
        toolbarSecond.setSubtitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                scrollToTop();
            }
        });

        getIntent();

        mtextView1 = findViewById(R.id.lore_summary);
        mtextView2 = findViewById(R.id.the_beginning);
        mtextView3 = findViewById(R.id.the_sin_war);
        mtextView4 = findViewById(R.id.the_reset);
        mtextView5 = findViewById(R.id.the_dark_exile);
        mtextView6 = findViewById(R.id.the_horadrim);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mtextView1.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView4.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView5.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView6.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }
    }

    /**
     * This method is used to scroll the ScrollView down to the desired position.
     * Different buttons offer different positions inside the ScrollView.
     * To link the id tof the TextView that the button is offering, getID is used.
     * Once the ID of the TextView is saves in textView, scrollTo() is used on scrollView.
     * scrollTo(int x, int y) takes for parameters the position of the desired view (textView).
     * In order to achieve the view´s position getX() and getY() are used and casted into an int.
     *
     * @param view Clicked button
     */

    public void scrollTo(View view) {
        final NestedScrollView scrollview =  findViewById(R.id.scrollview);
        TextView textView = getID(view);
        scrollview.scrollTo((int)textView.getX(),(int)textView.getY());
    }

    /**
     * Custom getId() method. Compares the view´s (button´s) id with the different TextView id.
     * If they match, saves the id of the TextView in textView.
     * Used to identify the TextView that is linked with the button.
     *
     * @param view Clicked button in scrollTo(View view)
     * @return textView
     */

    public TextView getID(View view){
        TextView textView = null;
        switch(view.getId()){
            case R.id.button_intro:
                textView = findViewById(R.id.header_intro_second);
                break;
            case R.id.button_the_beginning:
                textView = findViewById(R.id.header_the_beginning);
                break;
            case R.id.button_the_sin_war:
                textView = findViewById(R.id.header_the_sin_war);
                break;
            case R.id.button_the_reset:
                textView = findViewById(R.id.header_the_reset);
                break;
            case R.id.button_the_dark_exile:
                textView = findViewById(R.id.header_the_dark_exile);
                break;
            case R.id.button_the_horadrim:
                textView = findViewById(R.id.header_the_horadrim);
                break;
        }
        return textView;
    }

    public void scrollToTop() {
        final NestedScrollView scrollview = findViewById(R.id.scrollview);
        scrollview.fullScroll(ScrollView.FOCUS_UP);
    }
}