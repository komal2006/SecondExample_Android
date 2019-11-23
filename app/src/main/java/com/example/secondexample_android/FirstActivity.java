package com.example.secondexample_android;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

public class FirstActivity extends AppCompatActivity implements View.OnClickListener {

    public static final String KEY_Name = "Name";
    private EditText edtName;
    private Button btnGoNext;
    private ToggleButton toggleButton;
    private TextView txtColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        edtName = findViewById(R.id.editPersonName);
        btnGoNext = findViewById(R.id.btnLogin);
        toggleButton = findViewById(R.id.toggleButton);
        txtColor = findViewById((R.id.txtColor));

       // btnGoNext.setOnClickListener(new On);
        btnGoNext.setOnClickListener(this);

        toggleButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean b)
            {
              if(b)
              {
                  txtColor.setBackgroundColor(Color.YELLOW);
                  txtColor.setTextColor(Color.BLUE);
              }else{
                  txtColor.setBackgroundColor(Color.GREEN);
                  txtColor.setTextColor(Color.RED);
              }

            }
        });
    }



    @Override
    public void onClick(View view) {
        //view.getId() == R.id.btnLogin;
        if (edtName.getText().toString().trim().length() != 0)
        {
            Intent mIntent = new Intent(FirstActivity.this, SecondActivity.class);
            mIntent.putExtra("name",edtName.getText().toString());
            startActivity(mIntent);
        } else {
           edtName.setError("Please Enter Name");
            showAlert();

        }
    }

        private void showAlert()
        {
            AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
                    alertDialogBuilder.setIcon(R.drawable.ic_action_name);
                    alertDialogBuilder.setTitle("login Error");
                    alertDialogBuilder.setMessage("Please Enter Your Name");
                    alertDialogBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which)
                        {

                        }
                    });
            alertDialogBuilder.setNegativeButtonIcon(getResources().getDrawable(R.drawable.ic_action_name));
            AlertDialog mAlertDialog = alertDialogBuilder.create();
            mAlertDialog.show();
        }

}
