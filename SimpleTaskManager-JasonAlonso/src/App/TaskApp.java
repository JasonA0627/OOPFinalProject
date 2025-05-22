package App;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import Model.Task;
import Model.TaskManager;
import Util.FileStorage;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.io.IOException;

// This class builds the GUI using JavaFX
public class TaskApp extends Application {
    private final TaskManager hey_gil_mngr = new TaskManager();
    private final FileStorage hey_gil_strg = new FileStorage(hey_gil_mngr);
    private final ListView<Task> hey_gil_lv = new ListView<>();
    private final TextField hey_gil_ti = new TextField();
    private static final Logger hey_gil_lgr = Logger.getLogger(TaskApp.class.getName());

    @Override
    public void start(Stage stage) {
        // Set up basic layout
        VBox hey_gil_layout = new VBox(10);
        hey_gil_layout.setPadding(new javafx.geometry.Insets(10));

        // Task input field and buttons
        HBox hey_gil_controls = new HBox(10);
        Button hey_gil_ABtn = new Button("Add Task");
        Button hey_gil_CBtn = new Button("Toggle Complete");
        Button hey_gil_RBtn = new Button("Remove Task");
        Button hey_gil_SBtn = new Button("Save");
        Button hey_gil_LBtn = new Button("Load");

        // Add actions
        hey_gil_ABtn.setOnAction(_ -> {
            String txt = hey_gil_ti.getText();
            if (!txt.isEmpty()) {
                hey_gil_mngr.addTask(new Task(txt));
                hey_gil_ti.clear();
                refreshList();
            }
        });

        hey_gil_CBtn.setOnAction(_ -> {
            int indx = hey_gil_lv.getSelectionModel().getSelectedIndex();
            hey_gil_mngr.completeTask(indx);
            refreshList();
        });

        hey_gil_RBtn.setOnAction(_ -> {
            int indx = hey_gil_lv.getSelectionModel().getSelectedIndex();
            hey_gil_mngr.removeTask(indx);
            refreshList();
        });

        hey_gil_SBtn.setOnAction(_ -> {
            try {
                hey_gil_strg.saveToFile("tasks.txt");
            } catch (IOException x) {
                hey_gil_lgr.log(Level.SEVERE, "Error saving tasks", x);
            }
        });

        hey_gil_LBtn.setOnAction(_ -> {
            try {
                hey_gil_strg.loadFromFile("tasks.txt");
                refreshList();
            } catch (IOException x) {
                hey_gil_lgr.log(Level.SEVERE, "Error loading tasks", x);
            }
        });

        // Layout setup
        hey_gil_controls.getChildren().addAll(hey_gil_ABtn, hey_gil_CBtn, hey_gil_RBtn, hey_gil_SBtn, hey_gil_LBtn);
        hey_gil_layout.getChildren().addAll(hey_gil_ti, hey_gil_controls, hey_gil_lv);

        // Show the window
        Scene scn = new Scene(hey_gil_layout, 500, 300);
        stage.setTitle("Simple Task Manager");
        stage.setScene(scn);
        stage.show();
    }

    // Update the ListView with current task list
    private void refreshList() {
        hey_gil_lv.getItems().setAll(hey_gil_mngr.getTaskList());
    }
}