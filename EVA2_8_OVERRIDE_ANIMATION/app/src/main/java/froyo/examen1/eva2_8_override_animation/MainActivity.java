package froyo.examen1.eva2_8_override_animation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.nio.file.Files;

public class MainActivity extends AppCompatActivity {

    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);

    }

    public void click(View v){
        startActivity(new Intent(this,  MainActivity2.class));
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_right);

    }
}