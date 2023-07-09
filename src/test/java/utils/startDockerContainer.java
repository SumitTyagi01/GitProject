package utils;

import org.testng.Assert;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Calendar;

public class startDockerContainer {

    public void startFile() throws IOException, InterruptedException {
        File file=new File("output.txt");
        if(file.delete()){
            System.out.println("File is deleted successfully!!");
        }

        boolean flag = false;
        Runtime runtime = Runtime.getRuntime();
        runtime.exec("cmd /c start dockerUp.bat");

        Thread.sleep(4000);
        String f = System.getProperty("user.dir")+"//output.txt";

        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.SECOND, 45);
        long stopnow = cal.getTimeInMillis();

        while (System.currentTimeMillis() < stopnow) {

            if(flag){

                break;
            }

            BufferedReader reader = new BufferedReader(new FileReader(f));
            String currentLine = reader.readLine();

            while (currentLine != null && !flag) {

                if (currentLine.contains("Node has been added")) {
                    System.out.println("found my text!!");
                    flag = true;
                    break;
                }
                currentLine = reader.readLine();
            }
            reader.close();

        }
        Assert.assertTrue(flag);
        runtime.exec("cmd /c start scale.bat");
        Thread.sleep(15000);
    }

}
