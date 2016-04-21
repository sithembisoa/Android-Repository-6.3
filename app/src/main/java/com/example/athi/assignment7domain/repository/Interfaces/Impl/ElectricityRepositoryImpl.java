package com.example.athi.assignment7domain.repository.Interfaces.Impl;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.ElectricityBill;
import com.example.athi.assignment7domain.repository.Interfaces.ElectricityTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class ElectricityRepositoryImpl extends SQLiteOpenHelper implements ElectricityTypeRepository {

    public static final String TABLE_NAME = "electricitybill";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_WATS = "wats";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_WATS + " TEXT NOT NULL );";

    public ElectricityRepositoryImpl(Context context){

        super(context,DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public ElectricityBill findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_WATS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final ElectricityBill electricityBill = new ElectricityBill.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .wats(cursor.getDouble(cursor.getColumnIndex(COLUMN_WATS)))
                    .build();

            return electricityBill;
        } else {
            return null;
        }
    }

    @Override
    public ElectricityBill save(ElectricityBill entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_WATS, entity.getWats());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ElectricityBill insertedEntity = new ElectricityBill.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public ElectricityBill update(ElectricityBill entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_WATS, entity.getWats());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public ElectricityBill delete(ElectricityBill entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<ElectricityBill> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ElectricityBill> electricityBills = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ElectricityBill electricityBill = new ElectricityBill.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .wats(cursor.getDouble(cursor.getColumnIndex(COLUMN_WATS)))
                        .build();
                electricityBills.add(electricityBill);
            } while (cursor.moveToNext());
        }
        return electricityBills;
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
}
