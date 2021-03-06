package ro.duoline.agenti;


import android.content.Intent;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.ColorMatrixColorFilter;
//import android.icu.text.SimpleDateFormat;
import java.text.SimpleDateFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;

import java.util.Date;


/**
 * A login screen that offers login via email/password.
 */
public class ParteneriActivity extends AppCompatActivity {
    private RecyclerView recyclerViewParteneri;
    private Button mVeziProforma;
    private ParteneriAdapter adapter;
    private LinearLayoutManager layoutManager;
    DBController controller = new DBController(this);
    private AutoCompleteTextView filtruParteneri;
    private String cod_fiscalSelectat = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setTheme(SaveSharedPreference.getStyle(this));
        setContentView(R.layout.activity_parteneri);
        this.setTitle("Clienti");
        recyclerViewParteneri = (RecyclerView) findViewById(R.id.recyclerViewParteneri);
        mVeziProforma = (Button) findViewById(R.id.buttonEmiteProforma);
        filtruParteneri = (AutoCompleteTextView) findViewById(R.id.filtruParteneriEditText);
        layoutManager = new LinearLayoutManager(this);
        recyclerViewParteneri.setLayoutManager(layoutManager);
        adapter = new ParteneriAdapter(this, controller.getParteneri(""), controller, this);
        int iColor = Color.parseColor("#cdcdcd");
        int red   = (iColor & 0xFF0000) / 0xFFFF;
        int green = (iColor & 0xFF00) / 0xFF;
        int blue  = iColor & 0xFF;

        float[] matrix = { 0, 0, 0, 0, red,
                0, 0, 0, 0, green,
                0, 0, 0, 0, blue,
                0, 0, 0, 1, 0 };

        ColorFilter colorFilter = new ColorMatrixColorFilter(matrix);

        recyclerViewParteneri.addItemDecoration(new LineItemDecoration(this, colorFilter));
        recyclerViewParteneri.setAdapter(adapter);

        mVeziProforma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
                controller.setCod_FiscalForCos(cod_fiscalSelectat, sdf.format(new Date()));
                Intent i = new Intent(getBaseContext(), ProformaViewActivity.class);
                startActivity(i);
            }
        });

        filtruParteneri.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                adapter.setValues(controller.getParteneri(s.toString()));
                setButtonEnabled(false, "");
                adapter.notifyDataSetChanged();
            }
        });
    }

    public void setButtonEnabled(Boolean state, String cod_fiscal){
        mVeziProforma.setEnabled(state);
        cod_fiscalSelectat = cod_fiscal;
    }

}

