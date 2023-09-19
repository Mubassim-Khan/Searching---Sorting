package Binary_Search_Algo;

import java.util.Scanner;

public class phoneDirectory {
    public static int binary(String phoneNumbers[], String key) {
        int left = 0;
        int right = phoneNumbers.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            int result = key.compareTo(phoneNumbers[mid]);

            if (result < 0) {
                right = mid - 1;
            } else if (result > 0) {
                left = mid + 1;
            } else {
                return mid + 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println("PHONE DIRECTORY ALGO");
        String phoneNumbers[] = { "0313-91219911", "0321-76853023", "0332-24566789", "0333-98734321", "0341-24910205" };
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter phone number to find: ");
        String key = scanner.nextLine();
        scanner.close();

        int position = binary(phoneNumbers, key);
        if (position == -1) {
            System.out.println("Phone number does not exsist in directory");
        } else {
            System.out.println("KEY: " + key);
            System.out.println("Your phone number \"" + key + "\" is located at position \"" + position + "\" of directory.");
        }
    }
}