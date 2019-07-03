package com.kuklinski.masteringandroid.samples;

import android.annotation.SuppressLint;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ProgressBar;

public class MyAsyncTask extends AsyncTask<Integer, Integer, Void> {

    ProgressBar pB;

    public MyAsyncTask(ProgressBar pB) {
        this.pB = pB;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        pB.setProgress(0);
    }

    @Override
    protected void onProgressUpdate(Integer... values) {
        super.onProgressUpdate(values);
        pB.setProgress(values[0]);

    }

//    @SuppressLint("WrongThread")
    @Override
    protected Void doInBackground(Integer... integers) {
        for (int i = 0; i <10; i++) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            onProgressUpdate(new Integer[]{i});
        }
        return null;
    }

    @Override
    protected void onPostExecute(Void o) {
        super.onPostExecute(o);
        Log.d("AsyncTask","Completed");
    }
}
