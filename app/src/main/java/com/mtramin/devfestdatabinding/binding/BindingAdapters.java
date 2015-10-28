package com.mtramin.devfestdatabinding.binding;

import android.databinding.BindingAdapter;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.mtramin.devfestdatabinding.R;

/**
 * Created by marvi on 10/24/2015.
 */
public class BindingAdapters {

    @BindingAdapter("bind:imageUrl")
    public static void loadImage(ImageView view, String url) {
        view.setBackgroundColor(ContextCompat.getColor(view.getContext(), R.color.colorPrimary));
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
//
//    @BindingAdapter("android:paddingLeft")
//    public static void trollPadding(View view, int padding) {
//        view.setPadding(
//                view.getPaddingLeft(),
//                view.getPaddingTop(),
//                padding,
//                view.getPaddingBottom()
//        );
//    }
}
