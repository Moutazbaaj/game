import game.Game


fun main() {
    var i = 0

    val Game = Game()

    while (true) {
        Game.playGame()

        println(
            """
            
                ----- Do you wanna Play Again? ----- 
            
                   -- 'y' For Yes , 'n' For No -- """.trimMargin()
        )

        val userInput: String = readlnOrNull()!!

        if (userInput.lowercase() == "n") {
            // Exit the loop and end the program
            break
        } else if (userInput.lowercase() == "y") {
            // Continue the loop and play the game again
            i++
        } else {
            println("Invalid input. Please enter 'y' or 'n'.")

        }
    }

    println("\nThanks for playing 'Realm of Adventure'! You played $i times.")
}
