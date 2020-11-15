package com.e.bhartiyaparivar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentProfileBinding;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {

    FragmentProfileBinding profileBinding;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        profileBinding = FragmentProfileBinding.inflate(getLayoutInflater());
        return profileBinding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        setSpinner();
    }

    private void setSpinner() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("-Select-");
        arrayList.add("Profession A");
        arrayList.add("Profession B");
        arrayList.add("Profession C");
        arrayList.add("Profession D");
        arrayList.add("Profession E");
        arrayList.add("Profession F");

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileBinding.spinner2.setAdapter(arrayAdapter);
        profileBinding.spinner2.setSelection(0);
    }
}