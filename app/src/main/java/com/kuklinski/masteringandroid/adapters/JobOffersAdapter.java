package com.kuklinski.masteringandroid.adapters;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.activities.OfferDetailActivity;
import com.kuklinski.masteringandroid.model.JobOffer;

import java.util.List;

public class JobOffersAdapter extends RecyclerView.Adapter<JobOffersAdapter.MyViewHolder> {

    private List<JobOffer> mOfferList;

    public JobOffersAdapter(List<JobOffer> mOfferList) {
        this.mOfferList = mOfferList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_job_offer, parent, false);
        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.textViewName.setText(mOfferList.get(position).getTittle());
        holder.textViewDescription.setText(mOfferList.get(position).getDescription());
    }

    @Override
    public int getItemCount() {
        return mOfferList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener{

        public TextView textViewName;
        public TextView textViewDescription;

        public MyViewHolder(View view) {
            super(view);
            textViewName = view.findViewById(R.id.rowJobOfferTitle);
            textViewDescription = view.findViewById(R.id.rowJobOfferDesc);
            textViewName.setOnClickListener(this);
            view.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            Intent intent = new Intent(view.getContext(), OfferDetailActivity.class);
            JobOffer selectedJobOffer = mOfferList.get(getLayoutPosition());
            intent.putExtra("job_title", selectedJobOffer.getTittle());
            intent.putExtra("job_description",selectedJobOffer.
                    getDescription());
            intent.putExtra("job_image", selectedJobOffer.getImageLink());
            view.getContext().startActivity(intent);
        }

        @Override
        public boolean onLongClick(View view) {
            mOfferList.remove(getLayoutPosition());
            notifyItemRemoved(getLayoutPosition());
            return false;
        }
    }


}
