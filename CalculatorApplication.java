import java.util.Scanner;

class Calculator {
        public int add(int a, int b) {
            return a + b;
        }
        public double add(double a, double b) {
            return a + b;
        }
        public int add(int a, int b, int c) {
            return a + b + c;
        }
        public int subtract(int a, int b) {
            return a - b;
        }
        public double multiply(double a, double b) {
            return a * b;
        }
        public double divide(int a, int b) {
            try {
                if (b == 0) {
                    throw new ArithmeticException("Cannot divide by zero!");
                }
                return (double) a / b;
            } catch (ArithmeticException e) {
                System.out.println(e.getMessage());
                return 0;
            }
        }
    }
    public class CalculatorApplication {

        private static Scanner sc = new Scanner(System.in);
        private static Calculator calc = new Calculator();

        public static void performAddition() {
            System.out.println("\n--- Addition ---");
            System.out.println("1. Add two integers");
            System.out.println("2. Add two doubles");
            System.out.println("3. Add three integers");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter first integer: ");
                    int a1 = sc.nextInt();
                    System.out.print("Enter second integer: ");
                    int b1 = sc.nextInt();
                    System.out.println("Result: " + calc.add(a1, b1));
                    break;

                case 2:
                    System.out.print("Enter first double: ");
                    double a2 = sc.nextDouble();
                    System.out.print("Enter second double: ");
                    double b2 = sc.nextDouble();
                    System.out.println("Result: " + calc.add(a2, b2));
                    break;

                case 3:
                    System.out.print("Enter first integer: ");
                    int a3 = sc.nextInt();
                    System.out.print("Enter second integer: ");
                    int b3 = sc.nextInt();
                    System.out.print("Enter third integer: ");
                    int c3 = sc.nextInt();
                    System.out.println("Result: " + calc.add(a3, b3, c3));
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        }

        public static void performSubtraction() {
            System.out.println("\n--- Subtraction ---");
            System.out.print("Enter first number: ");
            int a = sc.nextInt();
            System.out.print("Enter second number: ");
            int b = sc.nextInt();
            System.out.println("Result: " + calc.subtract(a, b));
        }

        public static void performMultiplication() {
            System.out.println("\n--- Multiplication ---");
            System.out.print("Enter first double: ");
            double a = sc.nextDouble();
            System.out.print("Enter second double: ");
            double b = sc.nextDouble();
            System.out.println("Result: " + calc.multiply(a, b));
        }

        public static void performDivision() {
            System.out.println("\n--- Division ---");
            System.out.print("Enter numerator: ");
            int a = sc.nextInt();
            System.out.print("Enter denominator: ");
            int b = sc.nextInt();
            System.out.println("Result: " + calc.divide(a, b));
        }

        public static void mainMenu() {
            int choice;
            do {
                System.out.println("\n============================");
                System.out.println(" Welcome to the Calculator! ");
                System.out.println("============================");
                System.out.println("1. Add Numbers");
                System.out.println("2. Subtract Numbers");
                System.out.println("3. Multiply Numbers");
                System.out.println("4. Divide Numbers");
                System.out.println("5. Exit");
                System.out.print("Enter your choice: ");
                choice = sc.nextInt();

                switch (choice) {
                    case 1:
                        performAddition();
                        break;
                    case 2:
                        performSubtraction();
                        break;
                    case 3:
                        performMultiplication();
                        break;
                    case 4:
                        performDivision();
                        break;
                    case 5:
                        System.out.println("Exiting... Thank you for using the Calculator!");
                        break;
                    default:
                        System.out.println("Invalid choice! Please try again.");
                }
            } while (choice != 5);
        }

        public static void main(String[] args) {
            mainMenu();
        }
    }


