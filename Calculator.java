import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Calculator implements ActionListener {
    JFrame frame;
    JTextField textField;
    JButton[] numbutton = new JButton[10];
    JButton[] funcbutton = new JButton[9];

    JButton addbutton,subbutton,mulbutton,divbutton,negbutton;
    JButton decbutton,clrbutton,equbutton,delbutton;

    JPanel panel;
    Font font = new Font("Inker Free",Font.BOLD,30);

    double num1=0,num2=0,result=0;
    char operator;

    Calculator(){
        frame = new JFrame("Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(420,550);
        Container contentPane = frame.getContentPane();
        contentPane.setBackground(Color.lightGray);

        panel = new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.lightGray);

        textField = new JTextField();
        textField.setBounds(50,25,300,50);
        textField.setFont(font);

        addbutton = new JButton("+");
        subbutton = new JButton("-");
        mulbutton = new JButton("*");
        divbutton = new JButton("/");
        decbutton = new JButton(".");
        clrbutton = new JButton("Clr");
        equbutton = new JButton("=");
        delbutton = new JButton("Del");
        negbutton = new JButton("(-)");

        funcbutton[0] = addbutton;
        funcbutton[1] = subbutton;
        funcbutton[2] = mulbutton;
        funcbutton[3] = divbutton;
        funcbutton[4] = decbutton;
        funcbutton[5] = clrbutton;
        funcbutton[6] = equbutton;
        funcbutton[7] = delbutton;
        funcbutton[8] = negbutton;

        for(int i=0; i<9; i++){
            funcbutton[i].addActionListener(this);
            funcbutton[i].setFont(font);
            funcbutton[i].setFocusable(false);
        }

        for(int i=0; i<10; i++){
            numbutton[i] = new JButton(String.valueOf(i));
            numbutton[i].addActionListener(this);
            numbutton[i].setFont(font);
            numbutton[i].setFocusable(false);
        }

        negbutton.setBounds(50,430,100,50);
        delbutton.setBounds(150,430,100,50);
        clrbutton.setBounds(250,430,100,50);

        panel.add(numbutton[1]);
        panel.add(numbutton[2]);
        panel.add(numbutton[3]);
        panel.add(addbutton);
        panel.add(numbutton[4]);
        panel.add(numbutton[5]);
        panel.add(numbutton[6]);
        panel.add(subbutton);
        panel.add(numbutton[7]);
        panel.add(numbutton[8]);
        panel.add(numbutton[9]);
        panel.add(mulbutton);
        panel.add(decbutton);
        panel.add(numbutton[0]);
        panel.add(equbutton);
        panel.add(divbutton);


        frame.add(panel);
        frame.add(negbutton);
        frame.add(delbutton);
        frame.add(clrbutton);
        frame.add(textField);
        frame.setVisible(true);
    }


    public static void main(String[] args) {

        Calculator calc = new Calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0; i<10; i++){
            if(e.getSource()==numbutton[i]){
                textField.setText(textField.getText().concat(String.valueOf(i)));
            }
        }
        if(e.getSource()==decbutton){
            textField.setText(textField.getText().concat("."));
        }
        if(e.getSource()==addbutton){
            num1 = Double.parseDouble(textField.getText());
            operator = '+';
            textField.setText("");
        }
        if(e.getSource()==subbutton){
            num1 = Double.parseDouble(textField.getText());
            operator = '-';
            textField.setText("");
        }
        if(e.getSource()==mulbutton){
            num1 = Double.parseDouble(textField.getText());
            operator = '*';
            textField.setText("");
        }
        if(e.getSource()==divbutton){
            num1 = Double.parseDouble(textField.getText());
            operator = '/';
            textField.setText("");
        }
        if(e.getSource()==equbutton){
            num2 = Double.parseDouble(textField.getText());
            switch (operator){
                case '+':
                    result = num1 + num2;
                    break;
                case '-':
                    result = num1 - num2;
                    break;
                case '*':
                    result = num1 * num2;
                    break;
                case '/':
                    result = num1 / num2;
                    break;
            }
            textField.setText(String.valueOf(result));
            num1 = result;
        }
        if(e.getSource()==clrbutton){
            textField.setText("");
        }
        if(e.getSource()==delbutton){
            String string = textField.getText();
            textField.setText("");
            for(int i=0; i<string.length()-1; i++){
                textField.setText(textField.getText()+string.charAt(i));
            }
        }
        if(e.getSource()== negbutton){
            double temp = Double.parseDouble(textField.getText());
            temp *= -1;
            textField.setText(String.valueOf(temp));
        }
    }
}