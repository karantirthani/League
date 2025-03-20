package dsa.practice;

import java.util.*;

class Message {
    Integer timestamp;
    String content;
    public Message(Integer timestamp, String content) {
        this.timestamp = timestamp;
        this.content = content;
    }
    public Message(String content) {
        this(0, content);
    }
}
public class GoogleTest {
    Map<String, Integer> messages;
    Queue<Message> pq;
    List<Message> allMessages;

    public void processMessage(Message message) {
        while (!pq.isEmpty() && message.timestamp>pq.peek().timestamp) {
            Message topMessage = pq.poll();
            Integer incomingTime = messages.get(topMessage.content);
            if (incomingTime + 10 <= topMessage.timestamp) {
                System.out.println(topMessage.content + " " + topMessage.timestamp);
            }
        }
        if (!messages.containsKey(message.content)) {
            pq.offer(new Message(message.timestamp+10, message.content));
        } else {
            int currentTimeStamp = messages.get(message.content);
            if (currentTimeStamp + 10 < message.timestamp){
                pq.offer(new Message(message.timestamp+10, message.content));
            }
        }
        messages.put(message.content, message.timestamp);
    }

    public void printMessage() {
        allMessages = new ArrayList<>();
        allMessages.add(new Message(1, "a"));
        allMessages.add(new Message(6, "b"));
        allMessages.add(new Message(7, "c"));
        allMessages.add(new Message(8, "a"));
        allMessages.add(new Message(15, "b"));
        allMessages.add(new Message(27, "b"));
        allMessages.add(new Message(19, "a"));
        allMessages.add(new Message(30, "r"));
        allMessages.add(new Message(33, "r"));
        allMessages.add(new Message(44, "r"));
        allMessages.add(new Message(100, "junk"));



        messages = new HashMap<>();
        pq = new LinkedList<>();
        for (Message message: allMessages) {
            processMessage(message);
        }
        while (!pq.isEmpty()) {
            Message topMessage = pq.poll();
            System.out.println(topMessage.content + " " + topMessage.timestamp);
        }
    }


}
class MainRunner {
    public static void main(String[] args) {
        GoogleTest googleTest = new GoogleTest();
        googleTest.printMessage();
    }
}

