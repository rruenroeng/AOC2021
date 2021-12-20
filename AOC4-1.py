import numpy as np

#find a winner
for ln in range(2,7):
    current = np.array(lines[ln].split()).astype(int)
    print(current)
    card = np.append(card,current)
print(card)
card=card.reshape(5,5)
print(card.diagonal(0))
print(np.fliplr(card).diagonal(0))

#handle the winner
if np.isin(26,card):
    card = card[card!=26]
    print(card)



#Open file and load up the data
f = open("bingoinput.txt","r")
lines = f.readlines()
k = np.array(lines[0].split(",")).astype(np.int64)

#Throw the octopus's draws into an array to use
card = np.array([])

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
#If MinRoundsToWin < MinSoFar
    #Save position of winning card
##AT THIS POINT WE'VE FOUND THE WINNING CARD AND KNOW HOW MANY ROUNDS IT TOOK
#Load the winning card into a single array
#Iterate through a range that goes up to the winning number of round on the octopus's selections
    #Remove members of the winning card from it
#Iterate through the remaining members of the winning card
    #Add its values together
#Multiply this number by the number of rounds
#Print the result

def playGameForCard(int cardInitLn, Array lines):
    for ln in range(cardInitLn,cardInitLn+5):
            current = np.array(lines[ln].split()).astype(int)
        print(current)
        card = np.append(card,current)
    print(card)
    minRoundsToWin = 
    return MinRoundsToWin