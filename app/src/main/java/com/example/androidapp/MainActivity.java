package com.example.androidapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.androidapp.DBHepler;
import com.example.androidapp.HomeActivity;
import com.example.androidapp.LoginActivity;

public class MainActivity extends AppCompatActivity {

    EditText username, password, repassword;
    Button signup,signin;
    DBHepler DB;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        repassword = (EditText) findViewById(R.id.repassword);
        signup = (Button) findViewById(R.id.btnsingup);
        signin = (Button) findViewById(R.id.btnsingin);
        DB = new DBHepler(this);

        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String repass = repassword.getText().toString();

                if(user.equals("")||pass.equals("")||repass.equals(""))
                    Toast.makeText(com.example.androidapp.MainActivity.this,"Wypełnij wszystkie pola",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser = DB.checkusername(user);
                        if(checkuser==false){
                            Boolean insert = DB.insertData(user,pass);
                            if(insert==true){
                                Toast.makeText(com.example.androidapp.MainActivity.this,"Zarejestrowano pomyślnie",Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getApplicationContext(), HomeActivity.class);
                                startActivity(intent);
                            }else{
                                Toast.makeText(com.example.androidapp.MainActivity.this,"Błąd rejestracji",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else {
                            Toast.makeText(com.example.androidapp.MainActivity.this,"Użytkownik jest już zarejestrowany",Toast.LENGTH_SHORT).show();
                        }
                    }else {
                        Toast.makeText(com.example.androidapp.MainActivity.this,"Hasła się nie zgadzają!",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getApplicationContext(), LoginActivity.class);
                startActivity(intent);
            }
        });
    }

}
