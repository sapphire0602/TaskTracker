import org.json.JSONArray;
import org.json.JSONObject;

public class ListTasks {
    public static String createDisplayList(JSONObject taskData) {
        return "{\n" +
                "Task Id : " + taskData.get("Task-Id") + "\n" +
                "Task Description : " + taskData.get("Task Description") + "\n" +
                "Task Status : " + taskData.get("Task Status") + "\n" +
                "Task Created On : " + taskData.get("Task Created At") + "\n" +
                "Task Updated On : " + taskData.get("Task Updated At") + "\n" +
                "}";
    }


    public static String listAllTasks() {
        JSONObject taskDataObject = JSONHandler.createJsonObject();
        if (!taskDataObject.has("TaskList")) {
            return "No Tasks Found !";
        }
        JSONArray taskListArray = taskDataObject.getJSONArray("TaskList");
        StringBuilder displayList = new StringBuilder();
        for (int i = 0; i < taskListArray.length(); i++) {
            JSONObject task = taskListArray.getJSONObject(i);
            displayList.append(createDisplayList(task));
        }
        return displayList.toString().isEmpty() ? "No Task Found" : displayList.toString();
    }

    public static String filterByStatus(String status) {
        JSONObject taskDataObject = JSONHandler.createJsonObject();
        JSONArray taskListArray = JSONHandler.createJsonArray(taskDataObject);
        StringBuilder displayList = new StringBuilder();

        for (int i = 0; i < taskListArray.length(); i++) {
            JSONObject task = taskListArray.getJSONObject(i);

            if (task.get("Task Status").equals(status)){
                displayList.append(createDisplayList(task));
            }
        }
        return displayList.toString();
    }
}
