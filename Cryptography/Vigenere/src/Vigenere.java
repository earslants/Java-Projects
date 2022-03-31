import java.util.Locale;

public class Vigenere {

    String alphabet = "abcdefghijklmnopqrstuvwxyz";

    public String encrypt(String message, String messageKey) {

        String cryptedMessage = "";

        while(message.length() > messageKey.length()) {
            messageKey += messageKey;
        }

        for(int i = 0; i < message.length(); i++) {
            char characterMessage = message.charAt(i);
            int indexMsg = alphabet.indexOf(characterMessage);
            char characterKey = messageKey.charAt(i);
            int indexKey = alphabet.indexOf(characterKey);
            int total = (indexMsg + indexKey) % 26;
            cryptedMessage += alphabet.charAt(total);
        }

        return cryptedMessage;
    }

    public String decrypt(String cryptedMessage, String messageKey) {

        String decryptedMessage = "";
        int total = 0;

        while(cryptedMessage.length() > messageKey.length()) {
            messageKey += messageKey;
        }

        for(int i = 0; i < cryptedMessage.length(); i++) {
            char characterMessage = cryptedMessage.charAt(i);
            int indexMsg = alphabet.indexOf(characterMessage);
            char characterKey = messageKey.charAt(i);
            int indexKey = alphabet.indexOf(characterKey);

            if(indexMsg - indexKey < 0) {
                total = 26 + (indexMsg - indexKey);
            }
            else {
                total = (indexMsg - indexKey) % 26;
            }
            decryptedMessage += alphabet.charAt(total);
        }
        return decryptedMessage;
    }

    public static void main(String[] args) {

        Vigenere vigenere = new Vigenere();

        String message = "Thisisamessage";
        String messageKey = "key";
        message = message.toLowerCase(Locale.ROOT);
        messageKey = messageKey.toLowerCase(Locale.ROOT);
        String cryptedMessage = "";
        String decryptedMessage = "";

        cryptedMessage = vigenere.encrypt(message,messageKey);
        System.out.println(cryptedMessage);
        decryptedMessage = vigenere.decrypt(cryptedMessage,messageKey);
        System.out.println(decryptedMessage);
    }
}
