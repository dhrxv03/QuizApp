/**
 * @author dhruvshah
 *
 */
package web.quizapplication;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;

public class QuizTest extends JFrame implements ActionListener {

    private static final long serialVersionUID = 1L;
	JLabel label;
    JRadioButton radioButtons[] = new JRadioButton[5];
    JButton btnNext, btnResult;
    ButtonGroup bg;
    int count = 0, current = 0, x = 1, y = 1, now = 0;
    int m[] = new int[10];

    QuizTest(String s) {
        super(s);
        label = new JLabel();
        add(label);
        bg = new ButtonGroup();
        for (int i = 0; i < 5; i++) {
            radioButtons[i] = new JRadioButton();
            add(radioButtons[i]);
            bg.add(radioButtons[i]);
        }
        btnNext = new JButton("Next");
        btnResult = new JButton("Result:");
        btnResult.setVisible(false);
        btnResult.addActionListener(this);
        btnNext.addActionListener(this);
        add(btnNext);
        add(btnResult);
        setData();
        label.setBounds(30, 40, 450, 20);
        radioButtons[0].setBounds(50, 80, 450, 20);
        radioButtons[1].setBounds(50, 110, 200, 20);
        radioButtons[2].setBounds(50, 140, 200, 20);
        radioButtons[3].setBounds(50, 170, 200, 20);
        btnNext.setBounds(100, 240, 100, 30);
        btnResult.setBounds(270, 240, 100, 30);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setLocation(250, 100);
        setVisible(true);
        setSize(600, 350);

    }

    void setData() {
        radioButtons[4].setSelected(true);
        if (current == 0) {
            label.setText("Q1 How many Bits makes one Byte ?");
            radioButtons[0].setText("8 bit");
            radioButtons[1].setText("16 bit");
            radioButtons[2].setText("32 bit");
            radioButtons[3].setText("1024 bit");
        }
        if (current == 1) {
            label.setText("Q2 Which of the following is a Search Engine ?");
            radioButtons[0].setText("Microsoft Edge");
            radioButtons[1].setText("Mozilla Firefox");
            radioButtons[2].setText("Google");
            radioButtons[3].setText("Internet Explorer");
        }
        if (current == 2) {
            label.setText("Q3 What is the full form of RAM? ");
            radioButtons[0].setText("Random Access Memory");
            radioButtons[1].setText("Read Access Memory");
            radioButtons[2].setText("Run Access Memory");
            radioButtons[3].setText("None of the Above");
        }
        if (current == 3) {
            label.setText("Q4 IC chips used in computers are usually made of :");
            radioButtons[0].setText("Lead");
            radioButtons[1].setText("Silicon");
            radioButtons[2].setText("Chromium");
            radioButtons[3].setText("Gold");
        }
        if (current == 4) {
            label.setText("Q5 Which of the following is not an example of an Operating System ?");
            radioButtons[0].setText("Windows 98");
            radioButtons[1].setText("macOS");
            radioButtons[2].setText("Microsoft Office");
            radioButtons[3].setText("Red Hat Linux");
        }
        if (current == 5) {
            label.setText("Q6 Which of the following is used to manage Database ?");
            radioButtons[0].setText("Operating System");
            radioButtons[1].setText("DBMS");
            radioButtons[2].setText("Compiler");
            radioButtons[3].setText("None of the above");
        }
        if (current == 6) {
            label.setText("Q7 Who invented Java Programming ?");
            radioButtons[0].setText("Guido van Rossum");
            radioButtons[1].setText("Bjarne Stroustrup");
            radioButtons[2].setText("Dennis Ritchie");
            radioButtons[3].setText("James Gosling");
        }
        if (current == 7) {
            label.setText("Q8 Which computer language is written in binary codes only ?");
            radioButtons[0].setText("Pascal");
            radioButtons[1].setText("C");
            radioButtons[2].setText("Assembly Language");
            radioButtons[3].setText("C++");
        }
        if (current == 8) {
            label.setText("Q9 Which Language is used to make webpages?");
            radioButtons[0].setText("C++");
            radioButtons[1].setText("Assembly");
            radioButtons[2].setText("R");
            radioButtons[3].setText("HTML");
        }
        if (current == 9) {
            label.setText("Q10 which is the official language for Android Development ?");
            radioButtons[0].setText("Java");
            radioButtons[1].setText("Kotlin");
            radioButtons[2].setText("C++");
            radioButtons[3].setText("JavaScript");
        }
    label.setBounds(30, 40, 450, 20);
        for(int i=0,j=0; i<=90; i+=30,j++){
            radioButtons[j].setBounds(50, 80+i, 200, 20);
        }
    }
    
    boolean checkAns(){
        if(current==0){
            return (radioButtons[0].isSelected());
        }
        if(current==1){
            return (radioButtons[2].isSelected());
        }
        if(current==2){
            return (radioButtons[0].isSelected());
        }
        if(current==3){
            return (radioButtons[1].isSelected());
        }
        if(current==4){
            return (radioButtons[2].isSelected());
        }
        if(current==5){
            return (radioButtons[1].isSelected());
        }
        if(current==6){
            return (radioButtons[3].isSelected());
        }
        if(current==7){
            return (radioButtons[2].isSelected());
        }
        if(current==8){
            return (radioButtons[3].isSelected());
        }
        if(current==9){
            return (radioButtons[1].isSelected());
        }
    return false;
}

    public static void main(String[] args) {
        new QuizTest("Java Quiz App");
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource()==btnNext){
            if(checkAns())
                count=count+1;
            current++;
            setData();
            if(current==9){
                btnNext.setEnabled(false);
                btnResult.setVisible(true);
                btnResult.setText("Result");
            }
        }
        
        if(e.getActionCommand().equals("Result")){
            if(checkAns())
                count = count + 1;
            current++;
            JOptionPane.showMessageDialog(this,"Correct answers are "+count);
            System.exit(0);
        }
    }
}
