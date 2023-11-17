import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)

    val array1 = readIntArray(scanner)
    val array2 = readIntArray(scanner)

    val intersection = findIntersection(array1, array2)
    println("Пересечение массивов: ${intersection.toList()}")
}

fun readIntArray(scanner: Scanner): IntArray {
    print("Введите элементы массива через пробел: ")
    val input = scanner.nextLine().trim()
    return input.split(" ").map { it.toInt() }.toIntArray()
}

fun findIntersection(array1: IntArray, array2: IntArray): List<Int> {
    val countMap1 = countOccurrences(array1)
    val countMap2 = countOccurrences(array2)
    val intersection = mutableListOf<Int>()

    for ((num, count) in countMap1) {
        val minCount = minOf(count, countMap2.getOrDefault(num, 0))
        repeat(minCount) {
            intersection.add(num)
        }
    }
    return intersection
}

fun countOccurrences(array: IntArray): Map<Int, Int> {
    val countMap = mutableMapOf<Int, Int>()
    for (num in array) {
        countMap[num] = countMap.getOrDefault(num, 0) + 1
    }
    return countMap
}
