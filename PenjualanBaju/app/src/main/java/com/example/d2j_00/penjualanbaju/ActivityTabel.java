package com.example.d2j_00.penjualanbaju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

public class ActivityTabel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_tabel);
    }

    protected void onResume() {
        super.onResume();

        ListView listTransaksi = (ListView) findViewById(R.id.list_transaksi);
        PenjualanHelper dbHelper = new PenjualanHelper(this);
        final List<Transaksi> listTrans = dbHelper.getTransaksi();

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_expandable_list_item_1, listTrans);
        listTransaksi.setAdapter(adapter);


        listTransaksi.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Transaksi transaksi = listTrans.get(position);
                Intent intent = new Intent(parent.getContext(), ActivityDetail.class);
                intent.putExtra("transaksi.detail", transaksi);
                startActivity(intent);
            }
        });
    }
}
