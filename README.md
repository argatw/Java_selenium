# Java Selenium Automation Playground

This repository is a **lightweight Java + Selenium + Maven setup** used for hands-on practice, interview preparation, and rapid experimentation with UI automation concepts.

The goal is **clarity over complexity** — focusing on solid fundamentals such as waits, synchronization, Page Object design, and realistic user flows, rather than building a heavy framework prematurely.

---

## Tech Stack

- **Java** (JDK 17+)
- **Selenium WebDriver 4**
- **Maven**
- **WebDriverManager**
- **ChromeDriver**
- Explicit waits (`WebDriverWait`, `ExpectedConditions`)

---

## Project Structure

src/main/java/com
├── example // Java scratchpad (DS/Algo, quick experiments)
├── pages // Page Object / locator classes
└── tests // Standalone test flows (entry points)


### `example`
- Used as a **sandbox** for:
  - Java language practice
  - Data structures & algorithms
  - Quick exploratory test automation scripts that utilize inline only (no POM)
- Intentionally kept separate from automation code.

### `pages`
- Contains **Page Object–style classes**.
- Responsibility:
  - Store element locators
  - Encapsulate wait logic
- No test flow logic inside.

### `tests`
- Contains **executable automation flows**.
- Each class demonstrates:
  - Realistic user journeys
  - Explicit synchronization
  - Defensive cleanup (`try / catch / finally`)
  - Minimal but meaningful console logging
  - POM usage from pages

---

## Key Concepts Practiced

### Explicit Waits (No Hard Sleeps)
- Avoids `Thread.sleep` except when diagnosing issues.
- Waits are tied to **state readiness**, not just element presence.
- Example patterns:
  - Waiting for post-login indicators
  - Waiting for dropdown options to populate asynchronously

### Handling Async Data Readiness
- Demonstrates waiting for:
  - `<option>` elements inside `<select>` tags
  - Backend-driven UI updates
- Avoids fragile timing assumptions.

### Page Object Model (Lightweight)
- Constructor-based injection of `WebDriver`
- Locators defined once
- Test classes remain readable and intention-driven

### Defensive Teardown
- Uses `finally` blocks to guarantee:
  - Browser cleanup
  - Execution timing logs
- Prevents orphan browser sessions on failure.

---

## Sample Scenarios Covered

- Basic login flows
- Post-login navigation
- Dropdown interaction using `Select`
- Transaction-style flows (e.g. account creation)
- Extracting and logging business data (e.g. generated account numbers)

These scenarios intentionally go **beyond simple `sendKeys()` demos** to reflect real-world automation challenges.

---

## Logging Philosophy

- Console logging is **minimal and checkpoint-based**
- Logs focus on:
  - Key user actions
  - Flow transitions
  - Business-relevant outcomes
- Avoids noisy per-locator logging

Example:
[login1] Navigating to login page
[login1] Login successful
[login1] New account created: 13677


---

## Why This Repo Exists

This project is **not** intended to be a full production framework.

Instead, it serves as:
- A **clean reference baseline** for Java Selenium automation
- A fast starting point for **pair programming or live coding**
- A comparison point when evaluating **modern tools like Playwright**

---

## Notes

- Credentials used are demo-only (public test sites).
- This repo evolves incrementally as concepts are explored.
- Heavier abstractions (BaseTest, listeners, reporting, CI) are intentionally deferred.

---

## Next Steps (Out of Scope for This Repo)

- Equivalent baseline in **TypeScript + Playwright**
- TestNG / JUnit integration
- CI pipeline setup
- Reporting & screenshots on failure

These are explored separately to keep this project focused and readable.

---

## Disclaimer

This repository is for **learning and interview preparation purposes only** and is not affiliated with any third-party demo systems used.
