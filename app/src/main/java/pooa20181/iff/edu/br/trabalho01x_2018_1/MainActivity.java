package pooa20181.iff.edu.br.trabalho01x_2018_1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public EditText edtTamanho;
    private Button btnCalc;
    private TextView tMens;
    private TextView tMens2;
    private TextView tMens3;



    private float metros;
    private float litros;
    private int lata;
    private int galao;
    private float vLata;
    private float vgalao;
    private int mrLata;
    private int mrGalao;
    private float mvLata;
    private float mvGalao;
    private float resto;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtTamanho = (EditText) findViewById(R.id.edtTamanho);
        btnCalc = (Button) findViewById(R.id.btnCalc);
        tMens = (TextView) findViewById(R.id.tMens);
        tMens2 = (TextView) findViewById(R.id.tMens2);
        tMens3 = (TextView) findViewById(R.id.tMens3);


        btnCalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcular();

                tMens.setText("Quantidades de latas: " + lata + "\nPreço: " + vLata);
                tMens2.setText("Quantidade de Galôes: " + galao + "\nPreço: " + vgalao);
                tMens3.setText("Melhor resultado: " + "\nQuantidade melhor lata: " + mrLata +" Melhor preco: " +mvLata +
                        "\nQuantidade melhor galões: "+ mrGalao  + " Melhor preco: " +mvGalao);

            }
        });
    }

    private void calcular(){

        mrLata = 0;
        mrGalao = 0;
        mvGalao = 0;
        mvLata = 0;
        lata = 0;
        galao = 0;
        vgalao = 0;
        vLata = 0;
        litros = 0;
        metros = 0;
        resto = 0;


        metros = Float.parseFloat(edtTamanho.getText().toString());
        litros = metros / 6;

        lata = (int) (litros / 18);
        galao = (int) (litros / 3.6);


        if((litros % 18)!= 0){
            lata = lata +1;
        }
        vLata = lata * 80;


        if((litros % 3.6) != 0){
            galao = galao + 1;
        }
        vgalao = galao * 25;


        if(litros >= 18){
            mrLata = (int) litros / 18;
            resto = litros % 18;
            if((resto) > 10.8){
                mrLata = mrLata + 1;
            }
            else{
                mrGalao = (int) ((resto) / 3.6);
                if(resto != 0){
                    mrGalao = mrGalao + 1;
                }
            }
        }
        else{
            if(litros <= 10.8){
                mrGalao = (int) (litros / 3.6);
                resto = (int) (litros % 3.6);

                if(resto != 0){
                    mrGalao = mrGalao + 1;
                }
            }
            else{
                mrLata = mrLata + 1;
            }
        }
        mvLata = mrLata * 80;
        mvGalao = mrGalao * 25;
    }

}

