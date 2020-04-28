package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//import org.apache.commons.lang3.StringUtils;

import static java.lang.Math.*;
import static java.lang.Math.pow;
public class MainActivity extends AppCompatActivity {

    EditText operation;
    TextView result;
    double op1 = 0;
    double op2 = 0;
    double r = 0;
    String op="";
    String s="";
    Button btn,btnc,spr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        operation = (EditText) findViewById(R.id.operation);
        result = (TextView) findViewById(R.id.result);
        btn = (Button)findViewById(R.id.egale);
        btnc = (Button) findViewById(R.id.clear);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });
        /*spr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                supprimer();
            }
        });*/
    }

    public void set_operator(View view) {
        //btn = (Button) view;
        if(op.contentEquals("")) {
            switch (view.getId()) {
                case R.id.plus:
                    op = "+";break;
                case R.id.moins:
                    op = "-";break;
                case R.id.fois:
                    op = "*";break;
                case R.id.par:
                    op = "/";break;
                case R.id.percent:
                    result.setText(""+(op1/100));clear();break;
                case R.id.puiss:
                    op = "^";break;
                case R.id.racine:
                    result.setText(""+(sqrt(op1)));clear();break;
                case R.id.cosi:
                    result.setText(""+cos(op1));
                case R.id.sini:
                    result.setText(""+sin(op1));
                case R.id.tang:
                    result.setText(""+tan(op1));
            }
            if((!op.contentEquals("%")) && (!op.contentEquals("-v")))
                operation.setText("");
        }
    }

    public void clear() {
        op1 = 0;
        op2 = 0;
        r = 0;
        op="";
        operation.setText("");
        //btn = findViewById(R.id.clear);
        if(btnc.isPressed())
            result.setText("");
    }

    /*public void supprimer(View view) {
    }*/

    public void calcule(View view) {
        String c=((Button)view).getText().toString();
        s=operation.getText().toString();
        if((c.contentEquals("."))&&(s.contains(".")))
            c="";
        s = s + c;
        if(s.contentEquals("."))
            s="0.";
        operation.setText(s);
        /*if(spr.isPressed())
            supprimer();*/
        affectation();
    }

    public void resultat(View view) {
        if(op.contentEquals(""))
            result.setText(""+op1);
        else{
            switch (op){
                case "+" : r = op1 + op2;break;
                case "-" : r = op1 - op2;break;
                case "*" : r = op1 * op2;break;
                case "/" : if(op2!=0){r = op1 / op2;} else{System.out.println("ERR");};break;
                //case "%" : r = op1 / 100;break;
                case "^" : r = pow(op1,op2);break;
                //case "-v" : r =sqrt(op1);break;
            }
            result.setText(""+r);
        }
        clear();
    }

    public void supprimer(View view) {
        String a = operation.getText().toString();
        if(!a.contentEquals("")) {
            operation.setText(a.substring(0, (a.length() - 1)));
            affectation();
        }
    }

    public void affectation(){
        if(op.contentEquals(""))
            op1 = Double.parseDouble(operation.getText().toString());
        else
            op2 = Double.parseDouble(operation.getText().toString());
    }
}
