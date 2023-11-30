package game
import kotlin.random.Random

// Item class represents items that the player can find

class Item(val name: String, val description: String, val lifePoints: Int, val attackPowerBonus: Int) {
    companion object {
        // Function to generate a random item with random properties
        fun generateRandomItem(): Item {
            val randomItemName = listOf("Magic Potion", "Mystic Crystal", "Ancient Amulet").random()
            val randomItemDescription =
                "A mysterious item with magical properties that will give you more health points or increase your attack power."
            val randomLifePoints = Random.nextInt(10, 51) // Adjust as needed
            val randomAttackPowerBonus = Random.nextInt(5, 21) // Adjust as needed

            return Item(randomItemName, randomItemDescription, randomLifePoints, randomAttackPowerBonus)
        }
    }
}
