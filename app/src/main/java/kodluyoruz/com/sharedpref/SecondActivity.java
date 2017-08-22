package kodluyoruz.com.sharedpref;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvGoster;
    //SharedPref sinifindaki verilere erismem gerek
    SharedPref sharedPref;
    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        initView();

    }

    private void initView() {
        tvGoster = (TextView) findViewById(R.id.activity_second_tvGoster);
        //sharedPref sinifina ait yeni bir nesne olusturdum
        sharedPref = new SharedPref();
        //tvGoster adli textView 'de sharedPref sınıfından getValue metotunu cagirip
        //parametre olarak context verildiginde veri istenilen textView 'de gösterilir.
        tvGoster.setText(sharedPref.GetValue(context));
    }
}
