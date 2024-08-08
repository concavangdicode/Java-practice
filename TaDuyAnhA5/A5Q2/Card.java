public class Card {
   private String suit;
   private int number; // A = 1, ..., J = 11, Q = 12, K = 13

   public Card(String suit, int number) {
      this.suit = suit;
      this.number = number;
   }

   public String suit() {
      return suit;
   }

   public int value() {
      return number;
   }
}