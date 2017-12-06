package com.android.alejandra.intencionesejercicio02;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    protected final static String NOMBRE_USUARIO = "nombre_usuario";
    protected final static int CODIGO_RESPUESTA_VERIFICAR = 1;
    private EditText nombre;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //referencias
        nombre = (EditText) findViewById(R.id.etNombre);
        Button btVerificar = (Button) findViewById(R.id.btVerificar);

        //boton verificar
        btVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(MainActivity.this, ActivityAceptarCondiciones.class);
                i.putExtra(NOMBRE_USUARIO, nombre.getText().toString());
                startActivityForResult(i, CODIGO_RESPUESTA_VERIFICAR);
            }
        });
    }

    //recojo resultados devueltos por la otra activity

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CODIGO_RESPUESTA_VERIFICAR && resultCode == RESULT_OK) {
            String resultadoVerificacion = data.getStringExtra(ActivityAceptarCondiciones.NOMBRE_BOTON_PULSADO);
            ((TextView) findViewById(R.id.tvResultado)).setText("Resultado: " + resultadoVerificacion);
        }
    }
}
