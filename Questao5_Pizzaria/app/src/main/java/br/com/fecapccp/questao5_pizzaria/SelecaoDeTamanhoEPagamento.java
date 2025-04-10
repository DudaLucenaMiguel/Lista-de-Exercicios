package br.com.fecapccp.questao5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoDeTamanhoEPagamento extends AppCompatActivity {

    private RadioButton rbPequena, rbMedia, rbGrande, rbDebito, rbCredito, rbPix, rbDinheiro;
    private Button btnSet;
    private String saborEscolhido, tamanhoEscolhido, formaDePagamento;

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

        rbPequena = findViewById(R.id.rbPequena);
        rbMedia = findViewById(R.id.rbMedia);
        rbGrande = findViewById(R.id.rbGrande);

        rbDebito = findViewById(R.id.rbDebito);
        rbCredito = findViewById(R.id.rbCredito);
        rbPix = findViewById(R.id.rbPix);
        rbDinheiro = findViewById(R.id.rbDinheiro);

        btnSet = findViewById(R.id.btnSet);

        Bundle bundle = getIntent().getExtras();

        saborEscolhido = bundle.getString("saborEscolhido");

        if(rbPequena.isChecked()){
            tamanhoEscolhido = rbPequena.getText().toString();
        }
        if(rbMedia.isChecked()){
            tamanhoEscolhido = rbMedia.getText().toString();
        }
        if(rbMedia.isChecked()){
            tamanhoEscolhido = rbMedia.getText().toString();
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


        btnSet.setOnClickListener(view -> {
            Intent intent = new Intent(this, ResumoDoPodedio.class);

            intent.putExtra("tamanhoEscolhido", tamanhoEscolhido);
            intent.putExtra("formaDePagamento", formaDePagamento);
            intent.putExtra("saborEscolhido", saborEscolhido);

            startActivity(intent);
            finish();
        });

    }
}