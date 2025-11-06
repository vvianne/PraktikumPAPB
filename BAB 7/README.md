# 🧩 Mengelola Data Dengan Room

## 📖 Deskripsi Singkat
Pada bab ini, aplikasi *To-Do List* dikembangkan menggunakan **Room Database** sebagai penyimpanan lokal.  
Room berperan sebagai jembatan antara aplikasi dan database SQLite, supaya kita bisa mengelola data (CRUD) tanpa harus nulis query mentah secara manual.

Aplikasi ini memungkinkan pengguna untuk:
- ✨ Menambahkan tugas baru (*Create*)
- 📋 Menampilkan daftar tugas (*Read*)
- ✅ Mengubah status tugas (centang/sudah selesai – *Update*)
- 🗑️ Menghapus tugas (*Delete*)
- 📝 Mengedit nama tugas (*Update Title*, fitur tambahan)

---

## 🔧 Fitur Tambahan: Edit Task
Fitur baru yang ditambahkan memungkinkan pengguna untuk **mengubah nama tugas** secara langsung dari daftar.  
Saat teks tugas diklik, akan muncul *dialog* untuk mengedit nama. Setelah disimpan, judul langsung berubah di tampilan dan di database.  
Fitur ini memperkaya interaksi pengguna dan memperlihatkan bagaimana data di Room bisa diperbarui secara *real-time* melalui Compose.

---

## 📸 Hasil Uji CRUD
Berikut hasil pengujian fungsi CRUD pada aplikasi:
1. **Create** – Menambahkan tugas baru ke daftar.  
2. **Read** – Menampilkan seluruh tugas tersimpan.  
3. **Update (Status)** – Menandai tugas sebagai selesai/tidak selesai.  
4. **Update (Nama Tugas)** – Mengubah nama tugas melalui dialog edit.  
5. **Delete** – Menghapus tugas dari daftar.
