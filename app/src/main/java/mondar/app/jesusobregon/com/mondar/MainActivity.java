package mondar.app.jesusobregon.com.mondar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button boton1, boton2, boton3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boton1 = (Button)findViewById(R.id.boton1);
        boton2 = (Button)findViewById(R.id.boton2);
        boton3 = (Button)findViewById(R.id.boton3);

        boton1.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.boton1:
                //ir a otra actividad
                Intent intent = new Intent(MainActivity.this, Randoms.class);
                startActivity(intent);
                break;
            case R.id.boton2:
                //ir a otra actividad
                break;
            case R.id.boton3:
                //cerrar
                break;
        }
    }
}
