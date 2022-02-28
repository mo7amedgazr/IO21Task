package com.app.io21task.presentation.home.tabs;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.app.io21task.R;
import com.app.io21task.databinding.FragmentARBinding;
import com.app.io21task.databinding.FragmentLoginBinding;
import com.app.io21task.presentation.home.tabs.adapter.ARAdapter;
import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;

public class ARFragment extends Fragment {

    private FragmentARBinding binding;


    public ARFragment() {
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
        binding = FragmentARBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        initListAdapter();
        initTabs();
    }

    private void initTabs() {
        TabLayout.Tab firstTab = binding.tabsLayout.newTab();
        firstTab.setText("All");

        TabLayout.Tab secondTab = binding.tabsLayout.newTab();
        secondTab.setText("Training");

        TabLayout.Tab thirdTab = binding.tabsLayout.newTab();
        thirdTab.setText("Events");

        binding.tabsLayout.addTab(firstTab);
        binding.tabsLayout.addTab(secondTab);
        binding.tabsLayout.addTab(thirdTab);

    }

    private void initListAdapter() {
        ARAdapter adapter = new ARAdapter(requireContext(), new ArrayList<>());
        binding.rvListItems.setAdapter(adapter);

        binding.rvTabsList.setAdapter(adapter);
    }
}