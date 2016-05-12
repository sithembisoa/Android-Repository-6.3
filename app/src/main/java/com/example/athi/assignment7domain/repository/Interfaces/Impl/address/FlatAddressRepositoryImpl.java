package com.example.athi.assignment7domain.repository.Interfaces.Impl.address;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.address.FlatAddress;
import com.example.athi.assignment7domain.repository.Interfaces.address.FlatAddressTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class FlatAddressRepositoryImpl extends SQLiteOpenHelper implements FlatAddressTypeRepository{

    public static final String TABLE_NAME = "address";
    private SQLiteDatabase db;



    public static final String COLUMN_ID = "id";
    public static final String COLUMN_NUMBER = "number";
    public static final String COLUMN_ZIPCODE = "zip";


    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_NUMBER + " TEXT  NOT NULL , "
            + COLUMN_ZIPCODE + " INTEGER NOT NULL );";


    public FlatAddressRepositoryImpl(Context context) {
        super(context, DBConstants.DATABASE_NAME, null, DBConstants.DATABASE_VERSION);
        getReadableDatabase().execSQL(DATABASE_CREATE);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public FlatAddress findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_NUMBER,
                        COLUMN_ZIPCODE},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final FlatAddress addressType = new FlatAddress.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .flatNo(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                    .zip(cursor.getInt(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                    .build();

            return addressType;
        } else {
            return null;
        }
    }

    @Override
    public FlatAddress save(FlatAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUMBER, entity.getFlatNo());
        values.put(COLUMN_ZIPCODE, entity.getZipcode());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        FlatAddress insertedEntity = new FlatAddress.Builder()
                .copy(entity)
                .id(new Long(id))
                .build();
        return insertedEntity;
    }

    @Override
    public FlatAddress update(FlatAddress entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_NUMBER, entity.getFlatNo());
        values.put(COLUMN_ZIPCODE, entity.getZipcode());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public FlatAddress delete(FlatAddress entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<FlatAddress> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<FlatAddress> addressTypes = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final FlatAddress addressType = new FlatAddress.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .flatNo(cursor.getString(cursor.getColumnIndex(COLUMN_NUMBER)))
                        .zip(cursor.getInt(cursor.getColumnIndex(COLUMN_ZIPCODE)))
                        .build();
                addressTypes.add(addressType);
            } while (cursor.moveToNext());
        }
        return addressTypes;
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
