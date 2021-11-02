//package com.example.sa;
//
//import javafx.event.ActionEvent;
//import javafx.fxml.FXML;
//import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
//import javafx.scene.Scene;
//import javafx.scene.control.Button;
//import javafx.scene.control.Label;
//import javafx.scene.image.Image;
//import javafx.scene.image.ImageView;
//import javafx.stage.Stage;
//import javafx.stage.StageStyle;
//
//import java.io.File;
//import java.net.URL;
//import java.sql.Connection;
//import java.sql.ResultSet;
//import java.sql.Statement;
//import java.util.ResourceBundle;
//
//public class HelloController {
//    @FXML
//    private Label showProductLable;
//    @FXML
//    private ImageView shieldImageView;
//
//    @FXML
//    private Button exitButton;
//
//
//
//
//    public void exitButtonOnAction(ActionEvent event){
//        Stage stage = (Stage) exitButton.getScene().getWindow();
//        stage.close();
//    }
//
////    @FXML
////    private Button nextBotton;
//
//
////    public void initialize(URL url, ResourceBundle resourceBundle){
////    File shieldFile = new File("image/logo.png");
////    Image shieldImage = new Image(shieldFile.toURI().toString());
////    shieldImageView.setImage(shieldImage);
////}
//    public void connectionButton(ActionEvent event) {
//        DatabaseConnection connection = new DatabaseConnection();
//        Connection connectDB = connection.getConnection();
//
//        String connectQuery = "SELECT id_P fROM product";
//
//
//        try{
//            Statement statement = connectDB.createStatement();
//            ResultSet queryOutput = statement.executeQuery(connectQuery);
//
//            while(queryOutput.next()){
//                showProductLable.setText(queryOutput.getString("id_P"));
//            }
//
//
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//
//    }
//
//    public void nextBottonOnAction(ActionEvent event){
//        DatabaseConnection connectNow = new DatabaseConnection();
//        Connection connectDB = connectNow.getConnection();
////        Statement statement = connectDB.createStatement();
//        addProductForm();
//
//    }
//
//
//    public void addProductForm(){
//        try{
//            Parent root = FXMLLoader.load(getClass().getResource("product.fxml"));
//            Stage productStage = new Stage();
//            productStage.initStyle(StageStyle.DECORATED);
//            productStage.setScene(new Scene(root, 520, 400));
//            productStage.show();
//
//        }catch(Exception e){
//            e.printStackTrace();
//            e.getCause();
//        }
//
//
//    }
//    //
////    @FXML
////    protected void onHelloButtonClick() {
////        welcomeText.setText("Welcome to JavaFX Application!");
////    }
//}