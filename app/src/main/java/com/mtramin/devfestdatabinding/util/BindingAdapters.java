package com.mtramin.devfestdatabinding.util;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

/**
 * Created by marvi on 10/24/2015.
 */
public class BindingAdapters {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String url) {
        Glide.with(view.getContext())
                .load(url)
                .asBitmap()
                .into(view);
    }

    @BindingAdapter({"bind:imageUrl", "bind:errorDrawable"})
    public static void loadImage(ImageView view, String url, Drawable errorDrawable) {
        Glide.with(view.getContext())
                .load(url)
                .asBitmap()
                .error(errorDrawable)
                .into(view);
    }

    @BindingAdapter("android:paddingLeft")
    public static void trollPadding(View view, int padding) {
        view.setPadding(
                view.getPaddingLeft(),
                view.getPaddingTop(),
                padding,
                view.getPaddingBottom()
        );
    }
}
