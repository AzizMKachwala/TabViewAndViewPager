package com.example.tabviewandviewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class StatusFragment extends Fragment {

    EditText etvMobile;
    Button btnMobile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        etvMobile = view.findViewById(R.id.etvMobile);
        btnMobile = view.findViewById(R.id.btnMobile);

        btnMobile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String mobile = etvMobile.getText().toString();

                if(isValid(mobile)){
                    String message = "Mobile No.:" + mobile;
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
                }
                else{
                    etvMobile.setError("Enter Valid Number");
                }
            }
        });

        return view;
    }

    private boolean isValid(String mobile){
        String MobileNo = "^[0-9]{10}$";
        return Pattern.matches(MobileNo, mobile);
    }
}