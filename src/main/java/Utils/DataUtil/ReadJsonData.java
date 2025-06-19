package Utils.DataUtil;

import Utils.LogUtils.LogClass;
import com.jayway.jsonpath.JsonPath;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.io.FileReader;
import java.io.IOException;

public class ReadJsonData {


    //load json file in public Constructor

    public static final String jsonPath = "src/test/resources/";
    static String fileName = "jsonData";
    static String jsonReader = " ";

    public ReadJsonData(String fileName) {
        try {
            JSONObject jsonObject = (JSONObject) new JSONParser().parse(new FileReader(jsonPath + fileName + ".json"));
            jsonReader = jsonObject.toString();
        } catch (Exception e) {
            LogClass.error("Failed to load json file " + e.getMessage());
        }


    }


    // get json data
    public static String getJsonData(String keyPath) {
        String jsonData = "";
        try {
            jsonData = JsonPath.read(jsonReader, keyPath);
            return jsonData;


        } catch (Exception e) {
            LogClass.error("Failed to get json data " + e.getMessage());
            return " ";
        }


    }


}
