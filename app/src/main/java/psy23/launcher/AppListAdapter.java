package psy23.launcher;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collection;


/**
 * Created by pkb on 28/08/16.
 */
public class AppListAdapter extends ArrayAdapter<AppModel> {
        private final LayoutInflater mInflater;

        public AppListAdapter(Context context){
            super(context, android.R.layout.simple_list_item_2);

            mInflater = LayoutInflater.from(context);
        }


    public void setData(ArrayList<AppModel> data) {
        clear();
        if (data != null) {
            addAll(data);
        }
    }

    @Override
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public void addAll(Collection<? extends AppModel> items) {
        //if the platform supports it, use add all otherwise
        //add in loop
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.HONEYCOMB) {
            super.addAll(items);
        }
        else {
            for (AppModel item: items) {
                super.add(item);
            }
        }
    }

    /**
     * Popularte new items in the list
     */
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.list_item_icon_text, parent, false);

        }
        else {
            view = convertView;
        }

        AppModel item = getItem(position);
        ((ImageView)view.findViewById(R.id.icon)).setImageDrawable(item.getIcon());
        ((TextView)view.findViewById(R.id.text)).setText(item.getLabel());

        return view;
    }


}
