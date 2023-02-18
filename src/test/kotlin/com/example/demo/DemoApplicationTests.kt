package com.example.demo

import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter


class DemoApplicationTests {

	@Test
	fun solution() {
		var a: IntArray = intArrayOf(3, 4, -1, 1);

		var temp = 1;
		a.distinct().sorted().filter { it > 0 }.map { if(temp > it) return@map else temp = it + 1 }
		println(temp)
	}

	@Test
	fun solution2() {
		val A: String = "12:01"
		val B: String = "12:44"

		val dateFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm")
		val dateFormatter2: DateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy")
		val currentDate = LocalDate.now().format(dateFormatter2)
		var endDate = LocalDate.now().format(dateFormatter2);

		var from = LocalDateTime.parse("$currentDate $A", dateFormatter)
		var to = LocalDateTime.parse("$endDate $B", dateFormatter)

		var count = 0
		if(from != to) {
			if(from > to) {
				to = to.plusDays(1)
			}

			if(from.minute == 0) {
				from = from.plusMinutes(15)
			}
			while (from <= to) {
				println(from)
				val scrap = from.minute % 15
				if (scrap != 0) {
					from = from.plusMinutes(15-scrap.toLong())
				} else {
					from = from.plusMinutes(15)
					count += 1
				}
			}
			if(to.minute % 15 != 0 && to.minute != 59) count -= 1
		}
		println(count)
	}

	@Test
	fun solution3() {
		val string = ".>..."

		var res = 0
		var counter = 0
		for(item in string.iterator()){
			if(item == '.') counter += 1
			else if(item == '<') res += counter
		}

		var counter2 = 0
		for(item in string.reversed().iterator()){
			if(item == '.') counter2 += 1
			else if(item == '>') res += counter2
		}

		println(res)
	}

}
