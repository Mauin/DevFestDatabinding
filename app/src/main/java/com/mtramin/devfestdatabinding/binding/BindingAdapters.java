package com.mtramin.devfestdatabinding.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
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
                .into(view);
    }

    @BindingAdapter({"bind:imageUrl", "bind:errorDrawable"})
    public static void loadImage(ImageView view, String url, Drawable errorDrawable) {
        Glide.with(view.getContext())
                .load(url)
                .error(errorDrawable)
                .into(view);
    }
}
