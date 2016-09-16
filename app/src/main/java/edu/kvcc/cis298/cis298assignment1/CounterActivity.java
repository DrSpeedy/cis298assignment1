package edu.kvcc.cis298.cis298assignment1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class CounterActivity extends AppCompatActivity {

    // Declare all of the variables that we need for this app
    private int count;              // variable to hold the current count
    private boolean hasToasted;     // set true if the > 20 toast message has been fired
    private Button mMinus;          // handle for the minus button
    private Button mPlus;           // handle for the plus button
    private TextView mCounterText;  // handle for the text view that displays the current count

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        // Initialize class variables
        count = 0;
        hasToasted = false;

        // Get module handles
        mMinus = (Button) findViewById(R.id.minus);
        mPlus = (Button) findViewById(R.id.plus);
        mCounterText = (TextView) findViewById(R.id.counter);

        // When the + button is pressed...
        mPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set count = count + 1
                count += 1;

                // if the count is greater than 20 and the toast message has not been fired yet,
                // fire the toast message and set hasToasted = true
                if (count > 20 && !hasToasted) {
                    Toast.makeText(CounterActivity.this, R.string.toast_message, Toast.LENGTH_SHORT).show();
                    hasToasted = true;
                }

                // update the counter textview with the new count
                updateCounterText();
            }
        });

        // When the - button is pressed...
        mMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // set count = count - 1
                count -= 1;

                // if the toast message has already been fired, but the count is now back under 20,
                // reset the hasToasted variable back the false so we can fire the message again
                // if or when the count goes back over 20
                if (hasToasted && count < 20) {
                    hasToasted = false;
                }

                // update the counter textview with the new count
                updateCounterText();
            }
        });
    }

    // Set the counter text view with the appropriate value
    public void updateCounterText() {
        mCounterText.setText("Count: " + count);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
