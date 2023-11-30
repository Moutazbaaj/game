package Game

import Player

// Location class represents different places the player can visit
class Location(val name: String, val description: String) {
    // Function to simulate a visit to a location
    fun visit(player: Player) {
        println("\nYou arrive at the $name.")
        println(description)

        when (name) {
            "Enchanted Grove" -> {
                // Logic for Enchanted Grove (unchanged)
            }

            "Whispering Waterfall" -> {
                // Logic for Whispering Waterfall (unchanged)
            }

            "Mystic Cavern" -> {
                // Logic for Mystic Cavern
                val cavernMonster = Monster()
                println("A mysterious ${cavernMonster.name} with ${cavernMonster.healthPoints}HP appears!")

                // Offer choices for the player
                println("\nWhat would you like to do?")
                println("1. Confront the ${cavernMonster.name}")
                println("2. Retreat and return to the previous location")

                when (readLine()?.toIntOrNull()) {
                    1 -> {// Confront the monster
                        battle(player, cavernMonster)
                    }

                    2 -> {
                        // Retreat
                        println("You decide to retreat and return to the previous location.")
                        // Implement additional logic as needed
                    }

                    else -> {
                        println("Invalid choice. The adventure ends here.")
                    }
                }
            }

            else -> {
                println("Invalid choice. The adventure ends here.")
            }
        }
    }
}