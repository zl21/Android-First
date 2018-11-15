package com.example.zhoul.myapplication;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import java.math.MathContext;
import java.util.Arrays;
import java.util.List;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button)findViewById(R.id.button);
        final EditText username = (EditText)findViewById(R.id.editText1);
        final EditText password = (EditText)findViewById(R.id.editText2);
        final RadioGroup sex = (RadioGroup)findViewById(R.id.radioGroup);
        CheckBox g = (CheckBox)findViewById(R.id.cb1);
        CheckBox b = (CheckBox)findViewById(R.id.cb2);
        CheckBox s = (CheckBox)findViewById(R.id.cb3);
        final List<CheckBox>checkBoxList = Arrays.asList(g,b,s);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //判断并获取性别
                String a = "";
                for (int i = 0 ; i < sex.getChildCount();i++) {
                    RadioButton radioButton = (RadioButton)sex.getChildAt(i);
                    if (radioButton.isChecked()) {
//                            Toast toast = Toast.makeText(MainActivity.this, radioButton.getText(), Toast.LENGTH_LONG);
//                        toast.show();
                        a = radioButton.getText().toString();
                        break;
                    }
                }
                //获取爱好
                String c = "";
                for(CheckBox checkBox:checkBoxList) {
                    if (checkBox.isChecked()) {
                        c+= checkBox.getText().toString();
                    }
                }

                Log.i("into",username.getText().toString() + password.getText().toString() + a + c);
                Intent intent=new Intent(MainActivity.this,NewActivity.class);
                Bundle bundle = new Bundle();   //数据传递句柄
                bundle.putString("username", username.getText().toString());
                bundle.putString("password", password.getText().toString());
                bundle.putString("sex", a);
                bundle.putString("hobby", c);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
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
