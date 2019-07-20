package com.example.screenorientation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/**
 * A Demo app to illustrate SOLUTION:
 * 		1. How to restore Activity State back
 * 		   to it's previous state before screen rotation using onRestoreInstanceState
 * 		   and onSaveInstanceState methods.
 * 		2. How to update the Resources as well.
 * */

public class MainActivity extends AppCompatActivity {
    private static final String TAG = MainActivity.class.getSimpleName();
    private final String KEY_MESSAGE = "message";
    private final String KEY_BTN_TEXT = "button_text";

    private  TextView textView;
    private Button btn;
    private EditText editText;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "onCreate()");
        textView = findViewById(R.id.textView);
        btn = findViewById(R.id.button);
        editText=findViewById(R.id.editText);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                btn.setText("LOGOUT");
                textView.setText("Welcome " + editText.getText().toString());
            }
        });

    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        Log.i(TAG, "onRestoreInstanceState()");
        if (savedInstanceState != null) {
            btn.setText(savedInstanceState.getString(KEY_BTN_TEXT));
            textView.setText(savedInstanceState.getString(KEY_MESSAGE));
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle b) {
        super.onSaveInstanceState(b);
        Log.i(TAG, "onSaveInstanceState()");

        b.putString(KEY_MESSAGE, textView.getText().toString());
        b.putString(KEY_BTN_TEXT, btn.getText().toString());
    }


    @Override
    protected void onRestart() {
        super.onRestart();
        Log.i(TAG, "onRestart()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG, "onStart()");

    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG, "onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG, "onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG, "onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG, "onDestroy()");
    }
}
