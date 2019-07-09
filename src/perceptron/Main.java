package perceptron;

import java.util.Random;

public class Main {

    public static void main(String[] args) {
        Random rand = new Random();
        // zbiór ucz¹cy
        int[] x = {-8, 4, 2, -6, -9, 5, -2, 1, 4, -6}; // p[0]
        int[] y = {20, 25, 20, -5, -10, 9, -10, -10, -16, -25}; // p[1]
        int[] t = {1, 1, 1, 1, 1, 0, 0, 0, 0, 0};

        // zbiór sprawdzaj¹cy
        int[] x2 = {5, 4, 2, 4, -6, -6};
        int[] y2 = {9, 25, 5, -25, 5, -25};
        int[] t2 = {0, 1, 1, 0, 1, 0};

        float w1 = rand.nextFloat(); // wartoœæ pocz¹tkowa wag wejœciowych X
        float w2 = rand.nextFloat(); // wartoœæ pocz¹tkowa wag wejœciowych Y
        float b = rand.nextFloat(); // przesuniêcie

        int result;
        int i = 0;
        int e;
        float a = 0;
        boolean change = false;

        do {
            change = false;
            i = 0;
            do {
                do {
                    a = (w1 * x[i]) + (w2 * y[i]) + b;
                    result = (a >= 0) ? 1 : 0;
                    e = t[i] - result;
                    System.out.printf("a = %f, w1 = %f, w2 = %f, wynikY[%d] = %d, e[%d] = %d\n", a, w1, w2, i, result, i, e);
                    if (e != 0) {
                        change = true;
                        w1 += e * x[i];
                        w2 += e * y[i];
                        b += e;
                        System.out.printf("Zmiana wagi!\n");
                    } else {
                        break;
                    }
                }
                while (true);
                i++;
            }
            while (i < x.length);
        }
        while (change == true);

        System.out.printf("FINA£: b = %f, w1 = %f, w2 = %f\n", b, w1, w2);
        i = 0;

        do {
            a = (w1 * x2[i]) + (w2 * y2[i]); // a = w1 x[i] + b; a = ((w1 x2[i]) + (w2 y2[i]));
            result = activationFunction(a);
            System.out.printf("X = %d, Y = %d, a = %f, aF = %d, zgadza siê? %s\n", x2[i], y2[i], a, result,
                    (result == t2[i]) ? "tak" : "nie");
        }
        while ((++i) < x2.length);
    }

    public static int activationFunction(float a) {
        return (a >= 0) ? 1 : 0;
    }

}
