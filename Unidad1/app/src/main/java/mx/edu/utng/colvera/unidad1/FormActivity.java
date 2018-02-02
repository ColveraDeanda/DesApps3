package mx.edu.utng.colvera.unidad1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Ganzo on 01/02/2018.
 */

public class FormActivity extends AppCompatActivity {

    EditText edtName;
    EditText edtAge;
    EditText edtPhone;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_form);

        edtName = (EditText)(findViewById(R.id.edt_name));
        edtAge = (EditText)(findViewById(R.id.edt_age));
        edtPhone = (EditText)(findViewById(R.id.edt_phone));
        btnSubmit = (Button)(findViewById(R.id.btn_submit));

        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent =
                        new Intent(FormActivity.this, DataActivity.class);

                Bundle b = new Bundle();

                b.putString("NAME", edtName.getText().toString());
                b.putString("AGE", edtAge.getText().toString());
                b.putString("PHONE", edtPhone.getText().toString());

                intent.putExtras(b);

                startActivity(intent);
            }
        });
    }


    public void nextActivity4(View view) {
        startActivity(new Intent(this, DataActivity.class));
    }
}

