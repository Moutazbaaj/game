package Game
import kotlin.random.Random

// Item class represents items that the player can find
class Item(val name: String, val description: String, val lifePoints: Int) {
    companion object {
        // Function to generate a random item with random properties
        fun generateRandomItem(): Item {
            val randomItemName = listOf("Magic Potion", "Mystic Crystal", "Ancient Amulet").random()
            val randomItemDescription = "A mysterious item with magical properties."
            val randomLifePoints = Random.nextInt(10, 31) // Adjust as needed

            return Item(randomItemName, randomItemDescription, randomLifePoints)
        }
    }
}
