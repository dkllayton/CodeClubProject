package math;

public class MathUtils {
    public static float sqrt(float num) { return (float) Math.sqrt(num); }
    public static float pow(float base, int power) {
        float answer = base;
        for (int i = 1;i < power;i++) {
            answer *= base;
        }
        return answer;
    }

    public static float sin(float theta, int digits) {
        if (digits > 0) {
            float answer = 0.0f;
            for (int n = 0; n < digits; n++) {
                answer += ((-1.0f * n) / factorial(2 * n + 1)) * pow(theta, 2 * n + 1);
            }
            return answer;
        } else {
            throw new NumberFormatException("Cannot give " + digits + " digits of sin(" + theta + ")");
        }
    }

    public static float cos(float theta, int digits) {
        if (digits > 0) {
            float answer = 0.0f;
            for (int n = 0; n < digits; n++) {
                answer += ((-1.0f * n) / factorial(2 * n)) * pow(theta, 2 * n);
            }
            return answer;
        } else {
            throw new NumberFormatException("Cannot give " + digits + " digits of sin(" + theta + ")");
        }
    }

    // TODO: Unoptimized solution, should replace with Maclauren series for tangent instead
    public static float tan(float theta, int digits) {
        return sin(theta, digits) / cos(theta, digits);
    }

    public static int factorial(int num) {
        int answer = num;
        for (int i = num - 1;i > 0;i--) {
            answer *= i;
        }
        return answer;
    }
}
