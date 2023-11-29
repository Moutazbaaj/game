package Game

class Player(val name: String) {
    var healthPoints = 100

    fun displayInfo() {
        println("\n----- $name's Adventure -----")
        println("Current Health: $healthPoints")
    }

    fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {
            println("Oh no! $name has been defeated.")
            // Add game over logic or handle the end of the game
        }
    }

    fun collectItem(item: Item) {
        println("You found ${item.name}! ${item.description}")
        // Update player's health based on the item's life points
        updateHealth(item.lifePoints)
        println("Your health is now $healthPoints.")
    }

    fun updateHealth(points: Int) {
        healthPoints = (healthPoints + points).coerceAtMost(100).coerceAtLeast(0)
    }
}