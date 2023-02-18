package com.example.demo

import org.junit.jupiter.api.Test

class TryByMeTest {

    @Test
    fun addToArrayForm() {
        val num: IntArray = intArrayOf(2,1,5)
        var k = 806

        val ans: MutableList<Int> = mutableListOf()
        for(i in num.size - 1 downTo 0) {
            ans.add(0, (num[i] + k) % 10)
            k = (num[i] + k) / 10
        }

        while (k > 0) {
            ans.add(0, k % 10)
            k /= 10
        }
        println(ans)
    }

    @Test
    fun twoSumByMe() {
        val nums: IntArray = intArrayOf(3,2,4)
        var target = 6

        val ans: MutableList<Int> = mutableListOf()
        for (i in nums.indices) {
            for (j in i + 1 until nums.size) {
                if(nums[i] + nums[j] == target) {
                    ans.add(i)
                    ans.add(j)
                }
            }
        }

        println(ans.toIntArray())
    }

    @Test
    fun twoSum() {
        val nums: IntArray = intArrayOf(3,2,4)
        var target = 6

        var res = intArrayOf()

        var map = HashMap<Int, Int>()
        nums.forEachIndexed { i, value ->
            var j = map[target - value]
            j?.let {
                res = intArrayOf(j, i)
            }
            map[value] = i
        }
        println(res)
    }
}