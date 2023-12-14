package com.example.datastructurespractice.algoExpert.simple.arrays

/**
 * Write a function that takes in a non-empty array of distinct integers and an
 * integer representing a target sum. If any two numbers in the input array sum
 * up to the target sum, the function should return them in an array, in any
 * order. If no two numbers sum up to the target sum, the function should return
 * an empty array.
 *
 *
 * Note that the target sum has to be obtained by summing two different integers
 * in the array; you can't add a single integer to itself in order to obtain the
 * target sum.
 *
 *
 * You can assume that there will be at most one pair of numbers summing up to
 * the target sum.
 *
 * @author (c) 2023,
 * */
fun main(args: Array<String>) {
    print(twoNumberSum(mutableListOf<Int>(3, 5, -4, 8, 11, 1, -1, 6), 10).toString())
}

// O(n) Time | O(n) Space
fun twoNumberSum(array: MutableList<Int>, targetSum: Int): List<Int> {
    val seenNumbers = mutableSetOf<Int>()
    for (num in array) {
        val complement = targetSum - num
        if (seenNumbers.contains(complement)) {
            return listOf(num, complement)
        }
        seenNumbers.add(num)
    }
    // Write your code here.
    return listOf()
}