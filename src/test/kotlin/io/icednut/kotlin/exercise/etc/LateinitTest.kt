package io.icednut.kotlin.exercise.etc

import org.junit.jupiter.api.BeforeEach
import kotlin.properties.Delegates
import org.junit.jupiter.api.Test

internal class LateinitTest {

    private var age: Int by Delegates.notNull()

    @BeforeEach
    fun init() {
        age = 10
    }

    @Test
    fun `check 사용하기`() {
        pop(10)
    }

    private fun pop(num: Int) {
        check(num > 0)
        require(num > 0)
        assert(num > 0)

        throw IllegalArgumentException()
    }
}
