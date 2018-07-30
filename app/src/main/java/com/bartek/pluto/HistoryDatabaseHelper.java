package com.bartek.pluto;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.google.gson.Gson;

import java.util.ArrayList;

public class HistoryDatabaseHelper extends SQLiteOpenHelper {
    public static final String DATABASE_NAME = "Match.db";
    public static final String TABLE_NAME = "match_table";
    public static final String COL_1 = "ID";
    public static final String COL_2 = "GSON";

    public HistoryDatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE " + TABLE_NAME + " (ID INTEGER PRIMARY KEY, GSON TEXT NOT NULL)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    public boolean insertData(String GSON) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COL_2, GSON);
        long result = db.insert(TABLE_NAME, null, contentValues);
        if (result == -1) return false;
        else return true;
    }

    public Cursor getData() {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor res = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        return res;
    }

    public void deleteRow(int position) {
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = getData();
        cursor.moveToPosition(position);
        int id = cursor.getInt(cursor.getColumnIndex("ID"));
        db.execSQL("DELETE FROM " + TABLE_NAME + " WHERE ID ='" + String.valueOf(id) + "'");
        cursor.close();
    }

    public ArrayList<Match> getMatchesFromDB() {

        ArrayList<Match> matches = new ArrayList<>();
        Cursor cursor = getData();

        if (cursor.moveToFirst()) {
            while (!cursor.isAfterLast()) {
                String json = cursor.getString(cursor.getColumnIndex("GSON"));
                Gson gson = new Gson();
                Match match = gson.fromJson(json, Match.class);
                matches.add(match);
                cursor.moveToNext();
            }
        }
        cursor.close();
        return matches;
    }
}
