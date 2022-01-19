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

    public static int score(String[] inputs, String baseWord) {
        HashMap<Character, Integer> baseWordCharCountMapForCheckingIfTheInputIsUsingALetterTooManyTimes = getCharCountMap(baseWord);
        int score = 0;
        for (String input : inputs) {
            if (!isValid(input, baseWordCharCountMapForCheckingIfTheInputIsUsingALetterTooManyTimes)) continue;

            score += input.length() - 2;
            if (input.length() == 6) score += 50;
        }
        return score;
    }

    public static HashMap<Character, Integer> getCharCountMap(String input) {
        HashMap<Character, Integer> output = new HashMap<>();

        for (Character currentChar : input.toCharArray()) {
            if (!output.containsKey(currentChar)) {
                output.put(currentChar, 1);
            } else {
                output.replace(currentChar, output.get(currentChar) + 1);
            }
        }

        return output;
    }

    public static boolean isValid(String input, HashMap<Character, Integer> baseWordInput) {
        HashMap<Character, Integer> baseWordCharCount = deepCopyHashMap(baseWordInput);

        for (Character currentChar : input.toCharArray()) {
            if (baseWordCharCount.containsKey(currentChar)) {
                baseWordCharCount.replace(currentChar, baseWordCharCount.get(currentChar) - 1);
                if (baseWordCharCount.get(currentChar) == 0) baseWordCharCount.remove(currentChar);
            } else {return false;}
        }
        return true;
    }

    public static <A, B> HashMap<A, B> deepCopyHashMap(HashMap<A, B> input) {
        HashMap<A, B> output = new HashMap<>();
        for (A key : input.keySet()) output.put(key, input.get(key));
        return output;
    }
}
