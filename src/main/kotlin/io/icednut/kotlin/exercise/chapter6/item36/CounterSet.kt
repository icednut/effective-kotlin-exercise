package io.icednut.kotlin.exercise.chapter6.item36

class CounterSet<T> : MutableSet<T> {
    private val innerSet = HashSet<T>()
    var elementsAdded: Int = 0

    override fun add(element: T): Boolean {
        elementsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        elementsAdded += elements.size
        return innerSet.addAll(elements)
    }

    override val size: Int
        get() = innerSet.size

    override fun clear() {
        innerSet.clear()
    }

    override fun isEmpty(): Boolean {
        return innerSet.isEmpty()
    }

    override fun containsAll(elements: Collection<T>): Boolean {
        return innerSet.containsAll(elements)
    }

    override fun contains(element: T): Boolean {
        return innerSet.contains(element)
    }

    override fun iterator(): MutableIterator<T> {
        return innerSet.iterator()
    }

    override fun retainAll(elements: Collection<T>): Boolean {
        return innerSet.retainAll(elements)
    }

    override fun removeAll(elements: Collection<T>): Boolean {
        return innerSet.removeAll(elements)
    }

    override fun remove(element: T): Boolean {
        return innerSet.remove(element)
    }
}
