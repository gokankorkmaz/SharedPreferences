package kodluyoruz.com.sharedpref;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    CheckBox cb;
    EditText etVeri;
    Button btnKaydet, btnSil, btnKaldir, btnAct;
    SharedPref sharedPref;
    Context context = this;
    String kaydedilecekVeri = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
        initEvent();
    }


    private void initView() {
        //Java tanımlamalar
        cb = (CheckBox) findViewById(R.id.activity_main_cb);
        etVeri = (EditText) findViewById(R.id.activity_main_etVeri);
        btnKaydet = (Button) findViewById(R.id.activity_main_btnKaydet);
        btnSil = (Button) findViewById(R.id.activity_main_btnSil);
        btnKaldir = (Button) findViewById(R.id.activity_main_btnKaldir);
        btnAct = (Button) findViewById(R.id.activity_main_btnAct);


        //Button onClick
        btnKaydet.setOnClickListener(this);
        btnSil.setOnClickListener(this);
        btnKaldir.setOnClickListener(this);
        btnAct.setOnClickListener(this);

    }


    private void initEvent() {
    }


    //switch case ile hangi butona basıldıysa o butona ait case'e girer.
    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.activity_main_btnKaydet:
                if (cb.isChecked()) {
                    //editText'ten veriyi aldim
                    kaydedilecekVeri = etVeri.getText().toString();
                    sharedPref = new SharedPref();
                    //kaydet metotu parametre olarak context ve editText'ten gelen kaydedilecekVeri'yi içerir
                    sharedPref.Save(context, kaydedilecekVeri);
                }
                break;
            //sil ve kaldir metotlari için sharedPref sinifindan yeni bir nesne olusturup
            //sil ve kaldir metotlarını cagırdim
            //sil ve kaldir metotlari parametre olarak context alir
            case R.id.activity_main_btnSil:
                sharedPref = new SharedPref();
                sharedPref.Sil(context);
                break;
            case R.id.activity_main_btnKaldir:
                sharedPref = new SharedPref();
                sharedPref.Kaldir(context);
                break;
            case R.id.activity_main_btnAct:
                //Yeni bir intent olusturup ikinci aktiviye geçilir
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
                break;
        }
    }
}
