import java.util.Scanner
import java.nio.file.Paths

class HelloWorld {
    static void main(String[] args) {
        def currentDir = new File(".").absolutePath
        println currentDir
        def path = Paths.get(currentDir, "/test", "first-test.txt")
        println path.toFile().exists()
        if (path.toFile().exists()) {
            println path.toFile().text
        } else {
            println "File does not exist!"
            System.exit(0)
        }
        // Initialize the scanner with System.in (standard input)
        def scanner = new Scanner(System.in)

        print "Enter a full directory path: "
        def directory = scanner.nextLine() // Reads a full line of text

        print "Enter a word to find: "
        def word = scanner.nextLine() // Reads a full line of text

        def wf = new WordFinder(directory, word)
        println "${wf.path} ${wf.word}"
    }
}

class WordFinder {
    String path
    String word

    WordFinder(String path, String word) {
        this.path = path
        this.word = word
    }
}

