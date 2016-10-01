import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created by tony on 16/09/2016.
 */
public class DebugThirteen1 {

    public static void main(String[] args)
    {
        Path file1 = Paths.get("src/DebugData1");
        Path file2 = Paths.get("src/DebugData2");
        System.out.println(file1.getFileName());

        try{

            BasicFileAttributes attr1 = Files.readAttributes(file1, BasicFileAttributes.class);

            System.out.println("File: " + file1.getFileName());
            System.out.println("Creation time " + attr1.creationTime());
            System.out.println("Last modified time " + attr1.lastModifiedTime());
            System.out.println("Size " + attr1.size());

            BasicFileAttributes attr2 = Files.readAttributes(file2, BasicFileAttributes.class);
            System.out.println("\nFile: " + file2.getFileName());
            System.out.println("Creation time " + attr2.creationTime());
            System.out.println("Last modified time " + attr2.lastModifiedTime());
            System.out.println("Size " + attr2.size());

            if(attr1.creationTime().compareTo(attr2.creationTime()) > 0) {
                System.out.println("\n" + file1.getFileName() + " was created earlier");
            }else{
                System.out.println("\n" + file1.getFileName() + " was not created earlier");
            }if(attr1.size() > attr2.size()) {
                    System.out.println(file1.getFileName() + " is larger ");
            }else{
                System.out.println(file1.getFileName() + " is not larger");
            }
        }
        catch(IOException e)
        {
            System.out.println("IO Exception");
        }
    }
}
