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

    public static void printArray(studentData[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.println("Reg No: " + arr[i].regNo + ", Name: " + arr[i].name + ", Course: " + arr[i].course
                    + ", CGPA: " + arr[i].cgpa);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Data of 50 students.

        studentData[] students = new studentData[] {
                new studentData(7, "Grace", "Computer Science", 3.7),
                new studentData(1, "Alice", "Computer Science", 3.8),
                new studentData(3, "Charlie", "Mathematics", 3.2),
                new studentData(12, "Leo", "Chemistry", 3.6),
                new studentData(4, "David", "Physics", 3.9),
                new studentData(5, "Eva", "Biology", 3.4),
                new studentData(6, "Frank", "Chemistry", 3.6),
                new studentData(8, "Hank", "Engineering", 3.5),
                new studentData(10, "Jack", "Physics", 3.9),
                new studentData(16, "Paul", "Physics", 3.9),
                new studentData(45, "Sofia", "Mathematics", 3.2),
                new studentData(17, "Quinn", "Biology", 3.4),
                new studentData(18, "Ryan", "Chemistry", 3.6),
                new studentData(19, "Sara", "Computer Science", 3.7),
                new studentData(20, "Tom", "Engineering", 3.5),
                new studentData(21, "Uma", "Mathematics", 3.2),
                new studentData(22, "Victor", "Physics", 3.9),
                new studentData(2, "Bob", "Engineering", 3.5),
                new studentData(23, "Wendy", "Biology", 3.4),
                new studentData(25, "Yara", "Computer Science", 3.7),
                new studentData(50, "Xander", "Engineering", 3.5),
                new studentData(26, "Zane", "Engineering", 3.5),
                new studentData(27, "Amy", "Mathematics", 3.2),
                new studentData(43, "Quinn", "Computer Science", 3.7),
                new studentData(28, "Ben", "Physics", 3.9),
                new studentData(29, "Cathy", "Biology", 3.4),
                new studentData(30, "Daniel", "Chemistry", 3.6),
                new studentData(31, "Ella", "Computer Science", 3.7),
                new studentData(32, "Finn", "Engineering", 3.5),
                new studentData(46, "Thomas", "Physics", 3.9),
                new studentData(47, "Uma", "Biology", 3.4),
                new studentData(33, "Gina", "Mathematics", 3.2),
                new studentData(34, "Harry", "Physics", 3.9),
                new studentData(9, "Ivy", "Mathematics", 3.2),
                new studentData(35, "Isabel", "Biology", 3.4),
                new studentData(36, "Jake", "Chemistry", 3.6),
                new studentData(37, "Kylie", "Computer Science", 3.7),
                new studentData(38, "Liam", "Engineering", 3.5),
                new studentData(11, "Katie", "Biology", 3.4),
                new studentData(13, "Mia", "Computer Science", 3.7),
                new studentData(14, "Noah", "Engineering", 3.5),
                new studentData(39, "Mia", "Mathematics", 3.2),
                new studentData(40, "Nina", "Physics", 3.9),
                new studentData(41, "Oscar", "Biology", 3.4),
                new studentData(42, "Penelope", "Chemistry", 3.6),
                new studentData(15, "Olivia", "Mathematics", 3.2),
                new studentData(44, "Ryan", "Engineering", 3.5),
                new studentData(48, "Victor", "Chemistry", 3.6),
                new studentData(49, "Wendy", "Computer Science", 3.7),
                new studentData(24, "Xander", "Chemistry", 3.6),
        };

        // a) Linear search function to display data of a student with a particular Regn no.

        System.out.println("\n Part A: Linear Search Method (To display data) \n");

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

        System.out.println("\n Part B: Bubble Sort Method (To sort data) \n");

        bubbleSort(students);
        printArray(students);

        // c) Binary search on the sorted data to display a student with a particular Regn no.

        System.out.println("\n Part C: Binary Seach Method (To display data) \n");

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
}