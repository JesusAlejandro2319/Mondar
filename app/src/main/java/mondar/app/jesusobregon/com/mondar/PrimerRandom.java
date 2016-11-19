package mondar.app.jesusobregon.com.mondar;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Handler;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class PrimerRandom extends AppCompatActivity implements View.OnClickListener {

    TableLayout tablaPrimerAleatorio;
    TableLayout columnasAleatoriasPrimerAleatorio;
    Button boton_randoms, boton_otraVez, boton_detener, boton_randomFinal;
    int registrosLLenos, suma=0;
    Boolean bandera = Boolean.FALSE, completo = Boolean.FALSE;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_random);
        crearTablaPrimerAleatorio();

        boton_randoms = (Button)findViewById(R.id.primerRandom_boton_randoms);
        boton_otraVez = (Button)findViewById(R.id.primerRandom_boton_otraVez);
        boton_randomFinal = (Button)findViewById(R.id.primerRandom_boton_randomFinal);

        boton_randoms.setOnClickListener(this);
        boton_otraVez.setOnClickListener(this);
        boton_randomFinal.setOnClickListener(this);

        boton_detener = (Button)findViewById(R.id.primerRandom_boton_detener);
        boton_detener.setOnTouchListener(new View.OnTouchListener() {

            private Handler mHandler;

            public boolean onTouch(View v, MotionEvent me) {
                switch(me.getAction()) {
                    case MotionEvent.ACTION_UP:
                        if(bandera == Boolean.FALSE) {
                            if (mHandler != null) return true;
                            mHandler = new Handler();
                            mHandler.postDelayed(mAction, 50);
                        }
                        break;
                    case MotionEvent.ACTION_DOWN:
                        if (mHandler == null) return true;
                        mHandler.removeCallbacks(mAction);
                        mHandler = null;
                        bandera = Boolean.TRUE;
                        pintarCuadros();
                        break;
                }
                return false;
            }

            Runnable mAction = new Runnable() {
                @Override public void run() {
                    llenarTablaAleatoriamente();
                    llenarColumnasAleatorias();
                    mHandler.postDelayed(this, 50);
                }
            };
        });

        long downTime = 100;
        long eventTime = 100;
        float x = (float) boton_randomFinal.getLeft() + 5;
        float y = (float) boton_randomFinal.getTop() + 5;
        int metaState = 0;
        MotionEvent motionEvent = MotionEvent.obtain(
                downTime,
                eventTime,
                MotionEvent.ACTION_UP,
                x,
                y,
                metaState
        );

        boton_detener.dispatchTouchEvent(motionEvent);
    }

    void crearTablaPrimerAleatorio(){
        tablaPrimerAleatorio = (TableLayout) findViewById(R.id.tablaPrimerRandom);
        for (int i = 1; i < 11; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            for (int j = 0; j < 11; j++) {

                TextView vista = new TextView(this);
                vista.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
                if(j==0) {
                    vista.setText(String.valueOf(i));
                    vista.setTag("InicioFila" + i);
                }else {
                    vista.setText(String.valueOf("0"));
                    vista.setTag(i +","+j);
                    registrosLLenos++;
                }
                vista.setGravity(Gravity.CENTER);

                if (j == 0) {
                    vista.setBackground(ContextCompat.getDrawable(this, R.drawable.alt_color_row));
                } else {
                    vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_color));
                    vista.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
                }

                row.addView(vista);

            }

            tablaPrimerAleatorio.addView(row);
        }
    }

    void llenarTablaAleatoriamente() {
        TextView vista;
        //int i = 0;
        Random r;
        int numero;

        View vistas = findViewById(R.id.tablaPrimerRandom);

        for (int i = 1; i < 11; i++) {

            for (int j = 1; j < 11; j++) {

                vista = (TextView)  vistas.findViewWithTag(i +","+j);

                r = new Random();
                numero = r.nextInt(10 - 1) + 1;
                vista.setText(String.valueOf(numero));
            }
        }

    }

    void llenarColumnasAleatorias(){
        TextView vista = new TextView(this);
        Random r;
        int numero;

        for (int i = 0; i < 11; i++) {

            r = new Random();
            numero = r.nextInt(10 - 1) + 1;

            if (i == 1) {
                vista = (TextView) findViewById(R.id.columnaAleatoria1);
            } else {
                if (i == 2) {
                    vista = (TextView) findViewById(R.id.columnaAleatoria2);
                } else {
                    if (i == 3) {
                        vista = (TextView) findViewById(R.id.columnaAleatoria3);
                    } else {
                        if (i == 4) {
                            vista = (TextView) findViewById(R.id.columnaAleatoria4);
                        } else {
                            if (i == 5) {
                                vista = (TextView) findViewById(R.id.columnaAleatoria5);
                            } else {
                                if (i == 6) {
                                    vista = (TextView) findViewById(R.id.columnaAleatoria6);
                                } else {
                                    if (i == 7) {
                                        vista = (TextView) findViewById(R.id.columnaAleatoria7);
                                    } else {
                                        if (i == 8) {
                                            vista = (TextView) findViewById(R.id.columnaAleatoria8);
                                        } else {
                                            if (i == 9) {
                                                vista = (TextView) findViewById(R.id.columnaAleatoria9);
                                            } else {
                                                if (i == 10) {
                                                    vista = (TextView) findViewById(R.id.columnaAleatoria10);
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
            }
            vista.setText(String.valueOf(numero));
            vista.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
        }
    }

    void pintarCuadros() {
        View vistas = findViewById(R.id.tablaPrimerRandom);
        TextView vista;
        String filaTexto, valor;
        int i;

        //1
        vista = (TextView)findViewById(R.id.columnaAleatoria1);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+1);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //2
        vista = (TextView)findViewById(R.id.columnaAleatoria2);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+2);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //3
        vista = (TextView)findViewById(R.id.columnaAleatoria3);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+3);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //4
        vista = (TextView)findViewById(R.id.columnaAleatoria4);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+4);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //5
        vista = (TextView)findViewById(R.id.columnaAleatoria5);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+5);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //6
        vista = (TextView)findViewById(R.id.columnaAleatoria6);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+6);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //7
        vista = (TextView)findViewById(R.id.columnaAleatoria7);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+7);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //8
        vista = (TextView)findViewById(R.id.columnaAleatoria8);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+8);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //9
        vista = (TextView)findViewById(R.id.columnaAleatoria9);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+9);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        //10
        vista = (TextView)findViewById(R.id.columnaAleatoria10);
        filaTexto = vista.getText().toString();
        i = Integer.parseInt(filaTexto);
        vista = (TextView)  vistas.findViewWithTag(i+","+10);
        vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_red));
        valor = vista.getText().toString();
        suma = suma + Integer.parseInt(valor);

        completo = Boolean.TRUE;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.primerRandom_boton_randoms:
                finish();
                Intent intent = new Intent(PrimerRandom.this, Randoms.class);
                startActivity(intent);
                break;
            case R.id.primerRandom_boton_otraVez:
                finish();
                Intent intent2 = getIntent();
                finish();
                startActivity(intent2);
                break;
            case R.id.primerRandom_boton_randomFinal:
                if(completo == Boolean.TRUE) {
                    finish();
                    Intent intent3 = new Intent(PrimerRandom.this, ResultadoFinal.class);
                    intent3.putExtra("Dato",suma);
                    startActivity(intent3);
                }
                else {
                    Toast.makeText(getApplicationContext(), "¡Aún no detienes el random!",Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }
}
