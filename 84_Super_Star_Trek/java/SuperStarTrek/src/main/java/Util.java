import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * Convenience utility methods for the Super Star Trek game.
 */
public class Util {

    final Random random = new Random();

    public float random() {
        return random.nextFloat();
    }

    public int fnr() {    // 475
        // Generate a random integer from 1 to 8 inclusive.
        return toInt(random() * 7 + 1);
    }

    public int toInt(final double num) {
        int x = (int) Math.floor(num);
        if (x < 0) {
            x *= -1;
        }
        return x;
    }

    public void println(final String s) {
        System.out.println(s);
    }

    public void print(final String s) {
        System.out.print(s);
    }

    public String tab(final int n) {
        return IntStream.range(1, n).mapToObj(num -> " ").collect(Collectors.joining());
    }

    public int strlen(final String s) {
        return s.length();
    }

    public String inputStr(final String message) {
        System.out.print(message + "? ");
        final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            return reader.readLine();
        } catch (IOException ioe) {
            ioe.printStackTrace();
            return "";
        }
    }

    public int[] inputCoords(final String message) {
        while (true) {
            final String input = inputStr(message);
            try {
                final String[] splitInput = input.split(",");
                if (splitInput.length == 2) {
                    int x = Integer.parseInt(splitInput[0]);
                    int y = Integer.parseInt(splitInput[0]);
                    return new int[]{x, y};
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public float inputFloat(final String message) {
        while (true) {
            System.out.print(message + "? ");
            final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                final String input = reader.readLine();
                if (input.length() > 0) {
                    return Float.parseFloat(input);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Returns the first three characters of the input string
     * @param input
     * @param len
     * @return
     */
    public String leftStr(final String input, final int len) {
        if (input == null || input.length() < len) {
            return input;
        }

        return input.substring(0, len);
    }

    public String midStr(final String input, final int start, final int len) {
        if (input == null || input.length() < ((start - 1) + len)) {
            return input;
        }
        return input.substring(start - 1, (start - 1) + len);
    }

    /**
     * TODO: Index out of bounds hit randomly, test to solve this
     *
     * @param input
     * @param len
     * @return
     */
    public String rightStr(final String input, final int len) {
        if (input == null || input.length() < len) {
            return "";
        }
        return input.substring(input.length() - len);
    }

    public double round(double value, int places) {
        if (places < 0) {
            throw new IllegalArgumentException();
        }
        BigDecimal bd = new BigDecimal(Double.toString(value));
        bd = bd.setScale(places, RoundingMode.HALF_UP);
        return bd.doubleValue();
    }


}
