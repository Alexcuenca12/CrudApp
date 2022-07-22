package com.alexis.siavi.crudapp;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;

import com.alexis.siavi.crudapp.modelo.Persona;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;

import android.view.View;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.alexis.siavi.crudapp.databinding.ActivityMainBinding;

import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CursorAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnGuardar=(Button) findViewById(R.id.buttonG);
        btnGuardar.setOnClickListener(guardarListener);
        Button btnListar=(Button) findViewById((R.id.buttonL));
        btnListar.setOnClickListener((listarListener));

    }

    View.OnClickListener guardarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            EditText txtID= (EditText) findViewById(R.id.txtID);
            EditText txtNom= (EditText) findViewById(R.id.txtNombre);
            EditText txtApe= (EditText) findViewById(R.id.txtApellidos);
            EditText txtCorreo= (EditText) findViewById(R.id.txtCorreo);

            //Set Personas
            Persona persona =new Persona();
            persona.setId(txtID.getText().toString());
            persona.setNombre(txtNom.getText().toString());
            persona.setApellido(txtApe.getText().toString());
            persona.setCorreo(txtCorreo.getText().toString());

            persona.guardarPersona(getApplicationContext());

            Toast.makeText(getApplicationContext(),"persona creada",Toast.LENGTH_LONG).show();

        }
    };

    View.OnClickListener listarListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ListView listView=(ListView) findViewById(R.id.listPersonas);
            Cursor cursor  =Persona.listarPersona(getApplicationContext());
            String[] desde = new String[]{"id","nombres","apellidos","correo"};
            int[] hasta =new int[]{R.id.txtID_P,R.id.txtNombre_P,R.id.txtApellidos_P,R.id.txtCorreo_P};

            CursorAdapter cursorAdapter = new SimpleCursorAdapter(getApplicationContext(),R.layout.detallepersona,cursor,desde,hasta,0);

            listView.setAdapter(cursorAdapter);





        }
    };
}

