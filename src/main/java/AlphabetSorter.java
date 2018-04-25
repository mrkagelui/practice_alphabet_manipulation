import java.util.*;
import java.util.stream.Collectors;

public class AlphabetSorter {
    private String value;
    private String sortedValue;

    public AlphabetSorter(String val) {
        value = val;
        sortedValue = "";
    }

    public String getSortedValue() {
        return sortedValue;
    }

    public static boolean isVowel(char c) {
        return "aeiou".indexOf(Character.toLowerCase(c)) > 0;
    }

    public static boolean isConsonant(char c) {
        return "bcdfghjklmnpqrstvwxyz".indexOf(Character.toLowerCase(c)) > 0;
    }

    public void sort() {
        // actually separate the vowels and consonants and sort them
        List<Character> vowels = new ArrayList<>();
        List<Character> consonants = new ArrayList<>();
        for (char ch : value.toCharArray()) {
            if (isVowel(ch)) {
                vowels.add(ch);
            }
            else if (isConsonant(ch)) {
                consonants.add(ch);
            }
        }
        // sort case-insensitively
        vowels.sort((c1, c2) -> Character.toLowerCase(c1) - Character.toLowerCase(c2));
        consonants.sort((c1, c2) -> Character.toLowerCase(c1) - Character.toLowerCase(c2));
        String vowelPart = vowels.stream().map(c->c.toString()).collect(Collectors.joining());
        String consonantPart = consonants.stream().map(c->c.toString()).collect(Collectors.joining());

        sortedValue = vowelPart+consonantPart;
    }

    public void quickSort(){
        // assume only English alphabets are processed, build a counter map instead of sorting
        Map<Character, Integer> charMap = new LinkedHashMap<>();
        charMap.put('A', 0);
        charMap.put('a', 0);
        charMap.put('E', 0);
        charMap.put('e', 0);
        charMap.put('I', 0);
        charMap.put('i', 0);
        charMap.put('O', 0);
        charMap.put('o', 0);
        charMap.put('U', 0);
        charMap.put('u', 0);
        charMap.put('B', 0);
        charMap.put('b', 0);
        charMap.put('C', 0);
        charMap.put('c', 0);
        charMap.put('D', 0);
        charMap.put('d', 0);
        charMap.put('F', 0);
        charMap.put('f', 0);
        charMap.put('G', 0);
        charMap.put('g', 0);
        charMap.put('H', 0);
        charMap.put('h', 0);
        charMap.put('J', 0);
        charMap.put('j', 0);
        charMap.put('K', 0);
        charMap.put('k', 0);
        charMap.put('L', 0);
        charMap.put('l', 0);
        charMap.put('M', 0);
        charMap.put('m', 0);
        charMap.put('N', 0);
        charMap.put('n', 0);
        charMap.put('P', 0);
        charMap.put('p', 0);
        charMap.put('Q', 0);
        charMap.put('q', 0);
        charMap.put('R', 0);
        charMap.put('r', 0);
        charMap.put('S', 0);
        charMap.put('s', 0);
        charMap.put('T', 0);
        charMap.put('t', 0);
        charMap.put('V', 0);
        charMap.put('v', 0);
        charMap.put('W', 0);
        charMap.put('w', 0);
        charMap.put('X', 0);
        charMap.put('x', 0);
        charMap.put('Y', 0);
        charMap.put('y', 0);
        charMap.put('Z', 0);
        charMap.put('z', 0);

        for (char ch : value.toCharArray()) {
            if (charMap.containsKey(ch)) {
                charMap.put(ch, charMap.get(ch) + 1);
            }
        }
        StringBuilder sb = new StringBuilder();
        for (Map.Entry<Character, Integer> e : charMap.entrySet()) {
            if (e.getValue() > 0) {
                for (int i = 0; i < e.getValue(); i++) {
                    sb.append(e.getKey());
                }
            }
        }
        sortedValue = sb.toString();
    }

    private static void benchmark(){
        int length = 1000;
        Random r = new Random();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < length; i++) {
            sb.append((char)(r.nextInt(26) + 'a'));
        }
        String testStr = sb.toString();
        AlphabetSorter asNormal = new AlphabetSorter(testStr);
        long startTime = System.nanoTime();
        asNormal.sort();
        long endTime = System.nanoTime();
        long normalSortTime = endTime - startTime;

        AlphabetSorter asQuick = new AlphabetSorter(testStr);
        startTime = System.nanoTime();
        asQuick.quickSort();
        endTime = System.nanoTime();
        long quickSortTime = endTime - startTime;

        System.out.println("For character sequence of " + length + ":");
        System.out.printf("Normal sorting takes %d nano seconds.\n", normalSortTime);
        System.out.printf("Quick 'sorting' takes %d nano seconds.\n", quickSortTime);
    }

    public static void main(String[] args) {
        //benchmark();
        System.out.println("Please key in the string to sort:");
        Scanner sc = new Scanner(System.in);
        String toSort = sc.nextLine();
        AlphabetSorter as = new AlphabetSorter(toSort);
        as.quickSort();
        // as.sort();
        System.out.println("Sorted string is: " + as.getSortedValue());
    }
}
