package com.alexandracastrillonvalencia.punto5_formulario;

import android.app.DatePickerDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;

import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class MainActivity extends AppCompatActivity {
    Calendar calendario= Calendar.getInstance();
    private EditText Nombre, Apellido, Fecha, Identi;
    private Button B_fecha,B_conf;
    private CheckBox c_1,c_2,c_3,c_4;
    private RadioButton s_femenimo,s_masculino;
    private int opcion;
    private int cont=0,a,b,c,d;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre=(EditText)findViewById(R.id.name);
        Apellido=(EditText)findViewById(R.id.lastname);
        Identi=(EditText)findViewById(R.id.n_ID);
        Fecha=(EditText)findViewById(R.id.F_number);
        B_fecha=(Button)findViewById(R.id.f_b);
        s_femenimo=(RadioButton)findViewById(R.id.s_f);
        s_masculino=(RadioButton)findViewById(R.id.s_m);
        c_1=(CheckBox)findViewById(R.id.s_1);
        c_2=(CheckBox)findViewById(R.id.s_2);
        c_3=(CheckBox)findViewById(R.id.s_3);
        c_4=(CheckBox)findViewById(R.id.s_4);
        B_conf=(Button)findViewById(R.id.s_conf);

        B_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Registro_datos[] usuario ;
                usuario= new Registro_datos[10];
                Pattern patron = Pattern.compile("[^A-Za-z ]");
                Matcher cadena;
                String data;

                a=Nombre.getText().toString().compareTo("");
                b= Apellido.getText().toString().compareTo("");
                c= Identi.getText().toString().compareTo("");
                d=Fecha.getText().toString().compareTo("");
                usuario[cont]= new Registro_datos();
                if (a==0){
                    Nombre.setText("");
                }else{
                    data=Nombre.getText().toString();
                    cadena = patron.matcher(data);
                    while(cadena.find()){
                        Nombre.setText("Dato Invalido");
                        data=Nombre.getText().toString();
                        cadena = patron.matcher(data);
                    }
                    usuario[cont].setNombre(data);
                }
                if (b==0){
                    Apellido.setText("");
                }else{
                    data=Apellido.getText().toString();
                    cadena = patron.matcher(data);
                    while(cadena.find()){
                        Apellido.setText("Dato Invalido");
                        data=Nombre.getText().toString();
                        cadena = patron.matcher(data);
                    }
                    usuario[cont].setApellido(data);
                }
                if (c==0){
                    Identi.setText("");
                }else{
                    data=Identi.getText().toString();
                    usuario[cont].setIdentidad(data);
                }
                switch (opcion){
                    case 1:
                        data="Femenino";
                        usuario[cont].setSexo(data);
                        break;
                    case 2:
                        data="Masculino";
                        usuario[cont].setSexo(data);
                        break;
                }


                cont++;
            }
        });


    }

    public void selecciongenero(View v){
        if(s_femenimo.isChecked()){
            opcion=1;
        }else{
            if (s_masculino.isChecked()){
                opcion=2;
            }
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
