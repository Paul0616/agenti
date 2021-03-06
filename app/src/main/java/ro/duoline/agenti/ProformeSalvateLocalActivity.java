package ro.duoline.agenti;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.List;

public class ProformeSalvateLocalActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private ProformeSalavateAdapter adapter;
    private RecyclerView.LayoutManager layoutManager;
    DBController controller = new DBController(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(SaveSharedPreference.getStyle(this));
        setContentView(R.layout.activity_proforme_salvate_local);
        recyclerView = (RecyclerView)findViewById(R.id.recyclerSalvate);
        layoutManager = new LinearLayoutManager(getApplicationContext(), LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        this.setTitle("Proforme salv. doar pe dispozitiv");
        List<Proformevalues> valori = controller.getProformeNesalvate();
        adapter = new ProformeSalavateAdapter(this, valori, ProformeSalvateLocalActivity.this);
        recyclerView.setAdapter(adapter);
        //controller.

    }
}
