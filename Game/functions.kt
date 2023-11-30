package Game

import Player
import kotlin.random.Random

// Function to simulate a battle between the player and a monster
fun battle(player: Player, monster: Monster) {
    println("Prepare for battle!")

    // Battle loop
    while (player.healthPoints > 0 && monster.healthPoints > 0) {
        // Player attacks the monster
        val damageDealt = Random.nextInt(player.attackPower / 2, player.attackPower + 1)
        println("You deal $damageDealt damage to ${monster.name}!")

        // Check if the monster is defeated
        if (damageDealt >= monster.healthPoints) {
            println("You defeated ${monster.name}!")
            // Move to the next level and gain more life and attack power
            player.attackPower += 10
            player.updateHealth(20)
            println("Congratulations! You've gained more life and attack power.")
            player.displayInfo()
            break
        } else {
            // Monster attacks the player
            val damageReceived = Random.nextInt(1, 21) // Change this as needed
            println("${monster.name} attacks! $damageReceived damage received.")
            // Update player's health
            player.takeDamage(damageReceived)

            // Check if the player is defeated
            if (player.healthPoints <= 0) {
                break
            }
        }
    }
}

// Function to process player's choice in a location
fun processLocationChoice(choice: Int?, player: Player, previousLocation: Location?) {
    when (choice) {
        1 -> {
            // Location 1: Enchanted Grove
            val groveMonster = Monster()
            println("\nYou arrive at the Enchanted Grove. A wild ${groveMonster.name} with ${groveMonster.healthPoints}HP appears!")

            // Offer choices for the player
            println("\nWhat would you like to do?")
            println("1. Fight the ${groveMonster.name}")
            println("2. Flee and return to the previous location")
            var playerChoice: Int?
            do {
                playerChoice = readLine()?.toIntOrNull()
                when (playerChoice) {
                    1 -> {
                        // Fight the monster
                        battle(player, groveMonster)
                    }

                    2 -> {
                        // Flee
                        println("You decide to flee and return to the previous location.")
                        // Implement additional logic as needed
                        if (previousLocation != null) {
                            println("\nWhat would you like to do?")
                            println("1. Go back to the previous location")
                            println("2. Discover another location")
                            var fleeChoice: Int?
                            do {
                                fleeChoice = readLine()?.toIntOrNull()
                                when (fleeChoice) {
                                    1 -> {
                                        processLocationChoice(null, player, null)
                                    }

                                    2 -> {
                                        processLocationChoice(Random.nextInt(1, 4), player, null)
                                    }

                                    else -> {
                                        println("Invalid choice.Please choose again:")
                                    }
                                }
                            } while (fleeChoice !in listOf(1, 2))
                        }
                    }

                    else -> {
                        println("Invalid choice.Please choose again:")
                    }
                }
            } while (playerChoice !in listOf(1, 2))
        }

        2 -> {
// Location 2: Whispering Waterfall
            val waterfallItem = Item.generateRandomItem()
            println("\nYou arrive at the Whispering Waterfall. You discover a hidden item near the waterfall!")
            // Offer choices for the player
            println("\nWhat would you like to do?")
            println("1. Collect the item")
            println("2. Leave the item and continue exploring")

            var playerChoice: Int?
            do {
                playerChoice = readLine()?.toIntOrNull()
                when (playerChoice) {
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
            } while (playerChoice !in listOf(1, 2))
        }

        3 -> {
            // Location 3: Mystic Cavern
            val cavernMonster = Monster()
            println("\nYou arrive at the Mystic Cavern. A mysterious ${cavernMonster.name} with ${cavernMonster.healthPoints}HP appears!")

            // Offer choices for the player
            println("\nWhat would you like to do?")
            println("1. Confront the ${cavernMonster.name}")
            println("2. Retreat and return to the previous location")

            var playerChoice: Int?
            do {
                playerChoice = readLine()?.toIntOrNull()
                when (playerChoice) {
                    1 -> {
                        // Confront the monster
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
            } while (playerChoice !in listOf(1, 2))
        }

        else -> {
            println("Invalid choice. The adventure ends here.")
        }
    }
}
