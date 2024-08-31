package com.example.calculadora;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class resultado extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);


        TextView txtResultado = findViewById(R.id.txt_resultado);


        Intent intent = getIntent();
        String resultado = intent.getStringExtra("resultado");


        txtResultado.setText("El resultado es: " + resultado);


        Button btnHome = findViewById(R.id.bt_home);
        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                txtResultado.setText("");


                Intent intent = new Intent(resultado.this, MainActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(intent);


                finish();
            }
        });
    }
}
