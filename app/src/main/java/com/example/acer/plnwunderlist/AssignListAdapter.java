package com.example.acer.plnwunderlist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by rynfd on 8/28/2017.
 */

public class AssignListAdapter extends ArrayAdapter<User> {

    public AssignListAdapter(@NonNull Context context,
                             @NonNull List<User> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.task_details_assign_dialog_list, parent, false);
        }

        // Get the {@link Word} object located at this position in the list
        User currentUser = getItem(position);
        String currentUserName = currentUser.getName();
        String currentUserEmail = currentUser.getEmail();

        // Find the TextView in the main_menu_list.xml layout with the ID ListTitle
        TextView nameView = (TextView) listItemView.findViewById(R.id.txtRealName);
        TextView emailView = (TextView) listItemView.findViewById(R.id.txtEmail);

        // Get the list title from the current object and
        // set this text on the name TextView
        nameView.setText(currentUserName);
        emailView.setText(currentUserEmail);

        // Return the whole list item layout (containing an ImageView and a TextView)
        // so that it can be shown in the ListView
        return listItemView;
    }

}
