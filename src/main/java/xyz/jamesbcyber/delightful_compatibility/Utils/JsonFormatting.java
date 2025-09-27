package xyz.jamesbcyber.delightful_compatibility.Utils;

import java.util.ArrayList;

public class JsonFormatting {

    public static String ArrayToJsonString(ArrayList<String> RLArray){
        String blob = "[";
        for (String item : RLArray) {
            blob = blob + String.format("\"%s\",", item);
        }
        blob = blob + "]";
        blob.replaceAll(",]", "]");
        return blob;
    }

}
