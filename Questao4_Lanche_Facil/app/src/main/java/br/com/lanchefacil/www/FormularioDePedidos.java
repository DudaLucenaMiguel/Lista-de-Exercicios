package br.com.lanchefacil.www;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioDePedidos extends AppCompatActivity {

    private EditText editTextNome;
    private Button btnSetLanche1,btnSetLanche2, btnSetLanche3, btnSetLanche4, btnSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_formulario_de_pedidos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        editTextNome = findViewById(R.id.editTextNome);
        btnSetLanche1 = findViewById(R.id.btnSetLanche1);
        btnSetLanche2 = findViewById(R.id.btnSetLanche2);
        btnSetLanche3 = findViewById(R.id.btnSetLanche3);
        btnSetLanche4 = findViewById(R.id.btnSetLanche4);
        btnSet = findViewById(R.id.btnSet);
    }
}