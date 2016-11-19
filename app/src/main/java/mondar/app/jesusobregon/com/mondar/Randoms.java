package mondar.app.jesusobregon.com.mondar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Randoms extends AppCompatActivity implements View.OnClickListener {

    Button botonPrimerRandom, botonInicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randoms);

        botonPrimerRandom = (Button) findViewById(R.id.botonPrimerRandom);
        botonInicio = (Button) findViewById(R.id.randoms_boton_inicio);

        botonPrimerRandom.setOnClickListener(this);
        botonInicio.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonPrimerRandom:
                finish();
                Intent intent = new Intent(Randoms.this, PrimerRandom.class);
                startActivity(intent);
                break;
            case R.id.randoms_boton_inicio:
                finish();
                Intent intent2 = new Intent(Randoms.this, MainActivity.class);
                startActivity(intent2);
                break;
        }
    }
}
