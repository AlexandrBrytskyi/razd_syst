package lab2.lab2_2;

/**
 * Created with IntelliJ IDEA.
 * User: huyti
 * Date: 26.09.15
 * Time: 13:08
 * To change this template use File | Settings | File Templates.
 */
public class Customer {

    private int id;
    private String surname;
    private String name;
    private String fatherName;
    private String address;
    private String cardNum;
    private String bankNum;

    public Customer(int id, String surname, String name, String fatherName, String address, String cardNum, String bankNum) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.fatherName = fatherName;
        this.address = address;
        this.cardNum = cardNum;
        this.bankNum = bankNum;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public String getAddress() {
        return address;
    }

    public String getCardNum() {
        return cardNum;
    }

    public String getBankNum() {
        return bankNum;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", fatherName='" + fatherName + '\'' +
                ", address='" + address + '\'' +
                ", cardNum='" + cardNum + '\'' +
                ", bankNum='" + bankNum + '\'' +
                '}' + "\n";
    }
}
