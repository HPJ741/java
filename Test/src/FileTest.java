import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
 
public class FileTest {
 
  
   public static void main(String[] args) throws IOException {
     
      File srcFile=new File("C:\\Users\\hpj\\Desktop\\新建文件夹");//需要复制的文件的源路径
      File aimFile=new File("c:\\mydoc\\jpg");//复制后的文件的目标路径
      String srcPath=srcFile.getAbsolutePath();//获得源路径
      String aimPath=aimFile.getAbsolutePath();//获得目标路径
      //图片过滤器
      FilenameFilter filter=new FilenameFilter() {
        @Override
        public boolean accept(File dir, String name) {
           return (name.endsWith(".jpg")||name.endsWith(".png"));//把以.jpg和.png结尾的文件过滤出来
        }
      };
      //过滤出的文件
      System.out.println(srcPath+"下存在的图片有：");
      File[] str=srcFile.listFiles(filter);
      for(File i:str){
        System.out.println(i.getName());
      }
     
      for(int i=0;i<str.length;i++){
        File oldFile=new File(srcPath+"\\"+str[i].getName()); //需要复制的文件
        File newFile=new File(aimPath+"\\"+str[i].getName());//复制后的文件
        //创建流对象
        DataInputStream dis=new DataInputStream(new FileInputStream(oldFile));
        DataOutputStream dos=new DataOutputStream(new FileOutputStream(newFile));
       
        int temp;
        //读写数据
        while((temp=dis.read())!=-1){//读数据
           dos.write(temp);//把读到的数据写入到Temp文件中
        }
        
        //关闭流
        dis.close();
        dos.close();
      }
      
      System.out.println("文件已复制成功！");
   }
 
 
}