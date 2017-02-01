package marcel.reza.javaclass;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    public String showString;
    public TextView showText;
    public barang[] arrbarang = new barang[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        showText = (TextView) findViewById(R.id.show_text);

        showString = "Manipulasi Java Android";
        addSeparator();

        initbarang();
        // showString += arrbarang[5].toString();
        // addSeparator();
        // showString += arrbarang[1].toString();

        transaksi trans1 = new transaksi();
        trans1.addbarang(arrbarang[3]);
        trans1.addbarang(arrbarang[7]);
        trans1.addbarang(arrbarang[1]);
        showString += trans1.printTransaksi();

        showText.setText(showString);
    }

    public void addSeparator() {
        showString += "\n--------------------\n";
    }

    public void initbarang() {
        arrbarang[0] = new barang("Leptop", 1, 70000000);
        arrbarang[1] = new barang("Printer", barang.ELEKTRONIK, 250000);
        arrbarang[2] = new barang("Mouse", barang.ELEKTRONIK, 600000);
        arrbarang[3] = new barang("Monitor", barang.ELEKTRONIK, 800000);
        arrbarang[4] = new barang("Keyboard", barang.ELEKTRONIK, 700000);
        arrbarang[5] = new barang("Meja", barang.NEW_ELEKTRONIK, 900000);
        arrbarang[6] = new barang("Kipas Angin", barang.ELEKTRONIK, 110000);
        arrbarang[7] = new barang("Kursi", barang.NEW_ELEKTRONIK, 6000000);
        arrbarang[8] = new barang("SmartPhone", barang.ELEKTRONIK, 250000);
        arrbarang[9] = new barang("Jam", barang.ELEKTRONIK, 250000);


    }
}
