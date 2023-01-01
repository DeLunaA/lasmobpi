package com.example.pi;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class PanierDB {

        private static final int VERSION_BDD = 1;
        private static final String NOM_BDD = "panier03.db";

        private static final String TABLE_PANIER = "table_Panier";

        private static final String COL_Tel = "Tel";
        private static final int NUM_COL_Tel = 0;

        private static final String COL_Iteam = "Iteam";
        private static final int NUM_COL_Iteam = 1;


        //creation base de données
        private SQLiteDatabase bdd;


        private panier.MaBaseSQLite03 maBaseSQLite;

        public PanierDB(Context context) {
            //On créer la BDD et sa table et on va declencher method maBaseSQLite et apres elle va aussi declencher onCreate et onUpgrade
            maBaseSQLite = new panier.MaBaseSQLite03(context, NOM_BDD, null, VERSION_BDD);

        }

        public void open() {
            bdd = maBaseSQLite.getWritableDatabase();

        }

        public void close() {
            //on ferme l'accès à la BDD (fermer la connection)
            bdd.close();
        }

        public SQLiteDatabase getBDD() {

            return bdd;
        }

        public long insertPanier(panier panier) {
                //Création d'un ContentValues
                ContentValues values = new ContentValues();
                //on lui ajoute une valeur associé à une clé (qui est le nom de la colonne dans laquelle on veut mettre la valeur)

                values.put(COL_Tel, panier.getTel());
                values.put(COL_Iteam, panier.getIteam());
                return bdd.insert(TABLE_PANIER, null, values);
        }


        public Boolean checkuser(String etel) {
                Cursor m = bdd.rawQuery("select * from table_Panier where Tel = ? ", new String[]{etel});

                if (m.getCount() > 0)
                        return true;
                else
                        return false;


        }

        public Boolean updatepanier(String tel,String iteam){
                ContentValues contentValues=new ContentValues();
                contentValues.put("iteam",iteam);
                long result=bdd.update("TABLE_PANIER",contentValues,"Tel=?",new String[]{tel});
                if (result==-1)
                        return false;
                else
                        return true;
        }


        public panier getpanierWithTelephone(String Tel) {
                Cursor f = bdd.query(TABLE_PANIER, new String[]{"Tel", "Iteam"}, "Tel=?", new String[]{String.valueOf(Tel)},
                        null, null, null, null);

                if (f.getCount() == 0)
                        return null;

                f.moveToFirst();

                panier panier = new panier(f.getString(0), f.getString(1));
                return panier;

        }

        /*public panier droppanier(String Tel) {
                Cursor f = bdd.delete(TABLE_PANIER, null, null)

                panier panier = new panier(f.getString(0), f.getString(1));
                return panier;

        }*/


}

