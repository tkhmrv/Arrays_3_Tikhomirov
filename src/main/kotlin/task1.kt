import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Запрос количества строк и столбцов для двумерного массива
    print("Введите количество строк: ")
    val rows = scanner.nextInt()
    print("Введите количество столбцов: ")
    val cols = scanner.nextInt()

    // Создание двумерного массива
    val matrix = Array(rows) { IntArray(cols) }

    // Ввод трехзначных чисел
    println("Введите ${rows * cols} трехзначных числа/чисел:")
    for (i in 0 until rows) {
        for (j in 0 until cols) {
            matrix[i][j] = readThreeDigitNumber(scanner)
        }
    }

    // Вывод двумерного массива
    println("Двумерный массив:")
    for (row in matrix) {
        for (num in row) {
            print("$num\t")
        }
        println()
    }

    // Подсчет количества различных цифр
    val uniqueDigits = countUniqueDigits(matrix)

    // Вывод результата
    println("В массиве использовано $uniqueDigits различных цифр")
}

fun readThreeDigitNumber(scanner: Scanner): Int {
    var number: Int
    do {
        print("Введите трехзначное число: ")
        number = scanner.nextInt()
    } while (number !in 100..999)
    return number
}

fun countUniqueDigits(matrix: Array<IntArray>): Int {
    val digitSet = mutableSetOf<Int>()

    for (row in matrix) {
        for (num in row) {
            // Разбиваем число на цифры и добавляем их в множество
            digitSet.addAll(num.toString().toCharArray().map { it.toString().toInt() })
        }
    }

    return digitSet.size
}