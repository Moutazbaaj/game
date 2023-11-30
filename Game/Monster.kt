package Game
import Player
import kotlin.random.Random

// Monster class represents the adversaries in the game
class Monster {
    val name: String = generateRandomMonsterName()
    var healthPoints: Int = Random.nextInt(20, 101)
    var attackDamage: Int = Random.nextInt(1, 51)

    // Function to generate a random monster name
    private fun generateRandomMonsterName(): String {
        val adjectives = listOf("Fierce", "Sly", "Thunderous", "Giant", "Dreadful")
        val monsters = listOf("Dragon", "Basilisk", "Specter", "Wyrm", "Chimera")
        return "${adjectives.random()} ${monsters.random()}"
    }

    // Function to simulate an encounter with the monster
    fun encounter(player: Player) {
        println("Oh no! You've encountered a $name with ${healthPoints}HP!")

        // Simulate an attack by the monster
        val playerDamage = Random.nextInt(1, 21) // Change this as needed
        println("$name attacks! $playerDamage damage received.")

        // Update player's health
        player.takeDamage(playerDamage)
    }
}