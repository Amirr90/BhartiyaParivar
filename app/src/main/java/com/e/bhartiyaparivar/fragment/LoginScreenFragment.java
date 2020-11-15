package com.e.bhartiyaparivar.fragment;

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

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentLoginScreenBinding;

import java.util.ArrayList;

public class LoginScreenFragment extends Fragment {

    FragmentLoginScreenBinding loginScreenBinding;
    NavController navController;
    String mobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        loginScreenBinding = FragmentLoginScreenBinding.inflate(getLayoutInflater());
        return loginScreenBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        navController = Navigation.findNavController(view);
        setSpinner();


        loginScreenBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                Bundle bundle = new Bundle();
                bundle.putString("mobile", "+919044865611");
                navController.navigate(R.id.action_loginScreenFragment_to_submitOtpFragment, bundle);
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