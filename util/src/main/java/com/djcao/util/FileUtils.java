package com.djcao.util;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.apache.commons.lang3.StringUtils;

/**
 * @author djcao
 * @workcode BG389966
 * @date 2020/10/15
 */
public class FileUtils {
    /**
     * 多文件合并行级别去重
     * @param files
     * @return
     * @throws FileNotFoundException
     */
    public static Set<String> unqFiles(List<String> files) throws IOException {
        Set<String> fileSets = new HashSet<>();
        for (int i = 0; i < files.size(); i++) {
            Set<String> strings = unqFile(files.get(i));
            fileSets.addAll(strings);
        }
        return fileSets;
    }

    /**
     * 单文件去重
     * @param file
     * @return
     * @throws FileNotFoundException
     */
    public static Set<String> unqFile(String file) throws IOException {
        BufferedReader bufferedReader = getBufferedReader(file);
        Set<String> collect = bufferedReader.lines().filter(StringUtils::isNotBlank)
            .collect(Collectors.toSet());
        return collect;
    }

    /**
     * 把集合按行写入文件
     * @param files
     * @param path path will be delete and create new
     * @throws IOException
     */
    public static void write2File(Collection<String> files,String path) throws IOException {
        File file = new File(path);
        if (file.exists()) {
            file.delete();
        }
        BufferedWriter bufferedWriter = getBufferedWriter(path);
        for (String s : files) {
            bufferedWriter.write(s,0,s.length());
            bufferedWriter.newLine();
        }
        bufferedWriter.flush();
        bufferedWriter.close();
    }

    /**
     * file sets removeAll file sets mainFile sets
     * @param mainFileName
     * @param fileName
     * @return
     * @throws IOException
     */
    public static Set<String> fileNotExistAtMain(String mainFileName,String fileName) throws IOException {
        Set<String> mainFileNameSet = unqFile(mainFileName);
        Set<String> fileNameSet = unqFile(fileName);
        fileNameSet.removeAll(mainFileNameSet);
        return mainFileNameSet;
    }

    private static BufferedWriter getBufferedWriter(String file) throws IOException {
        FileWriter fileWriter = new FileWriter(file);
        return new BufferedWriter(fileWriter);
    }

    private static BufferedReader getBufferedReader(String file) throws IOException {
        FileReader fileReader = new FileReader(file);
        return new BufferedReader(fileReader);
    }

    public static void test1() throws IOException {
        List<String> strings = new ArrayList<>();
        strings.add("C:\\Users\\bg389966\\Desktop\\影响单号.txt");
        write2File(unqFiles(strings),"C:\\Users\\bg389966\\Desktop\\影响单号去重后.txt");
    }
    public static void main(String[] args) throws IOException {
        //test1();
        List<String> strings = new ArrayList<>();
        strings.add("C:\\Users\\bg389966\\Desktop\\xxx.txt");
        write2File(unqFiles(strings),"C:\\Users\\bg389966\\Desktop\\影响单号去重后.txt");
    }
}
