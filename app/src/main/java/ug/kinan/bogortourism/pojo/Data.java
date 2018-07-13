package ug.kinan.bogortourism.pojo;

/**
 * Created by farhan on 9/27/17.
 */

public class Data {
    private int _id;
    private String judul,alamat,harga,operasional,deskripsi;
    private String lat,lng,tipe,foto,foto2;

    public Data(){}

    public Data(int _id, String judul, String alamat, String harga, String operasional, String deskripsi, String lat, String lng, String foto, String foto2, String tipe){
        this._id = _id;
        this.judul = judul;
        this.alamat = alamat;
        this.harga = harga;
        this.operasional = operasional;
        this.deskripsi = deskripsi;
        this.lat = lat;
        this.lng = lng;
        this.foto = foto;
        this.foto2 = foto2;
        this.tipe = tipe;
    }

    public Data(String judul, String alamat, String harga, String operasional, String deskripsi, String lat, String lng, String foto, String foto2, String tipe){
        this.judul = judul;
        this.alamat = alamat;
        this.harga = harga;
        this.operasional = operasional;
        this.deskripsi = deskripsi;
        this.lat = lat;
        this.lng = lng;
        this.foto = foto;
        this.foto2 = foto2;
        this.tipe = tipe;
    }

    public String getFoto2() {
        return foto2;
    }

    public void setFoto2(String foto2) {
        this.foto2 = foto2;
    }

    public int get_id() {
        return _id;
    }

    public void set_id(int _id) {
        this._id = _id;
    }

    public String getJudul() {
        return judul;
    }

    public void setJudul(String judul) {
        this.judul = judul;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String getHarga() {
        return harga;
    }

    public void setHarga(String harga) {
        this.harga = harga;
    }

    public String getOperasional() {
        return operasional;
    }

    public void setOperasional(String operasional) {
        this.operasional = operasional;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public void setDeskripsi(String deskripsi) {
        this.deskripsi = deskripsi;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public String getTipe() {
        return tipe;
    }

    public void setTipe(String tipe) {
        this.tipe = tipe;
    }

    public String getFoto() {
        return foto;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }
}
