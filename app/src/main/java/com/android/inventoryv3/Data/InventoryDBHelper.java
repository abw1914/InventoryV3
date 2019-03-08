package com.android.inventoryv3.Data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.android.inventoryv3.Data.InventoryContract.InventoryEntry;

public class InventoryDBHelper extends SQLiteOpenHelper {

    public static final String LOG_TAG = InventoryDBHelper.class.getSimpleName();

    public static final String DATABASE_NAME = "store.db";
    public static final int DATABSE_VERSION = 1;

    private static final String PRODUCT_TABLE = "product_table";

    private static int KEY_ID;
    private static final String PRODUCT_NAME = "name";
    private static final String PRODUCT_PRICE = "price";
    private static final String PRODUCT_QUANTITY = "quantity";
    private static final String SUPPLIER_NAME = "supplier_name";
    private static final String SUPPLIER_PHONE = "supplier_phone";


    public InventoryDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABSE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

         String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE "
                + PRODUCT_TABLE + " ("
                + PRODUCT_NAME + " TEXT NOT NULL, "
                + PRODUCT_PRICE + " INTEGER, "
                + PRODUCT_QUANTITY + " INTEGER, "
                + SUPPLIER_NAME + " TEXT, "
                + SUPPLIER_PHONE + " TEXT, '');";



           /*String SQL_CREATE_INVENTORY_TABLE = "CREATE TABLE " + InventoryEntry.PRODUCT_TABLE_NAME + " ("
            + KEY_ID + "INTEGER PRIMARY KEY AUTOINCREMENT, "
                          + InventoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                          + InventoryEntry.COLUMN_PRODUCT_NAME + " TEXT NOT NULL, "
                          + InventoryEntry.COLUMN_PRICE + " INTEGER, "
                          + InventoryEntry.COLUMN_QUANTITY + " INTEGER, "
                          + InventoryEntry.COLUMN_SUPPLIER_NAME  + " TEXT, "
                          + InventoryEntry.COLUMN_SUPPLIER_PHONE + " TEXT,);";*/

        sqLiteDatabase.execSQL(SQL_CREATE_INVENTORY_TABLE);

    }



    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}
