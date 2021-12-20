import numpy as np

#Incorrect Guesses: 39644(low),64124(high)

#Basic Flow of Program
#Open file and load up the data
#Throw the octopus's draws into an array to use
#Iterate through a range that steps the length of a card in the file
    #Play the game - Make this its own function with
            #Returns: Minimum Rounds to Win
        #Load up a bingo card into memory
            #Find the diagonals
            #Find the horizontal lines
            #Find the vertical lines
            #Addend a 6th item to each array in the card starting at 100
        #Iterate through the octopuses array using a range that maxes at the minimum found so far.  
            #Iterate through each array and add 1 to the 6th column if the octopuses number is contained in the array
        #Return length of octopuses array if the file isn't found.
#If MinRoundsToWin < overallMinRounds
    #Save position of winning card
##AT THIS POINT WE'VE FOUND THE WINNING CARD AND KNOW HOW MANY ROUNDS IT TOOK
#Load the winning card into a single array
#Iterate through a range that goes up to the winning number of round on the octopus's selections
    #Remove members of the winning card from it
#Iterate through the remaining members of the winning card
    #Add its values together
#Multiply this number by the number of rounds
#Print the result

def main():
    #Open file and load up the data
    f = open("bingoinput.txt","r")
    lines = f.readlines()
    bestCardInitLn = 0
      #Throw the octopus's draws into an array to use
    bingoPicks = np.array(lines[0].split(",")).astype(np.int64)
    minRoundsToWin = len(bingoPicks)+1
    overallMin = len(bingoPicks)+1
    overallMax = 0

    for cardInitLn in range(2,len(lines),6):
        RoundsToWin = playGameForCard(cardInitLn,lines,bingoPicks)
        if (RoundsToWin<overallMin):
            overallMin = RoundsToWin
            bestCardInitLn = cardInitLn
        if(RoundsToWin>overallMax):
            overallMax = RoundsToWin
            worstCardInitLn = cardInitLn

    if bestCardInitLn == 0:
        print("A winning card was not found")
        return 0
    else:
        print("Winning Card Location: " + str(bestCardInitLn) + " minRoundsToWin: " + str(overallMin))
    
    minTotal = workupWinner(bestCardInitLn,overallMin,lines,bingoPicks)
    print(minTotal)
    print(bingoPicks[overallMin])
    print(minTotal*bingoPicks[overallMin])

    maxTotal = workupWinner(worstCardInitLn,overallMax,lines,bingoPicks)
    print(maxTotal)
    print(bingoPicks[overallMax])
    print(maxTotal*bingoPicks[overallMax])
    return 1


'''
Play the game - Make this its own function with
            Returns: Minimum Rounds to Win
        Load up a bingo card into memory
            Find the diagonals
            Find the horizontal lines
            Find the vertical lines
            Addend a 6th item to each array in the card starting at 100
        Iterate through the octopuses array using a range that maxes at the minimum found so far.  
            Iterate through each array and add 1 to the 6th column if the octopuses number is contained in the array
        Return length of octopuses array if the file isn't found.
'''
def playGameForCard(cardInitLn,lines,bingoPicks):
    card = np.array([])
    winningLines = []
    RoundsToWin = len(bingoPicks)
    #Load up a bingo card into memory
    for ln in range(cardInitLn,cardInitLn+5):
        current = np.array(lines[ln].split()).astype(int)
        # print(current)
        card = np.append(card,current)
    card=card.reshape(5,5)
    # print("Processing: ")
    # print(card)
    #Add the diagonals
    diag = card.diagonal(0)
    diag = np.append(diag,100)
    revDiag = np.fliplr(card).diagonal(0)
    revDiag = np.append(revDiag,100)
    #Add these to winningLines
    ##winningLines.append(diag)
    ##winningLines.append(revDiag)
    #Add rows to winningLines
    for row in card:
        row=np.append(row,100)
        winningLines.append(row)
        #winningLines = np.array([winningLines],[row])
    #Find the columns and add them to winningLines
    card = np.transpose(card)
    for col in card:
        col=np.append(col,100)
        winningLines.append(col)

    for pickNum in range(len(bingoPicks)):
        sup = 0
        for ln in winningLines:
            if np.isin(bingoPicks[pickNum],ln):
                ln[5]+=1
            if ln[5] == 105:
                print("Winning Line")
                print(ln)
                RoundsToWin = pickNum
                print(RoundsToWin)
                return RoundsToWin
    return RoundsToWin

'''
Load the winning card into a single array
Iterate through a range that goes up to the winning number of round on the octopus's selections
    Remove members of the winning card from it
Iterate through the remaining members of the winning card
    Add its values together
'''
def workupWinner(cardInitLn,overallMinRounds,lines,bingoPicks):
    card = np.array([])
    #Buildup card
    for ln in range(cardInitLn,cardInitLn+5):
        current = np.array(lines[ln].split()).astype(int)
        print(current)
        card = np.append(card,current)
    #Iterate Through Numbers
    for i in range(overallMinRounds+1):
        if np.isin(bingoPicks[i],card):
            card = card[card!=bingoPicks[i]]
    total = 0
    for x in card:
        total+=x
    print("Final:")
    print(card)

    return total

if __name__ == "__main__":
    main()