package com.app.io21task.presentation.login;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.app.io21task.R;
import com.app.io21task.databinding.FragmentLoginBinding;

public class LoginFragment extends Fragment {

    private FragmentLoginBinding binding;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentLoginBinding.inflate(inflater, container, false);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        initClickListener();

    }

    private void initClickListener() {
        binding.btnLogin.setOnClickListener(view -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                    .navigate(R.id.action_SecondFragment_to_tabsFragment);
        });
        binding.tvContinueGuest.setOnClickListener(view -> {
            Navigation.findNavController(requireActivity(), R.id.nav_host_fragment_content_main)
                    .navigate(R.id.action_SecondFragment_to_tabsFragment);
        });
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}