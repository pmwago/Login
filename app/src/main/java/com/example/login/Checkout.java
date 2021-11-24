package com.example.login;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

public class Checkout extends Fragment {

    Button btnCheckout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.checkout,container,false);

        btnCheckout = view.findViewById(R.id.btnCheckout);

        btnCheckout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //dialogue Bulder to check out

                AlertDialog.Builder alertDialogBuilder = new  AlertDialog.Builder(getActivity());
                // set Title
                alertDialogBuilder.setTitle("Confirm Purchase");
                //set Message
                alertDialogBuilder.setMessage("Are you sure you want to  Purchase ?").setCancelable(false)
                        .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id){
                        // if button is clicked
                        Toast.makeText(getActivity(), "Thanks you and welcome", Toast.LENGTH_SHORT).show();
                     System.exit(0);
                    }
                }).setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id ){
                        // if button is clicked then close the alert box
                        Toast.makeText(getActivity(), "Go confirm first on purchase tab", Toast.LENGTH_SHORT).show();
                        dialog.cancel();
                    }
                });
                //create alert dialog
                AlertDialog alertDialog = alertDialogBuilder.create();
                //show alert box
                alertDialog.show();
            }
        });
        return view;
    }
}
