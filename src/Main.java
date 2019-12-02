import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    private static Scanner scanner = new Scanner(System.in);
    private static R3Vector r3Vector = new R3Vector();
    private static double[][] vectorOne = new double[2][3];
    private static double[][] vectorTwo = new double[2][3];
    private static double[][] vectorThree = new double[2][3];
    private static double number;
    private static int numberOperation;

    public static void main(String[] args) {
        VectorsStart();
    }

    private static void VectorsStart() {
        try {
            do {
                welcome();
                inputNumOfOperation();
                operations();
            } while (true);
        } catch (InputMismatchException e) {
            System.out.println("Ошибка ввода. Что-то пошло не так.");
        }
    }

    private static void welcome() {
        System.out.println("1. Сумма векторов");
        System.out.println("2. Разность векторов");
        System.out.println("3. Умножение вектора на число");
        System.out.println("4. Скалярное произведение векторов");
        System.out.println("5. Векторное произведение векторов");
        System.out.println("6. Смешанное произведение векторов");
        System.out.println("Введите номер операции");
    }

    private static void inputNumOfOperation() {
        numberOperation = scanner.nextInt();
    }

    private static void operations() {
        switch (numberOperation) {
            case 1 : {
                inputRequestVectors(vectorOne, vectorTwo);
                r3Vector.sumVector(vectorOne, vectorTwo);
                break;
            }
            case 2 : {
                inputRequestVectors(vectorOne, vectorTwo);
                r3Vector.diffVector(vectorOne, vectorTwo);
                break;
            }
            case 3 : {
                inputRequestVectors(vectorOne);
                inputNumber();
                r3Vector.multiplyVectorByNumber(vectorOne, number);
                break;
            }
            case 4 : {
                inputRequestVectors(vectorOne, vectorTwo);
                r3Vector.scalarParamVectors(vectorOne, vectorTwo);
                break;
            }
            case 5 : {
                inputRequestVectors(vectorOne, vectorTwo);
                r3Vector.vectorProduct(vectorOne, vectorTwo);
                break;
            }
            case 6 : {
                inputRequestVectors(vectorOne, vectorTwo, vectorThree);
                r3Vector.mixedProductVectors(vectorOne, vectorTwo, vectorThree);
                break;
            }
            default:
                System.out.println("Нет такого номера операции\n");
        }
    }

    private static void inputRequestVectors(double[][] vectorOne) {
        System.out.println("Введите первый вектор");
        inputVector(vectorOne);
    }

    private static void inputRequestVectors(double[][] vectorOne, double[][] vectorTwo) {
        inputRequestVectors(vectorOne);
        System.out.println("Введите второй вектор");
        inputVector(vectorTwo);
    }

    private static void inputRequestVectors(double[][] vectorOne, double[][] vectorTwo, double[][] vectorThree) {
        inputRequestVectors(vectorOne, vectorTwo);
        System.out.println("Введите третий вектор");
        inputVector(vectorThree);
    }

    private static void inputVector(double[][] vector) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                vector[i][j] = scanner.nextDouble();
            }
        }
    }

    private static void inputNumber() {
        System.out.println("Введите число");
        number = scanner.nextDouble();
    }
}