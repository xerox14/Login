package com.bloomberg.login;

import android.provider.BaseColumns;


/**
 * Created by ajendrasharma on 08/02/15.
 */
public class TableData {

    public TableData()
    {

    }
    public static abstract class TableInfo implements BaseColumns
    {
        public static final String USER_NAME= "user_name";
        public static final String USER_PASS= "user_pass";
        public static final String DATABASE_NAME= "user_info";
        public static final String TABLE_NAME = "reg_info";


    }

}
