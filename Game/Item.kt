package Game

import kotlin.random.Random

class Item(val name: String, val description: String, val lifePoints: Int) {
    companion object {
        fun generateRandomItem(): Item {
            val randomItemName = listOf("Magic Potion", "Mystic Crystal", "Ancient Amulet").random()
            val randomItemDescription = "A mysterious item with magical properties."
            val randomLifePoints = Random.nextInt(10, 31) // Adjust as needed

            return Item(randomItemName, randomItemDescription, randomLifePoints)
        }
    }
}