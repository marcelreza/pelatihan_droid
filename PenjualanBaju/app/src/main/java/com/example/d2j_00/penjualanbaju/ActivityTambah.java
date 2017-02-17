package com.example.d2j_00.penjualanbaju;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class ActivityTambah extends AppCompatActivity {
    private String [] merkStr = {"PETERSAYSDENIM","MACBETH","3second","Wadezig"};
    private String [] memberStr = {"Member","Bukan Member"};
    private EditText edtNama,edtHarga,edtPembeli;
    private Spinner spnMerk,spnMember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_tambah);

        spnMerk = (Spinner) findViewById(R.id.spnmerk);
        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item,merkStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMerk.setAdapter(adapter);

        spnMember = (Spinner) findViewById(R.id.spnmember);
        ArrayAdapter adapter1 = new ArrayAdapter(this, android.R.layout.simple_spinner_item,memberStr);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spnMember.setAdapter(adapter1);

        edtNama = (EditText)findViewById(R.id.txtnama);
        edtHarga = (EditText)findViewById(R.id.txtharga);
        edtPembeli = (EditText) findViewById(R.id.txtpembeli);
    }
    public void Simpan(View view){
        PenjualanHelper dbHelper = new PenjualanHelper(this);
        String nama = edtNama.getText().toString();
        int merk = spnMerk.getSelectedItemPosition()+1;
        int harga = Integer.parseInt(edtHarga.getText().toString());
        String pembeli = edtPembeli.getText().toString();
        int member = spnMember.getSelectedItemPosition()+1;

        dbHelper.insertTransaksi(nama,merk,harga,pembeli,member);
        Log.d("form transaksi",nama+"-"+Integer.toString(merk)+" - "+Integer.toString(harga)+" - "+pembeli+" - "+Integer.toString(member));
        Toast.makeText(this, "Transaksi"+nama+"Berhasil disimpan",Toast.LENGTH_SHORT).show();
        finish();
    }
}
