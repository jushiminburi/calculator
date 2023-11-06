package com.comp1786.calculator;

import static java.util.Objects.requireNonNull;

import android.os.Bundle;
import android.text.InputType;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.textfield.TextInputLayout;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String TAG = MainActivity.class.getSimpleName();
    private TextInputLayout textInputLayout;
    private EditText editText;
    private TextView textResult;

    private Button button0;
    private Button button1;
    private Button button2;
    private Button button3;
    private Button button4;
    private Button button5;
    private Button button6;
    private Button button7;
    private Button button8;
    private Button button9;
    private Button buttonPlus;
    private Button buttonMinus;
    private Button buttonTimes;
    private Button buttonDiv;
    private Button buttonDot;
    private Button buttonClearAll;
    private Button buttonDel;
    private Button buttonEqual;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setOnClickListener();
        editText.setInputType(InputType.TYPE_NULL);

    }

    private void setOnClickListener() {
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonTimes.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
        buttonClearAll.setOnClickListener(this);
        buttonEqual.setOnClickListener(this);
    }

    private void findViews() {

        textInputLayout = findViewById(R.id.text_input_layout);
        editText = requireNonNull((EditText) textInputLayout.getEditText());
        textResult = findViewById(R.id.text_result);
        button0 = findViewById(R.id.button0);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button4 = findViewById(R.id.button4);
        button5 = findViewById(R.id.button5);
        button6 = findViewById(R.id.button6);
        button7 = findViewById(R.id.button7);
        button8 = findViewById(R.id.button8);
        button9 = findViewById(R.id.button9);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonTimes = findViewById(R.id.button_times);
        buttonDiv = findViewById(R.id.button_div);
        buttonDot = findViewById(R.id.button_dot);
        buttonClearAll = findViewById(R.id.button_clear_all);
        buttonEqual = findViewById(R.id.button_equal);
    }

    private void onClickButtonEqual() {
        final String inputString = editText.getText().toString();
        try {
            final double result = Evaluation.execute(inputString);
            textResult.setText(formatDouble(result));
        } catch (Exception e) {
            Log.d(TAG, e.getMessage(), e);
        }
    }

    private String formatDouble(double result) {
        if (result == (long) result) {
            return String.format(Locale.getDefault(), "%d", (long) result);
        }
        return String.valueOf(result);
    }

    @Override
    public void onClick(View view) {

        if (view.getId() == R.id.button_clear_all) {
            editText.setText("");
            textResult.setText("0");
        } else if (view.getId() == R.id.button0) {
            editText.append("0");
        } else if (view.getId() == R.id.button1) {
            editText.append("1");
        } else if (view.getId() == R.id.button2) {
            editText.append("2");
        } else if (view.getId() == R.id.button3) {
            editText.append("3");
        } else if (view.getId() == R.id.button4) {
            editText.append("4");
        } else if (view.getId() == R.id.button5) {
            editText.append("5");
        } else if (view.getId() == R.id.button6) {
            editText.append("6");
        } else if (view.getId() == R.id.button7) {
            editText.append("7");
        } else if (view.getId() == R.id.button8) {
            editText.append("8");
        } else if (view.getId() == R.id.button9) {
            editText.append("9");
        } else if (view.getId() == R.id.button_dot) {
            editText.append(".");
        } else if (view.getId() == R.id.button_plus) {
            editText.append("+");
        } else if (view.getId() == R.id.button_minus) {
            editText.append("_");
        } else if (view.getId() == R.id.button_times) {
            editText.append("*");
        } else if (view.getId() == R.id.button_div) {
            editText.append("/");
        } else if (view.getId() == R.id.button_equal) {
            onClickButtonEqual();
        }
    }
}