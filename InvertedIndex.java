// Krish Doshi
// 09/29/2024
// CSE 123 
// C0: Warm Up and Review
// TA: Cynthia

import java.util.*;

//This class takes a list of books and creates an index from that list of book and that words
//contained in the books
public class InvertedIndex {
    public static void main(String[] args) {
        List<Media> docs = List.of(
            new Book("Mistborn", "Brandon Sanderson",
                     new Scanner("Epic fantasy worldbuildling content")),
            new Book("Farenheit 451", "Ray Bradbury",
                     new Scanner("Realistic \"sci-fi\" content")),
            new Book("The Hobbit", "J.R.R. Tolkein",
                     new Scanner("Epic fantasy quest content"))
        );
        
        Map<String, Set<Media>> result = createIndex(docs);
        System.out.println(docs);
        System.out.println();
        System.out.println(result);
    }

    // Behavior: 
    //   - This method provides an index (shows which words are in what media) of all the words
    //   - provided in given media
    // Parameters:
    //   - docs: list of books for which we are going to create an index
    // Returns:
    //   - Map<String, Set<Media>>: pairs up each word (case-insensitive) to a list of which 
    //   - books contain
    //   - that words
    // Exceptions:
    //   - No exceptions thrown.
    public static Map<String, Set<Media>> createIndex(List<Media> docs){
        Map<String, Set<Media>> index = new TreeMap<>();

        for (int i = 0; i < docs.size(); i++) {
            Media media = docs.get(i);
            List<String> words = media.getWords();

            for (int j = 0; j < words.size(); j++) {
                String currentWord = words.get(j).toLowerCase();
                if (index.get(currentWord) != null) { //media contains the checked word
                    Set<Media> tempSet = index.get(currentWord);
                    tempSet.add(media);
                } else {
                    index.put(currentWord, new HashSet<Media>(Arrays.asList(media)));
                } 
            }
        }

        return index;
    }
}
