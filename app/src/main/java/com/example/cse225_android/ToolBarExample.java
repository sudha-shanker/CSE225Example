package com.example.cse225_android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;


public class ToolBarExample extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tool_bar_example);
        Toolbar toolbar = findViewById(R.id.toolbar);
        toolbar.setTitle("ToolBar Example");
        toolbar.setLogo(R.drawable.logo_toolbar);
        setSupportActionBar(toolbar); // replace toolbar as the ActionBar
        toolbar.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ToolBarExample.this, "Back Arrow", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu_toolbar, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.action_settings) {
            Toast.makeText(getApplicationContext(), "Setting Menu", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_email) {
            Toast.makeText(getApplicationContext(), "Email", Toast.LENGTH_SHORT).show();
            return true;
        } else if (id == R.id.action_add) {
            Toast.makeText(getApplicationContext(), "Add", Toast.LENGTH_SHORT).show();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
