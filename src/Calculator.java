public class Calculator {
    int n;
    public double[][] inputMatrix = new double[21][22];
    double tmpX[] = new double[21];
    double roots[] = new double[21];
    double inaccuracy[] = new double[21];
    int r = 0;
    double k = 0;
    double accuracy = 0.0001;
    int iterationsCount = 0;
    public Calculator(int n, double[][] inputMatrix) {
        this.n = n;
        this.inputMatrix = inputMatrix;
    }

    public void getResul() {
        do {
            for (int i = 0; i < n; i++) {
                roots[i] = inputMatrix[i][n] / inputMatrix[i][i];//b
                for (int j = 0; j < n; j++) {
                    if (i != j) {
                        roots[i] -= inputMatrix[i][j] / inputMatrix[i][i] * tmpX[j];//(b-ax)/a
                        //roots[i] save x
                    }
                }
                inaccuracy[i] = Math.abs(roots[i]-tmpX[i] );
                r=i;
            }
            tmpX = roots.clone();
            iterationsCount++;
        }while (inaccuracy[r]>0.000078653480&&inaccuracy[r]<1*1000000000);
    }
        void printinaccuracy () {
            System.out.println("Error Analysis:" + inaccuracy[r]);
        }
        void printiterationsCount () {
            System.out.println("Number of iterations:" + iterationsCount);
        }
        void printMatrix ( double[][] matrix){
            System.out.println("System: printing matrix.");
            for (int i = 0; i < n; i++) {
                for (int j = 0; j <= n; j++) {
                    System.out.printf("%3.2f ", matrix[i][j]);
                }
                System.out.println();
            }
        }
        void printResult () {
            System.out.println("The result is: ");
            for (int i = 0; i < n; i++) {
                System.out.printf("%3.2f ", roots[i]);
            }
            System.out.println();
        }
        void error(){
            if (inaccuracy[r]>1*1000000000){
                System.out.println("The error is getting bigger and bigger,so there is no answer in this way");
            }
        }
    }


