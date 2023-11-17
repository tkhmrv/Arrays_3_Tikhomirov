fun main() {
    val alphabet = "АБВГДЕЁЖЗИЙКЛМНОПРСТУФХЦЧШЩЬЫЪЭЮЯ"
    val alphabetNumbers = intArrayOf(21, 13, 4, 20, 22, 1, 25, 12, 24, 14, 2, 28, 9, 23, 3, 29, 6, 16, 15, 11, 26, 5, 30, 27, 8, 18, 10, 33, 31, 32, 19, 7, 17)

    var choice: String? = null

    while (choice !in listOf("шифрование", "дешифрование")) {
        print("Введите 'шифрование' или 'дешифрование': ")
        choice = readlnOrNull()
    }

    when (choice) {
        "шифрование" -> {
            print("Введите текст для шифрования: ")
            val originalText = readlnOrNull() ?: ""
            print("Введите ключевое слово: ")
            val keyword = readlnOrNull() ?: ""
            val encryptedText = encrypt(originalText, keyword, alphabet, alphabetNumbers)
            println("Зашифрованный текст: $encryptedText")
        }

        "дешифрование" -> {
            print("Введите зашифрованный текст: ")
            val ciphertext = readlnOrNull() ?: ""
            print("Введите ключевое слово: ")
            val keyword = readlnOrNull() ?: ""
            val decryptedText = decrypt(ciphertext, keyword, alphabet, alphabetNumbers)
            println("Расшифрованный текст: $decryptedText")
        }
    }
}

fun encrypt(text: String, keyword: String, alphabet: String, alphabetNumbers: IntArray): String {

    val encryptedChars = mutableListOf<Char>()

    for (i in text.indices) {
        val char = text[i].toString().uppercase().first()
        val keywordChar = keyword[i % keyword.length].toString().uppercase().first()
        val charIndex = alphabetNumbers[alphabet.indexOf(char)]
        val keywordIndex = alphabetNumbers[alphabet.indexOf(keywordChar)]

        if (charIndex != -1) {
            val newIndex = (charIndex + keywordIndex) % alphabetNumbers.size
            encryptedChars.add(alphabet[alphabetNumbers.indexOf(newIndex)])
        } else {
            encryptedChars.add(char)
        }
    }

    return encryptedChars.joinToString("")
}

fun decrypt(ciphertext: String, keyword: String, alphabet: String, alphabetNums: IntArray): String {

    val decryptedChars = mutableListOf<Char>()

    for (i in ciphertext.indices) {
        val char = ciphertext[i].toString().uppercase().first()
        val keywordChar = keyword[i % keyword.length].toString().uppercase().first()
        val charIndex = alphabetNums[alphabet.indexOf(char)]
        val keywordIndex = alphabetNums[alphabet.indexOf(keywordChar)]

        if (charIndex != -1) {
            val newIndex = (charIndex - keywordIndex + alphabetNums.size) % alphabetNums.size
            decryptedChars.add(alphabet[alphabetNums.indexOf(newIndex)])
        } else {
            decryptedChars.add(char)
        }
    }

    return decryptedChars.joinToString("")
}