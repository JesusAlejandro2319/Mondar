package mondar.app.jesusobregon.com.mondar;

import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultadoFinal extends AppCompatActivity implements View.OnClickListener {
    int suma;
    Button botonPrimerRandom, botonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado_final);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        if(extras!=null) {
            botonPrimerRandom = (Button) findViewById(R.id.resultadoFinal_botonRegresar);
            botonInicio = (Button) findViewById(R.id.resultadoFinal_boton_inicio);

            botonPrimerRandom.setOnClickListener(this);
            botonInicio.setOnClickListener(this);

            suma = extras.getInt("Dato");

            ImageView circulo = (ImageView) findViewById(R.id.circuloResultadoFinal);
            TextView cantidadFinal = (TextView) findViewById(R.id.sumaResultadoFinal);
            TextView mensajeRF = (TextView) findViewById(R.id.mensajeResultadoFinal);
            if(suma <= 69){
                circulo.setBackground(ContextCompat.getDrawable(this, R.drawable.circulo_rojo));
                cantidadFinal.setText(String.valueOf(suma));
                cantidadFinal.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
                if(suma == 69){
                    mensajeRF.setText("'El puso puntos suspensivos, ella cansada, le borró dos.' ¿Y si les pides el punto que les sobro? No creo que lo vayan a necesitar.");
                }
                else {
                    mensajeRF.setText("¡Sigue particicipando!");
                }
            }
            else{
                if(suma >= 70 && suma <= 85){
                    circulo.setBackground(ContextCompat.getDrawable(this, R.drawable.circulo_rojo));
                    cantidadFinal.setText(String.valueOf(suma));
                    cantidadFinal.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
                    mensajeRF.setText("¡GG!");
                }
                else{
                    circulo.setBackground(ContextCompat.getDrawable(this, R.drawable.circulo_rojo));
                    cantidadFinal.setText(String.valueOf(suma));
                    cantidadFinal.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
                    mensajeRF.setText("¡Tu suerte no se puede comparar a ninguna!");
                }
            }
        }

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.resultadoFinal_botonRegresar:
                finish();
                Intent intent = new Intent(ResultadoFinal.this, PrimerRandom.class);
                startActivity(intent);
                break;
            case R.id.resultadoFinal_boton_inicio:
                finish();
                Intent intent2 = new Intent(ResultadoFinal.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }



}
