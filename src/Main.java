import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

import static java.nio.file.StandardOpenOption.CREATE;

public class Main {
    public static void main(String[] args) {
        ArrayList<Person> folks = new ArrayList<>();



        File workingDirectory = new File(System.getProperty("user.dir"));
        Path file = Paths.get(workingDirectory.getPath() + "\\src\\person1Data.txt");




        Person kaylee = new Person("kaylee", "tincher", "ms.", 2002);
        System.out.println(kaylee);
        folks.add(kaylee);

        Person donna = new Person("donna", "combs", "ms.", 1996);
        System.out.println(donna);
        folks.add(donna);

        Person kyria = new Person("kyria", "anderson", "ms.", 2003);
        System.out.println(kyria);
        folks.add(kyria);

        Person jerilyn = new Person("jerilyn", "scherier", "ms.", 1997);
        System.out.println(jerilyn);
        folks.add(jerilyn);

        for (Person p : folks)
            System.out.println(p);

        try
        {
            // Typical java pattern of inherited classes
            // we wrap a BufferedWriter around a lower level BufferedOutputStream
            OutputStream out =
                    new BufferedOutputStream(Files.newOutputStream(file, CREATE));
            BufferedWriter writer =
                    new BufferedWriter(new OutputStreamWriter(out));

            // Finally can write the file LOL!

            for(Person rec : folks)
            {

                writer.newLine();  // adds the new line

            }
            writer.close(); // must close the file to seal it and flush buffer
            System.out.println("Data file written!");
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }




    }

    }


