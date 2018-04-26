package googlesearch.sabel.com.wegepunkt_app;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.Date;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private WegepunktRepo wegepunktRepo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        wegepunktRepo = new WegepunktRepo();
        wegepunktRepo.add(new WegePunkt(new Date(), 4711, 7712));

        listView = findViewById(R.id.listView);
        ArrayAdapter<WegePunkt> arrayAdapter = new ArrayAdapter<WegePunkt>(this, android.R.layout.simple_list_item_1, wegepunktRepo.getWegePunkte());
        listView.setAdapter(arrayAdapter);

    }
}
