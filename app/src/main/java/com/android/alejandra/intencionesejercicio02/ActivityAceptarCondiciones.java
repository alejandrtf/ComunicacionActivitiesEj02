package com.android.alejandra.intencionesejercicio02;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityAceptarCondiciones extends Activity {
    protected final static String NOMBRE_BOTON_PULSADO = "boton_pulsado";
    private String nombreBotonPulsado = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_aceptar_condiciones);

        //recojo los datos recibidos
        String nombre = getIntent().getStringExtra(MainActivity.NOMBRE_USUARIO);

        //relleno saludo y pregunta sobre verificación con los datos recibidos
        TextView texto = (TextView) findViewById(R.id.tvPreguntaVerificar);
        texto.setText("Hola " + nombre + ", ¿Aceptas las condiciones");


    }


    /**
     * Método que se ejecuta tanto si se pulsa un botón como otro y
     * devuelve a la activity anterior el nombre del botón pulsado
     *
     * @param v botón pulsado
     */
    public void crearIntentRespuesta(View v) {
        String respuesta = (((Button) v).getId() == R.id.btAceptar) ? "Aceptado" : "Rechazado";

        Intent iRespuesta = new Intent();
        iRespuesta.putExtra(NOMBRE_BOTON_PULSADO, respuesta);
        setResult(RESULT_OK, iRespuesta);
        finish();

    }
}
