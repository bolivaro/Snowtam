package com.syrdav.snowtamer;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by David on 08/12/2016.
 */
public class DatabaseHandler extends SQLiteOpenHelper {
    // All Static variables
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "UsersAccount";

    // Contacts table name
    private static final String TABLE_USER = "Users";

    // Contacts Table Columns names
    private static final String ID = "id";
    private static final String EMAIL = "email";
    private static final String PASSWORD = "password";




    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        String CREATE_CONTACTS_TABLE = "CREATE TABLE " + TABLE_USER + "("
                + ID + " INTEGER PRIMARY KEY," + EMAIL + " TEXT,"
                + PASSWORD + " TEXT" + ")";
        db.execSQL(CREATE_CONTACTS_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_USER);

        // Create tables again
        onCreate(db);

    }

    public void addUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMAIL, user.getEmail()); // Contact Name
        values.put(PASSWORD, user.getPassword()); // Contact Phone Number

        // Inserting Row
        db.insert(TABLE_USER, null, values);
        db.close(); // Closing database connection
    }


    public User getUser(String email) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = db.query(TABLE_USER, new String[] { ID,
                        EMAIL, PASSWORD }, PASSWORD + "=?",
                new String[] {email }, null, null, null, null);
        User user;


        cursor.moveToFirst();
//populate table
        if (cursor.getCount()<=0){
            user=null;

        }else{
            user = new User(cursor.getInt(0),cursor.getString(1), cursor.getString(2));
        }
        cursor.close();
         return user;

    }

    public int updateUser(User user) {
        SQLiteDatabase db = this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(EMAIL, user.getEmail());
        values.put(PASSWORD, user.getPassword());

        // updating row
        return db.update(TABLE_USER, values, ID + " = ?",
                new String[] { String.valueOf(user.getUserId()) });
    }


}
