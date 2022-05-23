package io.icednut.kotlin.exercise.chapter6.item37

data class FullName(
    val firstName: String,
    val lastName: String
)

fun String.parseName(): FullName? {
    val indexOfLastSpace = this.trim().lastIndexOf(' ')

    if (indexOfLastSpace < 0) {
        return null
    }

    val firstName = this.take(indexOfLastSpace)
    val lastName = this.drop(indexOfLastSpace)

    return FullName(firstName, lastName)
}
