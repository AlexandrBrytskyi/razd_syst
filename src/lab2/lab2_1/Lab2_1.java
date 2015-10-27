package lab2.lab2_1;

/**
 * Created with IntelliJ IDEA.
 * User: Brytskyi
 * Date: 16.09.15
 * Time: 11:10
 * To change this template use File | Settings | File Templates.
 */
public class Lab2_1 {
    static String text = "papuha";

    public void print(String text) {
        for (char a : text.toCharArray()) {
            System.out.print(a + "   ");
        }
        System.out.println();
        for (char a : text.toCharArray()) {
            System.out.print((Character.getNumericValue(a)-9)+ "  ");
        }
    }

    public static void main(String[] args) {
        Lab2_1 lab2_1 = new Lab2_1();
        lab2_1.print(text);
    }

}
