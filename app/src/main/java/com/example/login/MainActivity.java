package com.example.login;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText userName,password;
    private Button signIn,register;
    DatabaseHelper dbHelper;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName=findViewById(R.id.username);
        password=findViewById(R.id.pwd);
        signIn=findViewById(R.id.btnSignIn);
        register=findViewById(R.id.btnRegister);

        dbHelper=new DatabaseHelper(this);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String uname=userName.getText().toString();
                String pwd=password.getText().toString();

                if (uname.equals("")&&pwd.equals("")){
                    Toast.makeText(MainActivity.this, "Fill the empty fields", Toast.LENGTH_SHORT).show();
                }
                else {
                    boolean checkUserpass=dbHelper.checkUsernamePwd(uname,pwd);
                    if (checkUserpass==true){
                        Toast.makeText(MainActivity.this, "Sign in successful", Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),Home.class);
                        startActivity(intent);
                        userName.setText("");
                        password.setText("");
                    }
                    else{
                        Toast.makeText(MainActivity.this, "Invalid credentials", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
        register. setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(getApplicationContext(),SignUp.class);
                startActivity(intent);
            }
        });
    }
}