package ug.kinan.bogortourism;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import java.util.ArrayList;

import ug.kinan.bogortourism.adapter.WisataAdapter;
import ug.kinan.bogortourism.database.DatabaseHandler;
import ug.kinan.bogortourism.pojo.Data;

public class WisataSejarahActivity extends AppCompatActivity {

    private DatabaseHandler databaseHandler;
    private ArrayList<Data> dataList = new ArrayList<>();
    private RecyclerView recyclerView;
    private WisataAdapter adapter;
    private LinearLayoutManager linearLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_wisata);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        setTitle(R.string.wisata_sejarah);

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        databaseHandler = new DatabaseHandler(WisataSejarahActivity.this);
        dataList = databaseHandler.getAllSejarah();
        Log.d("HASIL",""+dataList.size()+" "+dataList.get(1).getJudul());
        recyclerView.setHasFixedSize(true);
        linearLayoutManager = new GridLayoutManager(WisataSejarahActivity.this,1);
        recyclerView.setLayoutManager(linearLayoutManager);
        adapter = new WisataAdapter(WisataSejarahActivity.this,dataList);
        recyclerView.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();

        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        finish();
    }
}
