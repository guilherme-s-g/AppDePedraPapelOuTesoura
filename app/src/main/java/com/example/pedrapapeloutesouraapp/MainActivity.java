package com.example.pedrapapeloutesouraapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view)
    {
        this.opcaoSelecionada("pedra");
    }

    public void selecionadoPapel(View view)
    {
        this.opcaoSelecionada("papel");
    }

    public void selecionadoTesoura(View view)
    {
        this.opcaoSelecionada("tesoura");
    }

    public void opcaoSelecionada(String escolhaUsuario)
    {
        ImageView imageResultado = findViewById(R.id.imageResultado);
        TextView textoResultado = findViewById(R.id.textoResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"pedra","papel","tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp)
        {
            case"pedra":
                imageResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imageResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imageResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        if(     (escolhaApp == "pedra" && escolhaUsuario =="tesoura") ||
                (escolhaApp == "papel" && escolhaUsuario =="pedra") ||
                (escolhaApp == "tesoura" && escolhaUsuario =="papel")
        )
        {
            textoResultado.setText("Você perdeu :( ");
        }
        else if (       (escolhaUsuario == "pedra" && escolhaApp =="tesoura") ||
                        (escolhaUsuario == "papel" && escolhaApp =="pedra") ||
                        (escolhaUsuario == "tesoura" && escolhaApp =="papel")
        )
        {
            textoResultado.setText("Você ganhou :)");
        }
        else
        {
            textoResultado.setText("Empatamos ");
        }

    }

}