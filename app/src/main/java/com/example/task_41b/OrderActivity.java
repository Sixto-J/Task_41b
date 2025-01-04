package com.example.task_41b;


import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.NavUtils;


public class OrderActivity extends AppCompatActivity {
    private final String TAG_ACTIVITY = OrderActivity.class.getSimpleName();


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_order);


        // Set the Toolbar as the ActionBar
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("Order Activity");
        setSupportActionBar(toolbar);
        // Enable the Up button
        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        }


        Intent intent = getIntent();
        String message = intent.getStringExtra("message");


        TextView oculto  = findViewById(R.id.oculto);
        oculto.setText(message);
        oculto.setVisibility(TextView.VISIBLE);


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


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
