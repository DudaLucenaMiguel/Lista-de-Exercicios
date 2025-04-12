package br.com.fecapccp.questao5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ResumoDoPedido extends AppCompatActivity {

    private TextView textTamanho, textSabor, textFormaDePagamento, textValor;
    private String tamanhoEscolhido, saborEscolhido, formaDePagamento;
    private float valorTotal;
    private Button btnSet;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_podedio);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textTamanho = findViewById(R.id.textTamanho);
        textSabor = findViewById(R.id.textSabor);
        textFormaDePagamento = findViewById(R.id.textFormaDePagamento);
        textValor = findViewById(R.id.textValor);

        btnSet = findViewById(R.id.btnSet);

        Bundle bundle = getIntent().getExtras();

        tamanhoEscolhido = bundle.getString("tamanhoEscolhido");
        saborEscolhido = bundle.getString("saborEscolhido");
        formaDePagamento = bundle.getString("formaDePagamento");
        valorTotal = bundle.getFloat("valorTotal");

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

        textTamanho.setText(tamanhoEscolhido);
        textSabor.setText(saborEscolhido);
        textFormaDePagamento.setText(formaDePagamento);
        textValor.setText("R$ " + decimalFormat.format(valorTotal));

        btnSet.setOnClickListener(view ->{
            Intent intent = new Intent(this, SelecaoDoSabor.class);
            startActivity(intent);
            finish();
        });
    }
    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    protected void onResume(){
        super.onResume();
    }

    @Override
    protected void onPause(){
        super.onPause();
    }

    @Override
    protected void onDestroy(){
        super.onDestroy();
    }

    @Override
    protected void onStop(){
        super.onStop();
    }

    @Override
    protected void onRestart(){
        super.onRestart();
    }
}