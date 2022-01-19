import java.util.ArrayList;
import java.util.HashMap;

public class TextTwist {
    public static void main(String[] args) {

        String[] input = {"cat", "create", "sat"};
        System.out.println(score(input, "caster"));
        String[] input2 = {"trance", "recant"};
        System.out.println(score(input2, "recant"));
        String[] input3 = {"dote", "dotes", "toes", "set", "dot", "dots", "sted"};
        System.out.println(score(input3, "tossed"));
    }

    public static int score(String[] inputs, String base) {
        HashMap<Character, Integer> baseMap = getMap(base);
        int score = 0;
        for (String input : inputs) {
            if (!checkValid(input, baseMap)) continue;
            if (input.length() == 6) score += 50;
            score += input.length() - 2;
        }
        return score;
    }

    public static HashMap<Character, Integer> getMap(String base) {
        HashMap<Character, Integer> output = new HashMap<Character, Integer>();

        for (int i = 0; i < base.length(); i++) {
            if (output.containsKey(base.charAt(i))) {
                output.replace(base.charAt(i), output.get(base.charAt(i)) + 1);
            } else {
                output.put(base.charAt(i), 1);
            }
        }

        return output;
    }

    public static boolean checkValid(String input, HashMap<Character, Integer> baseInput) {
        HashMap<Character, Integer> base = deepCopyHashMap(baseInput);
        for (int i = 0; i < input.length(); i++) {
            if (base.containsKey(input.charAt(i))) {
                if (base.get(input.charAt(i)) > 0) {
                    base.replace(input.charAt(i), base.get(input.charAt(i)) - 1);
                } else {
                    return false;
                }
            } else {
                return false;
            }
        }
        return true;
    }

    public static HashMap<Character, Integer> deepCopyHashMap(HashMap<Character, Integer> input) {

        HashMap<Character, Integer> output = new HashMap<Character, Integer>();
        for (Character key : input.keySet()) {
            output.put(key, input.get(key));
        }
        return output;
    }
}
