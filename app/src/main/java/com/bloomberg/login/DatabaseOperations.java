package com.bloomberg.login;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

//added comments
/**
 * Created by ajendrasharma on 08/02/15.
 */
public class DatabaseOperations extends SQLiteOpenHelper {
    public static final int database_version = 1;
    public String CREATE_QUERY = " CREATE TABLE " + TableData.TableInfo.TABLE_NAME + "(" + TableData.TableInfo.USER_NAME + " TEXT " + TableData.TableInfo.USER_PASS + " TEXT );";


    public DatabaseOperations(Context context) {
        super(context, TableData.TableInfo.DATABASE_NAME, null, database_version);
        Log.d("Database operations", "database created");
    }

    @Override
    public void onCreate(SQLiteDatabase sdb) {
        sdb.execSQL(CREATE_QUERY);
        Log.d("Database operations", "Table created ");


    }

    @Override
    public void onUpgrade(SQLiteDatabase arg0, int arg1, int arg2) {

    }

    public void putInformation(DatabaseOperations dop, String name, String password) {
        SQLiteDatabase SQ = dop.getWritableDatabase();
        ContentValues cv = new ContentValues();
        cv.put(TableData.TableInfo.USER_NAME, name);
        cv.put(TableData.TableInfo.USER_PASS, password);
        long k = SQ.insert(TableData.TableInfo.TABLE_NAME, null, cv);
        Log.d("Database operations", "One row inserted ");
    }

    public Cursor getInformation(DatabaseOperations dop) {

        SQLiteDatabase SQ = dop.getReadableDatabase();
        String[] coloumns = {TableData.TableInfo.USER_NAME, TableData.TableInfo.USER_PASS};
        Cursor CR = SQ.query(TableData.TableInfo.TABLE_NAME, coloumns, null, null, null, null, null);
        return CR;
    }

}
