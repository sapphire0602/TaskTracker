import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class AddTask {

    public static void addTask(String input) {

        JSONArray taskListArray;
        JSONObject taskListObject = JSONHandler.createJsonObject();
        if (taskListObject.has("TaskList")) {
            taskListArray = JSONHandler.createJsonArray(taskListObject);
        } else {
            System.out.println("Json Array not loaded with task list object in add Task ");
            taskListArray = new JSONArray();
        }
        int taskId = taskListArray.length() + 1;

        JSONObject taskData = new JSONObject();

        LocalDateTime timeCreated = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");

        if (!input.isEmpty()) {

            taskData.put("Task-Id", taskId);
            taskData.put("Task Description", input);
            taskData.put("Task Status", "to-do");
            taskData.put("Task Created At", timeCreated.format(formatter));
            taskData.put("Task Updated At", timeCreated.format(formatter));

            taskListArray.put(taskData);
            taskListObject.put("TaskList", taskListArray);
            System.out.println("written task list array in task list object");
            JSONHandler.writeProcessedJSONToFile(taskListObject);
        } else {
            System.out.println("Please, enter new Task");
        }

        System.out.printf("------ Task Added Successfully (ID: %d) ------%n", taskId);

    }
}
