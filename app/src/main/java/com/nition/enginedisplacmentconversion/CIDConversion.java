package com.nition.enginedisplacmentconversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class CIDConversion extends AppCompatActivity {

    public static final String EXTRA = "com.nition.enginedisplacementconversion";

    private EditText input;
    private TextView resultCC;
    private TextView resultL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cidconversion);

        Intent intent = getIntent();

        input = findViewById(R.id.editText);
    }

    private void calculate(double n) {

        double ccResult = 16.387064069264*n;
        double literResult = ccResult/1000;

        DecimalFormat dec = new DecimalFormat("#.##");
        String formattedLiters = dec.format(literResult);
        String formattedCC = dec.format(ccResult);

        resultL = findViewById(R.id.textView11);
        resultCC = findViewById(R.id.textView12);

        resultL.setText(formattedLiters + " Liters");
        resultCC.setText(formattedCC + " cc");
    }

    //hide calculations
    public void convert(View view) {
        double numberInput = Double.valueOf(input.getText().toString());
        calculate(numberInput);

    }

    //goes to liter conversion page, for button input
    public void literConvert(View view) {
        Intent intent = new Intent(this, LiterConversion.class);
        startActivity(intent);
    }

    //goes to cc conversion page, for button input
    public void ccConvert(View view) {
        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }
}
