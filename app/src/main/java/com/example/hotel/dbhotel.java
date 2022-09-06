package com.example.hotel;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import java.util.ArrayList;

public class dbhotel extends SQLiteOpenHelper {
    public static final String dbname = "data.db";

    public dbhotel(@Nullable Context context)
    {
        super(context, dbname, null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("create table hotel (id INTEGER PRIMARY KEY AUTOINCREMENT,name TEXT,place TEXT,stars TEXT, price TEXT,image INTEGER)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    db.execSQL("DROP TABLE IF EXISTS hotel");
    onCreate(db);
    }

    public boolean insertdata(String name,String place ,String stars,String price,int image)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentvalues =new ContentValues();
        contentvalues.put("name",name);
        contentvalues.put("place",place);
        contentvalues.put("stars",stars);
        contentvalues.put("price",price);
        contentvalues.put("image",image);
        long res = db.insert("hotel",null,contentvalues);
        if(res ==-1)
            return false;
        else
            return true;

    }

    public ArrayList getdata(String name, String price,String place,String stars)
    {
        //ArrayList arr =new ArrayList();
        String []arg={name,stars,place,stars};
        ArrayList<item> items = new ArrayList<>();
        SQLiteDatabase db =this.getReadableDatabase();
        Cursor cur =db.rawQuery("select * from hotel where ((name like ? and price like ? and place like ? and stars like ?) or(name like ? and price like ? and place like ?) or (name like ? and place like ?) or (place like ?) or (name like ?) or (id < 11 ))  limit 10 ",arg);

        cur.moveToFirst();
        while(cur.isAfterLast()==false)
        {

            String b =cur.getString(1);
            String c =cur.getString(2);
            String d =cur.getString(3);
            String e =cur.getString(4);
            int f =cur.getInt(5);

            items.add(new item(b,c,d,e,f));
            cur.moveToNext();
        }

         //cur.moveToNext();
        return items;
    }

}
