package com.example.testapp2;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends ActionBarActivity {
    public final static String EXTRA_MESSAGE = "com.example.testapp2.MainActivity.message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); 
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    @Override
    protected void onResume() {
        super.onResume();
        Intent i = getIntent();
        if (i!= null) {
            EditText edit1 = (EditText) findViewById(R.id.textEdit1);
            edit1.setText(i.getStringExtra(DisplayMessageActivity.EXTRA_MESSAGE));
        }
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

    public void sendMessage(View view) {
        EditText edit1 = (EditText) findViewById(R.id.textEdit1);
        String message = edit1.getText().toString();
        Intent i = new Intent(this,  DisplayMessageActivity.class);
        i.putExtra(EXTRA_MESSAGE, message + " - nope");
        startActivity(i);
        
    }
}
