package com.app.io21task.presentation.home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.app.io21task.R;
import com.app.io21task.databinding.FragmentLoginBinding;
import com.app.io21task.databinding.FragmentTabsBinding;
import com.app.io21task.presentation.home.tabs.ARFragment;
import com.app.io21task.presentation.home.tabs.HomeTabFragment;
import com.app.io21task.presentation.home.tabs.MoreFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class TabsFragment extends Fragment {

    final Fragment fragment1 = new ARFragment();
    final Fragment fragment2 = new HomeTabFragment();
    final Fragment fragment3 = new MoreFragment();
    FragmentManager fm;
    private FragmentTabsBinding binding;
    Fragment active = fragment1;

    public TabsFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        binding = FragmentTabsBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        fm = getChildFragmentManager();
        initBottomNav();
    }

    private void initBottomNav() {
        binding.navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        fm.beginTransaction().add(R.id.tabs_main_container, fragment3, "3").hide(fragment3).commit();
        fm.beginTransaction().add(R.id.tabs_main_container, fragment2, "2").hide(fragment2).commit();
        fm.beginTransaction().add(R.id.tabs_main_container, fragment1, "1").commit();
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = item -> {
                switch (item.getItemId()) {
                    case R.id.navigation_vr:
                        fm.beginTransaction().hide(active).show(fragment1).commit();
                        active = fragment1;
                        return true;

                    case R.id.navigation_home:
                        fm.beginTransaction().hide(active).show(fragment2).commit();
                        active = fragment2;
                        return true;

                    case R.id.navigation_more:
                        fm.beginTransaction().hide(active).show(fragment3).commit();
                        active = fragment3;
                        return true;
                }
                return false;
            };

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);
    }
}