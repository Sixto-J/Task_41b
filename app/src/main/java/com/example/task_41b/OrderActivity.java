package com.example.task_41b;


import android.os.Bundle;
import android.util.Log;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class OrderActivity extends AppCompatActivity {
    private final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);


        RadioGroup rGroup = findViewById(R.id.aradio);
        rGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {


            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                RadioButton cRButton = rGroup.findViewById(rGroup.getCheckedRadioButtonId());
                onRadioButtonClicked(cRButton);


            }
        });

    }

    public void onRadioButtonClicked(RadioButton cRButton) { // Is the button now checked?
        boolean checked = cRButton.isChecked();

        // Check which radio button was clicked
        final int samedayId = R.id.sameday;
        final int nextdayId = R.id.nextday;
        final int pickupId = R.id.pickup;

        if(cRButton.getId() == R.id.sameday){
            if (checked) {// Same day service
                displayToast(getString(R.string.chosen) +
                        getString(R.string.same_day_messenger_service));
            }

        }
        if(cRButton.getId() == R.id.nextday) {
            if (checked) {// Same day service
                displayToast(getString(R.string.chosen) +
                        getString(R.string.next_day_ground_delivery));
            }
        }

        if(cRButton.getId() == R.id.pickup) {

            if (checked) {// Pick up
                displayToast(getString(R.string.chosen) +
                        getString(R.string.pick_up));
            }
        }


    }

    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message, Toast.LENGTH_SHORT).show();
    }


}
