package com.aad.termin19vezbanje.fragments;

import android.app.Fragment;
import android.app.NotificationManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.NotificationCompat;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RatingBar;
import android.widget.Spinner;
import android.widget.TextView;

import com.aad.termin19vezbanje.R;
import com.aad.termin19vezbanje.providers.CategoryProvider;
import com.aad.termin19vezbanje.providers.FruitProvider;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class DetailFragment extends Fragment {

    private static int NOTIFICATION_ID = 1;
    private int position = 0;

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        if(savedInstanceState != null){
            position = savedInstanceState.getInt("position", 0);
        }

        ImageView ivImage =  (ImageView) getView().findViewById(R.id.iv_image);
        InputStream is = null;
        try{
            is = getActivity().getAssets().open(FruitProvider.getFruitById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        }catch (IOException e){
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(FruitProvider.getFruitById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FruitProvider.getFruitById(position).getDescription());

        Spinner category = (Spinner)getView().findViewById(R.id.spinner_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FruitProvider.getFruitById(position).getCategory().getId());

        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FruitProvider.getFruitById(position).getRating());

        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();
            }
        });
    }

    private void showNotification(){
        NotificationCompat.Builder builder = new NotificationCompat.Builder(getActivity());
        Bitmap bitmap = BitmapFactory.decodeResource(getActivity().getResources(), R.drawable.ic_stat_buy);
        builder.setSmallIcon(R.drawable.ic_stat_buy);
        builder.setContentTitle("Item odered");
        builder.setContentText("The selected item has been ordered and will be shipped..");
        builder.setLargeIcon(bitmap);

        NotificationManager manager = (NotificationManager) getActivity().getSystemService(Context.NOTIFICATION_SERVICE);
        manager.notify(NOTIFICATION_ID, builder.build());


    }

    public void updateContent(final int position){
        this.position = position;
        Log.v("DetailFragment", "updateContent() sets position to " + position);

        ImageView ivImage = (ImageView) getView().findViewById(R.id.detail_view);
        InputStream is = null;

        try {
            is = getActivity().getAssets().open(FruitProvider.getFruitById(position).getImage());
            Drawable drawable = Drawable.createFromStream(is, null);
            ivImage.setImageDrawable(drawable);
        }catch (IOException e){
            e.printStackTrace();
        }

        TextView tvName = (TextView) getView().findViewById(R.id.tv_name);
        tvName.setText(FruitProvider.getFruitById(position).getName());

        TextView tvDescription = (TextView) getView().findViewById(R.id.tv_description);
        tvDescription.setText(FruitProvider.getFruitById(position).getDescription());

        Spinner category = (Spinner) getView().findViewById(R.id.spinner_category);
        List<String> categories = CategoryProvider.getCategoryNames();
        ArrayAdapter<String> adapter = new ArrayAdapter(getActivity(), android.R.layout.simple_spinner_item, categories);
        category.setAdapter(adapter);
        category.setSelection((int)FruitProvider.getFruitById(position).getCategory().getId());

        RatingBar rbRating = (RatingBar) getView().findViewById(R.id.rb_rating);
        rbRating.setRating(FruitProvider.getFruitById(position).getRating());

        FloatingActionButton btnBuy = (FloatingActionButton) getView().findViewById(R.id.btn_buy);
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showNotification();

            }
        });
    }
    public void setContent(final int position){
        this.position = position;
        Log.v("DetailFragment", "setContent() sets position to " + position);
    }


}
