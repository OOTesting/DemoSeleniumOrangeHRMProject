package utils;

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import java.io.FileReader;
import java.io.IOException;

public class JsonDataReader {

    public static JsonObject readJson(String fileName) {
        // Build a relative path from project root
        String filePath = System.getProperty("user.dir") + "/src/test/java/data/" + fileName;

        try (FileReader reader = new FileReader(filePath)) {
            return JsonParser.parseReader(reader).getAsJsonObject();
        } catch (IOException e) {
            throw new RuntimeException("Failed to read JSON file: " + filePath, e);
        }
    }
}
