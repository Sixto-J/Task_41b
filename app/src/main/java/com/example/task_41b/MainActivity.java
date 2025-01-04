package com.example.task_41b;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.my_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection.
        if(item.getItemId() == R.id.order){
            showOrder();
        }else if(item.getItemId() == R.id.status) {
            //showStatus();
        }else if(item.getItemId() == R.id.favorites){
            //showFavorites();
        }
        return false;
    }

    private void showOrder() {



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
        inte.putExtra("message", message);
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

/*button inferior derecha de contacto que cambia a boton de carrito
    <TextView
        android:id="@+id/textintro"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
        android:background="#3F51B5"
        android:text="@string/intro_text"

        />
 */
