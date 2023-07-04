package com.example.sadcamp.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sadcamp.CallAdapter;
import com.example.sadcamp.ContactData;
import com.example.sadcamp.NewContactActivity;
import com.example.sadcamp.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class CallFragment extends Fragment {

    private static final String TAG = "CallFragment";

    private RecyclerView recyclerView;
    private CallAdapter adapter;
    ArrayList<ContactData> data = new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_call, container, false);

        FloatingActionButton fabAddContact = rootView.findViewById(R.id.fab_add_contact);
        fabAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                return;
            }
        });
        recyclerView = (RecyclerView) rootView.findViewById(R.id.recyclerview);

        data.add(new ContactData("신민영","010-5127-6448",R.drawable.shin));
        data.add(new ContactData("Test","010-5413-6410",R.drawable.b));

        adapter = new CallAdapter(getActivity(), data);

        Log.d(TAG, "array constructed");

        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(adapter);

        return rootView;
    }
}