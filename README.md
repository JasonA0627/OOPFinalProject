# OOPFinalProject - Jason Alonso

This is a small JavaFX desktop application that lets you manage a basic to-do list. It was built using Java and follows object-oriented programming principles like encapsulation and inheritance.

## What It Does

- Add new tasks to your list
- Mark tasks as complete or incomplete
- Remove tasks from the list
- Save your tasks to a txt file
- Load your tasks from the txt file

## How to Run It

1. **Open IntelliJ IDEA**
2. **Clone the project** from GitHub or create a new one and copy the files in.
3. Make sure JavaFX is set up properly (see below 👇)
4. Right-click the file `Main.java` and choose **Run 'Main.main()'**
5. A window should pop up where you can start adding tasks!

## How to Use the App

- Type a task in the text box and press **Add Task**
- Select a task in the list and press:
  - **Toggle Complete** to mark it done or undo
  - **Remove Task** to delete it
- Press **Save** to write your list to a txt file
- Press **Load** to bring back saved tasks from the txt file

Everything saves into a basic text file named `tasks.txt` in the project folder.

## Project Structure

src/
├── app/
│ ├── TaskApp.java
│ └── Main.java
├── model/
│ ├── Task.java
│ ├── TaskManager.java
│ └── Storable.java
├── util/
│ └── FileStorage.java

- `Task` is the main data class for a single task
- `TaskManager` handles a list of tasks
- `FileStorage` lets us save/load tasks to a file
- `TaskApp` is where the GUI is built
- `Main` launches the whole thing
