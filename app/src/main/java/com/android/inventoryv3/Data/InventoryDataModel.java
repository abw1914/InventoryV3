package com.android.inventoryv3.Data;

public class InventoryDataModel {
    private String PRODUCT;
    private String QUANTITY;
    private String PRICE;
    private String SUPPLIERNAME;
    private String SUPPLIERPHONE;

    public InventoryDataModel(String PRODUCT, String QUANTITY, String PRICE, String SUPPLIERNAME, String SUPPLIERPHONE) {
        this.PRODUCT = PRODUCT;
        this.QUANTITY = QUANTITY;
        this.PRICE = PRICE;
        this.SUPPLIERNAME = SUPPLIERNAME;
        this.SUPPLIERPHONE = SUPPLIERPHONE;
    }

    public String getPRODUCT() {
        return PRODUCT;
    }

    public void setPRODUCT(String PRODUCT) {
        this.PRODUCT = PRODUCT;
    }

    public String getQUANTITY() {
        return QUANTITY;
    }

    public void setQUANTITY(String QUANTITY) {
        this.QUANTITY = QUANTITY;
    }

    public String getPRICE() {
        return PRICE;
    }

    public void setPRICE(String PRICE) {
        this.PRICE = PRICE;
    }

    public String getSUPPLIERNAME() {
        return SUPPLIERNAME;
    }

    public void setSUPPLIERNAME(String SUPPLIERNAME) {
        this.SUPPLIERNAME = SUPPLIERNAME;
    }

    public String getSUPPLIERPHONE() {
        return SUPPLIERPHONE;
    }

    public void setSUPPLIERPHONE(String SUPPLIERPHONE) {
        this.SUPPLIERPHONE = SUPPLIERPHONE;
    }
}
