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

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    protected void onResume() {
        super.onResume();

        PenjualanHelper dbHelper = new PenjualanHelper(this);
        final List<Transaksi> listTrans = dbHelper.getTransaksi();


        int total = 0;
        for (int i = 0; i < listTrans.size(); i++) {
            if (listTrans.get(i).member == 1) {
                total += (listTrans.get(i).harga * 90) / 100;
            } else {
                total += listTrans.get(i).harga;
            }
        }

        TextView txtMasuk = (TextView) findViewById(R.id.txt_masuk);
        txtMasuk.setText("Total Pemasukan " + Integer.toString(total));

    }

    public void Tambah (View view){
        Intent intent = new Intent(this, ActivityTambah.class);
        startActivity(intent);
    }
    public void Tampil (View view){
        Intent intent = new Intent(this, ActivityTabel.class);
        startActivity(intent);
    }
}
