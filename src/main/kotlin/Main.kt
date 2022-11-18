import kotlin.random.Random
import java.util.Scanner

public fun array2dOfBoolean(sizeOuter: Int, sizeInner: Int): Array<BooleanArray> = Array(sizeOuter) { BooleanArray(sizeInner)}
public fun array2dOfInt(sizeOuter: Int, sizeInner: Int): Array<IntArray> = Array(sizeOuter) { IntArray(sizeInner) }

var gameBoard = array2dOfInt(10, 10);
var boardBool = array2dOfBoolean(10,10 );

fun newGame(bombs: Int){

    for(i in 0..boardBool.size - 1) {
        var rowArray = BooleanArray(10)
        for(j in 0..boardBool.size - 1) {
            rowArray[j] = false;
        }
        boardBool[i] = rowArray
    }


    var x = 0;
    var r = Random.nextInt(0,99);

    var list = mutableListOf(r);

    while(x < bombs){
        var spot = 0;
        if(x == 0){
            for (i in 0..boardBool.size - 1) {
                val rowArray = boardBool.get(i)
                for (j in 0..boardBool.size - 1) {
                    if(spot == r) {
                        rowArray[j] = true;
                    }
                    spot++;
                }
                boardBool[i] = rowArray;
            }
            x++;
        }
        else if(!list.contains(r)) {
            list.add(r);
            for (i in 0..boardBool.size - 1) {
                val rowArray = boardBool.get(i)
                for (j in 0..boardBool.size - 1) {
                    if(spot == r) {
                        rowArray[j] = true;
                    }
                    spot++;
                }
                boardBool[i] = rowArray;
            }
            x++;
        }
    r = Random.nextInt(0,99);
    }

    for (i in 0..boardBool.size - 1) {
        val rowArray = IntArray(10)
        val boolRow = boardBool.get(i)
        for (j in 0..boardBool.size - 1) {
            if(!boolRow[j]) {
                rowArray[j] = 0;
            }
            else{
                rowArray[j] = 9;
            }

        }
        gameBoard[i] = rowArray;
    }

    for (i in 0..gameBoard.size - 1) {
        var row0: IntArray;
        var row1: IntArray;
        var row2: IntArray;
        if(i == 0){
            row2 = gameBoard.get(i+1)
            row1 = gameBoard.get(i)


            for (j in 0..gameBoard.size - 1) {
                if (row1[j] >= 9) {
                    if (j == 0) {
                        row1[j + 1]++
                        row2[j]++
                        row2[j + 1]++
                    } else if (j == gameBoard.size - 1) {
                        row1[j - 1]++
                        row2[j - 1]++
                        row2[j]++
                    } else {
                        row1[j + 1]++
                        row1[j - 1]++
                        row2[j]++
                        row2[j + 1]++
                        row2[j - 1]++
                    }

                } else {
                    gameBoard[i] = row1;
                    gameBoard[i + 1] = row2;
                }
            }
        }
        else if (i == gameBoard.size - 1){
            row0 = gameBoard.get(i-1)
            row1 = gameBoard.get(i)

            for (j in 0..gameBoard.size - 1) {
                if (row1[j] >= 9) {
                    if (j == 0) {
                        row1[j + 1]++
                        row0[j]++
                        row0[j + 1]++
                    } else if (j == gameBoard.size - 1) {
                        row1[j - 1]++
                        row0[j - 1]++
                        row0[j]++
                    } else {
                        row1[j + 1]++
                        row1[j - 1]++
                        row0[j]++
                        row0[j + 1]++
                        row0[j - 1]++
                    }

                } else {
                    gameBoard[i] = row1;
                    gameBoard[i - 1] = row0;
                }
            }
        }
        else {
            row0 = gameBoard.get(i - 1)
            row1 = gameBoard.get(i)
            row2 = gameBoard.get(i+1)

            for (j in 0..gameBoard.size - 1) {
                if (row1[j] >=9) {
                    if (j == 0) {
                        row1[j + 1]++
                        row0[j]++
                        row0[j + 1]++
                        row2[j]++
                        row2[j + 1]++
                    } else if (j == gameBoard.size - 1) {
                        row1[j - 1]++
                        row0[j - 1]++
                        row0[j]++
                        row2[j - 1]++
                        row2[j]++
                    } else {
                        row1[j + 1]++
                        row1[j - 1]++
                        row0[j]++
                        row0[j + 1]++
                        row0[j - 1]++
                        row2[j]++
                        row2[j + 1]++
                        row2[j - 1]++
                    }

                } else {
                    gameBoard[i] = row1;
                    gameBoard[i - 1] = row0;
                    gameBoard[i +1] = row2;
                }
            }
        }
    }

    for (i in 0..gameBoard.size - 1) {
        val rowArray = gameBoard.get(i)
        for (j in 0..gameBoard.size - 1) {
            if(rowArray[j]>= 9) {
                rowArray[j] = 9;
            }
        }
        gameBoard[i] = rowArray;
    }

    for(row in gameBoard) {
        for(j in row) {
            print(j)
            print(" ")
        }
        println("")
    }
}
fun boardGet(x : Int, y : Int){
    for(row in gameBoard) {
        for(j in row) {
            print(j)
            print(" ")
        }
        println("")
    }

}


fun main(args: Array<String>) {

    val reader = Scanner(System.`in`)

    println("would you like to play game? y/n")
    var input = reader.next();
    println("You entered: $input")
// prints new sequence every time

    newGame(10);

    // Try adding program arguments via Run/Debug configuration.
    // Learn more about running applications: https://www.jetbrains.com/help/idea/running-applications.html.
    //println("Program arguments: ${args.joinToString()}")
}