package com.example.asus.eighthapp.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.asus.eighthapp.ActionPersonListener;
import com.example.asus.eighthapp.Constant.Constant;
import com.example.asus.eighthapp.R;
import com.example.asus.eighthapp.models.PersonModel;

import java.util.List;

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    public List<PersonModel> list;
    Context context;
    ActionPersonListener actionPersonListener;

    public PersonAdapter (List<PersonModel> list, Context context){
        this.list = list;
        this.context = context;
        this.actionPersonListener = (ActionPersonListener) context;
    }

    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_contact, parent, false);
        PersonViewHolder holder = new PersonViewHolder(v, actionPersonListener);
        return holder;
    }

    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.setPersonModel(list.get(position));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }


    public void insert (int position,PersonModel personModel ){
        list.add(position, personModel);
        notifyItemInserted(position);
    }

    public void remove (PersonModel personModel){
        int position = list.indexOf(personModel);

        try {
            list.remove(position);
            notifyItemRemoved(position);
        } catch (IndexOutOfBoundsException e){
            Log.d(Constant.TAG, "IndexOutOfBondsExeptionCaught");
        }
    }

}
