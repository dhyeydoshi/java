
import java.util.*;
import java.io.*;
import java.util.stream.*;

class HelloWorld {
    public static void runHelloWorld() {
        System.out.println("\n Hello World Example");
        System.out.println("Hello, World!");
    }
}

class PersonVariables {
    public static void runPersonVariables() {
        System.out.println("\n Variables and Data Types Example");
        String name = "John Smith";
        int age = 30;
        double salary = 75000.50;

        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
        System.out.println("Salary: $" + salary);
    }
}

class NumberCheck {
    public static void runNumberCheck() {
        System.out.println("\n Conditional Statements Example ");
        checkNumber(-5);
        checkNumber(0);
        checkNumber(10);
    }

    private static void checkNumber(int number) {
        if (number > 0) {
            System.out.println(number + " is positive");
        } else if (number < 0) {
            System.out.println(number + " is negative");
        } else {
            System.out.println("The number is zero");
        }
    }
}

class NaturalNumbers {
    public static void runNaturalNumbers() {
        System.out.println("\n Looping Example");
        System.out.println("First 10 natural numbers:");

        for (int i = 1; i <= 10; i++) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

class ArrayExample {
    public static void runArrayExample() {
        System.out.println("\n Arrays Example");
        int[] numbers = {10, 20, 30, 40, 50};

        System.out.println("Array elements:");
        for (int i = 0; i < numbers.length; i++) {
            System.out.println("Element at index " + i + ": " + numbers[i]);
        }
    }
}


class Student {
    // Instance variables
    private String name;
    private int id;
    private char grade;

    // Constructor
    public Student(String name, int id, char grade) {
        this.name = name;
        this.id = id;
        this.grade = grade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public char getGrade() {
        return grade;
    }

    public void setGrade(char grade) {
        this.grade = grade;
    }

    // Display method
    public void displayInfo() {
        System.out.println("Student Information:");
        System.out.println("Name: " + name);
        System.out.println("ID: " + id);
        System.out.println("Grade: " + grade);
    }

    public static void runStudentExample() {
        System.out.println("\n Classes and Objects Example");
        Student student = new Student("Alice Johnson", 12345, 'A');
        student.displayInfo();
    }
}

// Base class
abstract class Shape {
    abstract double calculateArea();
    abstract double calculatePerimeter();
}

// Circle class
class Circle extends Shape {
    private double radius;

    public Circle(double radius) {
        this.radius = radius;
    }

    @Override
    double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    double calculatePerimeter() {
        return 2 * Math.PI * radius;
    }
}

// Rectangle class
class Rectangle extends Shape {
    private double length;
    private double width;

    public Rectangle(double length, double width) {
        this.length = length;
        this.width = width;
    }

    @Override
    double calculateArea() {
        return length * width;
    }

    @Override
    double calculatePerimeter() {
        return 2 * (length + width);
    }
}

// Test class for inheritance
class ShapeDemo {
    public static void runShapeDemo() {
        System.out.println("\n Inheritance Example");
        Circle circle = new Circle(5.0);
        System.out.println("Circle Area: " + circle.calculateArea());
        System.out.println("Circle Perimeter: " + circle.calculatePerimeter());

        Rectangle rectangle = new Rectangle(4.0, 6.0);
        System.out.println("Rectangle Area: " + rectangle.calculateArea());
        System.out.println("Rectangle Perimeter: " + rectangle.calculatePerimeter());
    }
}

class DivisionExceptionHandling {
    public static void runDivisionExample() {
        System.out.println("\n Exception Handling Example ");

        divideNumbers(10, 2);
        divideNumbers(10, 0);
    }

    private static void divideNumbers(int numerator, int denominator) {
        try {
            System.out.println("Dividing: " + numerator + " / " + denominator);
            int result = divide(numerator, denominator);
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Division by zero is not allowed.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        } finally {
            System.out.println("Division operation completed.");
        }
    }

    public static int divide(int numerator, int denominator) {
        return numerator / denominator;
    }
}

class ArrayListDemo {
    public static void runArrayListDemo() {
        System.out.println("\n Collections Example");
        ArrayList<String> names = new ArrayList<>();

        names.add("John");
        names.add("Alice");
        names.add("Bob");
        names.add("Carol");
        names.add("David");

        System.out.println("Original list: " + names);

        names.add(2, "Eve");
        System.out.println("After adding 'Eve' at index 2: " + names);

        names.remove("Bob");
        System.out.println("After removing 'Bob': " + names);

        Collections.sort(names);
        System.out.println("Sorted list: " + names);

        boolean hasAlice = names.contains("Alice");
        System.out.println("Does the list contain 'Alice'? " + hasAlice);

        String thirdPerson = names.get(2);
        System.out.println("Person at index 2: " + thirdPerson);

        System.out.println("Size of the list: " + names.size());

        System.out.println("List elements:");
        for (String name : names) {
            System.out.println("- " + name);
        }
    }
}


class FileStatistics {
    public static void runFileExample() {
        System.out.println("\n File I/O Example");

        createSampleFile();

        String fileName = "sample.txt";
        int lineCount = 0;
        int wordCount = 0;
        int charCount = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;

            while ((line = reader.readLine()) != null) {
                lineCount++;

                charCount += line.length();

                if (!line.isEmpty()) {
                    String[] words = line.split("\\s+");
                    wordCount += words.length;
                }
            }

            System.out.println("File: " + fileName);
            System.out.println("Lines: " + lineCount);
            System.out.println("Words: " + wordCount);
            System.out.println("Characters: " + charCount);

        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
    }

    private static void createSampleFile() {
        try (FileWriter writer = new FileWriter("sample.txt")) {
            writer.write("This is a sample text file.\n");
            writer.write("It contains multiple lines.\n");
            writer.write("We will count the lines, words, and characters in it.\n");
            writer.write("This is the fourth and final line.");
        } catch (IOException e) {
            System.out.println("Error creating sample file: " + e.getMessage());
        }
    }
}

class EvenOddThreads {
    public static void runThreadsExample() {
        System.out.println("\n Multithreading Example");
        System.out.println("Starting threads to print even and odd numbers...");

        // Create threads
        Thread evenThread = new Thread(new EvenNumberPrinter());
        Thread oddThread = new Thread(new OddNumberPrinter());

        // Set thread names
        evenThread.setName("EvenThread");
        oddThread.setName("OddThread");

        // Start threads
        evenThread.start();
        oddThread.start();

        // Wait for both threads to complete
        try {
            evenThread.join();
            oddThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("All threads have finished execution.");
    }
}

class EvenNumberPrinter implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started");

            for (int i = 2; i <= 10; i += 2) {
                System.out.println("Even: " + i);
                Thread.sleep(100);
            }

            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
        }
    }
}

class OddNumberPrinter implements Runnable {
    @Override
    public void run() {
        try {
            System.out.println(Thread.currentThread().getName() + " started");

            for (int i = 1; i <= 9; i += 2) {
                System.out.println("Odd: " + i);
                Thread.sleep(100);
            }

            System.out.println(Thread.currentThread().getName() + " finished");
        } catch (InterruptedException e) {
            System.out.println(Thread.currentThread().getName() + " interrupted: " + e.getMessage());
        }
    }
}

class Pair<T, U> {
    private T first;
    private U second;

    public Pair(T first, U second) {
        this.first = first;
        this.second = second;
    }

    public T getFirst() {
        return first;
    }

    public void setFirst(T first) {
        this.first = first;
    }

    public U getSecond() {
        return second;
    }

    public void setSecond(U second) {
        this.second = second;
    }

    @Override
    public String toString() {
        return "(" + first + ", " + second + ")";
    }

    public static void runGenericPairExample() {
        System.out.println("\n Generics Example");
        Pair<String, Integer> person = new Pair<>("John", 30);
        System.out.println("Person: " + person);
        System.out.println("Name: " + person.getFirst());
        System.out.println("Age: " + person.getSecond());

        // Change values
        person.setFirst("Jane");
        person.setSecond(28);
        System.out.println("Updated person: " + person);

        // Double, Double pair
        Pair<Double, Double> coordinates = new Pair<>(10.5, 20.7);
        System.out.println("Coordinates: " + coordinates);

        // String, String pair
        Pair<String, String> dictionary = new Pair<>("apple", "a fruit");
        System.out.println("Dictionary entry: " + dictionary);
    }
}

class StreamsAndLambdas {
    public static void runStreamsExample() {
        System.out.println("\n Lambda Expressions and Streams Example");
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        System.out.println("Original list: " + numbers);

        List<Integer> evenNumbers = numbers.stream()
                .filter(n -> n % 2 == 0)
                .collect(Collectors.toList());
        System.out.println("Even numbers: " + evenNumbers);

        List<Integer> squaredNumbers = numbers.stream()
                .map(n -> n * n)
                .collect(Collectors.toList());
        System.out.println("Squared numbers: " + squaredNumbers);

        int sum = numbers.stream()
                .reduce(0, (a, b) -> a + b);
        System.out.println("Sum of all numbers: " + sum);

        int sumOfEvens = numbers.stream()
                .filter(n -> n % 2 == 0)
                .reduce(0, Integer::sum);
        System.out.println("Sum of even numbers: " + sumOfEvens);

        boolean allPositive = numbers.stream()
                .allMatch(n -> n > 0);
        System.out.println("Are all numbers positive? " + allPositive);

        int firstGreaterThan5 = numbers.stream()
                .filter(n -> n > 5)
                .findFirst()
                .orElse(-1);
        System.out.println("First number greater than 5: " + firstGreaterThan5);

        int maxValue = numbers.stream().mapToInt(Integer::intValue).max().getAsInt();
        int minValue = numbers.stream().mapToInt(Integer::intValue).min().getAsInt();
        double average = numbers.stream().mapToInt(Integer::intValue).average().getAsDouble();

        System.out.println("Max value: " + maxValue);
        System.out.println("Min value: " + minValue);
        System.out.println("Average: " + average);
    }
}


public class Introduction {
    public static void main(String[] args) {

        HelloWorld.runHelloWorld();
        PersonVariables.runPersonVariables();
        NumberCheck.runNumberCheck();
        NaturalNumbers.runNaturalNumbers();
        ArrayExample.runArrayExample();

        Student.runStudentExample();
        ShapeDemo.runShapeDemo();
        DivisionExceptionHandling.runDivisionExample();
        ArrayListDemo.runArrayListDemo();
        FileStatistics.runFileExample();
        EvenOddThreads.runThreadsExample();
        Pair.runGenericPairExample();
        StreamsAndLambdas.runStreamsExample();

    }
}