package com.kuklinski.masteringandroid.model;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.kuklinski.masteringandroid.R;

import java.util.List;

public class JobOfferList extends ArrayAdapter<JobOffer> {

    private Activity context;
    private List<JobOffer> jobOfferList;

    public JobOfferList(Activity context, List<JobOffer> jobOfferList) {
        super(context, R.layout.row_job_offer, jobOfferList);
        this.context = context;
        this.jobOfferList = jobOfferList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.row_job_offer, null, true);

        TextView textViewDesc = listViewItem.findViewById(R.id.rowJobOfferDesc);
        TextView textViewTitle = listViewItem.findViewById(R.id.rowJobOfferTitle);

        JobOffer jobOffer = jobOfferList.get(position);

        textViewDesc.setText(jobOffer.getDescription());
        textViewTitle.setText(jobOffer.getTittle());

        return listViewItem;
    }
}
