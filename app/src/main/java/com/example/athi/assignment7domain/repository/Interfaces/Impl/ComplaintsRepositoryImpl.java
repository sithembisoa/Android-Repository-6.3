package com.example.athi.assignment7domain.repository.Interfaces.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.SQLException;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.Complaints;
import com.example.athi.assignment7domain.repository.Interfaces.ComplaintsTypeRepository;

import java.util.HashSet;
import java.util.Set;


/**
 * Created by Administrator on 2016/04/21.
 */
public class ComplaintsRepositoryImpl extends SQLiteOpenHelper implements ComplaintsTypeRepository {

    public static final String TABLE_NAME = "settings";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_COMPLAINT = "complaint";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_COMPLAINT + " TEXT NOT NULL );";


    public ComplaintsRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);
    }

    @Override
    public Complaints findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_COMPLAINT},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Complaints complaints = new Complaints.Builder(cursor.getString(cursor.getColumnIndex(COLUMN_COMPLAINT)))
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .build();

            return complaints;
        } else {
            return null;
        }
    }

    @Override
    public Complaints save(Complaints entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPLAINT, entity.logComplaint());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Complaints insertedEntity = new Complaints.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public Complaints update(Complaints entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_COMPLAINT, entity.logComplaint());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Complaints delete(Complaints entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Complaints> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Complaints> settings = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Complaints setting = new Complaints.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .complaint(cursor.getString(cursor.getColumnIndex(COLUMN_COMPLAINT)))
                        .build();
                settings.add(setting);
            } while (cursor.moveToNext());
        }
        return settings;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }
}
