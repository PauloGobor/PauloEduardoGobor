package com.example.ti.pauloeduardogobor;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    private Button btnLimpar, btnConverter;
    private EditText edtReal;
    private TextView txtRealDolar, txtRealEuro, txtRealArgentino;
    private ImageView imgDolar;
    private double real, realDolar, realEuro, realArgentino;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnLimpar        = (Button) findViewById(R.id.btnLimpar);
        btnConverter     = (Button) findViewById(R.id.btnConverter);
        edtReal          = (EditText) findViewById(R.id.edtReal);
        txtRealDolar     = (TextView) findViewById(R.id.txtRealDolar);
        txtRealEuro      = (TextView) findViewById(R.id.txtRealEuro);
        txtRealArgentino = (TextView) findViewById(R.id.txtRealArgentino);
        imgDolar         = (ImageView) findViewById(R.id.imgDolar);


        btnConverter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                    real = Double.parseDouble(edtReal.getText().toString());
                    realEuro = real / 4.41;
                    realDolar = real / 3.91;
                    realArgentino = real / 0.09;

                    txtRealDolar.setText(String.valueOf(realDolar));
                    txtRealEuro.setText(String.valueOf(realEuro));
                    txtRealArgentino.setText(String.valueOf(realArgentino));
                    imgDolar.setImageResource(R.drawable.download);

            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                exibirMensgem();
            }
        });

    }

    private void exibirMensgem() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        //Conteúdo da mensagem
        builder.setTitle("Conversão feita!");
        builder.setMessage("Deseja reiniciar?");
        builder.setPositiveButton("Sim", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                reiniciarConversor();
            }
        });
        builder.setNegativeButton("Cancelar", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        //Criando a mensagem
        AlertDialog dialog = builder.create();
        //Exibir a mensagem na Activity
        dialog.show();
    }


    public void reiniciarConversor() {
        txtRealArgentino.setText("");
        txtRealEuro.setText("");
        txtRealDolar.setText("");
        edtReal.setText("");
        imgDolar.setImageResource(R.drawable.images);

    }
}
