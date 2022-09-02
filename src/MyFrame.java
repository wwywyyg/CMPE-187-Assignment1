
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.function.BinaryOperator;

public class MyFrame extends JFrame{
        int CurrencyAmount = 0;
        int changesReturn = 0;
        int red_gumball_amount = 0;
        int yellow_gumball_amount = 0;
        JLabel insertAmount = new JLabel("Your Amount : " + CurrencyAmount +"\t¢");
        JLabel red_gumball_have = new JLabel("Red Gumballs : " + red_gumball_amount);
        JLabel yellow_gumball_have = new JLabel("Yellow Gumballs : " + yellow_gumball_amount);
        JLabel YChanges = new JLabel("Your Changes : " + changesReturn +"\t¢");
    public MyFrame(String title){
            super(title);

            // create main panel

            JPanel mainPanel = new JPanel();
            this.setContentPane(mainPanel);
            mainPanel.setLayout(new BorderLayout());


            //create top panel
            //North section is the program name
            JPanel topPanel = new JPanel();
            JLabel programName = new JLabel("Gumball Vending Machine");
            programName.setFont(new Font("Arial",Font.BOLD,25));
            topPanel.add(programName);
            //add top panel
            mainPanel.add(topPanel, BorderLayout.NORTH);


            // Left panel
            JPanel leftPanel = new JPanel();
            leftPanel.setLayout(new BoxLayout(leftPanel,BoxLayout.Y_AXIS));

            //Left Title
            JLabel gumballGot = new JLabel("Gumball Price");
            gumballGot.setFont(new Font("Arial",Font.BOLD,20));


            //Red Gumball price label
            JLabel rGumball = new JLabel("      Red Gumball");
            rGumball.setFont(new Font("Arial",Font.PLAIN,15));
            JLabel rPrice = new JLabel("        5\t¢");
            rPrice.setFont(new Font("Arial",Font.BOLD,20));

            //Yellow gumball price label
            JLabel yGumball = new JLabel("    Yellow Gumball");
            yGumball.setFont(new Font("Arial",Font.PLAIN,15));
            JLabel yPrice = new JLabel("       10\t¢");
            yPrice.setFont(new Font("Arial",Font.BOLD,20));


            //Reset button function
            JButton resetButt = new JButton("Reset");
            resetButt.addActionListener(e -> {
                    CurrencyAmount = 0;
                    changesReturn = 0;
                    red_gumball_amount = 0;
                    yellow_gumball_amount = 0;
                    insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
                    red_gumball_have.setText("Red Gumballs : " + red_gumball_amount);
                    yellow_gumball_have.setText("Yellow Gumballs : " + yellow_gumball_amount);
                    YChanges.setText("Your Changes : " + changesReturn +"\t¢");

            });



            // left format setting

            leftPanel.add(Box.createVerticalStrut(150));
            leftPanel.add(gumballGot); // gumball price title

            //add red gumball price and label
            leftPanel.add(Box.createVerticalStrut(20));
            leftPanel.add(rGumball);
            leftPanel.add(rPrice);

            // add yellow gumball and label
            leftPanel.add(yGumball);
            leftPanel.add(yPrice);
            leftPanel.add(Box.createVerticalStrut(120));
            leftPanel.add(resetButt);





            // add left panel
            mainPanel.add(leftPanel,BorderLayout.WEST);




            /* Middle panel
               This part is for the MidPanel.
               MidPanel use border layout , the North section is the Icon of two gumballs.


               the middle section use boxlayout for the customer insert title and button, and the display customer insert amount.
               the button includes 5 , 10 , 25 cents.

               the south section are the two levers for purchase the gumballs

             */
            JPanel midPanel = new JPanel();
            midPanel.setLayout(new BorderLayout());


            /* Mid - top section for gumballs icons
               The gumballs Icon use two images
               The layout is flowLayout
             */

            //  Red gumball icon
            ImageIcon redGum = new ImageIcon("src/redGum.png");
            JLabel redGumball = new JLabel(redGum);

            //  Yellow gumball icon

            ImageIcon yellowGum = new ImageIcon("src/YellowGum.png");
            JLabel yellowGumball = new JLabel(yellowGum);

            // add to North Section
            JPanel gumballIcon = new JPanel();
            gumballIcon.add(redGumball);
            gumballIcon.add(yellowGumball);

            // add to Icon section to the Middle Panel
            midPanel.add(gumballIcon, BorderLayout.NORTH);

            /*   Middle section for middle panel
                 - this part use box layout
                 - one inset text
                 - three currency button

             */

            Box insertCoinSec = Box.createVerticalBox();
            JLabel insertLabel = new JLabel("Insert");
            insertLabel.setFont(new Font("Arial",Font.BOLD,25));

            JButton nickel = new JButton("5\t¢");
            nickel.addActionListener(e -> {
                    CurrencyAmount = CurrencyAmount + 5;
                    insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
            });
            JButton dimes = new JButton("10\t¢");
            dimes.addActionListener(e -> {
                    CurrencyAmount = CurrencyAmount + 10;
                    insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
            });
            JButton quarter = new JButton("25\t¢");
            quarter.addActionListener(e -> {
                    CurrencyAmount = CurrencyAmount + 25;
                    insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
            });




            quarter.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            insertLabel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            nickel.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            dimes.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            insertAmount.setAlignmentX(JComponent.CENTER_ALIGNMENT);




            insertCoinSec.add(Box.createVerticalStrut(20));
            insertCoinSec.add(insertLabel);
            insertCoinSec.add(Box.createVerticalStrut(10));
            insertCoinSec.add(nickel);
            insertCoinSec.add(Box.createVerticalStrut(10));
            insertCoinSec.add(dimes);
            insertCoinSec.add(Box.createVerticalStrut(10));
            insertCoinSec.add(quarter);
            insertCoinSec.add(Box.createVerticalStrut(20));
            insertCoinSec.add(insertAmount);


            midPanel.add(insertCoinSec, BorderLayout.CENTER);


            //add Insert lever

            Box twoLevers = Box.createVerticalBox();

            JButton redLever= new JButton("Red Lever");
            JButton yellowLever= new JButton("Yellow Lever");
            redLever.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            yellowLever.setAlignmentX(JComponent.CENTER_ALIGNMENT);

            // purchase red gumball function
            redLever.addActionListener(e -> {
                    if (CurrencyAmount >= 5){
                            CurrencyAmount = CurrencyAmount - 5;
                            red_gumball_amount = red_gumball_amount + 1;
                            red_gumball_have.setText("Red Gumballs : " + red_gumball_amount);
                            insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
                    }else{
                            //need coins warning
                            JOptionPane.showMessageDialog(null, "not enough Coins !!!");
                    }
            });


            // purchase yellow gumball function
            yellowLever.addActionListener(e -> {
                    if (CurrencyAmount >= 10){
                            CurrencyAmount = CurrencyAmount - 10;
                            yellow_gumball_amount = yellow_gumball_amount + 1;
                            yellow_gumball_have.setText("Yellow Gumballs : " + yellow_gumball_amount);
                            insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
                    }else{
                            //need coins warning
                            JOptionPane.showMessageDialog(null, "not enough Coins !!!");
                    }
            });
            twoLevers.add(redLever);
            twoLevers.add(yellowLever);


            midPanel.add(twoLevers,BorderLayout.SOUTH);








            //add mid  panel
            mainPanel.add(midPanel,BorderLayout.CENTER);




            /* right panel
            use box layout
            - return my change button
            - customer red gumball
            - customer yellow gumball
            - your change label

             */



            Box rightPanel = Box.createVerticalBox();

            // customer gumball title
            JLabel yourGumball = new JLabel("Your Gumball");

            // return button function
            JButton return_my_change = new JButton("Return My Change");
            return_my_change.addActionListener(e -> {
                    changesReturn = changesReturn + CurrencyAmount;
                    YChanges.setText("Your Changes : " + changesReturn +"\t¢");
                    CurrencyAmount = 0;
                    insertAmount.setText("Your Amount : " + CurrencyAmount +"\t¢");
            });

            yourGumball.setFont(new Font("Arial" , Font.BOLD,20));


            //format setting
            return_my_change.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            red_gumball_have.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            yellow_gumball_have.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            YChanges.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            yourGumball.setAlignmentX(JComponent.CENTER_ALIGNMENT);
            rightPanel.add(Box.createVerticalStrut(150));
            rightPanel.add(yourGumball);
            rightPanel.add(Box.createVerticalStrut(10));
            rightPanel.add(red_gumball_have);
            rightPanel.add(Box.createVerticalStrut(10));
            rightPanel.add(yellow_gumball_have);
            rightPanel.add(Box.createVerticalStrut(20));
            rightPanel.add(return_my_change,BorderLayout.NORTH);
            rightPanel.add(Box.createVerticalStrut(20));
            rightPanel.add(YChanges,BorderLayout.CENTER);


            // add to main panel
            mainPanel.add(rightPanel,BorderLayout.EAST);






    }

}
