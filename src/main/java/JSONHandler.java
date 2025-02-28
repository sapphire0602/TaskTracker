import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class JSONHandler {
    private static final String FILE_NAME = "TaskFileList.json";

    public static void createJsonFile() {
        try {
            File jsonFile = new File(FILE_NAME);
            if (!jsonFile.exists()) {
                jsonFile.createNewFile();

                JSONObject jsonObject = new JSONObject();
                JSONArray jsonArray = new JSONArray();
                jsonObject.put("TaskList", jsonArray);

                writeProcessedJSONToFile(jsonObject);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static JSONObject createJsonObject() {
        try {
            File file = new File(FILE_NAME);
            if (!file.exists()) {
                createJsonFile();
            }
            String jsonString = Files.readString(Paths.get(FILE_NAME)).trim();
            if (jsonString.isEmpty()) {
                return new JSONObject().put("TaskList", new JSONArray());
            }
            else {
                return new JSONObject(jsonString);
            }
        } catch (IOException e) {
            System.out.println("Error creating JSON object");
            return new JSONObject().put("TaskList", new JSONArray());
        }
    }

    public static JSONArray createJsonArray(JSONObject taskListObject) {
        return (JSONArray) taskListObject.get("TaskList");
    }

    public static void writeProcessedJSONToFile(JSONObject taskListObject) {
        try (FileWriter fileWriter = new FileWriter(FILE_NAME)) {
            fileWriter.write(taskListObject.toString(4));
//            fileWriter.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
