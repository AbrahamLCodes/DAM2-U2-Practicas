package dam2.unidad2.eva2_11_resource_files;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.txtVwFile);
    }

    @Override
    protected void onStart() {
        super.onStart();

        /** Abrir el archivo InputStrea,
            Leerlo en forma de bytes (InputStreamReader)
            Interpretarlo (Convertirlo a caracteres, BufferedReader)*/

        InputStream inputStream = getResources().openRawResource(R.raw.lorem_ipsum);
        InputStreamReader isReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(isReader);

        String sCade;

        try{
            while((sCade = bufferedReader.readLine()) != null){
                textView.append(sCade);
                textView.append("\n");
            }
            bufferedReader.close();
        }catch(IOException ex){
            Log.d("Excepcion: ", ex.getMessage());
        }
    }
}