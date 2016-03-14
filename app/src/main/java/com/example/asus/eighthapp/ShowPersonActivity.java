package com.example.asus.eighthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.example.asus.eighthapp.Constant.Constant;
import com.example.asus.eighthapp.models.PersonModel;

public class ShowPersonActivity extends AppCompatActivity {
    TextView txView_first_name;
    TextView txView_last_name;
    TextView txView_gender;
    TextView txView_age;
    TextView txView_phone_number;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_person);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        initViewElements();
        Intent intent = getIntent();
        PersonModel person = (PersonModel)intent.getSerializableExtra(Constant.PERSON_KEY);
        setInfoFromPerson(person);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
            onBackPressed();
        return super.onOptionsItemSelected(item);
    }

    // reading and set info about contact
    private void initViewElements() {
        txView_first_name =(TextView)findViewById(R.id.first_TV);
        txView_last_name = (TextView)findViewById(R.id.last_TV);
        txView_gender = (TextView)findViewById(R.id.gender_TV);
        txView_age = (TextView)findViewById(R.id.age_TV);
        txView_phone_number = (TextView)findViewById(R.id.phone_number_TV);
    }

    private void setInfoFromPerson(PersonModel personModel) {
        txView_first_name.setText(personModel.getFirstName());
        txView_last_name.setText(personModel.getLastName());
        txView_gender.setText(personModel.getGender());
        txView_age.setText(personModel.getAge());
        txView_phone_number.setText(personModel.getPhoneNumber());
    }
}
