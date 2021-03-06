package com.example.libra;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataBaseHelper extends SQLiteOpenHelper {


    public static final String BOOK_TABLE = "BOOK_TABLE";
    public static final String COLUMN_BOOK_ID = "BOOK_ID";
    public static final String COLUMN_NAME = "NAME";
    public static final String COLUMN_BOOK_NAME = "BOOK_NAME";
    public static final String COLUMN_BOOK_AUTHOR = "BOOK_AUTHOR";
    public static final String COLUMN_BOOK_GENRE = "BOOK_GENRE";
    public static final String USER_TABLE = "USER_TABLE";
    public static final String COLUMN_USERNAME = "USERNAME";
    public static final String COLUMN_PASSWORD = "PASSWORD";

    public DataBaseHelper(@Nullable Context context) { super(context, "book.db", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String createTableStatement = "CREATE TABLE " + BOOK_TABLE + "(" + COLUMN_BOOK_ID + " VARCHAR(10) PRIMARY KEY, " + COLUMN_BOOK_NAME + " TEXT, " + COLUMN_BOOK_AUTHOR + " TEXT, " + COLUMN_BOOK_GENRE + " TEXT)";
        db.execSQL(createTableStatement);
        String createTableQuery = "CREATE TABLE " + USER_TABLE + "(" + COLUMN_NAME + " TEXT, " + COLUMN_USERNAME + " TEXT PRIMARY KEY, " + COLUMN_PASSWORD + " TEXT)";
        db.execSQL(createTableQuery);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
    }

    public boolean addUser(UserModel new_user){
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues cv = new ContentValues();

        cv.put(COLUMN_NAME,new_user.getName());
        cv.put(COLUMN_USERNAME,new_user.getUsername());
        cv.put(COLUMN_PASSWORD,new_user.getPassword());

        long result = db.insert(USER_TABLE, null ,cv);
        if(result == -1){
            return false;
        }
        else{
            return true;
        }
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

    public List<bookmodel> viewAll(){
        List<bookmodel> returnlist = new ArrayList<>();
        String query = "SELECT * FROM " + BOOK_TABLE;
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query,null);
        if(cursor.moveToFirst()){
            do{
                String ID = cursor.getString(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String genre = cursor.getString(3);

                bookmodel new_book = new bookmodel(ID,name,author,genre);
                returnlist.add(new_book);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return returnlist;
    }

    public List<bookmodel> search(String term) {
        List<bookmodel> result = new ArrayList<>();
        String query = "SELECT * FROM " + BOOK_TABLE + " WHERE " + COLUMN_BOOK_NAME + " LIKE '%" + term + "%'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            do{
                String ID = cursor.getString(0);
                String name = cursor.getString(1);
                String author = cursor.getString(2);
                String genre = cursor.getString(3);

                bookmodel new_book = new bookmodel(ID,name,author,genre);
                result.add(new_book);
            }while(cursor.moveToNext());
        }
        cursor.close();
        db.close();
        return result;
    }

    public boolean deleteOne(String term) {
        SQLiteDatabase db = this.getWritableDatabase();
        return db.delete(BOOK_TABLE, COLUMN_BOOK_ID + "=?", new String[]{term}) > 0;
    }

    public boolean login(String username, String pass){
        String query = "SELECT * FROM " + USER_TABLE + " WHERE " + COLUMN_USERNAME + " = '" + username + "' AND " + COLUMN_PASSWORD + " = '" + pass + "'";
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery(query, null);
        if(cursor.moveToFirst()){
            return true;
        }
        else{
            return false;
        }
    }
}
