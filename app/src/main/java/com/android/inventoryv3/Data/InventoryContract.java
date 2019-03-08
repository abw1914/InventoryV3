package com.android.inventoryv3.Data;

import android.provider.BaseColumns;

public class InventoryContract {

    private InventoryContract(){}

    public static final class InventoryEntry implements BaseColumns {

        //task type table name
        public static final String PRODUCT_TABLE_NAME = "products";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_PRICE = "1";
        public static final String COLUMN_QUANTITY = "1";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE= "supplier_phone_number";


    }
}
