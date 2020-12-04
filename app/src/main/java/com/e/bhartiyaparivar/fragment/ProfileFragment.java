package com.e.bhartiyaparivar.fragment;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentProfileBinding;
import com.e.bhartiyaparivar.interfaces.ApiInterface;
import com.e.bhartiyaparivar.model.User;
import com.e.bhartiyaparivar.utils.ApiUtils;
import com.e.bhartiyaparivar.utils.Utils;

import java.util.ArrayList;


public class ProfileFragment extends Fragment {
    private static final String TAG = "ProfileFragment";

    FragmentProfileBinding profileBinding;

    User user = new User();

    ArrayAdapter<String> arrayAdapter;

    String profession = null;

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

        getProfileData();

        user.setMobileNo(getArguments().getString("mobileNumber"));

        profileBinding.btnUpdateProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isAllFilled()) {
                    Utils.showProgressDialog(requireActivity(), "Please wait, registering account....");
                    user.setName(profileBinding.etName.getText().toString());
                    user.setAge(profileBinding.etAge.getText().toString());
                    user.setPin(profileBinding.etPinCode.getText().toString());

                    registerUser(user);
                }
            }
        });

    }

    private boolean isAllFilled() {
        if (profileBinding.etName.getText().toString().isEmpty()) {
            Toast.makeText(requireActivity(), "name required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (profileBinding.etAge.getText().toString().isEmpty()) {
            Toast.makeText(requireActivity(), "age required", Toast.LENGTH_SHORT).show();
            return false;
        } else if (profileBinding.etAge.getText().toString().length() < 3) {
            Toast.makeText(requireActivity(), "enter valid age", Toast.LENGTH_SHORT).show();
            return false;
        } else if (profileBinding.etPinCode.getText().toString().isEmpty()) {
            Toast.makeText(requireActivity(), "pin code required", Toast.LENGTH_SHORT).show();
            return false;
        } /*else if (profileBinding.etPinCode.getText().toString().length() < 6) {
            Toast.makeText(requireActivity(), "enter valid pin code", Toast.LENGTH_SHORT).show();
            return false;
        }*/ else if (null == profession) {
            Toast.makeText(requireActivity(), "select  profession", Toast.LENGTH_SHORT).show();
            return false;
        } else
            return true;
    }

    private void registerUser(final User user) {

        Utils.hideKeyboard(requireActivity());
        ApiUtils.registerUser(user, new ApiInterface() {
            @Override
            public void onSuccess(Object obj) {
                User res = (User) obj;
                Toast.makeText(requireActivity(), "User register with user ID " + res.getUserID(), Toast.LENGTH_SHORT).show();
                Utils.hideProgressDialog();
            }

            @Override
            public void onFailed(String msg) {
                Toast.makeText(requireActivity(), msg, Toast.LENGTH_SHORT).show();
                Utils.hideProgressDialog();
            }
        });
    }

    private void getProfileData() {

        ApiUtils.getUserProfile(user, new ApiInterface() {
            @Override
            public void onSuccess(Object ojb) {
                try {
                    user = (User) ojb;
                    profileBinding.setUser(user);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailed(String msg) {
                Log.d(TAG, "onFailedToGetUser: " + msg);
            }
        });
    }

    private void setSpinner() {
        final ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("-Select-");
        arrayList.add("Profession A");
        arrayList.add("Profession B");
        arrayList.add("Profession C");
        arrayList.add("Profession D");
        arrayList.add("Profession E");
        arrayList.add("Profession F");

        arrayAdapter = new ArrayAdapter<String>(requireActivity(), android.R.layout.simple_spinner_item, arrayList);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        profileBinding.professionSpinner.setAdapter(arrayAdapter);
        profileBinding.professionSpinner.setSelection(0);

        profileBinding.professionSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                user.setProfession(arrayList.get(position));
                profession = arrayList.get(position);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });


    }
}