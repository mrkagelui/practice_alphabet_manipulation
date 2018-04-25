import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UniqueCommonAlphabetTest {
    @Test
    void shouldTakeCareOfEmptyInput() {
        UniqueCommonAlphabet uca = new UniqueCommonAlphabet("Char", "");
        uca.process();
        assertEquals("", uca.getCommonChars(),
                "Non-empty string and empty one should have no common");
        assertEquals("Cahr", uca.getUniqueChars(),
                "Non-empty string itself (sorted) should be unique");
    }

    @Test
    void happyPath() {
        UniqueCommonAlphabet uca = new UniqueCommonAlphabet("characters", "alphabets");
        uca.process();
        assertEquals("aehst", uca.getCommonChars(),
                "Should return all common characters");
        assertEquals("bclpr", uca.getUniqueChars(),
                "Should return all unique characters");
    }

    @Test
    void shouldBeCaseSensitive() {
        UniqueCommonAlphabet uca = new UniqueCommonAlphabet("charAcTers", "alphabeTs");
        uca.process();
        assertEquals("Taehs", uca.getCommonChars(),
                "Should return all common characters, one of which is upper case");
        assertEquals("Abclpr", uca.getUniqueChars(),
                "Different case should be treated as unique");
    }
}