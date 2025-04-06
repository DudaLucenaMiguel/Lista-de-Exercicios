package br.com.fecapccp.questao3_temdetudo;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ConfirmacaoDeCadastro extends AppCompatActivity {

    private TextView textNome;
    private Button btnBack;
    private String nome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_confirmacao_de_cadastro);

        textNome = findViewById(R.id.textNome);
        btnBack = findViewById(R.id.btnBack);
        Bundle bundle = getIntent().getExtras();

        nome = bundle.getString("nome");

        textNome.setText(nome);

        btnBack.setOnClickListener(view -> {
            Intent intent = new Intent(this, TelaDeBoasVindas.class);
            startActivity(intent);
            finish();
        });

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
}