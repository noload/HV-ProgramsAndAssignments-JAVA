import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class unique {
    public static Map<String, Integer> hm 
            = new HashMap<String, Integer>(); 
    public static void main(String[] args) {

        try {
            FileReader file = new FileReader("MainDir\\text5.txt");
            BufferedReader br = new BufferedReader(file);
            String line;
            // br.readLine();

            while ((line = br.readLine()) != null) {
                String[] Data = line.split(" ");
                for(String data:Data){
                   hm.put(line, null);
                }            

            }
            br.close();
        } catch (Exception e) {
            e.getMessage();
        }
    }
}
