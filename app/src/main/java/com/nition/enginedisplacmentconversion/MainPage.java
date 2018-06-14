package com.nition.enginedisplacmentconversion;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainPage extends AppCompatActivity {

    public static final String EXTRA = "com.nition.enginedisplacementconversion";
    private EditText input;
    private TextView resultL;
    private TextView resultCID;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);

        input = findViewById(R.id.editText3);
    }

    private void calculate(double n) {

        double literResult = n/1000;
        double cidResult = n/16.387064069264;

        DecimalFormat dec = new DecimalFormat("#.##");
        String formattedLiters = dec.format(literResult);
        String formattedCID = dec.format(cidResult);

        resultL = findViewById(R.id.textView5);
        resultCID = findViewById(R.id.textView6);

       resultL.setText(formattedLiters + " Liters");
        resultCID.setText(formattedCID + " C.I.D.");
    }

    //hide calculations
    public void convert(View view) {
        double numberInput = Double.valueOf(input.getText().toString());
        calculate(numberInput);

    }

    //goes to liter conversion page, for button input
    public void literConvert(View view) {

        Intent intent = new Intent(this, LiterConversion.class);
        /*EditText editText = findViewById(R.id.editText);
        String message = editText.getText().toString();
        intent.putExtra(EXTRA, message);*/
        startActivity(intent);
    }

    //goes to cid conversion page, for button input
    public void cIDConvert(View view) {

        Intent intent = new Intent(this, CIDConversion.class);
        startActivity(intent);
    }
}
