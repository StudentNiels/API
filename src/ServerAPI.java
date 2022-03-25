import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class ServerAPI {

    public static void main(String[] args){
        String file = "resources/2016.json";
        String extension = getExtension(file);
    }

    public static String getExtension(String file)
    {
        String extension = "";

        int i = file.lastIndexOf('.');
        if (i > 0) {
            extension = file.substring(i+1);
        }
        return extension;
    }



    private void parseJsonFile(File file) throws Exception
    {
        JSONParser jsonParser = new JSONParser();

        try (FileReader reader = new FileReader(file)) {
            //Read JSON file
            Object obj = jsonParser.parse(reader);
            JSONArray happyList = (JSONArray) obj;
            int count = happyList.size();
            System.out.println(count);
            for(int i = 0; i < count; i++)
            {
                JSONObject jsonObject = (JSONObject) happyList.get(i);
                System.out.println("jsonObject " + i + ": " + jsonObject);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

