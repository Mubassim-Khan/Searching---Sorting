package sortingAlgos;

import java.util.Scanner;

class studentData {
    int regNo;
    String name;
    String course;
    double cgpa;

    public studentData(int regNo, String name, String course, double cgpa) {
        this.regNo = regNo;
        this.name = name;
        this.course = course;
        this.cgpa = cgpa;
    }

    public void display() {
        System.out.println("Reg No: " + regNo);
        System.out.println("Name: " + name);
        System.out.println("Course: " + course);
        System.out.println("CGPA: " + cgpa);
    }
}

public class question2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        studentData[] students = new studentData[2];
        students[0] = new studentData(34, "Bob", "89", 3.4);
        students[1] = new studentData(345, "Boba", "890", 37.4);

        // a) Linear search function to display data of a student with a particular Regn no.

        System.out.println("\n Part A \n");

        System.out.print("Enter Register number to find student: ");
        int regNoToSearch = scanner.nextInt();

        boolean found = false;
        for (studentData student : students) {
            if (student != null && student.regNo == regNoToSearch) {
                student.display();
                found = true;
            }
        }

        if (!found) {
            System.out.println("Unable to find Student with Reg no: " + regNoToSearch);
        }

        // b) Bubble sort function to arrange data of students according to Regn no.

        System.out.println("\n Part B \n");

        bubbleSort(students);

        // c) Binary search on the sorted data to display a student with a particular Regn no.

        System.out.println("\n Part C \n");

        System.out.print("Enter Register number to find student data: ");
        int regNoToBinarySearch = scanner.nextInt();
        scanner.close();
        int result = binarySearch(students, regNoToBinarySearch);
        if (result != -1) {
            students[result].display();
        } else {
            System.out.println("Unable to find Student with Reg no: " + regNoToBinarySearch);
        }
    }

    // Bubble sort function to arrange data of students according to Regn no.
    static void bubbleSort(studentData[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j].regNo > arr[j + 1].regNo) {
                    // Swap arr[j] and arr[j+1]
                    studentData temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // Binary search function to find a student by Regn no.
    static int binarySearch(studentData[] arr, int regNoToSearch) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid].regNo == regNoToSearch) {
                return mid;
            }
            if (arr[mid].regNo < regNoToSearch) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1; // Student not found
    }
}
