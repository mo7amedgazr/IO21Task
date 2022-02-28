package com.app.io21task.presentation.splash;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.io21task.R;
import com.app.io21task.databinding.FragmentSplashBinding;

public class WelcomeFragment extends Fragment {

    private FragmentSplashBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSplashBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        handleNavigation();
    }

    private void handleNavigation() {
        new Handler().postDelayed(() ->
                        Navigation.findNavController(requireActivity(),
                                R.id.nav_host_fragment_content_main)
                                .navigate(R.id.action_FirstFragment_to_SecondFragment),
                2000);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}