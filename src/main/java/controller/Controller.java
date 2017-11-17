package controller;

import customtablecell.CheckComboBoxTableCell;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import model.TableEntry;

import java.util.ArrayList;

public class Controller {

    @FXML
    TableView<TableEntry> tableView;

    @FXML
    TableColumn<TableEntry, Integer> poNumberColumn;

    @FXML
    TableColumn<TableEntry, String> conditionColumn;

    @FXML
    public void initialize() {
        System.out.println("Initializing...");

        tableView.getItems().setAll(createTableEntries());

        setupCellValueFactories();
        setupCellFactories();

    }

    private void setupCellValueFactories() {

        poNumberColumn.setCellValueFactory(
                cellData -> cellData.getValue().poNumberProperty().asObject()
        );

        conditionColumn.setCellValueFactory(
                cellData -> cellData.getValue().conditionProperty()
        );
    }

    private void setupCellFactories() {
        ObservableList<String> options = FXCollections.observableArrayList("Open", "Cut", "Ok");
        conditionColumn.setCellFactory(CheckComboBoxTableCell.forTableColumn(options));

        conditionColumn.setOnEditStart(handler -> System.out.println("Start."));
        conditionColumn.setOnEditCommit(handler -> {
            //Get new new checks
            String newValue = handler.getNewValue();
            System.out.println("Commit: " + newValue);
        });
        conditionColumn.setOnEditCancel(handler -> System.out.println("Cancel."));
    }

    private TableEntry[] createTableEntries() {
        ArrayList<TableEntry> tableEntries = new ArrayList<>();

        tableEntries.add(new TableEntry(1000));
        tableEntries.add(new TableEntry(2000));
        tableEntries.add(new TableEntry(3000));

        return tableEntries.toArray(new TableEntry[tableEntries.size()]);
    }
}
