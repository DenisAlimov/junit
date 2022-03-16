public class Contact {
    private String name;
    private String phoneNumber;

    @Override
    public String toString() {
        return "Имя: " + name + ", телефон: " + phoneNumber;
    }

    public String toString(String number) {
        return phoneNumber;
    }

    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        Contact other = (Contact) o;
        return name == other.name &&
                phoneNumber == other.phoneNumber;
    }
}