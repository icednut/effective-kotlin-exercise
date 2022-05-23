package io.icednut.kotlin.exercise.etc

internal class ThrowExceptionBenchmark {

    @org.junit.jupiter.api.Test
    fun `throw Exception을 하지 않을 때`() {
        val t = Test()

        val start = System.currentTimeMillis()
        t.reset()
        for (i in 1..100000000) {
            t.method1(i)
        }
        println("method1 took ${System.currentTimeMillis() - start}ms, result was ${t.value}")
    }

    @org.junit.jupiter.api.Test
    fun `throw Exception을 마지막에 한 번만 할 때`() {
        val t = Test()

        val start = System.currentTimeMillis()
        t.reset()
        for (i in 1..100000000) {
            try {
                t.method2(i)
            } catch (e: Exception) {
                println("You'll never see this!")
            }
        }
        println("method2 took ${System.currentTimeMillis() - start}ms, result was ${t.value}")
    }

    @org.junit.jupiter.api.Test
    fun `throw Exception 계속 던졌을 때`() {
        val t = Test()

        val start = System.currentTimeMillis()
        t.reset()
        for (i in 1..100000000) {
            try {
                t.method3(i)
            } catch (e: Exception) {
            }
        }
        println("method3 took ${System.currentTimeMillis() - start}ms, result was ${t.value}")
    }

    @org.junit.jupiter.api.Test
    fun `throw NoStackTraceThrowable을 계속 던졌을 때`() {
        val t = Test()

        val start = System.currentTimeMillis()
        t.reset()
        for (i in 1..100000000) {
            try {
                t.method4(i)
            } catch (e: NoStackTraceThrowable) {
            }
        }
        println("method4 took ${System.currentTimeMillis() - start}ms, result was ${t.value}")
    }

    @org.junit.jupiter.api.Test
    fun `throw NoStackTraceRuntimeException을 계속 던졌을 때`() {
        val t = Test()

        val start = System.currentTimeMillis()
        t.reset()
        for (i in 1..100000000) {
            try {
                t.method5(i)
            } catch (e: RuntimeException) {
            }
        }
        println("method5 took ${System.currentTimeMillis() - start}ms, result was ${t.value}")
    }
}

class Test {
    var value = 0

    fun reset() {
        value = 0
    }

    // Calculates without exception
    fun method1(i: Int) {
        value = (value + i) / i shl 1
        // Will never be true
        if (i and 0xFFFFFFF == 1000000000) {
            println("You'll never see this!")
        }
    }

    // Could in theory throw one, but never will
    @Throws(Exception::class)
    fun method2(i: Int) {
        value = (value + i) / i shl 1
        // Will never be true
        if (i and 0xFFFFFFF == 1000000000) {
            throw Exception()
        }
    }

    // This one will regularly throw one
    @Throws(Exception::class)
    fun method3(i: Int) {
        value = (value + i) / i shl 1
        // i & 1 is equally fast to calculate as i & 0xFFFFFFF; it is both
        // an AND operation between two integers. The size of the number plays
        // no role. AND on 32 BIT always ANDs all 32 bits
        if (i and 0x1 == 1) {
            throw Exception()
        }
    }

    // This one will regularly throw one
    @Throws(NoStackTraceThrowable::class)
    fun method4(i: Int) {
        value = (value + i) / i shl 1
        // i & 1 is equally fast to calculate as i & 0xFFFFFFF; it is both
        // an AND operation between two integers. The size of the number plays
        // no role. AND on 32 BIT always ANDs all 32 bits
        if (i and 0x1 == 1) {
            throw NoStackTraceThrowable()
        }
    }

    // This one will regularly throw one
    @Throws(NoStackTraceRuntimeException::class)
    fun method5(i: Int) {
        value = ((value + i) / i) shl 1;
        // i & 1 is equally fast to calculate as i & 0xFFFFFFF; it is both
        // an AND operation between two integers. The size of the number plays
        // no role. AND on 32 BIT always ANDs all 32 bits
        if (i and 0x1 == 1) {
            throw NoStackTraceRuntimeException()
        }
    }
}

class NoStackTraceThrowable : Throwable("my special throwable", null, false, false)
class NoStackTraceRuntimeException : RuntimeException("my special throwable", null, false, false)
