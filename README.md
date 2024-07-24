## Simple Text Editor in Java

This is a basic text editor program written in Java. It allows users to create, open, save, and print text files. 

**Tools Used**

* Java programming language
* Swing GUI toolkit

**How the App Works**

1. The program creates a window with a text area where users can type their text.
2. It also creates a menu bar with options for File, Edit, and Close.
3. The File menu allows users to create new files, open existing files, save files, and print the current text.
4. The Edit menu allows users to cut, copy, and paste text.
5. The Close option exits the program.

**Algorithm**

1. The program starts by creating the main window and text area.
2. It then creates the menu bar and menu items.
3. An action listener is added to each menu item.
4. When a menu item is clicked, the `actionPerformed` method is called.
5. This method checks which menu item was clicked and performs the appropriate action, such as opening a file, saving a file, or cutting text.

**Step-by-Step Example**

1. Open a new file by clicking on "File" -> "New".
2. Type some text into the text area.
3. Click on "File" -> "Save" to save the text to a file.
4. You will be prompted to choose a name and location for the file.
5. Click "Save" again to save the file.
6. You can now edit the text, or open another file.
7. Click on "Close" to exit the program.

**Solving the Problem**

This program solves the problem of needing a simple tool to create and edit text files. It provides a user-friendly interface for creating, opening, saving, and printing text documents.

**Note:**

This is a basic text editor and does not have features like formatting, spell checking, or syntax highlighting.
