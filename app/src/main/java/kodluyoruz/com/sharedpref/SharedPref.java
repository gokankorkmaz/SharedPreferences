package kodluyoruz.com.sharedpref;

import android.content.Context;
import android.content.SharedPreferences;
import android.widget.Toast;

/**
 * Created by GokhanKorkmaz on 22.08.2017.
 */


/**
 * SharedPref sınıfı olusturup kaydet,getir,sil ve kaldir metotlari tanımlandi
 */
public class SharedPref {
    private final String FILENAME = "Dosya";
    private final String KEY = "Key";
    Context context;


    //metot parametre olarak context ve kaydedilecek string deger alir
    public void Save(Context context, String text) {

        //İçine kayıt yapılacak dosya adı ve kayıt modu(MODE_PRIVATE)
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        //Editor olusturuluyor
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //String kayit edilecegi icin putString ile kay-value mantıgına gore veriyi kaydettim
        editor.putString(KEY, text);
        //commit ile kayit islemi bitti
        editor.commit();
        Toast.makeText(context, "Veriniz Kaydedildi", Toast.LENGTH_SHORT).show();

    }

    //Bu metot parametre olarak context alir
    public String GetValue(Context context) {
        //Tekrardan dosya olusturuldu(FILENAME{Dosya})
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        //getString ile kaydettiğimizde kullandıgımız anahtar deger ve verinin bulunamadıgı zamanda gosterilecek string deger
        String gelenVeri = sharedPreferences.getString(KEY, "Veri Bulunamadı");

        return gelenVeri;
    }

    //Bu metot parametre olarak context alir
    public void Sil(Context context) {
        //Tekrardan dosya olusturuldu(FILENAME{Dosya})
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        //Editleme işlemi yapılacagı için Editor olusturuldu
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //clear ile veriler silindi
        editor.clear();
        //commit ile işlem tamamlanir
        editor.commit();
        Toast.makeText(context, "Veriniz Silindi", Toast.LENGTH_SHORT).show();

    }

    //Bu metot parametre olarak context alir
    public void Kaldir(Context context) {

        //Dosya ve Editor olusturuldu
        SharedPreferences sharedPreferences = context.getSharedPreferences(FILENAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        //remove ile kaydettiğimizde kullandıgımız anahtar(key) kullanilir
        editor.remove(KEY);
        //commit ile işlem tamamlanir
        editor.commit();
        //Kullanıcıya Toast mesajı gösterilir
        Toast.makeText(context, "Veriniz Kaldırıldı", Toast.LENGTH_SHORT).show();

    }
}
