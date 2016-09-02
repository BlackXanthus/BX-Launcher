package psy23.launcher;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by pkb on 02/09/16.
 */
public class QuickAdapter extends BaseAdapter {

    public Context mContext;
    ApplicationInfo[] appInfo = new ApplicationInfo[10];
    Drawable icon = null;
    LayoutInflater mInflater;

    public QuickAdapter(Context context) {

        mContext=context;
        mInflater = LayoutInflater.from(context);
    }

    public int getCount() {
        return appInfo.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    /**
    // Convert DP to PX
    // Source: http://stackoverflow.com/a/8490361
    public int dpToPx(int dps) {
        final float scale = getResources().getDisplayMetrics().density;
        int pixels = (int) (dps * scale + 0.5f);

        return pixels;
    }
**/
    public void add(ApplicationInfo item){
        appInfo[0]=item;

    }

    public void add(Drawable mIcon) {
        icon=mIcon;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view;

        if (convertView == null) {
            view = mInflater.inflate(R.layout.list_item_icon_text, parent, false);

        }
        else {
            view = convertView;
        }

        //AppModel item = getItem(position);
        ((ImageView)view.findViewById(R.id.icon)).setImageDrawable(icon);
        //((TextView)view.findViewById(R.id.text)).setText(item.getLabel());

        return view;
    }

}
