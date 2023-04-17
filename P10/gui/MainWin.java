package gui;
import javax.swing.JFrame;           // for main window
import javax.swing.JOptionPane;      // for standard dialogs
import javax.swing.JPanel;
// import javax.swing.JDialog;          // for custom dialogs (for alternate About dialog)
import javax.swing.JMenuBar;         // row of menu selections
import javax.swing.JMenu;            // menu selection that offers another menu
import javax.swing.JMenuItem;        // menu selection that does something
import javax.swing.JToolBar;         // row of buttons under the menu
import javax.swing.JButton;          // regular button
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JToggleButton;    // 2-state button
import javax.swing.BorderFactory;    // manufacturers Border objects around buttons
import javax.swing.Box;              // to create toolbar spacer
import javax.swing.BoxLayout;
import javax.swing.UIManager;        // to access default icons
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.GridLayout;
import javax.swing.JTextField;

import store.Customer;
import store.Option;
import store.Store;
import store.Computer;
import store.Order;

import javax.swing.JLabel;           // text or image holder
import javax.swing.ImageIcon;        // holds a custom icon
import javax.swing.SwingConstants;   // useful values for Swing method calls

import javax.imageio.ImageIO;        // loads an image from a file

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;                 // opens a file
import java.io.FileFilter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;          // reports an error reading from a file
import java.util.ArrayList;
import java.awt.BorderLayout;        // layout manager for main window
import java.awt.FlowLayout;          // layout manager for About dialog

import java.awt.Color;               // the color of widgets, text, or borders
import java.awt.Font;                // rich text in a JLabel or similar widget
import java.awt.image.BufferedImage; // holds an image loaded from a file

public class MainWin extends JFrame {

  private Store store = new Store("Macrosoft");

    public MainWin(String title) {
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(650, 200);
        setLocationRelativeTo(null);
        // /////// ////////////////////////////////////////////////////////////////
        // M E N U
        // Add a menu bar to the PAGE_START area of the Border Layout

        JMenuBar menubar = new JMenuBar();
        
        JMenu     file         = new JMenu("File");
        JMenuItem newStore     = new JMenuItem("New Store");
        JMenuItem openStore    = new JMenuItem("Open Store");
        JMenuItem saveStore    = new JMenuItem("Save Store");
        JMenuItem saveStoreAs  = new JMenuItem("Save Store As");
        JMenuItem quit         = new JMenuItem("Quit");

        JMenu     insert       = new JMenu("Insert");
        JMenuItem customer     = new JMenuItem("Customer");
        JMenuItem option       = new JMenuItem("Option");
        JMenuItem computer     = new JMenuItem("Computer");
        JMenuItem order     = new JMenuItem("Order");

        JMenu     view          = new JMenu("View");
        JMenuItem customers     = new JMenuItem("Customers");
        JMenuItem options       = new JMenuItem("Options");
        JMenuItem computers     = new JMenuItem("Computers");
        JMenuItem orders         = new JMenuItem("Orders");
        

        JMenu     help       = new JMenu("Help");
        JMenuItem about      = new JMenuItem("About");

        quit.addActionListener(event -> onQuitClick());
        newStore.addActionListener(event -> {
          try {
            onNewClick();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
        openStore.addActionListener(event -> onOpenClick());
        saveStore.addActionListener(event -> {
          try {
            onSaveClick();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
        saveStoreAs.addActionListener(event -> {
          try {
            onSaveAsClick();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
        about.addActionListener(event -> onAboutClick());
        customer.addActionListener(event -> onInsertCustomerClick());
        option.addActionListener(event -> onInsertOptionClick());
        computer.addActionListener(event -> onInsertComputerClick());
        order.addActionListener(event -> {
          try {
            onInsertOrderClick();
          } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
          }
        });
        customers.addActionListener(event -> onViewClick(Record.CUSTOMER));
        options.addActionListener(event -> onViewClick(Record.OPTION));
        computers.addActionListener(event -> onViewClick(Record.COMPUTER));
        orders.addActionListener(event -> onViewClick(Record.ORDER));

        
        file.add(newStore);
        file.add(openStore);
        file.add(saveStore);
        file.add(saveStoreAs);
        file.add(quit);
        help.add(about);
        insert.add(customer);
        insert.add(option);
        insert.add(computer);
        insert.add(order);
        view.add(customers);
        view.add(options);
        view.add(computers);
        view.add(orders);
        
        menubar.add(file);
        menubar.add(insert);
        menubar.add(view);
        menubar.add(help);
      
        setJMenuBar(menubar);
        
        // ///////////// //////////////////////////////////////////////////////////
        // T O O L B A R
        // Add a toolbar to the PAGE_START region below the menu
        JToolBar toolbar = new JToolBar("Elsa Controls");


        button1  = new JButton(new ImageIcon("gui/custo.png"));
          button1.setActionCommand("Enter a new Customer");
          button1.setToolTipText("Enter a new Customer");
          toolbar.add(button1);
          button1.addActionListener(event -> onInsertCustomerClick());

        button2    = new JButton(new ImageIcon("gui/option.png"));
          button2.setActionCommand("Enter a new Option");
          button2.setToolTipText("Enter a new Option");
          toolbar.add(button2);
          button2.addActionListener(event -> onInsertOptionClick());

        button3 = new JButton(new ImageIcon("gui/computer.png"));
          button3.setActionCommand("Enter a new Computer");
          button3.setToolTipText("Enter a new Computer");
          toolbar.add(button3);
          button3.addActionListener(event -> onInsertComputerClick());
        
        // A "horizontal strut" is just a space of the specified pixel width
        toolbar.add(Box.createHorizontalStrut(25));
        
        button4 = new JButton(new ImageIcon("gui/customersView.png"));
          button4.setActionCommand("View Customers");
          button4.setToolTipText("View Customers");
          toolbar.add(button4);
          button4.addActionListener(event -> onViewClick(Record.CUSTOMER));

         button5    = new JButton(new ImageIcon("gui/optionsView.png"));
          button5.setActionCommand("View Options");
          button5.setToolTipText("View Options");
          toolbar.add(button5);
          button5.addActionListener(event -> onViewClick(Record.OPTION));

        button6 = new JButton(new ImageIcon("gui/computerView.png"));
          button6.setActionCommand("View Computers");
          button6.setToolTipText("View Computers");
          toolbar.add(button6);
          button6.addActionListener(event -> onViewClick(Record.COMPUTER));

          toolbar.add(Box.createHorizontalStrut(25));
        
         button7 = new JButton(new ImageIcon("gui/new.png"));
          button7.setActionCommand("New Store");
          button7.setToolTipText("New Store");
          toolbar.add(button7);
          button7.addActionListener(event -> {
            try {
              onNewClick();
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          });

         button8  = new JButton(new ImageIcon("gui/open.png"));
          button8.setActionCommand("Open Store");
          button8.setToolTipText("Open Store");
          toolbar.add(button8);
          button8.addActionListener(event -> onOpenClick());

         button9 = new JButton(new ImageIcon("gui/save.png"));
          button9.setActionCommand("Save Store");
          button9.setToolTipText("Save Store");
          toolbar.add(button9);
          button9.addActionListener(event -> {
            try {
              onSaveClick();
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          });

         button10 = new JButton(new ImageIcon("gui/saveAs.png"));
          button10.setActionCommand("Save As Store");
          button10.setToolTipText("Save As Store");
          toolbar.add(button10);
          button10.addActionListener(event -> {
            try {
              onSaveAsClick();
            } catch (IOException e) {
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          });

          toolbar.add(Box.createHorizontalStrut(25));

          button11 = new JButton(new ImageIcon("gui/Insert_Order-1.png"));
          button11.setActionCommand("Insert Order");
          button11.setToolTipText("Insert Order");
          toolbar.add(button11);
          button11.addActionListener(event -> {
            try {
              onInsertOrderClick();
            } catch (IOException e) { 
              // TODO Auto-generated catch block
              e.printStackTrace();
            }
          });

          button12 = new JButton(new ImageIcon("gui/View_Order-1.png"));
          button12.setActionCommand("View Orders");
          button12.setToolTipText("View Orders");
          toolbar.add(button12);
          button12.addActionListener(event -> onViewClick(Record.ORDER));
          


        
        // // Create a toggle button to enable or disable the computer player
        // computerPlayer = new JToggleButton(new ImageIcon("freepik_robot.png"));
        //   computerPlayer.setActionCommand("Enable computer player");
        //   computerPlayer.setToolTipText("Enable computer to be Player 2");
        //   computerPlayer.setBorder(null);
        //   toolbar.add(computerPlayer);
        //   computerPlayer.addActionListener(event -> onComputerPlayerClick());

        // "Horizontal glue" expands as much as possible, pushing the "X" to the right
        toolbar.add(Box.createHorizontalGlue());
        
        // Create a custom Quit button (not available in Swing stock icons)
        JButton quitB  = new JButton("X");
          quitB.setActionCommand("Quit");
          quitB.setToolTipText("Exit game");
          quitB.setBorder(null);
          toolbar.add(quitB);
          quitB.addActionListener(event -> onQuitClick());
        toolbar.addSeparator();

        getContentPane().add(toolbar, BorderLayout.PAGE_START);
        
        
        // ///////////////////////////////////////////////////////////////////////
        // C O M P U T E R S   D I S P L A Y
        // Provide a text entry box to show the remaining data
        data = new JLabel();
        data.setFont(new Font("SansSerif", Font.BOLD, 18));
        add(data, BorderLayout.CENTER);

        // S T A T U S   B A R   D I S P L A Y ////////////////////////////////////
        // Provide a status bar for game messages
        msg = new JLabel();
        add(msg, BorderLayout.PAGE_END);
        
        // Make everything in the JFrame visible
        setVisible(true);
        
        // Start a new game
        //onInsertCustomerClick();
    }
    
    // Listeners

    protected void onNewClick() throws IOException {        
      //WIPE EXISTING STORE WITH NEW ONE?
      //maybe have a dialogue like "have you saved yet?" then "Enter new store name"
      //"Let user pick name"
      int dialogButton = JOptionPane.YES_NO_OPTION;
      int dialogResult = JOptionPane.showConfirmDialog (null, "Would You Like to Save First?","Warning",dialogButton);
        if(dialogResult == JOptionPane.YES_OPTION){
        onSaveClick();
        }
        String newStoreName = JOptionPane.showInputDialog("Enter Store Name");
        store = new Store(newStoreName);
    }
    protected void onSaveClick() throws IOException {        
        if(filename == null){
          filename = new File("default.txt");
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filename.getName()))){

          store.Save(bw);
          //bw.write("TEST\n");
          //bw.close();
        } catch (Exception e) {
          System.err.println("Failed to write" + e );
        }
        //call save method from store object
    }
    protected void onInsertOrderClick() throws IOException {

      Customer selectedCustomerOne = null;

      Object[] tempCustomers = store.customers();
      //THIS RETURN MAYBE A PROB IDK
      if(tempCustomers.length == 0){onInsertCustomerClick(); return;}
      else if(tempCustomers.length == 1){ selectedCustomerOne = (Customer) tempCustomers[0];}
      else {

         JPanel panel = new JPanel();

         ArrayList<String> optionsArrList = new ArrayList<String>();
          for(int i=0; i<tempCustomers.length; i++){
            optionsArrList.add(tempCustomers[i].toString());
          }
          
          Object[] OptionsArr = optionsArrList.toArray();

         JComboBox firstBox = new JComboBox(OptionsArr);
         JOptionPane.showMessageDialog(null, firstBox, "Select Customer",
        JOptionPane.QUESTION_MESSAGE);
        panel.add(firstBox);
      
        String selectedOptionString = firstBox.getSelectedItem().toString();
        for(int i=0; i<tempCustomers.length; i++){
          if(selectedOptionString.equals(tempCustomers[i].toString())){
            Object selectedCustomer = tempCustomers[i];
            selectedCustomerOne = (Customer)selectedCustomer;
            //System.out.println((Customer)selectedCustomer);
          }
        }
      }
      //with selected customer one now what??
      Order tempOrder = new Order(selectedCustomerOne);
      store.add(tempOrder);
      JPanel panel = new JPanel();
      Object[] computersAvailableTemp = store.computers();

      Computer[] temp5 = new Computer[computersAvailableTemp.length];
      for(int i=0; i<computersAvailableTemp.length; i++){
        Computer tempComp = (Computer) computersAvailableTemp[i];
        temp5[i]=tempComp;
      }


      // Computer[] tempp = (Computer[]) computersAvailableTemp;
      // System.out.println("\n\nYES\n\n");
      ArrayList<String> ComputersList = new ArrayList<String>();
      

      for(int i=0; i<computersAvailableTemp.length; i++){
        ComputersList.add(temp5[i].toString());
      }

      String[]finalComputerList = new String[computersAvailableTemp.length];
      for(int i=0; i<ComputersList.size(); i++){
        finalComputerList[i]=ComputersList.get(i);
      }
      if(finalComputerList.length == 0){
        JOptionPane.showMessageDialog(panel, "Store is Empty");
        return;}
      JComboBox secondBox = new JComboBox((finalComputerList));
   

      JOptionPane.showMessageDialog(null, secondBox, "Select Computer",
        JOptionPane.QUESTION_MESSAGE);
        panel.add(secondBox);

        //if they picked one do somehting
        String selectedComputerString = secondBox.getSelectedItem().toString();
        Computer selectedComputerOne = null;

        for(int i=0; i<finalComputerList.length; i++){
          if(selectedComputerString.equals(finalComputerList[i].toString())){
            Object selectedComputer = temp5[i];
            selectedComputerOne = (Computer)selectedComputer;
            // System.out.println("\n\n\n\n");
            // System.out.println(selectedComputerOne);
            // System.out.println("\n\n\n\n");
          }
        }

        //we now have the computer they want; add to order
        tempOrder.addComputer(selectedComputerOne);

        onViewClick(Record.ORDER);

    }
    protected void onSaveAsClick() throws IOException {        
        final JFileChooser fc = new JFileChooser(filename);
        FileNameExtensionFilter storeFiles = new FileNameExtensionFilter("Store Files", "txt");
        fc.addChoosableFileFilter(storeFiles);
        fc.setFileFilter(storeFiles);

        int result = fc.showSaveDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
          filename = fc.getSelectedFile();
          if(!filename.getAbsolutePath().endsWith(".txt"))
          filename = new File(filename.getAbsolutePath() + ".txt");
          onSaveClick();
        }
    }
    protected void onOpenClick() {        
        final JFileChooser fc = new JFileChooser();
        // FileNameExtensionFilter storeFiles = new FileNameExtensionFilter("Store Files", "txt");
        // fc.addChoosableFileFilter(storeFiles);
        // fc.setFileFilter(storeFiles);
        int result = fc.showOpenDialog(this);
        if(result == JFileChooser.APPROVE_OPTION){
          filename = fc.getSelectedFile();
          if(!filename.getAbsolutePath().endsWith(".txt"))
          filename = new File(filename.getAbsolutePath() + ".txt");
    }

    if(filename != null){
      //do something
    }
    try (BufferedReader br = new BufferedReader(new FileReader(filename.getName()))){
      store = new Store(br);
    } catch (Exception e) {
      System.err.println("Failed to read" + e );
    }
  }

    protected void onViewClick(Record record) {     
          // Display VIEW of each list
          if(Record.ORDER.equals(record)){
            //display the options
            Object[] forViewing = store.orders();
            //cast to options
            Order tempOrders[] = new Order[forViewing.length];
            for(int i=0; i<forViewing.length; i++){
              tempOrders[i] = (Order) forViewing[i];
            }
            //[DEBUG]System.out.println("\n\n" + tempOrders[0] + "\n\n");
            //we got the order, now we need to display!
            JLabel title = new JLabel("<html>"
          + "<p><font size=+2>Orders</font></p>"
          +  "</br>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel data = new JLabel("<html>"
          + "<br/><p>Current Orders</p>"
          + "<p>UpToDate</p><br/>"
          + "</html>");

          //Get all the objects or 'Orders' into a String for HTML format
        StringBuilder s1 = new StringBuilder();
        for(Order i : tempOrders){  
        s1.append(i.toString());
        s1.append("\n");
        }
        String ordersLoaded = s1.toString();
        //customersLoaded = customersLoaded.replaceAll("\n", "<br/>");
        data.setText(("<html>" + ordersLoaded.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));

         JOptionPane.showMessageDialog(this, 
             new Object[]{null, title, data},
             "Orders",
             JOptionPane.PLAIN_MESSAGE
         );

          }

      if(Record.CUSTOMER.equals(record)){
        Object[] forViewing = store.customers();

        //here casting to customers arr
        int length = forViewing.length;
        Customer customers[] = new Customer[length];
        for(int i=0; i<length; i++){
          customers[i] = (Customer) forViewing[i];
        }
        //[DEBUG]System.out.println("\n\n" + customers[0] + "\n\n");

        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+2>Customers</font></p>"
          +  "</br>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel data = new JLabel("<html>"
          + "<br/><p>Current Customers</p>"
          + "<p>UpToDate</p><br/>"
          + "</html>");
          
          //Get all the objects or 'Customers' into a String for HTML format
        StringBuilder s1 = new StringBuilder();
        for(Customer i : customers){  
        s1.append(i.toString());
        s1.append("\n");
        }

        String customersLoaded = s1.toString();
        //customersLoaded = customersLoaded.replaceAll("\n", "<br/>");
        data.setText(("<html>" + customersLoaded.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));

         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, data},
             "Customers",
             JOptionPane.PLAIN_MESSAGE
         );
      }


      else if(Record.COMPUTER.equals(record)){
        Object[] forViewing = store.computers();

        //here casting to computers arr
        int length = forViewing.length;
        Computer computers[] = new Computer[length];
        for(int i=0; i<length; i++){
          computers[i] = (Computer) forViewing[i];
        }
        //[DEBUG]System.out.println("\n\n" + computers[0] + "\n\n");


        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Computers</font></p>"
          + "<p>Version 1.4J</p>"
           + "</html>",
          SwingConstants.CENTER);


          JLabel data = new JLabel("<html>"
          + "<br/><p>Current Computers</p>"
          + "<p>UpToDate</p><br/>"
          + "</html>");
          
          //Get all the objects or 'Customers' into a String for HTML format
        StringBuilder s1 = new StringBuilder();
        for(Computer i : computers){  
        s1.append(i.toString());
        s1.append("\n");
        }

        String computersLoaded = s1.toString();
        //customersLoaded = customersLoaded.replaceAll("\n", "<br/>");
        data.setText(("<html>" + computersLoaded.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));

          
         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, data},
             "Computers",
             JOptionPane.PLAIN_MESSAGE
         );
      }

      else if(Record.OPTION.equals(record)){
        Object[] forViewing = store.options();

          //here casting to computers arr
          int length = forViewing.length;
          Option options[] = new Option[length];
          for(int i=0; i<length; i++){
            options[i] = (Option) forViewing[i];
          }
          //[DEBUG]System.out.println("\n\n" + options[0] + "\n\n");


        JLabel logo = null;
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            logo = new JLabel(new ImageIcon(myPicture));
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Options</font></p>"
          + "<p>Version 1.4J</p>"
           + "</html>",
          SwingConstants.CENTER);

          JLabel data = new JLabel("<html>"
          + "<br/><p>Current Options</p>"
          + "<p>UpToDate</p><br/>"
          + "</html>");
          
          //Get all the objects or 'Customers' into a String for HTML format
        StringBuilder s1 = new StringBuilder();
        for(Option i : options){  
        s1.append(i.toString());
        s1.append("\n");
        }

        String optionsLoaded = s1.toString();
        //customersLoaded = customersLoaded.replaceAll("\n", "<br/>");
        data.setText(("<html>" + optionsLoaded.replaceAll("<","&lt;").replaceAll(">", "&gt;").replaceAll("\n", "<br/>") + "</html>"));

          
         JOptionPane.showMessageDialog(this, 
             new Object[]{logo, title, data},
             "Options",
             JOptionPane.PLAIN_MESSAGE
         );
      }
    }

    protected void onInsertComputerClick() {     
      //ALL BUT OPTIONS DROP DOWN VALIDATED
      JPanel pane = new JPanel();
      pane.setLayout(new GridLayout(0, 2, 2, 2));

      JTextField computerName = new JTextField(5);
      JTextField modelName = new JTextField(5);

      pane.add(new JLabel("Enter Computer Name"));
      pane.add(computerName);

      pane.add(new JLabel("Enter Model"));
      pane.add(modelName);

      int option = JOptionPane.showConfirmDialog(null, pane, "Insert Computer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
      
      String nameInput = computerName.getText();
      String modelInput = modelName.getText();
      // String nameComputer = JOptionPane.showInputDialog("Enter Computer Name", "Computer");
       if(nameInput != null && !nameInput.equals("")){
      // String model = JOptionPane.showInputDialog("Enter Model", "Model");
       if(modelInput != null && !modelInput.equals("")){
       Computer computer = new Computer(nameInput, modelInput);
      //  [DEBUG]System.out.println("\n\n\n"+computer + "\n\n\n");
      Object[] optionsArray = store.options();
      JComboBox<Object> selectOption = new JComboBox<>(optionsArray);

      //how do you select more than one option?
      //change yes and no to add and done.

      Object[] options = {"ADD",
      "DONE"};

      int selectedOption = 0;
      while(selectedOption != 1){
        //selectedOption = JOptionPane.showConfirmDialog(null, selectOption);
        selectedOption = JOptionPane.showOptionDialog(null, selectOption,"Select Option",JOptionPane.YES_NO_OPTION,
        JOptionPane.QUESTION_MESSAGE, null,options,options[0]);
        //YES BUTTON TO ADD, NO BUTTON TO DONE, CANCEL DOES NOT WORK
        if(selectedOption == 1 || selectedOption == 2){
          break;
        }
        ///[DEBUG}System.out.println("/n/n/nchosen is 1 " + selectedOption);
        Object chosenOptionObj = selectOption.getSelectedItem();

        //[DEBUG]System.out.println("/n/n/nchosen is 2 " + chosenOptionObj);
        computer.addOption((Option) chosenOptionObj);
        //[DEBUG]System.out.println("/n/n/nchosen is 3 " + computer);
      }
      //[DEBUG]System.out.println("/n/n/HERE IS THE ORDER" + computer);
      store.add(computer);
        }
      }
    }
    protected void onInsertOptionClick() {     
      //VALIDATED
      JPanel pane = new JPanel();
      pane.setLayout(new GridLayout(0, 2, 2, 2));

      JTextField option1 = new JTextField(5);
      JTextField cost1 = new JTextField(5);

      pane.add(new JLabel("Enter Option"));
      pane.add(option1);

      pane.add(new JLabel("Enter Cost [$xx.xx]"));
      pane.add(cost1);

      int option = JOptionPane.showConfirmDialog(null, pane, "Insert Option", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
      
      String optionInput = option1.getText();
      long costInput2 = (long) (Double.parseDouble(cost1.getText()) * 100);
      //Long costInput2 = Long.parseLong(cost1.getText()) * 100;
       Option newOption = new Option(optionInput, costInput2);
       store.add(newOption);

      // String option = JOptionPane.showInputDialog("Enter Option", "Option");
      // if(option !=null && !option.equals("Option")){
      // String cost = JOptionPane.showInputDialog("Enter Cost [$xx.xx]");
      // long costDouble = (long) (Double.parseDouble(cost) * 100);

      // //JOptionPane.showInputDialog(costDouble);
      // Option newOption = new Option(option, costDouble);
      // store.add(newOption);
     // }
    }

    protected void onInsertCustomerClick() {        
      JPanel pane = new JPanel();
      pane.setLayout(new GridLayout(0, 2, 2, 2));

      JTextField name1 = new JTextField(5);
      JTextField email1 = new JTextField(5);

      pane.add(new JLabel("Enter Customer Name"));
      pane.add(name1);

      pane.add(new JLabel("Enter Customer Email"));
      pane.add(email1);

      int option = JOptionPane.showConfirmDialog(null, pane, "Insert Customer", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE);
      
      String nameInput = name1.getText();
      String emailInput = email1.getText();
      
      if (option == JOptionPane.YES_OPTION) {

        if(nameInput != null && !nameInput.equals("")){
          if(emailInput!=null && !emailInput.equals("")){
            Customer newCustomer = null;
                try{
                  newCustomer = new Customer(nameInput, emailInput);
                }catch(Exception e){
                  if(emailInput != null){
                    JOptionPane.showMessageDialog(null, "Invalid Email");
                  }
                }
                //right here below is new code, should be good
                if(newCustomer == null) return;
                store.add(newCustomer);
                }
          }
        }
         

          // try {
          //     days = Integer.parseInt(nameInput);
          //     assignments = Integer.parseInt(assignmentsInput);
          // } catch (NumberFormatException nfe) {
          //     nfe.printStackTrace();
          // }
      }
  
  //   //VALIDATED
  //   String name = JOptionPane.showInputDialog("Enter Customer Name", "Name");
  //     if(name != null && !name.equals("Name")){
  //   String email = JOptionPane.showInputDialog("Enter Customer Email", "Email");
  //       if(email!=null && !email.equals("Email")){
  //   Customer newCustomer = null;
  //   try{
  //     newCustomer = new Customer(name, email);
  //   }catch(Exception e){
  //     if(email != null){
  //       JOptionPane.showMessageDialog(null, "Invalid Email");
  //     }
  //   }
  //   store.add(newCustomer);
  //    }
  //  }
  

    protected void onNewStoreClick() {        
    }
    
    protected void onButtonClick(int button) {  // Select 1, 2, or 3 sticks from pile
        // try {
        //     // Catch the "impossible" out of sticks exception
        //     nim.takeSticks(button);
        //     setSticks();
        // } catch(Exception e) {
        //     sticks.setText("FAIL: " + e.getMessage() + ", start new game");
        // }
    }
            
    protected void onComputerPlayerClick() {   // Enable / disable computer player
        // setSticks();
        // // Java Swing requires action to visually indicate enabled / disabled button
        // computerPlayer.setBorder(computerPlayer.isSelected() ? BorderFactory.createLineBorder(Color.black) : null);
    }
    protected void onRulesClick() {             // Show the rules
        // String s = "The Rules of Nim\n\nCopyright 2017-2023 by George F. Rice - CC BY 4.0\n\n" +
        //     "The two players alternate taking 1 to 3 sticks from the pile.\n" +
        //     "The goal is to force your opponent to take the last stick (called misère rules).\n" +
        //     "If the computer button is up, it's a two player game. If down, the computer is always Player 2.)";
        // JOptionPane.showMessageDialog(this, s, "The Rules of Nim", JOptionPane.PLAIN_MESSAGE);
    }
    protected void onAboutClick() {                 // Display About dialog
        // JLabel logo = null;
        // try {
        //     BufferedImage myPicture = ImageIO.read(new File("gui/save.png"));
        //     logo = new JLabel(new ImageIcon(myPicture));
        // } catch(IOException e) {
        // }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>ELSA</font></p>"
          + "<p>Version 0.2</p>"
           + "</html>",
          SwingConstants.CENTER);

        JLabel artists = new JLabel("<html>"
          + "<br/><p>Copyright 2023 by Shaan Sekhon</p>"
          + "<p>Licensed under Gnu GPL 3.0</p><br/>"
          + "<p>Logo by GDJ ,, licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/cranium-head-human-male-man-2099120/</font></p>"
          + "<p>Logo by raphaelsilva , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/gear-option-engine-config-icon-2160908/</font></p>"
          + "<p>Logo by Clker-Free-Vector-Images , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/lcd-monitor-computer-32872/</font></p>"
          + "<p>Logo by Deans_Icons , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/illustrations/customer-service-1433640/</font></p>"
          + "<p>Logo by janjf93 , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/flat-design-symbol-icon-www-2126880/</font></p>"
          + "<p>Logo by raphaelsilva , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/gear-option-engine-config-icon-2935358/</font></p>"
          + "<p>Logo by tuktukdesign , licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/icon-user-person-symbol-people-1633249/</font></p>"
          + "<p>Logo by Clker-Free-Vector-Images licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/users/clker-free-vector-images-3736/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=309156</font></p>"
          + "<p>Logo by Clker-Free-Vector-Images licensed under Pixabay License</p>"
          + "<p><font size=-2>ttps://pixabay.com/users/clker-free-vector-images-3736/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=309052</font></p>"
          + "<p>Logo by Clker-Free-Vector-Images licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/users/openclipart-vectors-30363/?utm_source=link-attribution&amp;utm_medium=referral&amp;utm_campaign=image&amp;utm_content=1293738</font></p>"
          + "<p>Logo by OpenClipart-Vectors licensed under Pixabay License</p>"
          + "<p><font size=-2>https://pixabay.com/vectors/icon-user-person-symbol-people-1633249/</font></p>"
          + "<p><font size=-2>all other images used were created by Shaan Sekhon</font></p>"
          + "</html>");
          
          //JPanel Canvas = new JPanel();

          //Canvas.setLayout(new BoxLayout(Canvas, BoxLayout.PAGE_AXIS));
          //Canvas.setBorder(BorderFactory.createTitledBorder("Elsa"));
          
         JOptionPane.showMessageDialog(this, 
             new Object[]{new Canvas(), title, artists},
             "ELSA",
             JOptionPane.PLAIN_MESSAGE
         );
     }

/*
    // This is an alternate About dialog using JDialog instead of JOptionPane
    
    protected void onAboutClick() {                 // Display About dialog
        JDialog about = new JDialog();
        about.setLayout(new FlowLayout());
        about.setTitle("The Game of Nim");
        
        try {
            BufferedImage myPicture = ImageIO.read(new File("128px-Pyramidal_matches.png"));
            JLabel logo = new JLabel(new ImageIcon(myPicture));
            about.add(logo);
        } catch(IOException e) {
        }
        
        JLabel title = new JLabel("<html>"
          + "<p><font size=+4>Nim</font></p>"
          + "</html>");
        about.add(title);

        JLabel artists = new JLabel("<html>"
          + "<p>Version 1.4J</p>"
          + "<p>Copyright 2017-2023 by George F. Rice</p>"
          + "<p>Licensed under Gnu GPL 3.0</p>"
          + "<p>Logo by M0tty, licensed under CC BY-SA 3.0</p>"
          + "<p><font size=-2>https://commons.wikimedia.org/wiki/File:Pyramidal_matches.svg</font></p>"
          + "<p>Robot by FreePik.com, licensed for personal</p><p>and commercial purposes with attribution</p>"
          + "<p><font size=-2>https://www.freepik.com/free-vector/grey-robot-silhouettes_714902.htm</font></p>"
          + "</html>");
        about.add(artists);

        JButton ok = new JButton("OK");
        ok.addActionListener(event -> about.setVisible(false));
        about.add(ok);
        
        about.setSize(450,400);
        about.setVisible(true);
     }
*/
    protected void onQuitClick() {System.exit(0);}   // Exit the game

    private void setSticks() {              // Update display, robot move
        // // s collects the status message
        // String s = "";
        
        // // If the robot is enabled and it's their turn, move the robot
        // if(nim.sticksLeft() > 0) {
        //     if(computerPlayer.isSelected() && nim.currentPlayer() == 2) {
        //         int move = 1;
        //         try {
        //             move = nim.optimalMove();
        //         } catch(Exception e) {
        //             System.err.println("Invalid optimal move: " + e.getMessage());
        //         }
        //         s += "Robot plays " + move + ", ";
        //         nim.takeSticks(move);
        //     }
        // }
        
        // // Report who's turn it is, or (if all sticks gone) who won
        
        // if (nim.sticksLeft() > 0) {
        //     s += "Player " + nim.currentPlayer() + "'s turn";
        // } else {
        //     s += "Player " + nim.currentPlayer() +  " wins!";
        //     msg.setFont(new Font("SansSerif", Font.BOLD, 18));
        // }
        
        // // Display the collected status on the status bar
        // msg.setText(s);

        // // Update the visual display of sticks
        // s = "";
        // for(int i=0; i<nim.sticksLeft(); ++i) s += ("| ");
        // s += "  (" + (nim.sticksLeft()) + " sticks)";
        // sticks.setText(s);

        // // Set sensitivity of the human stick selectors so user can't make an illegal move
        // button1.setEnabled(nim.sticksLeft() > 0);
        // button2.setEnabled(nim.sticksLeft() > 1);
        // button3.setEnabled(nim.sticksLeft() > 2);
    }
    
  //  private Nim nim;
    
    private JLabel data;                  // Display of sticks on game board
    private JLabel msg;                     // Status message display
    private JButton button1;                // Button to select 1 stick
    private JButton button2;                // Button to select 2 sticks
    private JButton button3;                // Button to select 3 sticks
    private JButton button4;                // Button to select 1 stick
    private JButton button5;                // Button to select 2 sticks
    private JButton button6;                // Button to select 3 sticks
    private JButton button7;                // Button to select 3 sticks
    private JButton button8;                // Button to select 3 sticks
    private JButton button9;                // Button to select 3 sticks
    private JButton button10;                // Button to select 3 sticks
    private JButton button11;                // Button to select 3 sticks
    private JButton button12;                // Button to select 3 sticks
    private JToggleButton computerPlayer;   // Button to enable robot
    private File filename;

}
