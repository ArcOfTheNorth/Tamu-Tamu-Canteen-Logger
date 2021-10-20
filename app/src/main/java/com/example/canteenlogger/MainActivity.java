package com.example.canteenlogger;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ArrayAdapter arrayAdapter;

    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        setTitle("Student Query Selection");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText theFilter = (EditText) findViewById(R.id.searchFilter);
        listView =  (ListView) findViewById(R.id.nameListView);

        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Toby");
        arrayList.add("Andy");
        arrayList.add("Jane");
        arrayList.add("Ian");
        arrayList.add("Nate");
        arrayList.add("Taylor");
        arrayList.add("Anthony");
        arrayList.add("Ted");
        arrayList.add("Bob");
        arrayList.add("Ben");

        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList);
        listView.setAdapter(arrayAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int i, long id) {
                Toast.makeText(MainActivity.this, "clicked item: " + i + " " + arrayList.get(i).toString(), Toast.LENGTH_SHORT).show();
            }

        });

        theFilter.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int start, int before, int count) {
                (MainActivity.this).arrayAdapter.getFilter().filter(charSequence);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

    }
}
