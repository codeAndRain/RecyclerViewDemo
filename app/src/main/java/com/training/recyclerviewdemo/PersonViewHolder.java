package com.training.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

class PersonViewHolder extends RecyclerView.ViewHolder {

    TextView nameTextView;
    TextView ageTextView;
    TextView genderTextView;

    public PersonViewHolder(@NonNull View itemView) {
        super(itemView);
        nameTextView = itemView.findViewById(R.id.name_text_view);
        ageTextView = itemView.findViewById(R.id.age_text_view);
        genderTextView = itemView.findViewById(R.id.gender_text_view);
    }

    public void bind(Person person) {
        nameTextView.setText(person.getName());
        ageTextView.setText(String.valueOf(person.getAge()));
        genderTextView.setText(person.getGender());
    }
}
