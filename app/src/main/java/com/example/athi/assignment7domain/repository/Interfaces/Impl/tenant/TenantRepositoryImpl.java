package com.example.athi.assignment7domain.repository.Interfaces.Impl.tenant;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.athi.assignment7domain.conf.databases.DBConstants;
import com.example.athi.assignment7domain.domain.tenant.Tenant;
import com.example.athi.assignment7domain.repository.Interfaces.tenant.TenantTypeRepository;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Administrator on 2016/04/21.
 */
public class TenantRepositoryImpl extends SQLiteOpenHelper implements TenantTypeRepository{

    public static final String TABLE_NAME = "tenant";
    private SQLiteDatabase db;

    public static final String COLUMN_ID = "id";
    public static final String COLUMN_FULLNAME = "fullname";
    public static final String COLUMN_IDNUMBER = "idnumber";



    // Database creation sql statement
    private static final String DATABASE_CREATE = " CREATE TABLE "
            + TABLE_NAME + "("
            + COLUMN_ID + " INTEGER  PRIMARY KEY AUTOINCREMENT, "
            + COLUMN_IDNUMBER + " INTEGER NOT NULL, "
            + COLUMN_FULLNAME + " TEXT NOT NULL );";

    public TenantRepositoryImpl(Context context){

        super(context, DBConstants.DATABASE_NAME,null,DBConstants.DATABASE_VERSION);
    }

    public void open() throws SQLException {
        db = this.getWritableDatabase();
    }

    public void close() {
        this.close();
    }

    @Override
    public Tenant findById(Long id) {

        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query(
                TABLE_NAME,
                new String[]{
                        COLUMN_ID,
                        COLUMN_FULLNAME,
                        COLUMN_IDNUMBER},
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(id)},
                null,
                null,
                null,
                null);
        if (cursor.moveToFirst()) {
            final Tenant tenant = new Tenant.Builder()
                    .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                    .fullName(cursor.getString(cursor.getColumnIndex(COLUMN_FULLNAME)))
                    .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_IDNUMBER)))
                    .build();

            return tenant;
        } else {
            return null;
        }
    }

    @Override
    public Tenant save(Tenant entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_FULLNAME, entity.getFullName());
        values.put(COLUMN_IDNUMBER, entity.getIdNumber());
        long id = db.insertOrThrow(TABLE_NAME, null, values);
        Tenant insertedEntity = new Tenant.Builder()
                .copy(entity)
                .id(id)
                .build();
        return insertedEntity;
    }

    @Override
    public Tenant update(Tenant entity) {
        open();
        ContentValues values = new ContentValues();
        values.put(COLUMN_ID, entity.getId());
        values.put(COLUMN_FULLNAME, entity.getFullName());
        values.put(COLUMN_IDNUMBER, entity.getFullName());
        db.update(
                TABLE_NAME,
                values,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())}
        );
        return entity;
    }

    @Override
    public Tenant delete(Tenant entity) {
        open();
        db.delete(
                TABLE_NAME,
                COLUMN_ID + " =? ",
                new String[]{String.valueOf(entity.getId())});
        return entity;
    }

    @Override
    public Set<Tenant> findAll() {
        SQLiteDatabase db = this.getReadableDatabase();
        Set<Tenant> tenants = new HashSet<>();
        open();
        Cursor cursor = db.query(TABLE_NAME, null,null,null,null,null,null);
        if (cursor.moveToFirst()) {
            do {
                final Tenant tenant = new Tenant.Builder()
                        .id(cursor.getLong(cursor.getColumnIndex(COLUMN_ID)))
                        .fullName(cursor.getString(cursor.getColumnIndex(COLUMN_FULLNAME)))
                        .idNumber(cursor.getString(cursor.getColumnIndex(COLUMN_IDNUMBER)))
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
