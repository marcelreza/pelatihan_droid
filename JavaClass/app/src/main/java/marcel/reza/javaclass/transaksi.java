package marcel.reza.javaclass;

import java.util.ArrayList;

/**
 * Created by D2J-00 on 31/01/2017.
 */
public class transaksi {

    private ArrayList<barang> Listbarang = new ArrayList<>();

    public void addbarang (barang Barang){
        this.Listbarang.add(Barang);
    }
    public int Totaltransaksi(){
        int hasil =0;
        for(int i=0; i < Listbarang.size();++i){
            hasil += Listbarang.get(i).getharga();
        }
return hasil;
}

public String printTransaksi(){
String text = "Barang yang dibeli pada transaksi ini adalah:\n";
    text += "--------------------------\n";
    for(int i = 0;i <Listbarang.size(); i++){
        text += Listbarang.get(i).toString();
    }
    text += "---------------------------\n";
    text += "Total Pembelian :"+Totaltransaksi()+"\n";
    text += "----------------------------\n";
    return text;
    }
}
