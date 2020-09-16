package com.berkantcanerkanat.notepad;

public class Singleton {

    private String baslik;
    private String text;
    private int sira;//sira 1 :  yeni bir not olarak gelmis sira 2: editlenecek sekilde gelmis
    static Singleton singleton;

    private Singleton(){

    }

    public String getBaslik() {
        return baslik;
    }

    public void setBaslik(String baslik) {
        this.baslik = baslik;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getSira() {
        return sira;
    }

    public void setSira(int sira) {
        this.sira = sira;
    }

    public static Singleton getInstance(){
        if(singleton == null){
            singleton = new Singleton();
        }
        return singleton;
    }


}
