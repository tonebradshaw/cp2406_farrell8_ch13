import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 * Created by tony on 17/09/2016.
 */
public class DebugThirteen4 {

    public static void main(String[] args){

        Scanner keyBoard = new Scanner(System.in);
        Path file = Paths.get("src\\DebugData4");
        String[] array;
        String string = "";
        String delimiter = ",";
        double searchPrice;
        boolean wasFound = false;

        try{
            InputStream input = new BufferedInputStream(Files.newInputStream(file));
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));

            System.out.println();
            System.out.print("Enter maximum price to search for >> ");
            searchPrice = keyBoard.nextDouble();
            System.out.println("\nEntrees no more than $" + searchPrice + "\n");
            string = reader.readLine();

            while(string != null){

                array = string.split(delimiter);

                if(searchPrice >= Double.parseDouble(array[1])){
                    wasFound = true;
                    System.out.println(array[0] + "  $" + array[1]);
                }
                string = reader.readLine();
            }
            if(!wasFound) {
                System.out.println("No entrees found under $" + searchPrice);
            }
            reader.close();
        }
        catch(Exception e){

            System.out.println("Message: " + e);
        }
    }
}
