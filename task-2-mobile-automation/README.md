# Monefy Mobile Test Automation Framework

This project contains an automated mobile test framework for the Monefy Android application using Appium, Java, and JUnit 5.

The framework covers selected end-to-end user flows and demonstrates a clean, maintainable Page Object Model (POM) structure.

---

## 📱 Covered Test Scenarios

The following test cases are automated:

1. Driver Boot Test
    - Verifies that the application launches successfully and reaches the dashboard.

2. Add Expense Test
    - User opens the expense screen
    - Enters an amount
    - Selects a category
    - Verifies return to dashboard

3. Cancel Income Test
    - User opens income screen
    - Cancels the transaction
    - Verifies return to dashboard

4. Income Category Validation Test
    - User opens income flow
    - Navigates to category list
    - Verifies that "Salary" category exists

---

## 🏗 Framework Structure

The project follows a simple Page Object Model (POM):
src/test/java
├── base
│ ├── BaseTest.java
│ └── DriverFactory.java
├── pages
│ ├── HomePage.java
│ ├── TransactionPage.java
│ ├── CategoryPage.java
│ └── OnboardingPage.java
└── tests
├── DriverBootTest.java
├── AddExpenseTest.java
├── CancelIncomeTest.java
└── IncomeCategoryTest.java

- `base` → Driver setup and teardown
- `pages` → Page classes encapsulating UI interactions
- `tests` → Clean and readable test scenarios

---

## ⚙️ Setup Instructions

### 1️⃣ Prerequisites

- Java 17+
- Node.js
- Appium Server (v2+)
- Android Studio
- Android Emulator or real device
- Maven

---

### 2️⃣ Start Appium Server

```bash
appium

Server should run on:
http://127.0.0.1:4723/

3️⃣ Start Android Emulator

Open Android Studio → Device Manager → Start emulator

How to Run Tests

From the project root:
mvn clean test

📊 Test Report

After execution, reports are generated in:
target/surefire-reports

🧠 Tech Stack Explanation
Java

Chosen for strong OOP support and industry-standard usage in test automation.

Appium

Used for mobile automation because it supports native Android automation using UiAutomator2.

JUnit 5

Used as the test runner for:

Modern annotations

Clean assertions

Good IDE support

Maven

Used for:

Dependency management

Test execution

Report generation

🧩 Approach & Design Decisions
1️⃣ Simplicity First

The framework was intentionally kept simple and readable.
No over-engineering or unnecessary abstraction layers were introduced.

2️⃣ Page Object Model

Each screen is represented as a class:

Keeps test code clean

Improves maintainability

Makes test cases easy to understand

3️⃣ Stable Element Strategy

For dashboard interaction:

Used coordinate-based tapping for expense/income buttons

Avoided unstable text-based locators

For category validation:

Used UiScrollable to ensure reliability

4️⃣ Clean Test Philosophy

Each test:

Covers one clear business flow

Is readable

Has a clear assertion

Can run independently

🎯 Why This Framework Works Well

Easy to understand

Easy to extend

Easy to debug

Minimal flaky logic

Focused on core user flows