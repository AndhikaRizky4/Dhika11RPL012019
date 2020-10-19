package com.example.dhika11rpl012019;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.media.ExifInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    SharedPreferences pref;
    SharedPreferences.Editor editor;

    EditText edt1;
    EditText edt2;
    Button btnMasuk;
    Button btnTutup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        pref = getSharedPreferences("login", MODE_PRIVATE);
        edt1 = (EditText) findViewById(R.id.edt1);
        edt2 = (EditText) findViewById(R.id.edt2);
        btnMasuk = (Button) findViewById(R.id.btnMasuk);
        btnMasuk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edt1.getText().toString().isEmpty() ||
                        edt2.getText().toString().isEmpty()) {
                    Toast.makeText(MainActivity.this, "Harus terisi semua", Toast.LENGTH_SHORT).show();

                } else {

                if (edt1.getText().toString().equals("admin")
                        && edt2.getText().toString().equals("admin")) {
                    Toast.makeText(MainActivity.this, "Login sukses", Toast.LENGTH_SHORT).show();
                    Intent i = new Intent(MainActivity.this, Mainmenu.class);
                    startActivity(i);

                } else {
                    Toast.makeText(MainActivity.this,"Login gagal", Toast.LENGTH_SHORT) .show();
                    finish();
                }
                //saving ke SP
                editor = pref.edit();
                editor.putString("username", edt1.getText().toString());
                editor.putString("status", "login");
                editor.apply();
                //menuju ke main menu
                startActivity(new Intent(getApplicationContext(), Mainmenu.class));
                finish();
            }

        }
    });

    }
}

