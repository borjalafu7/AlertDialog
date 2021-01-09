package com.borjalapa.alertdialog;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;

public class MiDialogo {
    Context context;
    RespuestaDialogo rd;

    public MiDialogo(Context context, RespuestaDialogo rd){
        this.context = context;
        this.rd = rd;
    }

    /* DIALOGO CON BOTONES CLASICO*/
    public Dialog MostrarDialogoBotones(){

        //Creamos el constructor de dialogos
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        //Añadimos parámetros que necesitemos para el dialogo
        builder.setMessage("Pulsa aceptar")
                .setPositiveButton("Acepto", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Lo que hace al aceptar
                        //Toast.makeText(context,"Has aceptado",Toast.LENGTH_SHORT).show();
                        rd.OnAccept("Has aceptado");
                    }
                })
                .setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        //Lo que hace al cancelar
                        //Toast.makeText(context,"Has cancelado",Toast.LENGTH_SHORT).show();
                        rd.OnCancel("Has cancelado");
                    }
                });

        //devuelves el builder creandolo
        return builder.create();
    }


    /* DIALOGO CON UNA SOLA OPCION(ARRAY) */
    public Dialog DialogoOpcionUnica(){
        //Creamos el constructor de dialogos
        AlertDialog.Builder builder = new AlertDialog.Builder(context);

        builder.setTitle("Elige un color")
                .setItems(R.array.colors_array, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String[] s = context.getResources().getStringArray(R.array.colors_array);
                        Toast.makeText(context, "Has elegido " + s[i], Toast.LENGTH_SHORT).show();
                    }
                });

        //devuelves el builder creandolo
        return builder.create();

    }

    /* DIALOGO PERSONALIZADO */
    public Dialog customDialog(){
        //Creamos el constructor de dialogos
        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        builder.setView(inflater.inflate(R.layout.signin_dialog,null));

        //devuelves el builder creandolo
        return builder.create();
    }


    public interface RespuestaDialogo{
        void OnAccept(String cadena);
        void OnCancel(String cadena);
    }
}
