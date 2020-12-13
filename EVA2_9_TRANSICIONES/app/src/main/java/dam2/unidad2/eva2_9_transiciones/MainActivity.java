package dam2.unidad2.eva2_9_transiciones;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActivityOptions;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        button = findViewById(R.id.button);

    }

    public void click(View v) {
        ActivityOptions options = ActivityOptions.makeSceneTransitionAnimation(
                this
                , imageView
                , "miTransicion"
        );

        startActivity(
                new Intent(this, MainActivity2.class)
                , options.toBundle());
    }
}