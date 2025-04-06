package br.com.fecapccp.questao1_supermercado;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
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

    private TextView textTotal;
    private CheckBox checkArroz, checkLeite, checkCarne, checkFeijao, checkRefrigerante;
    private Button btnSet;
    private float precoArroz;
    private float precoLeite;
    private float precoCarne;
    private float precoFeijao;
    private float precoRefrigerante;
    private float total;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);

        textTotal = findViewById(R.id.textTotal);
        checkArroz = findViewById(R.id.checkArroz);
        checkLeite = findViewById(R.id.checkLeite);
        checkCarne = findViewById(R.id.checkCarne);
        checkFeijao = findViewById(R.id.checkFeijao);
        checkRefrigerante = findViewById(R.id.checkRefrigerante);
        btnSet = findViewById(R.id.btnSet);

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat formato = new DecimalFormat("0.00", symbols);

        precoArroz =  2.69f;
        precoLeite =  2.70f;
        precoCarne =  16.70f;
        precoFeijao =  3.38f;
        precoRefrigerante = 3f;

        btnSet.setOnClickListener(view -> {
            total = 0;
            if(checkArroz.isChecked()){
                total = total + precoArroz;
            }
            if(checkLeite.isChecked()){
                total = total + precoLeite;
            }
            if(checkCarne.isChecked()){
                total = total + precoCarne;
            }
            if(checkFeijao.isChecked()){
                total = total + precoFeijao;
            }
            if(checkRefrigerante.isChecked()){
                total = total + precoRefrigerante;
            }
            textTotal.setText("Total da compra: R$" + formato.format(total));
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}