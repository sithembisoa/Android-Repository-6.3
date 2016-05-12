package com.example.athi.assignment7domain.repository.Interfaces.Impl.management;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.management.TenantManagement;
import com.example.athi.assignment7domain.repository.Interfaces.management.TenantManagementTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class TenantManagementRepositoryImpl extends SQLiteOpenHelper implements TenantManagementTypeRepository{
    public static final String TABLE_NAME = "management";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_SIZE = "size";

    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_SIZE + " INTEGER NOT NULL );";

    public TenantManagementRepositoryImpl(Context context){

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
    public TenantManagement findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final TenantManagement tenant = new TenantManagement.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .build();

            return tenant;
        } else {
            return null;
        }
    }

    @Override
    public TenantManagement save(TenantManagement entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_SIZE, entity.getSize());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        TenantManagement insertedEntity = new TenantManagement.Builder()
                .copy(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public TenantManagement update(TenantManagement entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public TenantManagement delete(TenantManagement entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<TenantManagement> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<TenantManagement> tenants = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final TenantManagement tenant = new TenantManagement.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .build();
                tenants.add(tenant);
            } while (cursor.moveToNext());
        }
        return tenants;
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
