package com.e.bhartiyaparivar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import com.e.bhartiyaparivar.R;
import com.e.bhartiyaparivar.databinding.FragmentSelectLanguageBinding;

import static com.e.bhartiyaparivar.utils.Utils.setAppLocale;


public class SelectLanguageFragment extends Fragment {

    FragmentSelectLanguageBinding selectLanguageBinding;
    NavController navController;
    String language = "hi";

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        selectLanguageBinding = FragmentSelectLanguageBinding.inflate(getLayoutInflater());
        return selectLanguageBinding.getRoot();

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


        navController = Navigation.findNavController(view);
        selectLanguageBinding.btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                navController.navigate(R.id.action_selectLanguageFragment_to_termsandConditionFragment);
            }
        });

        setAppLocale(language, requireActivity());

        selectLanguageBinding.languageGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                if (radioGroup.getCheckedRadioButtonId() == R.id.radioButtonHindi)
                    language = "hi";
                else language = "en";
                setAppLocale(language, requireActivity());

            }

        });
    }
}