package com.example.diablowiki;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

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
        setSupportActionBar(toolbarSecond);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbarSecond.setTitle("");
        toolbarSecond.setSubtitle("");
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

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

    public void scrollTo(View view) {
        final ScrollView scrollview = ((ScrollView) findViewById(R.id.scrollview));
        TextView textView = getID(view);
        scrollview.scrollTo((int)textView.getX(),(int)textView.getY());
    }

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
}