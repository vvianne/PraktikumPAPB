# Analisis Kode Praktikum 3

Aplikasi ini menggabungkan tiga komponen interaktif dalam satu layar untuk mendemonstrasikan bagaimana state tunggal dapat memicu perubahan pada banyak elemen UI.

### 1. Counter
* **Fungsi:** Menambah dan mengurangi nilai hitungan.
* **Batasan:** Nilai hitungan tidak dapat kurang dari nol.

### 2. Tombol Warna
* **Fungsi:** Mengubah warna sebuah Box (200x200 dp) secara bergantian antara Merah dan Hijau.

### 3. Profil
* **Fungsi:** Mengelola status "Follow/Unfollow" pada sebuah profil, yang secara simultan mengubah teks tombol dan indikator teks di bawahnya.

---

## Implementasi State di Jetpack Compose

Di Jetpack Compose, state adalah data yang dapat berubah seiring waktu dan akan memicu *recomposition* (penggambaran ulang) pada UI secara otomatis.

Menggunakan:

* **`remember { mutableStateOf(...) }`**: `mutableStateOf` menyimpan nilai yang dapat berubah, sementara `remember` memastikan nilai tersebut dipertahankan selama Composable berada dalam memori saat terjadi *recomposition*.
* **Delegasi Properti (`by`)**: menggunakan sintaks `var namaState by remember { mutableStateOf(nilaiAwal) }` untuk membuat akses ke nilai state lebih ringkas.

| Aplikasi | Nama State | Tipe Data | Peran |
| :--- | :--- | :--- | :--- |
| Counter | `count` | `Int` | Menyimpan nilai hitungan saat ini. |
| Toggle Warna | `isRed` | `Boolean` | Melacak apakah warna saat ini adalah Merah (`true`) atau Hijau (`false`). |
| Profil | `isFollowing` | `Boolean` | Melacak status pengguna: sedang diikuti (`true`) atau belum diikuti (`false`). |

Ketika nilai state (`count`, `isRed`, atau `isFollowing`) diubah, Compose secara cerdas hanya memperbarui Composable yang membaca state tersebut.

---

## Analisis: Compose vs. XML Tradisional

Pengelolaan UI interaktif dalam tugas ini menunjukkan keunggulan mendasar dari pendekatan Deklaratif (Compose) dibandingkan Imperatif (XML tradisional):

| Fitur | Jetpack Compose (Deklaratif) | XML Tradisional (Imperatif) |
| :--- | :--- | :--- |
| **Logika UI** | **Tunggal dan Terpadu.** Logika dan desain UI berada dalam satu file Kotlin (`@Composable`). | **Terpisah.** Desain di file XML, Logika di file Kotlin/Java (`Activity`/`Fragment`). |
| **Perubahan UI** | **Otomatis melalui State.** Cukup ubah nilai state (misalnya, `isFollowing = !isFollowing`), Compose akan mengurus pembaruan UI (tombol dan teks indikator) secara otomatis. | **Manual.** Membutuhkan **tiga** langkah: 1) `findViewById` untuk mendapatkan referensi View, 2) Menulis logika (misal: `if/else`), 3) Memanggil fungsi mutasi (misal: `button.setText()`). |
| **Keterbacaan** | **Sangat Tinggi.** UI secara langsung mencerminkan state yang digunakannya, membuatnya ringkas. | **Rendah untuk Interaktif.** Logika sering kali tersebar di *listener* dan *lifecycle method*, membuatnya kompleks. |
