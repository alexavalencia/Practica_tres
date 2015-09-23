package com.alexandracastrillonvalencia.punto_3_promedio;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private  int a,b,c,d;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText nota1=(EditText)findViewById(R.id.n_quiz);
        final EditText nota2=(EditText)findViewById(R.id.n_expo);
        final EditText nota3=(EditText)findViewById(R.id.n_lab);
        final EditText nota4=(EditText)findViewById(R.id.n_py);
        final TextView NotaFinal=(TextView)findViewById(R.id.n_final);
        Button confirma=(Button)findViewById(R.id.calcular);


        confirma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String auxi;
                double n1,n2,n3,n4,nf;
                a=nota1.getText().toString().compareTo("");
                b=nota2.getText().toString().compareTo("");
                c=nota3.getText().toString().compareTo("");
                d=nota4.getText().toString().compareTo("");
                if(a==0 || b==0 || c==0 || d==0){
                    nf=0;
                    auxi = Double.toString(nf);

                }else {
                    auxi =nota1.getText().toString();
                    n1 = Double.valueOf(auxi).doubleValue();
                    auxi =nota2.getText().toString();
                    n2=Double.valueOf(auxi).doubleValue();
                    auxi=nota3.getText().toString();
                    n3=Double.valueOf(auxi).doubleValue();
                    auxi=nota4.getText().toString();
                    n4=Double.valueOf(auxi).doubleValue();
                    if(n1>5 || n2>5 || n3>5 || n4>5){
                        auxi="Error";
                    }else{
                        nf=((n1*0.15)+(n2*0.1)+(n3*0.4)+(n4*0.35));
                        auxi = Double.toString(nf);
                    }


                }


                NotaFinal.setText(auxi);

            }
        });
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
