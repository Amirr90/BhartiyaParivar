package com.e.bhartiyaparivar.fragment;

import android.app.ProgressDialog;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentLoginScreenBinding;
import com.e.bhartiyaparivar.interfaces.ApiInterface;
import com.e.bhartiyaparivar.model.Login;
import com.e.bhartiyaparivar.model.SendOTP;
import com.e.bhartiyaparivar.utils.ApiUtils;

import java.util.ArrayList;

import static com.e.bhartiyaparivar.utils.Utils.MOBILE_NUMBER_KEY;
import static com.e.bhartiyaparivar.utils.Utils.hideKeyboard;

public class
LoginScreenFragment extends Fragment {

    FragmentLoginScreenBinding loginScreenBinding;
    NavController navController;
    ProgressDialog dialog;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        loginScreenBinding = FragmentLoginScreenBinding.inflate(getLayoutInflater());
        return loginScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        dialog = new ProgressDialog(requireActivity());
        navController = Navigation.findNavController(view);
        setSpinner();


        loginScreenBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobileNumber = loginScreenBinding.etMobileNumber.getText().toString();
                if (mobileNumber.length() == 10) {
                    sendOTP(mobileNumber);
                } else {
                    Toast.makeText(requireActivity(), "Please enter valid mobile number", Toast.LENGTH_SHORT).show();
                }

            }
        });


    }

    private void sendOTP(final String mobileNumber) {

        hideKeyboard(requireActivity());
        dialog.setMessage("Sending OTP to +91" + mobileNumber);
        dialog.show();
        SendOTP OTPModel = new SendOTP();
        OTPModel.setMobileNo(mobileNumber);

        ApiUtils.generateOTP(OTPModel, new ApiInterface() {
            @Override
            public void onSuccess(Object ojb) {
                dialog.dismiss();
                Toast.makeText(requireActivity(), "OTP sent successfully to mobile number " + mobileNumber, Toast.LENGTH_SHORT).show();
                Bundle bundle = new Bundle();
                bundle.putString(MOBILE_NUMBER_KEY, mobileNumber);
                navController.navigate(R.id.action_loginScreenFragment_to_submitOtpFragment, bundle);
            }

            @Override
            public void onFailed(String msg) {
                dialog.dismiss();
                Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show();

            }
        });


    }

    private void setSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("BHARAT");
        arrayList.add("USA");
        arrayList.add("CHINA");
        arrayList.add("NEPAL");
        arrayList.add("PAKISTAN");
        arrayList.add("RUSSIA");
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginScreenBinding.spinner.setAdapter(arrayAdapter);
        loginScreenBinding.spinner.setSelection(0);
    }
}