package mx.edu.utng.colvera.unidad1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class DataActivity extends AppCompatActivity {

    EditText edtText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data);

        edtText = (EditText)(findViewById(R.id.edt_text));

        Bundle bundle = this.getIntent().getExtras();

        edtText.setText(bundle.getString("NAME") + ", " + bundle.getString("AGE") + ", " + bundle.getString("PHONE"));
    }
}
