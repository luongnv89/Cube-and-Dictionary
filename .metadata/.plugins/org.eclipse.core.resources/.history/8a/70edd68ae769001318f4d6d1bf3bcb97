package csc5021.mapreduce;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.util.Progressable;

import csc5021.interfaces.HasInvariant;
import csc5021.objects.Feature;

import java.io.*;
import java.net.URI;
import java.util.ArrayList;

/**
 * Created by luongnv89 on 13/12/13.
 */
public class ShareMemory implements HasInvariant {

    public static void setup(String hdfsURL, String dicPath, String cubePath, Configuration conf) {
        String randomName = String.valueOf(System.currentTimeMillis());
        Utils.writeToFile("\nRandom name: "+randomName);
        setDataName(randomName);
//        ShareMemory.setRESULT_PATH("log_" + randomName + ".txt");
        Utils.writeToFile("\nLog file: "+ShareMemory.getRESULT_PATH());

        Utils.writeToFile("\nRoot HDFS: "+hdfsURL);
        ShareMemory.setRootHDFS(hdfsURL);

        ShareMemory.setDicPath(dicPath);
        Utils.writeToFile("\nDictionary path: " + ShareMemory.getDicPath());

        ShareMemory.setCubePath(cubePath);
        Utils.writeToFile("\nCube path: " + ShareMemory.getCubePath());

        ShareMemory.setDataHDFS(hdfsURL + "/data_" + randomName);
        Utils.writeToFile("\nData path: " + ShareMemory.getDataHDFS());

        ShareMemory.setConf(conf);

        loadDictionary();

        getCubeSizeInfor();

        calculateFeatures();

        splitCube();
    }

    private static void splitCube() {
        while (ShareMemory.getListFeatures().size() > 0) {
            Feature currentFeature = ShareMemory.getListFeatures().get(0);
            extractFeature(currentFeature);
            ShareMemory.getListFeatures().remove(0);
        }
    }

    private static String RESULT_PATH;

    public static String getRESULT_PATH() {
        return RESULT_PATH;
    }

    private static String dataName;

    public static String getDataName() {
        return dataName;
    }

    public static void setDataName(String dataName) {
        ShareMemory.dataName = dataName;
    }

    private static String rootHDFS;

    private static String dataHDFS;

    private static String dicPath;

    private static Configuration conf;

    private static ArrayList<String> listWords = new ArrayList<String>();
    private static ArrayList<Feature> listFeatures = new ArrayList<Feature>();
    private static int cubeSize;
    private static int dicSize;
    private static int wordLength;

    public static Configuration getConf() {
        return conf;
    }

    public static void setConf(Configuration conf) {
        ShareMemory.conf = conf;
    }

    public static String getRootHDFS() {
        return rootHDFS;
    }

    public static void setRootHDFS(String rootHDFS) {
        ShareMemory.rootHDFS = rootHDFS;
    }

    public static String getDataHDFS() {
        return dataHDFS;
    }

    public static void setDataHDFS(String dataHDFS) {
        ShareMemory.dataHDFS = dataHDFS;
    }

    public static String getDicPath() {
        return dicPath;
    }

    public static void setDicPath(String dicPath) {
        ShareMemory.dicPath = dicPath;
    }

    public static String getCubePath() {
        return cubePath;
    }

    public static void setCubePath(String cubePath) {
        ShareMemory.cubePath = cubePath;
    }

    private static String cubePath;


    public static void setRESULT_PATH(String RESULT_PATH) {
        ShareMemory.RESULT_PATH = RESULT_PATH;
    }

    public static ArrayList<String> getListWords() {
        return listWords;
    }

    public static void addWords(String word) {
        listWords.add(word);
    }

    public static boolean isAssocciated() {
        return listWords.size() == 0;
    }



    private static void calculateFeatures() {
        Utils.writeToFile("\nCalculate the features of cube: ");
        listFeatures.clear();
        //OXY,
        for(int z=0;z<cubeSize;z++){
            listFeatures.add(new Feature(Feature.OXY,z));
        }

        //OZX
        for(int y=0;y<cubeSize;y++){
            listFeatures.add(new Feature(Feature.OZX,y));
        }

        //OYZ
        for(int x=0;x<cubeSize;x++){
            listFeatures.add(new Feature(Feature.OYZ,x));
        }

        //ABQR
        for(int delta = wordLength;delta<cubeSize;delta++){
            listFeatures.add(new Feature(Feature.ABQR,delta));
        }

        //ODCP
        for(int delta = wordLength;delta<cubeSize;delta++){
            listFeatures.add(new Feature(Feature.ODCP,delta));
        }

        Utils.writeToFile("\nNumber of features: " + ShareMemory.getListFeatures().size());

    }

    private static void getCubeSizeInfor() {
        Utils.writeToFile("\nGet cube information data from: " + dicPath);
//        System.out.println("Load cube from: " + cubePath);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(cubePath));
            String line = br.readLine();

            setCubeSize(line.length());
            Utils.writeToFile("\nCube size: " + ShareMemory.getCubeSize());
        } catch (Exception e) {
            System.out.println("Cannot load cube data!");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    private static void loadDictionary() {
        Utils.writeToFile("\nINFOR: Load dictionary data from: " + dicPath);
//        System.out.println("Load dictionary from: " + dicPath);
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(dicPath));
            String line = br.readLine();

            setWordLength(line.length());

            int nb = 1;
            while (line != null) {
                ShareMemory.addWords(line);
                line = br.readLine();
                nb++;
            }

            setDicSize(nb);
            Utils.writeToFile("\nCreated dictionary: \nWord length: " + ShareMemory.getWordLength());
            Utils.writeToFile("\nSize: " + ShareMemory.getDicSize());
        } catch (Exception e) {
            System.out.println("Cannot load dictionary data!");
            e.printStackTrace();
            System.exit(-1);
        }
    }

    @Override
    public boolean invariant() {
        //TODO: Check invariant
        return true;
    }

    public static int getCubeSize() {
        return cubeSize;
    }

    public static void setCubeSize(int cubeSize) {
        ShareMemory.cubeSize = cubeSize;
    }

    public static int getDicSize() {
        return dicSize;
    }

    public static void setDicSize(int dicSize) {
        ShareMemory.dicSize = dicSize;
    }

    public static int getWordLength() {
        return wordLength;
    }

    public static void setWordLength(int wordLength) {
        ShareMemory.wordLength = wordLength;
    }

    public static ArrayList<Feature> getListFeatures() {
        return listFeatures;
    }


    private static void extractFeature(Feature currentFeature) {

        String file_name = currentFeature.getFile_name();
        Utils.writeToFile("\nExtract feature to file: "+file_name);
        int delta = currentFeature.getDelta();

        //Load cube
//        Utils.writeToFile("\nINFOR: Load cube data from: " + ShareMemory.getCubePath());
        try {
            BufferedReader br = new BufferedReader(new FileReader(ShareMemory.getCubePath()));
            String line = br.readLine();

            switch (currentFeature.getFeature()) {

                case Feature.OXY:

                    boolean stop = false;
                    //Array contain the value of a lattice oxy
                    char[][] arrayxy = new char[ShareMemory.getCubeSize()][ShareMemory.getCubeSize()];

                    while (line != null && !stop) {
                        //For each value of z
                        for (int z = 0; z < ShareMemory.getCubeSize(); z++) {
                            for (int y = 0; y < ShareMemory.getCubeSize(); y++) {
                                char[] arrayX = new char[ShareMemory.getCubeSize()];
                                arrayX = line.toCharArray();
                                for (int x = 0; x < arrayX.length; x++) {
                                    //The kind of plane
                                    if (z == delta) {
                                        arrayxy[x][y] = arrayX[x];
                                    }
                                }
                                line = br.readLine();
                            }

                            if (z == delta) {
                                stop = true;
                                break;
                            }

                        }

                    }
                    //Extract feature and write to file

                    extractFeatureToFile(file_name, arrayxy,ShareMemory.getCubeSize()-1,ShareMemory.getCubeSize()-1,true);

                    break;


                /******OYZ******/
                case Feature.OYZ:
                    //Array contain the value of a lattice oxy
                    char[][] arrayyz = new char[ShareMemory.getCubeSize()][ShareMemory.getCubeSize()];

                    while (line != null) {
                        //For each value of z
                        for (int z = 0; z < ShareMemory.getCubeSize(); z++) {
                            for (int y = 0; y < ShareMemory.getCubeSize(); y++) {
                                char[] arrayX = new char[ShareMemory.getCubeSize()];
                                arrayX = line.toCharArray();
                                for (int x = 0; x < arrayX.length; x++) {
                                    //The kind of plane
                                    if (x == delta) {
                                        arrayyz[y][z] = arrayX[x];
                                        break;
                                    }
                                }
                                line = br.readLine();
                            }

                        }


                    }

                    extractFeatureToFile(file_name, arrayyz,ShareMemory.getCubeSize()-1,ShareMemory.getCubeSize()-1,true);
                    break;

                /***OZX****/
                case Feature.OZX:

                    //Array contain the value of a lattice oxy
                    char[][] arrayzx = new char[ShareMemory.getCubeSize()][ShareMemory.getCubeSize()];

                    while (line != null) {
                        //For each value of z
                        for (int z = 0; z < ShareMemory.getCubeSize(); z++) {
                            for (int y = 0; y < ShareMemory.getCubeSize(); y++) {
                                if (z == delta) {
                                    char[] arrayX = new char[ShareMemory.getCubeSize()];
                                    arrayX = line.toCharArray();
                                    for (int x = 0; x < arrayX.length; x++) {
                                        //The kind of plane
                                        if (y == delta) {
                                            arrayzx[z][x] = arrayX[x];
                                            break;
                                        }
                                    }
                                }
                                line = br.readLine();
                            }

                        }

                    }
                    extractFeatureToFile(file_name, arrayzx,ShareMemory.getCubeSize()-1,ShareMemory.getCubeSize()-1,true);
                    break;
                /****ABQR****/
                case Feature.ABQR:
                    //Array contain the value of a lattice oxy
                    char[][] arrayabqr = new char[ShareMemory.getCubeSize()][delta];
                    char[][] arrayabqr2 = new char[ShareMemory.getCubeSize()][delta];

                    while (line != null) {
                        //For each value of z
                        for (int z = 0; z < ShareMemory.getCubeSize(); z++) {
                            for (int y = 0; y < ShareMemory.getCubeSize(); y++) {
                                if (z == delta) {
                                    char[] arrayX = new char[ShareMemory.getCubeSize()];
                                    arrayX = line.toCharArray();
                                    for (int x = 0; x < delta; x++) {
                                        //The kind of plane
                                        if (x+y == delta) {
                                            arrayabqr[z][x] = arrayX[x];
                                            break;
                                        }
                                        if(x+y==2*ShareMemory.getCubeSize()-delta-1){
                                            arrayabqr2[z][ShareMemory.getCubeSize()-1-x]=arrayX[x];
                                        }
                                    }
                                }
                                line = br.readLine();
                            }

                        }

                    }
                    extractFeatureToFile(file_name, arrayabqr,ShareMemory.cubeSize-1,delta-1,false);
                    extractFeatureToFile(file_name, arrayabqr2,ShareMemory.cubeSize-1,delta-1,false);
                    break;
                /****ODCP****/
                case Feature.ODCP:
                    //Array contain the value of a lattice oxy
                    char[][] arrayodcp = new char[ShareMemory.getCubeSize()][delta];
                    char[][] arrayodcp2 = new char[ShareMemory.getCubeSize()][delta];

                    while (line != null) {
                        //For each value of z
                        for (int z = 0; z < ShareMemory.getCubeSize(); z++) {
                            for (int y = 0; y < ShareMemory.getCubeSize(); y++) {
                                if (z == delta) {
                                    char[] arrayX = new char[ShareMemory.getCubeSize()];
                                    arrayX = line.toCharArray();
                                    for (int x = 0; x < arrayX.length; x++) {
                                        //The kind of plane
                                        if (x-y == delta) {
                                            arrayodcp[z][ShareMemory.getCubeSize()-1-x] = arrayX[x];
                                            break;
                                        }
                                        if(x-y==-delta){
                                            arrayodcp2[z][x]=arrayX[x];
                                        }
                                    }
                                }
                                line = br.readLine();
                            }

                        }

                    }
                    extractFeatureToFile(file_name, arrayodcp,ShareMemory.cubeSize-1,delta-1,false);
                    extractFeatureToFile(file_name, arrayodcp2,ShareMemory.cubeSize-1,delta-1,false);
                    break;
                default:
                    break;
            }


        } catch (Exception e) {
            System.out.println("Cannot load dictionary data!");
            e.printStackTrace();
            System.exit(-1);
        }

    }

    private static void extractFeatureToFile(String file_name, char[][] arrayxy, int a,int b,boolean full) {
        Utils.writeToFile("\nWrite feature to file: "+file_name);
        try {
            FileSystem hdfs = FileSystem.get(new URI(ShareMemory.getRootHDFS()), ShareMemory.getConf());
            Path file = new Path(ShareMemory.getDataHDFS()+"/"+file_name);
            OutputStream os = hdfs.create(file,
                    new Progressable() {
                        public void progress() {
                            System.out.println("Write data to : ");
                        }
                    });
            BufferedWriter brHDFS = new BufferedWriter(new OutputStreamWriter(os, "UTF-8"));

            //OX
            for (int y = 0; y <= b; y++) {
                StringBuffer bf = new StringBuffer();
                for (int x = 0; x <= a; x++) {
                    bf.append(arrayxy[x][y]);

                }
                brHDFS.write(bf.toString() + "\n");

            }
            for (int sum = ShareMemory.getWordLength() - 1; sum <= a; sum++) {
                StringBuffer bf = new StringBuffer();
                StringBuffer bf2 = new StringBuffer();
                StringBuffer bf3 = new StringBuffer();
                StringBuffer bf4 = new StringBuffer();

                //Sum
                for (int x = 0; x < sum; x++) {
                    bf.append(arrayxy[x][sum - x-1]);
                    bf2.append(arrayxy[x][b - sum + x+1]);
                }

                //Sub
                for (int x = a - sum; x < a; x++) {
                    bf3.append(arrayxy[x][sum - x-1]);
                    bf4.append(arrayxy[x][x - b + sum+1]);
                }
                brHDFS.write(bf.toString() + "\n");
                brHDFS.write(bf2.toString() + "\n");
                brHDFS.write(bf3.toString() + "\n");
                brHDFS.write(bf4.toString() + "\n");

            }
            Utils.writeToFile("Write a file to data set: " + file_name);
            brHDFS.close();
            hdfs.close();
        } catch (Exception e) {
            e.printStackTrace();
            Utils.writeToFile("\nError write feature to file: "+e.toString());
        }


    }

}
