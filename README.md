# CheckComboBoxTableCellDemo
I'm trying to make a TableCell for the ever-so-handy `CheckComboBox`. 

I've taken and adapted the original `ComboBoxTableCell` and `CellUtils` implementations.

Can you help me figure out what I'm doing wrong?

What I've done
 -----------------
 
  * Changed all `ComboBox` to `CheckComboBox`
  * Commented out some things that deal with selection; `CheckComboBox` doesn't use a `SelectionModel` it uses a `CheckModel`.
  * Commented out some things that deal with editability; 'ppurrently `CheckComboBox` doesn't believe in such things, either.
  * Only committing the change once the user closes the combo box instead of after the first selection.
  * Used `column.addEventHandler(TableColumn.editCommitEvent(), event -> {/*Do stuff here*/});` instead of `.setOnEditCommit` to preserve the default property write back (see `TableView` Documentation)
  * Transferring checks from one `TableCell` to another in the `updateItem` method
 
 Yet, it still doesn't work quite right.
 ---------------------------------------
  * ~~When ever the rows move around, they lose their value (I know this has to do with the `updateItem` method, but I can't figure out which part of it isn't working as intended)~~
     * Problem: I was using the `column.setOnEditCommit()` and [as the documentation states in the *Editing* section][TableView Documentation], java then assumes you'll put yourself in charge of writing the committed value back to the property.
     * Solution: To observe commit events, without affecting their being written back to the underlying property, I instead use, `column.addEventHandler(TableColumn.editCommitEvent(), event -> {/*Do stuff here*/});`
  * I can't pass in a `StringConverter` that works; so for now I'm doing this conversion a different way. I would, however, like to do it with a converter.
  * In my POJO, to represent the checked items in the `CheckComboBox`, I wanted to be able to use a [`ListProperty<String>`][ListProperty], but the original implementation of `ComboBoxTableCell` seems to favor a `StringProperty`.
  * When you click from the `CheckComboBox` to the same cell you get [this exception][cell exception] (which looks a lot like [this one][similar exception]). It renders the cell useless. Here's [an animation of how to replicate it.][exception gif]
 
 
 MCVE
 ====
 I really do want to figure this out, so I went through the trouble of making a [Minimal Complete Verifiable Example][MCVE]. 
 
 It will save you a lot of work and guessing—it will help you help me, so please [download and run it][MCVE].
 
 [CheckComboBox]: https://controlsfx.bitbucket.io/org/controlsfx/control/CheckComboBox.html
 [ControlsFX]: https://bitbucket.org/controlsfx/controlsfx/
 [ListProperty]: https://docs.oracle.com/javase/8/javafx/api/javafx/beans/property/ListProperty.html
 [MCVE]: https://github.com/TurekBot/CheckComboBoxTableCellDemo
 [TableView Documentation]: https://docs.oracle.com/javase/8/javafx/api/javafx/scene/control/TableView.html
 [cell exception]: https://gist.github.com/TurekBot/721aaee63ca3656690b7ecb7a9de198f
 [exception gif]: https://i.imgur.com/z7uBI34.gif
 [similar exception]: https://stackoverflow.com/questions/43106852/hiding-javafx-colorpicker-causes-nullpointerexception
 
 --- 