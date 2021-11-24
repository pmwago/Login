package com.example.login;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class Purchase extends Fragment {
    private Button btnPurchase,btnBuy1,btnBuy2,btnBuy3,btnBuy4;
    private Spinner spin1,spin2,spin3,spin4;
    private TextView price1,price2,price3,price4,priceTotal;
    private int totalPrice;
    private ImageView tv,woofer,laptop,extension;
    int tvPrice=15000,laptopPrice=40000,wooferPrice=5800,extensionPrice=400;
    int totalTv,totalLaptop,totalWoofer,totalExtension=0;
    Button[] buttons = new Button[]{btnBuy1, btnBuy2, btnBuy3, btnBuy4};
    @Nullable
    @Override

    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.purchase,container,false);
        tv=view.findViewById(R.id.tv);
        woofer=view.findViewById(R.id.woofer);
        laptop=view.findViewById(R.id.laptop);
        extension=view.findViewById(R.id.extension);
        btnPurchase=view.findViewById(R.id.purchase);
        btnBuy1=view.findViewById(R.id.btnBuy1);
        btnBuy2=view.findViewById(R.id.btnBuy2);
        btnBuy3=view.findViewById(R.id.btnBuy3);
        btnBuy4=view.findViewById(R.id.btnBuy4);
        spin1=view.findViewById(R.id.spin1);
        spin2=view.findViewById(R.id.spin2);
        spin3=view.findViewById(R.id.spin3);
        spin4=view.findViewById(R.id.spin4);
        price1=view.findViewById(R.id.price1);
        price2=view.findViewById(R.id.price2);
        price3=view.findViewById(R.id.price3);
        price4=view.findViewById(R.id.price4);
        priceTotal=view.findViewById(R.id.priceTotal);


        Integer[] items = new Integer[]{0,1,2,3,4,5,6,7,9,10,11,12,13,14,15,16,17,18,19,20};
        ArrayAdapter<Integer> adapter1 = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        spin1.setAdapter(adapter1);
        ArrayAdapter<Integer> adapter2 = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        spin2.setAdapter(adapter2);
        ArrayAdapter<Integer> adapter3 = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        spin3.setAdapter(adapter3);
        ArrayAdapter<Integer> adapter4 = new ArrayAdapter<Integer>(getActivity(),android.R.layout.simple_spinner_item, items);
        spin4.setAdapter(adapter4);

        btnBuy1.setOnClickListener(new View.OnClickListener() {
            int check=1;
                    @Override
                    public void onClick(View view) {
                        if (check==1) {
                            btnBuy1.setBackgroundColor(Color.GREEN);
                            totalTv = calculatePrice(Integer.parseInt(spin1.getSelectedItem().toString()), tvPrice);
                            price1.setText(String.valueOf(totalTv));
                            check=0;
                        }
                        else {

                            btnBuy1.setBackgroundColor(Color.BLUE);
                         totalTv=0;
                         spin1.setSelection(0);
                         price1.setText(String.valueOf(tvPrice));
                         check=1;
                        }
                    }
                });

        btnBuy2.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {
                if (check==1) {
                    btnBuy2.setBackgroundColor(Color.GREEN);
                    totalLaptop = calculatePrice(Integer.parseInt(spin2.getSelectedItem().toString()),laptopPrice);
                    price2.setText(String.valueOf(totalLaptop));
                    check=0;
                }
                else {
                    btnBuy2.setBackgroundColor(Color.BLUE);
                    totalLaptop=0;
                    spin2.setSelection(0);
                    price2.setText(String.valueOf(laptopPrice));
                    check=1;
                }
            }
        });

        btnBuy3.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {
                if (check==1) {
                    btnBuy3.setBackgroundColor(Color.GREEN);
                    totalWoofer = calculatePrice(Integer.parseInt(spin3.getSelectedItem().toString()), wooferPrice);
                    price3.setText(String.valueOf(totalWoofer));
                    check=0;
                }
                else {
                    btnBuy3.setBackgroundColor(Color.BLUE);
                    totalWoofer=0;
                    spin3.setSelection(0);
                    price3.setText(String.valueOf(wooferPrice));
                    check=1;
                }
            }
        });

        btnBuy4.setOnClickListener(new View.OnClickListener() {
            int check=1;
            @Override
            public void onClick(View view) {
                if (check==1) {
                    btnBuy4.setBackgroundColor(Color.GREEN);
                    totalExtension = calculatePrice(Integer.parseInt(spin4.getSelectedItem().toString()), extensionPrice);
                    price4.setText(String.valueOf(totalExtension));
                    check=0;
                }
                else {
                    btnBuy4.setBackgroundColor(Color.BLUE);
                    totalExtension=0;
                    spin4.setSelection(0);
                    price4.setText(String.valueOf(extensionPrice));
                    check=1;
                }
            }
        });

        btnPurchase.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               priceTotal.setText(String.valueOf(totalPrice()));
            }


        });


        return view;
    }
    public  int calculatePrice(int quantity,int price){
        int subTotalPrice=quantity*price;
        return subTotalPrice;
    }

    public int totalPrice(){
        return  totalPrice=totalExtension+totalLaptop+totalWoofer+totalTv;
    }
}
