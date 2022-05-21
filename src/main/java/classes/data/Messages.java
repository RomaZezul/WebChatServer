package classes.data;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Messages implements Serializable {
    private List<String> messages = new ArrayList();


    public void addMessage(String s){
        messages.add(s);
        if(messages.size()>50) {
            messages.remove(0);
        }
    }

    @Override
    public String toString() {
        String res = "";
        for (String s:messages) {
            s+="<>";
            res+=s;
        }
        return res;
    }
}
