package sercandevops.com.spinner1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SpinnerCocukAdapter extends BaseAdapter {
private Context context;
private List<Cocuk> list;

    public SpinnerCocukAdapter(Context context, List<Cocuk> list) {
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
            convertView = layoutInflater.inflate(R.layout.custom_sp_cocuk_layout,parent,false);

        }


        TextView t2 = convertView.findViewById(R.id.textcocukisim);

        Cocuk cocuk = (Cocuk) getItem(position);

        if (cocuk != null)
        {

            t2.setText(""+cocuk.getCocukAdi());
        }


        return convertView;
    }
}
