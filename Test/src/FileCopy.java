import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class FileCopy {
	private static int a = 5;

	public static void main(String[] args) {
		// ��Ҫ���Ƶ�Ŀ���ļ���Ŀ���ļ���
		String pathname = "C:/Users/hpj/Desktop/2";
		File file = new File(pathname);
		// ���Ƶ���λ��
		String topathname = "C:/Users/hpj/Desktop/3";
		File toFile = new File(topathname);
		
		File[] file2 = file.listFiles();
		for(int i = 0;i<file2.length;i++) {
			File[] file3 = file2[i].listFiles();
			if(file3.length>80) {
				try {
					System.out.println(file2[i]+"�����С�����");
					copy(file2[i], toFile);
					System.out.println(file2[i]+"�������");
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

	public static void copy(File file, File toFile) throws Exception {
		byte[] b = new byte[1024];
		int a;
		FileInputStream fis;
		FileOutputStream fos;
		if (file.isDirectory()) {
			String filepath = file.getAbsolutePath();
			filepath = filepath.replaceAll("\\\\", "/");
			String toFilepath = toFile.getAbsolutePath();
			toFilepath = toFilepath.replaceAll("\\\\", "/");
			int lastIndexOf = filepath.lastIndexOf("/");
			toFilepath = toFilepath + filepath.substring(lastIndexOf, filepath.length());
			File copy = new File(toFilepath);
			// �����ļ���
			if (!copy.exists()) {
				copy.mkdir();
			}
			// �����ļ���
			for (File f : file.listFiles()) {
				copy(f, copy);
			}
		} else {
			if (toFile.isDirectory()) {
				String filepath = file.getAbsolutePath();
				filepath = filepath.replaceAll("\\\\", "/");
				String toFilepath = toFile.getAbsolutePath();
				toFilepath = toFilepath.replaceAll("\\\\", "/");
				int lastIndexOf = filepath.lastIndexOf("/");
				toFilepath = toFilepath + filepath.substring(lastIndexOf, filepath.length());

				// д�ļ�
				File newFile = new File(toFilepath);
				fis = new FileInputStream(file);
				fos = new FileOutputStream(newFile);
				while ((a = fis.read(b)) != -1) {
					fos.write(b, 0, a);
				}
			} else {
				// д�ļ�
				fis = new FileInputStream(file);
				fos = new FileOutputStream(toFile);
				while ((a = fis.read(b)) != -1) {
					fos.write(b, 0, a);
				}
			}

		}
	}

}