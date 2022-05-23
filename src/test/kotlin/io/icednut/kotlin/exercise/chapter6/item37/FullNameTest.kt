package io.icednut.kotlin.exercise.chapter6.item37

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class FullNameTest {

    @Test
    fun `FullName component2 연습하기`() {
        val fullName = "Marcin Moskala"
        val (firstName, lastName) = fullName.parseName() ?: return

        assertEquals("Marcin", firstName)
        assertEquals(" Moskala", lastName)
    }
}
