package com.srtp.nursinghome;

public class Old {
    private int imageId;
    private String name;
    private String id;
    public Old(String name,String id,int imageId){
        this.name=name;
        this.imageId=imageId;
        this.id=id;
    }

    public String getName(){
        return name;
    }

    public String getId(){
        return id;
    }

    public int getImageId() {
        return imageId;
    }
}
