package com.wshop.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;
import java.util.Enumeration;

import org.apache.tools.zip.ZipEntry;
import org.apache.tools.zip.ZipFile;
import org.apache.tools.zip.ZipOutputStream;

/**
 * 文件压缩及解压工具类
 * maven 引入:
 * <dependency>
 * <groupId>org.apache.ant</groupId>
 * <artifactId>ant</artifactId>
 * <version>1.9.7</version>
 * </dependency>
 */
@SuppressWarnings("all")
public class ZipHelper {

    private static Logger logger = LoggerFactory.getLogger(ZipHelper.class);


    /**
     * 递归压缩目录和文件
     *
     * @param source 源路径,可以是文件,也可以目录
     * @param target 目标路径,压缩文件名
     */
    public static void compress(String source, String target) {
        compress(new File(source), new File(target));
    }

    /**
     * 递归压缩目录和文件
     *
     * @param source 源路径,可以是文件,也可以目录
     * @param target 目标路径,压缩文件名
     */
    public static void compress(File source, String target) {
        compress(source, new File(target));
    }

    /**
     * 递归压缩目录和文件
     *
     * @param source 源路径,可以是文件,也可以目录
     * @param target 目标路径,压缩文件名
     */
    public static void compress(File source, File target) {
        try {
            if (source.isFile() || source.isDirectory()) //若是文件和目录则处理
            {
                ZipOutputStream zipOut = new ZipOutputStream(new BufferedOutputStream(new FileOutputStream(target)));
                String rootPath = (source.isFile()) ? source.getParent() : source.getPath();
                rootPath = (rootPath == null) ? "" : rootPath;
                compressFile(rootPath, source, target.getPath(), zipOut);
                zipOut.close();
            }
        } catch (IOException ex) {
            logger.error("", ex);
        }
    }

    /**
     * 压缩文件
     *
     * @param rootPath 压缩根路径
     * @param srcFile  源文件
     * @param targetFilePath 输出文件路径(仅用于生成的压缩文件在同目录时剔除文件本身的问题)
     * @param zipOut   输出 zip 文件
     * @throws IOException IO错误
     */
    private static void compressFile(String rootPath, File srcFile, String targetFilePath, ZipOutputStream zipOut) throws IOException {
        String tempPath = rootPath.replace("\\", "/");

        String storePath = srcFile.toString().replace("\\", "/");
        if (storePath.startsWith(tempPath)) {
            storePath = storePath.substring(tempPath.length());
            if (storePath.startsWith("/")) //去掉最前面的目录符号
            {
                storePath = storePath.substring(1);
            }
        }


        if (srcFile.isFile()) { //若是文件

            // 压缩文件本身需要剔除
            if (srcFile.getPath().equals(targetFilePath)) {
                return;
            }

            int readedBytes;
            byte[] buffer = new byte[4096];

            FileInputStream inStream = new FileInputStream(srcFile);
            zipOut.putNextEntry(new ZipEntry(storePath));
            while ((readedBytes = inStream.read(buffer)) > 0) {
                zipOut.write(buffer, 0, readedBytes);
            }
            inStream.close();
            zipOut.closeEntry();
        } else if (srcFile.isDirectory()) { //若是目录

            File[] files = srcFile.listFiles();
            if (null == files || files.length == 0) { //若目录中没有文件
                zipOut.putNextEntry(new ZipEntry(storePath + "/"));
                zipOut.closeEntry();
            } else {
                for (File file : files) {
                    compressFile(rootPath, file, targetFilePath, zipOut);
                }
            }
        }
    }

    /**
     * 解压特定的文件
     *
     * @param source 源文件
     * @param target 目标路径
     */
    public static void decompress(String source, String target) {
        int readedBytes;
        byte[] buffer = new byte[4096];

        try {
            File srcFile = new File(source);
            if (srcFile.isFile()) {
                ZipFile zipFile = new ZipFile(source);

                for (Enumeration entries = zipFile.getEntries(); entries.hasMoreElements(); ) {
                    ZipEntry entry = (ZipEntry) entries.nextElement();
                    File file = new File(target + "/" + entry.getName());

                    if (entry.isDirectory()) {
                        file.mkdirs();
                    } else {
                        //如果指定文件的目录不存在,则创建之.
                        File parent = file.getParentFile();
                        if (!parent.exists()) {
                            parent.mkdirs();
                        }

                        InputStream inputStream = zipFile.getInputStream(entry);
                        FileOutputStream outStream = new FileOutputStream(file);
                        while ((readedBytes = inputStream.read(buffer)) > 0) {
                            outStream.write(buffer, 0, readedBytes);
                        }
                        outStream.close();
                        inputStream.close();
                    }
                }
                zipFile.close();
            }
        } catch (IOException ex) {
            logger.error("", ex);
        }
    }

    public static void main(String[] args) throws Exception {
        //ZipHelper.compress("F:/base","F:/base.zip");
        //ZipHelper.compress("F:/111.txt","F:/111.zip");
        //ZipHelper.decompress("F:/base.zip","F:/base");
    }
}
