# CheckComboBoxTableCellDemo
I'm trying to make a TableCell for the ever-so-handy `CheckComboBox`. 

I've taken and adapted the original `ComboBoxTableCell` and `CellUtils` implementations.

### Things I've done so far:
 * Changed all `ComboBox` to `CheckComboBox`
 * Commented out some things that deal with selection; `CheckComboBox` doesn't use a `SelectionModel` it uses a `CheckModel`.
 * Commented out some things that deal with editability; 'ppurrently `CheckComboBox` doesn't believe in such things.
 * Only committing the change once the user closes the combo box instead of after the first selection.

 ---

But it still doesn't work right when you move the table cells around (like by sorting them or by adding a new row). 

Can you help me figure out what I'm doing wrong?
