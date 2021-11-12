package com.example.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class Register extends Fragment {
    CustomerModel customer;
    @Nullable
    @Override


    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view=inflater.inflate(R.layout.register,container,false);

        EditText txtFullName=(EditText) view.findViewById (R.id.username);
        EditText txtAddress=(EditText)view.findViewById(R.id.address);
        EditText txtId=(EditText)view.findViewById(R.id.idNo);
        EditText txtGender=(EditText)view.findViewById(R.id.gender);
        Button btnRegister=(Button)view.findViewById(R.id.btnRegister);

        btnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                        //customer=new CustomerModel(txtId.getText().toString(),txtFullName.getText().toString(),txtAddress.getText().toString(),txtGender.getText().toString());
                        DatabaseHelper1 dbHelper=new DatabaseHelper1(getActivity());
                        boolean insertResults=dbHelper.insertCustomer(customer=new CustomerModel(txtId.getText().toString(),txtFullName.getText().toString(),txtAddress.getText().toString(),txtGender.getText().toString()));
                        if (insertResults) {
                            Toast.makeText(getActivity(), "Customer registration successful", Toast.LENGTH_SHORT).show();
                            txtAddress.setText("");
                            txtFullName.setText("");
                            txtGender.setText("");
                            txtId.setText("");
                        }
                        else
                            Toast.makeText(getActivity(), "Customer registration failed!!!", Toast.LENGTH_SHORT).show();
                }catch (Exception e){
                    Toast.makeText(getActivity(), "Error creating customer", Toast.LENGTH_SHORT).show();
                    customer=new CustomerModel("","","","");
                }
            }
        });
//
        return view;
    }
}
