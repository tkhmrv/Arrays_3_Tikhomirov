import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Ввод массива слов
    val words = readWordsArray(scanner)

    // Группировка слов по признаку "состоят из одинаковых букв"
    val groupedWords = groupWordsByLetters(words)

    // Вывод результата
    println("Группы слов по признаку 'состоят из одинаковых букв':")
    for (group in groupedWords) {
        println(group.joinToString(", "))
    }
}

fun readWordsArray(scanner: Scanner): Array<String> {
    print("Введите слова через пробел: ")
    val input = scanner.nextLine().trim()
    return input.split(" ").toTypedArray()
}

fun groupWordsByLetters(words: Array<String>): List<List<String>> {
    val groupedMap = mutableMapOf<String, MutableList<String>>()

    for (word in words) {
        val sortedLetters = word.toCharArray().sorted().joinToString("")
        groupedMap.computeIfAbsent(sortedLetters) { mutableListOf() }.add(word)
    }

    return groupedMap.values.toList()
}
