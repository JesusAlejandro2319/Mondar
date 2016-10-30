package mondar.app.jesusobregon.com.mondar;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.util.Random;

public class PrimerRandom extends AppCompatActivity implements View.OnClickListener {

    TableLayout tablaPrimerAleatorio;
    TableLayout columnasAleatoriasPrimerRandom;
    Button boton_randoms, boton_col, boton_cols, boton_randomFinal;
    int columnasLlenas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_primer_random);
        numerosRandom();
        declaracionColumnasRandom();

        boton_randoms = (Button)findViewById(R.id.primerRandom_boton_randoms);
        boton_col = (Button)findViewById(R.id.primerRandom_boton_col);
        boton_cols = (Button)findViewById(R.id.primerRandom_boton_cols);
        boton_randomFinal = (Button)findViewById(R.id.primerRandom_boton_randomFinal);

        boton_randoms.setOnClickListener(this);
        boton_col.setOnClickListener(this);
        boton_cols.setOnClickListener(this);
        boton_randomFinal.setOnClickListener(this);

        columnasLlenas = 1;
    }

    void numerosRandom() {
        tablaPrimerAleatorio = (TableLayout) findViewById(R.id.tablaPrimerRandom);

        Random r;
        int numero;

        for (int i = 1; i <11; i++) {
            TableRow row = new TableRow(this);
            TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
            row.setLayoutParams(lp);

            for (int j = 0; j < 11; j++) {
                if(j == 0) {
                    numero = i;
                }
                else{
                    r = new Random();
                    numero = r.nextInt(10 - 1) + 1;
                }

                TextView vista = new TextView(this);
                vista.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));

                vista.setText(String.valueOf(numero));
                vista.setGravity(Gravity.CENTER);

                if(j == 0){
                    vista.setBackground(ContextCompat.getDrawable(this, R.drawable.alt_color_row));
                }
                else {
                    vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_color));
                    vista.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
                }

                row.addView(vista);

            }

            tablaPrimerAleatorio.addView(row);
        }

    }

    void declaracionColumnasRandom() {
        columnasAleatoriasPrimerRandom = (TableLayout) findViewById(R.id.columnasAleatoriasPrimerRandom);

        TableRow row = new TableRow(this);
        TableRow.LayoutParams lp = new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT);
        row.setLayoutParams(lp);

        for (int i = 0; i < 11; i++) {
            TextView vista = new TextView(this);
            vista.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT));
            vista.setGravity(Gravity.CENTER);
            if(i==1) {
                vista.setId(R.id.columnaAleatoria1);
            }else{
                if(i==2){
                    vista.setId(R.id.columnaAleatoria2);
                }
                else{
                    if(i==3) {
                        vista.setId(R.id.columnaAleatoria3);
                    }
                    else {
                        if(i==4){
                            vista.setId(R.id.columnaAleatoria4);
                        }
                        else{
                            if(i==5){
                                vista.setId(R.id.columnaAleatoria5);
                            }
                            else{
                                if(i==6){
                                    vista.setId(R.id.columnaAleatoria6);
                                }
                                else {
                                    if(i==7){
                                        vista.setId(R.id.columnaAleatoria7);
                                    }
                                    else{
                                        if(i==8){
                                            vista.setId(R.id.columnaAleatoria8);
                                        }
                                        else{
                                            if(i==9){
                                                vista.setId(R.id.columnaAleatoria9);
                                            }
                                            else{
                                                if(i==10){
                                                    vista.setId(R.id.columnaAleatoria10);
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

            if(i == 0) {
                vista.setText(R.string.cols);
                vista.setBackground(ContextCompat.getDrawable(this, R.drawable.alt_color_row));
            }
            else {
                vista.setText("");
                vista.setBackground(ContextCompat.getDrawable(this, R.drawable.row_color));
                vista.setTextColor(ContextCompat.getColor(this, R.color.colorNumeros));
            }

            row.addView(vista);

        }

        columnasAleatoriasPrimerRandom.addView(row);

    }

    void llenarCol() {
        TextView vista;
        int i = columnasLlenas;

        Random r;
        int numero;
        r = new Random();
        numero = r.nextInt(10 - 1) + 1;


        if(i==1) {
            vista = (TextView) findViewById(R.id.columnaAleatoria1);
        }else{
            if(i==2){
                vista = (TextView) findViewById(R.id.columnaAleatoria2);
            }
            else{
                if(i==3) {
                    vista = (TextView) findViewById(R.id.columnaAleatoria3);
                }
                else {
                    if(i==4){
                        vista = (TextView) findViewById(R.id.columnaAleatoria4);
                    }
                    else{
                        if(i==5){
                            vista = (TextView) findViewById(R.id.columnaAleatoria5);
                        }
                        else{
                            if(i==6){
                                vista = (TextView) findViewById(R.id.columnaAleatoria6);
                            }
                            else {
                                if(i==7){
                                    vista = (TextView) findViewById(R.id.columnaAleatoria7);
                                }
                                else{
                                    if(i==8){
                                        vista = (TextView) findViewById(R.id.columnaAleatoria8);
                                    }
                                    else{
                                        if(i==9){
                                            vista = (TextView) findViewById(R.id.columnaAleatoria9);
                                        }
                                        else{
                                            if(i==10){
                                                vista = (TextView) findViewById(R.id.columnaAleatoria10);
                                            }
                                            else {
                                                vista = new TextView(this);
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
        columnasLlenas++;
    }

    void llenarCols(){
        TextView vista;
        Random r;
        int numero;

        if(columnasLlenas != 11) {
            for (int i = columnasLlenas; i < 11; i++) {

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
                                                    } else {
                                                        vista = new TextView(this);
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
            }
            columnasLlenas = 11;
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.primerRandom_boton_randoms:
                Intent intent = new Intent(PrimerRandom.this, Randoms.class);
                startActivity(intent);
                break;
            case R.id.primerRandom_boton_col:
                llenarCol();
                break;
            case R.id.primerRandom_boton_cols:
                llenarCols();
                break;
            case R.id.primerRandom_boton_randomFinal:
                //ir a otra actividad
                break;
        }
    }
}
