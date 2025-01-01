// Krish Doshi
// 09/29/2024
// CSE 123 
// C0: Warm Up and Review
// TA: Cynthia

import java.util.*;

//This class represents a book which is a form of media (implements the media interface). 
//It has information about the title, author, words, and ratings related to this book, which can
//be acquired.
public class Book implements Media{

    private String title;
    private List<String> authors;
    private List<Integer> ratings;
    private Scanner sc;
    private List<String> wordsList;


    // Behavior: 
    //   - This stores the title, authors list, ratings list.
    //   - No words or ratings are provided for the book
    // Parameters:
    //   - title: the title of the book
    //   - author: the author of the book
    // Returns:
    //   - Doesn't return anything.
    // Exceptions:
    //   - No exceptions thrown.
    public Book(String title, String author) {
        this.title = title;
        authors = new ArrayList<>();
        authors.add(author);
        sc = null;
        ratings = new ArrayList<>();
        wordsList = new ArrayList<>();
    }

    // Behavior: 
    //   - This method stores the title, authors list, and ratings list.
    //   - No words or ratings are provided for the book
    // Parameters:
    //   - title: the title of the book
    //   - authors: a list of authors of the book
    // Returns:
    //   - Doesn't return anything.
    // Exceptions:
    //   - No exceptions thrown.
    public Book(String title, List<String> authors) {
        this.title = title;
        this.authors = authors;
        sc = null;
        ratings = new ArrayList<>();
        wordsList = new ArrayList<>();

    }

    // Behavior: 
    //   - This method stores the title, authors list, ratings list, and words in the book.
    //   - No ratings are provided for the book
    // Parameters:
    //   - title: the title of the book
    //   - author: the author of the book
    //   - sc: the words in the book
    // Returns:
    //   - Doesn't return anything.
    // Exceptions:
    //   - No exceptions thrown.
    public Book(String title, String author, Scanner sc) {
        this.title = title;
        authors = new ArrayList<>();
        authors.add(author);       
        this.sc = sc;
        ratings = new ArrayList<>();

        wordsList = new ArrayList<>();

        while (sc.hasNext()) {
            wordsList.add(sc.next());
        }
    }

    // Behavior: 
    //   - This method provides the title of the book
    // Parameters:
    //   - No parameters
    // Returns:
    //   - String: title of the book
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public String getTitle() {
        return title;
    }

    // Behavior: 
    //   - This method provides the authors of the book
    // Parameters:
    //   - No parameters
    // Returns:
    //   - List<String>: a list of the authors of the book
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public List<String> getArtists() {
        return authors;
    }

    // Behavior: 
    //   - This method stores a new rating
    // Parameters:
    //   - score: the number given as a rating to the book 
    // Returns:
    //   - Doesn't return anything.
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public void addRating(int score) {
        ratings.add(score);
    }

    // Behavior: 
    //   - This method provides the amount of ratings the book has gotten
    // Parameters:
    //   - No parameters
    // Returns:
    //   - int: how many ratings the book has
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public int getNumRatings() {
        return ratings.size();
    }

    // Behavior: 
    //   - This method calculates the average rating of the book based on all the sum of the
    //   - ratings and how many ratings there have been so far
    // Parameters:
    //   - No parameters
    // Returns:
    //   - double: the average rating of the book
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public double getAverageRating() {
        if(ratings.isEmpty()){
            return 0;
        }

        double sumOfRatings = 0.0;

        for (int i = 0; i < getNumRatings(); i++) {
            sumOfRatings += ratings.get(i);
        }

        return (sumOfRatings / getNumRatings()); //rounding to at most 2 decimal places
    }

    // Behavior: 
    //   - This method provides a list of the words in the book if it was provided when the 
    //   - book was created. Otherwise it provides an empty list
    // Parameters:
    //   - No parameters
    // Returns:
    //   - List<String>: a list of the words in the book (the list is empty if the words 
    //   - weren't provided)
    // Exceptions:
    //   - No exceptions thrown.
    @Override
    public List<String> getWords() {
        return wordsList;
    }

    // Behavior: 
    //   - This method provides a readable format for the information about the book, including
    //   - the title, author(s), average rating, and number of ratings
    // Parameters:
    //   - No parameters
    // Returns:
    //   - String: gives the title and author(s) of the book (if there are ratings, then
    //   - provides the
    //   - average rating and number of ratings too)
    // Exceptions:
    //   - No exceptions thrown.
    public String toString() {
        if (ratings.size() == 0) {
            return title + " by " + getArtists().toString();
        }

        return title + " by " + getArtists().toString() + ": " + Math.round(getAverageRating() *
                100.0) / 100.0 + " (" + getNumRatings() + " ratings)";
    }
}