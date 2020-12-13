package dam2.unidad2.eva2_16_mysqlite_2;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SQLiteDatabase db = openOrCreateDatabase("mi_base_datos", MODE_PRIVATE, null);
        //TextView nombres = findViewById(R.id.nombres);
        ArrayList<String> nombres = new ArrayList<>();
        try {
            db.execSQL("CREATE TABLE mitabla(" +
                    "id INTEGER," +
                    "nombre TEXT," +
                    "apellido TEXT" +
                    ")");
        }catch (SQLiteException e){
            e.printStackTrace();
        }

        db.beginTransaction();

        try{

            db.execSQL("INSERT INTO mitabla(nombre, apellido) VALUES ('Tecate', 'Original')");
            db.execSQL("INSERT INTO mitabla(nombre, apellido) VALUES ('Tecate', 'Light')");
            int i = 1 / 0;
            db.execSQL("INSERT INTO mitabla(nombre, apellido) VALUES ('Juarez', 'Chihuahua')");
            db.execSQL("INSERT INTO mitabla(nombre, apellido) VALUES ('Quiero', 'Dormir')");
            db.execSQL("INSERT INTO mitabla(nombre, apellido) VALUES ('Estoy', 'Cansado')");
            db.setTransactionSuccessful();

        }catch (Exception e){
            e.printStackTrace();
        } finally {
            db.endTransaction();
        }

        Cursor cursor = db.rawQuery("SELECT * FROM mitabla;",null);
        cursor.moveToFirst();
        while(!cursor.isAfterLast()){
            nombres.add(
                    cursor.getColumnIndex("nombre")+ " " +
                            cursor.getString(cursor.getColumnIndex("apeddio")
            ));
        }
    }
}