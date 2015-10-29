package com.mtramin.devfestdatabinding.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.mtramin.devfestdatabinding.R;
import com.mtramin.devfestdatabinding.data.AndroidVersion;
import com.mtramin.devfestdatabinding.util.AndroidVersionUtil;

import java.util.ArrayList;
import java.util.List;

public class VersionListActivity extends AppCompatActivity {

    private SpeakersAdapter adapter;

    public static Intent createIntent(Activity activity) {
        return new Intent(activity, VersionListActivity.class);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_version_list);

        adapter = new SpeakersAdapter();
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.speaker_list);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
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
            View root = inflater.inflate(R.layout.item_android_version, parent, false);
            return new SpeakerViewHolder(root);

        }

        @Override
        public void onBindViewHolder(SpeakerViewHolder holder, int position) {
            holder.setAndroidVersion(this.androidVersions.get(position));
        }
    }

    private class SpeakerViewHolder extends RecyclerView.ViewHolder {

        private View root;
        private ImageView image;
        private TextView name;
        private TextView apiLevel;
        private TextView releaseDate;

        public SpeakerViewHolder(View itemView) {
            super(itemView);

            root = itemView;

            image = (ImageView) itemView.findViewById(R.id.version_image);
            name = (TextView) itemView.findViewById(R.id.version_name);
            apiLevel = (TextView) itemView.findViewById(R.id.version_api_level);
            releaseDate = (TextView) itemView.findViewById(R.id.version_release);
        }

        public void setAndroidVersion(AndroidVersion version) {
            Glide.with(image.getContext())
                    .load(version.getImageUrl())
                    .error(R.drawable.ic_error)
                    .into(image);

            name.setText(version.name);
            apiLevel.setText(apiLevel.getContext().getString(R.string.version, version.versionCode, version.apiLevel));
            releaseDate.setText(apiLevel.getContext().getString(R.string.released, version.releaseDate));

            if (AndroidVersionUtil.isCurrent(version.apiLevel)) {
                root.setBackgroundColor(root.getContext().getResources().getColor(R.color.green));
            } else {
                root.setBackgroundColor(root.getContext().getResources().getColor(R.color.white));
            }
        }
    }
}
