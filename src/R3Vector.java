class R3Vector {
    private double[][] resultVector = new double[2][3];
    private double[] result = new double[2];

    void sumVector(double[][] vectorOne, double[][] vectorTwo) {
        countSumVector(vectorOne, vectorTwo);
        arrEnumeration(resultVector);
    }

    void diffVector(double[][] vectorOne, double[][] vectorTwo) {
        countDiffVector(vectorOne, vectorTwo);
        arrEnumeration(resultVector);
    }

    void multiplyVectorByNumber(double[][] vector, double number) {
        countMultiplyVectorByNumber(vector, number);
        arrEnumeration(resultVector);
    }

    void scalarParamVectors(double[][] vectorOne, double[][] vectorTwo) {
        countScalarParamVectors(vectorOne, vectorTwo);
        arrEnumeration(result);
    }

    void vectorProduct(double[][] vectorOne, double[][] vectorTwo) {
        countVectorProduct(vectorOne, vectorTwo);
        arrEnumeration(resultVector);
    }

    void mixedProductVectors(double[][] vectorOne, double[][] vectorTwo, double[][] vectorThree) {
        countMixedProductVectors(vectorOne, vectorTwo, vectorThree);
        arrEnumeration(result);
    }

    private void countSumVector(double[][] vectorOne, double[][] vectorTwo) {
        arrZeroing(resultVector);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                resultVector[i][j] = vectorOne[i][j] + vectorTwo[i][j];
            }
        }
    }

    private void countDiffVector(double[][] vectorOne, double[][] vectorTwo) {
        arrZeroing(resultVector);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                resultVector[i][j] = vectorOne[i][j] - vectorTwo[i][j];
            }
        }
    }

    private void countMultiplyVectorByNumber(double[][] vector, double number) {
        arrZeroing(resultVector);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                resultVector[i][j] = vector[i][j] * number;
            }
        }
    }

    private void countScalarParamVectors(double[][] vectorOne, double[][] vectorTwo) {
        arrZeroing(result);
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                result[i] += vectorOne[i][j] * vectorTwo[i][j];
            }
        }
    }

    private void countVectorProduct(double[][] vectorOne, double[][] vectorTwo) {
        arrZeroing(resultVector);
        for (int i = 0; i < 2; i++) {
            resultVector[i][0] = vectorOne[i][1] * vectorTwo[i][2] - vectorOne[i][2] * vectorTwo[i][1];
            resultVector[i][1] = - (vectorOne[i][0] * vectorTwo[i][2] - vectorOne[i][2] * vectorTwo[i][0]);
            resultVector[i][2] = vectorOne[i][0] * vectorTwo[i][1] - vectorOne[i][1] * vectorTwo[i][0];
        }
    }

    private void countMixedProductVectors(double[][] vectorOne, double[][] vectorTwo, double[][] vectorThee) {
        countVectorProduct(vectorOne, vectorTwo);
        countScalarParamVectors(resultVector, vectorThee);
    }

    private void arrEnumeration(double[][] resultVector) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Точка " + (i + 1) + " (x, y, z): ");
            for (int j = 0; j < 3; j++) {
                System.out.print(resultVector[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void arrEnumeration(double[] result) {
        for (int i = 0; i < 2; i++) {
            System.out.println("Точка " + (i + 1) + " (x, y, z):\n" + result[i]);
        }
        System.out.println();
    }

    private void arrZeroing(double[][] resultVector) {
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                resultVector[i][j] = 0;
            }
        }
    }

    private void arrZeroing(double[] result) {
        for (int i = 0; i < 2; i++) {
            result[i] = 0;
        }
    }
}