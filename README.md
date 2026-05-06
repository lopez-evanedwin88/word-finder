# Word Finder (Groovy CLI)

This application searches for a specific word within files in a given directory and optionally replaces it.

## 📦 Requirements

Make sure you have **Groovy** installed on your system.

### Install Groovy CLI

You can install Groovy using one of the following methods:

* **SDKMAN (recommended):**

  ```bash
  curl -s "https://get.sdkman.io" | bash
  sdk install groovy
  ```

* **Homebrew (macOS):**

  ```bash
  brew install groovy
  ```

* **APT (Ubuntu/Debian):**

  ```bash
  sudo apt install groovy
  ```

Verify installation:

```bash
groovy -version
```

## 🚀 How to Run

Execute the script using the Groovy CLI:

## Usage

```bash
groovy init.groovy <path> <word> <replace>
```

### Parameters

* `<path>` – The directory to search in
* `<word>` – The word to look for
* `<replace>` – The word that will replace the matched word

## How It Works

1. The application scans all files within the specified directory.
2. It searches for occurrences of the given word.
3. It counts how many matches are found.
4. It outputs:

   * The file name
   * Number of matches
   * Original file content
   * Updated content after replacement

## Example

```bash
groovy init.groovy test test test
```

### Test File

`test/first-test.txt` contains:

```text
test
test123
test456
this is me coding groovy
```

### Output

```text
File: test/first-test.txt
Matches: 3

---- Original ----
Original:
    test
    test123
    test456
    this is me coding groovy

---- Replace ----
Replace:
    test
    test123
    test456
    this is me coding groovy
```

## Notes

* You are free to modify the test files or create new ones.
* Nested directories are supported, but use them at your own discretion.
* Always review changes when using the replace feature, as it may overwrite content.

