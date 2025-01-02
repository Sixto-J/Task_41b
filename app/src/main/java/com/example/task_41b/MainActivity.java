package com.example.task_41b;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);



        ImageView bdonut = findViewById(R.id.donut);
        bdonut.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showDonutOrder(view);
            }

        });

        ImageView bice_cream = findViewById(R.id.ice_cream);
        bice_cream.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showIceCreamOrder(view);
            }
        });



        ImageView bfroyo = findViewById(R.id.froyo);
        bfroyo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                showFroyoOrder(view);
            }

        });

    }

    /**
     * Displays a toast message for the food order
     * and starts the OrderActivity activity.
     *
     * @param message Message to display.
     */
    public void displayToast(String message) {
        Toast.makeText(getApplicationContext(), message,
                Toast.LENGTH_SHORT).show();
    }

    public void showFoodOrder(String message) {
        displayToast(message);
        Intent inte = new Intent(this, OrderActivity.class);
        startActivity(inte);

    }


    /**
     * Shows a message that the donut image was clicked.
     */
    public void showDonutOrder(View view) {
        showFoodOrder(getString(R.string.donut_order_message));
    }


    /**
     * Shows a message that the ice cream sandwich image was clicked.
     */
    public void showIceCreamOrder(View view) {
        showFoodOrder(getString(R.string.ice_cream_order_message));
    }

    /**
     * Shows a message that the froyo image was clicked.
     */
    public void showFroyoOrder(View view) {
        showFoodOrder(getString(R.string.froyo_order_message));
    }

}