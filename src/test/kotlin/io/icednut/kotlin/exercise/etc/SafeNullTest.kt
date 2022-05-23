package io.icednut.kotlin.exercise.etc

import org.junit.jupiter.api.Test

internal class SafeNullTest {

    @Test
    fun `스마트 캐스트를 이용한 안전한 null 처리하기`() {
        println("What is your name?")
        val name: String? = readLine()

        if (name.isNullOrBlank() != true) {
            println("Hello ${name.toUpperCase()}")
        }

        name.orEmpty()
    }
}
