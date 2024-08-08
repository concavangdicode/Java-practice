import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class CardGameGUI {
    private Deck deck;
    private JFrame frame;
    private JTextArea textArea;

    public CardGameGUI() {
        deck = new Deck();
        initializeGUI();
    }

    private void initializeGUI() {
        frame = new JFrame("Card Game GUI");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 300);

        JPanel panel = new JPanel();

        JButton shuffleButton = new JButton("Shuffle Deck");
        shuffleButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                shuffleDeck();
            }
        });

        textArea = new JTextArea(10, 30);
        textArea.setEditable(false);
        displayDeck();

        panel.add(shuffleButton);
        panel.add(textArea);

        frame.getContentPane().add(panel);
    }

    private void shuffleDeck() {
        deck.shuffle();
        displayDeck();
    }

    private void displayDeck() {
        List<String> cards = deck.getCards();
        StringBuilder deckText = new StringBuilder();
        for (String card : cards) {
            deckText.append(card).append("\n");
        }
        textArea.setText(deckText.toString());
    }

    public void show() {
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new CardGameGUI().show();
            }
        });
    }
}
