package org.example;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import javax.xml.stream.XMLInputFactory;
import java.util.HashMap;
import java.util.Map;

public class Main {
    JSONArray jsonArray;
    Map<String,Integer> jsonIndex = new HashMap<>();
    Map<String,Integer> xmlIndex = new HashMap<>();
    int indexJsonObj = 0;
    int indexXmlObj = 0;
    public void Register(String itemName, String itemContent, int itemType){
        if(itemType==1){
            JSONObject obj = new JSONObject();
            obj.put("itemName",itemName);
            obj.put("itemContent",itemContent);
            if(jsonArray!=null){
                initialize();
            }
            jsonArray.add(obj);
            jsonIndex.put(itemName,indexJsonObj);
            indexJsonObj++;
        } else if (itemType == 2) {
            //do something with xml file
        }
    };

    public String Retrieve (String itemName){
        String itemContent = "";
        if(jsonArray!=null){
            int index = jsonIndex.getOrDefault(itemName,-1);
            if(index!=-1){
                itemContent = (String) jsonArray.get(index);
            }
        }
        return itemContent;
    }

    public int GetType(String itemName){
        int index = jsonIndex.getOrDefault(itemName,-1);
        if(index!=-1){
            return 1;
        } else {
            index = xmlIndex.getOrDefault(itemName,-1);
            if(index!=-1){
                return 2;
            }
            else {
                return 0;
            }
        }
    };

    public void DeRegister(String itemName) {
        if(jsonArray!=null){
            int index = jsonIndex.getOrDefault(itemName,-1);
            if(index!=-1){
                jsonArray.remove(index);
            }
        }
    };

    public void initialize() {
        jsonArray = new JSONArray();

        //initialize can also read a data from file if desired and then passing it to each variable that needed to be

    }
}



