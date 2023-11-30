import Game.Location
import Game.processLocationChoice


fun main() {
// Storyline
    println("Welcome to ‘Realm of Adventure’!")
    println(" In a distant land, a brave adventurer embarks on a quest filled with monsters, challenges, and hidden treasures.")
    println( "Your goal is to navigate through mystical locations, defeat monsters, and discover powerful items.")
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
    println("\nGame over, $playerName! Thanks for playing...")
}