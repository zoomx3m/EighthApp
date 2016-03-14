package com.example.asus.eighthapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;

import com.example.asus.eighthapp.Constant.Constant;
import com.example.asus.eighthapp.models.PersonModel;
import com.example.asus.eighthapp.recyclerview.PersonAdapter;

import java.io.Serializable;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ActionPersonListener, Serializable {
    RecyclerView recyclView;
    PersonAdapter personAdapter;
    ArrayList<PersonModel> list = new ArrayList<PersonModel>();
    LinearLayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclView = (RecyclerView) findViewById(R.id.recyclerview);
        personAdapter = new PersonAdapter(list, this);
        recyclView.setAdapter(personAdapter);
        recyclView.setLayoutManager(new LinearLayoutManager(this));
    }

    // create new contact
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.add_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent = new Intent(this, CreatePersonActivity.class);
        startActivityForResult(intent, Constant.REQUEST_CODE);
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK){
            if (requestCode == Constant.REQUEST_CODE){
                PersonModel p = (PersonModel) data.getSerializableExtra(Constant.PERSON_KEY);
                int pos;
                pos = personAdapter.list.size();
                personAdapter.insert(pos, p);
            }
        }
    }
    // delete contact
    @Override
    public void onClickDelete(PersonModel personModel) {
        personAdapter.remove(personModel);
    }


    // open contact
    @Override
    public void onClickOpen(PersonModel personModel) {
        Intent intent = new Intent(this, ShowPersonActivity.class);
        intent.putExtra(Constant.PERSON_KEY,personModel);
        startActivity(intent);
    }
}
