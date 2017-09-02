package sample;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

public class Controller {

    @FXML    private TextField purchName; // textfield to write the product name in
    @FXML    private TextField price;      // textfield to write the price of the product in
    @FXML    private TableView<Item> table = new TableView<>();    // table to store pairs (purchase, price)
    @FXML    private TableColumn names;    // table column for product names
    @FXML    private TableColumn prices;   // table column for product price

    private int id = 0;           // variable to store purchase id
    private ObservableList<Item> data = FXCollections.observableArrayList(); // stores Item objects (id, purchaseName, price)

    /* Method add data from the textfields to the table */
    @FXML    public void onClickBtnAdd(Event event) {

        table.setEditable(true);

        /* @param purchName - field of class Item
         @param price - field of class Item */
        names.setCellValueFactory(new PropertyValueFactory<Item, String>("purchName"));
        prices.setCellValueFactory(new PropertyValueFactory<Item, String>("price"));

        try {
            data.add(new Item(++id, purchName.getText(), Integer.parseInt(price.getText())));   // add data from textfields to data
            table.setItems(data);                           // set data to table
            table.getColumns().setAll(names, prices);       // set columns to table
            purchName.requestFocus();                       // set cursor in the textfield purchName

        } catch (NumberFormatException e) {
            Alert alert = setAlert();   // set params for the alert window
            alert.showAndWait();
            e.printStackTrace();
        } finally {
            purchName.setText("");
            price.setText("");
        }

    }

    // method to set params for the alert window
    private Alert setAlert() {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Error converting \'" + price.getText() + "\' to integer.");
        alert.setContentText("Enter the correct integer number.");

        return alert;
    }


}
