package com.example.asus.eighthapp.recyclerview;


import android.graphics.Color;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.asus.eighthapp.ActionPersonListener;
import com.example.asus.eighthapp.R;
import com.example.asus.eighthapp.models.PersonModel;

public class PersonViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private CardView cardView;

    private ActionPersonListener actionPersonListener;
    private PersonModel personModel;

    private TextView vTextView;
    private Button vButton;

    // initialization elements
    public PersonViewHolder(View itemView, ActionPersonListener actionPersonListener) {
        super(itemView);
        this.actionPersonListener = actionPersonListener;

        cardView = (CardView) itemView.findViewById(R.id.card_view);
        vTextView = (TextView) itemView.findViewById(R.id.contact_name);
        vButton = (Button) itemView.findViewById(R.id.x_delete);
        //  setter on card
        cardView.setOnClickListener(this);
        vButton.setOnClickListener(this);
    }

        // color of card
    public void setPersonModel(PersonModel personModel){
        this.personModel = personModel;
        vTextView.setText(personModel.getFirstName());
        if (personModel.hasEmptyFields()){
            cardView.setCardBackgroundColor(Color.RED);
        }

    }

    // manage card click
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.x_delete:
                actionPersonListener.onClickDelete(personModel);
                break;
            case R.id.card_view:
                actionPersonListener.onClickOpen(personModel);
                break;
        }
    }
}
