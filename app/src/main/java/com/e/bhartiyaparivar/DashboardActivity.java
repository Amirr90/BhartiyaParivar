package com.e.bhartiyaparivar;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.e.bhartiyaparivar.adapters.NavAdapter;
import com.e.bhartiyaparivar.databinding.ActivityDashboardBinding;
import com.e.bhartiyaparivar.interfaces.NavigationInterface;
import com.e.bhartiyaparivar.model.NavModel;

import java.util.ArrayList;
import java.util.List;

public class DashboardActivity extends AppCompatActivity implements NavigationInterface {
    ActivityDashboardBinding activityDashboardBinding;

    NavAdapter navAdapter;
    List<NavModel> navModels = new ArrayList<>();


    public static DashboardActivity instance;

    public static DashboardActivity getInstance() {
        return instance;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityDashboardBinding = DataBindingUtil.setContentView(this, R.layout.activity_dashboard);
        instance = this;
    }


    @Override
    protected void onStart() {
        super.onStart();

        setNavRec();

    }

    private void setNavRec() {
        navAdapter = new NavAdapter(navModels, this);
        activityDashboardBinding.recNavSideMenu.setAdapter(navAdapter);
        loadNavData();
    }

    private void loadNavData() {
        navModels.clear();
        navModels.add(new NavModel(getString(R.string.profile), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.donate), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.join_us), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.about_us), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.contact_us), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.choose_language), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.advertisement), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.notification), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.dark_mode), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.share_app), R.drawable.ic_baseline_person_24));
        navModels.add(new NavModel(getString(R.string.frequently_ask), R.drawable.ic_baseline_person_24));
        navAdapter.notifyDataSetChanged();

    }

    @Override
    public void onNavigationItemClicked(Object obj) {

    }
}