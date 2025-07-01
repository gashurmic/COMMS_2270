package hw2;
/**
 * Model of a Monopoly-like game. Two players take turns
 * rolling dice to move around a board. The game ends
 * when one of the players has at least MONEY_TO_WIN
 * money or one of the players goes bankrupt (they have
 * negative money).
 * 
 * @author George Michael
 */
public class CyGame {

		/**
		 * The endzone square type.
		 */
		public static final int ENDZONE = 0;
		/**
		 * The CyTown square type.
		 */
		public static final int CYTOWN = 1;
		/**
		 * The pay rent square type.
		 */
		public static final int PAY_RENT = 2;
		/**
		 * The fall behind square type.
		 */
		public static final int FALL_BEHIND = 3;
		/**
		 * The blizzard square type.
		 */
		public static final int BLIZZARD = 4;
		/**
		 * The pass class square type.
		 */
		public static final int PASS_CLASS = 5;
		/**
		 * Points awarded when landing on or passing over the endzone square.
		 */
		public static final int ENDZONE_PRIZE = 200;
		/**
		 * The standard rent payed to the other player when landing on a
		 * pay rent square.
		 */
		public static final int STANDARD_RENT_PAYMENT = 80;
		/**
		 * The cost to by CyTown.
		 */
		public static final int CYTOWN_COST = 200;
		/**
		 * The amount of money required to win.
		 */
		public static final int MONEY_TO_WIN = 400;
		/**
		 * instance variable stating who is currently playing, who's turn it is.
		 */
		private int currentPlayer = 1;
		/**
		 * instance variable stating the current position of player 1.
		 */
		private int player1Square;
		/*
		 * instance variable stating the current position of player 2.
		 */
		private int player2Square;
		/*
		 * instance variable stating the current amount of money player 1 has.
		 */
		private int player1Money;
		/*
		 * instance variable stating the current amount of money player 1 has.
		 */
		private int player2Money;
		/*
		 * instance variable stating the total number of squares the board has.
		 */
		private int numSquares;
		/*
		 * instance variable stating if player 1 was on a stuck blizzard spot last turn and needs to roll an odd number to get out
		 */
		private boolean p1StuckInBlizzard = false;
		/*
		 * instance variable stating if player 2 was on a stuck blizzard spot last turn and needs to roll an odd number to get out
		 */
		private boolean p2StuckInBlizzard = false;
		/*
		 * instance variable stating if this is the second roll/turn in a row of player 1.
		 */
		private boolean isSecondRollP1 = false;
		/*
		 * instance variable stating if this is the second roll/turn in a row of player 2. 
		 */
		private boolean isSecondRollP2 = false;
		/*
		 * instance variable stating if player 1 owns CyTown. 
		 */
		private boolean p1Ownership = false;
		/*
		 * instance variable stating if player 1 owns CyTown. 
		 */
		private boolean p2Ownership = false;
		
		/**
		 * Constructs a game that has the given number of squares and starts both players on square 0.
		 * @param numSquares  - - number of squares on board
		 * @param startingMoney - - starting money for each player
		 */
		public CyGame(int numSquares, int startingMoney) {
			this.numSquares = numSquares;
			player1Money = startingMoney;
			player2Money = startingMoney;
		}
		
		/**
		 * Get the current player.
		 * @return 1 if it is currently Player 1's turn, otherwise 2
		 */
		public int getCurrentPlayer() {
			return currentPlayer;
		}
		
		/**
		 * Get the player who is not the current player.
		 * @return 1 if it is currently Player 2's turn, otherwise 1
		 */
		public int getOtherPlayer() {
			if(currentPlayer == 1) {
				return 2;
			}
			else {
				return 1;
			}
		}
		
			
		/**
		 * Get the given player's square location.
		 * @param player -- specifies which player, 1 or 2
		 * @return the player's square location
		 */
			public int getPlayerSquare(int player) {
			if(player == 1) {
			return player1Square;
			}
			if(player == 2) {
				return player2Square;
				}
			return 0;
		}
		
		/**
		 * Returns true if player 1 owns CyTown, false otherwise.
		 * @return if player 1 owns CyTown
		 */
		public boolean isPlayer1CyTownOwner() {
			return p1Ownership;
		}
		
		/**
		 * Returns true if player 2 owns CyTown, false otherwise.
		 * @return if player 2 owns CyTown
		 */
		public boolean isPlayer2CyTownOwner() {
			return p2Ownership;
		}
		
		/**
		 * Returns true if game is over, false otherwise. The game is over when either player has at least MONEY_TO_WIN money or either player has a negative amount of money.
		 * @return true if the game is over, false otherwise
		 */
		public boolean isGameEnded() {
			if (player1Money >= MONEY_TO_WIN || player2Money >= MONEY_TO_WIN || player1Money < 0 || player2Money < 0) {
				return true;
			}
			else {
				return false;
			}
		}
		
		
		/**
		 * Method called to indicate the current player is attempting to buy CyTown.
		 */
		public void buyCyTown() {
			
				//PLAYER 1 TURN
				if(currentPlayer == 1) {
					if(player1Square == numSquares-1 && !isPlayer1CyTownOwner() && !isPlayer2CyTownOwner() && player1Money >= CYTOWN_COST && !isGameEnded()) {
						player1Money -= CYTOWN_COST;
						p1Ownership = true;
						isSecondRollP1 = false;
						endTurn();
					}
				//PLAYER 2 TURN
				} else {
					if(player2Square == numSquares-1 && !isPlayer1CyTownOwner() && !isPlayer2CyTownOwner() && player2Money >= CYTOWN_COST && !isGameEnded()) {
						player2Money -= CYTOWN_COST;
						p2Ownership = true;
						isSecondRollP2 = false;
						endTurn();
					}
				}
		}
		
		/**
		 * Get the given player's money.
		 * @param player -- specifies which player, 1 or 2
		 * @return the player's money
		 */
		public int getPlayerMoney(int player) {
			if(player == 1) {
				return player1Money;
			}
			if(player == 2) {
				return player2Money;
			}
			else {
				return -1;
			}
		}
		
		/**
		 * Get the type of square code (see constants defined at the top of this class) for the given square location.
		 * @param square - - the square location
		 * @return the code (as defined by in the constants) for the square type
		 */
		public int getSquareType(int square) {
			
			if(square == 0) {
				//squareType = ENDZONE;
				return ENDZONE;
			}
			if(square == numSquares-1) {
				//squareType = CYTOWN;
				return CYTOWN;
			}
			
			if(square % 5 == 0) {
				//squareType = PAY_RENT;
				return PAY_RENT;
			}
			if(square % 7 == 0 || square % 11 == 0) {
				//squareType = FALL_BEHIND;
				return FALL_BEHIND;
			}
			if(square % 3 == 0) {
				//squareType = BLIZZARD;
				return BLIZZARD;
			}
			else {
				//squareType = PASS_CLASS;
				return PASS_CLASS;
			}
		}
		
		/**
		 * This method is called to indicate the die has been rolled.
		 * @param value -- the number rolled by the die (1 to 6 inclusive)
		 */
		public void roll(int value) {
			//if(isGameEnded()) {
				
			 //  return; // Exits the method early
			    
			//}
				int actualMoved = 0;
				int playerWhenStarted = currentPlayer;
				//fix
				while(currentPlayer == playerWhenStarted && !isGameEnded()) {
					
					//PLAYER 1 TURN
					if(currentPlayer == 1) {
						
						if(p1StuckInBlizzard) {
							if(value % 2 != 0) {
								p1StuckInBlizzard = false;
								roll(value);
								break;
							}
							else {
								isSecondRollP1 = false;
								endTurn();
								break;
								
							}
						
						}
						actualMoved = player1Square;
						player1Square = Math.min(player1Square+=value, numSquares);
						actualMoved = player1Square - actualMoved;
						if(player1Square == numSquares) {
							
							player1Money += ENDZONE_PRIZE;
							player1Square = value - actualMoved;
						}
						if(getSquareType(player1Square) == PASS_CLASS) {
							
							if(!isSecondRollP1) {
								isSecondRollP1 = true;
								roll(4);
							}
							else {
								isSecondRollP1 = false;
								endTurn();
							}
							
							
						}
						else if(getSquareType(player1Square) == PAY_RENT) {
							
								if(isPlayer2CyTownOwner()) {
								player1Money -= (2 * STANDARD_RENT_PAYMENT);
								player2Money += (2*STANDARD_RENT_PAYMENT);
								isSecondRollP1 = false;
								endTurn();
								}
								else {
									player1Money -= (STANDARD_RENT_PAYMENT);
									player2Money += (STANDARD_RENT_PAYMENT);
									isSecondRollP1 = false;
									endTurn();
								}
						}
						else if(getSquareType(player1Square) == BLIZZARD) {
							p1StuckInBlizzard = true;
							isSecondRollP1 = false;
							endTurn();
								
							
						}
						else if (getSquareType(player1Square) == FALL_BEHIND) {
							if (!isSecondRollP1) {
								isSecondRollP1 = true;
								roll(-1);
								
							}
							else {
								isSecondRollP1 = false;
								endTurn();
							}
							
						}
						else if (getSquareType(player1Square) == CYTOWN) {
							//possible buy CyTown, pause turn
							isSecondRollP2 = false;
							break;
						}
						
						
						
						
						
						
					//PLAYER 2 TURN
					} else {
						if(p2StuckInBlizzard) {
							if(value % 2 != 0) {
								isSecondRollP1 = true;
								p2StuckInBlizzard = false;
								roll(value);
								break;
							}
							else {
								isSecondRollP1 = false;
								endTurn();
								break;
								
							}
							
						}
						actualMoved = player2Square;
						player2Square = Math.min(player2Square+=value, numSquares);
						actualMoved = player2Square - actualMoved;
						if(player2Square == numSquares) {
							player2Money += ENDZONE_PRIZE;
							player2Square = value - actualMoved;
						}
						if(getSquareType(player2Square) == PASS_CLASS) {
							
							if(!isSecondRollP2) {
								isSecondRollP2 = true;
								roll(4);
							}
							else {
								isSecondRollP2 = false;
								endTurn();
							}
							
							
						}
						else if(getSquareType(player2Square) == PAY_RENT) {
							
								if(isPlayer1CyTownOwner()) {
								player2Money -= (2 * STANDARD_RENT_PAYMENT);
								player1Money += (2*STANDARD_RENT_PAYMENT);
								isSecondRollP2 = false;
								endTurn();
								
								}
								else {
									player2Money -= (STANDARD_RENT_PAYMENT);
									player1Money += (STANDARD_RENT_PAYMENT);
									isSecondRollP2 = false;
									endTurn();
								}
						}
						else if(getSquareType(player2Square) == BLIZZARD) {
							p2StuckInBlizzard = true;
							isSecondRollP2 = false;
							endTurn();
								
							
						}
						else if (getSquareType(player2Square) == FALL_BEHIND) {
							if (!isSecondRollP2) {
								isSecondRollP2 = true;
								roll(-1);
								
							}
							else {
								isSecondRollP2 = false;
								endTurn();
							}
						}
						else if (getSquareType(player2Square) == CYTOWN) {
							//possible buy CyTown, pause turn
							isSecondRollP2 = false;
							break;
							
						}
						
						
					
					} 
											
					
				}	
			
				
				
				
			
				
		}
			
			
			
		
		/**
		 * Method called to indicate the current player has completed their turn.
		 */
		public void endTurn() {
			if(currentPlayer == 1) {
			currentPlayer = 2;
			}
			else  {
				currentPlayer = 1;
			}
			
		}
		

		
		/**
		 * Returns a one-line string representation of the current game state. The
		 * format is:
		 * <p>
		 * <tt>Player 1*: (0, false, $0) Player 2: (0, false, $0)</tt>
		 * <p>
		 * The asterisks next to the player's name indicates which players turn it
		 * is. The values (0, false, $0) indicate which square the player is on,
		 * if the player is the owner of CyTown, and how much money the player has
		 * respectively.
		 * 
		 * @return one-line string representation of the game state
		 */
		
		
		public String toString() {
			String fmt = "Player 1%s: (%d, %b, $%d) Player 2%s: (%d, %b, $%d)";
			String player1Turn = "";
			String player2Turn = "";
			if (getCurrentPlayer() == 1) {
				player1Turn = "*";
			} else {
				player2Turn = "*";
			}
			return String.format(fmt,
					player1Turn, getPlayerSquare(1), isPlayer1CyTownOwner(), getPlayerMoney(1),
					player2Turn, getPlayerSquare(2), isPlayer2CyTownOwner(), getPlayerMoney(2));
		}
		
	}


