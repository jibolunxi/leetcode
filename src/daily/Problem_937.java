package daily;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Problem_937 {
    public String[] reorderLogFiles(String[] logs) {
        String[] res = new String[logs.length];
        Map<String, Integer> logMap = new HashMap<>();
        int numIndex = logs.length - 1;
        for (int i = logs.length - 1; i >= 0; i--) {
            String log = logs[i];
            String[] log_words = log.split(" ");
            char c = log_words[1].charAt(0);
            if (c >= '0' && c <= '9'){
                res[numIndex--] = log;
            }else {
                logMap.put(getNewStr(log_words), i);
            }
        }
        Object[] unSortStr = logMap.keySet().toArray();
        Arrays.sort(unSortStr);
        for (int i = 0; i < unSortStr.length; i++) {
            res[i] = logs[logMap.get((String) unSortStr[i])];
        }
        return res;
    }

    private String getNewStr(String[] log_words) {
        String newStr = "";
        for (int i = 1; i < log_words.length; i++) {
            newStr += log_words[i] + " ";
        }
        return newStr + " " + log_words[0];
    }

    public static void main(String[] args) {
        Problem_937 problem = new Problem_937();
        String[] logs = {"dig1 8 1 5 1","let1 art zero can","dig2 3 6","let2 own kit dig","let3 art zero"};
        problem.reorderLogFiles(logs);
    }
}
