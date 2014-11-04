package com.example.manuel.al_lah;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by Manuel on 14/10/2014.
 */
public class BDHelper extends SQLiteOpenHelper {

    private static final String DB_NAME = "Organizador";
    private static final int DB_SCHEME_VERSION = 1;

    public BDHelper(Context context) {
        super(context, DB_NAME, null, DB_SCHEME_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
    db.execSQL(ControlBD.CREATE_TABLE);
    db.execSQL(ControlBD.CREATE_TABLE2);
    db.execSQL(ControlBD.CREATE_TABLE3);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
