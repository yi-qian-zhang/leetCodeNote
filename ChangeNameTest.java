import java.io.File;

/**
 * @author clap of thunder
 * @date 2023-11-03 15:36
 * @description
 */
public class ChangeNameTest {
    public static void main(String[] args) {
        String oldPath ="D:\\APP\\APP1";
//        String newPath ="D:\\APP\\APP1_BF";
        String newName = "著作系统";
        getDroolFile(oldPath,newName);

    }
    public static int getDroolFile(String oldPath,String newName){
        // 定义旧文件夹路径
        String oldFolderPath = oldPath;

        // 定义新文件夹路径 即入参newName

        // 创建File对象

        File oldFile = new File(oldFolderPath);
        String ParentAbsolutePath = oldFile.getParent();
        File newFile = new File(ParentAbsolutePath+"\\"+newName);

        // 检查旧文件夹是否存在
        if (oldFile.exists()) {
            // 使用renameTo()方法更改文件夹名称
            if (oldFile.renameTo(newFile)) {
                System.out.println("文件夹名称已成功更改。");
                return 1;
            } else {
                System.out.println("文件夹名称更改失败。");
                return 0;
            }
        } else {
            System.out.println("旧文件夹不存在。");
            return 0;
        }
    }
}
