# practice_alphabet_manipulation

## Alphabet Sorter

* Sorts a string, putting the sorted vowels before sorted consonants (upper case before lower case)
* Provides two implementations:
1. "Sort": Separate the vowels and consonants, sort them separately and concatenate, apparently this takes O(nlgn) time;
2. "QuickSort": With the assumption that anything other than English alphabets are discarded, build a map which records the number of occurrence and preserves the order of keys, then print the characters, this takes O(n) time.
* A benchmark method is also provided, which proves the difference of elapsed time between the two approaches.

## Unique Common Alphabet

* Given two strings, return the unique character set that only appear in one of them, and the common character set that are in both of them, in a case-sensitive manner
* Build a character->int map and scan the strings:
  1. For string 1, put every character with 1 into the map;
  2. For string 2:
  * If the character is not found in the map, put it with 0 into the map;
  * If it is in the map and the value is at least 1 (so that this character appears in string 1 at least once), increase the value by 1.
* After this, those characters with value 1 come only from string 1, and those with value 0 come only from string 2; greater than 1 means they appear in both
* This approach takes O(m+n) time and space, m and n being the length of the two strings