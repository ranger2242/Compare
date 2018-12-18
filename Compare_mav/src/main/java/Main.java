import io.FileHandler;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Layer1 l1 = new Layer1();
        String path ="C:\\Users\\Chris\\Google Drive\\JAVA\\Compare\\data\\";

        String[] paths = new String[]{
                path+"A",
                path+"B"
        };
        FileHandler fh  = new FileHandler(paths);

        ArrayList<Integer> bytesA = new ArrayList<>();
        ArrayList<Integer> bytesB = new ArrayList<>();
        File fileA = new File(path+"a");
        File fileB = new File(path+"b");
        String extA = getFileExtension(fileA);
        String extB = getFileExtension(fileB);
        try (
                InputStream inA = new FileInputStream(fileA);
                InputStream inB = new FileInputStream(fileB);
        ) {

            int byteRead;
            while ((byteRead = inA.read()) != -1) {
                bytesA.add(byteRead);
            }
            while ((byteRead = inB.read()) != -1) {
                bytesB.add(byteRead);
            }

        } catch (IOException ex) {
            ex.printStackTrace();
        }
        int[] analysisA = l1.binaryAnalysis(bytesA);
        int[] analysisB = l1.binaryAnalysis(bytesB);

        boolean allSame = true;
        int[] diffAB = new int[255];
        for (int i = 0; i < 255; i++) {
            if(!(i==9 || i==10 || i==13 || i==32)) {
                if (analysisA[i] != analysisB[i]) {
                    allSame = false;
                }
                diffAB[i] = Math.abs(analysisA[i] - analysisB[i]);
            }
        }
        double nA = Arrays.stream(analysisA).asDoubleStream().sum();
        double nB = Arrays.stream(analysisB).asDoubleStream().sum();
        double nDiff= Math.abs(nA - nB);
        DecimalFormat nf = new DecimalFormat("000.000000");
        System.out.println("Size difference: " + nDiff  + "byte");
        System.out.println("Size A: " + nA);
        System.out.println("Size B: " + nB);

        System.out.println("Exact copy: " + allSame);
        System.out.println("Percent diff: " + nf.format(nDiff/nA)+"% ");

        System.out.println(Arrays.toString(diffAB));

    }



}
