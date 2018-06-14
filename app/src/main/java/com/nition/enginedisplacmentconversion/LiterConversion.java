package com.nition.enginedisplacmentconversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class LiterConversion extends AppCompatActivity {

    public static final String EXTRA = "com.nition.enginedisplacementconversion";
    private EditText input;
    private TextView resultCC;
    private TextView resultCID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liter_conversion);

        Intent intent = getIntent();

        input = findViewById(R.id.editText2);
    }

    private void calculate(double n) {

        double ccResult = n*1000;
        double cidResult = ccResult/16.387064069264;

        DecimalFormat dec = new DecimalFormat("#.##");
        String formattedCC = dec.format(ccResult);
        String formattedCID = dec.format(cidResult);

        resultCC = findViewById(R.id.textView9);
        resultCID = findViewById(R.id.textView10);

        resultCC.setText(formattedCC + " cc");
        resultCID.setText(formattedCID + " C.I.D.");
    }

    //hide calculations
    public void convert(View view) {

        double numberInput = Double.valueOf(input.getText().toString());
        calculate (numberInput);
    }

    //goes to cc conversion page, function for button input
    public void ccConvert(View view) {

        Intent intent = new Intent(this, MainPage.class);
        startActivity(intent);
    }

    //goes to cid conversion page, function for button input
    public void cIDConvert(View view) {

        Intent intent = new Intent(this, CIDConversion.class);
        startActivity(intent);
    }

}
