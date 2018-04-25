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

    public void sort() {
        // actually separate the vowels and consonants and sort them
    }

    public void quickSort(){
        // assume only English alphabets are processed, build a counter map instead of sorting
    }
}
