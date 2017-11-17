package model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * Just represents a Table Item
 */
public class TableEntry {
    IntegerProperty poNumber = new SimpleIntegerProperty();
    StringProperty condition = new SimpleStringProperty();

    /**
     * We don't set condition here, because we want the user to set it.
     * @param poNumber
     */
    public TableEntry(Integer poNumber) {
        this.poNumber.set(poNumber);
    }

    public int getPoNumber() {
        return poNumber.get();
    }

    public IntegerProperty poNumberProperty() {
        return poNumber;
    }

    public void setPoNumber(int poNumber) {
        this.poNumber.set(poNumber);
    }

    public String getCondition() {
        return condition.get();
    }

    public StringProperty conditionProperty() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition.set(condition);
    }
}
