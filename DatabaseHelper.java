package com.worldofwords.worldofwords.Helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.worldofwords.worldofwords.Model.Kelime;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class DatabaseHelper extends SQLiteOpenHelper {
    private Context myContext;
    private static String DB_NAME = "wow_data.db";
    private static String DB_PATH = "";
    public static int DATABASE_VERSION = 1;
    public SQLiteDatabase myDatabase;



    public void setGuncelle(String tabloAdi, ContentValues contentValues, String whereClause, String[] whereArgs){
        myDatabase = this.getReadableDatabase();
        myDatabase.update(tabloAdi,contentValues,whereClause,whereArgs);
    }




    public int getPuanlar(int seviye_id) {
        int puan = 0;
        myDatabase = this.getReadableDatabase();
        String sorgu = "select sum(puan) as toplampuan from Kelime where seviye_id="+seviye_id+" and cozuldu_mu=1";
        Cursor c = myDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            puan = c.getInt(0);
        }
        return puan;
    }



    public ArrayList<Kelime> getKelimeler(int seviye_id) {
        ArrayList<Kelime> kelimeler = new ArrayList<>();
        myDatabase = this.getReadableDatabase();
        String sorgu = "select * from Kelime where seviye_id=" + seviye_id;
        Cursor c = myDatabase.rawQuery(sorgu, null);
        while (c.moveToNext()) {
            kelimeler.add(
                    new Kelime(
                            c.getInt(c.getColumnIndex("seviye_id")),
                            c.getString(c.getColumnIndex("level_adi")),
                            c.getInt(c.getColumnIndex("sure")),
                            c.getInt(c.getColumnIndex("kelime_sayisi")),
                            c.getString(c.getColumnIndex("kelime_1")),
                            c.getString(c.getColumnIndex("kelime_2")),
                            c.getString(c.getColumnIndex("kelime_3")),
                            c.getString(c.getColumnIndex("harf_1")),
                            c.getString(c.getColumnIndex("harf_2")),
                            c.getString(c.getColumnIndex("harf_3")),
                            c.getString(c.getColumnIndex("harf_4")),
                            c.getString(c.getColumnIndex("harf_5")),
                            c.getInt(c.getColumnIndex("puan")),
                            c.getInt(c.getColumnIndex("cozuldu_mu"))
                    )
            );
        }
        return kelimeler;
        /*
        c.getInt -> int tipte cursorden değer alabilmek için,
        c.getColumnIndex -> ismini bildiğimiz kolonun indisini yakalayabilmek için
        */
    }



    public String getCategoryName(int seviye_id) {
        String str = "";
        try {
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery("select * from offline_Categories where seviye_id=" + seviye_id, null);
            while (c.moveToNext()) {
                str = c.getString(1);
            }
        } catch (Exception e) {
        }
        return str;
    }

    private int getCount(String tableName) {
        //Sorular
        myDatabase = this.getReadableDatabase();
        String Query = "select * from " + tableName;
        Cursor CR = myDatabase.rawQuery(Query, null);
        return CR.getCount();
    }

    private int getCountWithQuery(String sorgu) {
        //select * from Sorular where seviye_id=1
        //select * from Sorular where seviye_id=1 and cozuldu_mu=1
        myDatabase = this.getReadableDatabase();
        Cursor CR = myDatabase.rawQuery(sorgu, null);
        return CR.getCount();
    }


    public Cursor getRows(String query) {
        myDatabase = this.getReadableDatabase();
        String Query = query;
        Cursor CR = myDatabase.rawQuery(Query, null);
        return CR;
    }






    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {


        if (i > DATABASE_VERSION) {
            Log.v("Database Upgrade", "Database version higher than old.");
            deleteDatabase();

            try {
                createDatabase();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }


    public void openDatabase() {
        String myPath = DB_PATH + DB_NAME;
        myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
    }

    public boolean checkDatabase() {
        boolean checkdb = false;

        try {
            String dosyaKonumu = DB_PATH + DB_NAME;
            File dbFile = new File(dosyaKonumu);
            checkdb = dbFile.exists();
        } catch (SQLiteException e) {
            Log.d("DB_LOG", "Database bulunamadı");
        }

        return checkdb;
    }


    public boolean createDatabase() throws IOException {
        boolean dbExists = checkDatabase();
        // checkDatabase metodu ile database varmı/yokmu kontrolü yap
        if (dbExists) { //database varsa
            return true;
        } else { // database yoksa
            this.getReadableDatabase();
            try {
                this.close();
                copyDatabase();
            } catch (IOException e) {
                throw new Error("Database kopyalanma hatası");
            }
            return false;
        }
    }


    private void copyDatabase() throws IOException {
        String outFileName = DB_PATH + DB_NAME;
        OutputStream myOutput = new FileOutputStream(outFileName);
        InputStream myInput = myContext.getAssets().open(DB_NAME);

        byte[] buffer = new byte[1024];
        int length;
        while ((length = myInput.read(buffer)) > 0) {
            myOutput.write(buffer, 0, length);
        }
        myInput.close();
        myOutput.flush();
        myOutput.close();
    }



    public void deleteDatabase() {
        File file = new File(DB_PATH + DB_NAME);
        if (file.exists()) {
            file.delete();
            if (file.delete() == true) {
                Log.d("DB_LOG", "Database file deleted on apk in database file");
            } else {
                Log.d("DB_LOG", "Database file do not deleted !");
            }
        }
    }

    public DatabaseHelper(Context context) throws IOException {
        super(context, DB_NAME, null, DATABASE_VERSION);
        this.myContext = context;
        boolean dbExists = checkDatabase();
        DB_PATH = "/data/data/" + context.getPackageName() + "/databases/";

        if (dbExists) {
            Log.d("DB_LOG", "Database bulundu !");
        } else {
            try {
                if (createDatabase() == true) {
                    Log.d("DB_LOG", "Database oluşturuldu !");
                } else {
                    Log.d("DB_LOG", "Database oluşturulamadı !");
                }
            } catch (Exception e) {
                Log.d("DB_LOG", "Database oluşturulamadı !");
            }
        }

    }


    public synchronized void close() {
        if (myDatabase != null) {
            myDatabase.close();
        }
        super.close();
    }

}
