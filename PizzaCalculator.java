import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;

class UI
{   JPanel westPanel = new JPanel();
    JPanel eastPanel = new JPanel();
    JPanel centerPanel = new JPanel();
    JPanel northPanel = new JPanel();
    JPanel southPanel = new JPanel();

    // pizza size options
    JRadioButton Small = new JRadioButton("Small");
    JRadioButton Medium = new JRadioButton("Medium");
    JRadioButton Large = new JRadioButton("Large");

    // pizza topping selections
    JCheckBox Sausage = new JCheckBox("Sausage");
    JCheckBox Olives = new JCheckBox("Olives");
    JCheckBox Pepperoni = new JCheckBox("Pepperoni");
    JCheckBox Mushrooms = new JCheckBox("Mushrooms");
    JCheckBox Salami = new JCheckBox("Salami");
    JCheckBox Anchovies = new JCheckBox("Anchovies");

    // calculate, clear, and total buttons
    JButton Calculate = new JButton("Calculate");
    JButton Exit = new JButton("Exit");
    JLabel Total = new JLabel("Price: ");
    JTextField TotalResult = new JTextField(8);

    // variables used to calculate total
    int TopQty = 0;
    double Size = 0;
    double TopCost = 0;
    double TotalCost = 0;

   public void createUI()
   {
       // layout north portion of frame
        northPanel.setLayout(new GridLayout());
        northPanel.setBorder(new TitledBorder("Size:"));

        // register listeners with buttons
        Small.addActionListener(this);
        Medium.addActionListener(this);
        Large.addActionListener(this);
        Calculate.addActionListener(this);

       ButtonGroup pizzaSize = new ButtonGroup();
       pizzaSize.add(Small);
       pizzaSize.add(Medium);
       pizzaSize.add(Large);


        // add buttons to north panel

        northPanel.add(Small);
        northPanel.add(Medium);
        northPanel.add(Large);


        centerPanel.setLayout(new GridLayout(5, 3));
        centerPanel.setBorder(new TitledBorder("Toppings:"));

        centerPanel.add(Sausage);

        centerPanel.add(Olives);

        centerPanel.add(Pepperoni);

        centerPanel.add(Mushrooms);

        centerPanel.add(Salami);

        centerPanel.add(Anchovies);

        southPanel.add(Total);
        southPanel.add(TotalResult);        
        southPanel.add(Calculate);
        southPanel.add(Exit);


        // add all portions of panel
        setLayout(new BorderLayout());
        add(northPanel, BorderLayout.NORTH);
        add(centerPanel, BorderLayout.CENTER);
        add(southPanel, BorderLayout.SOUTH);
   }

   // handle action event for each pizza option
    public void actionPerformed(ActionEvent e) 
    {
       if (e.getSource() == Small)
            setSizeS();
        else if (e.getSource() == Medium)
            setSizeM();
        else if (e.getSource() == Large)
            setSizeL();

       setTopCost();
              if (e.getSource() == Calculate)
                calculate(Size, TopCost);
      }

    public double setSizeS() 
    {
        return Size = 6.99;
    }

    public double setSizeM() 
    {
        return Size = 8.99;
    }

    public double setSizeL() 
    {
       return Size = 10.99;
    }


    public double setTopCost()
    {               if ( Sausage.isSelected())
                        TopCost = 1.49;
                    else if ( Olives.isSelected())
                        TopCost = 1.49;
                    else if (Pepperoni.isSelected())
                        TopCost = 1.49;
                    else if (Mushrooms.isSelected())
                        TopCost = 0.99;
                    else if (Salami.isSelected())
                        TopCost = 0.99;
                    else if (Anchovies.isSelected())
                        TopCost = 0.99;


        return TopCost;

    }

    public void calculate(double Size, double TopCost) 
    {
       TotalCost = Size + TopCost;
        TotalResult.setText(String.valueOf(TotalCost));
    }

    public static void main(String[] args) 
    {
       PizzaCalculator PizzaCalc = new PizzaCalculator();
        // set window title
        PizzaCalc.setTitle("Pizza Calculator");
        // set window location
        PizzaCalc.setLocationRelativeTo(null);
        // specify window location
        PizzaCalc.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // set window size
        PizzaCalc.setSize(300, 350);
        // display window
        PizzaCalc.setVisible(true);
    }
}

class MyMain
{       public static void main(String[] args)
        {       UI ui1=new UI();
                ui1.createUI();
        }


}


 


      