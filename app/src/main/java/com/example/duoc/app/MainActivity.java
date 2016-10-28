package com.example.duoc.app;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {


    private DataBaseManager manager;
    private Cursor cursor;
    private ListView lista;
    SimpleCursorAdapter adapter;

    private TextView textView;
    private Button btn;


    //datos
    EditText edtNombre;
    EditText edtTelefono;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        manager= new DataBaseManager(this);
        lista = (ListView) findViewById(R.id.listView);
        textView = (TextView) findViewById(R.id.textView);
        btn = (Button) findViewById(R.id.btnIngresar);

        edtNombre=(EditText)findViewById(R.id.txtNombre);
        edtTelefono=(EditText)findViewById(R.id.txtTelefono);

        /*btn.setOnClickListener(this);

        String[] from = new String[]{manager.CN_NAME,manager.CN_PHONE};
        int[] to = new int[]{android.R.id.text1,android.R.id.text2};

        cursor = manager.cargarCursorRegistro();
        adapter= new SimpleCursorAdapter(this,android.R.layout.two_line_list_item,cursor,from,to);
        lista.setAdapter(adapter);
        //manager.InsertarRegistro("Jaime","123456789");*/
    }

    /*public void onClick(View v) {

        if (textView.getId()==R.id.btnIngresar){

            Cursor c = manager.BuscarContacto(textView.getText().toString());

            adapter.changeCursor(c);
        }
    }*/
    public void Ingresar(View view) {
            manager.InsertarRegistro(edtNombre.getText().toString(),edtTelefono.getText().toString());
    }
}
