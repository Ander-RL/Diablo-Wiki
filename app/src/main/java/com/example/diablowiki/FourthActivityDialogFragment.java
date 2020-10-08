package com.example.diablowiki;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import com.example.diablowiki.FourthActivity;
import com.example.diablowiki.R;

import java.util.ArrayList;

public class FourthActivityDialogFragment extends DialogFragment {

    private ArrayList<Integer> mSelectedItems;
    boolean[] choices = new boolean[]{false, false};
    FourthActivity filter;

    public FourthActivityDialogFragment(FourthActivity filter){
        this.filter = filter;
        this.mSelectedItems = filter.getSelectedItems();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Where we track the selected items
        //mSelectedItems = new ArrayList<>();
        //filter = new FourthActivity();
        //if(savedInstanceState != null){
        if (mSelectedItems != null) {
            for (int i = 0; i < mSelectedItems.size(); i++) {
                if (mSelectedItems.contains(i)) {
                    choices[i] = true;
                }
            }
        }
        //if (mSelectedItems.contains(0)){choices[0] = true;}
        //if (mSelectedItems.contains(1)){choices[1] = true;}
        //if (mSelectedItems.contains(0) && mSelectedItems.contains(1)){choices[0] = true; choices[1] = true;}
        //}
        // Use the Builder class for convenient dialog construction
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle("Titulo");
        // Specify the list array, the items to be selected by default (null for none),
        // and the listener through which to receive callbacks when items are selected
        builder.setMultiChoiceItems(R.array.filter_options, choices, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int which, boolean isChecked) {
                if (isChecked) {
                    if (!mSelectedItems.contains(which)) {
                        mSelectedItems.add(which);
                    }
                }
                if (!isChecked){
                    if (mSelectedItems.contains(which)) {  //TODO DEBUGEAR
                        if(mSelectedItems.size() == 1){mSelectedItems = new ArrayList<>(2);} //TODO cambiar choices a true inicial y guardar persistencia
                        else {mSelectedItems.remove(which);}
                    }
                }
            }
        });
        builder.setPositiveButton(R.string.menu_filter_dialog_ok, new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                filter.setSelectedItems(mSelectedItems);
            }
        })
                .setNegativeButton(R.string.menu_filter_dialog_cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        filter.setSelectedItems(new ArrayList<Integer>(2));
                    }
                });
        // Create the AlertDialog object and return it
        return builder.create();
    }

    public ArrayList<Integer> getmSelectedItems() {
        return mSelectedItems;
    }

    public void setmSelectedItems(ArrayList<Integer> mSelectedItems) {
        this.mSelectedItems = mSelectedItems;
    }
}
