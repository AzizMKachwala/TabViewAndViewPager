package com.example.tabviewandviewpager;

import android.os.Bundle;

import androidx.fragment.app.Fragment;


import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;

public class ChatsFragment extends Fragment {

    EditText etvUsername, etvPassword;
    Button btnData;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_chats, container, false);
        etvUsername = view.findViewById(R.id.etvUsername);
        etvPassword = view.findViewById(R.id.etvPassword);
        btnData = view.findViewById(R.id.btnData);

        btnData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String user = etvUsername.getText().toString();
                String pass = etvPassword.getText().toString();

                if(user.isEmpty() && pass.isEmpty()){
                    Toast.makeText(requireContext(), "Enter Username and Password First", Toast.LENGTH_SHORT).show();
                }

                if (isValidPass(pass)) {
                    // Both fields have content, display a toast message
                    String message = "Username: " + user + "\nPassword: " + pass + "\nLOGIN SUCCESSFUL!!!";
                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show();
                } else {
                    etvPassword.setError("Enter Valid Number");
                    }
                };
        });
        return view;
    }

    private boolean isValidPass(String pass){
        String validPassword = "^(?=.*[A-Z])(?=.*[a-z]).{8,16}$";
        return Pattern.matches(validPassword, pass);
    }
}