public class Person {

    private final String firstName;
    private final String lastName;
    // exercise 8 new code
    private MoneyStorage moneyStorage;

    public Person(String firstName, String lastName) {
        // Wallet constructor

        this.firstName = firstName;
        this.lastName = lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
// new code exercise 8
    public void setMoneyStorage( MoneyStorage moneyStorage){
        this.moneyStorage = moneyStorage;
    }

    public String getFullName() {
        return String.format("%s %s", firstName, lastName);
    }
}
// exercise 8 new code
    public MoneyStorage getMoneyStorage(){
    return MoneyStorage;
    }
