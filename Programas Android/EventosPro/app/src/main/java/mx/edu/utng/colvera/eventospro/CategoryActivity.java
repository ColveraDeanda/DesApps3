package mx.edu.utng.colvera.eventospro;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener{

    ListView listaRecorridos;

    private Event[] events = {
            new Event(R.drawable.gritoind, "Grito de independencia", "15 de septiembre"),
            new Event(R.drawable.revolucion, "Revolución", "20 de noviembre"),
            new Event(R.drawable.reyes, "Los reyes magos", "05 de enero"),
            new Event(R.drawable.arbol, "Arbol de navidad", "12 de diciembre"),
    };


    private GridView grvEvents;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        grvEvents = (GridView) findViewById(R.id.gvr_events);
        EventAdapter adapter = new EventAdapter( this,events);
        grvEvents.setAdapter(adapter);
        grvEvents.setOnItemClickListener(this);
        /*listaRecorridos = (ListView)findViewById(R.id.lv01);*/
    }

    public void infCategory(View view) {
        startActivity(new Intent(this, InfCategory.class));
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
        String selectedOption=((Event)adapterView.getItemAtPosition(i)).getName();
        Toast.makeText(this, "You selected: " +selectedOption, Toast.LENGTH_SHORT).show();

    }

    static  class ViewHolder{
        TextView txvName;
        ImageView imvPhoto;
        TextView txvDate;
    }


    class EventAdapter extends ArrayAdapter<Event> {
        public EventAdapter(@NonNull Context context, Event[] data){
            super (context, R.layout.cell_places,data);
        }

        @NonNull
        @Override

        public View getView(int position, @NonNull  View convertView, @NonNull ViewGroup parent){
            View cell = convertView;
            ViewHolder holder;
            if(cell == null){
                LayoutInflater inflater = LayoutInflater.from(getContext());
                cell= inflater.inflate(R.layout.cell_places, null);

                holder = new ViewHolder();
                holder.imvPhoto= cell.findViewById(R.id.imv_thumbnail);
                holder.txvName = cell.findViewById(R.id.txv_name);
                holder.txvDate = cell.findViewById(R.id.txv_date);

                cell.setTag(holder);

            }else{
                holder=(ViewHolder) cell.getTag();
            }

            holder.imvPhoto.setImageResource(events[position].getImageId());
            holder.txvName.setText(events[position].getName());
            holder.txvDate.setText(events[position].getDate());
            return cell;
        }


    }
}
