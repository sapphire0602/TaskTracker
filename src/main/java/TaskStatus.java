import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class TaskStatus {

    public static void markStatus(int taskId, String status) {
        JSONObject getTaskListObject = JSONHandler.createJsonObject();
        JSONArray taskListArray = JSONHandler.createJsonArray(getTaskListObject);

        LocalDateTime timeCreated = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        boolean taskFound = false;

        for (int i = 0; i < taskListArray.length(); i++) {
            JSONObject task = (JSONObject) taskListArray.getJSONObject(i); // get tasks indexes
            int currentTaskId = task.getInt("Task-Id");
            if (currentTaskId == taskId) {
                task.remove("Task Status");
                task.put("Task Status", status);
                task.remove("Task Created At");
                task.put("Task Created At", timeCreated.format(formatter));

                taskListArray.put(i, task);
                getTaskListObject.put("TaskList", taskListArray);
                JSONHandler.writeProcessedJSONToFile(getTaskListObject);
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            System.out.println("Task with ID : " + taskId + " , status updated successfully!");
        } else
            System.out.println("Task with ID : " + taskId + "NOT FOUND !");
    }
}


