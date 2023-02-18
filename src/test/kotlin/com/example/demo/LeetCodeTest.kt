package com.example.demo

import org.junit.jupiter.api.Test
import java.util.*


class LeetCodeTest {

    @Test
    fun addToArrayForm(){
        var num: IntArray = intArrayOf(2,1,5)
        val k = 806

        var k2 = k
        val ans: MutableList<Int> = mutableListOf()
        for (i in num.size - 1 downTo 0) {
            ans.add(0, (num[i] + k2) % 10)
            k2 = (num[i] + k2) / 10
        }

        while (k2 > 0) {
            ans.add(0, k2 % 10)
            k2 /= 10
        }

        println(ans)
    }

    @Test
    fun twoSum() {
        val nums: IntArray = intArrayOf(3,2,4)
        var target = 6

        var res = intArrayOf();

        val lookup = HashMap<Int, Int>()
        nums.forEachIndexed { i, x ->
            val j = lookup[target - x]
            j?.let {
                res = intArrayOf(j, i)
            }
            lookup[x] = i
        }

        println(res)
    }
}