
import java.io.*;

import FileUtils.FileUtils;

public class rename {
	/**
	 * public static void main(String[] args) { File file = new
	 * File("C:\\Users\\hpj\\Desktop\\����s2"); //File file = new File("F:\\����s2");
	 * File[] file2 = file.listFiles(); //ͼƬ�ļ��м��� for(int i = 0;i<file2.length;i++)
	 * { File[] file3 = file2[i].listFiles(); //��Ƭ�ļ����� int z = 1;
	 * System.out.println(file3.length+"---------------"+file2[i].getName()+"========"+i);
	 * for(int m=0;m<file3.length;m++) { String extension = ""; int n =
	 * file3[m].getName().lastIndexOf('.'); if (n > 0) { extension =
	 * file3[m].getName().substring(n + 1); } //file3[m].renameTo(new
	 * File(file2[i].getAbsolutePath()+"\\a"+z+"."+extension)); z = z+1;
	 * //System.out.println(file3[m].getName()+"�����ɹ���"); } } }
	 **/

	/**
	 * public static void main(String[] args) { for(int i=0;i<41;i++) { String b =
	 * String.valueOf(i);
	 * FileUtils.renameFiles("C:\\Users\\hpj\\Desktop\\����s2\\s_n"+b, "a"); }
	 * System.out.println("ִ�����");
	 * 
	 * }
	 **/

	public static void main(String[] args) { 
		//File file = new File("C:\\Users\\hpj\\Desktop\\����s2");
		File file = new File("F:\\4");
		File[] file2 = file.listFiles(); // ��Ŀ¼���� ����s3\... 
		//System.out.println(file2.length + "------------����s3��");
		int x;
		x = 1;
		int w;
		for (int i = 0; i < file2.length; i++) {
			File[] file3 = file2[i].listFiles(); // ����ͼƬ�ļ��м��� ����s3\s3_n61\... 
			//System.out.println(file2[i].getName() + "�ļ���" + file3.length + "------------����s3/...��");
			int countAll = 0;
			int countA = 0;
			int countB = 0;
			int countC = 0;
			int countD = 0;
			int countE = 0;
			int countF = 0;
			int countG = 0;
			w = x + 650;
			for (int m = 0; m < file3.length; m++) {
				int z = 1;
				File[] file4 = file3[m].listFiles(); // ����ͼƬ�ļ����� ����s3\s3_n61\a\... 
				//System.out.println(file3[m].getName() + "�ļ���" + file4.length + "------------����s3/sn/...��");
				for (int q = 0; q < file4.length; q++) { //
					//System.out.println(file4[q].getName());
					String extension = "";
					int n = file4[q].getName().lastIndexOf('.');
					if (n > 0) {
						extension = file4[q].getName().substring(n + 1);
					}
					if ("jpg".equals(extension) || "png".equals(extension) || "bmp".equals(extension)) {

					}
					file4[q].renameTo(
							new File(file2[i].getAbsolutePath() + "\\" + file3[m].getName() + z + "." + extension));
					z = z + 1;
					// System.out.println(file4[q].getName() + "�����ɹ���");

					countAll++;
					if (file3[m].getName().equals("a")) {
						countA++;
					}
					if (file3[m].getName().equals("b")) {
						countB++;
					}
					if (file3[m].getName().equals("c")) {
						countC++;
					}
					if (file3[m].getName().equals("d")) {
						countD++;
					}
					if (file3[m].getName().equals("e")) {
						countE++;
					}
					if (file3[m].getName().equals("F")) {
						countF++;
					}
					if (file3[m].getName().equals("g")) {
						countG++;
					}

				}		
			}
			System.out.println(countA + ";" + countB + ";" + countC + ";" + countD + ";" + countE + ";" + countF + ";" + countG);
			file2[i].renameTo(new File("F:\\�½��ļ���3\\"+"m"+w+"_n"+countAll));
			//System.out.println(w+"-------------"+x);
			x = x + 1;
		}
	}

	/**
	 * public static void main(String[] args) { File file = new File("F:\\���˲�ͬ����");
	 * File[] file2 = file.listFiles(); // ��Ŀ¼���� ����\... int q; q = 1;
	 * 
	 * for (int i = 0; i < file2.length; i++) { File[] file3 = file2[i].listFiles();
	 * // ����ͼƬ�ļ��м��� ����s3\s3_n61\... //
	 * System.out.println(file2[i].getName()+"�ļ���"+file3.length+"------------����s3/...��");
	 * int countAll = 0; int z; z = 1; int w; w = q + 300; for (int m = 0; m <
	 * file3.length; m++) { String extension = ""; int n =
	 * file3[m].getName().lastIndexOf('.'); if (n > 0) { extension =
	 * file3[m].getName().substring(n + 1); } if ("jpg".equals(extension) ||
	 * "png".equals(extension) || "bmp".equals(extension)) { countAll++;
	 * file3[m].renameTo( new File(file2[i].getAbsolutePath() + "\\pic" + z +"." +
	 * extension));
	 * 
	 * z = z+1; //System.out.println(q);
	 * System.out.println(file2[i].getAbsolutePath() + "\\pic" + z +"." +
	 * extension); System.out.println(file3[m].getName()+"�����ɹ�"); }
	 * 
	 * } System.out.println("F:\\�½��ļ���\\"+"m"+w+"_n"+countAll); File newFile = new
	 * File("F:\\�½��ļ���\\"+"m"+w+"_n"+countAll); file2[i].renameTo( new
	 * File("F:\\�½��ļ���\\"+"m"+w+"_n"+countAll)); q = q + 1;
	 * System.out.println(file2[i].getName()+":"+countAll); } }
	 **/

}
