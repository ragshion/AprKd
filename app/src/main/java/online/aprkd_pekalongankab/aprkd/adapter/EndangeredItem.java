package online.aprkd_pekalongankab.aprkd.adapter;

/**
 * Created by OiX on 22/08/2017.
 */

public class EndangeredItem {
    private String mName;
    private int mThumbnail;

    public String getName(){
        return mName;
    }

    public void setName(String name){
        this.mName = name;
    }

    public int getThumbnail(){
        return mThumbnail;
    }

    public void setThumbnail(int thumbnail){
        this.mThumbnail = thumbnail;
    }
}
