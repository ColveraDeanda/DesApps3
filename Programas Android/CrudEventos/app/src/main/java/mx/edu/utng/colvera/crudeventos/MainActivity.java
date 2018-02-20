package mx.edu.utng.colvera.crudeventos;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {
    private Event[] events = {
            new Event(R.drawable.gritoind, "Grito de independencia"),
            new Event(R.drawable.revolucion, "Revolución"),
            new Event(R.drawable.reyes, "Los reyes magos"),
            new Event(R.drawable.arbol, "Árbol de navidad"),
    };
    private ListView lsvEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        lsvEvents = (ListView) findViewById(R.id.lsv_event);
        EventAdapter adapter = new EventAdapter(this, events);
        lsvEvents.setAdapter(adapter);
        lsvEvents.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption = ((Event) adapterView.getItemAtPosition(i)).getName();
        //String selectedOptionOne = ((TextView)view.findViewById(R.id.txv_name)).getText().toString();
        Toast.makeText(this, "You selected: " + selectedOption, Toast.LENGTH_LONG).show();
    }

    static class ViewHolder{
        TextView txvName;
        TextView txvLocation;
        TextView txvType;
        ImageView imvPhoto;
    }

    class EventAdapter extends ArrayAdapter<Event>{
        public  EventAdapter(Context context, Event[] data){
            super(context, R.layout.cell_layout, data);
        }


        public View getView(int position, View convertView, ViewGroup parent) {
            View cell = convertView;
            ViewHolder holder;
            if (cell == null) {
                LayoutInflater layoutInflater = LayoutInflater.from(getContext());
                cell = layoutInflater.inflate(R.layout.cell_layout, null);

                holder = new ViewHolder();
                holder.imvPhoto = cell.findViewById(R.id.imv_photo);
                holder.txvName = cell.findViewById(R.id.txv_name);

                cell.setTag(holder);
            } else {
                holder = (ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(events[position].getImageId());
            holder.txvName.setText(events[position].getName());
            return cell;


        }

    }
    public void AddActivity(View view) {
        startActivity(new Intent(this, AddActivity.class));
    }
}//End
