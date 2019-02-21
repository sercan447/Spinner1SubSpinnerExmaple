package sercandevops.com.spinner1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerAdapter extends BaseAdapter {
private Context context;
private List<Kisi> list;

    public SpinnerAdapter(Context context, List<Kisi> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null)
        {
            LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = layoutInflater.inflate(R.layout.custom_sp_layout,parent,false);

        }
        //TextView t1 = convertView.findViewById(R.id.textid);

        TextView t2 = convertView.findViewById(R.id.textisim);

        Kisi kisi = (Kisi) getItem(position);

        if (kisi != null)
        {
           // t1.setText(""+kisi.getId());
            t2.setText(""+kisi.getIsim());
        }


        return convertView;
    }
}
