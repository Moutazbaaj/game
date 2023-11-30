package Game

import kotlin.random.Random

// Player class represents the adventurer in the game
class Player(val name: String) {
    var healthPoints = 100
    var attackPower = Random.nextInt(20, 61)

    // Function to display player information
    fun displayInfo() {
        println("\n----- $name's Adventure -----")
        println("Current Health: $healthPoints")
        println("Attack Power: $attackPower")
    }

    // Function to handle player taking damage
    fun takeDamage(damage: Int) {
        healthPoints -= damage
        if (healthPoints <= 0) {
            println("Oh no! $name has been defeated.")
            // Add game over logic or handle the end of the game
        }
        displayInfo()
    }

    // Function to simulate player collecting an item
    fun collectItem(item: Item) {
        println("You found ${item.name}! ${item.description}")
        // Update player's health based on the item's life points
        updateHealth(item.lifePoints)
        println("Your health is now $healthPoints.")
    }

    // Function to update player's health, avoiding exceeding 100 or going below 0
    fun updateHealth(points: Int) {
        healthPoints = (healthPoints + points).coerceAtMost(100).coerceAtLeast(0)
        displayInfo()
    }
}

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

// Monster class represents the adversaries in the game
class Monster {
    val name: String = generateRandomMonsterName()
    var healthPoints: Int = Random.nextInt(20, 101)
    var attackDamage: Int = Random.nextInt(1, 51)

    // Function to generate a random monster name
    private fun generateRandomMonsterName(): String {
        val adjectives = listOf("Fierce", "Sly", "Thunderous", "Giant", "Dreadful")
        val monsters = listOf("Dragon", "Basilisk", "Specter", "Wyrm", "Chimera")
        return "${adjectives.random()} ${monsters.random()}"
    }

    // Function to simulate an encounter with the monster
    fun encounter(player: Player) {
        println("Oh no! You've encountered a $name with ${healthPoints}HP!")

        // Simulate an attack by the monster
        val playerDamage = Random.nextInt(1, 21) // Change this as needed
        println("$name attacks! $playerDamage damage received.")

        // Update player's health
        player.takeDamage(playerDamage)
    }
}

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
                            println(
                                "1. Go back to the previous location”)
                                        println (“2. Discover another location”)
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
                                        println(“ Invalid choice.Please choose again:”)
                                    }
                                }
                            } while (fleeChoice !in listOf(1, 2))
                        }
                    }

                    else -> {
                        println(“ Invalid choice.Please choose again:”)
                    }
                }
            } while (playerChoice !in listOf(1, 2))
        }

        2 -> {
// Location 2: Whispering Waterfall
            val waterfallItem = Item.generateRandomItem()
            println(”\nYou arrive at the Whispering Waterfall. You discover a hidden item near the waterfall!”)
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

fun main() {
// Storyline
    println(“ Welcome to ‘Realm of Adventure’!”)
    println(“ In a distant land, a brave adventurer embarks on a quest filled with monsters, challenges, and hidden treasures.”)
    println(“ Your goal is to navigate through mystical locations, defeat monsters, and discover powerful items.”)
// Player name input
    print("Enter your adventurer's name: ")
    val playerName = readLine() ?: "Adventurer"

    val player = Player(playerName)
    println("\nGreetings, $playerName! Your journey begins now.")

// Main game loop
    var level = 1
    var previousLocation: Location? = null
    while (player.healthPoints > 0) {
        // Update player's attack power after each level
        player.attackPower += 10
        player.displayInfo()

        // Offer choices for the player to explore different places
        println("\nChoose a location for Level $level:")
        println("1. Enchanted Grove")
        println("2. Whispering Waterfall")
        println("3. Mystic Cavern")

        var locationChoice: Int?
        do {
            locationChoice = readLine()?.toIntOrNull()
            processLocationChoice(locationChoice, player, previousLocation)

        } while (locationChoice !in listOf(1, 2, 3))

        // Save the current location for potential return
        previousLocation = when (locationChoice) {
            1 -> Location("Enchanted Grove", "You enter the Enchanted Grove. The air is filled with magic.")
            2 -> Location(
                "Whispering Waterfall",
                "You approach the majestic Whispering Waterfall. Nature's symphony surrounds you."
            )

            3 -> Location("Mystic Cavern", "You descend into the mystical Mystic Cavern. Shadows dance on the walls.")
            else -> null // This case is unreachable due to the check above
        }

        // Move to the next level
        level++
    }

// Game over
    println("\nGame over, $playerName! Thanks for playing.")
}