package com.example.inputcontrols042homework;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button showToast;
    private CheckBox[] checkBoxes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showToast = findViewById(R.id.show_toast_Button);
        showToast.setOnClickListener(this);
        checkBoxes = new CheckBox[]{findViewById(R.id.chocolate_syrup_checkBox),
                findViewById(R.id.sprinkles_checkBox),
                findViewById(R.id.crushed_nuts_checkBox),
                findViewById(R.id.cremes_checkBox),
                findViewById(R.id.orio_cookie_crumbles_checkBox)};
    }

    public String getToastMessage() {
        String message = "Toppings: ";
        for (CheckBox checkBox : checkBoxes) {
            if (checkBox.isChecked()) {
                message = message.concat(checkBox.getText().toString() + ", ");
            }
        }
        //  message = message.substring(0 , message.lastIndexOf(","));
        return message.substring(0, message.lastIndexOf(","));
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.show_toast_Button:
                displayToast(getToastMessage());
                break;
        }
    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_LONG).show();
    }
}
