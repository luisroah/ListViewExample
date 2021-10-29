package com.poli.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class ListaNombres extends AppCompatActivity {

    private ListView listaNombres;
    private ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nombres);
        listaNombres = findViewById(R.id.lvListNames);

        nombres = new ArrayList<String>();

        nombres.add("Luis");
        nombres.add("Ivan");
        nombres.add("Alberto");

        ArrayAdapter<String> listNombreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);

        listaNombres.setAdapter(listNombreAdapter);
    }

    public void agregarNombre(View view){
        //String nombre = etIngresarNombre
    }
}