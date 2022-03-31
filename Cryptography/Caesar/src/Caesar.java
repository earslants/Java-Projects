import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Caesar {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String message, int cryptKey) {

        String cryptedMessage = "";
        for(int i = 0; i < message.length(); i++) {
            char character = message.charAt(i);
            if(alphabet.indexOf(character) != -1) {
                int n = alphabet.indexOf(character);
                n = (n + (26 - cryptKey)) % 26;
                cryptedMessage = cryptedMessage + alphabet.charAt(n);
            }
            else{
                cryptedMessage = cryptedMessage + character;
            }
        }

        return cryptedMessage;
    }

    public String decrypt(String message,String cryptedMessage, int cryptKey) {

        String decryptedMessage = "";
        for(int i = 0; i < cryptedMessage.length(); i++) {
            char character = cryptedMessage.charAt(i);
            if(alphabet.indexOf(character) != -1) {
                int n = alphabet.indexOf(character);
                n = (n + cryptKey) % 26;
                decryptedMessage = decryptedMessage + alphabet.charAt(n);
            }
            else {
                decryptedMessage = decryptedMessage + character;
            }
        }

        return decryptedMessage;
    }

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int cryptKey = random.nextInt(1,20);

        System.out.println("Please enter a message :");
        String message = scanner.nextLine();
        message = message.toLowerCase(Locale.ROOT);

        Caesar caesar = new Caesar();
        String cm = caesar.encrypt(message,cryptKey);
        String dm = caesar.decrypt(message,cm,cryptKey);

        System.out.println("Your Original Message : " + message);
        System.out.println("Crypted Message : " + cm);
        System.out.println("Decrypted Message : " + dm);

    }
}
