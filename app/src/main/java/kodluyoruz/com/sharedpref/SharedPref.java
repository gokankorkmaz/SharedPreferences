package kodluyoruz.com.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by GokhanKorkmaz on 22.08.2017.
 */

public class SharedPref {
    Context context;
    private final String FILENAME = "Dosya";
    private final String KEY = "Key";

    public void Save(Context context, String text) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY, text);
        editor.commit();
        Toast.makeText(context, "Veriniz Kaydedildi", Toast.LENGTH_SHORT).show();

    }


    public String GetValue(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        String gelenVeri = sharedPreferences.getString(KEY, "Veri Bulunamadı");
        return gelenVeri;
    }


    public void Sil(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear();
        editor.commit();
        Toast.makeText(context, "Veriniz Silindi", Toast.LENGTH_SHORT).show();

    }


    public void Kaldir(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.remove(KEY);
        editor.commit();
        Toast.makeText(context, "Veriniz Kaldırıldı", Toast.LENGTH_SHORT).show();

    }
}
