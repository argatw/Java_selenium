# Java Selenium Automation Playground

This repository is a **lightweight Java + Selenium + Maven automation setup** used for learning, experimentation, and interview preparation.

The focus is on:
- clean project structure
- correct Selenium synchronization (explicit waits)
- basic Page Object Model (POM) usage
- readable, debuggable test flows

It is intentionally kept **simple and framework-light**, so it can be quickly extended or refactored during live coding or pair-programming sessions.

---

## Tech Stack

- Java
- Selenium WebDriver
- Maven
- WebDriverManager
- ChromeDriver

---

## Project Structure

```
src/main/java/com
├─ example     → simple standalone Java scripts / scratchpad
├─ pages       → Page Object Model (locators + waits)
└─ tests       → test scripts that drive flows using POM
```

### `example/`
Contains **basic inline Java scripts** and quick experiments.
- Used for simple Selenium exploration
- Can also be used for Java fundamentals / DS & Algo practice
- No abstraction, minimal ceremony

### `pages/`
Contains **Page Object Model (POM)** classes.
- Encapsulates element locators and explicit wait logic
- Keeps test scripts DRY and readable
- Uses constructor-based dependency injection (`WebDriver`)

Example responsibilities:
- locating elements
- waiting for elements to be ready
- exposing elements or simple actions

### `tests/`
Contains **test scripts / flow drivers**.
- Uses page objects from `pages/`
- Focuses on user flows and intent, not locators
- Includes simple, checkpoint-based console logging for debugging

---

## Key Concepts Practiced

- Explicit waits (`WebDriverWait`)
- Avoiding `Thread.sleep` where possible
- Waiting for **state and data readiness**, not just element presence
- Dropdown handling using `Select`
- Phased test flows (login → checkpoint → action)
- Clean browser teardown using `try / catch / finally`
- Minimal but meaningful console logging

---

## Example Flow Implemented

- Login to Parabank demo application
- Wait for post-login state
- Navigate to “Open New Account”
- Handle dropdowns populated asynchronously
- Submit new account request
- Capture and print generated account number

This flow intentionally goes beyond simple `sendKeys` to practice:
- navigation
- dropdowns
- async UI behavior
- transactional confirmation handling

---

## Running the Project

From the project root:

```bash
mvn clean compile
```

Run individual scripts directly via their `main()` methods.

> Note: This project does not yet use a test runner (e.g. TestNG/JUnit) by design.  
> It is structured to be easily extended into one if needed.

---

## Design Philosophy

- Start simple
- Introduce abstraction only when duplication appears
- Prefer clarity over heavy frameworks
- Optimize for **live coding, debugging, and interview explanation**

This repository serves as a **personal reference baseline** that can be quickly adapted into larger automation frameworks when required.

---

## Future Extensions (Optional)

- Move test scripts to `src/test/java`
- Add TestNG or JUnit
- Introduce BasePage / BaseTest abstractions
- Add reporting or CI integration
- Parallel browser execution

---

## Disclaimer

This repository is intended for learning and demonstration purposes.  
Credentials and test data are placeholders only.
