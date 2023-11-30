import game.Item
import kotlin.random.Random


// Player class represents the adventurer in the game
class Player(val name: String) {
    var healthPoints = 100
    var attackPower = Random.nextInt(20, 51)

    // Function to display player information
    fun displayInfo() {
        println("\n----- $name's Info -----")
        println("Current Health: $healthPoints")
        println("Attack Power: $attackPower")
    }

    // Function to handle player taking damage
    fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {
            println("Oh no! $name has been defeated....")

        }
        displayInfo()
    }

    // Function to simulate player collecting an item
    fun collectItem(item: Item) {

        println("You found ${item.name}! ${item.description}\n")

        // Update player's health based on the item's life points
        updateHealth(item.lifePoints)
        updateAttackPower(item.attackPowerBonus)
        println("Your health is now $healthPoints.")
        println("Your attack power is now $attackPower.")
    }

    // Function to update player's health, avoiding exceeding 100 or going below 0
    fun updateHealth(points: Int) {
        healthPoints = (healthPoints + points).coerceAtMost(100).coerceAtLeast(0)

    }
    fun updateAttackPower(bonus: Int) {
        attackPower = (attackPower + bonus)//.coerceIn(20, 100)
    }
}