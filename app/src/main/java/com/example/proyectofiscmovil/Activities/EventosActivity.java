package com.example.proyectofiscmovil.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.proyectofiscmovil.Adapters.EventosListViewAdapter;
import com.example.proyectofiscmovil.Models.Eventos;
import com.example.proyectofiscmovil.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;


public class EventosActivity extends AppCompatActivity {

    ListView listaDocentesEncuestados;
    private RequestQueue mQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos);
        Volley.newRequestQueue(this).getCache().clear();
        inicializarControles();

        eventosListViewApi();

    }



    private void inicializarControles() {

        //Limpiar cache para que cargue datos actualizados.
        listaDocentesEncuestados = findViewById(R.id.listaDocentesEncuestados);
        mQueue = Volley.newRequestQueue(this);

    }

    private void eventosListViewApi() {

        final List<Eventos> list = new ArrayList<>();

        String url = "http://prensautp.ds507.online/Sistema/api/webApi.php";

        JsonArrayRequest request = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {

                        try {

                            String fecha, hInicial, hFinal, ubicacion,nombre,apellido;

                            for(int i = 0 ; i<response.length(); i++){

                                JSONObject resultado = response.getJSONObject(i);

                                fecha = resultado.getString("start");
                                hInicial = resultado.getString("hora_inicio");
                                hFinal = resultado.getString("hora_final");
                                ubicacion = resultado.getString("ubicacion");
                                nombre = resultado.getString("nombre");
                                apellido = resultado.getString("apellido");

                                list.add(new Eventos(fecha,hInicial,hFinal,ubicacion,nombre,apellido));

                            }

                            EventosListViewAdapter adapter = new EventosListViewAdapter(getApplicationContext(),list);
                            listaDocentesEncuestados.setAdapter(adapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });

        request.setRetryPolicy(new DefaultRetryPolicy(
                15000,
                DefaultRetryPolicy.DEFAULT_MAX_RETRIES,
                DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

        mQueue.add(request);


    }

}