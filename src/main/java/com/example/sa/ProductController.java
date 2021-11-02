package com.example.sa;

import com.example.sa.DatabaseConnection;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import org.w3c.dom.Text;

import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.Statement;
import java.util.ResourceBundle;


public class ProductController implements Initializable {

    @FXML
    private ImageView shieldImageView;
    @FXML
    private Button closeButton;

    @FXML
    private Label addProductLabel;

    @FXML
    private TextField idPro_Field;
    @FXML
    private TextField namePro_Field;
    @FXML
    private TextField pricePro_Field;
    @FXML
    private TextField quantityPro_Field;
    @FXML
    private TextField imagePro_Field;


    public void initialize(URL url, ResourceBundle resourceBundle){
        File shieldFile = new File("././image/logo.png");
        Image shieldImage = new Image(shieldFile.toURI().toString());
        shieldImageView.setImage(shieldImage);
    }

    public void closeButtonOnAction(ActionEvent event){
        Stage stage = (Stage) closeButton.getScene().getWindow();
        stage.close();
        Platform.exit();
    }


    public void addProductOnAction(ActionEvent event){
        DatabaseConnection connectionNow = new DatabaseConnection();
        Connection connectDB = connectionNow.getConnection();


        String idProduct = idPro_Field.getText();
        String nameProduct = namePro_Field.getText();
        String price = pricePro_Field.getText();
        String imagePath = imagePro_Field.getText();
        String quantity =  quantityPro_Field.getText();


        String insertField ="INSERT INTO product(id_p, name_p, price_p, quantity_p, image_p) VALUES('";
        String insertValues = idProduct + "','"+ nameProduct +"','"+ price +"','"+ quantity +"','"+ imagePath+"')";
        String insertToProduct = insertField + insertValues;


        try{
            Statement statement = connectDB.createStatement();
            statement.executeUpdate(insertToProduct);

            addProductLabel.setText("Add product successfully!");


        }catch (Exception e){
            e.printStackTrace();
            e.getCause();
        }


    }

//    private void productCheck() {
//        if(imagePro_Field.getText.equals())
//
//
//
//    }


}
