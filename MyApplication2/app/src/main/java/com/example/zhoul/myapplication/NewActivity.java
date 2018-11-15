package com.example.zhoul.myapplication;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;


public class NewActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new);
        Intent intent=getIntent();
        Bundle bundle=intent.getExtras();                               //获取一个句柄
        TextView textView = (TextView)findViewById(R.id.showName);
        textView.setText(bundle.getString("username"));                //通过key值为“username”来获取value
        TextView textView1 = (TextView)findViewById(R.id.showPassword);
        textView1.setText(bundle.getString("password"));
        TextView textView2 = (TextView)findViewById(R.id.showSex);
        textView2.setText(bundle.getString("sex"));
        TextView textView3 = (TextView)findViewById(R.id.showHobby);
        textView3.setText(bundle.getString("hobby"));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_new, menu);
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
