package com.example.tugasrecyclerview2;

public class ViewModel {
    String nama;
    int image;

    public ViewModel(String nama, int image) {
        this.nama = nama;
        this.image = image;
    }

    public String getNama() {
        return nama;
    }

    public int getImage() {
        return image;
    }
}
