package com.example.quranappwithnav_json;


public class ayah {
    public ayah(Integer juz, String surahName, String text) {
        this.juz = juz;
        this.SurahName = surahName;
        this.Text = text;
    }

    public ayah() {
    }

    public Integer getJuz() {
        return juz;
    }

    public void setJuz(Integer juz) {
        this.juz = juz;
    }

    public String getSurahName() {
        return SurahName;
    }

    public void setSurahName(String surahName) {
        SurahName = surahName;
    }

    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    Integer juz;
    String SurahName;
    String Text;

}
