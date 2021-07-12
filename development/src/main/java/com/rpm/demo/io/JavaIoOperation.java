package com.rpm.demo.io;

import java.io.*;

/**
 * @Author Piming Ren
 * @Date 2021/3/3 9:34
 * @Version 1.0
 */
public class JavaIoOperation {





    /**
     * 读取键盘输入的方法
     *
     * @throws IOException
     */
    public static void keyInAndPrintConsole() throws IOException {
        PrintWriter out = null;
        BufferedReader br = null;
        try {
            System.out.println("请输入:");
            out = new PrintWriter(System.out, true);
            br = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            while ((line = br.readLine()) != null) {
                if (line.equals("exit")) {
                    System.exit(1);
                }
                out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            out.close();
            br.close();
        }
    }

    /**
     * 字节流读取文件
     *
     * @throws IOException
     */
    public static void readAndWriteByteToFile() throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            // 在try()中打开文件会在结尾自动关闭
            is = new FileInputStream("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application.yml");
            os = new FileOutputStream("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application-out.yml");
            byte[] buf = new byte[4];
            int hasRead = 0;
            while ((hasRead = is.read(buf)) > 0) {
                os.write(buf, 0, hasRead);
            }
            System.out.println("write success");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            os.close();
            is.close();
        }
    }

    /**
     * 在try() 中打开的文件， JVM会自动关闭
     * 字符流读取文件
     */

    public static void readAndWriteCharToFile() throws IOException {
        Reader reader = null;
        Writer writer = null;
        try {
            File readFile = new File("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application.yml");
            reader = new FileReader(readFile);
            File writeFile = new File("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application-out.yml");
            writer = new FileWriter(writeFile);
            char[] byteArray = new char[(int) readFile.length()];
            int size = reader.read(byteArray);
            System.out.println("大小:" + size + "个字符;内容:" + new String(byteArray));
            writer.write(byteArray);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
            writer.close();
        }
    }

    /**
     * StringReader 和StringWriter
     *
     * @throws IOException
     */
    public static void stringNode() throws IOException {
        StringReader sr = null;
        StringWriter sw = null;
        try {
            String str = "学习不刻苦 " + "不如卖红薯; ";
            char[] buf = new char[8];
            int hasRead = 0;
            // StringReader将以String字符串为节点读取数据
            sr = new StringReader(str);
            while ((hasRead = sr.read(buf)) > 0) {
                System.out.println(new String(buf, 0, hasRead));
            }
            // 由于String是一个不可变类，因此创建StringWriter时，实际上是以一个StringBuffer作为输出节点
            sw = new StringWriter();
            sw.write("黑夜给了我黑色的眼睛 ");
            sw.write("我却用它寻找光明 ");
            // toString()返回sw节点内的数据
            System.out.println(sw.toString());
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            sw.close();
            sr.close();
        }
    }

    /**
     * 字节流转换为字符流
     *
     * @throws IOException
     */
    public static void convertByteToChar() throws IOException {
        InputStream is = null;
        Reader reader = null;
        try {
            File file = new File("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application.yml");
            is = new FileInputStream(file);
            reader = new InputStreamReader(is, "gbk");
            char[] byteArray = new char[(int) file.length()];
            int size = reader.read(byteArray);
            System.out.println("大小:" + size + ";内容:" + new String(byteArray));
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            reader.close();
            is.close();
        }
    }

    /**
     * randomaccessfile
     *
     * @throws IOException
     */
    public static void randomAccessFileReadAndWrite() throws IOException {
        RandomAccessFile randomAccessFile = null;
        try {
            // 创建一个RandomAccessFile对象
            randomAccessFile = new RandomAccessFile("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application.yml", "rw");
            // 通过seek方法来移动指针
            randomAccessFile.seek(10);
            // 获取当前指针
            long pointerBegin = randomAccessFile.getFilePointer();
            // 从当前指针开始读
            byte[] contents = new byte[10];
            randomAccessFile.read(contents);
            long pointerEnd = randomAccessFile.getFilePointer();
            System.out.println("pointerBegin:" + pointerBegin + " " + "pointerEnd:" + pointerEnd + " " + new String(contents));
            randomAccessFile.seek(20);
            // 获取当前指针
            long begin = randomAccessFile.getFilePointer();
            randomAccessFile.write(contents);
            long end = randomAccessFile.getFilePointer();
            System.out.println("begin:" + begin + " " + "end:" + end + " ");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            randomAccessFile.close();
        }
    }

    /**
     * 管道流的使用
     *
     * @throws IOException
     */
    public static void piped() throws IOException {
        final PipedOutputStream output = new PipedOutputStream();
        final PipedInputStream input = new PipedInputStream(output);
        Thread thread1 = new Thread(() -> {
            try {
                output.write("Hello world, pipe!".getBytes());
            } catch (IOException e) {
            }
        });
        Thread thread2 = new Thread(() -> {
            try {
                int data = input.read();
                while (data != -1) {
                    System.out.print((char) data);
                    data = input.read();
                }
            } catch (IOException e) {
            } finally {
                try {
                    input.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        thread2.start();
    }

    /**
     * 多输入流合并
     * @throws IOException
     */
    public static void sequeue() throws IOException {
        FileInputStream fistream1 =null;
        FileInputStream fistream2 =null;
        SequenceInputStream sistream =null;
        FileOutputStream fostream =null;
        try {
            fistream1 = new FileInputStream("d:/A.txt");
            fistream2 = new FileInputStream("d:/B.txt");
            sistream = new SequenceInputStream(fistream1, fistream2);
            fostream = new FileOutputStream("d:/C.txt");
            int temp;
            while( ( temp = sistream.read() ) != -1) {
                System.out.print( (char) temp );
                fostream.write(temp);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            fostream.close();
            sistream.close();
            fistream1.close();
            fistream2.close();
        }
    }


    public static void pushback() throws FileNotFoundException, IOException {
        try (PushbackReader pr = new PushbackReader(new FileReader("D:\\workspace\\springcloudalibaba\\development\\src\\main\\resources\\application.yml"), 64)) {
            char[] buf = new char[32];
            String lastContent = "";
            int hasRead = 0;
            while ((hasRead = pr.read(buf)) > 0) {
                String content = new String(buf, 0, hasRead);
                int targetIndex = 0;
                if ((targetIndex = (lastContent + content).indexOf("-")) > 0) {
                    System.out.println(targetIndex);
                    //可以插入任意字符数组
                    pr.unread((lastContent + content).toCharArray());
                    if (targetIndex > 32) {
                        buf = new char[targetIndex];
                    }
                    pr.read(buf, 0, targetIndex);
                    System.out.println(new String(buf, 0, targetIndex));
                    System.out.println(new String(buf, targetIndex, buf.length-targetIndex));
                    System.exit(0);
                } else {
                    System.out.println(lastContent);
                    lastContent = content;
                }
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws IOException {

        pushback();

    }
}
