package physics.ohmslaw;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Получаем кнопку из интерфейса
        Button calcR = (Button) findViewById(R.id.calcR);
        Button calcI = (Button) findViewById(R.id.calcI);
        Button calcU = (Button) findViewById(R.id.calcU);

        // Получаем поля для значений из интерфейса
        final EditText editR = (EditText) findViewById(R.id.R);
        final EditText editU = (EditText) findViewById(R.id.U);
        final EditText editI = (EditText) findViewById(R.id.I);

        // Берем кнопку рассчёта сопротивления и добавляем обработчик
        calcR.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // R = U / I
                double U = Double.valueOf(editU.getText().toString());
                double I = Double.valueOf(editI.getText().toString());
                double R = U / I;
                editR.setText(Double.toString(R));
            }

        });

        calcI.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double U = Double.valueOf(editU.getText().toString());
                double R = Double.valueOf(editR.getText().toString());
                double I = U / R;
                editI.setText(Double.toString(I));
            }
        });

        calcU.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double I = Double.valueOf(editI.getText().toString());
                double R = Double.valueOf(editR.getText().toString());
                double U = I * R;
                editU.setText(Double.toString(U));
            }
        });
    }
}
