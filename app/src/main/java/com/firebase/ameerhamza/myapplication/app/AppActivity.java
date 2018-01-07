package com.firebase.ameerhamza.myapplication.app;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.view.MenuItemCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.SearchView;

import com.firebase.ameerhamza.myapplication.Fragments.AllDonorFragments;
import com.firebase.ameerhamza.myapplication.Fragments.BloodBank;
import com.firebase.ameerhamza.myapplication.Fragments.Third;
import com.firebase.ameerhamza.myapplication.R;
import com.firebase.ameerhamza.myapplication.adapter.DonorListAdapter;
import com.firebase.ameerhamza.myapplication.adapter.TabsAdapter;
import com.firebase.ameerhamza.myapplication.models.AllDonorInformation;
import com.firebase.ameerhamza.myapplication.models.User;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

public class AppActivity extends AppCompatActivity {

    StringBuilder token = new StringBuilder("Bearer ");
    private List<Fragment> fragmentList = new ArrayList<>();
    private List<String> titleList = new ArrayList<>();
    private ViewPager viewPager;
    private TabsAdapter adapter;
    private TabLayout tabLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);

        Intent intent = getIntent();
        token.append(intent.getStringExtra("token"));
        EventBus.getDefault().post(token.toString());
        initialize();
        prepareDataResource();
        adapter = new TabsAdapter(getSupportFragmentManager(), fragmentList, titleList);
        viewPager.setAdapter(adapter);
        tabLayout.setupWithViewPager(viewPager);
    }

    private void initialize() {
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        toolbar.setTitle("Blood Bank");
        viewPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabs);
    }


    private void prepareDataResource() {
        addData(new AllDonorFragments(), "Donor");
        addData(new BloodBank(), "Blood Bank");
        addData(new Third(), "Third");
    }

    private void addData(Fragment fragment, String title) {
        fragmentList.add(fragment);
        titleList.add(title);
    }
}
