import java.io.File;
import java.io.FileWriter;
import java.util.Scanner;

public class FileHandling
{
    public static void main(String[] arg)
    {
        String ch;
        File file;
        String loc;
        String data;
        FileWriter fw;
        do {

            try
            {
                System.out.println("Enter file location : ");
                loc = new Scanner(System.in).nextLine();
                file = new File(loc);
                if (file.createNewFile())
                {
                    System.out.println("File "+file.getName()+" is created");
                    System.out.println("Write some data into the file : ");
                    data = new Scanner(System.in).nextLine();
                    fw = new FileWriter(file);
                    fw.write(data);
                    fw.close();
                    System.out.println("Data has been added into "+file.getName());
                }
                else
                {
                    System.out.println("File already exists \nReading from file.....");
                    Scanner scanner = new Scanner(file);
                    while (scanner.hasNext())
                    {
                        data = scanner.nextLine();
                        System.out.println(data);
                    }
                    System.out.print("Do you want to add data at the end of the file yes/no : ");
                    ch = new Scanner(System.in).next();
                    if (ch.equals("yes"))
                    {
                        System.out.println("Enter data : ");
                        data = new Scanner(System.in).nextLine();
                        fw = new FileWriter(file,true);
                        fw.append(data);
                        fw.close();
                        System.out.println("Data has been appended Successfully ! ");
                    }

                }
            }
            catch (Exception e)
            {
                System.out.println("Some exception has been occurred");
            }

            System.out.println("Continue : Y/exit");
            ch = new Scanner(System.in).next();
        }while (!ch.equals("exit"));
    }
}
