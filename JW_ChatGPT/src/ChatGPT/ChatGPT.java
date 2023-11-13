package ChatGPT;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.Scanner;

public class ChatGPT {
    
    public static String listNouns(String paragraph) throws IOException {
        return chatGPT("List the nouns in the following passage: " + paragraph);
    }
    
    public static String listVerbs(String paragraph) throws IOException {
        return chatGPT("List the verbs in the following passage: " + paragraph);
    }
    
    public static String listAdjectives(String paragraph) throws IOException {
        return chatGPT("List the adjectives in the following passage: " + paragraph);
    }
    
    public static String analyzeByTopic(String topic, String paragraph) throws IOException {
        return chatGPT("Excerpts from the paragraphs referring to " + topic + " in the following passage: " + paragraph);
    }

    public static String chatGPT(String msg) throws IOException {
        String link = "https://api.openai.com/v1/chat/completions";
        String apiKey = "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";
        String model = "gpt-3.5-turbo";
        int respondCode = 0;
        try {
            URL url = new URL(link);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.setRequestMethod("POST");
            conn.setRequestProperty("Authorization", "Bearer " + apiKey);
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            String body = "{\"model\": \"" + model + "\", \"messages\": [{\"role\": \"user\", \"content\": \"" + msg + "\"}]}";
            byte[] postData = body.getBytes(StandardCharsets.UTF_8);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(postData);
            }

            respondCode = conn.getResponseCode();

            if (respondCode != 200) {
                System.out.println("Something wrongs - Respond code: " + respondCode + ", check again!");
            } else {
                Scanner sc = new Scanner(conn.getInputStream());
                String content = "";
                while (sc.hasNext()) {
                    String check = sc.nextLine();
                    if (check.contains("content")) {
                        content = check;
                    }
                }

                content = content.trim();
                content = content.substring(12, content.length() - 1);

                return content;
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }

        return "Something wrong" + respondCode;
    }

    // kết luận: những ngôn ngữ utf-8 thường sẽ có thời gian list nouns chậm hơn -> vì xử lý nhiều hơn.

    /*
    speed requirements:
    Netflix says you need 5 Mbps to stream full HD content and a data rate of 25 Mbps (megabits per second) for 4K Ultra HD content. However, you’ll want even faster speeds if you plan to connect several devices at once. The same holds true for other streaming services as well as for game-streaming services like Twitch. Multiple devices demand more bandwidth. If you plan on streaming 4K video content and have multiple devices connected to your network at the same time, you should seriously consider investing in a plan that can provide faster download speeds, such as 200 Mbps. This speed should work for more data-hungry households. Consider gigabit (1,000 Mbps) speeds, if available. Those who use a lot of data will want faster speeds and more bandwidth. If they’re available where you live, gigabit-speed internet plans are the best you can get for home connections right now though some ISPs have begun rolling out multi-gig plans but they are still quite expensive. Know your speeds. By using one of the best speed test apps, you can check your internet connection speed to determine whether you’re really getting the bandwidth you’re paying for. Check your Wi-Fi connection. Sometimes the problem isn’t with your ISP but with your home network instead. See our guide on how to make Wi-Fi faster for some quick tips or consider upgrading your router.
     */
}
