# liteforexdemo
Test Automation Demo Project
This project is a simple demonstration of running automated tests on an Android emulator for a sample application. It was created in a short timeframe (about 4 hours) and is intended solely as a basic example. Please note: This project is not suitable as a foundation for a fully-fledged automation framework, as it lacks the polish and robustness required for production use.

Features
Language: Java
Build Tool: Gradle
Test Framework: JUnit
Automation Tool: Appium (for Android testing)
Assertion Library: AssertJ-Core
Requirements
To run this project, ensure the following are installed and configured on your system:

Java Development Kit (JDK 17 or later)
Android SDK and Emulator
Appium (2.x or later)
Gradle (latest version)
How to Run
Clone the repository to your local machine.
Ensure your Android emulator is running:
bash
Копировать код
adb devices
You should see your emulator listed as emulator-5554 or similar.
Start the Appium server:
bash
Копировать код
appium
Run the tests using Gradle:
bash
Копировать код
./gradlew test
Limitations
Debugging challenges: Due to time constraints, some aspects of the project may be incomplete or error-prone.
Simplistic implementation: The project is a demo and does not follow best practices for scalability or maintenance.
