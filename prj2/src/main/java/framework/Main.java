package framework;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {
        TestDispatcher testDispatcher = new TestDispatcher();
        testDispatcher.startTests();
    }
}
