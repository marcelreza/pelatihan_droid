package com.example.d2j_00.penjualanbaju;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by D2J-00 on 16/02/2017.
 */
public class PenjualanHelper extends SQLiteOpenHelper {

    public static final String DB_NAME = "penjualan.db";
    public static final int DB_VERSION = 2;

    SQLiteDatabase db;

    public PenjualanHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {db.execSQL(Transaksi.SQL_CREATE);

    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(Transaksi.SQL_DELETE);
        onCreate(db);

    }
    public void insertTransaksi(String nama, int merk, int harga, String pembeli, int member){
        db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Transaksi.COL_NAMA, nama);
        values.put(Transaksi.COL_MERK, merk);
        values.put(Transaksi.COL_HARGA, harga);
        values.put(Transaksi.COL_PEMBELI, pembeli);
        values.put(Transaksi.COL_MEMBER, member);
        db.insert(Transaksi.TABLE_NAME,null ,values);
    }

    public List<Transaksi> getTransaksi() {
        db = getReadableDatabase();
        List<Transaksi> transaksi = new ArrayList<>();
        String[] projection = {Transaksi._ID,Transaksi.COL_NAMA,Transaksi.COL_MERK,Transaksi.COL_HARGA,Transaksi.COL_PEMBELI,Transaksi.COL_MEMBER};
        String sortOrder = Transaksi._ID;

        Cursor cursor = db.query(Transaksi.TABLE_NAME,projection,null,null,null,null,sortOrder);
        Transaksi newTrans;
        while (cursor.moveToNext()) {
            newTrans = new Transaksi(
                    cursor.getString(cursor.getColumnIndex(Transaksi.COL_NAMA)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_MERK)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_HARGA)),
                    cursor.getString(cursor.getColumnIndex(Transaksi.COL_PEMBELI)),
                    cursor.getInt(cursor.getColumnIndex(Transaksi.COL_MEMBER))
            );
            transaksi.add(newTrans);
        }
        cursor.close();
        return transaksi;
    }

}
