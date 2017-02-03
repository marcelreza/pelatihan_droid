package marcel.reza.multifunction;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public final static String EXTRA = "marcel.reza.multifunction.Main";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void ShowMessage(View view){
        Intent  intent = new Intent(this,ShowMessage.class);
        TextView txtMessage = (TextView) findViewById(R.id.txt_message);
        intent.putExtra(EXTRA,txtMessage.getText().toString());
        startActivity(intent);
    }
    public void OpenBrowser (View view){
        Intent intent = new Intent(this,IntentExecutor.class);
        intent.putExtra(EXTRA,"browser");
        startActivity(intent);
    }

    public void OpenPhone (View view){
        Intent intent = new Intent(this,IntentExecutor.class);
        intent.putExtra(EXTRA,"phone");
        startActivity(intent);
    }
    public void OpenMap (View view){
        Intent intent = new Intent(this,IntentExecutor.class);
        intent.putExtra(EXTRA,"map");
        startActivity(intent);
    }
}

