package maua.etec.appconsumocombustivel;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    EditText txtDistancia;
    EditText txtVelMed;
    TextView txtConsumo;
    Button btCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtDistancia = (EditText) findViewById(R.id.txtDistancia);
        txtVelMed = (EditText) findViewById(R.id.txtVelMed);
        txtConsumo = (TextView) findViewById(R.id.txtConsumo);
        btCalcular = (Button) findViewById(R.id.btCalcular);

        btCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculaConsumo();
            }
        });
    }

    private void calculaConsumo()
    {
        double distancia= Double.parseDouble(txtDistancia.getText().toString());
        double velMed= Double.parseDouble(txtVelMed.getText().toString());
        double consumo;

        if (velMed<40)
        {
            consumo = distancia/8;
        }
        else if(velMed > 80 )
        {
            consumo = distancia/7;
        }
        else
        {
            consumo = distancia/12;
        }

        txtConsumo.setText(String.format("Consumo %.2f litros de combustivel", consumo));
    }
}
