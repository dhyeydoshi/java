import java.util.*;

public class JavaPractice {
    public static class LinkedList {
        class Node {
            int data;
            Node next;

            Node(int data) {
                this.data = data;
                this.next = null;
            }
        }
        Node head;

        public void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                return;
            }

            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }

        public void reverse() {
            Node prev = null;
            Node current = head;
            Node next = null;

            while (current != null) {
                next = current.next;
                current.next = prev;
                prev = current;
                current = next;
            }
            head = prev;
        }

        public void printList() {
            Node current = head;
            while (current != null) {
                System.out.print(current.data + " ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void wordFrequencyCounter(String sentence) {
        String cleanedSentence = sentence.replaceAll("[^a-zA-Z\\s]", "").toLowerCase();

        String[] words = cleanedSentence.split("\\s+");

        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
        }
        frequencyMap.forEach((word, count) -> System.out.println(word + ": " + count));

    }

    public static boolean isPrime(int number) {
        if (number <= 1) return false;

        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) return false;
        }

        return true;
    }

    public static int factorial(int n) {
        if (n == 0 || n == 1) {
            return 1;
        }
        else if (n < 0) {
            System.out.println("Invalid");
            return -1;
        }
        return n * factorial(n - 1);
    }

    public static boolean anagramChecker(String str1, String str2) {
        if (str1 == null || str2 == null) return false;

        char[] charArray1 = str1.replaceAll("\\s", "").toLowerCase().toCharArray();
        char[] charArray2 = str2.replaceAll("\\s", "").toLowerCase().toCharArray();

        Arrays.sort(charArray1);
        Arrays.sort(charArray2);

        return Arrays.equals(charArray1, charArray2);
    }

    public static void bubbleSort(int[] arr) {

        if (arr == null || arr.length <= 1) return;

        int arrLength = arr.length;
        for (int i = 0; i < arrLength - 1; i++) {
            for (int j = 0; j < arrLength - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void countVowelsAndConsonants(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println("Invalid input");
            return;
        }
        str = str.toLowerCase();
        int vowels = 0, consonants = 0;

        for (char ch : str.toCharArray()) {
            if (Character.isLetter(ch)) {
                if ("aeiou".indexOf(ch) != -1) {
                    vowels++;
                } else {
                    consonants++;
                }
            }
        }

        System.out.println("Vowels: " + vowels + ", Consonants: " + consonants);
    }

    public static int gcd(int a, int b) {

        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0) return b;
        if (b == 0) return a;

        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int lcm(int a, int b) {
        return (a * b) / gcd(a, b);
    }

    public static void multiplyMatrices(int[][] A, int[][] B) {
        if (A == null || B == null || A.length == 0 || B.length == 0) {
            throw new IllegalArgumentException("Matrices cannot be null or empty");
        }
        int rowsALength = A.length;
        int colsALength = A[0].length;
        int colsBLength = B[0].length;

        int[][] result = new int[rowsALength][colsBLength];

        for (int i = 0; i < rowsALength; i++) {
            for (int j = 0; j < colsBLength; j++) {
                for (int k = 0; k < colsALength; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }

        for (int[] row : result) {
            System.out.println(Arrays.toString(row));
        }
    }

    public static boolean isArmstrong(int number) {
        if (number < 0) return false;
        if (number < 10) return true;

        int originalNumber = number;
        int sum = 0;
        int digits = String.valueOf(number).length();

        while (number > 0) {
            int digit = number % 10;
            sum += Math.pow(digit, digits);
            number /= 10;
        }

        return sum == originalNumber;
    }

    public static int[] removeDuplicates(int[] arr) {
        if (arr == null || arr.length <= 1) return arr;
        return Arrays.stream(arr).distinct().toArray();
    }

    static class BankAccount {
        private double balance;
        private String accountNumber;

        public BankAccount(String accountNumber, double initialBalance) {
            this.accountNumber = accountNumber;
            this.balance = initialBalance;
        }

        public void deposit(double amount) {
            if (amount > 0) {
                balance += amount;
                System.out.println("Deposited: " + amount);
            }
        }

        public void withdraw(double amount) {
            if (amount > 0 && amount <= balance) {
                balance -= amount;
                System.out.println("Withdrawn: " + amount);
            } else {
                System.out.println("Insufficient funds");
            }
        }

        public double getBalance() {
            return balance;
        }
    }



    // Main Function
    public static void main(String[] args){
        System.out.println("1. Linked List Reversal:");
        LinkedList list = new LinkedList();
        list.insert(2);
        list.insert(1);
        list.insert(3);
        list.insert(4);
        list.insert(8);
        list.insert(6);
        list.insert(7);
        list.insert(7);
        list.insert(6);
        System.out.println("Original List:");
        list.printList();
        list.reverse();
        System.out.println("Reversed List:");
        list.printList();

        System.out.println("\n2. Word Frequency Counter:");
        String sentence = "Hello, hello world! This is a test. Test, test.";
        wordFrequencyCounter(sentence);

        System.out.println("\n3. Prime Number Checker:");
        System.out.println("is 17 prime?: " + isPrime(17));
        System.out.println("is 20 prime?: " + isPrime(20));

        System.out.println("\n4. Factorial:");
        System.out.println("Factorial of 5: " + factorial(5));

        System.out.println("\n5. Anagram Checker:");
        System.out.println("listen silent: " + anagramChecker("listen", "silent"));

        System.out.println("\n6. Bubble Sort:");
        int[] arr = {1,6,2,3,8,4,7,5};
        System.out.println("Before sorting: " + Arrays.toString(arr));
        bubbleSort(arr);
        System.out.println("After sorting: " + Arrays.toString(arr));

        System.out.println("\n7. Vowel and Consonant Counter:");
        countVowelsAndConsonants("Hello World");

        System.out.println("\n8. GCD and LCM:");
        System.out.println("GCD: " + gcd(50, 10));
        System.out.println("LCM: " + lcm(50, 10));

        System.out.println("\n9. Matrix Multiplication:");
        int[][] matrix1 = {{1, 2}, {3, 4}};
        int[][] matrix2 = {{5, 6}, {7, 8}};
        multiplyMatrices(matrix1, matrix2);

        System.out.println("\n10. Armstrong Number:");
        System.out.println("153 is Armstrong: " + isArmstrong(153));

        System.out.println("\n11. Remove Duplicates:");
        int[] duplicateArr = {5, 2, 2, 3, 4, 4, 5};
        System.out.println("Without Duplicates: " + Arrays.toString(removeDuplicates(duplicateArr)));

        System.out.println("\n12. Banking System:");
        double initialBalance = 1000;
        BankAccount account = new BankAccount("123456", initialBalance);
        System.out.println("Initial Balance: " + account.getBalance());
        account.deposit(500);
        account.withdraw(200);
        System.out.println("Current Balance: " + account.getBalance());

    }
}
