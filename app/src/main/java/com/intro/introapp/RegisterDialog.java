package com.intro.introapp;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;

/**
 * Created by Jesse on 2014-12-28.
 */
public class RegisterDialog extends DialogFragment {



    @Override
    public AlertDialog onCreateDialog(Bundle savedInstanceState){
        final AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        LayoutInflater inflater = getActivity().getLayoutInflater();
        final View dialogView = inflater.inflate(R.layout.log_in_popup, null);
        final UserInfoAdapter userInfo = new UserInfoAdapter(getActivity());

        builder.setView(dialogView)
                .setPositiveButton(R.string.create, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int id) {
                        EditText userName = (EditText) dialogView.findViewById(R.id.newUser);
                        EditText password = (EditText) dialogView.findViewById(R.id.newPassword);

                        String user = userName.getText().toString();
                        String pass = password.getText().toString();

                        userInfo.insertUser(user, pass);
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        RegisterDialog.this.getDialog().cancel();
                    }
                });
        return builder.create();
    }
}