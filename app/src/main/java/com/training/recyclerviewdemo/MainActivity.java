package com.training.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText txtAddName;
    private EditText txtAddAge;
    private EditText txtAddGender;
    private Button addPersonButton;
    private RecyclerView recyclerView;
    private PersonsAdapter personsAdapter;
    private List<Person> personList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.person_recycler_view);
        addPersonButton = findViewById(R.id.add_person_button);
        txtAddName=findViewById(R.id.add_name);
        txtAddAge=findViewById(R.id.add_age);
        txtAddGender=findViewById(R.id.add_gender);
        addPersonButton.setOnClickListener(this);
        personList.addAll(Person.getPersonsList());

        // Setup layout manager for items with orientation
        // Also supports `LinearLayoutManager.HORIZONTAL`
        LinearLayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);

        // Attach layout manager to recyclerView
        recyclerView.setLayoutManager(layoutManager);

        // Add divider using the item animator
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, layoutManager.getOrientation());
        recyclerView.addItemDecoration(dividerItemDecoration);

        // Attach the adapter to the recyclerView to populate the items
        personsAdapter = new PersonsAdapter(personList);
        recyclerView.setAdapter(personsAdapter);

    }

    @Override
    public void onClick(View view) {
        // add to the top of the list
        int topPos = 0;
        personList.add(topPos, new Person(txtAddName.getText().toString(),txtAddAge.length(),txtAddGender.getText().toString()));
        personsAdapter.notifyItemInserted(topPos);
        txtAddName.setText(" ");
        txtAddAge.setText(" ");
        txtAddGender.setText(" ");
        // scroll to the top of the list
        recyclerView.scrollToPosition(topPos);
    }
}
