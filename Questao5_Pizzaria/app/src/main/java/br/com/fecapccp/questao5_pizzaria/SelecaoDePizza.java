package br.com.fecapccp.questao5_pizzaria;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class SelecaoDePizza extends AppCompatActivity {

    private CheckBox cbCalabresa, cbFrancoComCatupiry, cbPortuguesa;
    private Button btnSet;
    private String saborEscolhido;
    private TextView textResumo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_selecao_de_pizza);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        cbCalabresa = findViewById(R.id.cbCalabresa);
        cbFrancoComCatupiry = findViewById(R.id.cbFrancoComCatupiry);
        cbPortuguesa = findViewById(R.id.cbPortuguesa);
        btnSet = findViewById(R.id.btnSet);
        textResumo = findViewById(R.id.textResumo);

        cbCalabresa.setOnClickListener(view->{
            EscolherSabor();
        });
        cbFrancoComCatupiry.setOnClickListener(view->{
            EscolherSabor();
        });
        cbPortuguesa.setOnClickListener(view->{
            EscolherSabor();
        });

        btnSet.setOnClickListener(view -> {
            Intent intent = new Intent(this, SelecaoDeTamanhoEPagamento.class);
            intent.putExtra("saborEscolhido", saborEscolhido);
            startActivity(intent);
        });
    }

    public void EscolherSabor(){
        saborEscolhido = "";

        if(cbCalabresa.isChecked()){
            saborEscolhido = "" + cbCalabresa.getText();
        }
        if(cbPortuguesa.isChecked()){
            saborEscolhido = ""+ cbPortuguesa.getText();
        }
        if(cbFrancoComCatupiry.isChecked()){
            saborEscolhido = ""+ cbPortuguesa.getText();
        }
        if(cbCalabresa.isChecked() && cbFrancoComCatupiry.isChecked()){
            saborEscolhido = " 1/2 " +  cbCalabresa.getText() + "\n" + " 1/2 " + cbFrancoComCatupiry.getText();
        }
        if(cbCalabresa.isChecked() && cbPortuguesa.isChecked()){
            saborEscolhido = " 1/2 " + cbCalabresa.getText() + "\n" + " 1/2 " + cbPortuguesa.getText();
        }
        if(cbPortuguesa.isChecked() && cbFrancoComCatupiry.isChecked()){
            saborEscolhido = " 1/2 " + cbPortuguesa.getText() +"\n" + " 1/2 " + cbFrancoComCatupiry.getText();
        }
        if(cbCalabresa.isChecked() && cbPortuguesa.isChecked() && cbFrancoComCatupiry.isChecked()){
            saborEscolhido = " 1/3 "+ cbCalabresa.getText() + "\n" + " 1/3 " + cbPortuguesa.getText() + "\n" + " 1/3 " + cbFrancoComCatupiry.getText();
        }
        textResumo.setText("" + saborEscolhido);
    }
}