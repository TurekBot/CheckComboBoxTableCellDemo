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
        //Prepare the checkable options that will be given to the user
        ObservableList<String> options = FXCollections.observableArrayList("Open", "Cut", "Ok");


        conditionColumn.setCellFactory(CheckComboBoxTableCell.forTableColumn(options));



        //If we use `.setOnEditCommit()`, we replaced the default handler and are then saying that we put ourselves in
        // charge of writing back the property that the user just committed. This is explained clearly in the
        // Editing section of the TableView documentation.
        //See: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html
        //However if we use addEventHandler, the default behavior is preserved.
        conditionColumn.addEventHandler(TableColumn.editCommitEvent(), event -> {
            String newValue = (String) event.getNewValue();
            System.out.println("Commited value: " + newValue);
        });
        conditionColumn.addEventHandler(TableColumn.editStartEvent(), event -> System.out.println("Start."));
        conditionColumn.addEventHandler(TableColumn.editCancelEvent(), event -> System.out.println("Cancel."));

    }

    /**
     * Just preparing some rows to go in the table.
     */
    private TableEntry[] createTableEntries() {
        ArrayList<TableEntry> tableEntries = new ArrayList<>();

        tableEntries.add(new TableEntry(1000));
        tableEntries.add(new TableEntry(2000));
        tableEntries.add(new TableEntry(3000));

        return tableEntries.toArray(new TableEntry[tableEntries.size()]);
    }
}
