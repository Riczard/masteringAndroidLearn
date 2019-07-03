package com.kuklinski.masteringandroid.holders;

import android.view.View;
import android.widget.TextView;

import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.model.JobContact;

public class CompanyViewHolder {

    private TextView name;
    private TextView email;
    private TextView desc;

    public CompanyViewHolder(View view) {
        this.name = view.findViewById(R.id.rowJobContactName);
        this.email = view.findViewById(R.id.rowJobContactEmail);
        this.desc = view.findViewById(R.id.rowJobContactDesc);
    }

    public void bindView(JobContact company) {
        this.name.setText(company.getName());
        this.email.setText(company.getEmail());
        this.desc.setText(company.getDescription());
    }
}
