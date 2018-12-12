import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class ImageCopy {

	public static void main(String args[]) {
		ImageCopy ImageCopy = new ImageCopy();
		//String FileName = ImageCopy.getClass().getResource("").getPath();
		String FileName = "C:\\Users\\hpj\\Desktop\\新建文件夹";
		File classpathRoot = new File(FileName);
		System.out.println(FileName);
		// FileName = classpathRoot.getAbsolutePath();
		// File file = new File(FileName);
		File[] file1 = classpathRoot.listFiles();
		for (int i = 0; i < file1.length; i++) {
			File fileImg = new File(file1[i].getAbsoluteFile(), "");
			if (fileImg.isDirectory()) {
				File[] file2 = fileImg.listFiles();
				for (int m = 0; m < file2.length; m++) {
					String extension = "";
					int n = file2[m].getName().lastIndexOf('.');
					if (n > 0) {
						extension = file2[m].getName().substring(n + 1);
					}
					if ("jpg".equals(extension) || "png".equals(extension)) {
						long size = file2[m].length() / 1024;
						System.out.println(size);
						//if (size > 100) {
							try {
								FileInputStream input = new FileInputStream(file2[m].getAbsoluteFile());
								FileOutputStream output = new FileOutputStream("F:\\1\\" + file2[m].getName());
								System.out.println(input);
								byte[] b = new byte[1024 * 5];
								int len;
								try {
									while ((len = input.read(b)) != -1) {
										output.write(b, 0, len);
									}
								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
								try {
									output.flush();
									output.close();
									input.close();

								} catch (IOException e) {
									// TODO Auto-generated catch block
									e.printStackTrace();
								}
							} catch (FileNotFoundException e) {
								// TODO Auto-generated catch block
								e.printStackTrace();
							}
						}

					}

				}
			}
		}
	}
//}
