package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView inputTextView;
    private TextView equalsTextView;

    private String currentInput = "";
    private String prevNumber = "";
    private String operator = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inputTextView = findViewById(R.id.imputTextView);
        equalsTextView = findViewById(R.id.equalsTextView);

        // Código para inicializar los listeners...

        findViewById(R.id.equalsTextView).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                double result = performCalculation();
                equalsTextView.setText(String.valueOf(result));
                currentInput = "";
            }
        });

        findViewById(R.id.C).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Código para limpiar
            }
        });

    }

    View.OnClickListener numberClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            operator = button.getText().toString();
            prevNumber = currentInput;
            currentInput = "";
        }
        // Código para números...
    };

    View.OnClickListener operatorClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            Button button = (Button) view;
            operator = button.getText().toString();
            prevNumber = currentInput;
        }
    };

    private double performCalculation() {
        if (operator.isEmpty()) {
            return Double.parseDouble(currentInput);
        }

        if (prevNumber.isEmpty()) {
            prevNumber = "0";
        }

        double prevOperand = Double.parseDouble(prevNumber);
        double currentOperand = Double.parseDouble(currentInput);

        switch(operator) {
            case "+":
                return prevOperand + currentOperand;
            case "-":
                return prevOperand - currentOperand;
            case "X":
                return prevOperand * currentOperand;
            case "/":
                if(currentOperand == 0) {
                    return 0;
                }
                return prevOperand / currentOperand;
            default:
                return currentOperand;
        }
    }
}