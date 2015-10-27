package lab2.lab2_2;

import java.math.BigInteger;
import java.util.*;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 26.09.15
 * Time: 13:14
 * To change this template use File | Settings | File Templates.
 */
public class CustomerTest {

    private static Set<Customer> customers = new TreeSet<Customer>(new Comparator<Customer>() {
        @Override
        public int compare(Customer o1, Customer o2) {
            if (o1.getSurname().charAt(0) == o2.getSurname().charAt(0)) {
                int i = 0;
                while (o1.getSurname().charAt(i) == o2.getSurname().charAt(i)) {
                    i++;
                    if (i == o1.getSurname().length() || i == o2.getSurname().length()) return 0;
                    if (o1.getSurname().charAt(i) > o2.getSurname().charAt(i)) return 1;
                    if (o1.getSurname().charAt(i) < o2.getSurname().charAt(i)) return -1;
                }
            } else {
                if (o1.getSurname().charAt(0) > o2.getSurname().charAt(0)) return 1;
                if (o1.getSurname().charAt(0) < o2.getSurname().charAt(0)) return -1;
            }
            return 0;
        }
    });

    public static void main(String[] args) {
        customers.add(new Customer(1, "Brytskyi", "Olexandr", "Viacheslavovich", "Kyiv", "4149437885858585", "aa44444444444"));
        customers.add(new Customer(2, "Alokara", "Petro", "sergiyovich", "Talianki", "7445437885858585", "bb44444444444"));
        customers.add(new Customer(3, "Pupkin", "Vasil", "Olegovich", "Vishnia", "6445748585858542", "bb44444444444"));
        customers.add(new Customer(4, "Murkin", "Vasil", "Olegovich", "Vishnia", "3445748585858542", "bb44444444444"));
        customers.add(new Customer(5, "Mashkin", "Vasil", "Olegovich", "Vishnia", "4445748585858542", "bb44444444444"));
        customers.add(new Customer(6, "Kupkin", "Vasil", "Olegovich", "Vishnia", "8545748585858542", "bb44444444444"));
        customers.add(new Customer(7, "Lupkin", "Vasil", "Olegovich", "Vishnia", "7775748585858542", "bb44444444444"));
        customers.add(new Customer(8, "Mamamam", "Vasil", "Olegovich", "Vishnia", "2845748585858542", "bb44444444444"));

        System.out.println("Vivedemo vidsortovaniy masiv");
        System.out.println(customers.toString());
        System.out.println();
        System.out.println();
        System.out.println("Vvedit interval");
        Scanner s = new Scanner(System .in );
//        String aa =
//        String bb =
        BigInteger a = new BigInteger(s.nextLine());
        BigInteger b = new BigInteger(s.nextLine());
        System.out.println("Vivedemo vsih, chii karti v diapazoni <" + a + "--" + b + ">");
        for (Customer c : customers) {
            if (a.compareTo(BigInteger.valueOf(Long.valueOf(c.getCardNum()))) < 0 &&
                    b.compareTo(BigInteger.valueOf(Long.valueOf(c.getCardNum()))) > 0) {
                System.out.print(c);
            }
        }

    }

}
