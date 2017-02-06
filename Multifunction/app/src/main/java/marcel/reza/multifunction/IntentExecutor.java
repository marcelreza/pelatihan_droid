package marcel.reza.multifunction;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class IntentExecutor extends AppCompatActivity {

    String operator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_executor);

        Button btn = (Button)findViewById(R.id.btnexecute);
        Intent intent = getIntent();
        operator = intent.getStringExtra(MainActivity.EXTRA);
        if (operator.equals("browser")){
            btn.setText("Buka Browser");
        }else if (operator.equals("phone")){
            btn.setText("Hubungi No telp");
        }else if (operator.equals("map"))
            btn.setText("Buka Peta");
    }
    public void execute(View view){
        Intent exeIntent = null;
        EditText txtExec = (EditText) findViewById(R.id.text_exec);
        String exec = txtExec.getText().toString();
        if (operator.equals("browser")){
            Uri webpage = Uri.parse("https://"+exec);
            exeIntent = new Intent(Intent.ACTION_VIEW ,webpage);
        }else if (operator.equals("phone")){
            Uri number = Uri.parse("tel:"+exec);
            exeIntent = new Intent(Intent.ACTION_DIAL,number);
        }else if (operator.equals("map")){
            Uri gmmIntentUri = Uri.parse("geo:"+exec);
            exeIntent = new Intent(Intent.ACTION_VIEW,gmmIntentUri);
        }
        startActivity(exeIntent);
    }

}

