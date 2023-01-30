import javax.swing.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.Scanner;

public class PersonReader
{
    public static void main(String[] args)
    {

        JFileChooser chooser = new JFileChooser();
        Scanner inFile;
        String line;
        Path target = new File(System.getProperty("user.dir")).toPath();
        target = target.resolve("src");
        String Name = String.valueOf(target.getFileName());

        String heading1 = "ID|";
        String heading2 = "First Name|";
        String heading3 = "Last Name|";
        String heading4 = "Title|";
        String heading5 = "YOB";
        String divider = "====================================";

        String IDNum = "";
        String firstName = "";
        String lastName = "";
        String title = "";
        int YOB = 0;

        chooser.setCurrentDirectory(target.toFile());


        try
        {

            if(chooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION)
            {
                target = chooser.getSelectedFile().toPath();


                inFile = new Scanner(target);




                while (inFile.hasNextLine()) {
                    line = inFile.nextLine();



                    System.out.println(line);



                }
                System.out.printf("%s %s %s %s %d\n", IDNum, firstName,lastName, title, YOB);




                inFile.close();
            }
            else
            {
                System.out.println("Must select file, terminating now");
                System.exit(0);
            }

        }
        catch (IOException e)
        {
            System.out.println("File Not Found Error");
        }


    }
}
