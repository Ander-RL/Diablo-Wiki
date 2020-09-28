package com.example.diablowiki;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ThirdTabFragment1 extends Fragment {

    private TextView mtextView1;
    private TextView mtextView2;
    private TextView mtextView3;
    private TextView mtextView4;
    private TextView mtextView5;
    private TextView mtextView6;

    public ThirdTabFragment1() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_tab1, container, false);

        mtextView1 = view.findViewById(R.id.warrior_tab1);
        mtextView2 = view.findViewById(R.id.rogue_tab1);
        mtextView3 = view.findViewById(R.id.sorcerer_tab1);
        mtextView4 = view.findViewById(R.id.monk_tab1);
        mtextView5 = view.findViewById(R.id.barbarian_tab1);
        mtextView6 = view.findViewById(R.id.bard_tab1);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mtextView1.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView4.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView5.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView6.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        return view;
    }
}