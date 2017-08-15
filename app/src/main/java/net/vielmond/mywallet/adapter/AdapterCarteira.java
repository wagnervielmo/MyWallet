package net.vielmond.mywallet.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import net.vielmond.mywallet.R;
import net.vielmond.mywallet.entidades.Carteira;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * Created by root on 06/08/17.
 */

public class AdapterCarteira extends BaseAdapter {

    private Context context;
    private ArrayList<Carteira> list;

    public AdapterCarteira(Context context, ArrayList<Carteira> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Carteira ent = list.get(position);
        View layout;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
            layout = inflater.inflate(R.layout.lv_carteira, null);
        } else {
            layout = convertView;
        }

        ((TextView) layout.findViewById(R.id.nome_carteira_id)).setText(ent.getNome_carteira());
        ((TextView) layout.findViewById(R.id.descricao_carteira_id)).setText(ent.getDescricao());

        return layout;
    }

    public String Converter(String mes) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("MM", new Locale("pt", "BR"));
            Date mesDate = sdf.parse(mes);
            sdf.applyPattern("MMMM");
            return sdf.format(mesDate).toUpperCase().substring(0, 3);
        } catch (ParseException e) {
            System.out.println("Contracheque - Error: " + e);
            return "";
        }
    }
}
