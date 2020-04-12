package com.kiki.comcom.utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.List;

/**
 * 
    * @ClassName: IOUtil
    * @Description: 流的工具类
    * @author lk
    * @date 2020年3月30日
    *
 */
public class IOUtil {

	/**
	 * 
	    * @Title: readFileToList
	    * @Description: 读取文件到list
	    * @param @param InputStream
	    * @param @return
	    * @param @throws IOException    参数
	    * @return List<String>    返回类型
	    * @throws
	 */
    public static List<String> readFileToList(InputStream InputStream) throws IOException{
    	
    	//声明集合
    	List<String> list = new ArrayList<String>();
    	BufferedReader reader = new BufferedReader(new InputStreamReader(InputStream));
    	String line="";
		while((line=reader.readLine())!=null) {
			list.add(line);
		}
		return list;
	}
	
	/**
	 * 
	    * @Title: readFileToList
	    * @Description: 读取文件到到list
	    * @param @param filePath
	    * @param @return
	    * @param @throws IOException    参数
	    * @return List<String>    返回类型
	    * @throws
	 */
	public static List<String> readFileToList(String filePath) throws IOException {
		// 声明集合
		FileInputStream inputStream = new FileInputStream(filePath);
		return readFileToList(inputStream);

	}

	/**
	 * 
	    * @Title: readFileToList
	    * @Description: 读取文件到到list
	    * @param @param filePath
	    * @param @return
	    * @param @throws IOException    参数
	    * @return List<String>    返回类型
	    * @throws
	 */
	public static List<String> readFileToList(File file) throws IOException {
		FileInputStream inputStream = new FileInputStream(file);
		return readFileToList(inputStream);

	}
	
	/**
	 * 
	    * @Title: fileCopy
	    * @Description: 文件复制
	    * @param @param 要复制的文件
	    * @param @param 复制到哪个文件
	    * @param @throws IOException    参数
	    * @return void    返回类型
	    * @throws
	 */
    public static void fileCopy(String srcFile,String tarFile)throws IOException{
        //创建文件对象
        File file=new File(srcFile);
        //创建FileInputStream的对象
        FileInputStream fis=new FileInputStream(srcFile);
        //创建FileOutputStream的对象
        FileOutputStream fos=new FileOutputStream(tarFile);
        //定义数组，数组的长度为文本文件长度
        byte[]b=new byte[(int)file.length()];
        //写出文件到tarFile文件
        while(true){
            int rtn=fis.read(b);
            System.out.println(rtn);
            if (rtn==-1){
                fos.close();
                fis.close();
                break;
            }else{
                fos.write(b);
            }
        }
    }

    /**
     * 
        * @Title: fileEncrypt
        * @Description: 文件加密
        * @param @param 需要进行加密的文件
        * @param @throws IOException    参数
        * @return void    返回类型
        * @throws
     */
    public static void fileEncrypt(String srcFile)throws IOException{
        RandomAccessFile rf=null;
        File file=new File(srcFile);
        //以读写方式打开文件
        rf=new RandomAccessFile(file,"rw");
        byte[]b=new byte[(int)file.length()];
        //读入文本io.txt的内容
        rf.read(b);
        //进行文本加密
        for (int i=0;i<b.length;i++){
            b[i]=(byte)(b[i]+12);
        }
        //将指针移到开头
        rf.seek(0);
        //写出内容到文本io.txt
        rf.write(b);
        rf.close();
    }

    /**
     * 
        * @Title: fileDecrypt
        * @Description: 文件解密
        * @param @param 需要进行解密的文件
        * @param @throws IOException    参数
        * @return void    返回类型
        * @throws
     */
    public static void fileDecrypt(String srcFile)throws IOException{
        RandomAccessFile rf=null;
        File file=new File(srcFile);
        rf=new RandomAccessFile(file,"rw");
        byte[]b=new byte[(int)file.length()];
        //读入文本io.txt的内容
        rf.read(b);
        //进行解密
        for (int i=0;i<b.length;i++){
            b[i]=(byte)(b[i]-12);
        }
        //设置指针到开头
        rf.seek(0);
        //写出内容到文本io.txt
        rf.write(b);
        rf.close();

    }

    /**
     * 
        * @Title: fileReadMultiLine
        * @Description: 读取文件中多行文本并解析为字符串数组返回
        * @param @param 多行文本的文件地址
        * @param @return
        * @param @throws IOException    参数
        * @return String[]    返回类型
        * @throws
     */
    public static String[] fileReadMultiLine(String srcFile)throws IOException{
        BufferedReader br1=new BufferedReader(new FileReader(srcFile));
        //记录文件有几行文本内容
        int line=0;
        //判断有多少行
        while (true){
            if (br1.readLine()!=null){
                //行数+1
                line++;
            }else{
                br1.close();
                break;
            }
        }

        BufferedReader br2=new BufferedReader(new FileReader(srcFile));
        //创建字符串数组
        String[] strs=new String[line];
        //赋值给字符串数组
        for (int i=0;i<strs.length;i++){
            strs[i]=br2.readLine();
        }
        br2.close();
        //返回字符串数组
        return strs;
    }

    //把一个字符串数组中的多个字符串分行写入文本文件
    public static void fileWriteMultiLine(String[] textArray,String tarFile)throws IOException{
        BufferedWriter bw=new BufferedWriter(new FileWriter(tarFile));
        //写出字符串数组的值
        for (int i=0;i<textArray.length;i++){
            bw.write(textArray[i]);
            if (i!=(textArray.length-1)){
                //转行
                bw.newLine();
            }
        }
        bw.close();
    }

    //把一个字符串追加到一个文本文件内容后
    public static void fileContentAppend(String text,String srcFile)throws IOException{
        RandomAccessFile rf=null;
        File file=new File(srcFile);
        rf=new RandomAccessFile(file,"rw");
        //把指针移到最后
        rf.seek(file.length());
        rf.writeBytes(text);
        rf.close();
    }

    //把一个字符串插入到一个文本文件内容前
    public static void fileContentPrepend(String text,String srcFile)throws IOException{
        //注意：用RandomAccessFile类把内容写入到文件里面会把原内容覆盖一部分，所以要先把原内容复制下来。
        File file=new File(srcFile);
        FileInputStream fis=new FileInputStream(file);
        byte[]b=new byte[(int)file.length()];
        fis.read(b);
        fis.close();

        RandomAccessFile rf=new RandomAccessFile(file,"rw");
        //把指针移到最前
        rf.seek(0);
        rf.writeBytes(text);
        rf.write(b);
        rf.close();
    }

    //复制文件内容并追加到源文件内容后
    public static void fileContentCopy(String srcFile)throws IOException{
        File file=new File(srcFile);
        RandomAccessFile rf=new RandomAccessFile(file,"rw");
        byte[] b=new byte[(int)file.length()];
        rf.read(b);;
        rf.seek(file.length());
        rf.write(b);
        rf.close();
    }

    //替换文本指定内容
    public static void fileContentReplace(String srcFile,String oldContent,String newContent)throws IOException{
        File file=new File(srcFile);
        FileReader reader=new FileReader(file);
        char[]c=new char[(int)file.length()];
        //读取文本内容
        reader.read(c);
        reader.close();
        //将文本内容转换为String类型
        String str=String.valueOf(c);
        //替换文本指定内容
        str=str.replaceAll(oldContent,newContent);
        FileWriter writer=new FileWriter(file);
        //将替换后的内容写入到文本文件
        writer.write(str);
        writer.close();
    }

    //强制删除一个文件(夹)(如果是文件夹，删除里面所有的内容)
    public static void fileDelete(String srcFile){
        File file=new File(srcFile);
        if (file.isFile()){                     //如果是普通文件直接删除
            if (file.delete()) System.out.println("文件"+file.getName()+"删除成功!");
            else System.out.println("文件"+file.getName()+"删除失败!");
        }else{                                  //如果是目录则要递归删除此目录下所有内容再删除此目录
            deleteDirectory(file);
        }
    }

    //删除目录方法
    public static void deleteDirectory(File file){
        //获取此目录下所有文件名(包括文件夹)
        String[] files=file.list();
        System.out.println(file.getName());
        if (files.length==0){           //判断此目录是否为空，若为空则可以直接删除
            if (file.delete()) System.out.println("目录"+file.getName()+"删除成功!");
            else System.out.println("目录"+file.getName()+"删除失败!");
        }else{                          //若不为空则要递归删除此目录下所有内容再删除此目录
            //遍历此目录下所有文件(包括文件夹)
            for (int i=0;i<files.length;i++){
                //要拼接路径，不然将只有文件名
                File f=new File(file.getAbsolutePath()+"/"+files[i]);
                if (f.isFile()){    //如果是普通文件直接删除
                    if (f.delete()) System.out.println("文件"+f.getName()+"删除成功!");
                    else System.out.println("文件"+f.getName()+"删除失败!");
                }else{              //如果是目录则要递归删除此目录下所有内容再删除此目录
                    deleteDirectory(f);
                }
            }
            //最后删除此目录
            deleteDirectory(file);
        }
    }
	 
}
