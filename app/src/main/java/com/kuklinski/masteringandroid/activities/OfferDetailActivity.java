package com.kuklinski.masteringandroid.activities;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.ImageRequest;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.kuklinski.masteringandroid.MAApplication;
import com.kuklinski.masteringandroid.R;
import com.kuklinski.masteringandroid.utils.ImageUtils;

import java.util.BitSet;

public class OfferDetailActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_offer_detail);

        final Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        String job_title = getIntent().getStringExtra("job_title");

        CollapsingToolbarLayout collapsingToolbar = findViewById(R.id.collapsingtoolbar);
        collapsingToolbar.setTitle(job_title);

        String imageLink = getIntent().getStringExtra("job_image");
        ImageView imageViewLogo = findViewById(R.id.logo);

//        displayImageFromUrl(imageViewLogo, imageLink);
        displayImageWithVolley(imageViewLogo, imageLink);

    }

    private void displayImageFromUrl(final ImageView imageView, final String link) {
        new AsyncTask<Object, Void, Bitmap>() {

            ImageView imageView;
            String link;

            @Override
            protected Bitmap doInBackground(Object... objects) {
                imageView = (ImageView) objects[0];
                link = (String) objects[1];
                return ImageUtils.getImage(link);
            }

            @Override
            protected void onPostExecute(Bitmap bitmap) {
                super.onPostExecute(bitmap);
                imageView.setImageBitmap(bitmap);
            }
        }.execute(imageView, link);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayImageWithVolley(final ImageView imageView, String url) {
        ImageRequest request = new ImageRequest(url, new Response.Listener<Bitmap>() {
            @Override
            public void onResponse(Bitmap response) {
                imageView.setImageBitmap(response);
            }
        }, 0, 0, null,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                });
        MAApplication.getInstance().getRequestQueue().add(request);
    }

}
