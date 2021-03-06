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

import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import javafx.scene.Node;
import javafx.scene.control.Cell;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TreeItem;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.HBox;
import javafx.util.StringConverter;
import org.controlsfx.control.CheckComboBox;

// Package protected - not intended for external use
class CellUtils {

    static int TREE_VIEW_HBOX_GRAPHIC_PADDING = 3;

    /***************************************************************************
     *                                                                         *
     * Private fields                                                          *
     *                                                                         *
     **************************************************************************/

    private final static StringConverter<?> defaultStringConverter = new StringConverter<Object>() {
        @Override
        public String toString(Object t) {
            return t == null ? null : t.toString();
        }

        @Override
        public Object fromString(String string) {
            return (Object) string;
        }
    };

    private final static StringConverter<?> defaultTreeItemStringConverter =
            new StringConverter<TreeItem<?>>() {
                @Override
                public String toString(TreeItem<?> treeItem) {
                    return (treeItem == null || treeItem.getValue() == null) ?
                            "" : treeItem.getValue().toString();
                }

                @Override
                public TreeItem<?> fromString(String string) {
                    return new TreeItem<>(string);
                }
            };

    /***************************************************************************
     *                                                                         *
     * General convenience                                                     *
     *                                                                         *
     **************************************************************************/

    /*
     * Simple method to provide a StringConverter implementation in various cell
     * implementations.
     */
    @SuppressWarnings("unchecked")
    static <T> StringConverter<T> defaultStringConverter() {
        return (StringConverter<T>) defaultStringConverter;
    }

    /*
     * Simple method to provide a TreeItem-specific StringConverter
     * implementation in various cell implementations.
     */
    @SuppressWarnings("unchecked")
    static <T> StringConverter<TreeItem<T>> defaultTreeItemStringConverter() {
        return (StringConverter<TreeItem<T>>) defaultTreeItemStringConverter;
    }

    private static <T> String getItemText(Cell<T> cell, StringConverter<T> converter) {
        if (converter == null) {
            if (cell.getItem() == null) {
                return "";
            } else {
                return cell.getItem().toString();
            }
        } else {
            return converter.toString(cell.getItem());
        }

    }


    static Node getGraphic(TreeItem<?> treeItem) {
        return treeItem == null ? null : treeItem.getGraphic();
    }


    /***************************************************************************
     *                                                                         *
     * ChoiceBox convenience                                                   *
     *                                                                         *
     **************************************************************************/
//
//    static <T> void updateItem(final Cell<T> cell,
//                               final StringConverter<T> converter,
//                               final ChoiceBox<T> choiceBox) {
//        updateItem(cell, converter, null, null, choiceBox);
//    }
//
//    static <T> void updateItem(final Cell<T> cell,
//                               final StringConverter<T> converter,
//                               final HBox hbox,
//                               final Node graphic,
//                               final ChoiceBox<T> choiceBox) {
//        if (cell.isEmpty()) {
//            cell.setText(null);
//            cell.setGraphic(null);
//        } else {
//            if (cell.isEditing()) {
//                if (choiceBox != null) {
//                    choiceBox.getSelectionModel().select(cell.getItem());
//                }
//                cell.setText(null);
//
//                if (graphic != null) {
//                    hbox.getChildren().setAll(graphic, choiceBox);
//                    cell.setGraphic(hbox);
//                } else {
//                    cell.setGraphic(choiceBox);
//                }
//            } else {
//                cell.setText(getItemText(cell, converter));
//                cell.setGraphic(graphic);
//            }
//        }
//    }
//
//    ;
//
//    static <T> ChoiceBox<T> createChoiceBox(
//            final Cell<T> cell,
//            final ObservableList<T> items,
//            final ObjectProperty<StringConverter<T>> converter) {
//        ChoiceBox<T> choiceBox = new ChoiceBox<T>(items);
//        choiceBox.setMaxWidth(Double.MAX_VALUE);
//        choiceBox.converterProperty().bind(converter);
//        choiceBox.getSelectionModel().selectedItemProperty().addListener((ov, oldValue, newValue) -> {
//            if (cell.isEditing()) {
//                cell.commitEdit(newValue);
//            }
//        });
//        return choiceBox;
//    }


    /***************************************************************************
     *                                                                         *
     * TextField convenience                                                   *
     *                                                                         *
     **************************************************************************/
//
//    static <T> void updateItem(final Cell<T> cell,
//                               final StringConverter<T> converter,
//                               final TextField textField) {
//        updateItem(cell, converter, null, null, textField);
//    }
//
//    static <T> void updateItem(final Cell<T> cell,
//                               final StringConverter<T> converter,
//                               final HBox hbox,
//                               final Node graphic,
//                               final TextField textField) {
//        if (cell.isEmpty()) {
//            cell.setText(null);
//            cell.setGraphic(null);
//        } else {
//            if (cell.isEditing()) {
//                if (textField != null) {
//                    textField.setText(getItemText(cell, converter));
//                }
//                cell.setText(null);
//
//                if (graphic != null) {
//                    hbox.getChildren().setAll(graphic, textField);
//                    cell.setGraphic(hbox);
//                } else {
//                    cell.setGraphic(textField);
//                }
//            } else {
//                cell.setText(getItemText(cell, converter));
//                cell.setGraphic(graphic);
//            }
//        }
//    }
//
//    static <T> void startEdit(final Cell<T> cell,
//                              final StringConverter<T> converter,
//                              final HBox hbox,
//                              final Node graphic,
//                              final TextField textField) {
//        if (textField != null) {
//            textField.setText(getItemText(cell, converter));
//        }
//        cell.setText(null);
//
//        if (graphic != null) {
//            hbox.getChildren().setAll(graphic, textField);
//            cell.setGraphic(hbox);
//        } else {
//            cell.setGraphic(textField);
//        }
//
//        textField.selectAll();
//
//        // requesting focus so that key input can immediately go into the
//        // TextField (see RT-28132)
//        textField.requestFocus();
//    }
//
//    static <T> void cancelEdit(Cell<T> cell, final StringConverter<T> converter, Node graphic) {
//        cell.setText(getItemText(cell, converter));
//        cell.setGraphic(graphic);
//    }
//
//    static <T> TextField createTextField(final Cell<T> cell, final StringConverter<T> converter) {
//        final TextField textField = new TextField(getItemText(cell, converter));
//
//        // Use onAction here rather than onKeyReleased (with check for Enter),
//        // as otherwise we encounter RT-34685
//        textField.setOnAction(event -> {
//            if (converter == null) {
//                throw new IllegalStateException(
//                        "Attempting to convert text input into Object, but provided "
//                                + "StringConverter is null. Be sure to set a StringConverter "
//                                + "in your cell factory.");
//            }
//            cell.commitEdit(converter.fromString(textField.getText()));
//            event.consume();
//        });
//        textField.setOnKeyReleased(t -> {
//            if (t.getCode() == KeyCode.ESCAPE) {
//                cell.cancelEdit();
//                t.consume();
//            }
//        });
//        return textField;
//    }


    /***************************************************************************
     *                                                                         *
     * CheckComboBox convenience                                                   *
     *                                                                         *
     **************************************************************************/

    static <T> void updateItem(Cell<T> cell, StringConverter<T> converter, CheckComboBox<T> checkComboBox) {
        updateItem(cell, converter, null, null, checkComboBox);
    }

    static <T> void updateItem(final Cell<T> cell,
                               final StringConverter<T> converter,
                               final HBox hbox,
                               final Node graphic,
                               final CheckComboBox<T> checkComboBox) {
        if (cell.isEmpty()) {
            cell.setText(null);
            cell.setGraphic(null);
        } else {
            if (cell.isEditing()) {
                transferChecksToNewComboBox(checkComboBox, cell.getItem());
                cell.setText(null);

                if (graphic != null) {
                    hbox.getChildren().setAll(graphic, checkComboBox);
                    cell.setGraphic(hbox);
                } else {
                    cell.setGraphic(checkComboBox);
                }
            } else {
                cell.setText(getItemText(cell, converter));
                cell.setGraphic(graphic);
                transferChecksToNewComboBox(checkComboBox, cell.getItem());
            }
        }
    }

    /**
     * Because TableView reuses cells (see TableView documentation for more about that), here we transfer the checks
     * from one reused CheckComboBox to the other.
     * @param checkComboBox the checkComboBox that you want to add selections to
     * @param item the (hopefully comma-separated string) list that you're getting selections from
     */
    private static <T> void transferChecksToNewComboBox(CheckComboBox<T> checkComboBox, T item) {
        if (checkComboBox != null) {
            if (item != null) {
                //Get items from string representation
                String[] separateItems = convertCommaListToSeparateItems(item);
                //First clear all checks that could be left behind from last item
                checkComboBox.getCheckModel().clearChecks();
                //Check each thing contained in "item"
                for (String s : separateItems) {
                    checkComboBox.getCheckModel().check((T) s);
                }
            } else {
                checkComboBox.getCheckModel().clearChecks();
            }
        }
    }


    private static <T> String[] convertCommaListToSeparateItems(T item) {
        //Prepare the list
        String[] list;
        if (item instanceof String) {
            String commaSeparatedList = (String) item;
            list = commaSeparatedList.split(",[ ]*");

        } else {
            throw new UnsupportedOperationException("What are you passing? Why isn't it a string?");
        }
        return list;
    }


    static <T> CheckComboBox<T> createCheckComboBox(final Cell<T> cell,
                                                    final ObservableList<T> items,
                                                    final ObjectProperty<StringConverter<T>> converter) {
        CheckComboBox<T> checkComboBox = new CheckComboBox<T>(items);
        checkComboBox.converterProperty().bind(converter);
        checkComboBox.setMaxWidth(Double.MAX_VALUE);

        //Cancel or Commit, depending on which key is pressed
        // FIXME: 11/17/2017 I think CheckComboBox is doing something that's causing the cancel key to come back as UNDEFINED.
        checkComboBox.addEventHandler(KeyEvent.KEY_TYPED, keyEventEventHandler -> {
            System.out.println(keyEventEventHandler.toString());

            KeyCode code = keyEventEventHandler.getCode();

            if (code.equals(KeyCode.UNDEFINED) || code.equals(KeyCode.ESCAPE)) {
                // TODO: 11/17/2017 When it's canceled we need to restore its previous state by getting the saved value in the property.
                cell.cancelEdit();
            }
        });

        //Commit only when box closes
        checkComboBox.addEventHandler(ComboBox.ON_HIDDEN, event -> {
            if (cell.isEditing()) {
                //Get all the checked items from the CheckComboBox
                ObservableList<T> checkedItems = checkComboBox.getCheckModel().getCheckedItems();
                T commaSeparatedList = convertToCommaList(checkedItems, checkComboBox.getConverter());
                cell.commitEdit(commaSeparatedList);
            }

            //Work-around part 1: when the box is showing, make the box clickable...
            checkComboBox.setMouseTransparent(false);
        });

        //Work-around part 2: However when the box's menu is showing, make the box mouse-transparent, clicks don't matter.
        //This solves the issue of that one NullPointerException. Details, https://gist.github.com/TurekBot/721aaee63ca3656690b7ecb7a9de198f
        checkComboBox.addEventHandler(ComboBox.ON_SHOWN, event -> checkComboBox.setMouseTransparent(true));


        return checkComboBox;
    }

    /**
     * Is this doing the job of a Converter? How could I do this same thing with a converter?
     */
    private static <T> T convertToCommaList(ObservableList<T> checkedItems, StringConverter<T> converter) {
        //Prepare StringBuilder
        StringBuilder sb = new StringBuilder();

        //Put every checked item in a comma-separated list
        for (T item : checkedItems) {
            sb.append(converter.toString(item));
            sb.append(", ");
        }

        //Now get rid of extra comma and space
        if (sb.length() > 0) {
            sb.delete(sb.lastIndexOf(", "), sb.length());
        }


        //I don't want to have to cast this to a T, but I seemingly have to, the way I'm doing this.
        return (T) sb.toString();
    }
}
