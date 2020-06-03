package com.example.ujiansirrobin;

import android.content.Context;
import android.content.SharedPreferences;



public class SharedPreferencesManager {

    private String mName = "SpaceShooter";
    private Context mContext;

    public SharedPreferencesManager(Context context) {
        mContext = context;
    }

    public void saveHighScore(int score, int meteorDestroyed, int enemyDestroyed){
        SharedPreferences sp = mContext.getSharedPreferences(mName, Context.MODE_PRIVATE);
        SharedPreferences.Editor e = sp.edit();
        e.putInt("high_score", score);
        e.putInt("meteor", meteorDestroyed);
        e.putInt("enemy", enemyDestroyed);
        e.commit();
    }

    public int getHighScore(){
        SharedPreferences sp = mContext.getSharedPreferences(mName, Context.MODE_PRIVATE);
        return sp.getInt("high_score", 0);
    }

    public int getMeteorDestroyed(){
        SharedPreferences sp = mContext.getSharedPreferences(mName, Context.MODE_PRIVATE);
        return sp.getInt("meteor", 0);
    }

    public int getEnemyDestroyed(){
        SharedPreferences sp = mContext.getSharedPreferences(mName, Context.MODE_PRIVATE);
        return sp.getInt("enemy", 0);
    }
}
