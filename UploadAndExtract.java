import java.io.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

/**
 * @author clap of thunder
 * @date 2023-10-27 9:17
 * @description
 */
public class UploadAndExtract {
    public static void main(String[] args) {
        File file = new File("C:\\Users\\15065170282\\Desktop\\著作权演示系统规则.zip");
        // 创建一个File对象，该对象引用名为"example.txt"的文件
        String dir = "D:\\QQ\\test";
        importAllAppRuleMsg(file,dir);

        String absolutePath = new File(UploadAndExtract.class.getResource("/").getPath()).getAbsolutePath();
        System.out.println("************当前路径\"+absolutePath+\"**************");
        String result = "";
        String searchStr = "/pisp";
        int index = absolutePath.indexOf(searchStr);
        if (index != -1) {
            result = absolutePath.substring(0, index + searchStr.length());
            System.out.println("*****************获取服务绝对路径*****************：" + result);

        } else {
            System.out.println("error");
        }
    }

    public static void importAllAppRuleMsg(File file,String dir){
        if (file.exists()) { // 检查文件是否存在
            String absolutePath = file.getAbsolutePath(); // 获取文件的绝对路径
            System.out.println("文件的绝对路径是: " + absolutePath);
        } else {
            System.out.println("文件不存在");
        }
        String fileName = file.getName();
        System.out.println("文件名为"+fileName);

//        String zipFilePath = file.getAbsolutePath(); // 替换为你的zip文件路径

        Date now = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmss"); // 选择你想要的日期时间格式
        String foldName = "folder_" + sdf.format(now);

        dir = dir + File.separator + foldName;
        System.out.println("生成文件目录名为" + dir);

        try {
            unzip(file, dir);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void unzip(File file, String destDirectory) throws IOException {
        File destDir = new File(destDirectory);
        if (!destDir.exists()) {
            destDir.mkdir();
        }
        FileInputStream fileInputStream = new FileInputStream(file);
        ZipInputStream zipIn = new ZipInputStream(fileInputStream);

        ZipEntry entry = zipIn.getNextEntry();
        while (entry != null) {
            String filePath = destDirectory + File.separator + entry.getName();
            if (!entry.isDirectory()) {
                extractFile(zipIn, filePath);
            } else {
                createDirectory(filePath);
            }
            zipIn.closeEntry();
            entry = zipIn.getNextEntry();
        }
        zipIn.close();
    }

    private static void extractFile(ZipInputStream zipIn, String filePath) throws IOException {
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream(filePath));
        byte[] bytesIn = new byte[4096];
        int read;
        while ((read = zipIn.read(bytesIn)) != -1) {
            bos.write(bytesIn, 0, read);
        }
        bos.close();
    }

    private static void createDirectory(String filePath) {
        File dir = new File(filePath);
        if (!dir.exists()) {
            dir.mkdir();
        }
    }
}
