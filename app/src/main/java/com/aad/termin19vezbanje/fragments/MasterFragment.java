package com.aad.termin19vezbanje.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.aad.termin19vezbanje.R;
import com.aad.termin19vezbanje.adapters.FruitAdapter;
import com.aad.termin19vezbanje.providers.FruitProvider;

import java.util.List;

public class MasterFragment extends Fragment {


    public interface OnItemSelectedListener{
        public void onItemSelected(int position);
    }

    OnItemSelectedListener listener;



    @Override
    public void onActivityCreated( Bundle savedInstanceState) {

        super.onActivityCreated(savedInstanceState);

        final List<String> fruitNames = FruitProvider.getFruitNames();

        FruitAdapter dataAdapter = new FruitAdapter((OnItemSelectedListener) getActivity(), fruitNames);
        RecyclerView listView = (RecyclerView) getActivity().findViewById(R.id.list_of_fruits);
        listView.setLayoutManager(new LinearLayoutManager(getActivity()));
        listView.setAdapter(dataAdapter);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        if(container == null){
            return null;
        }
        View view = inflater.inflate(R.layout.fragment_master, container, false);

        return view;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try{
            listener = (OnItemSelectedListener)activity;

        }catch (ClassCastException e){
            throw new ClassCastException(activity.toString() + " must implement OnItemSelectedListener");
        }

    }
}
