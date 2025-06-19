# 🧪 Java Selenium Automation Framework

This is a modular and scalable test automation framework built using **Java**, **Selenium WebDriver**, **TestNG**, **Allure Reporting**, **Log4j2**, **Apache Commons IO**, and **JSON handling** — all managed via **Maven**.

It supports test execution, logging, reporting, and data-driven testing.

---

## 🚀 Tech Stack

| Tool              | Purpose                              |
|-------------------|--------------------------------------|
| Java              | Programming language                 |
| Selenium WebDriver| UI automation                        |
| TestNG            | Test framework                       |
| Maven             | Dependency management & build tool   |
| Allure            | Beautiful test reports               |
| Log4j2            | Logging mechanism                    |
| Apache Commons IO | File handling & utilities            |
| JSON (org.json)   | Data-driven tests & config           |

---

## 📁 Project Structure


┣ 📂 main
┃ ┗ 📂 java
┃ ┣ 📂 config # Configuration reader classes
┃ ┣ 📂 pages # Page Object Model classes
┃ ┣ 📂 utils # Utility classes (waits, screenshots, json readers)
┃ ┗ 📂 logger # Log4j2 config
┣ 📂 test
┃ ┗ 📂 java
┃ ┗ 📂 tests # TestNG test classes
┣ 📂 resources
┃ ┣ 📄 config.properties # Configuration settings
┃ ┣ 📄 log4j2.xml # Log4j2 config file
┃ ┣ 📄 testdata.json # Test data for data-driven testing
┃ ┗ 📄 testng.xml # TestNG suite definition
┣ 📂 allure-results # Generated test result files for Allure
┣ 📂 screenshots # (Optional) Screenshots on failure
┣ 📄 pom.xml # Maven configuration


---

## ⚙️ Setup Instructions

### 1. ✅ Clone the Repository

```bash
git clone https://gitlab.com/your-username/selenium-java-framework.git
cd selenium-java-framework

📦 Install Dependencies
mvn clean install

🙋‍♂️ Author
Mahmoud Rashad Elhamrawi
Software Test Engineer
