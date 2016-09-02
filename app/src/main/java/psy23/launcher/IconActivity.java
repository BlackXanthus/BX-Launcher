package psy23.launcher;

import android.support.v4.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.provider.Telephony;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;

/**
 * Created by pkb on 01/09/16.
 */
public class IconActivity extends Fragment {


    PackageManager mPm;
    Context mContext;
    String defaultSmsPackageName;
    AppListAdapter aLa;
    QuickAdapter qa;

    //Null Constructer
    public IconActivity() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        View rootView = inflater.inflate(R.layout.fragment_icons, container, false);
        //View view = inflater.inflate(R.layout.list_item_icon_text, parent, false);

        mContext= getActivity().getApplicationContext();
        aLa = new AppListAdapter(mContext);

        Drawable icon = null;

        mPm = getActivity().getApplicationContext().getPackageManager();
        qa = new QuickAdapter(mContext);

        String defaultSmsPackageName = Telephony.Sms.getDefaultSmsPackage(mContext); // Need to change the build to API 19

        //ApplicationInfo aI = mPm.getPackageInfo(defaultSmsPackageName);

        try {
            icon = mPm.getApplicationIcon(defaultSmsPackageName);
            qa.add(icon);
            //((ImageView)view.findViewById(R.id.icon)).setImageDrawable(icon);
            //((TextView)view.findViewById(R.id.text)).setText(item.getLabel());
        }
        catch(PackageManager.NameNotFoundException e) {
            Toast.makeText(mContext, "No Default SMS Package Found", Toast.LENGTH_LONG).show();
        }

        ListView mGridView = (ListView)rootView.findViewById(R.id.listView);
        mGridView.setAdapter(qa);
        return mGridView;
    }

    /**
     *
     * @param mInfo
     * @return
     *
    public Drawable getIcon(ApplicationInfo mInfo) {

        String mAppLabel;
         Drawable mIcon;

        boolean mMounted;
        final File mApkFile;

        //Placeholder. Replace these!
        mIcon = null;
        mApkFile = null;
        mMounted = null;

        if (mIcon == null) {
            if (mApkFile.exists()) {
                mIcon = mInfo.loadIcon(mContext.getPackageManager());
                return mIcon;
            } else {
                mMounted = false;
            }
        } else if (!mMounted) {
            // If the app wasn't mounted but is now mounted, reload
            // its icon.
            if (mApkFile.exists()) {
                mMounted = true;
                mIcon = mInfo.loadIcon(mContext.getPackageManager());
                return mIcon;
            }
        } else {
            return mIcon;
        }
        return mIcon;
    }
**/
    public void testCode() {

        Intent sendIntent = new Intent(Intent.ACTION_SEND);
        sendIntent.setType("text/plain");
        sendIntent.putExtra(Intent.EXTRA_TEXT, "text");

        if (defaultSmsPackageName != null)// Can be null in case that there is no default, then the user would be able to choose
        // any app that support this intent.
        {
            sendIntent.setPackage(defaultSmsPackageName);
        }
        startActivity(sendIntent);


    }
}
