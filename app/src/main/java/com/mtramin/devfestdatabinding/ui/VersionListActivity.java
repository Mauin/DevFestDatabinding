package com.mtramin.devfestdatabinding.ui;

import android.app.Activity;
import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.data.AndroidVersion;
import com.mtramin.devfestdatabinding.databinding.ActivityVersionListBinding;
import com.mtramin.devfestdatabinding.databinding.ItemAndroidVersionBinding;
import com.mtramin.devfestdatabinding.util.AndroidVersionUtil;

import java.util.ArrayList;
import java.util.List;

public class VersionListActivity extends AppCompatActivity {

    private ActivityVersionListBinding binding;

    private SpeakersAdapter adapter;

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, VersionListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_version_list);

        adapter = new SpeakersAdapter();
        binding.speakerList.setAdapter(adapter);
        binding.speakerList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    @Override
    protected void onResume() {
        super.onResume();

        adapter.setAndroidVersions(AndroidVersionUtil.createVersionList());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.add) {
            launchAddActivity();
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    private void launchAddActivity() {
        startActivity(AddVersionActivity.createIntent(this));
    }

    private class SpeakersAdapter extends RecyclerView.Adapter<SpeakerViewHolder> {

        private List<AndroidVersion> androidVersions = new ArrayList<>();

        public void setAndroidVersions(List<AndroidVersion> androidVersions) {
            this.androidVersions = androidVersions;
            notifyDataSetChanged();
        }

        @Override
        public int getItemCount() {
            return this.androidVersions.size();
        }

        @Override
        public SpeakerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            LayoutInflater inflater = LayoutInflater.from(parent.getContext());
            ItemAndroidVersionBinding binding = ItemAndroidVersionBinding.inflate(inflater, parent, false);
            return new SpeakerViewHolder(binding);

        }

        @Override
        public void onBindViewHolder(SpeakerViewHolder holder, int position) {
            holder.binding.setAndroidVersion(this.androidVersions.get(position));
        }
    }

    private class SpeakerViewHolder extends RecyclerView.ViewHolder {
        ItemAndroidVersionBinding binding;

        public SpeakerViewHolder(ItemAndroidVersionBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
