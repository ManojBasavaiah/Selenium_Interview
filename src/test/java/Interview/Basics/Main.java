package Interview.Basics;

import Interview.Basics.locators;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        locators l = new locators();
        l.initialize();
        l.launch();
        l.close();
    }
}
