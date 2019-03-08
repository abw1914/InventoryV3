package com.android.inventoryv3;

import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.inventoryv3.Data.InventoryContract.InventoryEntry;
import com.android.inventoryv3.Data.InventoryDBHelper;

public class MainActivity extends AppCompatActivity {
    Button showData;

    InventoryDBHelper inventoryDBHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        inventoryDBHelper = new InventoryDBHelper(this);

        showData = findViewById(R.id.showInventory);
        showData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertInventory();
                displayDatabaseInfo();

            }
        });
    }

    protected void onStart() {
        super.onStart();
        displayDatabaseInfo();
    }

    private void displayDatabaseInfo() {
        SQLiteDatabase db = inventoryDBHelper.getReadableDatabase();
        String[] projection = {
                InventoryEntry._ID,
                InventoryEntry.COLUMN_PRODUCT_NAME,
                InventoryEntry.COLUMN_PRICE,
                InventoryEntry.COLUMN_QUANTITY,
                InventoryEntry.COLUMN_SUPPLIER_NAME,
                InventoryEntry.COLUMN_SUPPLIER_PHONE };

        Cursor cursor = db.query(
                InventoryEntry.PRODUCT_TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null);

        TextView displayView = (TextView) findViewById(R.id.inventory_list);

        try {

            displayView.setText("Inventory table contains " + cursor.getCount() + " products \n\n");
            displayView.append(InventoryEntry._ID + " - " +
                    InventoryEntry.COLUMN_PRODUCT_NAME + " - " +
                    InventoryEntry.COLUMN_PRICE + " - " +
                    InventoryEntry.COLUMN_QUANTITY + " - " +
                    InventoryEntry.COLUMN_SUPPLIER_NAME + " - " +
                    InventoryEntry.COLUMN_SUPPLIER_PHONE + "\n");

            // Figure out the index of each column
            int idColumnIndex = cursor.getColumnIndex(InventoryEntry._ID);
            int productColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRODUCT_NAME);
            int priceColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_PRICE);
            int quantityColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_QUANTITY);
            int supplierColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_NAME);
            int supplierPhoneColumnIndex = cursor.getColumnIndex(InventoryEntry.COLUMN_SUPPLIER_PHONE);

            while (cursor.moveToNext()) {
                int currentID = cursor.getInt(idColumnIndex);
                String currentProduct = cursor.getString(productColumnIndex);
                String currentPrice = cursor.getString(priceColumnIndex);
                String currentQuantity = cursor.getString(quantityColumnIndex);
                String currentSupplierName = cursor.getString(supplierColumnIndex);
                String currentSupplierPhone = cursor.getString(supplierPhoneColumnIndex);

                // Display the values from each column of the current row in the cursor in the TextView
                displayView.append(("\n" + currentID + " - " +
                        currentProduct + " - " +
                        currentPrice + " - " +
                        currentQuantity + " - " +
                        currentSupplierName + " - " +
                        currentSupplierPhone));
            }
        } finally {
            cursor.close();
        }
    }

    private void insertInventory() {
        SQLiteDatabase db = inventoryDBHelper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, "Headphone");
        values.put(InventoryEntry.COLUMN_PRICE, "Terrier");
        values.put(InventoryEntry.COLUMN_QUANTITY, "45");
        values.put(InventoryEntry.COLUMN_SUPPLIER_NAME, "Bose");
        values.put(InventoryEntry.COLUMN_SUPPLIER_PHONE, "451-909-3456");

        long newRowId = db.insert(InventoryEntry.PRODUCT_TABLE_NAME, null, values);
    }
}
