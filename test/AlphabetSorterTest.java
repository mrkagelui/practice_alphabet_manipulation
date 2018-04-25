import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

class AlphabetSorterTest {
    @Test
    void shouldSortEmpty() {
        AlphabetSorter as = new AlphabetSorter("");
        as.sort();
        assertTrue(as.getSortedValue().equalsIgnoreCase(""),
                "Empty string should be sorted as empty");
    }

    @Test
    void shouldQuickSortEmpty() {
        AlphabetSorter as = new AlphabetSorter("");
        as.quickSort();
        assertTrue(as.getSortedValue().equalsIgnoreCase(""),
                "Empty string should be quick-sorted as empty");
    }

    @Test
    void sortStringWithSpace() {
        AlphabetSorter as = new AlphabetSorter("good morning");
        as.sort();
        assertTrue(as.getSortedValue().equals("iooodggmnnr"),
                "String with space should be sorted correctly");
    }

    @Test
    void quickSortStringWithSpace() {
        AlphabetSorter as = new AlphabetSorter("good morning");
        as.quickSort();
        assertTrue(as.getSortedValue().equals("iooodggmnnr"),
                "String with space should be sorted correctly");
    }

    @Test
    void quickSortWithMixedCase() {
        AlphabetSorter as = new AlphabetSorter("good morNing");
        as.quickSort();
        assertTrue(as.getSortedValue().equals("iooodggmNnr"),
                "String with mixed cases should be sorted correctly");
    }

    @Test
    void sortWithMixedCase() {
        AlphabetSorter as = new AlphabetSorter("good morNing");
        as.sort();
        assertTrue(as.getSortedValue().equals("iooodggmNnr"),
                "String with mixed cases should be sorted correctly");
    }
}