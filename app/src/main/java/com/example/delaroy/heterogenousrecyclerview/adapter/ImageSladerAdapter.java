package com.example.delaroy.heterogenousrecyclerview.adapter;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.daimajia.slider.library.Animations.DescriptionAnimation;
import com.daimajia.slider.library.SliderLayout;
import com.daimajia.slider.library.SliderTypes.BaseSliderView;
import com.daimajia.slider.library.SliderTypes.TextSliderView;
import com.daimajia.slider.library.Tricks.ViewPagerEx;
import com.example.delaroy.heterogenousrecyclerview.ImageSlader;
import com.example.delaroy.heterogenousrecyclerview.R;
import com.example.delaroy.heterogenousrecyclerview.pojos.ImageSladerModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rohani-suhadi on 2/24/2018.
 */

public class ImageSladerAdapter extends RecyclerView.Adapter<ImageSladerAdapter.MyViewHolder> {

    private Context context;
    private ArrayList<ImageSladerModel> imageSladerArrayList = new ArrayList<>();

    public ImageSladerAdapter(Context context, ArrayList<ImageSladerModel> imageSladerArrayList) {
        this.context = context;
        this.imageSladerArrayList = imageSladerArrayList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_sleder_singgle_row, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        for (ImageSladerModel imageSlader : imageSladerArrayList) {

            TextSliderView textSliderView = new TextSliderView(context);
            textSliderView
                    .description(imageSlader.getName())
                    .image(imageSlader.getUrl())
                    .setScaleType(BaseSliderView.ScaleType.Fit);
            textSliderView.bundle(new Bundle());
            textSliderView.getBundle()
                    .putString("extra", imageSlader.getName());
            holder.sliderLayout.addSlider(textSliderView);
        }

        holder.sliderLayout.setPresetTransformer(SliderLayout.Transformer.Accordion);
        holder.sliderLayout.setPresetIndicator(SliderLayout.PresetIndicators.Center_Bottom);
        holder.sliderLayout.setCustomAnimation(new DescriptionAnimation());
        holder.sliderLayout.setDuration(3000);
        //holder.sliderLayout.addOnPageChangeListener(this);
    }

    @Override
    public int getItemCount() {
        return 1;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder  {

        SliderLayout sliderLayout;

        public MyViewHolder(View itemView) {

            super(itemView);
            sliderLayout = (SliderLayout) itemView.findViewById(R.id.sliderLayout);
        }
    }

}
