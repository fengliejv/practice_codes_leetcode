package filetool.main;

import deploy.Deploy;
import filetool.util.FileUtil;
import filetool.util.LogUtil;

/**
 * 
 * 工具入口
 * 
 * @version  [版本号, 2017-1-9]
 * @see  [相关类/方法]
 * @since  [产品/模块版本]
 */
public class Main
{
    public static void main(String[] args)
    {
        if (args.length != 2)
        {
            args=new String[2];
            args[0]="/home/zhang/code/java/Hua/case_example/case0.txt";
            args[1]="/home/zhang/code/java/Hua/output/out";
//            System.err.println("please input args: graphFilePath, resultFilePath");
//            return;
        }

        String graphFilePath = args[0];
        String resultFilePath = args[1];

        LogUtil.printLog("Begin");

        // 读取输入文件
        String[] graphContent = FileUtil.read(graphFilePath, null);

        // 功能实现入口
        String[] resultContents = Deploy.deployServer(graphContent);

        resultContents=new findMinestMain().main(graphContent);

        // 写入输出文件
        if (hasResults(resultContents))
        {
            FileUtil.write(resultFilePath, resultContents, false);
        }
        else
        {
            FileUtil.write(resultFilePath, new String[] { "NA" }, false);
        }
        LogUtil.printLog("End");
    }
    
    private static boolean hasResults(String[] resultContents)
    {
        if(resultContents==null)
        {
            return false;
        }
        for (String contents : resultContents)
        {
            if (contents != null && !contents.trim().isEmpty())
            {
                return true;
            }
        }
        return false;
    }

}
