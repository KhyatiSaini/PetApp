package com.example.android.pets.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class PetDbHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = PetDbHelper.class.getSimpleName();
    private static final String DATABASE_NAME="shelter.db";
    private static final int DATABASE_VERSION = 3;
    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String SQL_CREATE_PET_TABLE="CREATE TABLE "+ PetContract.PetEntry.TABLE_NAME+"("
                + PetContract.PetEntry._ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
                + PetContract.PetEntry.COLUMN_NAME+" TEXT NOT NULL,"
                + PetContract.PetEntry.COLUMN_BREED+" TEXT,"
                + PetContract.PetEntry.COLUMN_GENDER+" INTEGER NOT NULL,"
                + PetContract.PetEntry.COLUMN_WEIGHT+" INTEGER NOT NULL DEFAULT 0);";
        sqLiteDatabase.execSQL(SQL_CREATE_PET_TABLE);
        Log.v(LOG_TAG,"I created table");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
    public PetDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
}
