package com.example.testapp2;

import android.support.v7.app.ActionBarActivity;
import android.app.ActionBar.LayoutParams;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class DisplayMessageActivity extends ActionBarActivity {
    public static final String EXTRA_MESSAGE = "com.example.testapp2.DisplayMessageActivity.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //create from xml
        setContentView(R.layout.activity_display_message);
        //enable up
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Intent intent = getIntent();
        String message = intent.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // update  the text view
        TextView textView = (TextView)findViewById(R.id.textView2);
        textView.setText(message);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.display_message, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    

    public void sendBack(View view) {
        Intent i = new Intent(this, MainActivity.class);
        TextView textView = (TextView)findViewById(R.id.textView2);
        String s = textView.getText().toString();
        i.putExtra(EXTRA_MESSAGE, s.substring(0, s.lastIndexOf("-")) + " OK");
        startActivity(i);
    }
}
