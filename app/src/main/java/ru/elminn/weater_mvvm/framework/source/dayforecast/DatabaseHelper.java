package ru.elminn.weater_mvvm.framework.source.dayforecast;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import retrofit2.Converter;
import ru.elminn.weater_mvvm.data.models.DayForecastInfo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by ravi on 15/03/18.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "weather_db";


    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    // Creating Tables
    @Override
    public void onCreate(SQLiteDatabase db) {

        // create notes table
        db.execSQL(DayForecastInfo.CREATE_TABLE);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + DayForecastInfo.TABLE_NAME);

        // Create tables again
        onCreate(db);
    }

    public long insertData(DayForecastInfo model) {
        // get writable database as we want to write data
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        // `id` and `timestamp` will be inserted automatically.
        // no need to add them
        values.put("dayTempInfo", model.getDayTempInfo());
        for (Field field:
             model.getClass().getFields()) {
            try {
                values.put("dayTempInfo", model.getDayTempInfo());
                values.put("pressure", model.getPressure());
                values.put("humidity", model.getHumidity());
                //TODO with reflection
                /*if(field.getType().equals(Float.TYPE)) {
                    values.put(field.getName(), (Float) field.get(model));
                }else if(field.getType().getName().equals(Integer.TYPE.toString())){
                    values.put(field.getName(), (Integer) field.get(model));
                }*/
            }catch (Exception ex){
                Log.e("DatabaseHelper", "Insert error");
            }
        }
        // insert row
        long id = db.insert(DayForecastInfo.TABLE_NAME, null, values);

        // close db connection
        db.close();

        // return newly inserted row id
        return id;
    }

    public DayForecastInfo getData(int id) {
        // get readable database as we are not inserting anything
        SQLiteDatabase db = this.getReadableDatabase();

        String selectQuery = "SELECT  * " +
                "FROM " + DayForecastInfo.TABLE_NAME +
                " WHERE ID = " + id;

        Cursor cursor = db.rawQuery(selectQuery, null);
        if (cursor != null)
            cursor.moveToFirst();

        // prepare  object
        DayForecastInfo data = new DayForecastInfo(
                cursor.getLong(cursor.getColumnIndex("dayTempInfo")),
                cursor.getLong(cursor.getColumnIndex("pressure")),
                cursor.getInt(cursor.getColumnIndex("humidity")));

        // close the db connection
        cursor.close();

        return data;
    }

    public List<DayForecastInfo> getAllData() {
        List<DayForecastInfo> list = new ArrayList<>();

        // Select All Query
        String selectQuery = "SELECT  * FROM " + DayForecastInfo.TABLE_NAME + " ORDER BY " +
                 "ID DESC";

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                // prepare  object
                DayForecastInfo data = new DayForecastInfo(
                        cursor.getLong(cursor.getColumnIndex("dayTempInfo")),
                        cursor.getLong(cursor.getColumnIndex("pressure")),
                        cursor.getInt(cursor.getColumnIndex("humidity")));

                list.add(data);
            } while (cursor.moveToNext());
        }

        // close db connection
        db.close();

        // return notes list
        return list;
    }

   /* public int getNotesCount() {
        String countQuery = "SELECT  * FROM " + Note.TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(countQuery, null);

        int count = cursor.getCount();
        cursor.close();


        // return count
        return count;
    }

    public int updateNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(Note.COLUMN_NOTE, note.getNote());

        // updating row
        return db.update(Note.TABLE_NAME, values, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
    }

    public void deleteNote(Note note) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(Note.TABLE_NAME, Note.COLUMN_ID + " = ?",
                new String[]{String.valueOf(note.getId())});
        db.close();
    }*/
}
