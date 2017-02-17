package com.example.d2j_00.penjualanbaju;

import android.provider.BaseColumns;

import java.io.Serializable;

/**
 * Created by D2J-00 on 16/02/2017.
 */
public class Transaksi implements BaseColumns,Serializable{
    public String nama;
    public int merk;
    public int harga;
    public String pembeli;
    public int member;

    public Transaksi(String nama, int harga, int merk, String pembeli) {
        this.nama = nama;
        this.harga = harga;
        this.merk = merk;
        this.pembeli = pembeli;
    }

    public Transaksi(String nama, int merk, int harga, String pembeli, int member) {
        this.nama = nama;
        this.merk = merk;
        this.harga = harga;
        this.pembeli = pembeli;
        this.member = member;
    }

    public int getDiskon(){
        if (this.member == 1)
            return +((harga * 90) / 100);
        return harga;
    }
    public String getMerk(){
        if (this.merk == 1){
            return "PETERSAYSDENIM";
        } else if (this.merk == 2){
            return "MACBETH";
        }else if (this.merk == 3){
            return "3second";
        }
            return "Wadezig";
    }
    public String getMember() {
        if (this.member == 1)
            return "Potongan member sebesar 10%";
        return "Tidak mendapat Potongan";
    }

    public String getMeber(){
        if (this.member == 1)
            return "Member";
        return "Bukan Member";
    }
    @Override
    public String toString(){
        return this.pembeli+": "+this.nama;
    }

    /* informasi properti tabel */
    public static final String TABLE_NAME = "transaksi";
    public static final String COL_NAMA = "name";
    public static final String COL_MERK = "type";
    public static final String COL_HARGA = "price";
    public static final String COL_PEMBELI = "pembeli";
    public static final String COL_MEMBER = "diskon";


    public static final String SQL_CREATE = "create table "+TABLE_NAME
            +" ("+_ID+" integer primary_key,"
            +" "+COL_NAMA+" text,"
            +" "+COL_MERK+" text,"
            +" "+COL_HARGA+" integer,"
            +" "+COL_PEMBELI+" text,"
            +" "+COL_MEMBER+" integer)";
    public static final String SQL_DELETE = " drop table if exists "+TABLE_NAME;
}
