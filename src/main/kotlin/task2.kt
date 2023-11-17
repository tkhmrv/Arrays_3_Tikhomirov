import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    // Запрос количества строк и столбцов для двумерного массива
    print("Введите количество строк и столбцов: ")
    val size = scanner.nextInt()

    // Рандомное заполнение массива
    val matrix = Array(size) {
        IntArray(size) { Random().nextInt(10) }

        // Создание двумерного массива и ввод
        /*val matrix = Array(size) { IntArray(size) }

        println("Введите элементы массива:")
        for (i in 0 until size) {
            for (j in 0 until size) {
                print("Элемент [$i][$j]: ")
                matrix[i][j] = scanner.nextInt()
            }*/
    }

    // Вывод двумерного массива
    println("Двумерный массив:")
    for (row in matrix) {
        for (num in row) {
            print("$num\t")
        }
        println()
    }

    // Проверка симметричности относительно главной диагонали
    val isSymmetric = checkSymmetry(matrix)

    // Вывод результата
    if (isSymmetric) {
        println("Массив симметричен относительно главной диагонали.")
    } else {
        println("Массив не симметричен относительно главной диагонали.")
    }
}

fun checkSymmetry(matrix: Array<IntArray>): Boolean {
    val size = matrix.size

    for (i in 0 until size) {
        for (j in i + 1 until size) {
            if (matrix[i][j] != matrix[j][i]) {
                // Если хотя бы одна пара элементов не равна, массив не симметричен
                return false
            }
        }
    }

    return true
}