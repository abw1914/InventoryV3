package com.android.inventoryv3.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.inventoryv3.Data.InventoryContract.InventoryEntry;

import static com.android.inventoryv3.Data.InventoryContract.InventoryEntry._ID;

public class InventoryDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = InventoryDBHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "store1.db";
    public static final int DATABSE_VERSION = 1;

    public InventoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

           String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " + InventoryEntry.PRODUCT_TABLE_NAME + " ("
            + InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "

                          + InventoryEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                          + InventoryEntry.COLUMN_PRICE + " INTEGER, "
                          + InventoryEntry.COLUMN_QUANTITY + " INTEGER, "
                          + InventoryEntry.COLUMN_SUPPLIER_NAME  + " TEXT, "
                          + InventoryEntry.COLUMN_SUPPLIER_PHONE + " TEXT);";

        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);

        //Notes from Tutor session with Akeme - the spaces here " INTEGER, "  really matter becasue you are cancatinating strings
        //Remember to rename the database with each version a
        //Remember to update the database_version when doing new versions
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
