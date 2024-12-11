# liteforexdemo
# Test Automation Demo Project

This project is a **demonstration** of running automated tests on an Android emulator for a sample application. **It is not a production-ready solution and should not be used as a foundation for real-world automation projects.** The purpose of this project is to showcase basic automation capabilities within a short timeframe.

---

## Disclaimer

⚠️ **This is a demo project** and is provided **as-is** for demonstration purposes only.  
- **This is not a production-ready solution.**  
- **Do not use it as a base for large-scale automation projects or critical environments.**

The project was built in approximately **4 hours**, meaning it lacks the depth, robustness, and structure required for a fully-fledged automation framework. It is meant to serve as an example and may contain bugs or inefficiencies.

---

## Features

- **Language:** Java  
- **Build Tool:** Gradle  
- **Test Framework:** JUnit  
- **Automation Tool:** Appium (for Android testing)  
- **Assertion Library:** AssertJ-Core

---

## Requirements

To run this project, ensure the following are installed and configured on your system:

- **Java Development Kit (JDK 17 or later)**
- **Android SDK and Emulator**
- **Appium (2.x or later)**
- **Gradle (latest version)**

---

## How to Run

1. Clone the repository to your local machine.
2. Ensure your Android emulator is running:
   ```bash
   adb devices
   ```
   You should see your emulator listed as `emulator-5554` or similar.
3. Start the Appium server:
   ```bash
   appium
   ```
4. Run the tests using Gradle:
   ```bash
   ./gradlew test
   ```

---

## Implemented Tests

### 1. Close Help Screen

Verifies that the informational overlay on the home screen can be dismissed by tapping on it.

```java
@Test
public void testCloseHelpScreen() {
    WebElement infoOverlay = driver.findElement(By.id("intro_image"));
    tapOnScreenByElement(infoOverlay);

    boolean isHelpClosed = driver.findElements(By.id("intro_image")).isEmpty();
    assertTrue(isHelpClosed, "The help screen was not closed.");
}
```

---

## Limitations

- **Debugging challenges:** Due to time constraints, some aspects of the project may be incomplete or error-prone.
- **Simplistic implementation:** The project is a demo and does not follow best practices for scalability or maintenance.

