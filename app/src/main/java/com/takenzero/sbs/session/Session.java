package com.takenzero.sbs.session;

import android.content.Context;
import android.content.SharedPreferences;

public class Session {
    SharedPreferences pref;
    SharedPreferences.Editor edtr;
    Context ctx;

    public Session(Context ctx){
        this.ctx = ctx;
        pref = ctx.getSharedPreferences("SBS", Context.MODE_PRIVATE);
        edtr = pref.edit();
    }

    public void setLoggedin(boolean loggedin){
        edtr.putBoolean("LoggedInMode", loggedin);
        edtr.commit();
    }

    public boolean loggedin(){
        return pref.getBoolean("LoggedInMode", false);
    }

}
