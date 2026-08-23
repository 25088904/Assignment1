package com.mycompany.extremeitassignment;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author jonat
 */
//Names:Kapa Jonathan
//Student Number:25088904
public class ReportData {
    private String productCode;
    private String productName;
    private int productCategory;
    private String warranty;
    private double price;
    private int stockLevel;
    private String supplier;

    public ReportData(String productCode, String productName, int productCategory, String warranty, double price, int stockLevel, String supplier) {
        this.productCode = productCode;
        this.productName = productName;
        this.productCategory = productCategory;
        this.warranty = warranty;
        this.price = price;
        this.stockLevel = stockLevel;
        this.supplier = supplier;
    }

    // Getters and Setters
    public String getProductCode() { return productCode; }
    public String getProductName() { return productName; }
    public int getProductCategory() { return productCategory; }
    public String getWarranty() { return warranty; }
    public double getPrice() { return price; }
    public int getStockLevel() { return stockLevel; }
    public String getSupplier() { return supplier; }

    public void setWarranty(String warranty) { this.warranty = warranty; }
    public void setPrice(double price) { this.price = price; }
    public void setStockLevel(int stockLevel) { this.stockLevel = stockLevel; }

    public String getCategoryName() {
        switch(productCategory) {
            case 1: return "Desktop Computer";
            case 2: return "Laptop";
            case 3: return "Tablet";
            case 4: return "Printer";
            case 5: return "Gaming Console";
            default: return "Unknown";
        }
    }
}