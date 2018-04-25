import java.util.*;
import java.util.stream.Collectors;

public class UniqueCommonAlphabet {
    private String string1;
    private String string2;
    private String uniqueChars;
    private String commonChars;

    public UniqueCommonAlphabet(String str1, String str2) {
        string1 = str1;
        string2 = str2;
        uniqueChars = "";
        commonChars = "";
    }

    public String getUniqueChars() {
        return uniqueChars;
    }

    public String getCommonChars() {
        return commonChars;
    }

    public void process() {
        Map<Character, Integer> charMap = new HashMap<>();
        for (char c : string1.toCharArray()) {
            charMap.put(c, 1);
        }
        for (char c : string2.toCharArray()) {
            charMap.put(c, charMap.getOrDefault(c, 0) + 1);
        }
        List<Character> uniques = new ArrayList<>();
        List<Character> commons = new ArrayList<>();
        for (Map.Entry<Character, Integer> entry : charMap.entrySet()){
            if (entry.getValue() > 1) {
                commons.add(entry.getKey());
            }
            else {
                uniques.add(entry.getKey());
            }
        }

        commons.sort(Comparator.naturalOrder());
        uniques.sort(Comparator.naturalOrder());

        commonChars = commons.stream().map(c -> c.toString()).collect(Collectors.joining());
        uniqueChars = uniques.stream().map(c -> c.toString()).collect(Collectors.joining());
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Please key in string 1:");
        String s1 = sc.nextLine();
        System.out.println("Please key in string 2:");
        String s2 = sc.nextLine();
        UniqueCommonAlphabet uca = new UniqueCommonAlphabet(s1, s2);
        uca.process();
        System.out.println("Unique characters: " + uca.getUniqueChars());
        System.out.println("Common characters: " + uca.getCommonChars());
    }
}
