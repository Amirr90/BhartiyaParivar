package com.e.bhartiyaparivar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentLoginScreenBinding;
import com.e.bhartiyaparivar.databinding.FragmentSubmitOtpBinding;

public class SubmitOtpFragment extends Fragment {

    FragmentSubmitOtpBinding submitOtpBinding;
    NavController navController;
    String number;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        submitOtpBinding = FragmentSubmitOtpBinding.inflate(getLayoutInflater());
        return submitOtpBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);

        number = getArguments().getString("mobile");

        submitOtpBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_submitOtpFragment_to_profileFragment);
            }
        });

    }
}