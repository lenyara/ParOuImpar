package br.edu.ifsp.scl.sdm.parouimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Random;

import br.edu.ifsp.scl.sdm.parouimpar.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ActivityMainBinding activityMainBinding;
    // substituido pela linha de código acima
    //private RadioGroup opcaoRg;
    //private Button zeroBt;
    //private Button umBt;
    //private Button doisBt;
    //private Button tresBt;
    //private Button quatroBt;
    //private Button cincoBt;
    //private TextView resultadoTv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        activityMainBinding = ActivityMainBinding.inflate(getLayoutInflater());

        //setContentView(R.layout.activity_main);
        setContentView(activityMainBinding.getRoot());

        // substituido pela linha de código acima
        //opcaoRg = findViewById(R.id.opcaoRg);
        //zeroBt = findViewById(R.id.zeroBt);
        //umBt = findViewById(R.id.umBt);
        //doisBt = findViewById(R.id.doisBt);
        //tresBt = findViewById(R.id.tresBt);
        //quatroBt = findViewById(R.id.quatroBt);
        //cincoBt = findViewById(R.id.cincoBt);
        //resultadoTv = findViewById(R.id.resultadoTv);

        activityMainBinding.zeroBt.setOnClickListener(this);
        activityMainBinding.umBt.setOnClickListener(this);
        activityMainBinding.doisBt.setOnClickListener(this);
        activityMainBinding.tresBt.setOnClickListener(this);
        activityMainBinding.quatroBt.setOnClickListener(this);
        activityMainBinding.cincoBt.setOnClickListener(this);

        activityMainBinding.mostrarOpcoesSw.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean mostrarOpcoes) {
                activityMainBinding.selecionarLl.setVisibility(mostrarOpcoes? View.VISIBLE : View.GONE);
            }
        });
    }

    @Override
    public void onClick(View view) {
        int jogada = -1;
        switch (view.getId()){
            case R.id.zeroBt:
                jogada = 0;
                break;
            case R.id.umBt:
                jogada = 1;
                break;
            case R.id.doisBt:
                jogada = 2;
                break;
            case R.id.tresBt:
                jogada = 3;
                break;
            case R.id.quatroBt:
                jogada = 4;
                break;
            case R.id.cincoBt:
                jogada = 5;
                break;
            default:
                break;
        }
        jogarParOuImpar(jogada);
    }

    private void jogarParOuImpar(int jogada){
        Random random = new Random(System.currentTimeMillis());
        int jogadaComputador = random.nextInt(6);

        int imagemJogadaComputador = -1;

        switch (jogadaComputador){
            case 0:
                imagemJogadaComputador = R.mipmap.zero;
                break;
            case 1:
                imagemJogadaComputador = R.mipmap.one;
                break;
            case 2:
                imagemJogadaComputador = R.mipmap.two;
                break;
            case 3:
                imagemJogadaComputador = R.mipmap.three;
                break;
            case 4:
                imagemJogadaComputador = R.mipmap.four;
                break;
            case 5:
                imagemJogadaComputador = R.mipmap.five;
                break;
            default:
                break;
        }

        activityMainBinding.jogadaComputadorIv.setImageResource(imagemJogadaComputador);

        StringBuilder resultadoSb = new StringBuilder();
        resultadoSb.append("Sua jogada = ");
        resultadoSb.append(jogada);
        resultadoSb.append(", Computador = ");
        resultadoSb.append(jogadaComputador);

        if (activityMainBinding.parRb.isChecked()){
            resultadoSb.append( (jogada+jogadaComputador) % 2 == 0? ". Você GANHOU!" : ". Você PERDEU!");
        }
        else {
            resultadoSb.append( (jogada+jogadaComputador) % 2 == 0? ". Você PERDEU!" : ". Você GANHOU!");
        }
        activityMainBinding.resultadoTv.setText(resultadoSb.toString());
        }
}