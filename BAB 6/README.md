# 🧭 Navigasi dengan Jetpack Compose

## 📖 Deskripsi Singkat
Pada bab ini, aplikasi **NavApp** dibuat menggunakan **Jetpack Compose** dan **Navigation Component**.  
Navigation Compose memudahkan developer untuk berpindah antar layar, mengirim data, dan mengelola back stack otomatis tanpa menulis kode navigasi kompleks.

Aplikasi ini memiliki tiga layar utama:
- 🏠 **HomeScreen** – Halaman utama dengan tombol menuju DetailScreen dan ProfileScreen.
- 📄 **DetailScreen** – Menampilkan data yang dikirim dari HomeScreen.
- 👤 **ProfileScreen** – Halaman profil yang bisa diakses dari HomeScreen.

---

## 🔧 Fitur Utama
- 📍 **Navigasi antar screen** menggunakan `NavController`.
- 📨 **Kirim data antar screen** melalui parameter.
- 🔄 **Back stack otomatis**, memungkinkan navigasi maju & mundur tanpa error.
- 🗺️ **Navigation Graph** untuk mengatur semua route di satu tempat.
