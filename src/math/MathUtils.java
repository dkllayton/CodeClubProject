package math;

public class MathUtils {
    public static float sqrt(float num) { return (float) Math.sqrt(num); }
    public static float pow(float base, int power) {
        if (power == 0)
            return 1;
        if (power < 0)
            return 1.0f / pow(base, -power);

        float answer = base;
        for (int i = 1;i < power;i++) {
            answer *= base;
        }
        return answer;
    }

    public static float sin(float theta, int terms) {
        theta %= 2 * Math.PI;
        if (terms > 0) {
            float answer = 0.0f;
            for (int n = 0; n < terms; n++) {
                float term = (MathUtils.pow(-1.0f, n) / factorial(2 * n + 1)) * pow(theta, 2 * n + 1);
                answer += term;
            }
            return answer;
        } else {
            throw new NumberFormatException("Cannot give " + terms + " terms of sin(" + theta + ")");
        }
    }

    public static float cos(float theta, int terms) {
        theta %= 2 * Math.PI;
        if (terms > 0) {
            float answer = 0.0f;
            for (int n = 0; n < terms; n++) {
                float term = (MathUtils.pow(-1.0f, n) / factorial(2 * n)) * pow(theta, 2 * n);
                answer += term;
            }
            return answer;
        } else {
            throw new NumberFormatException("Cannot give " + terms + " terms of cos(" + theta + ")");
        }
    }

    // TODO: Unoptimized solution, should replace with Maclauren series for tangent instead
    public static float tan(float theta, int digits) {
        if (cos(theta, digits) == 0)
            throw new NumberFormatException("Tangent is undefined at " + theta + ".");
        return sin(theta, digits) / cos(theta, digits);
    }

    public static long factorial(int num) {
        if (num < 0)
            throw new NumberFormatException("Factorial is undefined for negative values.");
        if (num == 0)
            return 1;
        long answer = num;
        for (int i = num - 1;i > 0;i--) {
            answer *= i;
        }
        return answer;
    }
}
