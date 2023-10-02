import java.io.FileWriter;
import java.util.Scanner;

public class DataRequest {

    private String lastName;
    private String firstName;
    private String middleName;
    private String yearOfBirth;
    private long numberPhone;
    private char gender;
    private Scanner scan = new Scanner(System.in);


    private void EnterLastName() {
        System.out.println("Введите Фамилию:");
        lastName = scan.nextLine();
        if (lastName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterFirstName() {
        System.out.println("Введите Имя");
        firstName = scan.nextLine();
        if (firstName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterMiddleName() {
        System.out.println("Введите отчество");
        middleName = scan.nextLine();
        if (middleName.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterYearOfBirth() {
        System.out.println("Укажите дату рождения в формате ДД.ММ.ГГГГ:");
        yearOfBirth = scan.nextLine();
        if (yearOfBirth.equals("")) {
            throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
        }
    }

    private void EnterNumberPhone() {
        try {
            System.out.println("Введите номер телефона в целочисленном формате:");
            String number = scan.nextLine();
            if (number.equals("")) {
                throw new RuntimeException("Вводимое значение не может быть пустым,\nпопробуйте снова!");
            }
            numberPhone = Long.parseLong(number);
        } catch (NumberFormatException e) {
            System.out.println("NumberFormatException: Не верный формат, попробуйте снова!");
        }
    }

    private void EnterGender() {
        System.out.println("Введите пол (f, m):");
        String gen;
        String f = "f";
        String m = "m";
        gen = scan.nextLine();
        if (gen.length() > 1) {
            throw new RuntimeException("Вы ввели слишком много символов \nпопробуйте снова!");
        }
        if (gen.equals(f) || gen.equals(m)) {
            gender = gen.charAt(0);
        } else {
            throw new RuntimeException("Вы ввели не тот символ!");
        }
    }


    private void OutPutData() {
        System.out.println("\nФамилия \t- \t" + lastName + "\n" + "Имя \t- \t" + firstName + "\n" + "Отчество \t- \t" + middleName + "\n" + "Дата рождения \t- \t" + yearOfBirth + "\n" + "Номер телефона \t- \t" + numberPhone + "\n" + "Пол   \t- \t" + gender);
    }


    private void DataEnter() {
        EnterLastName();
        EnterFirstName();
        EnterMiddleName();
        EnterYearOfBirth();
        EnterNumberPhone();
        EnterGender();
        OutPutData();
    }


    public void SaveDataEnter() {

        DataEnter();
        String file = lastName + ".txt";
        try (FileWriter fileWriter = new FileWriter(file, true)) {
            fileWriter.write("<" + lastName + "> " + "<" + firstName + "> " + "<" + middleName + "> " + "<" + yearOfBirth + "> " + "<" + numberPhone + "> " + "<" + gender + ">\n");
        } catch (Exception e) {
            System.out.println("Что-то пошло не так!");
        }
    }


    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public String getYearOfBirth() {
        return yearOfBirth;
    }

    public long getNumberPhone() {
        return numberPhone;
    }

    public char getGender() {
        return gender;
    }
}
