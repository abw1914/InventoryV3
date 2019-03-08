package com.android.inventoryv3;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.NavUtils;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.android.inventoryv3.Data.InventoryContract.InventoryEntry;
import com.android.inventoryv3.Data.InventoryDBHelper;

public class EditorActivity extends AppCompatActivity {
    InventoryDBHelper inventoryDBHelper;
    EditText mProduct, mPrice, mQuantity, mSupplierName, mSupplierPhone;
    Button mEnterProduct;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mProduct = findViewById(R.id.editProduct);
        mPrice = findViewById(R.id.editPrice);
        mQuantity = findViewById(R.id.editQuantity);
        mSupplierName = findViewById(R.id.editSupplier);
        mSupplierPhone = findViewById(R.id.editSupplierPhone);

        mEnterProduct = findViewById(R.id.enterInventory);

        mEnterProduct.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                insertInventory();
                finish();
            }
        });
    }

    private void insertInventory() {
        String productString = mProduct.getText().toString().trim();
        String priceString = mPrice.getText().toString().trim();
        String quantityString = mQuantity.getText().toString().trim();
        String supplierString = mSupplierName.getText().toString().trim();
        String supplierPhoneString = mSupplierPhone.getText().toString().trim();

        inventoryDBHelper = new InventoryDBHelper(this);

        // Gets the database in write mode
        SQLiteDatabase db = inventoryDBHelper.getWritableDatabase();

        // Create a ContentValues object where column names are the keys,
        // and pet attributes from the editor are the values.
        ContentValues values = new ContentValues();
        values.put(InventoryEntry.COLUMN_PRODUCT_NAME, productString);
        values.put(InventoryEntry.COLUMN_PRICE, priceString);
        values.put(InventoryEntry.COLUMN_QUANTITY, quantityString);
        values.put(InventoryEntry.COLUMN_SUPPLIER_NAME, supplierString);
        values.put(InventoryEntry.COLUMN_SUPPLIER_PHONE, supplierPhoneString);

        // Insert a new row for pet in the database, returning the ID of that new row.
        long newRowId = db.insert(InventoryEntry.PRODUCT_TABLE_NAME, null, values);

        // Show a toast message depending on whether or not the insertion was successful
        if (newRowId == -1) {

            Toast.makeText(this, "Error saving new product", Toast.LENGTH_SHORT).show();
        } else {
            // Otherwise, the insertion was successful and we can display a toast with the row ID.
            Toast.makeText(this, "New product saved to row: " + newRowId, Toast.LENGTH_SHORT).show();
        }
    }

}

