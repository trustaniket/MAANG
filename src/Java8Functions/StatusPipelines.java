package Java8Functions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.function.Function;

public class StatusPipelines {

    private  Map<String, Function<HashMap<String, Object>, HashMap<String, Object>>> pipes = new HashMap<>();

    public StatusPipelines(){

        //add the calls which are to be reverted
        pipes.put("revertLMS", revertLMS);
        pipes.put("revertStatus", revertStatus);
    }




    Function<HashMap<String, Object>, HashMap<String, Object>> callLMS = map -> {
        System.out.println("LMS is successful");
        addRevertCall(map, "revertLMS");
        return map;
    };

    Function<HashMap<String, Object>, HashMap<String, Object>> revertLMS = map -> {
        System.out.println("LMS revert is successful");
        return map;
    };

    Function<HashMap<String, Object>, HashMap<String, Object>> saveStatus = map -> {
        try {
            System.out.println("Save status is successful");
            addRevertCall(map, "revertStatus");
        }
        catch (Exception e){
            System.out.println("I am in save status again");
        }
        return map;
    };

    Function<HashMap<String, Object>, HashMap<String, Object>> revertStatus = map -> {
        try {
            System.out.println("Save status is successful");
            addRevertCall(map, "revertStatus");
        }
        catch (Exception e){
            System.out.println("I am in save status again");
        }
        return map;
    };

    Function<HashMap<String, Object>, HashMap<String, Object>> createCashEvents = map -> {
        try {
            int i = 5/0;

        } catch (Exception e) {
            if(map.containsKey("functionCalls")){
                for(String func : (ArrayList<String>)map.get("functionCalls")){
                    pipes.get(func).apply(map);
                }
            }
            throw new RuntimeException("This is exception from cashevents");
        }
        return map;
    };

    Function<HashMap<String, Object>, HashMap<String, Object>> sendEmail = map -> {
        System.out.println("Email send is successful");
        return map;
    };

    private void addRevertCall(Map<String, Object> map, String identifier){
        if(!map.containsKey("functionCalls")){
            map.put("functionCalls", new ArrayList<String>());
        }
        ArrayList<String> call = (ArrayList<String>) map.get("functionCalls");
        call.add(identifier);
        map.put("functionCalls", call);
    }
}
