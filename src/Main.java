import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args)
    {
        JFileChooser chooser = new JFileChooser();
        File selectedFile;
        int lineNum = 0;
        String line = "";
        int wordNum = 0;
        int charNum = 0;

        try {
            File workingDirectory = new File(System.getProperty("user.dir"));

            chooser.setCurrentDirectory(workingDirectory);

            if (chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                selectedFile = chooser.getSelectedFile();
                Path file = selectedFile.toPath();

                InputStream in =
                        new BufferedInputStream(Files.newInputStream(file, CREATE));
                BufferedReader reader =
                        new BufferedReader(new InputStreamReader(in));
                while (reader.ready()) {
                    line = reader.readLine();
                    String words[]=line.split(" ");
                    charNum = charNum + line.length();
                    wordNum =wordNum + words.length;
                    lineNum = lineNum + 1;

                }
                reader.close();

                System.out.println("The total number of lines are " + lineNum);
                System.out.println("The total number of words are " + wordNum);
                System.out.println("The total number of characters are " + charNum);

                System.out.println("\n\nData file read!");


            } else
            {
                System.out.println("No file selected!!! ... exiting.\nRun the program again and select a file.");
            }
        }
        catch (FileNotFoundException e)
        {
            System.out.println("File not found!!!");
            e.printStackTrace();
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }







        }
}