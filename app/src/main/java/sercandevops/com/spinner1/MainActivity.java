package sercandevops.com.spinner1;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;
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

        WindowManager windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        Display display = windowManager.getDefaultDisplay();

        boolean tabletSize = getResources().getBoolean(R.bool.isTablet);

        if(tabletSize)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            //Toast.makeText(getApplicationContext(),"TABLET",Toast.LENGTH_SHORT).show();

        }else
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
           // Toast.makeText(getApplicationContext(),"TABLEYT DEGİL",Toast.LENGTH_SHORT).show();

        }


        /*int orit = display.getOrientation();

        switch (orit)
        {
            case Configuration.ORIENTATION_PORTRAIT:
                setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
                break;
        }*/

        /*if((getResources().getConfiguration().orientation & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK) == Configuration.SCREENLAYOUT_SIZE_LARGE)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Toast.makeText(getApplicationContext(),"large",Toast.LENGTH_SHORT).show();
        } if((getResources().getConfiguration().orientation & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK) == Configuration.SCREENLAYOUT_SIZE_SMALL)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Toast.makeText(getApplicationContext(),"small",Toast.LENGTH_SHORT).show();
        } if((getResources().getConfiguration().orientation & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK) == Configuration.SCREENLAYOUT_SIZE_XLARGE)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Toast.makeText(getApplicationContext(),"xlarge",Toast.LENGTH_SHORT).show();
        } if((getResources().getConfiguration().orientation & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK) == Configuration.SCREENLAYOUT_SIZE_NORMAL)
        {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            Toast.makeText(getApplicationContext(),"normal",Toast.LENGTH_SHORT).show();
        } if((getResources().getConfiguration().orientation & Configuration.SCREENLAYOUT_LAYOUTDIR_MASK) == Configuration.SCREENLAYOUT_SIZE_UNDEFINED)
        {
            Toast.makeText(getApplicationContext(),"undefined",Toast.LENGTH_SHORT).show();
        }
        */


        Toast.makeText(getApplicationContext(),"a",Toast.LENGTH_SHORT).show();

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

                 spinnercocuk.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                     @Override
                     public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                      //   Toast.makeText(getApplicationContext(),((Cocuk)parent.getSelectedItem()).getCocukAdi(),Toast.LENGTH_LONG).show();
                     }

                     @Override
                     public void onNothingSelected(AdapterView<?> parent) {

                     }
                 });
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }
}
