package com.example.acer.plnwunderlist;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.zip.Inflater;

/**
 * Created by Ryan Fadholi on 20/07/2017.
 */

public class MainMenuActivity extends AppCompatActivity {

    private static final String TAG = "MainMenuActivity";
    private ArrayList<String> todoLists = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu);

        ListView todoListsList = (ListView) findViewById(R.id.todolistslist);
        todoListsList.setDivider(null);
        todoListsList.setDividerHeight(0);
        todoLists.add("Kerjaan");
        todoLists.add("Gawean");
        todoLists.add("Lokak");
        todoLists.add("Belajar");

        todoListAdapter adapter = new todoListAdapter(this, todoLists);
        todoListsList.setAdapter(adapter);

        View layout = getLayoutInflater().inflate(R.layout.main_menu_create_list_btn,null);
        todoListsList.addFooterView(layout);


        Button newListBtn = (Button) findViewById(R.id.add_list_btn);
        newListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainMenuActivity.this, "Add a new list", Toast.LENGTH_SHORT).show();
                showAddListDialog(MainMenuActivity.this);
            }
        });

        TextView emptyListText = new TextView(this);
        emptyListText.setText(R.string.emptyList_Text);
        emptyListText.setTextSize(TypedValue.COMPLEX_UNIT_SP,20);
        if(todoLists.size() == 0){
            emptyListText.setGravity(Gravity.CENTER_HORIZONTAL);
            todoListsList.addHeaderView(emptyListText);
        }

    }

    private void addNewList(String newListName){
        todoLists.add(newListName);
    }

    private void showAddListDialog(Context context){
        final AlertDialog.Builder addListBuilder = new AlertDialog.Builder(context);
        LayoutInflater inflater = LayoutInflater.from(context);
        final View addListDialogView = inflater.inflate(R.layout.main_menu_create_list_dialog, null);
        addListBuilder.setView(addListDialogView);

        addListBuilder.setTitle("Create New To-Do List");
        addListBuilder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText newListText = (EditText) addListDialogView.findViewById(R.id.newListTitleText);
                addNewList(newListText.getText().toString());
            }
        });
        addListBuilder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
            }
        });

        AlertDialog newList = addListBuilder.create();
        newList.show();

        Toast.makeText(MainMenuActivity.this, "Should've quicker!", Toast.LENGTH_SHORT).show();
    }
}
