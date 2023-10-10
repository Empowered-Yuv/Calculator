package com.example.calc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class MainActivity extends AppCompatActivity {

    TextView t_sol,t_res;

    Button b_ac,b_c,b_div,b_mul,b_d0,b_min,b_1,b_0,b_2,b_3,b_4,b_5,b_6,b_7,b_8,b_9,b_point,b_plus,b_per,b_eq;


    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        t_sol = findViewById(R.id.soln);
        t_res = findViewById(R.id.res);
        b_ac = findViewById(R.id.button_allcl);
        b_c = findViewById(R.id.button_cl);
        b_0 = findViewById(R.id.button_0);
        b_1 = findViewById(R.id.button_1);
        b_2 = findViewById(R.id.button_2);
        b_3 = findViewById(R.id.button_3);
        b_4 = findViewById(R.id.button_4);
        b_5 = findViewById(R.id.button_5);
        b_6 = findViewById(R.id.button_6);
        b_7 = findViewById(R.id.button_7);
        b_8 = findViewById(R.id.button_8);
        b_9 = findViewById(R.id.button_9);
        b_per = findViewById(R.id.button_per);
        b_d0 = findViewById(R.id.button_double0);
        b_plus = findViewById(R.id.button_plus);
        b_min = findViewById(R.id.button_minus);
        b_mul = findViewById(R.id.button_mul);
        b_div = findViewById(R.id.button_div);
        b_eq = findViewById(R.id.button_eq);
        b_point = findViewById(R.id.button_point);


        b_0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"0");
            }
        });


        b_1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"1");
            }
        });


        b_2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"2");
            }
        });


        b_3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"3");
            }
        });


        b_4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"4");
            }
        });


        b_5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"5");
            }
        });


        b_6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"6");
            }
        });


        b_7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"7");
            }
        });

        b_8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"8");
            }
        });

        b_9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"9");
            }
        });

        b_d0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                if (data == "" ) {
                    t_sol.setText(data+"0");
                } else if (data == "0") {
                    t_sol.setText("0");
                }else {
                    t_sol.setText(data+"00");
                }


            }

        });



        b_ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                t_sol.setText("");
                t_res.setText("");
            }
        });


        b_c.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                if(data == ""){
                    t_sol.setText("");
                }else {
                    t_sol.setText(data.substring(0,data.length()-1));
                }
            }
        });

        b_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();

                if(data.charAt(data.length()-1)== '+'){
                    t_sol.setText(data);
                }else{
                    t_sol.setText(data+"+");
                }

            }
        });

        b_min.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                if(data.charAt(data.length()-1)== '-'){
                    t_sol.setText(data);
                }else{
                    t_sol.setText(data+"-");
                }
            }
        });

        b_mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"*");
            }
        });

        b_div.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"/");
            }
        });

        b_point.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+".");
            }
        });

        b_per.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();
                t_sol.setText(data+"%");
            }
        });




        b_eq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                data = t_sol.getText().toString();

                data=data.replaceAll("×","*");
                data=data.replaceAll("%","/100");
                data=data.replaceAll("÷","/");

                Context rhino=Context.enter();
                rhino.setOptimizationLevel(-1);

                String finalResult="";

                Scriptable scriptable=rhino.initStandardObjects();
                finalResult=rhino.evaluateString(scriptable,data,"Javsscript",1,null).toString();

                t_res.setText(finalResult);
            }
        });



    }
}