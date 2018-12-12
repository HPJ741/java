import java.io.File;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
 
/**
 * 
 * @author {Mark Sir}
 * 
 *         2016-4-12
 */
public class replace {
    public static void main(String[] args) throws Exception {
        InputStream input = new FileInputStream(new File("C:\\Users\\hpj\\Desktop\\20181022_rgb_xml\\aiwinn_rgb_1022_0001.xml"));
        BufferedReader br = new BufferedReader(new InputStreamReader(input,"GBK"));
        File file = new File("E://output.txt");
        if (file.exists()) {
            file.delete();
        }
        BufferedWriter bos = new BufferedWriter(new OutputStreamWriter(
                new FileOutputStream(file), "GBK"));
        String tmp = null;
        StringBuffer sb = new StringBuffer();
        
        while ((tmp = br.readLine()) != null) {
            if (tmp.contains("aiwinn_rgb_1022_")) {
                // ¸ü¸Ä
                tmp.replace("aiwinn_rgb_1022_", "aiwinn_rgb_1024_");
            } else {
                sb.append(tmp);
            }
            //sb.append(",");
        }
 
        System.out.println(sb.toString());
 
        bos.write(sb.toString());
 
        bos.close();
        br.close();
        input.close();
 
        System.out.println("over");
    }
 
}// end
