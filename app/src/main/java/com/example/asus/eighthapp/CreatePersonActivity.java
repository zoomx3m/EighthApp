package com.example.asus.eighthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.asus.eighthapp.Constant.Constant;
import com.example.asus.eighthapp.models.PersonModel;

public class CreatePersonActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText edText_first_name;
    private EditText edText_last_name;
    private EditText edText_gender;
    private EditText edText_age;
    private EditText edText_phone_number;
    private Button btn_button_create;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_person);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewElements();
        btn_button_create.setOnClickListener(this);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onClick(View v) {
        PersonModel personModel = new PersonModel();
        String firstName = edText_first_name.getText().toString();
        String lastName = edText_last_name.getText().toString();
        String gender = edText_gender.getText().toString();
        String age = edText_age.getText().toString();
        String phoneNumber = edText_phone_number.getText().toString();

         // manage button click
        if (TextUtils.isEmpty(firstName)){
            Toast.makeText(CreatePersonActivity.this, R.string.add_first_name, Toast.LENGTH_SHORT).show();
        } else {
            if (TextUtils.isEmpty(phoneNumber)){
                Toast.makeText(CreatePersonActivity.this,R.string.add_phone_number, Toast.LENGTH_SHORT).show();
            }else {
                personModel.setFirstName(firstName);
                personModel.setPhoneNumber(phoneNumber);

                if (!TextUtils.isEmpty(lastName));{
                    personModel.setLastName(lastName);
                }
                if (!TextUtils.isEmpty(gender));{
                    personModel.setGender(gender);
                }
                if (!TextUtils.isEmpty(age));{
                    personModel.setAge(age);
                }
                Intent intent = new Intent(CreatePersonActivity.this, MainActivity.class);
                intent.putExtra(Constant.PERSON_KEY, personModel);
                setResult(RESULT_OK, intent);
                finish();
            }
        }

    }

    private void initViewElements(){
    edText_first_name = (EditText)findViewById(R.id.first_name);
    edText_last_name = (EditText)findViewById(R.id.last_name);
    edText_gender = (EditText)findViewById(R.id.gender);
    edText_age = (EditText)findViewById(R.id.age);
    edText_phone_number = (EditText)findViewById(R.id.phone_number);
    btn_button_create = (Button) findViewById(R.id.button_create);
    }
}
