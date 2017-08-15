package net.vielmond.mywallet.dao;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import net.vielmond.mywallet.AdicionarCompra;
import net.vielmond.mywallet.MainActivity;
import net.vielmond.mywallet.R;
import net.vielmond.mywallet.adapter.AdapterCarteira;
import net.vielmond.mywallet.entidades.Carteira;
import net.vielmond.mywallet.entidades.Compras;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Created by root on 06/08/17.
 */

public class CarteiraJson extends AsyncTask<Integer, Void, ArrayList> {
    private URL url = null;
    private String json_url;
    private String JSON_STRING;
    private Context context;
    private Activity activity;
    private Integer flagException = 0;
    private ProgressDialog load;
    private ArrayList<Carteira> lista = new ArrayList<>();
    private DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
    private ListView listView;

    public CarteiraJson(Context context, Activity activity){
        this.context = context;
        this.activity = activity;
    }

    @Override
    protected void onPreExecute() {
        Log.i("AsyncTask", "Exibindo ProgressDialog na tela Thread: " + Thread.currentThread().getName());
        load = ProgressDialog.show(context, null,
                "Carregando dados ...");

    }

    @Override
    protected ArrayList doInBackground(Integer... integers) {
        json_url = "http://10.1.1.110:8080/mywallet/carteira_json?ca="+ integers[0]; // [id_usuario_fk]

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

                Carteira r = new Carteira();
                r.setId_carteira(jsonObject.getInt("id_carteira"));
                r.setNome_carteira(jsonObject.getString("nome_carteira"));
                r.setDescricao(jsonObject.getString("descricao"));
                r.setMostrar(jsonObject.getBoolean("mostrar"));

                lista.add(r);

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

        return lista;
    }

    @Override
    protected void onPostExecute(ArrayList array) {
        if (array != null) {
            Log.i("AsyncTask", "Executa o carregamento de dados: " + Thread.currentThread().getName());
            try {
//
                // AQUI SELECIONA O BUTTON DENTRO DO LISTVIEW
                listView = (ListView) activity.findViewById(R.id.listview);
                AdapterCarteira adapter = new AdapterCarteira(context, array) {
                    @Override
                    public View getView(final int position, View convertView, ViewGroup parent) {
                        final View row = super.getView(position, convertView, parent);

                        //<editor-fold defaultstate="collapsed" desc="add uma compra">
                        ImageButton btnValores = (ImageButton) row.findViewById(R.id.btn_add_compra_id);
                        btnValores.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View v) {
                                Intent intent = new Intent(context, AdicionarCompra.class);
                                final Carteira cart = lista.get(position);
                                Bundle b = new Bundle();

                                b.putInt("id_carteira", cart.getId_carteira());
                                b.putString("nome_carteira", cart.getNome_carteira());
                                intent.putExtras(b);
                                activity.startActivity(intent);
                            }
                        });
                        //</editor-fold>

                        //<editor-fold defaultstate="collapsed" desc="btn graficos">
//                        ImageButton btnGraficos = (ImageButton) row.findViewById(R.id.btnGraficos);
//                        btnGraficos.setOnClickListener(new View.OnClickListener() {
//                            public void onClick(View v) {
//                                Intent intent = new Intent(context, DadosGraficos.class);
//                                final Carteira cart = lista.get(position);
//                                Bundle b = new Bundle();
//
//                                b.putInt("i_pessoas", Integer.parseInt(i_pessoas));
//                                b.putInt("i_funcionarios", Integer.parseInt(i_funcionarios));
//                                b.putString("comp", entMeses.getStri_competencias());
//                                b.putBoolean("flag_13", entMeses.getFlag_13());
//                                intent.putExtras(b);
//                                activity.startActivity(intent);
//                            }
//                        });
                        //</editor-fold>
                        return row;
                    }
                };

                adapter.notifyDataSetChanged();
                listView.setAdapter(adapter);
                listView.setTextFilterEnabled(true);


            } catch (Exception ex) {
                Logger.getLogger(MainActivity.class.getName()).log(Level.SEVERE, null, ex);
            }
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
