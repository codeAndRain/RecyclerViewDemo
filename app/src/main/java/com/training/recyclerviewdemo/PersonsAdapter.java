package com.training.recyclerviewdemo;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class PersonsAdapter extends RecyclerView.Adapter<PersonViewHolder> {

    private List<Person> personList;

    public PersonsAdapter(List<Person> personList) {
        this.personList = personList;
    }

    @NonNull
    @Override
    public PersonViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        // Inflate the custom layout
        LayoutInflater layoutInflater = LayoutInflater.from(viewGroup.getContext());
        View view = layoutInflater.inflate(R.layout.list_item_layout, viewGroup, false);

        // Return a new holder instance
        return(new PersonViewHolder(view));
    }

    @Override
    public void onBindViewHolder(@NonNull PersonViewHolder personViewHolder, int position) {
        // Get the data model based on position
        Person person = personList.get(position);
        personViewHolder.bind(person);
    }

    @Override
    public int getItemCount() {
        return personList != null ? personList.size() : 0;
    }
}
