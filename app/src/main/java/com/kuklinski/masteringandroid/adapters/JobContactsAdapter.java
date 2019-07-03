package com.kuklinski.masteringandroid.adapters;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.holders.CompanyViewHolder;
import com.kuklinski.masteringandroid.holders.CountryViewHolder;
import com.kuklinski.masteringandroid.model.Country;
import com.kuklinski.masteringandroid.model.JobContact;

import java.util.List;

public class JobContactsAdapter extends BaseAdapter {

    private List<Object> aList;
    private Context jContext;

    public JobContactsAdapter(List<Object> aList, Context jContext) {
        this.aList = aList;
        this.jContext = jContext;
    }

    @Override
    public int getCount() {
        return aList.size();
    }

    @Override
    public Object getItem(int i) {
        return aList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public int getItemViewType(int position) {
        return aList.get(position) instanceof Country ? 0 : 1;
    }

    @Override
    public int getViewTypeCount() {
        return 2;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        switch (getItemViewType(i)) {
            case (0):
                CountryViewHolder holderCountry;
                if (view == null) {
                    view = View.inflate(jContext, R.layout.row_job_country, null);
                    holderCountry = new CountryViewHolder(view);
                    view.setTag(view);
                } else {
                    holderCountry = (CountryViewHolder) view.getTag();
                }
                holderCountry.bindView((Country) aList.get(i), jContext);
                break;

            case 1:
                CompanyViewHolder holderCompany;
                if (view == null) {
                    view = View.inflate(jContext, R.layout.row_job_contact, null);
                    holderCompany = new CompanyViewHolder(view);
                    view.setTag(view);
                } else {
                    holderCompany = (CompanyViewHolder) view.getTag();
                }
                holderCompany.bindView((JobContact) aList.get(i));

        }

        return view;


    }
}
