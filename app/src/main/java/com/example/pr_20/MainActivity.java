package com.example.pr_20;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    EditText edName, edSecName, edMail;

    private DatabaseReference myDataBase;


    private String USER_KEY = "User";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edName = findViewById(R.id.edName);
        edSecName = findViewById(R.id.edSecName);
        edMail = findViewById(R.id.edEmail);
        myDataBase = FirebaseDatabase.getInstance().getReference(USER_KEY);
        //Добавляем

    }

    public void onClickSave(View view)
    {
        String id = myDataBase.getKey();
        String name = edName.getText().toString();
        String sec_name = edSecName.getText().toString();
        String email = edMail.getText().toString();
        User newUser = new User(id,name,sec_name,email);
        if(!TextUtils.isEmpty(name) && !TextUtils.isEmpty(sec_name) && !TextUtils.isEmpty(email))
        {
            myDataBase.push().setValue(newUser);
            Toast.makeText(this, "Успех", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(this, "Пустое поле", Toast.LENGTH_SHORT).show();
        }
    }
    public void onClickRead(View view)
    {
        Intent act = new Intent(MainActivity.this, ReadActivity.class);
        startActivity(act);

    }
}