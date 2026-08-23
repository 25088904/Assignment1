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


import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Products {
    private ArrayList<ReportData> productList;
    private Scanner input;

    public Products() {
        productList = new ArrayList<>();
        input = new Scanner(System.in);
    }

    public void DisplayMenu() {
        System.out.println("BRIGHT FUTURE TECHNOLOGIES APPLICATION");
        System.out.println("**************************************");
        System.out.println("Enter (1) to launch menu or any other key to exit.");
        String launch = input.nextLine();
        
        if(launch.equals("1")) {
            String choice;
            do {
                System.out.println("\nPlease select one of the following menu items:");
                System.out.println("(1) Capture a new product.");
                System.out.println("(2) Search for a product.");
                System.out.println("(3) Update a product.");
                System.out.println("(4) Delete a product.");
                System.out.println("(5) Print report.");
                System.out.println("(6) Save products to file.");
                System.out.println("(7) Exit Application.");
                choice = input.nextLine();
                
                switch(choice) {
                    case "1": CaptureProduct(); break;
                    case "2": SearchProduct(); break;
                    case "3": UpdateProduct(); break;
                    case "4": DeleteProduct(); break;
                    case "5": PrintReport(); break;
                    case "6": SaveToFile(); break;
                    case "7": ExitApplication(); break;
                    default: System.out.println("Invalid choice.");
                }
            } while(!choice.equals("7"));
        }
    }

    public void CaptureProduct() {
        System.out.println("CAPTURE A NEW PRODUCT");
        System.out.println("*********************");
        System.out.print("Enter the product code: ");
        String code = input.nextLine();
        System.out.print("Enter the product name: ");
        String name = input.nextLine();
        
        int category;
        do {
            System.out.println("Select the product category:");
            System.out.println("Desktop Computer - 1");
            System.out.println("Laptop - 2");
            System.out.println("Tablet - 3");
            System.out.println("Printer - 4");
            System.out.println("Gaming Console - 5");
            System.out.print("Product Category >> ");
            category = Integer.parseInt(input.nextLine());
            if(category < 1 || category > 5) System.out.println("Invalid category. Try again.");
        } while(category < 1 || category > 5);
        
        System.out.print("Indicate warranty. Enter (1) for 6 months or any other key for 2 years: ");
        String warranty = input.nextLine().equals("1") ? "6 months" : "2 years";
        
        System.out.print("Enter the price for " + name + " >> R");
        double price = Double.parseDouble(input.nextLine());
        System.out.print("Enter the stock level for " + name + " >> ");
        int stock = Integer.parseInt(input.nextLine());
        System.out.print("Enter the supplier for " + name + " >> ");
        String supplier = input.nextLine();
        
        productList.add(new ReportData(code, name, category, warranty, price, stock, supplier));
        System.out.println("Product details has been saved successfully!!!");
    }

    public void SearchProduct() {
        System.out.print("Please enter the product code to search: ");
        String code = input.nextLine();
        ReportData found = null;
        for(ReportData p : productList) {
            if(p.getProductCode().equalsIgnoreCase(code)) {
                found = p; break;
            }
        }
        if(found != null) {
            System.out.println("PRODUCT SEARCH RESULTS");
            System.out.println("PRODUCT CODE: " + found.getProductCode());
            System.out.println("PRODUCT NAME: " + found.getProductName());
            System.out.println("PRODUCT CATEGORY: " + found.getCategoryName());
            System.out.println("PRODUCT WARRANTY: " + found.getWarranty());
            System.out.println("PRODUCT PRICE: R" + found.getPrice());
            System.out.println("PRODUCT STOCK LEVEL: " + found.getStockLevel());
            System.out.println("PRODUCT SUPPLIER: " + found.getSupplier());
        } else {
            System.out.println("The product cannot be located. Invalid Product");
        }
    }

    public void DeleteProduct() {
        System.out.print("Please enter the product code to delete: ");
        String code = input.nextLine();
        ReportData found = null;
        for(ReportData p : productList) {
            if(p.getProductCode().equalsIgnoreCase(code)) {
                found = p; break;
            }
        }
        if(found != null) {
            System.out.print("Are you sure you want to delete " + found.getProductName() + "? (y/n): ");
            if(input.nextLine().equalsIgnoreCase("y")) {
                productList.remove(found);
                System.out.println("Product deleted successfully!");
            }
        } else {
            System.out.println("Product not found.");
        }
    }

    public void UpdateProduct() {
        System.out.print("Please enter the product code to update: ");
        String code = input.nextLine();
        ReportData found = null;
        for(ReportData p : productList) {
            if(p.getProductCode().equalsIgnoreCase(code)) {
                found = p; break;
            }
        }
        if(found != null) {
            System.out.print("Update the warranty? (y/n): ");
            if(input.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter (1) for 6 months or any other key for 2 years: ");
                found.setWarranty(input.nextLine().equals("1") ? "6 months" : "2 years");
            }
            System.out.print("Update the product price? (y/n): ");
            if(input.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter the new price >> R");
                found.setPrice(Double.parseDouble(input.nextLine()));
            }
            System.out.print("Update the stock level? (y/n): ");
            if(input.nextLine().equalsIgnoreCase("y")) {
                System.out.print("Enter the new stock level >> ");
                found.setStockLevel(Integer.parseInt(input.nextLine()));
            }
            System.out.println("Product details has been updated successfully!!!");
        } else {
            System.out.println("Product not found.");
        }
    }

    public void PrintReport() {
        if(productList.isEmpty()) {
            System.out.println("No products to display.");
            return;
        }
        System.out.println("\nPRODUCT REPORT");
        System.out.println("========================================");
        
        double totalValue = 0;
        for(ReportData p : productList) {
            System.out.println("Code: " + p.getProductCode() + " | Name: " + p.getProductName() + 
                               " | Category: " + p.getCategoryName() + " | Price: R" + p.getPrice());
            totalValue += p.getPrice();
        }
        
        System.out.println("========================================");
        System.out.println("TOTAL PRODUCT COUNT: " + productList.size());
        System.out.println("TOTAL PRODUCT VALUE: R" + totalValue);
        if(productList.size() > 0) {
            System.out.println("AVERAGE PRODUCT VALUE: R" + (totalValue / productList.size()));
        }
        System.out.println("========================================");
    }

    public void SaveToFile() {
        try {
            FileWriter writer = new FileWriter("products.txt");
            
            writer.write("PRODUCT REPORT\n");
            writer.write("========================================\n");
            
            double totalValue = 0;
            for(ReportData p : productList) {
                writer.write(p.getProductCode() + "," + 
                             p.getProductName() + "," + 
                             p.getCategoryName() + "," + 
                             p.getPrice() + "\n");
                totalValue += p.getPrice();
            }
            
            writer.write("=======================================\n");
            writer.write("TOTAL PRODUCT COUNT: " + productList.size() + "\n");
            writer.write("TOTAL PRODUCT VALUE: R" + totalValue + "\n");
            if(productList.size() > 0) {
                writer.write("AVERAGE PRODUCT VALUE: R" + (totalValue / productList.size()) + "\n");
            }
            writer.close();
            
            System.out.println("Products saved successfully to products.txt");
            
        } catch (IOException e) {
            System.out.println("Error saving file: " + e.getMessage());
        }
    }

    public void ExitApplication() {
        System.out.println("Exiting application. Goodbye!");
        System.exit(0);
    }
}