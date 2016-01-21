package com.lifo.upspoi;

import android.os.Bundle;
import android.app.Activity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.common.base.Strings;
import com.lifo.upspoi.services.UtilisateurService;

public class LoginActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    public void onBackPressed() {
        // On ne fait rien car l'utilisateur n'a pas le droit de quitter l'activite
    }

    public void onLoginButtonPressed(View v) {

        EditText userNameTextField = (EditText) findViewById(R.id.loginUsernameTextField);
        String usernameEntered = userNameTextField.getText().toString();
        if (Strings.isNullOrEmpty(usernameEntered)) {
            return;
        }

        UtilisateurService.getInstance().loggerUtilisateur(usernameEntered, "");

        finish();
    }
}
