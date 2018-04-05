package framework;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class EnteringReader {

    private static final String PATH_TO_ENTERING_FILE = "src/main/resources/Test.txt";

    private ArrayList<String> enteringList = getList();
    private ArrayList<String> parsedList = getCommand();

    public ArrayList<String> getEnteringList() {
        return enteringList;
    }

    public ArrayList<String> getParsedList() {
        return parsedList;
    }

    private ArrayList<String> getList() {
        ArrayList<String> list = new ArrayList<String>();
        try {
            FileReader reader = new FileReader(PATH_TO_ENTERING_FILE);
            Scanner scanner = new Scanner(reader);
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Чтение файла тестовой информации невозможно!");
        }
        return list;
    }

    private ArrayList<String> getCommand() {
        ArrayList<String> list = new ArrayList<String>();
        for (String item : enteringList) {
            {
                int a = item.indexOf("\"");
                list.add(item.substring(0, a - 1));
                int b = item.lastIndexOf("\"");
                String tmp = item.substring(a + 1, b);
                if (tmp.indexOf("\"") >= 0) {
                    int c = tmp.indexOf("\"");
                    int d = tmp.lastIndexOf("\"");
                    list.add(tmp.substring(0, c));
                    list.add(tmp.substring(d+1, tmp.length()));
                } else {
                    list.add(tmp);
                }
            }
        }
        return list;
    }
}

