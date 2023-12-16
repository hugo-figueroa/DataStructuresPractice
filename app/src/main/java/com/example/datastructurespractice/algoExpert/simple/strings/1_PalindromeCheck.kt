package com.example.datastructurespractice.algoExpert.simple.strings

/**
 * PalindromeCheck
 *
 * @author (c) 2023,
 * */

fun main(args: Array<String>) {
    print(isPalindrome("abcdcba").toString())
}

// O(log n) Time | 0(1) Space
fun isPalindrome(string: String): Boolean {
    var reversedChar = string.length - 1
    if (string.isNullOrEmpty()) return false
        for (char in string) {
        if (char != string[reversedChar]) return false
        if (reversedChar > string.length / 2) {
            reversedChar -= 1
        } else {
            return true
        }
    }
    return true
}