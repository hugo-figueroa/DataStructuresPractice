package com.example.datastructurespractice.algoExpert.simple.graphs

/**
 * 1_DepthFirstSearch
 *
 * You're given a "Node" class that has a "name" and an array of optional "children" nodes. When put together, nodes form
 * an acyclic tree-like structure.
 *
 * Implement the "depthFirstSearch" method on the "Node" class, which takes in an empty array, traverses the tree using
 * the Depth-first Search approach (specifically navigating the tree from left to right), stores all of the nodes' names in the
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
 * Expected Output = [A, B, E, F, I, J, C, D, G, K, H]
 *
 * @author (c) 2023, Hugo Figueroa
 * */

fun main(args: Array<String>) {

    val i = Node("I")
    val j = Node("J")
    val k = Node("K")

    val e = Node("E")
    val f = Node("F")
    f.children.addAll(listOf(i, j))

    val g = Node("G")
    g.children.add(k)

    val h = Node("H")

    val b = Node("B")
    b.children.add(e)
    b.children.add(f)

    val c = Node("C")

    val d = Node("D")
    d.children.add(g)
    d.children.add(h)

    val graph = Node("A")
    graph.children.add(b)
    graph.children.add(c)
    graph.children.add(d)

    val array = mutableListOf<String>()
    val output = graph.depthFirstSearch(array)
    print(output.toString())
}

class Node(name: String) {
    private val name: String = name
    val children = mutableListOf<Node>()

    // O(v + e) Time | O(v) Space
    fun depthFirstSearch(array: MutableList<String>): List<String> {
        array.add(this.name)
        for (child in this.children) {
            child.depthFirstSearch(array)
        }
        return array
    }
}