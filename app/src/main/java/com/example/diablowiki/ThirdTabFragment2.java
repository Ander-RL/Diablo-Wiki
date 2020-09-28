package com.example.diablowiki;

import android.graphics.text.LineBreaker;
import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

public class ThirdTabFragment2 extends Fragment {

    private TextView mtextView1;
    private TextView mtextView2;
    private TextView mtextView3;
    private TextView mtextView4;
    private TextView mtextView5;
    private TextView mtextView6;
    private TextView mtextView7;

    public ThirdTabFragment2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_third_tab2, container, false);

        mtextView1 = view.findViewById(R.id.amazon_tab2);
        mtextView2 = view.findViewById(R.id.barbarian_tab2);
        mtextView3 = view.findViewById(R.id.necromancer_tab2);
        mtextView4 = view.findViewById(R.id.paladin_tab2);
        mtextView5 = view.findViewById(R.id.sorceress_tab2);
        mtextView6 = view.findViewById(R.id.assassin_tab2);
        mtextView7 = view.findViewById(R.id.druid_tab2);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            mtextView1.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView2.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView3.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView4.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView5.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView6.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
            mtextView7.setJustificationMode(LineBreaker.JUSTIFICATION_MODE_INTER_WORD);
        }

        return view;
    }
}