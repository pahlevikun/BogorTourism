package ug.kinan.bogortourism.database;

import android.content.ContentValues;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;
import java.util.List;

import ug.kinan.bogortourism.R;
import ug.kinan.bogortourism.pojo.Data;

/**
 * Created by farhan on 8/15/16.
 */
public class DatabaseHandler extends SQLiteOpenHelper {

    // Versi Database
    public static final int DATABASE_VERSION = 9;

    // Nama Database
    public static final String DATABASE_NAME = "bogortourism";

    // Nama Tabel
    public static final String TABLE_WISATA = "wisata";
    public static final String TABLE_SEJARAH = "sejarah";
    public static final String TABLE_KULINER = "kuliner";

    // Tabel Nasihat
    public static final String KEY_ID = "_id";
    public static final String KEY_JUDUL = "judul";
    public static final String KEY_ALAMAT = "alamat";
    public static final String KEY_HARGA = "harga";
    public static final String KEY_OPERASIONAL = "operasional";
    public static final String KEY_DESKRIPSI = "deskripsi";
    public static final String KEY_LAT = "lat";
    public static final String KEY_LNG = "lng";
    public static final String KEY_FOTO = "foto";
    public static final String KEY_FOTO_2 = "foto2";
    public static final String KEY_TIPE = "tipe";

    public Resources res;

    public DatabaseHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        res = context.getResources();
    }

    // Creating Tables
    @Override
        public void onCreate(SQLiteDatabase db) {
        String CREATE_TABLE_WISATA = "CREATE TABLE " + TABLE_WISATA + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_JUDUL + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_HARGA + " TEXT," + KEY_OPERASIONAL + " TEXT,"
                + KEY_DESKRIPSI + " TEXT," + KEY_LAT + " TEXT," + KEY_LNG + " TEXT,"
                + KEY_FOTO + " TEXT," + KEY_FOTO_2 + " TEXT," + KEY_TIPE + " TEXT" + ")";
        String CREATE_TABLE_KULINER = "CREATE TABLE " + TABLE_KULINER + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_JUDUL + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_HARGA + " TEXT," + KEY_OPERASIONAL + " TEXT,"
                + KEY_DESKRIPSI + " TEXT,"  + KEY_LAT + " TEXT," + KEY_LNG + " TEXT,"
                + KEY_FOTO + " TEXT," + KEY_FOTO_2 + " TEXT," + KEY_TIPE + " TEXT" + ")";
        String CREATE_TABLE_SEJARAH = "CREATE TABLE " + TABLE_SEJARAH + "("
                + KEY_ID + " INTEGER PRIMARY KEY," + KEY_JUDUL + " TEXT,"
                + KEY_ALAMAT + " TEXT," + KEY_HARGA + " TEXT," + KEY_OPERASIONAL + " TEXT,"
                + KEY_DESKRIPSI + " TEXT," + KEY_LAT + " TEXT," + KEY_LNG + " TEXT,"
                + KEY_FOTO + " TEXT," + KEY_FOTO_2 + " TEXT," + KEY_TIPE + " TEXT" + ")";

        db.execSQL(CREATE_TABLE_WISATA);
        db.execSQL(CREATE_TABLE_KULINER);
        db.execSQL(CREATE_TABLE_SEJARAH);

        insertKuliner(db);
        insertWisata(db);
        insertSejarah(db);

    }

    public void insertKuliner(SQLiteDatabase db){
        ContentValues value = new ContentValues();
        //Record 1
        value.put(KEY_JUDUL, "Roti Unyil Venus");
        value.put(KEY_ALAMAT, "Jl.Siliwangi no.27E, Sukasari, Kec.Bogor Timur, Kota Bogor, Jawa Barat. 16133.");
        value.put(KEY_HARGA, "Rp 1.500 - Rp21.500");
        value.put(KEY_OPERASIONAL, "06.00-20.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.619150");
        value.put(KEY_LNG, "106.816313");
        value.put(KEY_FOTO, "kuliner1");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 2
        value.put(KEY_JUDUL, "Lapis Bogor Sangkuriang");
        value.put(KEY_ALAMAT, "Ruko Bantar Kemang, Jl. Raya Pajajaran no.20i, Baranangsiang, Kec.Bogor Timur, Kota Bogor, Jawa Barat, 16143.");
        value.put(KEY_HARGA, "Rp 29.000 – Rp 33.000");
        value.put(KEY_OPERASIONAL, "06.00 - 22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.616062");
        value.put(KEY_LNG, "106.814216");
        value.put(KEY_FOTO, "kuliner2");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 3
        value.put(KEY_JUDUL, "Asinan Gedung Dalam");
        value.put(KEY_ALAMAT, "Jl. Siliwangi no.27C, Sukasari, Kec.Bogor Timur, Kota Bogor, Jawa Barat, 16142.");
        value.put(KEY_HARGA, "Rp 19.000 – Rp 22.000");
        value.put(KEY_OPERASIONAL, "09.00-21.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.617481");
        value.put(KEY_LNG, "106.81191");
        value.put(KEY_FOTO, "kuliner3");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 4
        value.put(KEY_JUDUL, "Pia Apple Pie");
        value.put(KEY_ALAMAT, "Jl. Pangrango no.10, Babakan, Kec.Bogor Tengah, Kota Bogor, Jawa Barat, 16128.");
        value.put(KEY_HARGA, "Rp 9.000 – Rp 65.000");
        value.put(KEY_OPERASIONAL, "07.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.590302");
        value.put(KEY_LNG, "106.802581");
        value.put(KEY_FOTO, "kuliner4");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 5
        value.put(KEY_JUDUL, "Macaroni Panggang");
        value.put(KEY_ALAMAT, "Jl.Salak no.24, Babakan, Kec.Bogor Tengah, Kota Bogor, Jawa Barat, 16128.");
        value.put(KEY_HARGA, "Rp 23.000 – Rp 210.000");
        value.put(KEY_OPERASIONAL, "07.00 - 22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.588912");
        value.put(KEY_LNG, "106.802658");
        value.put(KEY_FOTO, "kuliner5");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 6
        value.put(KEY_JUDUL, "Priangan Sari");
        value.put(KEY_ALAMAT, "Jl. Raya Puncak, Cianjur no.53, Gadog, Megamendung, Bogor, Jawa Barat. 16770.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "07.00-21.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.653837");
        value.put(KEY_LNG, "106.866492");
        value.put(KEY_FOTO, "kuliner6");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 7
        value.put(KEY_JUDUL, "Sari Pakuan");
        value.put(KEY_ALAMAT, "Jl Raya Padjajaran no.72B, Pakuan, Bogor Selatan. Kota Bogor, Jawa Barat. 16132.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "06.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.603165");
        value.put(KEY_LNG, "106.806361");
        value.put(KEY_FOTO, "kuliner7");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 8
        value.put(KEY_JUDUL, "Miss Pumpkin");
        value.put(KEY_ALAMAT, "Jl. Raya Pajajaran no.84, Baranangsiang, Bogor Timur, Kota Bogor, Jawa Barat. 16143.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "08.00-18.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.608469");
        value.put(KEY_LNG, "106.810695");
        value.put(KEY_FOTO, "kuliner8");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 9
        value.put(KEY_JUDUL, "Bogor Princess Cake");
        value.put(KEY_ALAMAT, "Komplek Ahmad Yani no.44, Tanah Sareal, Kota Bogor, Jawa Barat. 16161.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "07.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.576463");
        value.put(KEY_LNG, "106.799947");
        value.put(KEY_FOTO, "kuliner9");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 10
        value.put(KEY_JUDUL, "Sentra Oleh-Oleh Kita");
        value.put(KEY_ALAMAT, "Ruko Tiara no.3A. Jl. Raya Padjajaran, Tegallega, Bogor Tengah, Kota Bogor, Jawa Barat. 16142.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "06.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.603165");
        value.put(KEY_LNG, "106.806361");
        value.put(KEY_FOTO, "kuliner10");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 11
        value.put(KEY_JUDUL, "Bogor Raincake");
        value.put(KEY_ALAMAT, "Jl. Raya Pajajaran no.31, Babakan, Bogor Tengh, Kota Bogor, Jawa Barat. 16128.");
        value.put(KEY_HARGA, "Rp 1.500 - Rp21.500");
        value.put(KEY_OPERASIONAL, "06.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.593827");
        value.put(KEY_LNG, "106.804974");
        value.put(KEY_FOTO, "kuliner11");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 12
        value.put(KEY_JUDUL, "Cake Ala Ali");
        value.put(KEY_ALAMAT, "Jl. RE.Martadinata no.8, Sempur, Bogor Tengah, Kota Bogor, Jawa Barat. 16129.");
        value.put(KEY_HARGA, "-");
        value.put(KEY_OPERASIONAL, "07.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.581249");
        value.put(KEY_LNG, "106.795133");
        value.put(KEY_FOTO, "kuliner12");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 13
        value.put(KEY_JUDUL, "Strudel Bogor");
        value.put(KEY_ALAMAT, "Jl. Raya Pajajaran no.3f, Baranangsiang, Bogor Timur, Kota Bogor, Jawa Barat. 16143.");
        value.put(KEY_HARGA, "Rp 1.500 - Rp21.500");
        value.put(KEY_OPERASIONAL, "08.00-22.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.603172");
        value.put(KEY_LNG, "106.805791");
        value.put(KEY_FOTO, "kuliner13");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
        //Record 14
        value.put(KEY_JUDUL, "Asinan Dewi Sri");
        value.put(KEY_ALAMAT, "Jl. Raya Pajajaran no.60A, Baranangsiang, Bogor Timur, Kota Bogor, Jawa Barat. 16143.");
        value.put(KEY_HARGA, "Rp 1.500 - Rp21.500");
        value.put(KEY_OPERASIONAL, "09.00-21.00 WIB");
        value.put(KEY_DESKRIPSI, "-");
        value.put(KEY_LAT, "-6.610503");
        value.put(KEY_LNG, "106.811515");
        value.put(KEY_FOTO, "kuliner14");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "1");
        db.insert(TABLE_KULINER, null, value);
    }

    public void insertWisata(SQLiteDatabase db){
        ContentValues value = new ContentValues();
        //Record 1
        value.put(KEY_JUDUL, "Kawah Ratu Taman Nasional Gunung Halimun Salak");
        value.put(KEY_ALAMAT, "Gunung Sari, Pamijahan, Bogor, Jawa Barat 16810.");
        value.put(KEY_HARGA, "Rp 10.000,00/orang");
        value.put(KEY_OPERASIONAL, "08.00 – 14.00 WIB");
        value.put(KEY_DESKRIPSI, "Kawah Ratu merupakan tempat menarik yang bisa dikunjungi oleh para pecinta wisata alam. Yang menjadikan kawah ini berbeda dengan kawah-kawah lain adalah keberedaan aliran sungai Cikuluwung sepanjang 1 km. Hal tersebut yang menjadi daya tarik tersendiri dari kawah ini. Dilihat dari kejauhan, air sungai tersebut terlihat berwarna biru toska. Namun, saat kita mendekat, akan ada warna kuning di dasar sungai yang terlihat dengan jelas. Warna kuning tersebut adalah endapan belerang.");
        value.put(KEY_LAT, "-6.717561");
        value.put(KEY_LNG, "106.713162");
        value.put(KEY_FOTO, "wisata1");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Gunung Kapur Klapanunggal");
        value.put(KEY_ALAMAT, "Klapanunggal, Klp. Nunggal, Bogor, Jawa Barat 16710.");
        value.put(KEY_HARGA, "Gratis");
        value.put(KEY_OPERASIONAL, "06.00-18.00 WIB");
        value.put(KEY_DESKRIPSI, "Gunung Kapur merupakan tempat wisata yang masih asri dan dekat dengan perkotaan. Dahulu tempat ini merupakan tempat penambangan batu kapur untuk bahan baku pembuatan semen. Oleh karena itu, bentuk-bentuk Gunung Kapur disini sangat unik dan menarik. Meski aktivitas pertambngan telah dilumpuhkan, gunungan pasir masih banyak terlihat disana. Tidak hanya pasir dan kapur, tempat ini juga memiliki beberapa cekungan yang membentuk gua.");
        value.put(KEY_LAT, "-6.457890");
        value.put(KEY_LNG, "106.953761");
        value.put(KEY_FOTO, "wisata2");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Penangkaran Elang Kampung Loji");
        value.put(KEY_ALAMAT, "Cijeruk, Bogor, Jawa Barat 16740.");
        value.put(KEY_HARGA, "Rp 10.000,00/orang");
        value.put(KEY_OPERASIONAL, "24 Jam");
        value.put(KEY_DESKRIPSI, "Penangkaran Elang Kampung Loji merupakan sebuah tempat wisata berbasis edukasi yang menyuguhkan pengalaman dapat berinteraksi langsung dengan salah satu predator terbesar di udara yaitu burung Elang. Selain mendapatkan beberapa informasi terkait satwa yang satu ini, tempat ini juga menyediakan fasilitas area berkemah atau camping ground yang cukup luas.");
        value.put(KEY_LAT, "-6.718049");
        value.put(KEY_LNG, "106.768619");
        value.put(KEY_FOTO, "wisata3");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Telaga Warna Puncak");
        value.put(KEY_ALAMAT, "Desa Tugu, Kecamatan Cisarua, Kabupaten Bogor, Jawa Barat.");
        value.put(KEY_HARGA, "Rp 7.500,00/orang");
        value.put(KEY_OPERASIONAL, "08.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Telaga Warna Puncak Bogor adalah sebuah objek taman wisata alam yang lokasi nya terletak di kawasan Pass Cisarua Bogor. Taman wisata yang berada kawasan Cagar Alam yang dikelola oleh Badan Konservasi Sumber Daya Alam ini merupakan salah satu primadona objek wisata yang terkenal karena pesona keindahan alamnya. Hamparan kebun teh yang membentang luas serta udaranya yang sejuk karena berada di ketinggian 1400 Mdpl menawarkan sensasi perjalanan wisata yang tenang dan menyenangkan. Sehingga sangat cocok dan tepat untuk dijadikan salah satu alternative tempat wisata bagi Anda yang ingin sejenak melupakan kesibukan kerja selama seminggu ke belakang. Luas keseluruhan Taman wisata Telaga Warna sendiri adalah 5 hektar, sedangkan luas telaganya adalah 1.5 hektar.");
        value.put(KEY_LAT, "-6.702325");
        value.put(KEY_LNG, "106.996766");
        value.put(KEY_FOTO, "wisata4");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Gunung Batu Jonggol");
        value.put(KEY_ALAMAT, "Desa Sukaharja, Sukamakmur, Bogor, Jawa Barat, 16830");
        value.put(KEY_HARGA, "Rp 15.000,00/orang");
        value.put(KEY_OPERASIONAL, "24 jam");
        value.put(KEY_DESKRIPSI, "Gunung Batu adalah sebuah gunung yang berada di daerah Jonggol, Kabupaten Bogor. Gunung ini mempunyai ketinggian 875 mdpl atau hanya hanya sekitar 200 m dari titik awal pendakian. Sebenarnya gunung ini kurang tepat disebut gunung atau lebih tepatnya disebut sebuah bukit atau tebing batu. (tetapi dalam masyarakat kita, setiap gugusan yang memiliki puncak cenderung disebut gunung). Dari titik awal pendakian ini, pengunjung bisa menitipkan kendaraan dengan tarif Rp 15ribu/motor dan pengunjung sudah bisa mendaki langsung tanpa membayar restribusi lagi. Dan, menurut informasi dari penjaga parkiran tempat parkir ini buka selama 24 jam. Disini juga terdapat warung-warung yang menjajakan makanan dan minuman selama 24 jam.");
        value.put(KEY_LAT, "-6.604170");
        value.put(KEY_LNG, "107.051912");
        value.put(KEY_FOTO, "wisata5");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Bukit Alesano");
        value.put(KEY_ALAMAT, "Desa Cijeruk, Bogor, Jawa Barat 16740");
        value.put(KEY_HARGA, "Rp 10.000,00/motor dan Rp 30.000,00/mobil");
        value.put(KEY_OPERASIONAL, "24 jam");
        value.put(KEY_DESKRIPSI, "Tempat wisata di bogor ini menawarkan pemandangan alam dari ketinggian baik di siang hari berupa hijaunya daun-daunan dan indahnya pemandangan kota Bogor yang tampak kecil. Serta pemandangan indahnya malam hari yang memberikan suasana yang menakjubkan dengan hiasan lampu-lampu yang menerangi dataran rendah kota Bogor.");
        value.put(KEY_LAT, "-6.711593");
        value.put(KEY_LNG, "106.770227");
        value.put(KEY_FOTO, "wisata6");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Alun-Alun Surya Kencana");
        value.put(KEY_ALAMAT, "TNGGP Cibodas, Sukamulya, Cugenang, Jawa Barat");
        value.put(KEY_HARGA, "Rp 27.500,00/orang");
        value.put(KEY_OPERASIONAL, "-");
        value.put(KEY_DESKRIPSI, "Alun-alun Surya Kencana berada di atas ketinggian 2.750 meter di atas permukaan laut, di kawasan Taman Nasional Gunung Gede Pangrango yang terdapat di tiga kabupaten, yaitu Cianjur, Sukabumi, dan Bogor. Untuk sampai ke tempat ini, para pendaki harus menempuh perjalanan tracking selama 7 hingga 8 jam via jalur Cibodas atau Gunung Putri. Disini, pengunjung bisa menikmati padang savanna yang terhampar  luas menjadi latar tanaman yang hanya tumbuh di ketinggian, yaitu bunga edelweiss.");
        value.put(KEY_LAT, "-6.777255");
        value.put(KEY_LNG, "106.981042");
        value.put(KEY_FOTO, "wisata7");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Danau Quarry Jayamix");
        value.put(KEY_ALAMAT, "Tegalega, Cigudeg, Bogor, Jawa Barat 16660");
        value.put(KEY_HARGA, "Rp 2.000");
        value.put(KEY_OPERASIONAL, "24 Jam");
        value.put(KEY_DESKRIPSI, "Danau Quarry Jayamix ini merupakan bekas penambangan pasir yang sudah tak lagi beroperasi. Yang ditawarkan di sini adalah pemandangan Danau Quarry itu sendiri. Banyak tempat menarik untuk menjadi latar belakang berfoto di sini, mulai dari tebing hingga danau. Tetapi, sangat tidak disarankan untuk memanjat tebing atau berenang di danaunya karena kondisi yang berbahaya dan minim pengawasan.");
        value.put(KEY_LAT, "-6.453445");
        value.put(KEY_LNG, "106.594624");
        value.put(KEY_FOTO, "wisata8");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Tirta Sanita Ciseeng");
        value.put(KEY_ALAMAT, "Jalan Pasar Ciseeng, Parung, Bojong Indah, Bogor, Jawa Barat, 16330");
        value.put(KEY_HARGA, "Rp 10.000/orang");
        value.put(KEY_OPERASIONAL, "07.00-20.00 WIB");
        value.put(KEY_DESKRIPSI, "Berendam di kolam air panas dengan suasana sekeliling yang indah alami, tidak saja akan menyegarkan dan mengembalikan stamina tubuh, tetapi juga menyegarkan pikiran. Manfaat itu yang akan pengunjung rasakan saat berendam di Taman Wisata Air Panas Tirta Sanita Ciseeng. Tempat ini juga menyediakan fasilitas rekreasi bagi anak-anak, seperti sepeda air, flying fox, dan area outbound.");
        value.put(KEY_LAT, "-6.431591");
        value.put(KEY_LNG, "106.696006");
        value.put(KEY_FOTO, "wisata9");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Situ Gede");
        value.put(KEY_ALAMAT, "Kelurahan Situgede, Kecamatan Bogor Barat, Jawa Barat.");
        value.put(KEY_HARGA, "Gratis");
        value.put(KEY_OPERASIONAL, "24 jam");
        value.put(KEY_DESKRIPSI, "Dengan luas sekitar 6 hektar dan terletak di tepi Hutan Dramaga yang merupakan hutan penelitian Badan Litbang Kehutanan, membuat Situ Gede diselimuti keindahan panorama air danau yang berpadu dengan rimbunnya pepohonan serta udara yang sejuk dan segar.");
        value.put(KEY_LAT, "-6.554420");
        value.put(KEY_LNG, "106.750233");
        value.put(KEY_FOTO, "wisata10");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Agro Wisata Gung Mas");
        value.put(KEY_ALAMAT, "Jalan Raya Puncak Km 87, Kecamatan Cisarua, Gunung Mas PTPN VIII Kotak Pos 6, Puncak 16750.");
        value.put(KEY_HARGA, "Rp 4.500/orang");
        value.put(KEY_OPERASIONAL, "24 jam");
        value.put(KEY_DESKRIPSI, "Hamparan kebun teh yang berada pada ketinggian 800-1200 meter di atas permukaan laut menjadi sajian utama bagi para pengunjung yang datang ke Agro Wisata Gunung Mas. Selain menikmati hijau kebun the, pengunjung juga dapat melihat proses pengolahan teh di Pabrik The milik PTP Nusantara VIII yang ada di lokasi wisata.\n");
        value.put(KEY_LAT, "-6.703019");
        value.put(KEY_LNG, "106.971692");
        value.put(KEY_FOTO, "wisata11");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Kebun Raya Bogor");
        value.put(KEY_ALAMAT, "Jl. Ir. Haji Djuanda No.13, Paledang, Bogor Tengah, Kota Bogor, Jawa Barat 16122");
        value.put(KEY_HARGA, "Rp 14.000/orang");
        value.put(KEY_OPERASIONAL, "08.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Kebun Raya Bogor merupakan kebun botani yang sudah ada sejak abad ke-19 ketika Indonesia masih dikuasai Belanda. Beberapa bangunan bersejarah dapat kita temukan di beberapa titik di Kebun Raya Bogor. Di kebun botani ini juga terdapat sebuah museum, taman serta danau buatan.");
        value.put(KEY_LAT, "-6.602151");
        value.put(KEY_LNG, "106.798475");
        value.put(KEY_FOTO, "wisata12");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Kebun Raya Cibodas");
        value.put(KEY_ALAMAT, "Kompleks Hutan Gunung Gede Pangrango, Desa Cimacan, Cipanas, Cianjur, Jawa Barat.");
        value.put(KEY_HARGA, "Rp 9.500/orang");
        value.put(KEY_OPERASIONAL, "08.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Kebun Raya Cibodas adalah taman hijau yang luasnya hampir 80 hektar dengan topografi lapangan yang bergelombang dan berbukit-bukit menjadikan kebun raya cibodas salah satu tujuan wisata utama di kawasan Cibodas. Keindahan Kebun Raya Cibodas sudah terkenal sejak lama dan menjadi tujuan wisata domestik maupun mancanegara. Kebu ini tepat berada di kaki gunung Gede Pangrango dengan ketinggian 1.275 mdpl dan bersuhu udara 17 – 27 derajat Celcius. ");
        value.put(KEY_LAT, "-6.736591");
        value.put(KEY_LNG, "107.008046");
        value.put(KEY_FOTO, "wisata13");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Gunung Munara");
        value.put(KEY_ALAMAT, "Desa Kampung Sawah, Rumpin, Kabupaten Bogor, Jawa Barat");
        value.put(KEY_HARGA, "Rp 5.000/orang");
        value.put(KEY_OPERASIONAL, "-");
        value.put(KEY_DESKRIPSI, "Gunung Munara merupakan salah satu tujuan alternatif yang mulai banyak dikenal pengunjung dari berbagai daerah. Tempat wisata ini cocok untuk pengunjung yang ingin mendaki ringan dengan lokasi yag tidak terlalu jauh dari Jakarta atau Bogor. Sebenarnya gunung ini lebih cocok disebut bukit, karena memang tidak terlalu tinggi. Untuk mencapai puncak Gunung Munara membutuhkan waktu kurang lebih 1 jam.");
        value.put(KEY_LAT, "-6.453087");
        value.put(KEY_LNG, "106.636929");
        value.put(KEY_FOTO, "wisata14");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
        //Record
        value.put(KEY_JUDUL, "Gunung Pancar");
        value.put(KEY_ALAMAT, "Karang Tengah, Kecamatan Babakan Madang, Kabupaten Bogor");
        value.put(KEY_HARGA, "Rp 5.000/orang");
        value.put(KEY_OPERASIONAL, "24 Jam");
        value.put(KEY_DESKRIPSI, "Wisata Gunung Pancar yang merupakan tempat wisata yang menghadirkan pemandangan alam yang begitu indah, pemandangan disana tentu jarang ditemui terutama di kota-kota besar seperti Jakarta. Taman wisata gunung pancar sendiri berada pada ketinggian 300-800 meter diatas permukaan laut. Disana pengunjung tidak hanya  menyaksikan pemandangan alam yang menyejukkan, tetapi juga dapat melihat beberapa jenis fauna seperti Jelarang, Kera, Babi Hutan dan juga jenis burung seperti  Burung Kutilang, Elang, Jalak, Ayam Hutan Merah, Srigunting, Enggang dan jenis yang lainnya.");
        value.put(KEY_LAT, "-6.580710");
        value.put(KEY_LNG, "106.903576");
        value.put(KEY_FOTO, "wisata15");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "2");
        db.insert(TABLE_WISATA, null, value);
    }

    public void insertSejarah(SQLiteDatabase db){
        ContentValues value = new ContentValues();
        //Record 1
        value.put(KEY_JUDUL, "Prasasti Batutulis");
        value.put(KEY_ALAMAT, "Jalan Batutulis no.54, Kecamatan Bogor Selatan, Kota Bogor, Jawa Barat. 16133");
        value.put(KEY_HARGA, "Gratis");
        value.put(KEY_OPERASIONAL, "08.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Komplek Prasasti Batutulis memiliki 17 x 15 meter, dianggap terletak di situs ibu kota pajajaran yakni masih terletak di lokasi aslinya dan menjadi nama desa lokasi situs ini. Prasasti Batutulis itu sendiri merupakan situs yang berupa batu yang terdapat ukiran aksara sunda dan jejak kaki serta telapak tangan dari prabu surawisesa. Jejak kaki dan telapak tangan inilah yang menjadi daya tarik para wisatawan karena sangat unik dan mempunyai nilai sejarah tersendiri.");
        value.put(KEY_LAT, "-6.623768");
        value.put(KEY_LNG, "106.809035");
        value.put(KEY_FOTO, "sejarah1");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Museum Zoologi");
        value.put(KEY_ALAMAT, "Jalan Ir.H.Djuanda no.9, Paledang, Kecamatan Bogor Tengah, Kota Bogor, Jawa Barat. 16911.");
        value.put(KEY_HARGA, "Gratis");
        value.put(KEY_OPERASIONAL, "08.00-16.00 WIB");
        value.put(KEY_DESKRIPSI, "Merupakan unit dari Bidang Zoologi, Puslit Biologi, LIPI yang merupakan penjabaran dari tugas pelayanan masyarakat umum untuk jasa ilmu pengetahuan zoologi. Unit ini mempunyai tugas memperkenalkan keanekaragaman fauna nusantara dalam bentuk awetan binatang dan replika, dengan harapan pengunjung dapat lebih mengenal kekayaan fauna nusantara, dan untuk meningkatkan kepedulian dan kecintaan generasi muda akan fauna nusantara, serta menunjang usaha pelestariannya. Jumlah koleksi yang dipamerkan di pameran ini meliputi 3,5% jumlah jenis fauna yang terdapat di Indonesia, dan hanya 0,05% contoh binatang (spesimen) yang dimiliki oleh Bidang Zoologi, Pusat Penelitian Biologi, LIPI.");
        value.put(KEY_LAT, "-6.603581");
        value.put(KEY_LNG, "106.796926");
        value.put(KEY_FOTO, "sejarah2");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Museum Pembela Tanah Air");
        value.put(KEY_ALAMAT, "Jalan Jendral Sudirman no.35, Sempur, Kecamatan Bogor Utara, Kota Bogor, Jawa Barat.");
        value.put(KEY_HARGA, "Rp 2.500/orang");
        value.put(KEY_OPERASIONAL, "Minggu, 09.00-15.00 WIB");
        value.put(KEY_DESKRIPSI, "Museum Pembela Tanah Air mempunyai 14 diorama yang menceritakan tentang peristiwa pembentukan tentara Peta dan beberapa kontribusinya dalam proses pergerakan kebangsaan untuk mencapai kemerdekaan. Koleksi yang ada di Museum Peta terdiri atas Relief atau monument yang menceritakan dari awal terbentuknya tentara Peta dan terjadinya pertempuran tentara Peta melawan penjajan. Terdapat pla koleksi patung, perlengkapan perang, meriam, dan senjata untuk perang.");
        value.put(KEY_LAT, "-6.585989");
        value.put(KEY_LNG, "106.796253");
        value.put(KEY_FOTO, "sejarah3");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Museum Perjuangan");
        value.put(KEY_ALAMAT, "Jalan Merdeka no.56, Kelurahan Cibogor, Kecamatan Bogor Tengah, Kota Bogor, Jawa Barat, 16124");
        value.put(KEY_HARGA, "Rp 2.000/orang");
        value.put(KEY_OPERASIONAL, "Sabtu-Kamis, Pukul 09.00-14.00 WIB");
        value.put(KEY_DESKRIPSI, "Gedung  ini didirikan pada tahun 1879, oleh pengusaha Belanda bernama Wilhem Gustaf Wissner. Gedung ini pernah digunakan sebagai tempat pergerakan nasional pada tahun 1935,  pernah digunakan sebagai gudang untuk menyimpan barang-barang milik Belanda, pernah juga digunakan untuk menyambut dan mempertahankan kemerdekaan RI pada tahun 1945. Kemudian pada tahun 1958 dihibahkan oleh pemiliknya kepada Umar Bin Usman Albawahab menjadi Museum Perjuangan Bogor. Museum ini didirikan oleh para pejuang Bogor  untuk mewariskan semangat juang serta nilai-nilai 45 kepada generasi saat ini. Bukti-bukti perjuangan pejuang kemerdekaan tersimpan rapi di antaranya: berbagai koleksi senjata yang pernah digunakan untuk melawan penjajah, replika pertempuran di Bogor antara tahun 1945 – 1950, dan ada kata-kata penggugah,  di salah satu batu nisan, yang menjadi simbol  kebangkitan rasa nasionalisme.");
        value.put(KEY_LAT, "-6.594255");
        value.put(KEY_LNG, "106.788588");
        value.put(KEY_FOTO, "sejarah4");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Museum Etnobotani");
        value.put(KEY_ALAMAT, "Jalan Ir.H.Djuanda no.22-24, Pusat Penelitian Biologi-LIPI, Paledang, Kecamatan Bogor Tengah, Kota Bogor, Jawa Barat, 16122.");
        value.put(KEY_HARGA, "Rp 3.000/orang");
        value.put(KEY_OPERASIONAL, "08.00-14.00 WIB");
        value.put(KEY_DESKRIPSI, "Museum Etnobotani adalah museum yang koleksinya menggabungkan ilmu botani dengan karya budaya etnik di seluruh Nusantara. Tempat wisata pengetahuan ini dikabarkan menyimpan lebih sekitar 2000 artefak yang berasal dari berbagai daerah dan kepulauan di Indonesia. Koleksinya meliputi barang-barang untuk keperluan rumah tangga, mainan anak, pakaian tradisional, peralatan pertanian, perikanan, alat musik, dan sebagainya, yang semuanya dibuat dari bagian-bagian tanaman lokal.");
        value.put(KEY_LAT, "-6.598566");
        value.put(KEY_LNG, "106.794098");
        value.put(KEY_FOTO, "sejarah5");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Museum Pasir Angin");
        value.put(KEY_ALAMAT, "Desa Cemplang, Kecamata Cibungbulang, Kabupaten Bogor.");
        value.put(KEY_HARGA, "Rp 3.000/orang");
        value.put(KEY_OPERASIONAL, "08.00-16.00 WIB");
        value.put(KEY_DESKRIPSI, "Museum Pasir Angin didirikan pada tahun 1976 dengan tujuan awal sebagai tempat untuk menampung berbagai artefak yang ditemukan di lokasi Situs Pasir Angin. Berbagai artefak seperti arca batu, kapak perunggu, kapak besi dan gerabah disimpan di dalam Museum Pasir Angin. Meskipun demikian, ada banyak temuan yang tidak disimpan disini. Beberapa artefak yang paling berharga seperti sebuah topeng emas disimpan di Museum Nasional. Dalam perkembangannya, Museum Pasir Angin juga menyimpan berbagai temuan arkeologi dari berbagai situs di Bogor. Salah satunya adalah dari Situs Cibodas Ciampea dalam bentuk beberapa arca yang sudah tidak utuh lagi.");
        value.put(KEY_LAT, "-6.597888");
        value.put(KEY_LNG, "106.635036");
        value.put(KEY_FOTO, "sejarah6");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Kampung Budaya Sindang Barang");
        value.put(KEY_ALAMAT, "Jl. Endang Sumawijaya RT 02 / RW 08, Sindang Barang, Dukuh Menteng, Desa Pasir Eurih Kecamatan Tamansari, Bogor, Jawa Barat 16631.");
        value.put(KEY_HARGA, "Rp 4.000/orang");
        value.put(KEY_OPERASIONAL, "09.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Di Kampung budaya Sindangbarang terdapat 8 macam kesenian Sunda yang telah direvitalisasi dan dilestarikan oleh para penduduknya. Disini terdapat pula situs-situs purbakala peninggalan kerajaan Pajajaran berupa Bukit-bukit berundak.Di sindangbarang setiap satu tahun sekali diselenggarkan upacara adat Seren Taun yaitu upacara ungkapan rasa syukur masyarakat terhadap Tuhan Yang Maha Esa atas hasil Panen dan hasil bumi yang diperoleh pada tahun ini dan berharap hasil panen tahun depan akan lebih baik lagi.");
        value.put(KEY_LAT, "-6.630670");
        value.put(KEY_LNG, "106.761564");
        value.put(KEY_FOTO, "sejarah7");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Situs Gunung Padang");
        value.put(KEY_ALAMAT, "Jl. Alternatif Cibubur, Karyamukti, Campaka, Kabupaten Cianjur, Jawa Barat 43215.");
        value.put(KEY_HARGA, "Rp 3.000/orang");
        value.put(KEY_OPERASIONAL, "09.00-17.00 WIB");
        value.put(KEY_DESKRIPSI, "Situs Gunung Padang merupakan situs peninggalan kebudayaan Megalitikum di Jawa Barat. Luas kompleks utamanya kurang lebih 900 m2, terletak pada ketinggian 885 mdpl, dan area situs ini sekitar 3 hektar, menjadikannya sebagai kompleks situs berundak terbesar di Asia Tenggara. Lokasi situs berbukit-bukit dan sulit dijangkau. Kompleksnya memanjang, menutupi permukaan sebuah bukit yang dibatasi olej jejeran batu andesit besar berbentuk persegi. Situs ini dikelilingi oleh lembah-lembah yang sangat dalam. Tempat ini sebelumnya memang telah dikeramatkan oleh warga setempat. Penduduk sekitar menganggapnya sebagai tempat Prabu Siliwangi, raja Sunda, berusaha membangun istana dalam semalam.");
        value.put(KEY_LAT, "-6.993643");
        value.put(KEY_LNG, "107.056315");
        value.put(KEY_FOTO, "sejarah8");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
        //Record
        value.put(KEY_JUDUL, "Monumen Kujang");
        value.put(KEY_ALAMAT, "Jl. Raya Pajajaran no.1A, Baranangsiang, Bogor Timur, Tegallega, Kota Bogor, Jawa Barat. 16143.");
        value.put(KEY_HARGA, "Gratis");
        value.put(KEY_OPERASIONAL, "24 Jam");
        value.put(KEY_DESKRIPSI, "Tugu Kujang merupakan simbol yang melambangkan kota Bogor yang wujudnya diambil dari sebuah senjata pusaka yang berasal dari Jawa Barat. Tugu Kujang dibangun pada 4 Mei 1982 pada masa pemerintahan walikota Achmad Sobana dengan biaya pembangunan mencapai 80 juta. Tinggi Tugu kujang kira-kira sekitar 25 meter dari permukaan tanah dengan seluas 26 meter x 23 meter. Tugu Kujang terletak di simpang tiga jalan raya Padjajaran, Otista, dan Baranangsiang.");
        value.put(KEY_LAT, "-6.601476");
        value.put(KEY_LNG, "106.805095");
        value.put(KEY_FOTO, "sejarah9");
        value.put(KEY_FOTO_2, "kuliner1");
        value.put(KEY_TIPE, "3");
        db.insert(TABLE_SEJARAH, null, value);
    }

    // Upgrading database
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_KULINER);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_WISATA);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_SEJARAH);

        // Create tables again
        onCreate(db);
    }


    public ArrayList<Data> getAllKuliner() {
        ArrayList<Data> dataList = new ArrayList<Data>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_KULINER;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data data = new Data();
                data.set_id(Integer.parseInt(cursor.getString(0)));
                data.setJudul(cursor.getString(1));
                data.setAlamat(cursor.getString(2));
                data.setHarga(cursor.getString(3));
                data.setOperasional(cursor.getString(4));
                data.setDeskripsi(cursor.getString(5));
                data.setLat(cursor.getString(6));
                data.setLng(cursor.getString(7));
                data.setFoto(cursor.getString(8));
                data.setFoto2(cursor.getString(9));
                data.setTipe(cursor.getString(10));
                // Adding contact to list
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }

    public ArrayList<Data> getAllWisata() {
        ArrayList<Data> dataList = new ArrayList<Data>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_WISATA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data data = new Data();
                data.set_id(Integer.parseInt(cursor.getString(0)));
                data.setJudul(cursor.getString(1));
                data.setAlamat(cursor.getString(2));
                data.setHarga(cursor.getString(3));
                data.setOperasional(cursor.getString(4));
                data.setDeskripsi(cursor.getString(5));
                data.setLat(cursor.getString(6));
                data.setLng(cursor.getString(7));
                data.setFoto(cursor.getString(8));
                data.setFoto2(cursor.getString(9));
                data.setTipe(cursor.getString(10));
                // Adding contact to list
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }

    public ArrayList<Data> getAllSejarah() {
        ArrayList<Data> dataList = new ArrayList<Data>();
        // Select All Query
        String selectQuery = "SELECT * FROM " + TABLE_SEJARAH;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(selectQuery, null);

        // looping through all rows and adding to list
        if (cursor.moveToFirst()) {
            do {
                Data data = new Data();
                data.set_id(Integer.parseInt(cursor.getString(0)));
                data.setJudul(cursor.getString(1));
                data.setAlamat(cursor.getString(2));
                data.setHarga(cursor.getString(3));
                data.setOperasional(cursor.getString(4));
                data.setDeskripsi(cursor.getString(5));
                data.setLat(cursor.getString(6));
                data.setLng(cursor.getString(7));
                data.setFoto(cursor.getString(8));
                data.setFoto2(cursor.getString(9));
                data.setTipe(cursor.getString(10));
                // Adding contact to list
                dataList.add(data);
            } while (cursor.moveToNext());
        }

        // return contact list
        return dataList;
    }

}
