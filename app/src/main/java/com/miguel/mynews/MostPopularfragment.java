package com.miguel.mynews;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.miguel.mynews.Adapter.InfoCellAdapter;
import com.miguel.mynews.Models.MostPopular;
import com.miguel.mynews.Utils.CellInformationCalls;
import com.miguel.mynews.Utils.MyAsyncTask;
import com.miguel.mynews.Utils.MyHandlerThread;

import java.util.ArrayList;
import java.util.List;


public class MostPopularfragment extends Fragment implements CellInformationCalls.Callbacks, MyAsyncTask.Listeners {

    public String KEYLIST = "mostpopularArrayList";
    private MyHandlerThread handlerThread;
    private ProgressBar progressBar;

    public static MostPopularfragment newInstance() {
        MostPopularfragment frag1 = new MostPopularfragment();
        return(frag1);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View result = inflater.inflate(R.layout.mostpopular, container, false);
        RelativeLayout rootView = result.findViewById(R.id.relativelayout);
        this.progressBar = result.findViewById(R.id.mostpop_progress_bar);
        this.configureHandlerThread();
        startHandlerThread();
        executeHttpRequestWithRetrofit();

            Bundle bundle = new Bundle();
            List<MostPopular> mostpopularlist = (List<MostPopular>) bundle.getSerializable("KEYLIST");


            InfoCellAdapter mondapteur;
            RecyclerView recyclerView = result.findViewById(R.id.recycleview_view);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            mondapteur = new InfoCellAdapter(mostpopularlist);
            recyclerView.setAdapter(mondapteur);

        return result;
    }
    private void startAsyncTask() {
        new MyAsyncTask(this).execute();
    }

    @Override
    public void onResponse(@Nullable List<MostPopular> mostpopularList) {
        Toast.makeText(getContext(), "Sucess", Toast.LENGTH_LONG).show();
        Log.i("test", "blalba" + mostpopularList);
        ArrayList<MostPopular> mostpopularListArrayList = new ArrayList<>(mostpopularList);

        Bundle bundle = new Bundle();
        bundle.putSerializable(KEYLIST, mostpopularListArrayList);

    }

    @Override
    public void onFailure() {
        Toast.makeText(getContext(),"Failed", Toast.LENGTH_LONG).show();
        Log.i("test", "failed");

    }
    public void executeHttpRequestWithRetrofit(){
        CellInformationCalls.fetchMostPopularList(this);
    }

    private void configureHandlerThread(){
        handlerThread = new MyHandlerThread("MyAwesomeHanderThread", this.progressBar);
    }

    private void startHandlerThread(){
        handlerThread.startHandler();
    }

    @Override
    public void onDestroy() {
        // 3 - QUIT HANDLER THREAD (Free precious resources)
        handlerThread.quit();
        super.onDestroy();
    }


    @Override
    public void onPreExecute() {
        progressBar.setVisibility(View.VISIBLE);

    }

    @Override
    public void doInBackground() {

    }

    @Override
    public void onPostExecute(Long success) {
        progressBar.setVisibility(View.INVISIBLE);

    }
}