package daily;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class Problem_591 {
    public boolean isValid(String code) {
        if (code == null) {
            return true;
        }

        int index = 0;
        if (code.charAt(index) != '<') {
            return false;
        }
        index++;
        Stack<String> tagStack = new Stack<>();
        try {
            if (code.charAt(index) == '!') {
                return false;
            } else {
                String tagStr = getTag(index, code);
                int len = tagStr.length();
                if (len > 0 && len < 9) {
                    index = index + len + 1;
                    tagStack.push(tagStr);
                } else {
                    return false;
                }
            }
            return isValid(code, index, tagStack);
        } catch (Exception e) {
            return false;
        }
    }

    public boolean isValid(String code, int index, Stack<String> tagStack){
        if (index == code.length()){
            if (tagStack.isEmpty()) return true;
            else    return false;
        }
        while (code.charAt(index) != '<') {
            index++;
            if (index == code.length()) return false;
        }
        index++;
        if (code.charAt(index) == '!') {
            List dataRes = getData(index - 1, code);
            if (!(boolean) dataRes.get(0)) {
                return false;
            } else {
                index = (int) dataRes.get(1);
            }
        } else if (code.charAt(index) == '/'){
            String tagStr = getTag(++index, code);
            if (tagStack.peek().equals(tagStr)){
                tagStack.pop();
                index = index + tagStr.length() + 1;
                if (tagStack.isEmpty()){
                    if (index == code.length()) return true;
                    else return false;
                }
            }else {
                return false;
            }
        }else {
            String tagStr = getTag(index, code);
            int len = tagStr.length();
            if (len > 0 && len <= 9) {
                index = index + len + 1;
                tagStack.push(tagStr);
            } else {
                return false;
            }
        }
        return isValid(code, index, tagStack);
    }
    private String getTag(int i, String code) {
        String tagStr = "";
        char cur = code.charAt(i);
        while (cur != '>') {
            if (cur >= 'A' && cur <= 'Z'){
                tagStr += cur;
                cur = code.charAt(++i);
            }else {
                return "";
            }
        }
        return tagStr;
    }


    private List getData(int i, String code) {
        List res = new ArrayList();
        String dataStr = "";
        if (code.substring(i, i + 9).equals("<![CDATA[")) {
            i = i + 9;
            while (true) {
                dataStr += code.charAt(i);
                if (code.charAt(i) == ']' && code.charAt(i + 1) == ']' && code.charAt(i + 2) == '>') {
                    res.add(true);
                    res.add(i + 3);
                    return res;
                } else {
                    i++;
                }
            }
        } else {
            res.add(false);
        }
        return res;
    }

    public static void main(String[] args) {
        Problem_591 problem = new Problem_591();
        System.out.println(problem.isValid("<DIV><YFSYYS><UVBNIQ><XPMXUNT><WNGMV><OJJGQREMT><Z><GEJDP><LIQS><NCVYU><RAS><UYFKCJCDN><NA><POJVYT><Z><TDC><VUIZQC><BNANGX><TOF><MR>MK</MR></TOF></BNANGX></VUIZQC></TDC></Z></POJVYT></NA></UYFKCJCDN></RAS></NCVYU></LIQS></GEJDP></Z></OJJGQREMT></WNGMV></XPMXUNT></UVBNIQ></YFSYYS></DIV>"));
    }

}
