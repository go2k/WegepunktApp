package googlesearch.sabel.com.wegepunkt_app;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.Serializable;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private WegepunktRepo wegepunkte;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listview);

        Serializable serializable = getIntent().getSerializableExtra("wegepunkte");

        if(serializable instanceof WegepunktRepo){
            wegepunkte = (WegepunktRepo) serializable;

            ArrayAdapter<WegePunkt> arrayAdapter = new ArrayAdapter<WegePunkt>(this,android.R.layout.simple_list_item_1,wegepunkte.getWegePunkte());
            listView.setAdapter(arrayAdapter);

            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                    WegePunkt wegePunkt = wegepunkte.get(i);
                    Log.d("Meins",wegePunkt.toString());

                    double lat = wegePunkt.getLatitude();
                    double longt = wegePunkt.getLongitude();
                    Intent browserIntent = new Intent(Intent.ACTION_VIEW,
                            Uri.parse("http://www.google.com/maps/search/?api=1&query=" +lat + ","+ longt ));
                    startActivity(browserIntent);
                }
            });
        }
    }

}
