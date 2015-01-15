package com.intro.introapp;



import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.Toast;

/**
 * A simple {@link Fragment} subclass.
 */
public class LogInScreen extends Fragment implements OnClickListener {
    Context c;

    public LogInScreen() {
        //required constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        c = container.getContext();

        View view = inflater.inflate(R.layout.fragment_log_in_screen, container, false);
        Button reg = (Button) view.findViewById(R.id.register);
        Button log = (Button) view.findViewById(R.id.logIn);
        reg.setOnClickListener(this);
        log.setOnClickListener(this);
        return view;
    }

    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.register:
                RegisterDialog dialog = new RegisterDialog();
                dialog.show(getFragmentManager(), "dialog");
                break;
            case R.id.logIn:
                EditText user = (EditText) getActivity().findViewById(R.id.userText);
                EditText password = (EditText) getActivity().findViewById(R.id.password);
                String userString = user.getText().toString();
                String passString = password.getText().toString();

                final UserInfoAdapter userInfo = new UserInfoAdapter(getActivity());

                boolean maybeAccept = userInfo.getUser(userString, passString);

                if (maybeAccept){
                    Intent intent = new Intent(getActivity(), ThirdScreen.class);
                    startActivity(intent);
                }

                else {
                    String message = "The user or password is not correct";
                    int length = Toast.LENGTH_SHORT;
                    Toast toast = Toast.makeText(c, message, length);
                    toast.show();
                }
        }

    }

}

