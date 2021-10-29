package com.poli.listviewexample;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class ListaNombres extends AppCompatActivity {

    private ListView listaNombres;
    private ArrayList nombres;
    private EditText txtIngresarNombre;
    private ArrayAdapter<String> listNombreAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_nombres);

        listaNombres = findViewById(R.id.lvListNames);
        txtIngresarNombre = findViewById(R.id.etIngresarNombre);

        nombres = new ArrayList();
        nombres.add("Luis");
        nombres.add("Ivan");
        nombres.add("Alberto");
        listNombreAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, nombres);
        listaNombres.setAdapter(listNombreAdapter);

        listaNombres.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Toast toast = Toast.makeText(getApplicationContext(), "Name: "+adapterView.getItemAtPosition(i)+" Selected!", Toast.LENGTH_LONG);
                toast.show();
            }
        });

        listaNombres.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long l) {
                final int posicion=i;

                AlertDialog.Builder dialogo1 = new AlertDialog.Builder(ListaNombres.this);
                dialogo1.setTitle("Important");
                dialogo1.setMessage("¿ Do you want to remove this name ?");
                dialogo1.setCancelable(false);
                dialogo1.setPositiveButton("Confirm", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                        nombres.remove(posicion);
                        listNombreAdapter.notifyDataSetChanged();
                    }
                });
                dialogo1.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialogo1, int id) {
                    }
                });
                dialogo1.show();

                return false;
            }
        });
    }

    public void agregarNombreBTN(View view){
        nombres.add(txtIngresarNombre.getText().toString());
        listNombreAdapter.notifyDataSetChanged();
        Toast toast = Toast.makeText(getApplicationContext(), "Name: "+txtIngresarNombre.getText().toString()+" added successfully!", Toast.LENGTH_LONG);
        toast.show();
        txtIngresarNombre.setText("");
    }
}