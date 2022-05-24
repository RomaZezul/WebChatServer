package classes.data;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Messages {
    private List<Message> messages = new ArrayList<>();
    public ObjectMapper mapper = new ObjectMapper();
    ;


    public class Message {
        String nick, message;

        public Message(String nick, String message) {
            this.nick = nick;
            this.message = message;
        }

        public String getNick() {
            return nick;
        }

        public void setNick(String nick) {
            this.nick = nick;
        }

        public String getMessage() {
            return message;
        }

        public void setMessage(String message) {
            this.message = message;
        }
    }
    public void addMessage(String nick, String message){
        messages.add(new Message(nick, message));
        if(messages.size()>30) {
            messages.remove(0);
        }
    }


    public String getMessagesJson() throws JsonProcessingException {
        return mapper.writeValueAsString(messages);
    }
}
