package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignUp extends AppCompatActivity {
    private EditText userName,password,passwordConfirm;
    private Button register;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        userName=findViewById(R.id.username);
        password=findViewById(R.id.pwd);
        passwordConfirm=findViewById(R.id.rePwd);
        register=findViewById(R.id.btnRegister);

        dbHelper=new DatabaseHelper(this);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=userName.getText().toString();
                String pwd=password.getText().toString();
                String confirmPwd=passwordConfirm.getText().toString();

                if (uname.equals("")&&pwd.equals("")&&confirmPwd.equals("")){
                    Toast.makeText(SignUp.this, "Fill the empty fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    if (pwd.equals(confirmPwd)){
                        boolean checkUser=dbHelper.checkUsername(uname);

                        if (checkUser==false){

                            boolean insert=dbHelper.insertData(uname,pwd);

                            if (insert==true){
                                Toast.makeText(SignUp.this, "Registered successfully", Toast.LENGTH_SHORT).show();
                                Intent intent=new Intent(getApplicationContext(),MainActivity.class);
                                startActivity(intent);
                            }
                            else{
                                Toast.makeText(SignUp.this, "Registration failed", Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(SignUp.this, "user already exists", Toast.LENGTH_SHORT).show();
                        }
                    }
                    else {
                        Toast.makeText(SignUp.this, "Passwords not matching!!", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });


    }
}
