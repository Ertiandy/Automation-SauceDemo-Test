# Final Project Automation Web & API Testing

Proyek ini merupakan otomatisasi pengujian web dan API menggunakan website [SauceDemo](https://www.saucedemo.com/) serta API dari [dummyapi.io](https://dummyapi.io/). Proyek ini dikembangkan menggunakan bahasa Java dan dibangun dengan Gradle, serta dilengkapi laporan pengujian menggunakan Allure.

---

## ⚖️ Build With

Proyek ini memanfaatkan beberapa library utama untuk mendukung pengujian otomatis:

* **Cucumber** – Menulis skenario pengujian dengan Gherkin
* **Selenium** – Automasi interaksi dengan web browser
* **WebDriverManager** – Manajemen driver browser otomatis
* **Rest Assured** – Automasi pengujian API
* **JUnit** – Framework eksekusi pengujian
* **AssertJ** – Library assertion untuk validasi hasil uji
* **Allure** – Reporting tool untuk hasil eksekusi pengujian

---

## ✅ Prerequisite

Sebelum menjalankan proyek ini, pastikan perangkat Anda telah memiliki:

1. JDK versi 8 atau lebih tinggi
2. Gradle Wrapper
3. Internet connection (untuk download dependency)
4. IDE seperti IntelliJ IDEA atau VSCode

---

## 💻 Installation

Langkah-langkah instalasi proyek:

1. Clone repository dari GitHub
2. Buka proyek menggunakan IDE favorit Anda
3. Pastikan konfigurasi Java dan Gradle sudah sesuai:

   * Java: arahkan ke folder instalasi JDK
   * Gradle: gunakan opsi "Use gradle wrapper"

---

## ⚙️ Gradle Configuration

File `build.gradle` telah dikonfigurasi dengan dependency berikut:

```groovy
plugins {
    id 'java'
    id 'io.qameta.allure' version '2.11.2'
}

repositories {
    mavenCentral()
}

dependencies {
    implementation 'org.seleniumhq.selenium:selenium-java:4.34.0'
    implementation 'io.github.bonigarcia:webdrivermanager:6.1.0'

    implementation 'io.cucumber:cucumber-java:7.24.0'
    testImplementation 'io.cucumber:cucumber-junit:7.24.0'
    testImplementation 'org.junit.vintage:junit-vintage-engine:5.9.3'
    testImplementation 'junit:junit:4.13.2'

    testImplementation 'io.rest-assured:rest-assured:5.4.0'
    testImplementation 'io.rest-assured:json-schema-validator:5.4.0'
    implementation 'org.json:json:20250517'
    testImplementation 'org.assertj:assertj-core:3.24.2'
}

test {
    useJUnit()
}

allure {
    version = '2.24.0'
    useJUnit4 {
        version = '2.24.0'
    }
    autoconfigure = true
    aspectjweaver = true
}
```

---

## 📁 Struktur Proyek

```
src
└── test
    ├── java
    │   ├── api
    │   │   ├── client
    │   │   │   └── ApiClient.java
    │   │   ├── data
    │   │   │   └── UserData.java
    │   │   ├── helper
    │   │   │   └── JsonSchemaValidatorHelper.java
    │   │   ├── pojo
    │   │   │   ├── CreateUserRequest.java
    │   │   │   └── UpdateUserRequest.java
    │   │   ├── steps
    │   │   │   └── ApiUserStep.java
    │   │   └── utils
    │   │       └── ScenarioContext.java
    │   ├── hooks
    │   │   └── Hooks.java
    │   └── web
    │       ├── pages
    │       │   ├── CheckoutPage.java
    │       │   ├── LoginPage.java
    │       │   └── SortingPage.java
    │       └── steps
    │           ├── CheckoutStep.java
    │           ├── LoginStep.java
    │           └── SortingStep.java
    └── resources
        ├── feature
        │   ├── api
        │   │   └── user.feature
        │   └── web
        │       ├── checkout.feature
        │       ├── login.feature
        │       └── sorting.feature
        └── schema
            ├── create_user_schema.json
            ├── get_user_schema.json
            ├── get_users_schema.json
            └── update_user_schema.json

```

Penjelasan:

📁 src/test
Folder utama untuk menyimpan semua kode dan resource pengujian (testing).

📂 java
Berisi seluruh kode Java untuk pengujian. Dibagi menjadi dua bagian besar:

1. 📂 api → Automation Test untuk API
📁 client
Tujuan: Menyimpan class untuk memanggil endpoint API menggunakan Rest Assured.

Contoh:
ApiClient.java: Fungsi getUserById(), createUser(), dll.

📁 data
Tujuan: Menyediakan test data atau data dummy untuk request API.

Contoh:
UserData.java: Static data user untuk create/update.

📁 helper
Tujuan: Menyediakan helper function untuk API testing.

Contoh:
JsonSchemaValidatorHelper.java: Validasi response JSON dengan schema.

📁 pojo
Tujuan: POJO (Plain Old Java Object) untuk memetakan request/response body JSON.

Contoh:
CreateUserRequest.java, UpdateUserRequest.java

📁 steps
Tujuan: Step definition untuk skenario Cucumber API.

Contoh:
ApiUserStep.java: Implementasi langkah-langkah seperti Given, When, Then.

📁 utils
Tujuan: Reusable utility class.

Contoh:
ScenarioContext.java: Menyimpan data antar step selama eksekusi.

2. 📂 web → Automation Test untuk Web UI (Selenium)
📁 pages
Tujuan: Page Object Model (POM), menyimpan semua locators & action di halaman.

Contoh:
LoginPage.java, CheckoutPage.java, SortingPage.java

📁 steps
Tujuan: Step definition untuk skenario Cucumber Web UI.

Contoh:
LoginStep.java, CheckoutStep.java, SortingStep.java

3. 📁 hooks
Tujuan: Inisialisasi sebelum dan sesudah test.

Contoh:
Hooks.java: Inisialisasi dan teardown WebDriver.

📂 resources
📁 feature
Tujuan: Menyimpan file skenario Cucumber .feature.

📂 web
- login.feature: Test login positif & negatif.
- checkout.feature: Test checkout (lengkap atau error).
- sorting.feature: Test sorting item.

📂 api
user.feature: Test Get, Create, Update, Delete user.

📁 schema
Tujuan: Menyimpan file JSON Schema untuk validasi response API.

Contoh:
- get_users_schema.json
- create_user_schema.json
- update_user_schema.json

---

## 🚀 Menjalankan Testing

### 💻 Via Terminal

```bash
./gradlew clean build
./gradlew test
```

Menjalankan Allure Report:

```bash
allure serve build/allure-results
```

### 🤖 Via IDE

Klik kanan pada `TestRunner` → Run

---

## 🧐 Test Case

### Web: SauceDemo

1. Standard login
2. Invalid login
3. Boundary login
4. Sorting by Price (low to high)
5. Sorting by Price (high to low)
6. Sorting by Name (A to Z)
7. Sorting by Name (Z to A)
8. Checkout - Add to cart
9. Checkout - Fill customer info
10. Checkout - Finish purchase

### API: DummyAPI.io

1. Get All Users (valid & invalid)
2. Get User by ID (valid & not found)
3. Create User
4. Update User by ID
5. Delete User by ID

---

## ⚙️ CI/CD: GitHub Actions

Pipeline berjalan otomatis setiap ada perubahan pada branch `main`. Tahapan:

1. Setup environment dan dependency
2. Eksekusi test (Web & API)
3. Generate laporan Allure
4. Upload hasil laporan ke GitHub Pages

---

## 🧪 Metodologi Pengujian

* Black-box Testing
* Unit Level Testing per fitur
* Pendekatan BDD dengan Gherkin

---

## 👨‍💼 Author

> **Ertiandy Waluyo**
> Calon QA Engineer

---

## 📚 Referensi

* [Selenium Documentation](https://www.selenium.dev/documentation/)
* [Cucumber Docs](https://cucumber.io/docs/cucumber/)
* [JUnit 4 Docs](https://junit.org/junit4/)
* [Gradle Installation](https://gradle.org/install/)
* [Allure Report Guide](https://docs.qameta.io/allure/)
