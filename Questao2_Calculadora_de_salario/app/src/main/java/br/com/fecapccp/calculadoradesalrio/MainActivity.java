package br.com.fecapccp.calculadoradesalrio;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private TextView textResultado;
    private EditText editTextSalario;
    private RadioButton rb40Percent, rb45Percent, rb50Percent;
    private Button btnSet;
    private float Salario;
    private float aumento;
    private float NovoSalario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textResultado = findViewById(R.id.textResultado);
        editTextSalario = findViewById(R.id.editTextSalario);
        rb40Percent = findViewById(R.id.rb40Percent);
        rb45Percent = findViewById(R.id.rb45Percent);
        rb50Percent = findViewById(R.id.rb50Percent);
        btnSet = findViewById(R.id.btnSet);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formato = new DecimalFormat("0.00", symbols);

        btnSet.setOnClickListener(view -> {
            Salario = Float.parseFloat(editTextSalario.getText().toString());
            aumento = 0;
            if(rb40Percent.isChecked()){
                aumento = 40f;
            }
            else if (rb45Percent.isChecked()) {
                aumento = 45f;
            }
            else if (rb50Percent.isChecked()) {
                aumento = 50f;
            }
            NovoSalario = Salario*(1+aumento/100);

            textResultado.setText("Novo Salário: " + formato.format(NovoSalario));

        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}