import java.util.Scanner;

class CalcQuad {
    protected String str;
    protected int n;
    protected CalcQuad(String str) {
        this.str = str;
        this.n = str.length();
    }

    void calc_it() {
        int a = 1, b = 0;
        int c = get_val(n);
        for (int i = (n-1); i >= 0; i--) {
            if (Character.isLetter(str.charAt(i))) {
                if (b == 0) {
                    b = get_val(i);
                }
                else {
                    a = get_val(i);
                }
            }
        }

        System.out.println("First root: " + pos_quad(a, b, c));
        System.out.println("Second root: " + neg_quad(a, b, c));
    }

    double pos_quad(int a, int b, int c) {
        double det = Math.pow(b, 2) - (4 * a * c);
        if (det < 0) {
            System.out.print("Root is imaginary ");
            return -1;
        }
        double result = (b * -1) + Math.sqrt(det);
        result = result / (2 * a);
        return result;
    }

    double neg_quad(int a, int b, int c) {
        double det = Math.pow(b, 2) - (4 * a * c);
        if (det < 0) {
            System.out.print("Root is imaginary ");
            return -1;
        }
        double result = (b * -1) - Math.sqrt(det);
        result = result / (2 * a);
        return result;
    }

    int get_val(int n) {
        int i = (n-1), x = 0;
        int num = 0;
        while ((i >= 0) && (!Character.isLetter(str.charAt(i)))) {
            if (Character.isDigit(str.charAt(i))) {
                num = (Character.getNumericValue(str.charAt(i)) * (int)Math.pow(10, x)) + num;
                ++x;
            }
            else if (str.charAt(i) == '+' || str.charAt(i) == '-') {
                if (num == 0) {
                    num = 1;
                }
                if (str.charAt(i) == '-') {
                    num *= -1;
                }
                return num;
            }
            --i;
        }
        if (num == 0) {
            return 1;
        }
        return num;
    }
}


public class MyQuad {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter the equation in the form: ax+by+c");
        String str = input.nextLine();
        CalcQuad ob = new CalcQuad(str);
        ob.calc_it();
        input.close();
    }
}
