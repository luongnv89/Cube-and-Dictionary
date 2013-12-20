package csc5021.objects;

/**
 * Created by luongnv89 on 19/12/13.
 */
public class Feature {
    public static final int OXY=0;
    public static final int OYZ=1;
    public static final int OZX=2;
    public static final int ABQR=3;
    public static final int ODCP=4;

    int feature;
    int delta;
    String file_name;

    public Feature(int feature, int delta) {
        this.feature = feature;
        this.delta = delta;
        this.file_name = String.valueOf(feature)+"_"+String.valueOf(delta)+".txt";
    }

    public int getFeature() {
        return feature;
    }

    public int getDelta() {
        return delta;
    }

    public String getFile_name() {
        return file_name;
    }
}
