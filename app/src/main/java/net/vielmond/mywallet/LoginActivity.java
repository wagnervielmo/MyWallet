package net.vielmond.mywallet;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.annotation.TargetApi;
import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.app.LoaderManager.LoaderCallbacks;

import android.content.CursorLoader;
import android.content.Loader;
import android.database.Cursor;
import android.net.Uri;
import android.os.AsyncTask;

import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import net.vielmond.mywallet.dao.LoginJson;

import java.util.ArrayList;
import java.util.List;

import static android.Manifest.permission.READ_CONTACTS;

/**
 * A login screen that offers login via email/password.
 */
public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        //<editor-fold defaultstate="collapsed" desc="btn login">
        Button btnLg = (Button) findViewById(R.id.btn_login);
        btnLg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String login = ((EditText) findViewById(R.id.login_id)).getText().toString();
                String senha = ((EditText) findViewById(R.id.senha_id)).getText().toString();
                if (login.equalsIgnoreCase("") || senha.equalsIgnoreCase("")) {

                } else {
                    chamarAsyncTask(login, senha);
                }
            }
        });
        //</editor-fold>

    }

    private void chamarAsyncTask(String login, String senha) {
        LoginJson loginacesso = new LoginJson(LoginActivity.this, this);
        Log.i("AsyncTask", "AsyncTask senado chamado Thread: " + Thread.currentThread().getName());
        loginacesso.execute(login, senha);
    }
}

