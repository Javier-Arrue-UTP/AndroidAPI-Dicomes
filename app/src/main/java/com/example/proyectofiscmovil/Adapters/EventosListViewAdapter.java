package com.example.proyectofiscmovil.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.proyectofiscmovil.Activities.SplashScreenEncuestaDocentes;
import com.example.proyectofiscmovil.Models.Eventos;
import com.example.proyectofiscmovil.R;

import java.util.List;

public class EventosListViewAdapter extends ArrayAdapter<Eventos> {

    private List<Eventos> lista;

    public EventosListViewAdapter(Context context, List<Eventos> lista){
        super(context, R.layout.listview_eventos,lista);
        this.lista = lista;
    }

    public View getView(int position, View convertView, ViewGroup parent){

        LayoutInflater inflater = LayoutInflater.from(getContext());
        View item = inflater.inflate(R.layout.listview_eventos,null);

        TextView fechaEvento = (TextView)item.findViewById(R.id.fechaListView);
        fechaEvento.setText(lista.get(position).getFechaEvento());

        TextView hInicial = (TextView)item.findViewById(R.id.hInicialListView);
        hInicial.setText(lista.get(position).getHoraInicioEvento());

        TextView hFinal= (TextView)item.findViewById(R.id.hFinalListView);
        hFinal.setText(lista.get(position).getHoraFinalevento());

        TextView ubicacionEvento = (TextView)item.findViewById(R.id.ubicacionListView);
        ubicacionEvento.setText(lista.get(position).getUbicaciónEvento());

        TextView nombre = (TextView)item.findViewById(R.id.nombreListView);
        nombre.setText(lista.get(position).getNombreCli());

        TextView apellido = (TextView)item.findViewById(R.id.apellidoListView);
        apellido.setText(lista.get(position).getApellidoCli());

        return item;
    }



}
