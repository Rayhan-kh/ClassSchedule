package com.foxcoders.classschedule.Database;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Ray on 2/6/2018.
 */

public class SharedPreferencesManager {
    private final String SHAREDPREFKEY = "ehgr ebrfbf vvsryu";
    private final String NOTIFYKEY = "ehgr";
    private SharedPreferences sharedPreferences;

    public SharedPreferencesManager(Context context) {
        sharedPreferences = context.getSharedPreferences(SHAREDPREFKEY, Context.MODE_PRIVATE);
    }

    public void setWillGetNotification(Boolean boo) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putBoolean(NOTIFYKEY, boo);
        editor.apply();
    }

    public boolean getWillGetNotification() {
        return sharedPreferences.getBoolean(NOTIFYKEY, false);
    }


}
