import java.io.File
import kotlin.random.Random
import kotlin.concurrent.schedule
import java.util.Timer

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
fun main() {

    // Массив слов
    //val words = arrayOf("яблоко", "банан", "вишня", "груша", "персик")
    val filePath = "D:/100000-russian-words.txt";

    // Читаем слова из файла
    val words = readWordsFromFile(filePath)

    // Выводим слова на экран
    //println(words)

    // Выбираем случайное слово
    val randomWord = words[Random.nextInt(words.size)]

    // Записываем слово в файл
    File("D:/word.txt").writeText(randomWord)

    // Выводим слово на экран
    println("Запомните это слово: $randomWord")

    // Задержка 3 секунды
    Timer().schedule(500) { // 1 секунда = 1000
        // Очищаем экран (в консоли можно использовать несколько переносов строки)
        repeat(50) { println() }

        // Предлагаем пользователю ввести слово
        println("Введите слово:")
        val userInput = readLine()

        // Проверяем правильность введенного слова
        if (userInput == randomWord) {
            println("Правильно")
        } else {
            println("Ошибка")
        }
        println(randomWord)
    }

}

fun readWordsFromFile(filePath: String): List<String> {
    // Создаем пустой список для хранения слов
    val wordsList = mutableListOf<String>()

    // Читаем файл построчно
    File(filePath).forEachLine { line ->
        // Разбиваем строку на слова и добавляем их в список
        wordsList.addAll(line.split("\\s+".toRegex()))
    }

    return wordsList
}