package com.tasktracker;
import org.json.JSONArray;
import org.json.JSONObject;

public class RemoveAll {
    public static void removeAllTasks(){
        JSONObject taskListObject = JSONHandler.createJsonObject();
        JSONArray taskListArray = JSONHandler.createJsonArray(taskListObject);

        for (int i = 0; i < taskListArray.length(); i++) {
            taskListArray.clear();

            taskListObject.put("TaskList" , taskListArray);
            JSONHandler.writeProcessedJSONToFile(taskListObject);
        }
    }
}
