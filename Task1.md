📝 Exploratory Testing Report – Monefy (Android)

Tester: Shubham Pandya
Application: Monefy – Budget & Expenses
Version Tested: 1.22.8
Devices Used:

Samsung Galaxy S22 (Android 16)

- Samsung Galaxy Tab A (Android 8)
- Testing Type: Exploratory Testing
Timebox: 2 Hours

🎯 Testing Objectives

- Validate core functionality (income and expense tracking)

- Verify data persistence and balance integrity

- Identify usability issues and UI inconsistencies

- Explore edge cases and error handling behavior

- Assess overall stability and performance

🔎 Key Charters & Findings
1️⃣ App Launch & First-Time User Experience

Goal: Validate onboarding flow and initial dashboard behavior.

Observations

- Onboarding quiz loads successfully and transitions to dashboard.

- First-time user tips are displayed on the dashboard.

- No option to create a personalised account (local-only data storage).

Issues Identified

- Android Back Button Behavior

- Pressing the Android Back button after launch does not close the app.

- Rapidly pressing Back (2–3 times) navigates unexpectedly to the “Add Income / Add Expense” screen.

- Behavior is inconsistent with standard Android navigation expectations.

Currency Change Tip Persistence

- The “Change Currency” tip in Settings does not disappear even after user interaction.

Severity: Medium
Navigation inconsistency affects usability but not financial logic.

2️⃣ Transactions (Income & Expense Flow)

Goal: Validate adding income and expenses and balance accuracy.

Observations

- Income and expense transactions update correctly.

- Balance calculations (addition, subtraction, multiplication, division) work correctly.

- During calculations, only the current number is visible — previously entered values are hidden, reducing clarity.

- Budget mode is global for all months and does not allow month-specific budgeting flexibility.

Severity: High (Core Feature)

Core financial functionality is stable but UX clarity can be improved.

3️⃣ Category & Dashboard UI

Goal: Validate dashboard charts, category visualization, and UI responsiveness.

Observations

- Category chart updates dynamically based on expense distribution.

- No graphical representation is available for income categories.

- When a category is removed, the chart leaves empty spaces instead of re-adjusting layout.

- Category icons are small and sometimes difficult to tap accurately.

Severity: Low–Medium
Primarily usability and layout improvements.

4️⃣ Data Persistence

Goal: Validate transaction retention across lifecycle events.

Scenarios Tested

- App restart

- Background / foreground transitions

- Force stop

- Device reboot

- Clear cache

- Clear storage

Observations

- Transactions remained intact after restart, force stop, and reboot.

- Balance calculations remained accurate.

- Clearing cache did not affect stored data.

- Clearing storage correctly reset the application and triggered onboarding.

- No data loss, corruption, or incorrect recalculation was observed.

- Severity: High (Critical Risk Area – Passed)

5️⃣ Error Handling & Edge Cases

Goal: Validate behavior under invalid and boundary conditions.

Observations

- Large numeric values are accepted without warning.

- The application does not provide explicit validation messages.

- Rapid inputs and repeated actions did not cause crashes.

- No incorrect balance calculations were observed.

Issues

- No warning for extremely large values.

- Minimal user-facing validation feedback.

Severity: Medium
Risk of user misunderstanding due to lack of validation messaging.

| Priority      | Area                    | Justification                                                  |
| ------------- | ----------------------- | -------------------------------------------------------------- |
| 🔴 High       | Transactions            | Core functionality; incorrect handling breaks primary purpose  |
| 🔴 High       | Data Persistence        | Financial data integrity is critical for user trust            |
| 🟠 Medium     | App Launch & Navigation | Navigation inconsistency impacts UX                            |
| 🟠 Medium     | Error Handling          | Lack of validation messaging may affect reliability perception |
| 🟢 Low–Medium | Category & Dashboard UI | Usability improvements; not blocking functionality             |

| Risk                          | Mitigation Strategy                               | Impact     |
| ----------------------------- | ------------------------------------------------- | ---------- |
| Incorrect balance calculation | Automated regression tests for transaction logic  | High       |
| Data loss after restart/crash | Persistent storage validation tests               | High       |
| Navigation inconsistency      | Align Back-button behavior with Android standards | Medium     |
| Lack of input validation      | Implement numeric limits and user feedback        | Medium     |
| Small tap targets             | Increase touch area for icons                     | Low–Medium |
| Budget rigidity               | Support month-based configurable budgets          | Medium     |

✅ Overall Conclusion

- Core financial functionality is stable and reliable.

- Data persistence is robust across lifecycle events.

- Improvements recommended in:

    - Navigation consistency

     - Input validation feedback

     - Dashboard usability refinements

     - Budget flexibility

The application is functionally stable but would benefit from UX and validation improvements before large-scale release.
