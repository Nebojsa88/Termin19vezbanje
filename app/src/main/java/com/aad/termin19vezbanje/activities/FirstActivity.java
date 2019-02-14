package com.aad.termin19vezbanje.activities;


import android.app.FragmentTransaction;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;


import com.aad.termin19vezbanje.R;
import com.aad.termin19vezbanje.fragments.DetailFragment;
import com.aad.termin19vezbanje.fragments.MasterFragment;

public class FirstActivity extends AppCompatActivity implements MasterFragment.OnItemSelectedListener {



    private boolean landscapeMode = false;
    private boolean masterShown = false;
    private boolean detailShown = false;
    private int itemId;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        //toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        final android.support.v7.app.ActionBar actionBar = getSupportActionBar();
        //toolbar
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(R.drawable.ic_action_drawer);
            actionBar.setHomeButtonEnabled(true);
            actionBar.show();
        }

        itemId = 0;

        if (savedInstanceState == null) {
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            MasterFragment masterFragment = new MasterFragment();
            ft.add(R.id.master_card_view, masterFragment, "Master_fragment_1");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
        }

        if (findViewById(R.id.detail_view) != null) {
            landscapeMode = true;
            getFragmentManager().popBackStack();


            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            if (detailFragment == null) {
                FragmentTransaction ft = getFragmentManager().beginTransaction();
                detailFragment = new DetailFragment();
                ft.replace(R.id.detail_view, detailFragment, "Detail_fragment1");
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
                detailShown = true;

            }
        }
        masterShown = true;
        detailShown = false;
        itemId = 0;

    }

    @Override
    public void onItemSelected(int id) {

        itemId = id;

        if(landscapeMode){
            DetailFragment detailFragment = (DetailFragment) getFragmentManager().findFragmentById(R.id.detail_view);
            detailFragment.updateContent(id);
        }else {
            DetailFragment detailFragment = new DetailFragment();
            detailFragment.setContent(id);
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.master_card_view, detailFragment, "Detail_fragment2");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.addToBackStack(null);
            ft.commit();

            masterShown = false;
            detailShown = true;

        }

    }
    @Override
    public void onBackPressed() {

        if(landscapeMode){
            finish();
        } else if(masterShown == true){
            finish();
        }else if (detailShown == true){
            getFragmentManager().popBackStack();
            MasterFragment masterFragment = new MasterFragment();
            FragmentTransaction ft = getFragmentManager().beginTransaction();
            ft.replace(R.id.master_card_view, masterFragment, "Master_fragment");
            ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            ft.commit();
            masterShown = true;
            detailShown = false;
        }
    }


}
