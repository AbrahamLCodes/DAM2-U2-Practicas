package dam2.unidad2.eva2_15_mysqlite1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Crear o abrir la BD en el espacio interno
        SQLiteDatabase db = openOrCreateDatabase("mi_base_datos", MODE_PRIVATE, null);

        try{
            db.execSQL("CREATE TABLE PRUEBA (" +
                    "ID INTEGER PRIMARY KEY AUTOINCREMENT," +
                    "COL1 TEXT," +
                    "COL2 INTEGER" +
                    ");");
        }catch (SQLiteException e){
            e.printStackTrace();
        }

        try{
            db.execSQL("INSERT INTO PRUEBA (COL1, COL2) VALUES ('HOLA MUNDO', 100)");
        }catch (SQLiteException e){
            e.printStackTrace();
        }
    }
}