package com.mtramin.devfestdatabinding.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.data.Speaker;
import com.mtramin.devfestdatabinding.databinding.ActivitySpeakersBinding;
import com.mtramin.devfestdatabinding.databinding.ItemSpeakerBinding;
import com.mtramin.devfestdatabinding.network.ApiClient;

import java.util.ArrayList;
import java.util.List;

import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;

public class SpeakersActivity extends AppCompatActivity {

    private ActivitySpeakersBinding binding;

    private SpeakersAdapter adapter;

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, SpeakersActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_speakers);

        adapter = new SpeakersAdapter();
        binding.speakerList.setAdapter(adapter);
        binding.speakerList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();

        ApiClient.getDevFestApiInstance().getSpeakers().enqueue(new Callback<List<Speaker>>() {
            @Override
            public void onResponse(Response<List<Speaker>> response, Retrofit retrofit) {
                adapter.setSpeakers(response.body());
            }

            @Override
            public void onFailure(Throwable t) {
                // Handle error
            }
        });
    }

    private class SpeakersAdapter extends RecyclerView.Adapter<SpeakerViewHolder> {

        private List<Speaker> speakers = new ArrayList<>();

        public void setSpeakers(List<Speaker> speakers) {
            this.speakers = speakers;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return this.speakers.size();
        }

        @Override
        public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ItemSpeakerBinding binding = ItemSpeakerBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);
            return new SpeakerViewHolder(binding.getRoot());

        }

        @Override
        public void onBindViewHolder(SpeakerViewHolder holder, int position) {
        }
    }

    private class SpeakerViewHolder extends RecyclerView.ViewHolder {
        ItemSpeakerBinding binding;

        public SpeakerViewHolder(View itemView) {
            super(itemView);
            binding = DataBindingUtil.bind(itemView);
        }
    }
}
