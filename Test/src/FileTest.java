import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
 
public class FileTest {
 
  
   public static void main(String[] args) throws IOException {
     
      File srcFile=new File("C:\\Users\\hpj\\Desktop\\�½��ļ���");//��Ҫ���Ƶ��ļ���Դ·��
      File aimFile=new File("c:\\mydoc\\jpg");//���ƺ���ļ���Ŀ��·��
      String srcPath=srcFile.getAbsolutePath();//���Դ·��
      String aimPath=aimFile.getAbsolutePath();//���Ŀ��·��
      //ͼƬ������
      FilenameFilter filter=new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
           return (name.endsWith(".jpg")||name.endsWith(".png"));//����.jpg��.png��β���ļ����˳���
        }
      };
      //���˳����ļ�
      System.out.println(srcPath+"�´��ڵ�ͼƬ�У�");
      File[] str=srcFile.listFiles(filter);
      for(File i:str){
        System.out.println(i.getName());
      }
     
      for(int i=0;i<str.length;i++){
        File oldFile=new File(srcPath+"\\"+str[i].getName()); //��Ҫ���Ƶ��ļ�
        File newFile=new File(aimPath+"\\"+str[i].getName());//���ƺ���ļ�
        //����������
        DataInputStream dis=new DataInputStream(new FileInputStream(oldFile));
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(newFile));
       
        int temp;
        //��д����
        while((temp=dis.read())!=-1){//������
           dos.write(temp);//�Ѷ���������д�뵽Temp�ļ���
        }
        
        //�ر���
        dis.close();
        dos.close();
      }
      
      System.out.println("�ļ��Ѹ��Ƴɹ���");
   }
 
 
}