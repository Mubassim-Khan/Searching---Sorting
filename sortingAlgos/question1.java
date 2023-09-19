package sortingAlgos;

public class question1 {
    // Bubble Sort
    static void bubbleSort(char characters[]) {
        System.out.println("Bubble Sort Method");
        int swaps = 0, comp = 0;
        int n = characters.length;
        char temp;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                comp++;
                if (characters[j] > characters[j + 1]) {
                    temp = characters[j];
                    characters[j] = characters[j + 1];
                    characters[j + 1] = temp;
                    swaps++;
                }
            }
        }
        System.out.println("Total Swappings are: " + swaps);
        System.out.println("Total Comparisons are: " + comp);
    }

    // Selection Sort
    static void selectionSort(char characters[]) {
        System.out.println("Selection Sort Method");
        int swaps = 0, comp = 0;
        int n = characters.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                comp++;
                if (characters[j] < characters[minIndex]) {
                    minIndex = j;
                    swaps++;
                }
            }
            char temp = characters[i];
            characters[i] = characters[minIndex];
            characters[minIndex] = temp;
            swaps++;
        }
        System.out.println("Total Swappings are: " + swaps);
        System.out.println("Total Comparisons are: " + comp);
    }

    // Insertion Sort
    static void insertionSort(char characters[]) {
        System.out.println("Insertion Sort Method");
        int n = characters.length;
        int swaps = 0, comp = 0;

        for (int i = 0; i < n; i++) {
            char temp = characters[i];
            int j = i - 1;

            while (j >= 0 && characters[j] > temp) {
                comp++;
                characters[j + 1] = characters[j];
                j--;
            }
            characters[j + 1] = temp;
            swaps++;

        }
        System.out.println("Total Swappings are: " + swaps);
        System.out.println("Total Comparisons are: " + comp);
    }

    static void printMethod(char characters[]) {
        System.out.print("Sorted Array is: ");
        for (char c : characters) {
            System.out.print(c + " ");
        }
        System.out.println("\n");
    }

    public static void main(String[] args) {
        char characters[] = { 'P', 'Y', 'T', 'H', 'O', 'N' };

        bubbleSort(characters);
        printMethod(characters);
        
        selectionSort(characters);
        printMethod(characters);

        insertionSort(characters);
        printMethod(characters);
        
        /* Total number of swappings & comparisons will decrease after calling of
         * first method i.e (Bubble Sort method),
         * because that same array will be used as an arrgument in every other method call. 
         */
    }
}
