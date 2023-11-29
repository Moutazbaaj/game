package Game

fun main() {
    // Storyline
    println("Welcome to 'Realm of Adventure'!")
    println("In a distant land, a brave adventurer embarks on a quest filled with monsters, challenges, and hidden treasures.")
    println("Your goal is to navigate through mystical locations, defeat monsters, and discover powerful items.")

    // Player name input
    print("Enter your adventurer's name: ")
    val playerName = readLine() ?: "Adventurer"

    val player = Player(playerName)
    println("\nGreetings, $playerName! Your journey begins now.")

    // Create a random monster
    val initialMonster = Monster("Random Beast")
    println("\nOh no! You've encountered a ${initialMonster.name} with ${initialMonster.healthPoints}HP!")

    // Options for the player
    println("\nWhat would you like to do?")
    println("1. Start playing")
    println("2. Cancel and exit")

    when (readLine()?.toIntOrNull()) {
        1 -> {
            println("\nGreat! Let the adventure begin.")

            println("\nChoose a location:")
            println("1. Mystical Jungle")
            println("2. Sandland")
            println("3. Holy Mountain")

            when (readLine()?.toIntOrNull()) {
                1 -> {
                    // Mystical Jungle
                    val mysticalJungle =
                        Location("Mystical Jungle", "You enter the Mystical Jungle. There are paths leading to:")
                    println("1. Enchanted Grove")
                    println("2. Whispering Waterfall")

                    val mysticalJungleChoice = readLine()?.toIntOrNull()
                    mysticalJungle.visit(player)
                }

                2 -> {
                    // Sandland
                    val sandland = Location("Sandland", "You traverse the vast Sandland. There are paths leading to:")
                    println("1. Dune Desert")
                    println("2. Mirage Oasis")

                    val sandlandChoice = readLine()?.toIntOrNull()
                    sandland.visit(player)
                }

                3 -> {
                    // Holy Mountain
                    val holyMountain =
                        Location("Holy Mountain", "You ascend the sacred Holy Mountain. There are paths leading to:")
                    println("1. Celestial Summit")
                    println("2. Divine Cavern")

                    val holyMountainChoice = readLine()?.toIntOrNull()
                    holyMountain.visit(player)
                }

                else -> {
                    println("Invalid choice. The adventure ends here.")
                }
            }
        }
    }
}


