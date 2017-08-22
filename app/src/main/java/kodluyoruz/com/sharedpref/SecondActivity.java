package kodluyoruz.com.sharedpref;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    TextView tvGoster;
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
        sharedPref = new SharedPref();
        tvGoster.setText(sharedPref.GetValue(context));
    }
}
