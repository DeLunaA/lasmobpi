package com.example.pi;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class panier {
    private String Tel;

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getIteam() {
        return Iteam;
    }

    public void setIteam(String iteam) {
        Iteam = iteam;
    }

    private String Iteam;

    public panier(String Tel, String Iteam) {
        this.Tel = Tel;
        this.Iteam = Iteam;

    }

    public panier() {
    }

    public static class MaBaseSQLite extends SQLiteOpenHelper {

        private static final String TABLE_PANIER = "table_Panier";
        private static final String COL_Tel = "Tel";
        private static final String COL_Iteam = "Iteam";


        public MaBaseSQLite(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {

            super(context, name, factory, version);
        }


        @Override
        public void onCreate(SQLiteDatabase db) {

            db.execSQL("CREATE TABLE " + TABLE_PANIER + " ("
                    + COL_Tel + " TEXT PRIMARY KEY," + COL_Iteam + " TEXT);");
        }



        @Override
        public void onUpgrade(SQLiteDatabase db, int i, int i1) {

            db.execSQL("DROP TABLE " + TABLE_PANIER + ";");
            onCreate(db);


        }

    }
}





