import game.Challenge
import game.Item
import game.Location
import game.Monster
import kotlin.random.Random

// Function to simulate a battle between the player and a monster
fun battle(player: Player, monster: Monster): Boolean {
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
            player.attackPower += 50
            player.updateHealth(25)
            println("Congratulations! You've gained more life and attack power.")
            player.displayInfo()
            return true
        } else {
            // Monster attacks the player
            val damageReceived = Random.nextInt(1, 21) // Change this as needed
            println("${monster.name} attacks! $damageReceived damage received.")
            // Update player's health
            player.takeDamage(damageReceived)

            // Check if the player is defeated
            if (player.healthPoints <= 0) {
                println("Game over! ${monster.name} defeated you. Thanks for playing!")
                return false
            }
        }
    }
    return false
}

// Function to process the player's choice after fleeing from a location
fun processFleeChoice(player: Player, previousLocation: Location?) {
    if (previousLocation != null) {
        println("\nWhat would you like to do?")
        println("1. Go back to the previous location")
        println("2. Discover another location")
        println("3. Flee and face a challenge")

        var fleeChoice: Int?
        do {
            fleeChoice = readLine()?.toIntOrNull()
            when (fleeChoice) {
                1 -> {
                    println("You decide to go back to the previous location.")

                }

                2 -> {
                    println("You decide to discover another location.")

                }

                3 -> {
                    println("You decide to flee and face a challenge.")
                    val challenge = Challenge()
                    if (challenge.generateRandomChallenge()) {
                        println("You successfully escaped the challenge and returned to the previous location.")
                    } else {
                        println("The challenge proved too difficult. You face consequences.")
                        // Implement consequences for failing the challenge, such as taking damage
                        player.takeDamage(10)
                    }
                }

                else -> {
                    println("Invalid choice. Please choose again:")
                }
            }
        } while (fleeChoice !in listOf(1, 2, 3))
    }
}


// Updated processLocationChoice function
fun processLocationChoice(choice: Int?, player: Player, previousLocation: Location?): Boolean {
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
                        if (!battle(player, groveMonster)) {
                            // Player was defeated, end the game
                            return false
                        }
                    }

                    2 -> {
                        // Flee
                        println("You decide to flee and return to the previous location.")
                        processFleeChoice(player, previousLocation)
                        return true // Player is still alive after fleeing
                    }

                    else -> {
                        println("Invalid choice. Please choose again:")
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
                    }

                    2 -> {
                        // Leave the item
                        println("You decide to leave the item and continue exploring.")
                    }

                    else -> {
                        println("Invalid choice. Please choose again:")
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
                        if (!battle(player, cavernMonster)) {
                            // Player was defeated, end the game
                            return false
                        }
                    }

                    2 -> {
                        // Retreat
                        println("You decide to retreat and return to the previous location.")
                        processFleeChoice(player, previousLocation)
                        return true // Player is still alive after retreating
                    }

                    else -> {
                        println("Invalid choice. Please choose again:")
                    }
                }
            } while (playerChoice !in listOf(1, 2))
        }

        else -> {
            println("Invalid choice. Please choose again:")
        }
    }
    return true // Player is still alive after processing the location choice
}

// Function to play the main game

