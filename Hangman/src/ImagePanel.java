import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

/**
 * @author Philip Abangan
 * @version 6 Oct 2017
 * Class imagePanel is the whole window containing an image, status info, and input box.
 * GUI has three sections of different information.
 */
public class ImagePanel extends JFrame
{
    private final JLabel textJLabel; // Where the status info is placed (bottom-left).
    private final JLabel promptLabel; // Text that will go on the button (upper section of bottom right).
    private final JTextField inputField; //Where the user enters info (bottom-right).

    public ImagePanel()
    {
        super ("Hangman Game");
        JSplitPane totalPane = new JSplitPane(); // To split the frame into top and bottom.
        JButton enterButton = new JButton("Enter");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);

        //Configure the default window.
        setPreferredSize(new Dimension(550, 750));
        setLayout(new GridLayout());
        add(totalPane);

        inputField = new JTextField(10);
        promptLabel = new JLabel("Enter Word");

        Hangman_Game embeddedHangman = new Hangman_Game();
        JPanel pictureLabel = new JPanel();    // Image container
        pictureLabel.setLayout(new GridLayout()); // So it fills up the space.
        pictureLabel.add(embeddedHangman);
        pictureLabel.setVisible(true);
        textJLabel = new JLabel(embeddedHangman.getGameRules()); // Status string container
        enterButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e)
            {
                // Pressing enter.
                promptLabel.setText("Guess a Letter");
                String enterInput = embeddedHangman.extractNonLetters(inputField.getText());
                inputField.setText("");
                if(embeddedHangman.getRound()==0) // If first round/beginning of game/fist time enter is pressed.
                {
                    embeddedHangman.setWord(enterInput); // Set the input to the word.
                }
                else if(embeddedHangman.getRound() > 99) // If end of game.
                {
                    System.exit(0); // Next action will close console.
                }
                else
                {
                    if (embeddedHangman.isValidGuess(enterInput)) // Only contains letters, and hasn't been guessed yet.
                    {
                        boolean check = embeddedHangman.check(enterInput);
                        if (check) // If the letter is in the word.
                        {
                            embeddedHangman.replaceUnderscores(enterInput); // Replace the the underscores with the char.
                        }
                        else
                        {
                            embeddedHangman.wrongGuess(enterInput.charAt(0)); //call the wrongGuess method.
                            embeddedHangman.nextHangmanImage(); // Call nextHangmanImage method.
                        }
                    }
                    embeddedHangman.winOrLose(); // Check if user won or lost.
                }

                pictureLabel.repaint();
                textJLabel.setText(embeddedHangman.getGameRules());
            }
        });


        // To Center the information.
        inputField.setHorizontalAlignment(JTextField.CENTER);
        textJLabel.setHorizontalAlignment(JLabel.CENTER);
        promptLabel.setHorizontalAlignment(JTextField.CENTER);

        JPanel inputFieldWithButton = new JPanel(new GridBagLayout()); //Bottom-right of GUI
        inputFieldWithButton.add(inputField); // Contains user input text field.
        inputFieldWithButton.add(enterButton); // Contains a button.

        JSplitPane bottomRightPane = new JSplitPane();
        bottomRightPane.setOrientation(JSplitPane.VERTICAL_SPLIT);   // We want it to split the window vertically.
        bottomRightPane.setDividerLocation(90);                       // The window is 400 pixels high.
        bottomRightPane.setTopComponent(promptLabel);               // Place panel with image, at the top.
        bottomRightPane.setBottomComponent(inputFieldWithButton);   // Nested Container

        // Configuring bottom pane into left and right.
        JSplitPane bottomPane = new JSplitPane();
        bottomPane.setOrientation(JSplitPane.HORIZONTAL_SPLIT); //Split left and right.
        bottomPane.setDividerLocation(315);
        bottomPane.setLeftComponent(textJLabel); // bottom-left displays textJLabel
        bottomPane.setRightComponent(bottomRightPane); // Nested Container.

        // let's configure our splitPane:
        totalPane.setOrientation(JSplitPane.VERTICAL_SPLIT);   // We want it to split the window vertically.
        totalPane.setDividerLocation(450);
        totalPane.setTopComponent(pictureLabel);               // Place panel with image, at the top.
        totalPane.setBottomComponent(bottomPane);                // Bottom panel is a nested container.

        pack();
        setContentPane(totalPane);

        validate(); // Validate performs relayout. It means invalid content is asked for all the sizes and all the subcomponents' sizes are set to proper values by LayoutManager.
        setVisible(true);
    } // End of Default Constructor.

} // end class ImagePanel