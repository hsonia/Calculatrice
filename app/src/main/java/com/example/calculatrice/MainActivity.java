package com.example.calculatrice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


import static java.lang.Math.*;
import static java.lang.Math.pow;
public class MainActivity extends AppCompatActivity {

    TextView result;
    double op1 = 0;
    double op2 = 0;
    double r = 0;
    String op="";
    String s="";
    Button btn,btnc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        result = (TextView) findViewById(R.id.result);
        btn = (Button)findViewById(R.id.egale);
        btnc = (Button) findViewById(R.id.clear);
        btnc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                clear();
            }
        });

    }

    public void set_operator(View view) {
        if(op.contentEquals("")) {
            switch (view.getId()) {
                case R.id.plus:
                    op = "+";result.setText("");break;
                case R.id.moins:
                    op = "-";result.setText("");break;
                case R.id.fois:
                    op = "*";result.setText("");break;
                case R.id.par:
                    op = "/";result.setText("");break;
                case R.id.percent:
                    result.setText(""+(op1/100));clear();break;
                case R.id.puiss:
                    op = "^";break;
                case R.id.racine:
                    result.setText(""+(sqrt(op1)));clear();break;
                case R.id.cosi:
                    result.setText(""+cos(op1));clear();break;
                case R.id.sini:
                    result.setText(""+sin(op1));clear();break;
                case R.id.tang:
                    result.setText(""+tan(op1));clear();break;
            }
        }
    }

    public void clear() {
        op1 = 0;
        op2 = 0;
        op="";
        if(btnc.isPressed()){
            result.setText("");
            r = 0;
        }
    }

    public void calcule(View view) {
        String c=((Button)view).getText().toString();
        if(r!=0){
            r = 0;
            s="";
        }
        else
            s=result.getText().toString();

        if((c.contentEquals("."))&&(s.contains(".")))
            c="";
        s = s + c;
        if(s.contentEquals("."))
            s="0.";
        result.setText(s);
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
                case "^" : r = pow(op1,op2);break;
            }
            result.setText(""+r);
        }
        clear();
    }

    public void supprimer(View view) {
        if(op1 == 0 && op2==0){

        }
        else{
            String a = result.getText().toString();
            if(!a.contentEquals("")) {
                result.setText(a.substring(0, (a.length() - 1)));
                affectation();
            }
        }
    }

    public void affectation(){
        String o = result.getText().toString();
        if(o.length()==0)
            o = "0";
        if(op.contentEquals(""))
            op1 = Double.parseDouble(o);
        else
            op2 = Double.parseDouble(o);
    }
}
