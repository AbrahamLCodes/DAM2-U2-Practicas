package dam2.unidad2.eva2_17_mysqlite_3;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    SQLiteDatabase db;
    final String NOMBRE_DB = "mi_base_datos";
    List<String> nombre = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        db = openOrCreateDatabase(NOMBRE_DB, MODE_PRIVATE, null);

        try {
            db.execSQL("CREATE TABLE mitabla(" +
                    "id INTEGER," +
                    "nombre TEXT," +
                    "apellido TEXT" +
                    ")");
        } catch (SQLiteException e) {
            e.printStackTrace();
        }

        db.beginTransaction();

        ContentValues datos = new ContentValues();
        datos.put("nombre", "Abraham");
        datos.put("apellido", "Luna");
        db.insert("mitabla", null, datos);

        datos.put("nombre", "Mario");
        datos.put("apellido", "Tejada");
        db.insert("mitabla", null, datos);

        datos.put("nombre", "Nevin");
        datos.put("apellido", "Almanza");
        db.insert("mitabla", null, datos);

        long clave;
        datos.put("nombre", "Soto");
        datos.put("apellido", "White");
        db.insert("mitabla", null, datos);
        clave = db.insert("mitabla", null, datos);
        Toast.makeText(this, "" + clave, Toast.LENGTH_SHORT).show();

        //UPDATE
        datos.clear();
        datos.put("nombre", "Juancho");
        String[] args = {clave + "", nombre + ""};
        db.update("mitabla", datos, "id = ? and nombre = ?", args);

        //DELETE
        String[] args2 = {"PEDRO"};
        db.delete("mitabla", "nombre = ?", args2);

        String[] columns = {"id", "nombre", "apellido"};
        String[] args3 = {"Juancho"};
        Cursor cursor = db.query("mitabla", columns, "nombre like ?", args3, null, null, "apellido");
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            nombre.add(
                    cursor.getString(
                            cursor.getColumnIndex("nombre")) + " " +
                            cursor.getString(cursor.getColumnIndex("apellido")));
            cursor.moveToNext();
        }

        lista.setAdapter(new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                nombre
        ));
    }
}