package Enums.com.pavel;

public class Main {
    public static void main(String[] args) {
        HttpMailHandler mail = new HttpMailHandler();

        int mailCode = 110;

        mail.handleHttpCode(mailCode);
    }
}
