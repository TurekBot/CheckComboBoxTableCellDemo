/*
 * Copyright (c) 2012, 2014, Oracle and/or its affiliates. All rights reserved.
 * ORACLE PROPRIETARY/CONFIDENTIAL. Use is subject to license terms.
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 *
 */

package customtablecell;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.util.Callback;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;


/**
 * A class containing a {@link TableCell} implementation that draws a
 * {@link CheckComboBox} node inside the cell.
 * <p>
 * <p>By default, the CheckComboBoxTableCell is rendered as a {@link Label} when not
 * being edited, and as a CheckComboBox when in editing mode. The CheckComboBox will, by
 * default, stretch to fill the entire table cell.
 * <p>
 * <p>To create a CheckComboBoxTableCell, it is necessary to provide zero or more
 * items that will be shown to the user when the {@link CheckComboBox} menu is
 * showing. These items must be of the same type as the TableColumn.
 *
 * @param <T> The type of the elements contained within the TableColumn.
 * @since JavaFX 2.2
 */
public class CheckComboBoxTableCell<S, T> extends TableCell<S, T> {

    /***************************************************************************
     *                                                                         *
     * Static cell factories                                                   *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a CheckComboBox cell factory for use in {@link TableColumn} controls.
     * By default, the CheckComboBoxCell is rendered as a {@link Label} when not
     * being edited, and as a CheckComboBox when in editing mode. The CheckComboBox will,
     * by default, stretch to fill the entire list cell.
     *
     * @param <T>   The type of the elements contained within the TableColumn.
     * @param items Zero or more items that will be shown to the user when the
     *              {@link CheckComboBox} menu is showing. These items must be of the same
     *              type as the TableColumn. Note that it is up to the developer to set
     *              {@link EventHandler event handlers} to listen to edit events in the
     *              TableColumn, and react accordingly. Methods of interest include
     *              {@link TableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart},
     *              {@link TableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit},
     *              and {@link TableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel}.
     * @return A {@link Callback} that will return a TableCell that is able to
     * work on the type of element contained within the TableColumn.
     */
    @SafeVarargs
    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(
            final T... items) {
        return forTableColumn(null, items);
    }

    /**
     * Creates a CheckComboBox cell factory for use in {@link TableColumn} controls.
     * By default, the CheckComboBoxCell is rendered as a {@link Label} when not
     * being edited, and as a CheckComboBox when in editing mode. The CheckComboBox will,
     * by default, stretch to fill the entire list cell.
     *
     * @param <T>       The type of the elements contained within the TableColumn.
     * @param converter A {@link StringConverter} to convert the given item (of
     *                  type T) to a String for displaying to the user.
     * @param items     Zero or more items that will be shown to the user when the
     *                  {@link CheckComboBox} menu is showing. These items must be of the same
     *                  type as the TableColumn. Note that it is up to the developer to set
     *                  {@link EventHandler event handlers} to listen to edit events in the
     *                  TableColumn, and react accordingly. Methods of interest include
     *                  {@link TableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart},
     *                  {@link TableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit},
     *                  and {@link TableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel}.
     * @return A {@link Callback} that will return a TableCell that is able to
     * work on the type of element contained within the TableColumn.
     */
    @SafeVarargs
    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(
            final StringConverter<T> converter,
            final T... items) {
        return forTableColumn(converter, FXCollections.observableArrayList(items));
    }

    /**
     * Creates a CheckComboBox cell factory for use in {@link TableColumn} controls.
     * By default, the CheckComboBoxCell is rendered as a {@link Label} when not
     * being edited, and as a CheckComboBox when in editing mode. The CheckComboBox will,
     * by default, stretch to fill the entire list cell.
     *
     * @param <T>   The type of the elements contained within the TableColumn.
     * @param items Zero or more items that will be shown to the user when the
     *              {@link CheckComboBox} menu is showing. These items must be of the same
     *              type as the TableColumn. Note that it is up to the developer to set
     *              {@link EventHandler event handlers} to listen to edit events in the
     *              TableColumn, and react accordingly. Methods of interest include
     *              {@link TableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart},
     *              {@link TableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit},
     *              and {@link TableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel}.
     * @return A {@link Callback} that will return a TableCell that is able to
     * work on the type of element contained within the TableColumn.
     */
    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(
            final ObservableList<T> items) {
        return forTableColumn(null, items);
    }

    /**
     * Creates a CheckComboBox cell factory for use in {@link TableColumn} controls.
     * By default, the CheckComboBoxCell is rendered as a {@link Label} when not
     * being edited, and as a CheckComboBox when in editing mode. The CheckComboBox will,
     * by default, stretch to fill the entire list cell.
     *
     * @param <T>       The type of the elements contained within the TableColumn.
     * @param converter A {@link StringConverter} to convert the given item (of
     *                  type T) to a String for displaying to the user.
     * @param items     Zero or more items that will be shown to the user when the
     *                  {@link CheckComboBox} menu is showing. These items must be of the same
     *                  type as the TableColumn. Note that it is up to the developer to set
     *                  {@link EventHandler event handlers} to listen to edit events in the
     *                  TableColumn, and react accordingly. Methods of interest include
     *                  {@link TableColumn#setOnEditStart(javafx.event.EventHandler) setOnEditStart},
     *                  {@link TableColumn#setOnEditCommit(javafx.event.EventHandler) setOnEditCommit},
     *                  and {@link TableColumn#setOnEditCancel(javafx.event.EventHandler) setOnEditCancel}.
     * @return A {@link Callback} that will return a TableCell that is able to
     * work on the type of element contained within the TableColumn.
     */
    public static <S, T> Callback<TableColumn<S, T>, TableCell<S, T>> forTableColumn(
            final StringConverter<T> converter,
            final ObservableList<T> items) {
        return list -> new CheckComboBoxTableCell<S, T>(converter, items);
    }


    /***************************************************************************
     *                                                                         *
     * Fields                                                                  *
     *                                                                         *
     **************************************************************************/

    private final ObservableList<T> items;

    private CheckComboBox<T> checkComboBox;


    /***************************************************************************
     *                                                                         *
     * Constructors                                                            *
     *                                                                         *
     **************************************************************************/

    /**
     * Creates a default CheckComboBoxTableCell with an empty items list.
     */
    public CheckComboBoxTableCell() {
        this(FXCollections.<T>observableArrayList());
    }

    /**
     * Creates a default {@link CheckComboBoxTableCell} instance with the given items
     * being used to populate the {@link CheckComboBox} when it is shown.
     *
     * @param items The items to show in the CheckComboBox popup menu when selected
     *              by the user.
     */
    @SafeVarargs
    public CheckComboBoxTableCell(T... items) {
        this(FXCollections.observableArrayList(items));
    }

    /**
     * Creates a {@link CheckComboBoxTableCell} instance with the given items
     * being used to populate the {@link CheckComboBox} when it is shown, and the
     * {@link StringConverter} being used to convert the item in to a
     * user-readable form.
     *
     * @param converter A {@link StringConverter} that can convert an item of type T
     *                  into a user-readable string so that it may then be shown in the
     *                  CheckComboBox popup menu.
     * @param items     The items to show in the CheckComboBox popup menu when selected
     *                  by the user.
     */
    @SafeVarargs
    public CheckComboBoxTableCell(StringConverter<T> converter, T... items) {
        this(converter, FXCollections.observableArrayList(items));
    }

    /**
     * Creates a default {@link CheckComboBoxTableCell} instance with the given items
     * being used to populate the {@link CheckComboBox} when it is shown.
     *
     * @param items The items to show in the CheckComboBox popup menu when selected
     *              by the user.
     */
    public CheckComboBoxTableCell(ObservableList<T> items) {
        this(null, items);
    }

    /**
     * Creates a {@link CheckComboBoxTableCell} instance with the given items
     * being used to populate the {@link CheckComboBox} when it is shown, and the
     * {@link StringConverter} being used to convert the item in to a
     * user-readable form.
     *
     * @param converter A {@link StringConverter} that can convert an item of type T
     *                  into a user-readable string so that it may then be shown in the
     *                  CheckComboBox popup menu.
     * @param items     The items to show in the CheckComboBox popup menu when selected
     *                  by the user.
     */
    public CheckComboBoxTableCell(StringConverter<T> converter, ObservableList<T> items) {
        this.getStyleClass().add("combo-box-table-cell");
        this.items = items;
        setConverter(converter != null ? converter : CellUtils.<T>defaultStringConverter());
    }


    /***************************************************************************
     *                                                                         *
     * Properties                                                              *
     *                                                                         *
     **************************************************************************/

    // --- converter
    private ObjectProperty<StringConverter<T>> converter =
            new SimpleObjectProperty<StringConverter<T>>(this, "converter");

    /**
     * The {@link StringConverter} property.
     */
    public final ObjectProperty<StringConverter<T>> converterProperty() {
        return converter;
    }

    /**
     * Sets the {@link StringConverter} to be used in this cell.
     */
    public final void setConverter(StringConverter<T> value) {
        converterProperty().set(value);
    }

    /**
     * Returns the {@link StringConverter} used in this cell.
     */
    public final StringConverter<T> getConverter() {
        return converterProperty().get();
    }


    // --- checkComboBox editable
    private BooleanProperty checkComboBoxEditable =
            new SimpleBooleanProperty(this, "checkComboBoxEditable");

    /**
     * A property representing whether the CheckComboBox, when shown to the user,
     * is editable or not.
     */
    public final BooleanProperty checkComboBoxEditableProperty() {
        return checkComboBoxEditable;
    }

    /**
     * Configures the CheckComboBox to be editable (to allow user input outside of the
     * options provide in the dropdown list).
     */
    public final void setCheckComboBoxEditable(boolean value) {
        checkComboBoxEditableProperty().set(value);
    }

    /**
     * Returns true if the CheckComboBox is editable.
     */
    public final boolean isCheckComboBoxEditable() {
        return checkComboBoxEditableProperty().get();
    }


    /***************************************************************************
     *                                                                         *
     * Public API                                                              *
     *                                                                         *
     **************************************************************************/

    /**
     * Returns the items to be displayed in the ChoiceBox when it is showing.
     */
    public ObservableList<T> getItems() {
        return items;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void startEdit() {
        if (!isEditable() || !getTableView().isEditable() || !getTableColumn().isEditable()) {
            return;
        }

        if (checkComboBox == null) {
            checkComboBox = CellUtils.createCheckComboBox(this, items, converterProperty());
            //CheckComboBox doesn't seem to be editable/non-editable
            //checkComboBox.editableProperty().bind(checkComboBoxEditableProperty());
        }
        //CheckComboBox doesn't have a SelectionModel, it has a CheckModel.
        //checkComboBox.getSelectionModel().select(getItem());

        super.startEdit();
        setText(null);
        setGraphic(checkComboBox);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void cancelEdit() {
        super.cancelEdit();

        setText(getConverter().toString(getItem()));
        setGraphic(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updateItem(T item, boolean empty) {
        super.updateItem(item, empty);
        CellUtils.updateItem(this, getConverter(), null, null, checkComboBox);
    }
}
