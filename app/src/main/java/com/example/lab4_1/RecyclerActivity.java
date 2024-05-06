package com.example.lab4_1;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.View;

import com.example.lab4_1.recycler.AdaptadorTitulares;
import com.example.lab4_1.recycler.Titular;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class RecyclerActivity extends AppCompatActivity {

    private RecyclerView recView;
    private ArrayList<Titular> datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);

        //inicialización de la lista de datos de ejemplo
        datos = new ArrayList<Titular>();
        for(int i=0; i<25; i++)
            datos.add(new Titular("Título " + i, "Subtítulo item " + i));

        //Inicialización RecyclerView
        recView = (RecyclerView) findViewById(R.id.RecView);
        recView.setHasFixedSize(true);

        final AdaptadorTitulares adaptador = new AdaptadorTitulares(datos);
        recView.setAdapter(adaptador);
        adaptador.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "Pulsando el elemento " +
                        recView.getChildAdapterPosition(v),Snackbar.LENGTH_SHORT).show();
            }
        });
        recView.setLayoutManager(
                new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        );



    }




}