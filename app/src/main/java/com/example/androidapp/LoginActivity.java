package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    EditText username, password;
    Button btnlogin;
    DBHepler DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username = (EditText) findViewById(R.id.username1);
        password = (EditText) findViewById(R.id.password1);
        btnlogin = (Button) findViewById(R.id.btnsingin1);
        DB = new DBHepler(this);

        btnlogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String user = username.getText().toString();
                String pass = password.getText().toString();

                if(user.equals("")||pass.equals(""))
                    Toast.makeText(LoginActivity.this,"Wypełnij wszystkie pola",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass = DB.chcekusernamepassword(user,pass);
                        if(checkuserpass==true){
                            Toast.makeText(LoginActivity.this,"Zalogowano pomyślnie",Toast.LENGTH_SHORT).show();
                            Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                            startActivity(intent);
                        }else {
                            Toast.makeText(LoginActivity.this,"Niepoprawne dane",Toast.LENGTH_SHORT).show();
                        }
                    }
            }

        });
    }


}
