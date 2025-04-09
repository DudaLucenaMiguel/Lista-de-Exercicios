package br.com.lanchefacil.www;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FormularioDePedidos extends AppCompatActivity {

    private EditText editTextNome;
    private Button btnSetLanche1,btnSetLanche2, btnSetLanche3, btnSetLanche4, btnSet;
    private LinearLayout layerLanche1,layerLanche2, layerLanche3, layerLanche4;
    private LinearLayout [] layouts;
    private int indexLancheEscolhido = 1000;
    private String nome = "";
    private String nomeDoLanche = "";
    private float precoDoLanche;

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

        layerLanche1 = findViewById(R.id.layerLanche1);
        layerLanche2 = findViewById(R.id.layerLanche2);
        layerLanche3 = findViewById(R.id.layerLanche3);
        layerLanche4 = findViewById(R.id.layerLanche4);

        btnSet = findViewById(R.id.btnSet);

        layouts = new LinearLayout[4];

        layouts[0] = layerLanche1;
        layouts[1] = layerLanche2;
        layouts[2] = layerLanche3;
        layouts[3] = layerLanche4;



        btnSetLanche1.setOnClickListener(view -> {
            mudarCorDaLayer(0);
            nomeDoLanche = "X-Burguer";
            precoDoLanche = 19.90f;
        });
        btnSetLanche2.setOnClickListener(view -> {
            mudarCorDaLayer(1);
            nomeDoLanche = "X-Frango";
            precoDoLanche = 19.90f;
        });
        btnSetLanche3.setOnClickListener(view -> {
            mudarCorDaLayer(2);
            nomeDoLanche = "X-Bacon";
            precoDoLanche = 19.90f;
        });
        btnSetLanche4.setOnClickListener(view -> {
            mudarCorDaLayer(3);
            nomeDoLanche = "X-Salada";
            precoDoLanche = 19.90f;
        });

        btnSet.setOnClickListener(view -> {
            nome = editTextNome.getText().toString();

            Intent intent = new Intent(this, ResumoDoPedido.class);

            intent.putExtra("nome", nome);
            intent.putExtra("precoDoLanche", precoDoLanche);
            intent.putExtra("nomeDoLanche", nomeDoLanche);

            startActivity(intent);
            finish();
        });


    }
    public void mudarCorDaLayer(int index){
        for(int i = 0; i<4; i++){
            if(index == i){
                layouts[i].setBackgroundColor(Color.rgb(253, 235, 208 ));
            }
            else{
                layouts[i].setBackgroundColor(Color.argb(0,0,0,0));
            }
        }
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