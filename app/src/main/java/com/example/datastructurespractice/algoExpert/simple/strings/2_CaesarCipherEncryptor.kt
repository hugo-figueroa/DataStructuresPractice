package com.example.datastructurespractice.algoExpert.simple.strings

/**
 * Given a non-empty string of lowercase letters and a non-negative integer
 * representing a key, write a function that returns a new string obtained by
 * shifting every letter in the input string by k positions in the alphabet,
 * where k is the key.
 *
 *
 * Note that letters should "wrap" around the alphabet; in other words, the
 * letter shifted by one returns the letter.
 *
 * @author (c) 2023, Hugo Figueroa
 * */

fun main(args: Array<String>) {
    print(caesarCipherEncryptor("xyz", 2))
}

// O(n) Time | O(n) Space
fun caesarCipherEncryptor(string: String, key: Int): String {
    var newLetters = arrayListOf<String>()
    val newKey = key % 26
    val alphabet = arrayOf("a","b","c","d","e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z")
    for (letter in string) {
        newLetters.add(getNewLetter(letter.toString(), newKey, alphabet))
    }
    return newLetters.joinToString(separator = "")
}

fun getNewLetter(letter: String, key: Int, alphabet: Array<String>): String {
    val newLetterCode = alphabet.indexOf(letter) + key
    return if (newLetterCode <= 25) alphabet[newLetterCode] else alphabet[newLetterCode % 26]
}