//package com.jvm.topk;
//
//import spire.math.MergeSort;
//
//import java.io.*;
//import java.util.HashMap;
//import java.util.Random;
//
///**
// * @author dongyl
// * @date 18:44 6/7/18
// * @project study-demo
// */
//public class WriteFile {
//    private static final String ORIGINALPATH = "";
//
//    public static void generateDate() throws IOException {
//        BufferedWriter writer = new BufferedWriter(new FileWriter(ORIGINALPATH));
//        Random random = new Random();
//        StringBuffer buffer = new StringBuffer(
//                "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ");
//        int range = buffer.length();
//        int length = 1;
//        for (int i = 0; i < BIGDATALENGTH; i++) {
//            StringBuffer sb = new StringBuffer();
//            length = random.nextInt(20) + 1;
//            //System.out.println("length--->"+length);
//            for (int j = 0; j < length; j++) {
//                //System.out.println("j--->"+j);
//                sb.append(buffer.charAt(random.nextInt(range)));
//            }
//            System.out.println("sb---->" + sb);
//            writer.write(sb.toString() + "\n");
//        }
//        writer.close();
//    }
//    static File[] tempFiles;
//    /**
//     * 将原始数据分成几块 并排序 再保存到临时文件
//     *
//     * @throws IOException
//     */
//    public static void splitData() throws IOException {
//        @SuppressWarnings("resource")
//        BufferedReader br = new BufferedReader(new FileReader(ORIGINALPATH));
//        tempFiles = new File[BIGDATALENGTH / TEMPFILELENGTH];//将会产生的临时文件列表
//        for (int i = 0; i < tempFiles.length; i++) {
//            tempFiles[i] = new File(TEMPFILEPATH + "TempFile" + i + ".txt");
//            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFiles[i]));
//            HashMap<Integer, String> hashMap = new HashMap<Integer, String>();//未排序
//            //每次读出TEMPFILELENGTH个文件 保存到smallLine中
//            for (int j = 1; j <= TEMPFILELENGTH; j++) {
//                String text = null;
//                if ((text = br.readLine()) != null) {
//                    hashMap.put(j, text);
//                }
//            }
//            hashMap = MergeSort.sort(hashMap);
//            for (int k = 1; k <= TEMPFILELENGTH; k++) {
//                writer.write(String.valueOf(hashMap.get(k))
//                        + System.getProperty("line.separator"));
////System.getProperty("line.separator")相当于\n
//            }
//            writer.close();
//        }
//    }
//
//    /**
//     * 多路归并排序
//     *
//     * @param files
//     * @throws IOException
//     */
//    public static void multiWaysMergeSort(String[] files) throws IOException {
//        System.out.println("归并文件-----第 " + mergeSortCount + " 次-----");
//        //当最后只有一个文件的时候 数据已经排序成功 直接复制保存到结果文件
//        if (files.length == 1) {
//            String lastFilePath = LASTFILEPATH + LASTFILENAME;
//            copyFile(files[0], lastFilePath, false);
//            //deleteFile(files[0]);
//            return;
//        }
//        for (int i = 0; i < files.length; i += 2) {
////开始合并两个相邻的文件 所以一次跳两个
//            if (i == files.length - 1) {
////这时候已经只剩下最后一个文件了 不需要合并 本趟归并结束
//                renameFile(files[i], i);
//                break;
//            }
//            //将br1 和 br2 写入到Write
//            BufferedReader br1 = new BufferedReader(new FileReader(files[i]));
//            BufferedReader br2 = new BufferedReader(new FileReader(files[i + 1]));
//            BufferedWriter writer = new BufferedWriter(new FileWriter(TEMPFILEPATH + "last_" + mergeSortCount + "_" + i + ".txt"));
//            String s1 = br1.readLine();
//            String s2 = br2.readLine();
//            while (s1 != null || s2 != null) {
//                if (s1 != null && s2 != null) {
//                    //都不为空 才有比较的必要
//                    int mergeResult = s1.compareTo(s2);
//                    if (mergeResult > 0) {//s1在s2后面
//                        writer.write(s2);
//                        writer.write(System.getProperty("line.separator"));
//                        s2 = br2.readLine();
//                    }
//                    if (mergeResult == 0) {//s1=s2
//                        writer.write(s1);
//                        writer.write(System.getProperty("line.separator"));
//                        writer.write(s2);
//                        writer.write(System.getProperty("line.separator"));
//                        //System.out.println("write time : " + writeTime++);
//                        s1 = br1.readLine();
//                        s2 = br2.readLine();
//                    }
//                    if (mergeResult < 0) {//s1在s2前面
//                        writer.write(s1);
//                        writer.write(System.getProperty("line.separator"));
//                        s1 = br1.readLine();
//                    }
//                }
//                if (s1 == null && s2 != null) {
//                    writer.write(s2);
//                    writer.write(System.getProperty("line.separator"));
//                    s2 = br2.readLine();
//                }
//                if (s2 == null && s1 != null) {
//                    writer.write(s1);
//                    writer.write(System.getProperty("line.separator"));
//                    s1 = br1.readLine();
//                }
//            }
//            br1.close();
//            br2.close();
////          deleteFile(files[i]);
////          deleteFile(files[i + 1]);
//            writer.close();
//        }
//        mergeSortCount++;
//        multiWaysMergeSort(getTempFiles("last_" + (mergeSortCount - 1) + "_"));
//    }
//
//}
