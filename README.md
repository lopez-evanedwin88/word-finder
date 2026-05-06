# Word Finder (Groovy CLI)

This is a simple Groovy command-line application that searches for a specific word inside a file and reports how many matches were found.

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

```bash
groovy init.groovy
```

## 🧠 How It Works

1. The program will prompt you to enter a full file path.
2. Then, it will ask for a word to search.
3. It scans the file and counts how many times the word appears.
4. Finally, it displays the results.

## 📌 Example Usage

```
Enter a full directory path: test/first-test.txt
Enter a word to find: wew
```

### Example Test File Content

```
wew
wew123
wew456
this is me coding groovy
```

### Output

```
File found: test/first-test.txt and word found: wew
Here are 3 matches found
```

## 🧪 Sample Run

```
Enter a full directory path: /first-test.txt
Enter a word to find: wew
File found: /first-test.txt and word found: wew
Here are 3 matches found
```

## 🛠 Notes

* A sample test file is available at `test/first-test.txt`.
* You are free to modify the test file or create your own.
* Ensure the file path you enter exists and is accessible.

## 📄 License

This project is open for modification and personal use.

