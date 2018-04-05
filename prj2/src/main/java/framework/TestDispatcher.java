package framework;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

public class TestDispatcher {
    private static final String PASS_TO_RESULT_FILE = "src/main/resources/result.txt";

    public void startTests() {

        int count = 0;
        int passed = 0;
        int failed = 0;
        double totalTime = 0;
        StringBuffer stringBuffer = new StringBuffer();
        URLChecker urlChecker = new URLChecker();
        EnteringReader reader = new EnteringReader();
        ArrayList<String> parsedList = reader.getParsedList();
        for (int i = 0; i < parsedList.size(); i++) {

            if (parsedList.get(i).equals("open")) {
                long start = System.currentTimeMillis();
                if (urlChecker.openUrl(parsedList.get(i + 1), Integer.parseInt(parsedList.get(i + 2)))) {
                    passed++;
                    stringBuffer.append("+ [open " + "\"" + parsedList.get(i + 1) + "\"" + "  " + "\"" + parsedList.get(i + 2) + "\"" + "] ");
                } else {
                    failed++;
                    stringBuffer.append("! [open " + "\"" + parsedList.get(i + 1) + "\"" + "  " + "\"" + parsedList.get(i + 2) + "\"" + "] ");
                }
                long finish = System.currentTimeMillis();
                double time = finish - start;
                totalTime = totalTime + time;
                stringBuffer.append(time / 1000 + "\n");
                i = i + 2;
                count++;
            }

            if (parsedList.get(i).equals("checkLinkPresentByHref")) {
                long start = System.currentTimeMillis();
                if (urlChecker.checkLinkPresentByHref(parsedList.get(i + 1))) {
                    passed++;
                    stringBuffer.append("+ [checkLinkPresentByHref " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                } else {
                    failed++;
                    stringBuffer.append("! [checkLinkPresentByHref " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                }
                long finish = System.currentTimeMillis();
                double time = finish - start;
                totalTime = totalTime + time;
                stringBuffer.append(time / 1000 + "\n");
                i = i + 1;
                count++;
            }

            if (parsedList.get(i).equals("checkLinkPresentByName")) {
                long start = System.currentTimeMillis();
                if (urlChecker.checkLinkPresentByName(parsedList.get(i + 1))) {
                    passed++;
                    stringBuffer.append("+ [checkLinkPresentByName " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                } else {
                    failed++;
                    stringBuffer.append("! [checkLinkPresentByName " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                }
                long finish = System.currentTimeMillis();
                double time = finish - start;
                totalTime = totalTime + time;
                stringBuffer.append(time / 1000 + "\n");
                i = i + 1;
                count++;
            }

            if (parsedList.get(i).equals("checkPageTitle")) {
                long start = System.currentTimeMillis();
                if (urlChecker.checkPageTitle(parsedList.get(i + 1))) {
                    passed++;
                    stringBuffer.append("+ [checkPageTitle " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                } else {
                    failed++;
                    stringBuffer.append("! [checkPageTitle " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                }
                long finish = System.currentTimeMillis();
                double time = finish - start;
                totalTime = totalTime + time;
                stringBuffer.append(time / 1000 + "\n");
                i = i + 1;
                count++;
            }

            if (parsedList.get(i).equals("checkPageContains")) {
                long start = System.currentTimeMillis();
                if (urlChecker.checkPageContains(parsedList.get(i + 1))) {
                    passed++;
                    stringBuffer.append("+ [checkPageContains " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                } else {
                    failed++;
                    stringBuffer.append("! [checkPageContains " + "\"" + parsedList.get(i + 1) + "\"" + "] ");
                }
                long finish = System.currentTimeMillis();
                double time = finish - start;
                totalTime = totalTime + time;
                stringBuffer.append(time / 1000 + "\n");
                i = i + 1;
                count++;
            }
        }

        stringBuffer.append("Total tests: " + count + "\n");
        stringBuffer.append("Passed/Failed: " + passed + "/" + failed + "\n");
        stringBuffer.append("Total time: " + totalTime / 1000 + "\n");
        stringBuffer.append("Average time: " + (totalTime / count) / 1000 + "\n");

        try (FileOutputStream oS = new FileOutputStream(new File(PASS_TO_RESULT_FILE))) {
            oS.write(0000);
            oS.write(stringBuffer.toString().getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
