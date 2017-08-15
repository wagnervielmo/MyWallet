package net.vielmond.mywallet.dao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import net.vielmond.mywallet.MainActivity;
import net.vielmond.mywallet.entidades.Login;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by root on 06/08/17.
 */

public class LoginJson extends AsyncTask<String, Void, Login> {
    private URL url = null;
    private String json_url;
    private String JSON_STRING;
    private Context context;
    private Integer flagException = 0;
    private ProgressDialog load;
    private Activity activit;

    public LoginJson(Context context, Activity activity){
        this.context = context;
        this.activit = activity;
    }

    @Override
    protected void onPreExecute() {
        Log.i("AsyncTask", "Exibindo ProgressDialog na tela Thread: " + Thread.currentThread().getName());
        load = ProgressDialog.show(context, null,
                "Analisando informações...");

    }

    @Override
    protected Login doInBackground(String... strings) {
        json_url = "http://10.1.1.110:8080/mywallet/login_json?ca=" + strings[0] + "&cb=" + strings[1]; // [login] [senha]
        Login l = new Login();

        try {
            url = new URL(json_url);
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

            StringBuilder stringBuilder = new StringBuilder();
            while ((JSON_STRING = bufferedReader.readLine()) != null){
                stringBuilder.append(JSON_STRING + "\n");
            }

            JSONArray jsonArray = new JSONArray(stringBuilder.toString());
            for (int i = 0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);

                l.setId_usuario(jsonObject.getInt("id_usuario"));
                l.setNome(jsonObject.getString("nome"));
                l.setCpf(jsonObject.getString("cpf"));
                l.setStr_dt_nascimento(jsonObject.getString("dt_nascimento"));

            }

            bufferedReader.close();
            inputStream.close();
            httpURLConnection.disconnect();

        } catch (IOException ex) {
            System.err.println("IOException: " + ex);
            flagException = 1;
        } catch (NullPointerException ex) {
            System.err.println("NullPointerException: " + ex);
            flagException = 2;
        } catch (JSONException ex) {
            System.err.println("JSONException: " + ex);
            flagException = 3;
        }

        return l;
    }

    @Override
    protected void onPostExecute(Login login) {
        if (login.getId_usuario() != 0) {
            Log.i("AsyncTask", "OK, realiando login: " + Thread.currentThread().getName());
            Intent i = new Intent(context, MainActivity.class);
            Bundle b = new Bundle();
            b.putInt("id_usuario", login.getId_usuario());
            b.putString("nome", login.getNome());
            b.putString("cpf", login.getCpf());
            b.putString("dt_nascimento", login.getStr_dt_nascimento());
            i.putExtras(b);

            context.startActivity(i);
            activit.finish();

        } else {
            if(flagException == 1){
                Log.i("AsyncTask", "Erro: " + Thread.currentThread().getName());
                load.dismiss();
                MessageBox("IOException - Entre em contato com o desenvolvedor");
            } else if(flagException == 2){
                Log.i("AsyncTask", "Erro: " + Thread.currentThread().getName());
                load.dismiss();
                MessageBox("NullPointerException - Entre em contato com o desenvolvedor");
            } else if(flagException == 3){
                Log.i("AsyncTask", "Erro: " + Thread.currentThread().getName());
                load.dismiss();
                MessageBox("JSONException - Verifique sua internet.");
            } else {
                load.dismiss();
                MessageBox("Login Incorreto - Confira os dados digitados");
            }

        }
        Log.i("AsyncTask", "Tirando ProgressDialog da tela Thread: " + Thread.currentThread().getName());
        load.dismiss();
    }

    public void MessageBox(String message) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show();
        Log.i("LOG MESSAGE", "Mostrou a mensagem");
    }
}
