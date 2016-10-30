package mondar.app.jesusobregon.com.mondar;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Randoms extends AppCompatActivity implements View.OnClickListener {

    Button botonPrimerRandom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_randoms);

        botonPrimerRandom = (Button) findViewById(R.id.botonPrimerRandom);
        botonPrimerRandom.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.botonPrimerRandom:
                Intent intent = new Intent(Randoms.this, PrimerRandom.class);
                startActivity(intent);
                break;
        }
    }
}
