package com.worldofwords.worldofwords.Model;

public class Kelime {

    private int seviye_id;
    private String level_adi;
    private int sure;
    private int kelime_sayisi;
    private String kelime_1;
    private String kelime_2;
    private String kelime_3;
    private String harf_1;
    private String harf_2;
    private String harf_3;
    private String harf_4;
    private String harf_5;
    private int puan;
    private int cozuldu_mu;


    public Kelime() {
    }

    public Kelime(int id, String level_adi, int sure, int kelime_sayisi, String kelime_1, String kelime_2, String kelime_3, String harf_1, String harf_2, String harf_3, String harf_4, String harf_5, int puan, int cozuldu_mu) {
        this.seviye_id = id;
        this.level_adi = level_adi;
        this.sure = sure;
        this.kelime_sayisi = kelime_sayisi;
        this.kelime_1 = kelime_1;
        this.kelime_2 = kelime_2;
        this.kelime_3 = kelime_3;
        this.harf_1 = harf_1;
        this.harf_2 = harf_2;
        this.harf_3 = harf_3;
        this.harf_4 = harf_4;
        this.harf_5 = harf_5;
        this.puan = puan;
        this.cozuldu_mu = cozuldu_mu;
    }


    public int getId() {
        return seviye_id;
    }

    public void setId(int id) {
        this.seviye_id = id;
    }

    public String getLevel_adi() {
        return level_adi;
    }

    public void setLevel_adi(String level_adi) {
        this.level_adi = level_adi;
    }

    public int getSure() {
        return sure;
    }

    public void setSure(int sure) {
        this.sure = sure;
    }

    public int getKelime_sayisi() {
        return kelime_sayisi;
    }

    public void setKelime_sayisi(int kelime_sayisi) {
        this.kelime_sayisi = kelime_sayisi;
    }

    public String getKelime_1() {
        return kelime_1;
    }

    public void setKelime_1(String kelime_1) {
        this.kelime_1 = kelime_1;
    }

    public String getKelime_2() {
        return kelime_2;
    }

    public void setKelime_2(String kelime_2) {
        this.kelime_2 = kelime_2;
    }

    public String getKelime_3() {
        return kelime_3;
    }

    public void setKelime_3(String kelime_3) {
        this.kelime_3 = kelime_3;
    }

    public String getHarf_1() {
        return harf_1;
    }

    public void setHarf_1(String harf_1) {
        this.harf_1 = harf_1;
    }

    public String getHarf_2() {
        return harf_2;
    }

    public void setHarf_2(String harf_2) {
        this.harf_2 = harf_2;
    }

    public String getHarf_3() {
        return harf_3;
    }

    public void setHarf_3(String harf_3) {
        this.harf_3 = harf_3;
    }

    public String getHarf_4() {
        return harf_4;
    }

    public void setHarf_4(String harf_4) {
        this.harf_4 = harf_4;
    }

    public String getHarf_5() {
        return harf_5;
    }

    public void setHarf_5(String harf_5) {
        this.harf_5 = harf_5;
    }

    public int getPuan() {
        return puan;
    }

    public void setPuan(int puan) {
        this.puan = puan;
    }

    public int getCozuldu_mu() {
        return cozuldu_mu;
    }

    public void setCozuldu_mu(int cozuldu_mu) {
        this.cozuldu_mu = cozuldu_mu;
    }
}
