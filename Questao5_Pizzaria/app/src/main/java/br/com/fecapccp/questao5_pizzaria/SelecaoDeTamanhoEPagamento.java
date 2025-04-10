package br.com.fecapccp.questao5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
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

public class SelecaoDeTamanhoEPagamento extends AppCompatActivity {

    private RadioButton rbPequena, rbMedia, rbGrande, rbDebito, rbCredito, rbPix, rbDinheiro;
    private Button btnSet;
    private String saborEscolhido, tamanhoEscolhido, formaDePagamento;

    private TextView textPrecoPequena, textPrecoMedia, textPrecoGrande;
    private float precoPequena,precoMedia, precoGrande, valorTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_de_tamanho_epagamento);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnSet = findViewById(R.id.btnSet);

        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);

        rbDebito = findViewById(R.id.rbDebito);
        rbCredito = findViewById(R.id.rbCredito);
        rbPix = findViewById(R.id.rbPix);
        rbDinheiro = findViewById(R.id.rbDinheiro);

        textPrecoPequena = findViewById(R.id.textPrecoPequena);
        textPrecoMedia = findViewById(R.id.textPrecoMedia);
        textPrecoGrande = findViewById(R.id.textPrecoGrande);

        DefinirValoresDasPizzas();

        Bundle bundle = getIntent().getExtras();

        saborEscolhido = bundle.getString("saborEscolhido");

        btnSet.setOnClickListener(view -> {
            ChecarOpcoes();
            Intent intent = new Intent(this, ResumoDoPodedio.class);

            intent.putExtra("tamanhoEscolhido", tamanhoEscolhido);
            intent.putExtra("formaDePagamento", formaDePagamento);
            intent.putExtra("saborEscolhido", saborEscolhido);
            intent.putExtra("valorTotal", valorTotal);

            startActivity(intent);
            finish();
        });

    }

    public void ChecarOpcoes(){


        if(rbPequena.isChecked()){
            tamanhoEscolhido = rbPequena.getText().toString();
            valorTotal = precoPequena;
        }
        if(rbMedia.isChecked()){
            tamanhoEscolhido = rbMedia.getText().toString();
            valorTotal = precoMedia;
        }
        if(rbGrande.isChecked()){
            tamanhoEscolhido = rbMedia.getText().toString();
            valorTotal = precoGrande;
        }

        if(rbDebito.isChecked()){
            formaDePagamento = rbDebito.getText().toString();
        }
        if(rbCredito.isChecked()){
            formaDePagamento = rbCredito.getText().toString();
        }
        if(rbPix.isChecked()){
            formaDePagamento = rbPix.getText().toString();
        }
        if(rbDinheiro.isChecked()){
            formaDePagamento = rbDinheiro.getText().toString();
        }
    }
    public void DefinirValoresDasPizzas(){

        precoPequena = 34.90f;
        precoMedia = 54.90f;
        precoGrande = 74.90f;

        DecimalFormatSymbols symbols = new DecimalFormatSymbols(new Locale("pt", "BR"));
        DecimalFormat decimalFormat = new DecimalFormat("0.00", symbols);

        textPrecoPequena.setText("R$" + decimalFormat.format(precoPequena));
        textPrecoMedia.setText("R$" + decimalFormat.format(precoMedia));
        textPrecoGrande.setText("R$" + decimalFormat.format(precoGrande));
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