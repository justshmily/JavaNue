package txr.io.hash;

import java.io.*;
import java.util.*;

public class SpiteFile
{
    public static void main(String[] args)throws IOException
    {
        //splitDemo();//分割文件
        sequenceDemo();//合并文件
    }
    public static void sequenceDemo()throws IOException
    {
        FileInputStream fis = null;
        FileOutputStream fos = new FileOutputStream("lal.txt");
        ArrayList<FileInputStream> al = new ArrayList<FileInputStream>();//Vector效率低 
        int count = 0;
        File dir = new File("spite");//利用File遍历文件夹下的文件
        File[] files = dir.listFiles();
        for(int x=0;x<files.length;x++)
        {
            al.add(new FileInputStream(files[x]));
        }
        final Iterator<FileInputStream> it = al.iterator();//ArrayList本身没有枚举方法，通过迭代器来实现
        Enumeration<FileInputStream>  en= new Enumeration<FileInputStream>()//匿名内部类，复写枚举接口下的两个方法
        {
            public boolean hasMoreElements(){
                return it.hasNext();
            }
            public FileInputStream nextElement()
            {
                return it.next();
            }
            
        };
        SequenceInputStream sis = new SequenceInputStream(en);
        byte[] buf = new byte[1024*32];//定义1M的缓存区
        while((count=sis.read(buf))!=-1)
        {
            fos.write(buf,0,count);
        }
        sis.close();
        fos.close();
    }
    
    public static void splitDemo()throws IOException
    {
        FileInputStream fis = new FileInputStream("p.txt");
        FileOutputStream fos = null;//要在循环内部创建FileOutputStream对象
        byte[] buf = new byte[1024*32];//将文件分割成1M大小的碎片
        int len,count = 0;
        
        while((len=fis.read(buf))!=-1)
        {
            fos = new FileOutputStream("spite\\"+(count++)+".part");
            fos.write(buf,0,len);
            fos.flush();
            fos.close();
        }
        fis.close();
    }
}