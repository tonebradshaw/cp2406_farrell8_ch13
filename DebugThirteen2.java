import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Created by tony on 16/09/2016.
 */
public class DebugThirteen2 {

    public static void main(String[] args)
    {
        Path fileIn = Paths.get("src/DebugData3");
        Path fileOut = Paths.get("src/DebugData5");

        String areaCode = "(312) ";
        String phone = null;
        InputStream input = null;
        OutputStream output;

        try{

            input = Files.newInputStream(fileIn);
            BufferedReader reader = new BufferedReader(new InputStreamReader(input));
            output = Files.newOutputStream(fileOut);
            phone = reader.readLine();

            while(phone != null){

                phone = areaCode + phone + System.getProperty("line.separator");
                byte[] phoneBytes = phone.getBytes();
                output.write(phoneBytes);
                phone = reader.readLine();
            }
            input.close();
        }
        catch (IOException e){

            System.out.println(e);
        }
    }
}
