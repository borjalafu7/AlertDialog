package com.borjalapa.alertdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView tvMostrar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvMostrar = (TextView)findViewById(R.id.tvMostrar);

    }

    public void mostrardialogo(View view) {

        MiDialogo md = new MiDialogo(this, new MiDialogo.RespuestaDialogo() {
            @Override
            public void OnAccept(String cadena) {
                Toast.makeText(MainActivity.this,cadena, Toast.LENGTH_SHORT).show();
                tvMostrar.setText("Aceptado");
            }

            @Override
            public void OnCancel(String cadena) {
                Toast.makeText(MainActivity.this,cadena, Toast.LENGTH_SHORT).show();
                tvMostrar.setText("Cancelado");
            }
        });


        //md.MostrarDialogoBotones().show();

        //md.DialogoOpcionUnica().show();

        md.customDialog().show();
    }
}