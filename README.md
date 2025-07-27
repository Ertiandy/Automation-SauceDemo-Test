# Automation-SauceDemo-Test
Automated UI testing for saucedemo.com using Java, Selenium, and Cucumber
# SauceDemo Automation Test

Proyek ini adalah otomatisasi pengujian pada website [SauceDemo](https://www.saucedemo.com) menggunakan Selenium, Cucumber, dan JUnit.

**Tools**
- Java 11+
- Gradle
- Selenium WebDriver
- JUnit 4
- Cucumber JVM
- IntelliJ IDEA

**Struktur Project**
src
├── test
│ ├── java
│ │ ├── web.pages
│ │ └── steps
│ └── resources
│ └── feature


**Cara Menjalankan**


1. Clone Repositori
```bash
git clone https://github.com/Ertiandy/Automation-SauceDemo-Test.git
cd Automation-SauceDemo-Test

**2. Jalankan Tes**
Dengan Gradle : ./gradlew test

Atau dari IntelliJ
- Buka file CucumberTest.java
- Klik kanan → Run 'CucumberTest'

Fitur yang Diuji :
**1 Login :**
- Standard login
- Invalid login
- Boundary login

**2. Filter Produk**
- Sorting by Price (low to high)
- Sorting by Price (high to low)
- Sorting by Name (A to Z)
- Sorting by Name (Z to A)

**3. Checkout**
- Add to cart
- Fill customer info
- Finish purchase

