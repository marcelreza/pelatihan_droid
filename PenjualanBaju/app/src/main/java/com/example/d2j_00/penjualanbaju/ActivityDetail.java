package com.example.d2j_00.penjualanbaju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ActivityDetail extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_detail);

        Intent intent = getIntent();
        Transaksi transaksi = (Transaksi) intent.getSerializableExtra("transaksi.detail");

        ((TextView)findViewById(R.id.det_kode)).setText(transaksi.nama);
        ((TextView)findViewById(R.id.det_name)).setText(transaksi.pembeli);
        ((TextView)findViewById(R.id.det_harga)).setText(Integer.toString(transaksi.harga));
        ((TextView)findViewById(R.id.det_merk)).setText(transaksi.getMerk());
        ((TextView)findViewById(R.id.det_member)).setText(transaksi.getMeber());
        ((TextView)findViewById(R.id.det_potongan)).setText(transaksi. getMember());
        ((TextView)findViewById(R.id.det_hargamember)).setText(Integer.toString(transaksi.getDiskon()));

    }
}
