package com.alexandracastrillonvalencia.punto_2_calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.SpannableStringBuilder;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText op2;
    private EditText op1;
    private Button total;
    private TextView m_result;
    private  RadioGroup select;
    private RadioButton s_1,s_2,s_3,s_4;
    private double rlt,a,b;
    private int flag;
    private int operacion,auxi3,auxi4;
    private String auxi,auxi2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

         op1=(EditText)findViewById(R.id.operando1);
         op2=(EditText)findViewById(R.id.operando2);
         total= (Button)findViewById(R.id.result);
         m_result=(TextView)findViewById(R.id.mostrar);
         select =(RadioGroup)findViewById(R.id.seleccion);
         s_1=(RadioButton)findViewById(R.id.s_suma);
         s_2=(RadioButton)findViewById(R.id.s_resta);
         s_3=(RadioButton)findViewById(R.id.s_mult);
         s_4=(RadioButton)findViewById(R.id.s_div);
         s_1.setChecked(true);

        total.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                auxi3=op1.getText().toString().compareTo("");
                auxi4=op2.getText().toString().compareTo("");
                switch (operacion){
                    case 1:
                        if(auxi3==0 || auxi4==0) {
                            rlt = 0;
                            auxi = String.valueOf(rlt);
                            m_result.setText(auxi);
                        }else {
                            auxi = op1.getText().toString();
                            a = Double.valueOf(auxi).doubleValue();
                            auxi = op2.getText().toString();
                            b = Double.valueOf(auxi).doubleValue();
                            rlt = a + b;
                        }
                        break;
                    case 2:
                        if(auxi3==0 || auxi4==0) {
                            rlt = 0;
                            auxi = String.valueOf(rlt);
                            m_result.setText(auxi);
                        }else {
                            auxi = op1.getText().toString();
                            a = Double.valueOf(auxi).doubleValue();
                            auxi = op2.getText().toString();
                            b = Double.valueOf(auxi).doubleValue();
                            rlt = a - b;
                        }
                        break;
                    case 3:
                        if(auxi3==0 || auxi4==0) {
                            rlt = 0;
                            auxi = String.valueOf(rlt);
                            m_result.setText(auxi);
                        }else {
                            auxi = op1.getText().toString();
                            a = Double.valueOf(auxi).doubleValue();
                            auxi = op2.getText().toString();
                            b = Double.valueOf(auxi).doubleValue();
                            rlt = a * b;
                        }
                        break;
                    case 4:
                        if(auxi3==0 || auxi4==0) {
                            rlt = 0;
                            auxi = String.valueOf(rlt);
                            m_result.setText(auxi);
                        }else {
                            auxi = op1.getText().toString();
                            a = Double.valueOf(auxi).doubleValue();
                            auxi = op2.getText().toString();
                            b = Double.valueOf(auxi).doubleValue();
                            if (b == 0) {
                                auxi2 = "ND"; // LA OPERACION NO ESTA DEFINIDA
                                flag = 1;
                            } else {
                                rlt = a / b;
                            }
                        }
                        break;

                }
                if(auxi3==0 || auxi4==0){
                    rlt=0;

                }else {
                    auxi = String.valueOf(rlt);
                    if (flag == 1) {
                        flag = 0;
                        m_result.setText(auxi2);
                    } else {
                        m_result.setText(auxi);
                    }
                }
            }
        });
    }
     public void operar(View view) {
         if (s_1.isChecked()) {
             operacion=1;

         } else if (s_2.isChecked()) {
                operacion=2;

         } else if (s_3.isChecked()) {
                operacion=3;

         } else if (s_4.isChecked()) {
                operacion=4;
         }
     }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
