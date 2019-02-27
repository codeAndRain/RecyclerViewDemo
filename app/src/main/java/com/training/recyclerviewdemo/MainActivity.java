package com.training.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

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
        txtAddName = findViewById(R.id.add_name);
        txtAddAge = findViewById(R.id.add_age);
        txtAddGender = findViewById(R.id.add_gender);
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
        String name =txtAddName.getText().toString();
        int age;
        String gender = txtAddGender.getText().toString();
        String regExString = "^[0-9]*$";

        if(name.isEmpty()&& txtAddAge.getText().toString().isEmpty()&&gender.isEmpty()){
            Toast.makeText(this, "Please fill all the fields and try again!", Toast.LENGTH_SHORT).show();
        }else if (name.isEmpty()){
            Toast.makeText(this, "Please enter the name!", Toast.LENGTH_SHORT).show();
        }else if(txtAddAge.getText().toString().isEmpty()|| !txtAddAge.getText().toString().trim().matches(regExString)){
            Toast.makeText(this, "please enter the age!", Toast.LENGTH_SHORT).show();
        }else if(gender.isEmpty()){
            Toast.makeText(this, "Please enter the gender!", Toast.LENGTH_SHORT).show();

        }else{
            age = Integer.parseInt(txtAddAge.getText().toString());
            personList.add(topPos, new Person(name, age ,gender ));
            personsAdapter.notifyItemInserted(topPos);
            txtAddName.setText("");
            txtAddAge.setText("");
            txtAddGender.setText("");
            // scroll to the top of the list
            recyclerView.scrollToPosition(topPos);
        }
        
    }
}
