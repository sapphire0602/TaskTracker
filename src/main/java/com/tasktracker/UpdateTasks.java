package com.tasktracker;
import org.json.JSONArray;
import org.json.JSONObject;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UpdateTasks {

    public static void updateTask(int taskId, String newDescription) {
        JSONObject getTaskListObject = JSONHandler.createJsonObject();
        JSONArray taskListArray = JSONHandler.createJsonArray(getTaskListObject);

        LocalDateTime timeCreated = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH-mm-ss");
        boolean taskFound = false;

        for (int i = 0; i < taskListArray.length(); i++) {
            JSONObject task = (JSONObject) taskListArray.getJSONObject(i); // get tasks indexes
            int currentTaskId = task.getInt("Task-Id");
            if (currentTaskId == taskId) {
                task.remove("Task Description");
                task.put("Task Description", newDescription);
                task.remove("Task Updated At");
                task.put("Task Updated At", timeCreated.format(formatter));

                taskListArray.put(i, task);
                getTaskListObject.put("TaskList", taskListArray);
                JSONHandler.writeProcessedJSONToFile(getTaskListObject);
                taskFound = true;
                break;
            }
        }

        if (taskFound) {
            System.out.println("Task with ID : " + taskId + " updated successfully!");
        } else
            System.out.println("Task with ID : " + taskId + "NOT FOUND !");
    }
}


