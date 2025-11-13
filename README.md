# FastTrackIT UI Automation

Production-ready Selenium + JUnit 5 automation framework targeting https://fasttrackit.org with Page Object Model, reusable utilities, and clearly separated smoke/regression suites.

## 1. Prerequisites

| Tool | Install command |
| --- | --- |
| Java 17 | **Windows:** `winget install --id Microsoft.OpenJDK.17`  •  **macOS:** `brew install openjdk@17`  |
| Maven 3.9+ | Bundled with IntelliJ or install via `winget install Apache.Maven` / `brew install maven` |
| Git | https://git-scm.com/downloads |
| IntelliJ IDEA | https://www.jetbrains.com/idea/download/ |

Verify Java & Maven:

```bash
java -version
mvn -version
```

## 2. Project Setup in IntelliJ

1. `git clone https://github.com/<your-org>/fasttrackit-automation.git`
2. `File` → `Open...` → select the cloned folder → choose *Maven* model if prompted.
3. Allow IntelliJ to import Maven dependencies.
4. Set the Project SDK to 17 (`File` → `Project Structure` → `SDKs`).

## 3. Running Tests

### IntelliJ
- Right-click `src/test/java/tests/smoke` → **Run 'Tests in smoke'** for the smoke suite.
- Right-click any `*Test.java` for targeted execution (e.g., `CartRegressionTest`).

### Maven CLI
```bash
mvn clean test                           # run everything
mvn -Dtest=tests.smoke.* test            # smoke suite only
mvn -Dtest=CartRegressionTest test       # single class
mvn -Dtest=CartRegressionTest#shouldAddProductToCart test
```

## 4. Architecture

```
src/
├── main/java/pages         # Page Object classes (Home, Login, Product, Cart, Checkout)
├── main/java/utils         # DriverFactory, waits, config, reusable test data
└── test/java/tests         # BaseTest + smoke/regression packages (AAA + one-assertion)
```

- `DriverFactory` uses WebDriverManager to version browsers automatically.
- `WaitUtils` abstracts explicit waits and DOM-ready checks (no `Thread.sleep`).
- `AppConfig` centralizes URLs, credentials, and timeouts.
- `TestData` holds reusable billing info and keywords.

## 5. Checkout Flow Data

Default credentials and billing data live in `AppConfig` and `TestData`. Update these once a dedicated QA account is available.

## 6. Git & GitHub

```bash
git checkout -b feature/automation
# add or update files
git status
git add .
git commit -m "Add Selenium framework baseline"
git push origin feature/automation
```

Open a pull request on GitHub for review.

## 7. Packaging / Zip

Create a distributable archive ready for handoff:

```powershell
Compress-Archive -Path "pom.xml","README.md","src" -DestinationPath fasttrackit-automation.zip -Force
```

(Use `zip -r fasttrackit-automation.zip src pom.xml README.md` on macOS/Linux.)

## 8. Additional Commands

- `mvn dependency:tree` – audit dependency graph.
- `mvn -DskipTests clean package` – produce a jar when tests aren’t required.
- `mvn -pl . -am verify` – full verify lifecycle for CI.

## 9. Troubleshooting

- Chrome version mismatch → delete the cached driver (`~/.cache/selenium`) and re-run tests.
- Element timing issues → adjust `AppConfig.DEFAULT_TIMEOUT`.
- Headless runs → set `CHROME_OPTS=--headless=new` and update `DriverFactory` to read it.

Happy testing!
