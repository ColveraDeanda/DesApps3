 package mx.com.utng.colvera.testregistrotelefono.activities;

 import android.os.AsyncTask;
 import android.os.Bundle;
 import android.support.annotation.Nullable;
 import android.support.v7.app.AppCompatActivity;
 import android.support.v7.widget.AppCompatTextView;
 import android.support.v7.widget.LinearLayoutManager;
 import android.support.v7.widget.RecyclerView;

 import java.util.ArrayList;
 import java.util.List;

 import mx.com.utng.colvera.testregistrotelefono.R;
 import mx.com.utng.colvera.testregistrotelefono.adapters.UsersRecyclerAdapter;
 import mx.com.utng.colvera.testregistrotelefono.model.User;
 import mx.com.utng.colvera.testregistrotelefono.sql.DatabaseHelper;


 public class UsersListActivity extends AppCompatActivity {

    private AppCompatActivity activity = UsersListActivity.this;
    private AppCompatTextView textViewName;
    private AppCompatTextView textViewName2;
    private AppCompatTextView textViewName3;
    private RecyclerView recyclerViewUsers;
    private List<User> listUsers;
    private UsersRecyclerAdapter usersRecyclerAdapter;
    private DatabaseHelper databaseHelper;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users_list);
        getSupportActionBar().hide();
       initViews();
       initObjects();


    }



    /**
     * This method is to initialize views
     */


    private void initViews() {
        textViewName = (AppCompatTextView) findViewById(R.id.textViewName);
        textViewName2 = (AppCompatTextView) findViewById(R.id.textViewName2);
        textViewName3 = (AppCompatTextView) findViewById(R.id.textViewName3);

     //  recyclerViewUsers = (RecyclerView) findViewById(R.id.recyclerViewUsers);
    }



    /**
     * This method is to initialize objects to be used
     */

    private void initObjects() {
        listUsers = new ArrayList<>();
        usersRecyclerAdapter = new UsersRecyclerAdapter(listUsers);

        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
     //   recyclerViewUsers.setLayoutManager(mLayoutManager);
      //  recyclerViewUsers.setItemAnimator(new DefaultItemAnimator());
      //  recyclerViewUsers.setHasFixedSize(true);
     //   recyclerViewUsers.setAdapter(usersRecyclerAdapter);
        databaseHelper = new DatabaseHelper(activity);

        String emailFromIntent = getIntent().getStringExtra("EMAIL");
        textViewName.setText(emailFromIntent);

        String passwordFromIntent = getIntent().getStringExtra("PASSWORD");
        textViewName2.setText(passwordFromIntent);

        String nameFromIntent = getIntent().getStringExtra("NAME");
        textViewName3.setText(nameFromIntent);

        getDataFromSQLite();
    }



    /**
     * This method is to fetch all user records from SQLite
     */

    private void getDataFromSQLite() {
        // AsyncTask is used that SQLite operation not blocks the UI Thread.
        new AsyncTask<Void, Void, Void>() {
            @Override
            protected Void doInBackground(Void... params) {
                listUsers.clear();
                listUsers.addAll(databaseHelper.getAllUser());

                return null;
            }

            @Override
            protected void onPostExecute(Void aVoid) {
                super.onPostExecute(aVoid);
                usersRecyclerAdapter.notifyDataSetChanged();
            }
        }.execute();
    }
}

