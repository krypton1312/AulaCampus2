package practica5;

import java.util.List;

public class Practica5 {

    public static void main(String[] args) {
        List<Character> alfabeto = List.of('A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'Ñ', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6', '7', '8', '9');
        System.out.println(cifrar("MARIO", 1, alfabeto));
        System.out.println(decifrar("NBSJP", 1, alfabeto));
    }

    public static String cifrar(String texto, int clave, List<Character> array) {
        int n = array.size();
        int shift = ((clave % n) + n) % n;

        char[] chars = texto.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = array.indexOf(chars[i]);
            
            int newIdx = (idx + shift) % n;
            chars[i] = array.get(newIdx);
        }
        return new String(chars);
    }

    public static String decifrar(String texto, int clave, List<Character> array) {
        int n = array.size();
        int shift = ((clave % n) + n) % n;

        char[] chars = texto.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            int idx = array.indexOf(chars[i]);

            int newIdx = (idx - shift + n) % n;
            chars[i] = array.get(newIdx);
        }
        return new String(chars);
    }

}
