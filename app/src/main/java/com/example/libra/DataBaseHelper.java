package com.example.libra;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String BOOK_TABLE = "BOOK_TABLE";
    public static final String COLUMN_BOOK_ID = "BOOK_ID";
    public static final String COLUMN_BOOK_NAME = "BOOK_NAME";
    public static final String COLUMN_BOOK_AUTHOR = "BOOK_AUTHOR";
    public static final String COLUMN_BOOK_GENRE = "BOOK_GENRE";

    public DataBaseHelper(@Nullable Context context) {
        super(context, "book.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + BOOK_TABLE + "(" + COLUMN_BOOK_ID + " VARCHAR(10) PRIMARY KEY, " + COLUMN_BOOK_NAME + " TEXT, " + COLUMN_BOOK_AUTHOR + " TEXT, " + COLUMN_BOOK_GENRE + " TEXT)";
        db.execSQL(createTableStatement);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(bookmodel new_book){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_BOOK_ID,new_book.getBook_id());
        cv.put(COLUMN_BOOK_NAME,new_book.getBook_name());
        cv.put(COLUMN_BOOK_AUTHOR,new_book.getAuthor());
        cv.put(COLUMN_BOOK_GENRE,new_book.getGenre());

        long result = db.insert(BOOK_TABLE, null ,cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }
}