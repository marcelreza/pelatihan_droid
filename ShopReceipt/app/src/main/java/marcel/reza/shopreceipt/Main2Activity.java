package marcel.reza.shopreceipt;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        Intent intent =getIntent();
        int[] num_barang = new int [6];
        num_barang[0] = intent.getIntExtra("main.tv.num",0);
        num_barang[1] = intent.getIntExtra("main.kipas.num",0);
        num_barang[2] = intent.getIntExtra("main.vacum.num",0);
        num_barang[3] = intent.getIntExtra("main.ac.num",0);
        num_barang[4] = intent.getIntExtra("main.cctv.num",0);
        num_barang[5] = intent.getIntExtra("main.dvd.num",0);

        int [] harga_barang = new int[6];
        harga_barang[0] = 3000000;
        harga_barang[1] = 2000000;
        harga_barang[2] = 5200000;
        harga_barang[3] = 1300000;
        harga_barang[4] = 2700000;
        harga_barang[5] = 8000000;

        int[] id_num = {R.id.tv2_num,R.id.kipas2_num,R.id.vacum2_num,
                        R.id.ac2_num,R.id.cctv2_num,R.id.dvd2_num};

        int[] id_total = {R.id.tv2_total,R.id.kipas2_total,R.id.vacum2_total,
                         R.id.ac2_total,R.id.cctv2_total,R.id.dvd2_total};

        int total = 0;
        for(int i = 0; i <6;i ++){
            total += harga_barang[i] * num_barang[i];
            ((TextView) findViewById(id_num[i])).setText(Integer.toString(num_barang[i]));
            ((TextView) findViewById(id_total[i])).setText(Integer.toString(num_barang[i] * harga_barang[i]));
        }
        ((TextView) findViewById(R.id.grand_total)).setText(Integer.toString(total));
    }

}
