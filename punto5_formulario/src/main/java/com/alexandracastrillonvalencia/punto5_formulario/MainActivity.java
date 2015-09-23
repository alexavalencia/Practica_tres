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
import android.widget.Spinner;
import android.widget.TextView;
import java.util.Calendar;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.reflect.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Calendar calendario= Calendar.getInstance();
    private EditText Nombre, Apellido, Identi;
    private Button B_conf;
    private CheckBox c_1,c_2,c_3,c_4;
    private RadioButton s_femenimo,s_masculino;
    private int opcion,opcion2;
    private int cont=0,a,b,c,d;
    private DatePicker fecha_n;
    private int dia,mes,año;
    private Spinner s_ciudad;
    private TextView print1,print2,print3,print4,print5,print6,print7;
    private Registro_datos[] usuario ;
    ArrayList<String> selection= new ArrayList<String>();
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Nombre=(EditText)findViewById(R.id.name);
        Apellido=(EditText)findViewById(R.id.lastname);
        Identi=(EditText)findViewById(R.id.n_ID);
        s_femenimo=(RadioButton)findViewById(R.id.s_f);
        s_masculino=(RadioButton)findViewById(R.id.s_m);
        c_1=(CheckBox)findViewById(R.id.s_1);
        c_2=(CheckBox)findViewById(R.id.s_2);
        c_3=(CheckBox)findViewById(R.id.s_3);
        c_4=(CheckBox)findViewById(R.id.s_4);
        B_conf=(Button)findViewById(R.id.s_conf);
        fecha_n=(DatePicker)findViewById(R.id.fecha);
        s_ciudad=(Spinner)findViewById(R.id.ciudad);
        print1=(TextView)findViewById(R.id.i_nombre);
        print2=(TextView)findViewById(R.id.i_apellido);
        print3=(TextView)findViewById(R.id.i_sexo);
        print4=(TextView)findViewById(R.id.i_fecha);
        print5=(TextView)findViewById(R.id.i_ciudad);
        print6=(TextView)findViewById(R.id.i_hobbie);
        print7=(TextView)findViewById(R.id.i_identidad);

        B_conf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                usuario = new Registro_datos[10];
                Pattern patron = Pattern.compile("[^A-Za-z ]");
                Matcher cadena;
                String data;

                a = Nombre.getText().toString().compareTo("");
                b = Apellido.getText().toString().compareTo("");
                c = Identi.getText().toString().compareTo("");
                usuario[cont] = new Registro_datos();
                if (a == 0 || b == 0 || c == 0) {
                    print1.setText("");
                    print2.setText("");
                    print3.setText("");
                    print4.setText("");
                    print5.setText("");
                    print7.setText("");
                    print6.setText("");
                } else {
                    if (a == 0) {
                        Nombre.setText("");
                    } else {
                        data = Nombre.getText().toString();
                        cadena = patron.matcher(data);
                        while (cadena.find()) {
                            Nombre.setText("");
                            data = Nombre.getText().toString();
                            cadena = patron.matcher(data);
                        }
                        usuario[cont].setNombre(data);
                    }
                    if (b == 0) {
                        Apellido.setText("");
                    } else {
                        data = Apellido.getText().toString();
                        cadena = patron.matcher(data);
                        while (cadena.find()) {
                            Apellido.setText("");
                            data = Nombre.getText().toString();
                            cadena = patron.matcher(data);
                        }
                        usuario[cont].setApellido(data);
                    }
                    if (c == 0) {
                        Identi.setText("");
                    } else {
                        data = Identi.getText().toString();
                        usuario[cont].setIdentidad(data);
                    }
                    switch (opcion) {
                        case 1:
                            data = "Femenino";
                            usuario[cont].setSexo(data);
                            break;
                        case 2:
                            data = "Masculino";
                            usuario[cont].setSexo(data);
                            break;
                    }
                    dia = fecha_n.getDayOfMonth();
                    mes = fecha_n.getMonth();
                    año = fecha_n.getYear();
                    data = dia + "/" + mes + "/" + año;
                    usuario[cont].setFecha(data);
                    data = s_ciudad.getSelectedItem().toString();
                    usuario[cont].setCiudad(data);

                    print1.setText(usuario[cont].getNombre());
                    print2.setText(usuario[cont].getApellido());
                    print3.setText(usuario[cont].getSexo());
                    print4.setText(usuario[cont].getFecha());
                    print5.setText(usuario[cont].getCiudad());
                    print7.setText(usuario[cont].getIdentidad());
                    String Hobbies = "";
                    for (String selections : selection) {
                        Hobbies = Hobbies + selections + "\n";

                    }
                    print6.setText(Hobbies);
                   // m_hobie();
                    cont++;
                }
                Nombre.setText("");
                Apellido.setText("");
                Identi.setText("");
                if(cont==10){
                    B_conf.setEnabled(false);
                    cont=0;
                }

            }
        });


    }
    public void selectItems( View view) {
        boolean checked = ((CheckBox) view).isChecked();
        switch (view.getId())

        {
            case R.id.s_1:
                if (checked) {
                    selection.add("Deporte");

                } else {
                    selection.remove("Deporte");
                }
                break;

            case R.id.s_2:
                if (checked) {
                    selection.add("Escuchar Musica");
                } else {
                    selection.remove("Escuchar Musica");
                }
                break;
            case R.id.s_3:
                if (checked) {
                    selection.add("Dormir");
                } else {
                    selection.remove("Dormir");
                }
                break;
            case R.id.s_4:
                if (checked) {
                    selection.add("Leer");
                } else {
                    selection.remove("Leer");
                }
                break;
        }
    }
    public void selecciongenero(View v){
        if(s_femenimo.isChecked()){
            opcion=1;
        }else
        if (s_masculino.isChecked()){
            opcion=2;
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
