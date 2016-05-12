package com.example.athi.assignment7domain.repository.Interfaces.Impl.maintenance;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.maintenance.Maintanance;
import com.example.athi.assignment7domain.repository.Interfaces.maintenance.MaintananceTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class MaintananceRepositoryImpl extends SQLiteOpenHelper implements MaintananceTypeRepository{
    public static final String TABLE_NAME = "maintenance";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_CHECK = "check";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_CHECK + " TEXT NOT NULL );";

    public MaintananceRepositoryImpl(Context context){

        super(context, DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
        getReadableDatabase().execSQL(DATABASE_CREATE);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Maintanance findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_CHECK,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Maintanance maintanance = new Maintanance.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .check(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_CHECK))))
                    .build();

            return maintanance;
        } else {
            return null;
        }
    }

    @Override
    public Maintanance save(Maintanance entity) {
        open();
        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CHECK, entity.maintananceChecks());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Maintanance insertedEntity = new Maintanance.Builder()
                .copy(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Maintanance update(Maintanance entity) {
        open();
        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_CHECK, entity.maintananceChecks());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Maintanance delete(Maintanance entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Maintanance> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Maintanance> mains = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Maintanance maintanance = new Maintanance.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .check(Boolean.parseBoolean(cursor.getString(cursor.getColumnIndex(COLUMN_CHECK))))
                        .build();
                mains.add(maintanance);
            } while (cursor.moveToNext());
        }
        return mains;
    }

    @Override
    public int deleteAll() {
        open();
        int rowsDeleted = db.delete(TABLE_NAME,null,null);
        close();
        return rowsDeleted;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.w(this.getClass().getName(),
                "Upgrading database from version " + oldVersion + " to "
                        + newVersion + ", which will destroy all old data");
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        onCreate(db);

    }
}
