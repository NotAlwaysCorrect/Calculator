import javax.swing.*;
import java.awt.*;
import java.text.DecimalFormat;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    JFrame frame;
    JPanel mainPanel , buttonPanel, equationPanel;
    JLabel equationOutput, blankLabel0, blankLabel1, blankLabel2, blankLabel3;
    JButton button0,button1, button2, button3, button4, button5, button6, button7, button8, button9, buttonEquals, buttonAdd, buttonSubtract, buttonMultiply, buttonDivide, buttonC, buttonDecimal, buttonBackSpace;
    double displayedValue = 0, heldValue = 0;
    char operation = ' ';
    boolean isDecimalInput = false;
    int decimalPower = 0;
    private static final DecimalFormat df =new DecimalFormat("0.#########");
    public Main() {
        mainPanel = new JPanel();
        mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));

        frame = new JFrame();
        buttonPanel = new JPanel();
        equationPanel = new JPanel();
        equationOutput = new JLabel("Output");

        blankLabel0 = new JLabel();
        blankLabel1 = new JLabel();
        blankLabel2 = new JLabel();
        blankLabel3 = new JLabel();

        button0 = new JButton("0");
        button1 = new JButton("1");
        button2 = new JButton("2");
        button3 = new JButton("3");
        button4 = new JButton("4");
        button5 = new JButton("5");
        button6 = new JButton("6");
        button7 = new JButton("7");
        button8 = new JButton("8");
        button9 = new JButton("9");
        buttonAdd = new JButton("+");
        buttonSubtract = new JButton("-");
        buttonMultiply = new JButton("X");
        buttonDivide = new JButton("/");
        buttonEquals = new JButton("=");
        buttonC = new JButton("C");
        buttonDecimal = new JButton(".");
        buttonBackSpace = new JButton("<-");

        equationPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        equationPanel.setLayout(new GridLayout(0,1));

        buttonPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));
        buttonPanel.setLayout(new GridLayout(0,4));

        equationPanel.add(equationOutput);

        buttonPanel.add(blankLabel0);
        buttonPanel.add(buttonC);
        buttonPanel.add(buttonBackSpace);
        buttonPanel.add(buttonDivide);

        buttonPanel.add(button9);
        buttonPanel.add(button8);
        buttonPanel.add(button7);
        buttonPanel.add(buttonMultiply);

        buttonPanel.add(button6);
        buttonPanel.add(button5);
        buttonPanel.add(button4);
        buttonPanel.add(buttonSubtract);

        buttonPanel.add(button3);
        buttonPanel.add(button2);
        buttonPanel.add(button1);
        buttonPanel.add(buttonAdd);

        buttonPanel.add(blankLabel1);
        buttonPanel.add(button0);
        buttonPanel.add(buttonDecimal);
        buttonPanel.add(buttonEquals);

//        Number button actions. Not sure how to condense this code yet

        button0.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(0);
            displayEquationOutput();
        });

        button1.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(1);
            displayEquationOutput();
        });

        button2.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(2);
            displayEquationOutput();
        });

        button3.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(3);
            displayEquationOutput();
        });

        button4.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(4);
            displayEquationOutput();
        });

        button5.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(5);
            displayEquationOutput();
        });

        button6.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(6);
            displayEquationOutput();
        });

        button7.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(7);
            displayEquationOutput();
        });

        button8.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(8);
            displayEquationOutput();
        });

        button9.addActionListener(e1 -> {
            checkPreviousOperatorIsEquals();
            numberButtonInput(9);
            displayEquationOutput();
        });

//        Operation buttons

        buttonAdd.addActionListener(e1 -> {
            if (operation == ' ' || operation == '=') {
                heldValue = displayedValue;
                displayedValue = 0;
                displayEquationOutput();
            }
            isDecimalInput = false;
            operation = '+';
            decimalPower = 0;
        });

        buttonSubtract.addActionListener(e1 -> {
            if (operation == ' ' || operation == '=') {
                heldValue = displayedValue;
                displayedValue = 0;
                displayEquationOutput();
            }
            isDecimalInput = false;
            operation = '-';
            decimalPower = 0;
        });

        buttonMultiply.addActionListener(e1 -> {
            if (operation == ' ' || operation == '=') {
                heldValue = displayedValue;
                displayedValue = 0;
                displayEquationOutput();
            }
            isDecimalInput = false;
            operation = '*';
            decimalPower = 0;
        });

        buttonDivide.addActionListener(e1 -> {
            if (operation == ' ' || operation == '=') {
                heldValue = displayedValue;
                displayedValue = 0;
                displayEquationOutput();
            }
            isDecimalInput = false;
            operation = '/';
            decimalPower = 0;
        });

        buttonEquals.addActionListener(e1 -> {
            if (operation == '+') {
                heldValue += displayedValue;
            }
            else if (operation == '-') {
                heldValue -= displayedValue;
            }
            else if (operation == '*') {
                heldValue *= displayedValue;
            }
            else if (operation == '/') {
                heldValue /= displayedValue;
            }

            displayedValue = heldValue;
            heldValue = 0;
            equationOutput.setText(String.valueOf(df.format(displayedValue)));

            isDecimalInput = false;
            decimalPower = 0;
            operation = '=';
            equationPanel.revalidate();
            equationPanel.validate();
        });

        buttonDecimal.addActionListener(e1 -> {
            if (!isDecimalInput) {
                equationOutput.setText(df.format(displayedValue) + ".");
            }
            isDecimalInput = true;
        });

        buttonC.addActionListener(e1 -> {
            operation = ' ';
            decimalPower = 0;
            displayedValue = 0;
            heldValue = 0;
            isDecimalInput = false;
            displayEquationOutput();
        });

//        From this learning thing, UI code is generally pretty gross sometimes. As in look at the below
//        I don't know how to make this cleaner, but the part that really makes it hard to understand is trying to
//        remove the decimal point

        buttonBackSpace.addActionListener(e1 -> {
            if (isDecimalInput && decimalPower == 0 && (operation != '=')) {
                isDecimalInput = false;
                equationOutput.setText(String.valueOf(df.format(displayedValue)));
            } else if (isDecimalInput && decimalPower == 1 && (operation != '=')) {
                decimalPower--;
                displayedValue -= displayedValue % Math.pow(10,-decimalPower);
                equationOutput.setText(df.format(displayedValue) + ".");
            } else if (isDecimalInput && (operation != '=')) {
                decimalPower--;
                displayedValue -= displayedValue % Math.pow(10,-decimalPower);
                equationOutput.setText(String.valueOf(df.format(displayedValue)));
            } else if ((operation != '=')) {
                displayedValue = (double) (((long) displayedValue) / 10);
                equationOutput.setText(String.valueOf(df.format(displayedValue)));
            }
        });

        mainPanel.add(equationPanel);
        mainPanel.add(buttonPanel);

        frame.add(mainPanel, BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Calculator");
        frame.pack();
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Main();
    }

    public void checkPreviousOperatorIsEquals() {
        if (operation == '=') {
            heldValue = 0;
            displayedValue = 0;
            operation = ' ';
        }
    }

    public void displayEquationOutput() {
        equationOutput.setText(String.valueOf(df.format(displayedValue)));
        equationPanel.revalidate();
        equationPanel.validate();
    }

    public void numberButtonInput(int number) {
        if (isDecimalInput) {
            decimalPower ++;
            displayedValue = displayedValue + number * Math.pow(10,-decimalPower);
        } else {
            displayedValue = displayedValue * 10 + number;
        }
    }
}