package br.com.lanchefacil.www;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.text.DecimalFormatSymbols;
import java.text.DecimalFormat;
import java.util.Locale;

public class ResumoDoPedido extends AppCompatActivity {

    private TextView textNomeDoLanche, textTotal, textNome;
    private String nome, nomeDoLanche;
    private float precoDoLanche;
    private Button btnSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_do_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textNomeDoLanche = findViewById(R.id.textNomeDoLanche);
        textTotal = findViewById(R.id.textTotal);
        textNome = findViewById(R.id.textNome);
        btnSet = findViewById(R.id.btnSet);

        Bundle bundle = getIntent().getExtras();

        nome = bundle.getString("nome");
        nomeDoLanche = bundle.getString("nomeDoLanche");
        precoDoLanche = bundle.getFloat("precoDoLanche");

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

        textNomeDoLanche.setText("- 1x - " + nomeDoLanche);
        textTotal.setText("R$" + decimalFormat.format(precoDoLanche));
        textNome.setText(nome + ",");

        btnSet.setOnClickListener(view -> {
            Intent intent = new Intent(this, TelaDeBoasVindas.class);
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