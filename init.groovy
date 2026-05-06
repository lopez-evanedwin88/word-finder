import java.util.Scanner
import java.nio.file.Paths

class HelloWorld {
    static void main(String[] args) {
        print '''
        This is a application that will find a word in a file
        First you will be asked to enter a full directory path
        Then you will be asked to enter a word

        Example:
        Enter a full directory path: test/first-test.txt
        Enter a word to find: wew

        I have setup a test file at test/first-test.txt
        It contains the following text:
        wew
        wew123
        wew456
        this is me coding groovy

            Then it will print:
            File found: test/first-test.txt and word found: wew
            Here are 3 matches found

        You are free to modify the test file or the other files
        '''
        println("")
        def wf = new WordFinder("", "")
        // Initialize the scanner with System.in (standard input)
        def scanner = new Scanner(System.in)
        print "Enter a full directory path: "
        def directory = scanner.nextLine() // Reads a full line of text

        wf.path = directory
        wf.validatePath()

        print "Enter a word to find: "
        def word = scanner.nextLine() // Reads a full line of text
        wf.word = word
        wf.findMatches()

        println "File found: ${wf.path} and word found: ${wf.word}"
        println "Here are ${wf.matches} matches found"
    }
}

class WordFinder {
    String path
    String word
    String currentDir = new File(".").absolutePath
    int matches = 0

    WordFinder(String path, String word) {
        this.path = path
        this.word = word
    }

    def toFile() {
        return Paths.get(currentDir, "/test", path).toFile()
    }

    def validatePath() {
        def pathToFile = toFile()
        if (!pathToFile.exists()) {
            println "File does not exist!"
            System.exit(0)
        }
    }

    def findMatches() {
        def pathToFile = toFile()
        pathToFile.eachLine { line ->
            // Add the number of matches found in this specific line
            matches += line.count(word)
        }
    }
}

