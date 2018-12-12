package FileUtils;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.InputStream;
import java.io.PrintWriter;

public  class  FileUtils  {  
	   public  FileUtils()  {  
	   }  
	   public  void  newFolder(String  folderPath)  {  
	       try  {  
	           String  filePath  =  folderPath;  
	           filePath  =  filePath.toString();  
	           java.io.File  myFilePath  =  new  java.io.File(filePath);  
	           if  (!myFilePath.exists())  {  
	               myFilePath.mkdir();  
	           }  
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("新建目录操作出错");  
	           e.printStackTrace();  
	       }  
	   }  
	 

	   public  void  newFile(String  filePathAndName,  String  fileContent)  {  
	 
	       try  {  
	           String  filePath  =  filePathAndName;  
	           filePath  =  filePath.toString();  
	           File  myFilePath  =  new  File(filePath);  
	           if  (!myFilePath.exists())  {  
	               myFilePath.createNewFile();  
	           }  
	           FileWriter  resultFile  =  new  FileWriter(myFilePath);  
	           PrintWriter  myFile  =  new  PrintWriter(resultFile);  
	           String  strContent  =  fileContent;  
	           myFile.println(strContent);  
	           resultFile.close();  
	 
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("新建目录操作出错");  
	           e.printStackTrace();  
	 
	       }  
	 
	   }  
	 

	   public  void  delFile(String  filePathAndName)  {  
	       try  {  
	           String  filePath  =  filePathAndName;  
	           filePath  =  filePath.toString();  
	           java.io.File  myDelFile  =  new  java.io.File(filePath);  
	           myDelFile.delete();  
	 
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("删除文件操作出错");  
	           e.printStackTrace();  
	 
	       }  
	 
	   }  
	   public  void  delFolder(String  folderPath)  {  
	       try  {  
	           delAllFile(folderPath);  //删除完里面所有内容  
	           String  filePath  =  folderPath;  
	           filePath  =  filePath.toString();  
	           java.io.File  myFilePath  =  new  java.io.File(filePath);  
	           myFilePath.delete();  //删除空文件夹  
	 
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("删除文件夹操作出错");  
	           e.printStackTrace();  
	 
	       }  
	 
	   }  
	 
	   public  void  delAllFile(String  path)  {  
	       File  file  =  new  File(path);  
	       if  (!file.exists())  {  
	           return;  
	       }  
	       if  (!file.isDirectory())  {  
	           return;  
	       }  
	       String[]  tempList  =  file.list();  
	       File  temp  =  null;  
	       for  (int  i  =  0;  i  <  tempList.length;  i++)  {  
	           if  (path.endsWith(File.separator))  {  
	               temp  =  new  File(path  +  tempList[i]);  
	           }  
	           else  {  
	               temp  =  new  File(path  +  File.separator  +  tempList[i]);  
	           }  
	           if  (temp.isFile())  {  
	               temp.delete();  
	           }  
	           if  (temp.isDirectory())  {  
	               delAllFile(path+"/"+  tempList[i]);//先删除文件夹里面的文件  
	               delFolder(path+"/"+  tempList[i]);//再删除空文件夹  
	           }  
	       }  
	   }  
	 
	   
	
	   public  void  copyFile(String  oldPath,  String  newPath)  {  
	       try  {  
	           int  bytesum  =  0;  
	           int  byteread  =  0;  
	           File  oldfile  =  new  File(oldPath);  
	           if  (oldfile.exists())  {  //文件存在时  
	               InputStream  inStream  =  new  FileInputStream(oldPath);  //读入原文件  
	               FileOutputStream  fs  =  new  FileOutputStream(newPath);  
	               byte[]  buffer  =  new  byte[1444];  
	               int  length;  
	               while  (  (byteread  =  inStream.read(buffer))  !=  -1)  {  
	                   bytesum  +=  byteread;  //字节数  文件大小  
	                   System.out.println(bytesum);  
	                   fs.write(buffer,  0,  byteread);  
	               }  
	               inStream.close();  
	           }  
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("复制单个文件操作出错");  
	           e.printStackTrace();  
	 
	       }  
	 
	   }  
	 
	
	   public  void  copyFolder(String  oldPath,  String  newPath)  {  
	 
	       try  {  
	           (new  File(newPath)).mkdirs();  //如果文件夹不存在  则建立新文件夹  
	           File  a=new  File(oldPath);  
	           String[]  file=a.list();  
	           File  temp=null;  
	           for  (int  i  =  0;  i  <  file.length;  i++)  {  
	               if(oldPath.endsWith(File.separator)){  
	                   temp=new  File(oldPath+file[i]);  
	               }  
	               else{  
	                   temp=new  File(oldPath+File.separator+file[i]);  
	               }  
	 
	               if(temp.isFile()){  
	                   FileInputStream  input  =  new  FileInputStream(temp);  
	                   FileOutputStream  output  =  new  FileOutputStream(newPath  +  "/"  +  
	                           (temp.getName()).toString());  
	                   byte[]  b  =  new  byte[1024  *  5];  
	                   int  len;  
	                   while  (  (len  =  input.read(b))  !=  -1)  {  
	                       output.write(b,  0,  len);  
	                   }  
	                   output.flush();  
	                   output.close();  
	                   input.close();  
	               }  
	               if(temp.isDirectory()){//如果是子文件夹  
	                   copyFolder(oldPath+"/"+file[i],newPath+"/"+file[i]);  
	               }  
	           }  
	       }  
	       catch  (Exception  e)  {  
	           System.out.println("复制整个文件夹内容操作出错");  
	           e.printStackTrace();  
	 
	       }  
	 
	   }  
	 
	 
	   public  void  moveFile(String  oldPath,  String  newPath)  {  
	       copyFile(oldPath,  newPath);  
	       delFile(oldPath);  
	 
	   }  
	 
	  
	   public  void  moveFolder(String  oldPath,  String  newPath)  {  
	       copyFolder(oldPath,  newPath);  
	       delFolder(oldPath);  
	 
	   }  
	   
	   
	    public static void renameFiles(String dirPath,String prefix){
	        File file=new File(dirPath);
	        if(!file.isDirectory()){
	            return;
	        }
	        File files[]=file.listFiles();
	        int index=1;

	        for(File f:files){
	            File newFile=new File(dirPath,prefix+String.valueOf(index++)+".jpg");
	            f.renameTo(newFile);
	        }
	    }

	}

