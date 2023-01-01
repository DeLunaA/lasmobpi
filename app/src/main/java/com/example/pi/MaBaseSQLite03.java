package com.example.pi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class MaBaseSQLite03 extends SQLiteOpenHelper {
    private static final String TABLE_PANIER = "table_panier";
    private static final String COL_tel = "Tel";
    private static final String COL_Iteam = "Iteam";

    private static final String CREATE_TABLE_PANIER = "CREATE TABLE " + TABLE_PANIER + " ("
            + COL_tel + " TEXT," + COL_Iteam
            + " TEXT);" ;

    private static final String update_db = "DROP TABLE " + TABLE_PANIER + ";";

    public MaBaseSQLite03(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }


    @Override
    public void onCreate (SQLiteDatabase db){
        db.execSQL(CREATE_TABLE_PANIER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVision){
        //remove the data base
        db.execSQL(update_db);

        //then recreate it by :
        onCreate(db);
    }



}


