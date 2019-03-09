package com.android.inventoryv3.Data;

import android.provider.BaseColumns;

public class InventoryContract {

    private InventoryContract(){}

    public static final class InventoryEntry implements BaseColumns {

        //task type table name
        public static final String PRODUCT_TABLE_NAME = "product_table";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_PRODUCT_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_SUPPLIER_NAME = "supplier_name";
        public static final String COLUMN_SUPPLIER_PHONE= "supplier_phone_number";

        //Notes from Tutor session with Akeme - the string values are important and need to stay consistant everywhere


    }
}
