package com.example.datastructurespractice.algoExpert.simple.graphs

import java.util.LinkedList
import java.util.Queue


/**
 * 2_BreadthFirstSearch
 *
 * You're given a "Node" class that has a "name" and an array of optional "children" nodes. When put together, nodes form
 * an acyclic tree-like structure.
 *
 * Implement the "depthFirstSearch" method on the "Node" class, which takes in an empty array, traverses the tree using
 * the Breadth-first Search approach (specifically navigating the tree from left to right), stores all of the nodes' names in the
 * input array, and returns it.
 *
 * graph = A
 *      /  |  \
 *     B   C   D
 *    / \     / \
 *   E   F   G   H
 *      / \   \
 *     I   J   K
 *
 * Expected Output = [A, B, C, D, E, F, G, H, I, J, K]
 *
 * @author (c) 2023, Hugo Figueroa
 * */

fun main(args: Array<String>) {

    val i = Node_("I")
    val j = Node_("J")
    val k = Node_("K")

    val e = Node_("E")
    val f = Node_("F")
    f.children.addAll(listOf(i, j))

    val g = Node_("G")
    g.children.add(k)

    val h = Node_("H")

    val b = Node_("B")
    b.children.add(e)
    b.children.add(f)

    val c = Node_("C")

    val d = Node_("D")
    d.children.add(g)
    d.children.add(h)

    val graph = Node_("A")
    graph.children.add(b)
    graph.children.add(c)
    graph.children.add(d)

    val array = mutableListOf<String>()
    val output = graph.breadthFirstSearch(array)
    print(output.toString())
}

class Node_(name: String) {
    private val name: String = name
    val children = mutableListOf<Node_>()

    // O(v + e) Time | O(v) Space
    fun breadthFirstSearch(array: MutableList<String>): List<String> {
        val queue: Queue<Node_> = LinkedList()
        queue.add(this)
        while (queue.isNotEmpty()) {
            val current = queue.poll()
            current?.let {
                array.add(it.name)
                for (child in it.children) {
                    queue.add(child)
                }
            }
        }
        return array
    }
}