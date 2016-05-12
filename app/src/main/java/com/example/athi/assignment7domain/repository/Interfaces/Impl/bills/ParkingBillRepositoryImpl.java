package com.example.athi.assignment7domain.repository.Interfaces.Impl.bills;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.bills.ParkingBill;
import com.example.athi.assignment7domain.repository.Interfaces.bills.ParkingBillTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class ParkingBillRepositoryImpl extends SQLiteOpenHelper implements ParkingBillTypeRepository {

    public static final String TABLE_NAME = "parking";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_DAYS = "days";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_DAYS + " INTEGER NOT NULL );";

    public ParkingBillRepositoryImpl(Context context){

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
    public ParkingBill findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_DAYS},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final ParkingBill waterBill = new ParkingBill.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .days(cursor.getInt(cursor.getColumnIndex(COLUMN_DAYS)))
                    .build();

            return waterBill;
        } else {
            return null;
        }
    }

    @Override
    public ParkingBill save(ParkingBill entity) {
        open();
        ContentValues values = new ContentValues();
        //values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DAYS, entity.getDays());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        ParkingBill insertedEntity = new ParkingBill.Builder()
                .copy(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public ParkingBill update(ParkingBill entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_DAYS, entity.getDays());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public ParkingBill delete(ParkingBill entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<ParkingBill> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<ParkingBill> parkingBills = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final ParkingBill bill = new ParkingBill.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .days(cursor.getInt(cursor.getColumnIndex(COLUMN_DAYS)))
                        .build();
                parkingBills.add(bill);
            } while (cursor.moveToNext());
        }
        return parkingBills;
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
        //db.execSQL(DATABASE_CREATE);
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
