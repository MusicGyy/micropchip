package com.example.sa;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Product {
    private String id_P;//8B01,8B02..,16B01,16B01
    private String name_P;
    private float price_P;
    private int quantity_P;
    private String image_P;

    public Product(){

    }
    public Product(String id_P, String name_P, float price_P, int quantity_P, String image_P) {
        this.id_P = id_P;
        this.name_P = name_P;
        this.price_P = price_P;
        this.quantity_P = quantity_P;
        this.image_P = image_P;
    }

    public String getId_P() {
        return id_P;
    }

    public void setId_P(String id_P) {
        this.id_P = id_P;
    }

    public String getName_P() {
        return name_P;
    }

    public void setName_P(String name_P) {
        this.name_P = name_P;
    }

    public float getPrice_P() {
        return price_P;
    }

    public void setPrice_P(float price_P) {
        this.price_P = price_P;
    }

    public int getQuantity_P() {
        return quantity_P;
    }

    public void setQuantity_P(int quantity_P) {
        this.quantity_P = quantity_P;
    }

    public String getImage_P() {
        return image_P;
    }

    public void setImage_P(String image_P) {
        this.image_P = image_P;
    }



    public void addProduct(String idProduct,String nameProduct,float price,String imagePath,int quantity) {
        DatabaseConnection connectionNows = new DatabaseConnection();
        Connection connectDB = connectionNows.getConnection();

                String insertField = "INSERT INTO product(id_p, name_p, price_p, quantity_p, image_p) VALUES('";
                String insertValues = idProduct + "','" + nameProduct + "','" + price + "','" + quantity + "','" + imagePath + "')";
                String insertToProduct = insertField + insertValues;


                try {
                    Statement statement = connectDB.createStatement();
                    statement.executeUpdate(insertToProduct);


                } catch (Exception e) {
                    e.printStackTrace();
                    e.getCause();
                }}
    public boolean isInt(String str) {

        try {
            @SuppressWarnings("unused")
            int x = Integer.parseInt(str);
            return true; //String is an Integer
        } catch (NumberFormatException e) {
            return false; //String is not an Integer
        }

    }
    public boolean isFloat(String str) {

        try {
            @SuppressWarnings("unused")
            float x = Float.parseFloat(str);
            return true; //String is an Integer
        } catch (NumberFormatException e) {
            return false; //String is not an Integer
        }

    }
    public boolean checkProduct(String idProduct, String nameProduct, String imagePath){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectionDB = connectionNow.getConnection();
        String connectQuery = "SELECT * FROM microchip.product";

        try {
            Statement statement = connectionDB.createStatement();
            ResultSet queryOutPut = statement.executeQuery(connectQuery);
            while (queryOutPut.next()){
                if (idProduct.equals(queryOutPut.getString("id_P"))){
                    System.out.println("1");
                    return true;
                }
                if(nameProduct.equals(queryOutPut.getString("name_P"))){
                    System.out.println("2");
                    return true;
                }
                if (imagePath.equals(queryOutPut.getString("image_P"))){
                    System.out.println("3");
                    return true;
                }
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        System.out.println("4");
        return false;
    }



}
