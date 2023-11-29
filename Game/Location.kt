package Game

class Location(val name: String, val description: String) {
    fun visit(player: Player) {
        println("\nYou arrive at the $name.")
        println(description)

        when (name) {
            "Enchanted Grove" -> {
                val groveMonster = Monster("Forest Guardian")
                println("A wild ${groveMonster.name} appears!")

                // Offer choices for the player
                println("\nWhat would you like to do?")
                println("1. Fight the ${groveMonster.name}")
                println("2. Flee and return to the previous location")

                when (readLine()?.toIntOrNull()) {
                    1 -> {
                        // Fight the monster
                        println("\nPrepare for battle!")
                        // Add logic for the battle, such as damage calculation, player's attack, etc.
                    }

                    2 -> {
                        // Flee
                        println("You decide to flee and return to the previous location.")
                        // Implement additional logic as needed
                    }

                    else -> {
                        println("Invalid choice. The adventure ends here.")
                    }
                }
            }

            "Whispering Waterfall" -> {
                val waterfallItem = Item.generateRandomItem()
                println("You discover a hidden item near the waterfall!")

                // Offer choices for the player
                println("\nWhat would you like to do?")
                println("1. Collect the item")
                println("2. Leave the item and continue exploring")

                when (readLine()?.toIntOrNull()) {
                    1 -> {
                        // Collect the item
                        player.collectItem(waterfallItem)
                        // Implement additional logic as needed
                    }

                    2 -> {
                        // Leave the item
                        println("You decide to leave the item and continue exploring.")
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
