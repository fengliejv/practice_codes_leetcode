package filetool.main;

import deploy.Deploy;
import filetool.util.FileUtil;
import filetool.util.LogUtil;

/**
 * 
 * �������
 * 
 * @version  [�汾��, 2017-1-9]
 * @see  [�����/����]
 * @since  [��Ʒ/ģ��汾]
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

        // ��ȡ�����ļ�
        String[] graphContent = FileUtil.read(graphFilePath, null);

        // ����ʵ�����
        String[] resultContents = Deploy.deployServer(graphContent);

        resultContents=new findMinestMain().main(graphContent);

        // д������ļ�
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
