import java.nio.file.Paths
import java.nio.file.Files
import java.nio.charset.StandardCharsets
import java.nio.file.Path

class Init {
    static void main(String[] args) {
        print '''
        This is a application that will find a word in a file
        First you will be asked to enter a full directory path
        Then you will be asked to enter a word

        Example:
            groovy init.groovy test test
            I have setup a test file at test/first-test.txt
            It contains the following text:
            test
            test123
            test456
            this is me coding groovy

            Then it will print:
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

        You are free to modify the test file or the other files
        Add nested directories on your own freedom, please put it on your own risk
        '''
        println "----------------------------------"
        def wf = new WordFinder()
        if ((args.length > 0 && args.length < 3) || args.length === 0) {
            println wf.validationMessage()
            System.exit(1)
        }

        wf.path = args[0]
        wf.word = args[1]
        wf.replaceWord = args[2]
        wf.combinedPath = wf.composePath()

        if (!Files.isDirectory(wf.combinedPath)) {
            println "Invalid directory path: ${wf.combinedPath}"
            System.exit(1)
        }

        wf.findMatches()
    }
}

class WordFinder {
    String path
    String word
    String replaceWord
    Path currentPath
    Path combinedPath
    int matches = 0

    def totalModifiedFiles = 0
    def totalMatches = 0

    WordFinder(String path = "", String word = "", String replaceWord = "") {
        this.path = path
        this.word = word
        this.replaceWord = replaceWord
        this.currentPath = Paths.get("").toAbsolutePath();
        this.combinedPath = composePath()
    }

    def validationMessage() {
        return "Usage: groovy init.groovy <path> <word> <replace-text>"
    }

    def composePath() {
        return currentPath.resolve(path);
    }

    def findMatches() {
        Files.walk(combinedPath)
            .filter { Files.isRegularFile(it) }
            .forEach { path ->
                try {
                    String original = Files.readString(path, StandardCharsets.UTF_8)
                    int matches = countMatches(original, word)

                    if (matches > 0) {
                        println "=================================="
                        println "File: ${path}"
                        println "Matches: ${matches}"

                        // Original
                        println "---- Original ----"
                        println "Original: ${original}"
                        // Replace
                        String updated = original.replaceAll(word, replaceWord)
                        println "---- Replace ----"
                        println "Replace: ${updated}"

                        Files.writeString(path, original.replaceAll(word, replaceWord), StandardCharsets.UTF_8)

                        totalModifiedFiles++
                        totalMatches += matches
                    }
                } catch (Exception e) {
                    println "Error: ${e.message}"
                    System.exit(1)
                }
        }
    }

    static int countMatches(String text, String word) {
        int count = 0
        int index = 0

        while((index = text.indexOf(word, index)) != -1) {
            count++
            index += word.length()
        }
        return count
    }
}

