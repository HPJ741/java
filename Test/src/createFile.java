import java.io.File;

public class createFile {
	public static void main(String args[]) {
		String rootFile = "C:\\Users\\hpj\\Desktop\\нд╪Ч╪п\\";
		File file = new File(rootFile);
		for(int i = 1;i<51;i++) {
			String n =  String.valueOf(i);
			String name = "e"+"_n"+n;
			File file2 = new File(rootFile+name);
			file2.mkdir();
		}
	}
}
