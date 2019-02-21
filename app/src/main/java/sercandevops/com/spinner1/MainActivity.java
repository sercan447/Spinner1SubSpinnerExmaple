package sercandevops.com.spinner1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Spinner;
import android.widget.Toast;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class MainActivity extends AppCompatActivity {

    Spinner spinner,spinnercocuk;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spinner = findViewById(R.id.spiner1);
        spinnercocuk = findViewById(R.id.spiner2);


        final ArrayList<Kisi> kisiArrayList = new ArrayList<>();
        kisiArrayList.add(new Kisi(33,"sena"));
        kisiArrayList.add(new Kisi(54,"ahmet"));
        kisiArrayList.add(new Kisi(34,"mehmet"));
        kisiArrayList.add(new Kisi(57,"yergok"));

        final ArrayList<Cocuk> cocuks = new ArrayList<>();
        cocuks.add(new Cocuk(1,"meltem",33));
        cocuks.add(new Cocuk(2,"aslı",33));
        cocuks.add(new Cocuk(3,"rıdvan",54));
        cocuks.add(new Cocuk(4,"koylem",54));
        cocuks.add(new Cocuk(5,"ceylan",54));
        cocuks.add(new Cocuk(6,"benay",57));
        cocuks.add(new Cocuk(7,"temel",57));

        final SpinnerAdapter spinnerAdapter = new SpinnerAdapter(getApplicationContext(),kisiArrayList);
        spinner.setAdapter(spinnerAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

               Kisi kisidt = (Kisi)parent.getSelectedItem();

                List<Cocuk> yenichild = new ArrayList<>();

                 for(Cocuk c : cocuks)
                {
                    if(c.getAna_id() == kisidt.getId())
                    {
                        yenichild.add(c);
                        Log.e("TAGLAR",c.getCocukAdi());
                    }

                }//while

                SpinnerCocukAdapter cocukAdapter = new SpinnerCocukAdapter(getApplicationContext(),yenichild);
                 spinnercocuk.setAdapter(cocukAdapter);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
