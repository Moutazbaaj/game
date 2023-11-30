package game

import Player
import kotlin.random.Random

class Challenge {


    // Function to generate a random challenge
    fun generateRandomChallenge(): Boolean {
        val challengeOptions = listOf(
            "Rolling the Dice",
            "Card Guessing Game",
            "Riddle Me This"
        )

        val selectedChallenge = challengeOptions.random()
        println("Challenge: $selectedChallenge")

        // Implement logic for each specific challenge type
        return when (selectedChallenge) {
            "Rolling the Dice" -> rollingTheDice()
            "Card Guessing Game" -> cardGuessingGame()
            "Riddle Me This" -> riddleMeThis()
            else -> false
        }
    }


    // Function to simulate the "Rolling the Dice" challenge
    fun rollingTheDice(): Boolean {
        println("Challenge: Rolling the Dice")
        println("You have to roll the dice and beat the generated number to win.")

        // Generate a random number for the challenge
        val challengeNumber = Random.nextInt(1, 7)
        println("Generated number: $challengeNumber")

        // Roll the dice (generate a random number between 1 and 6)
        val playerDiceRoll = Random.nextInt(1, 7)
        println("Your dice roll: $playerDiceRoll")

        // Check if the player wins the challenge
        val challengeResult = playerDiceRoll > challengeNumber
        if (challengeResult) {
            println("Congratulations! You've won the challenge.")
        } else {
            println("Sorry, you didn't beat the generated number. Challenge failed.")
        }

        return challengeResult
    }

    // Function to simulate the updated "Card Guessing Game" challenge
    fun cardGuessingGame(): Boolean {
        println("Challenge: Card Guessing Game")
        println("Guess the color of the card: Red or Black.")

        // Simulate drawing a random card
        val isRedCard = Random.nextBoolean()

        // Ask the player to guess the color
        println("Is the card Red or Black?")
        val playerGuess = readLine()?.trim()?.toLowerCase()

        // Check if the player's guess is correct
        val correctAnswer = if (isRedCard) "red" else "black"
        val challengeResult = playerGuess == correctAnswer

        if (challengeResult) {
            println("Congratulations! You've won the challenge.")
        } else {
            println("Sorry, your guess was incorrect. Challenge failed.")
        }

        return challengeResult
    }

    // Function to simulate the "Riddle Me This" challenge
    fun riddleMeThis(): Boolean {
        println("Challenge: Riddle Me This")
        println("Solve the following mathematical riddle:")

        // Generate a random mathematical question
        val operand1 = Random.nextInt(1, 11)
        val operand2 = Random.nextInt(1, 11)
        val operatorOptions = listOf("+", "-", "=")
        val randomOperator = operatorOptions.random()

        // Display the riddle
        println("$operand1 $randomOperator $operand2")

        // Generate three answer options
        val correctAnswer = when (randomOperator) {
            "+" -> operand1 + operand2
            "-" -> operand1 - operand2
            "=" -> operand1 * operand2 // For simplicity, use multiplication for equality
            else -> 0
        }

        val wrongAnswer1 = generateWrongAnswer(correctAnswer)
        val wrongAnswer2 = generateWrongAnswer(correctAnswer)

        // Shuffle the answer options
        val answerOptions = listOf(correctAnswer, wrongAnswer1, wrongAnswer2).shuffled()

        // Display answer options to the player
        println("Choose the correct answer:")
        println("1. ${answerOptions[0]}")
        println("2. ${answerOptions[1]}")
        println("3. ${answerOptions[2]}")

        // Ask the player to choose an option
        val playerChoice = readLine()?.toIntOrNull()

        // Check if the player's choice is correct
        val challengeResult = playerChoice == answerOptions.indexOf(correctAnswer) + 1
        if (challengeResult) {
            println("Congratulations! You've won the challenge.")
        } else {
            println("Sorry, your answer was incorrect. Challenge failed.")
        }

        return challengeResult
    }

    // Function to generate a wrong answer for the riddle
    fun generateWrongAnswer(correctAnswer: Int): Int {
        // Generate a random offset to create a wrong answer
        val offset = Random.nextInt(1, 6)
        return correctAnswer + offset
    }
}
