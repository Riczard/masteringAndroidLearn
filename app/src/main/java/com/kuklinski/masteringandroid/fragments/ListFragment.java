package com.kuklinski.masteringandroid.fragments;


import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.adapters.JobOffersAdapter;
import com.kuklinski.masteringandroid.model.JobOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment {

    public List<JobOffer> mListItems;
    public RecyclerView mRecyclerView;
    private SwipeRefreshLayout mSwipeRefreshLayout;

    public ListFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_list, container, false);
        mRecyclerView = view.findViewById(R.id.my_recycler_view);

        // use this setting to improve performance if you know that changes
        // in content do not change the layout size of the RecyclerView
        mRecyclerView.setHasFixedSize(true);

        mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        retrieveJobOffers();

        mSwipeRefreshLayout = view.findViewById(R.id.swipeRefreshLayout);
        mSwipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                retrieveJobOffers();
            }
        });

        return view;
    }

    private void retrieveJobOffers() {

        DatabaseReference databaseJobs = FirebaseDatabase.getInstance().getReference("contact");
        databaseJobs.keepSynced(true);
        databaseJobs.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                mListItems = new ArrayList<>();
                for (DataSnapshot jobSnapshot : dataSnapshot.getChildren()) {
                    JobOffer jobOffer = jobSnapshot.getValue(JobOffer.class);
                    mListItems.add(jobOffer);
                }
                JobOffersAdapter adapter = new JobOffersAdapter(mListItems);
                mRecyclerView.setAdapter(adapter);
                mSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


}
