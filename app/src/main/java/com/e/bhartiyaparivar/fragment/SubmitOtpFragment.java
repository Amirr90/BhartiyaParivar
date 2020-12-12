package com.e.bhartiyaparivar.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentLoginScreenBinding;
import com.e.bhartiyaparivar.databinding.FragmentSubmitOtpBinding;
import com.e.bhartiyaparivar.interfaces.ApiInterface;
import com.e.bhartiyaparivar.model.SendOTP;
import com.e.bhartiyaparivar.utils.ApiUtils;

import static com.e.bhartiyaparivar.utils.Utils.hideKeyboard;
import static com.e.bhartiyaparivar.utils.Utils.hideProgressDialog;
import static com.e.bhartiyaparivar.utils.Utils.showProgressDialog;

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

        submitOtpBinding.setNumber(number);

        submitOtpBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String OTP = submitOtpBinding.etOtp.getText().toString().trim();
                if (OTP.length() == 4) {
                    verifyOTP(OTP);
                } else {
                    Toast.makeText(requireActivity(), "Please enter valid OTP", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void verifyOTP(String otp) {
        hideKeyboard(requireActivity());
        showProgressDialog(requireActivity(), "Verifying OTP, please wait...", false);
        SendOTP model = new SendOTP();
        model.setMobileNo(number);
        model.setOtp(otp);
        ApiUtils.verifyOTP(model, new ApiInterface() {
            @Override
            public void onSuccess(Object ojb) {
                hideProgressDialog();
                Toast.makeText(requireActivity(), "OTP verified successfully", Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString("mobileNumber", number);
                navController.navigate(R.id.action_submitOtpFragment_to_profileFragment, bundle);

            }

            @Override
            public void onFailed(String msg) {
                hideProgressDialog();
                Toast.makeText(requireActivity(), "try again", Toast.LENGTH_SHORT).show();
            }
        });

    }
}