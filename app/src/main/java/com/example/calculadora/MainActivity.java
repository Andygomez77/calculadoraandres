package com.example.calculadora;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnres;
    EditText edtnum1, edtnum2;
    Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        btnres = findViewById(R.id.btnres);
        edtnum1 = findViewById(R.id.edtnum1);
        edtnum2 = findViewById(R.id.edtnum2);
        spinner = findViewById(R.id.spinner);


        String[] operadores = {"+","-","*","/"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, operadores);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);



        btnres.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String text1 = edtnum1.getText().toString();
                String text2 = edtnum2.getText().toString();

                if (text1.equals("") || text2.equals("")) {
                    Toast.makeText(MainActivity.this, "Están vacíos", Toast.LENGTH_LONG).show();
                } else {
                    double num1 = Double.parseDouble(text1);
                    double num2 = Double.parseDouble(text2);
                    double resultado = 0;


                    String operador = spinner.getSelectedItem().toString();


                    switch (operador) {
                        case "+":
                            resultado = num1 + num2;
                            break;


                        case "/":
                            if (num2 != 0) {
                                resultado = num1 / num2;

                            } else {
                                Toast.makeText(MainActivity.this, "No se puede dividir por 0", Toast.LENGTH_LONG).show();
                                return;
                            }
                            break;
                        case "-":
                            resultado = num1 - num2;
                            break;
                        case "*":
                            resultado = num1 * num2;
                            break;
                    }
                    // Mostrar el resultado en una nueva vista
                    //crear un intent para ir a la otra vista(Intent: Se utiliza para enviar datos desde MainActivity a ResultadoActivity.)
                    Intent intent = new Intent(MainActivity.this, resultado.class);

                    //pasar el resultado( El método putExtra se usa para pasar el resultado.)
                    intent.putExtra("resultado", String.valueOf(resultado));
                    //pasar a la vista de resultado
                    startActivity(intent);
                }

            }
        });
    }
}
