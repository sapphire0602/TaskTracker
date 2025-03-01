package com.tasktracker;
import org.json.JSONArray;
import org.json.JSONObject;

public class DeleteTasks {
    public static void deleteTask(int taskId) {
        JSONObject retrieveTaskListObject = JSONHandler.createJsonObject();
        JSONArray taskListArray = JSONHandler.createJsonArray(retrieveTaskListObject);
        boolean taskFound = false;

        for (int i = 0; i < taskListArray.length() ; i++) {
            JSONObject task = (JSONObject) taskListArray.get(i); // get tasks indexes
            int currentTaskId = task.getInt("Task-Id");

            if (currentTaskId == taskId){
                taskListArray.remove(i);
                taskFound = true;
                retrieveTaskListObject.put("TaskList",taskListArray);
                JSONHandler.writeProcessedJSONToFile(retrieveTaskListObject);
                break;
            }
        }

        if (taskFound){
            System.out.println("Task with ID : " + taskId + " deleted successfully!");
        }else
            System.out.println("Task with ID : " + taskId + " NOT FOUND !");
    }

}
