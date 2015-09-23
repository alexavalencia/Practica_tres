package com.alexandracastrillonvalencia.punto_4_area;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText LADO,BASE,ALT,RADIO;
    private TextView mostrar;
    private RadioButton s_1,s_2,s_3,s_4;
    private int operacion;
    private Button conf;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LADO=(EditText)findViewById(R.id.s_lado);
        BASE=(EditText)findViewById(R.id.s_base);
        ALT=(EditText)findViewById(R.id.s_altura);
        RADIO=(EditText)findViewById(R.id.s_radio);
        mostrar=(TextView)findViewById(R.id.respuesta);
        s_1=(RadioButton)findViewById(R.id.s_cua);
        s_2=(RadioButton)findViewById(R.id.s_rec);
        s_3=(RadioButton)findViewById(R.id.s_tria);
        s_4=(RadioButton)findViewById(R.id.s_cir);
        conf=(Button)findViewById(R.id.total);
        conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int a,b,c,d;
                double auxi,resultado_a=0,auxi1;
                String auxi2,auxi3;
                a=LADO.getText().toString().compareTo("");
                b=BASE.getText().toString().compareTo("");
                c=ALT.getText().toString().compareTo("");
                d=RADIO.getText().toString().compareTo("");
                switch (operacion){
                    case 1:
                        if(a==0){
                            mostrar.setText("Operacion invalida");
                        }else{
                            auxi2=LADO.getText().toString();
                            auxi=Double.valueOf(auxi2).doubleValue();
                            resultado_a=Math.pow(auxi, 2);
                            auxi2=Double.toString(resultado_a).toString();
                            mostrar.setText(auxi2);
                        }
                        break;
                    case 2:
                        if(b==0 || c==0){
                            mostrar.setText("Operacion invalida");
                        }else{
                            auxi2=BASE.getText().toString();
                            auxi3=ALT.getText().toString();
                            auxi=Double.valueOf(auxi2).doubleValue();
                            auxi1=Double.valueOf(auxi3).doubleValue();
                            resultado_a=auxi*auxi1;
                            auxi2=Double.toString(resultado_a).toString();
                            mostrar.setText(auxi2);
                        }

                        break;
                    case 3:
                        if(b==0 || c==0){
                            mostrar.setText("Operacion invalida");
                        }else{
                            auxi2=BASE.getText().toString();
                            auxi3=ALT.getText().toString();
                            auxi=Double.valueOf(auxi2).doubleValue();
                            auxi1=Double.valueOf(auxi3).doubleValue();
                            resultado_a=(auxi*auxi1)/2;
                            auxi2=Double.toString(resultado_a).toString();
                            mostrar.setText(auxi2);
                        }
                        break;
                    case 4:
                        if(d==0){
                            mostrar.setText("Operacion invalida");
                        }else{
                            auxi2=RADIO.getText().toString();
                            auxi=Double.valueOf(auxi2).doubleValue();
                            resultado_a=Math.pow(auxi,2)*Math.PI;
                            auxi2=Double.toString(resultado_a).toString();
                            mostrar.setText(auxi2);
                        }
                        break;
                }

            }
        });
    }
    public void operar_area(View view){
        if(s_1.isChecked()){
            operacion=1;
            LADO.setEnabled(true);
            BASE.setEnabled(false);
            ALT.setEnabled(false);
            RADIO.setEnabled(false);
            BASE.setText("");
            ALT.setText("");
            RADIO.setText("");
            mostrar.setText("");
        }else
            if(s_2.isChecked()){
                operacion=2;
                LADO.setEnabled(false);
                BASE.setEnabled(true);
                ALT.setEnabled(true);
                RADIO.setEnabled(false);
                LADO.setText("");
                RADIO.setText("");
                mostrar.setText("");
            }else
                if (s_3.isChecked()){
                    operacion=3;
                    LADO.setEnabled(false);
                    BASE.setEnabled(true);
                    ALT.setEnabled(true);
                    RADIO.setEnabled(false);
                    LADO.setText("");
                    RADIO.setText("");
                    mostrar.setText("");
                }else
                    if (s_4.isChecked()){
                        operacion=4;
                        LADO.setEnabled(false);
                        BASE.setEnabled(false);
                        ALT.setEnabled(false);
                        RADIO.setEnabled(true);
                        BASE.setText("");
                        ALT.setText("");
                        LADO.setText("");
                        mostrar.setText("");
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
