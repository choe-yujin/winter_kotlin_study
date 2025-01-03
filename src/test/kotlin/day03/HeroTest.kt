package day03

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class HeroTest {

    @Test
    fun `데미지 받고 hp가 음수가 되지 않음`() {
        val hero = Hero("용사", 100)
        val overHp = hero.hp + 10
        hero.takeDamage(overHp)
        assertEquals(0, hero.hp)
    }

    @Test
    fun `데미지 받고 hp가 깎임`() {
        val hero = Hero("용사", 100)
        hero.takeDamage(20)
        assertEquals(80, hero.hp)
    }

    @Test
    fun `힐링 받고 hp가 max보다 초과 되지 않음`() {
        val hero = Hero("용사", Hero.MAX_HP)
        hero.takeHp(10)
        assertEquals(Hero.MAX_HP, hero.hp)
    }

    @Test
    fun `힐링 받고 hp 회복함`() {
        val hero = Hero("용사", 10)
        hero.takeHp(20)
        assertEquals(30, hero.hp)
    }

    @Test
    fun `이름이 짧으면 예외 발생`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Hero(name = "A", hp = 50)
        }
        assertEquals("이름이 너무 짧습니다", exception.message)
    }

    @Test
    fun `이름이 길면 예외 발생`() {
        val exception = assertFailsWith<IllegalArgumentException> {
            Hero(name = "ABCDEFGHI", hp = 50)
        }
        assertEquals("이름이 너무 깁니다", exception.message)
    }

    @Test
    fun `이름이 적절한 길이라면 hero 정상 생성`() {
        val hero = Hero(name = "Batman", hp = 50)
        assertEquals("Batman", hero.name)
        assertEquals(50, hero.hp)
    }

}