# Analisis Kode Aplikasi Profil

### Penjelasan Singkat Kode

Aplikasi ini dibangun menggunakan Jetpack Compose untuk menampilkan antarmuka profil sederhana. Berikut adalah komponen utama dalam kode `MainActivity.kt`:

-   **`@Composable fun ProfileScreen()`**: Fungsi utama yang menyusun seluruh UI. Fungsi ini didekorasi dengan `@Composable` agar dapat digunakan oleh Jetpack Compose.
-   **`val isFollowing by remember { mutableStateOf(false) }`**: Menggunakan `state` (`mutableStateOf`) untuk mengelola status tombol "Follow". `remember` memastikan bahwa nilai `isFollowing` tidak di-reset saat UI di-compose ulang. `by` adalah delegasi properti yang memudahkan akses nilai dari `mutableState`.
-   **`Column`**: Digunakan untuk menata komponen-komponen secara vertikal. `Modifier.fillMaxSize()`, `horizontalAlignment = Alignment.CenterHorizontally`, dan `verticalArrangement = Arrangement.Center` memastikan seluruh konten berada di tengah layar, baik secara horizontal maupun vertikal.
-   **`Image`**: Menampilkan foto profil dari sumber daya `drawable`. `Modifier.clip(CircleShape)` dan `.size(120.dp)` digunakan untuk membuat foto berbentuk lingkaran dan menentukan ukurannya.
-   **`Text`**: Menampilkan informasi teks seperti nama, NIM, dan deskripsi. Berbagai `Modifier` digunakan untuk mengatur ukuran (`fontSize`), berat font (`fontWeight`), dan warna (`color`).
-   **`Spacer`**: Digunakan untuk memberikan jarak kosong antar komponen.
-   **`Button`**: Komponen tombol yang memiliki logika `onClick`. Teks di dalam tombol (`Text(text = if (isFollowing) "Unfollow" else "Follow")`) akan berubah berdasarkan nilai `isFollowing` yang dikelola oleh `state`.

### Analisis Singkat Keuntungan

1.  **Pendekatan Deklaratif** dengan Jetpack Compose memungkinkan kita mendefinisikan UI dengan cara yang lebih ringkas. Kita hanya perlu mendeklarasikan bagaimana UI seharusnya terlihat, dan Compose akan mengelola perubahan yang terjadi, seperti perubahan teks pada tombol.

2.  **Manajemen State yang Efisien** yaitu dengan adanya penggunaan `mutableStateOf` dan `remember` mempermudah pengelolaan data yang berubah. Ketika `isFollowing` diubah, Compose secara otomatis melakukan recomposition pembaruan UI hanya pada bagian yang terpengaruh yaitu tombol, tanpa harus menulis kode `findViewById` atau memanipulasi View secara manual.

3.  **Pengaturan Layout yang Fleksibel** dengan `Modifier` menawarkan cara yang sangat fleksibel untuk memodifikasi tampilan dan perilaku komponen misalnya, padding, ukuran, latar belakang, dan clipping.

4.  **Kode yang Lebih Sederhana dan Reusable** dengan omponen `@Composable` juga dapat digunakan kembali di bagian lain aplikasi, mengurangi duplikasi kode.
