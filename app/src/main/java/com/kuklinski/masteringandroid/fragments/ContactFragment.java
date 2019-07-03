package com.kuklinski.masteringandroid.fragments;


import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.kuklinski.masteringandroid.adapters.JobContactsAdapter;
import com.kuklinski.masteringandroid.model.Country;
import com.kuklinski.masteringandroid.model.JobContact;
import com.kuklinski.masteringandroid.model.JobOffer;
import com.kuklinski.masteringandroid.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactFragment extends ListFragment {


    List<Object> jobContactList;

    public ContactFragment() {
        // Required empty public constructor
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        retrieveJobContacts();
    }

//    @Override
//    public View onCreateView(LayoutInflater inflater, ViewGroup container,
//                             Bundle savedInstanceState) {
//        // Inflate the layout for this fragment
//
//        View view = inflater.inflate(R.layout.fragment_contact, container, false);
//        view.findViewById(R.id.addJobOffer).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//                FirebaseDatabase database = FirebaseDatabase.getInstance();
//                DatabaseReference myRef = database.getReference("contact");
//
//                String id = myRef.push().getKey();
//                JobOffer jobOffer = getJobOffer(id);
//                myRef.child(id).setValue(jobOffer);
//            }
//        });
//        return view;
//    }


    private void retrieveJobContacts() {
        DatabaseReference dbJobContacts = FirebaseDatabase.getInstance().getReference("JobContact");
        dbJobContacts.keepSynced(true);
        Query query = dbJobContacts.orderByChild("country");

        query.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                jobContactList = new ArrayList<>();

                if(dataSnapshot.exists()) {
                    String currentCountry = "";
                    for(DataSnapshot db : dataSnapshot.getChildren()) {
                        JobContact jobContact = db.getValue(JobContact.class);
                        if(!currentCountry.equals(jobContact.getCountry())){
                            currentCountry = jobContact.getCountry();
                            jobContactList.add(new Country(currentCountry));
                        }

                        jobContactList.add(jobContact);
                    }
                    setListAdapter(new JobContactsAdapter(jobContactList, getActivity()));
                }

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
