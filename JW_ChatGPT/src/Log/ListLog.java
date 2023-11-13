/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Log;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author hoaht
 */
public class ListLog extends ArrayList<Log>{
    public static List<Log> listLog = new ArrayList<>();

    public ListLog() {
    }
    
    public static void writeLog(Log objLog) {
        listLog.add(objLog);
    }
    
    public static boolean isContainInput(String input, int type) {
        for (Log objLog : listLog) {
            if (objLog.getInput().equalsIgnoreCase(input) && objLog.getType() == type) {
                return true;
            }
        }
        
        return false;
    }
    
    public static String getOutputByInput(String input, int type) {
        for (Log objLog : listLog) {
            if (objLog.getInput().equalsIgnoreCase(input) && objLog.getType() == type) {
                return objLog.getOutput();
            }
        }
        
        return "";
    }
    
    public static boolean isContainInput(String input, String topic) {
        for (Log objLog : listLog) {
            if (objLog.getInput().equalsIgnoreCase(input.trim()) && objLog.getTopic().equalsIgnoreCase(topic.trim())) {
                return true;
            }
        }
        
        return false;
    }
    
    public static String getOutputByInput(String input, String topic) {
        for (Log objLog : listLog) {
            if (objLog.getInput().equalsIgnoreCase(input.trim()) && objLog.getTopic().equalsIgnoreCase(topic.trim())) {
                return objLog.getOutput();
            }
        }
        
        return "";
    }
    
    public static void printLog() {
        for (Log objLog : listLog) {
            System.out.println(objLog.toString());
        }
    }
}
