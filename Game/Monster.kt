package Game

import kotlin.random.Random

class Monster(val name: String) {
    var healthPoints = Random.nextInt(20, 101)
    var attackDamage = Random.nextInt(1, 51)

    fun encounter(player: Player) {
        println("Oh no! You've encountered a $name with ${healthPoints}HP!")

        // Simulate an attack by the monster
        val playerDamage = Random.nextInt(1, 21) // Change this as needed
        println("$name attacks! $playerDamage damage received.")

        // Update player's health
        player.takeDamage(playerDamage)
    }
}