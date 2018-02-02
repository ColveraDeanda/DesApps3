package mx.edu.utng.colvera.unidad1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

/**
 * Created by Ganzo on 01/02/2018.
 */

public class ImagesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_images);
    }

    public void nextActivity2(View view) {
        startActivity(new Intent(this, CalculatorActivity.class));
    }

    public void nextActivity3(View view) {
        startActivity(new Intent(this, FormActivity.class));
    }

}
