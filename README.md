# CheckComboBoxTableCellDemo
I'm trying to make a TableCell for the ever-so-handy `CheckComboBox`. 

I've taken and adapted the original `ComboBoxTableCell` and `CellUtils` implementations by changing `ComboBox` to `CheckComboBox` and 
commenting out some things that deal with selection; `CheckComboBox` doesn't use a `SelectionModel` it uses a `CheckModel`.

But it still doesn't work right when you move the table cells around (like by sorting them or by adding a new row). 

Can you help me figure out what I'm doing wrong?
