package com.intro.introapp;


import android.app.FragmentManager;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInScreen extends Fragment {
    public LogInScreen() {
        // Required empty public constructor
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_log_in_screen, container, false);
        Button reg = (Button) view.findViewById(R.id.register);
        reg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                RegisterDialog dialog = new RegisterDialog();
                dialog.show(getFragmentManager(), "dialog");
            }
        });



        return view;
    }

   /* public void onClickPop (View view) {

        RegisterDialog dialog = new RegisterDialog();
        dialog.show(getFragmentManager(), "diaog");

    }
*/
    }

