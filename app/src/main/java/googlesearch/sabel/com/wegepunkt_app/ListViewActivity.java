package googlesearch.sabel.com.wegepunkt_app;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ListViewActivity extends AppCompatActivity {

    private ListView listView;
    private WegepunktRepo wegepunktRepo;
    private List<WegePunkt> wegePunktList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view);

        listView = findViewById(R.id.listView);

        wegepunktRepo = (WegepunktRepo) getIntent().getSerializableExtra("wegepunkte");

        ArrayAdapter<WegePunkt> arrayAdapter = new ArrayAdapter<WegePunkt>(this, android.R.layout.simple_list_item_1, wegepunktRepo.getWegePunkte());
        listView.setAdapter(arrayAdapter);

    }
}
