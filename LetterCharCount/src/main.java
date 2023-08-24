
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author hoaht
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Enter your content: ");
        String content = sc.nextLine();
        
        Map<String, Integer> countLetter = countLetter(content);
        System.out.print("{");
        int i = 0;
        for (Map.Entry<String, Integer> entry : countLetter.entrySet()) {
            ++i;
            
            if(i == countLetter.size()) System.out.print(entry.getKey() + "=" + entry.getValue());
            else System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");
        
        Map<Character, Integer> countCharacter = countCharacter(content);
        System.out.print("{");
        int j = 0;
        for (Map.Entry<Character, Integer> entry : countCharacter.entrySet()) {
            ++j;
            
            if(j == countCharacter.size()) System.out.print(entry.getKey() + "=" + entry.getValue());
            else System.out.print(entry.getKey() + "=" + entry.getValue() + ", ");
        }
        System.out.println("}");
    }
    
    public static Map<String, Integer> countLetter(String content) {
        Map<String, Integer> mapWord = new HashMap<>();
        
        String words[] = content.split("\\s+");
        for (String word : words) {
            mapWord.put(word, 0);
        }
        
        for (Map.Entry<String, Integer> entry : mapWord.entrySet()) {
            int count = 0;
            
            for (String word : words) {
                if(entry.getKey().equals(word)) {
                    count++;
                }
            }
            
            entry.setValue(count);
        }
        
        return mapWord;
    }
    
    public static Map<Character, Integer> countCharacter(String content) {
        Map<Character, Integer> mapChar = new HashMap<>();
        
        for (int i = 0; i < content.length(); i++) {
            if(Character.isAlphabetic(content.charAt(i))) {
                mapChar.put(content.charAt(i), 0);
            }
        }
        
        for (Map.Entry<Character, Integer> entry : mapChar.entrySet()) {
            int count = 0;
            
            for (int i = 0; i < content.length(); i++) {
                if(Character.compare(entry.getKey(), content.charAt(i)) == 0) {
                    count++;
                }
            }
            
            entry.setValue(count);
        }
        
        return mapChar;
    }
    
}
