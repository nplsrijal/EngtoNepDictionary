package helper;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MyHelper extends SQLiteOpenHelper {
   private static final String databaseName="DictionaryDB";
   private static final int dbversion=1;

    public MyHelper(Context context) {
        super(context, databaseName,null, dbversion);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String query =" CREATE TABLE WORDS " +
                "(wordsid INTEGER PRIMARY KEY AUTOINCREMENT,word TEXT,meaning TEXT)";
        db.execSQL(query);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean InsertData(String word,String meaning,SQLiteDatabase db){
       try{
           ContentValues contentValues=new ContentValues();
           contentValues.put("word",word);
           contentValues.put("meaning",meaning);

           db.insert("WORDS",null,contentValues);
           return  true;

       }catch(Exception e){
           Log.d("Error",e.toString());
           return false;

        }


    }
}
