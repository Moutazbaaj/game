package Game

import kotlin.random.Random

class Challenge(val name: String, val description: String, val difficulty: Int) {
    fun attempt(): Boolean {
        println("You encounter a $name challenge: $description (Difficulty: $difficulty)")

        // Simulate player attempting the challenge
        val playerRoll = Random.nextInt(1, 11) // Assuming a 10-sided die for simplicity

        println("You rolled a $playerRoll!")

        // Determine if the player succeeds based on the roll and challenge difficulty
        val success = playerRoll > difficulty
        if (success) {
            println("Congratulations! You succeeded in the $name challenge.")
        } else {
            println("Oh no! You failed the $name challenge.")
        }

        return success
    }
}