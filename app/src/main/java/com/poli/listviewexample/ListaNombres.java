package com.poli.listviewexample;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaNombres extends AppCompatActivity {

    private ListView listaNombres;
    private ArrayList<String> nombres;
    private EditText txtIngresarNombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nombres);
        listaNombres = findViewById(R.id.lvListNames);
        txtIngresarNombre = findViewById(R.id.etIngresarNombre);

        nombres = new ArrayList<String>();

        nombres.add("Luis");
        nombres.add("Ivan");
        nombres.add("Alberto");

        cargarLista();
    }

    public void agregarNombreBTN(View view){
        String nombre = txtIngresarNombre.getText().toString();
        Toast toast = Toast.makeText(getApplicationContext(), "Ingresó"+nombre, Toast.LENGTH_LONG);
        toast.show();
        nombres.add(nombre);
        cargarLista();
    }

    public void cargarLista(){
        ArrayAdapter<String> listNombreAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        listaNombres.setAdapter(listNombreAdapter);
    }
}