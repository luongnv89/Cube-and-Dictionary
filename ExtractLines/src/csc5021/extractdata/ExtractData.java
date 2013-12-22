package csc5021.extractdata;

import java.io.*;
import java.util.ArrayList;

/**
 * Created by luongnv89 on 22/12/13.
 */
public class ExtractData {
    static int cubeSize;
    static int nbZfile;
    static int nbYfile;
    static int nbXfile;
    static int nbSumXYFile;
    static int nbSubXYFile;


    public static void main(String args[]) {

        splitByZ();
//        splitByX();
        //        splitByY();
        splitByCrossXY();
        //        revertfiles();
//        extractStringAllFile();
    }

    private static void extractStringAllFile() {

        for(int i=0;i<cubeSize;i++){
            extractString("z_"+i);
            extractString("revert_y_"+i);
            extractString("x_"+i);
        }

        for (int sumxy = 0; sumxy < 2 * cubeSize; sumxy++) {
            extractString("sumxy_"+sumxy);
            extractString("revert_sumxy_"+sumxy);
            extractString("subxy_" + sumxy);
            extractString("revert_subxy_" + sumxy);

        }
    }

    private static void revertfiles() {

        for(int i=0;i<cubeSize;i++){
            revertFile("y_"+i);
            File file = new File("y_"+i);
            file.delete();
        }

        for(int i=0;i<2*cubeSize;i++){
            revertFile("sumxy_"+i);
            revertFile("subxy_"+i);
        }

    }

    private static void extractString(String filePath) {
        ArrayList<StringBuffer> listStringBuffers = new ArrayList<StringBuffer>();
        int size;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            BufferedWriter bw = new BufferedWriter(new FileWriter("extract_" + filePath));
            String line = br.readLine();

            int offset = 0;
            while (line != null) {
                //Normal string
                bw.write(line+"\n");
                //Cross string
                char[] array = line.toCharArray();
                for (int i = 0; i < array.length; i++) {
                    if(listStringBuffers.size()<=i+offset){
                        listStringBuffers.add(new StringBuffer());
                    }
                    listStringBuffers.get(i+offset).append(array[i]);
                }
                line = br.readLine();
                offset++;
            }
            br.close();
            //Write cross string to file
            while (!listStringBuffers.isEmpty()) {
                bw.write(listStringBuffers.get(0).toString() + "\n");
                listStringBuffers.remove(0);
            }
            bw.close();
            File delFile = new File(filePath);
            delFile.delete();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    private static void revertFile(String filePath) {
        ArrayList<StringBuffer> listStringBuffers = new ArrayList<StringBuffer>();
        int size;
        try {
            BufferedReader br = new BufferedReader(new FileReader(filePath));
            String line = br.readLine();
            size = line.length();
            for (int i = 0; i < size; i++) {
                listStringBuffers.add(new StringBuffer());
            }
            while (line != null) {
                char[] array = line.toCharArray();
                for (int i = 0; i < size; i++) {
                    listStringBuffers.get(i).append(array[i]);
                }
                line = br.readLine();
            }
            br.close();
            BufferedWriter bw = new BufferedWriter(new FileWriter("revert_" + filePath));
            while (!listStringBuffers.isEmpty()) {
                bw.write(listStringBuffers.get(0).toString() + "\n");
                listStringBuffers.remove(0);
            }
            bw.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void splitByCrossXY() {
        for (int z = 0; z < cubeSize; z++) {
            try {
                BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
                String line = bfZ.readLine();
                for (int y = 0; y < cubeSize; y++) {
                    char[] array = line.toCharArray();
                    for (int x = 0; x < cubeSize; x++) {
                        BufferedWriter bfSumXY = new BufferedWriter(new FileWriter("sumxy_" + (x + y), true));
                        BufferedWriter bfSubXY = new BufferedWriter(new FileWriter("subxy_" + (x - y), true));
                        bfSumXY.write(array[x]);
                        bfSumXY.close();
                        bfSubXY.write(array[x]);
                        bfSubXY.close();
                    }
                    line = bfZ.readLine();
                }
                bfZ.close();
                for (int sumxy = 0; sumxy < 2 * cubeSize; sumxy++) {
                    BufferedWriter bfX = new BufferedWriter(new FileWriter("sumxy_" + sumxy, true));
                    bfX.write("\n");
                    bfX.close();
                }

                for (int subxy = -(cubeSize-1); subxy < cubeSize; subxy++) {
                    BufferedWriter bfX = new BufferedWriter(new FileWriter("subxy_" + subxy, true));
                    bfX.write("\n");
                    bfX.close();
                }

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    private static void splitByX() {
        for (int z = 0; z < cubeSize; z++) {
            try {
                BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
                String line = bfZ.readLine();
                for (int y = 0; y < cubeSize; y++) {
                    char[] array = line.toCharArray();
                    for (int x = 0; x < cubeSize; x++) {
                        BufferedWriter bfX = new BufferedWriter(new FileWriter("x_" + x, true));
                        bfX.write(array[x]);
                        bfX.close();
                    }
                    line = bfZ.readLine();
                }
                bfZ.close();
                for (int x = 0; x < cubeSize; x++) {
                    BufferedWriter bfX = new BufferedWriter(new FileWriter("x_" + x, true));
                    bfX.write("\n");
                    bfX.close();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            nbXfile = cubeSize;
        }
    }

    private static void splitByY() {
        for (int z = 0; z < cubeSize; z++) {
            try {
                BufferedReader bfZ = new BufferedReader(new FileReader("z_" + z));
                String line = bfZ.readLine();
                for (int y = 0; y < cubeSize; y++) {
                    BufferedWriter bfY = new BufferedWriter(new FileWriter("y_" + y, true));
                    bfY.write(line + "\n");
                    bfY.close();
                    bfZ.readLine();
                }
                bfZ.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        nbYfile = cubeSize;

    }

    private static void splitByZ() {
        try {
            BufferedReader bf = new BufferedReader(new FileReader("cube_10"));
            String line = bf.readLine();
            int cube_size = line.length();
            cubeSize = cube_size;
            int count=0;

            for (int z = 0; z < cube_size; z++) {
                String zFile = "z_" + z;
                BufferedWriter bw = new BufferedWriter(new FileWriter(zFile, true));
                count++;
                for (int y = 0; y < cube_size; y++) {
                    bw.write(line + "\n");
                    line = bf.readLine();
                }
                bw.close();
            }
            bf.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
        nbZfile = cubeSize;
    }


}
