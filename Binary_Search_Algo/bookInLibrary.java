package Binary_Search_Algo;

import java.util.Scanner;

public class bookInLibrary {
    // Method of applying Binary Search
    public static int searchBookPosition(String[] bookArray, String targetBook) {
        int left = 0;
        int right = bookArray.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int comparison = targetBook.compareTo(bookArray[mid]);

            if (comparison < 0) {
                right = mid - 1;
            } else if (comparison > 0) {
                left = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    // Method to Print
    public static void printBookLocation(String bookName, String category, int position) {
        System.out.println("KEY: " + bookName);
        System.out.println("Your Book name is \"" + bookName + "\"");
        System.out.println(
                "Location in Library: At \"" + category.toUpperCase() + "\" Books Shelf, Position Number: \"" + position + "\"");
    }

    public static void main(String[] args) {
        System.out.println("SEARCHING A BOOK IN LIBRARY");
        String[] bookAlgorithm = { "Algorithm Design", "Algorithms Unlocked", "Algorithms in a nutshell",
                "Introduction to Algorithms", "Thomas H.Cumming" };
        String[] bookNetworking = { "Computer Networking", "CISCO Networking", "Routing Volume 1", "Routing Volume 2",
                "William Stalking" };
        String[] bookProgramming = { "Clean Code", "Code", "Coders at Work", "Code Complete", "Prefactoring" };

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the book name you want to search for: ");
        String targetBook = scanner.nextLine();
        scanner.close();

        String category;
        int position;

        // Searching in each category (using nested if-else)
        if ((position = searchBookPosition(bookAlgorithm, targetBook)) != -1) {
            category = "Algorithms";
            printBookLocation(targetBook, category, position);
        } else if ((position = searchBookPosition(bookNetworking, targetBook)) != -1) {
            category = "Networking";
            printBookLocation(targetBook, category, position);
        } else if ((position = searchBookPosition(bookProgramming, targetBook)) != -1) {
            category = "Programming";
            printBookLocation(targetBook, category, position);
        }

        if (position == -1) {
            System.out.println("Sorry, " + targetBook + " is not available in library.");
        }
    }
}