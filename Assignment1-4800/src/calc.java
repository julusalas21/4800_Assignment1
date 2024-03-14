import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calc {
    private JFrame frame;
    private JPanel panel;
    private JTextField usr;
    private JButton a7Btn;
    private JButton a4Btn;
    private JButton clearButton;
    private JButton divBtn;
    private JButton a1Btn;
    private JButton a2Btn;
    private JButton a3Btn;
    private JButton plusBtn;
    private JButton minBtn;
    private JButton multBtn;
    private JButton a9Btn;
    private JButton a8Btn;
    private JButton a6Btn;
    private JButton a5Btn;
    private JButton negateBtn;
    private JButton a0Btn;
    private JButton decButton;
    private JButton eqlBtn;
    private JButton backButton;
    private int firstOne;
    private boolean ready;
    private int operation;

    private static calc initialized=null;

    public calc(){
        initialize();
        frame.setVisible(true);
    }

    private void initialize(){
        frame=new JFrame("calculator");
        frame.setContentPane(panel);
        frame.setPreferredSize(new Dimension(600,500));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocation(500,200);
        ImageIcon icon = new ImageIcon("src/calculator.png");
        frame.setIconImage(icon.getImage());

        //operations
        multBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(1);
            }
        });
        plusBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(2);
            }
        });
        divBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(3);
            }
        });
        minBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                setNum(4);
            }
        });

        a1Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(1);
            }
        });
        a2Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(2);
            }
        });
        a3Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(3);
            }
        });
        a4Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(4);
            }
        });
        a5Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(5);
            }
        });
        a6Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(6);
            }
        });
        a7Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(7);
            }
        });

        a8Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(8);
            }
        });
        a9Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(9);
            }
        });
        a0Btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPresser(0);
            }
        });
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                usr.setText("");
                firstOne=0;
                operation=0;
            }
        });
        eqlBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int temp=Integer.valueOf(usr.getText());
                try{
                    if(operation==1){
                        firstOne=firstOne*temp;
                    }
                    if(operation==2){
                        firstOne=firstOne+temp;
                    }
                    if(operation==3){
                        firstOne=firstOne/temp;
                    }
                    if(operation==4){
                        firstOne=firstOne-temp;
                    }
                    else{
                        usr.setText("err");
                    }
                    usr.setText(String.valueOf(firstOne));
                    firstOne=0;
                    operation=0;
                    ready=false;
                }
                catch(Exception y){
                    setNum(0);
                }
            }
        });
        negateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String getText= usr.getText();
                int temp=Integer.valueOf(getText);
                usr.setText(String.valueOf(-temp));
            }
        });

        frame.pack();
    }
    private void setNum(int i){
        String getText= usr.getText();
        int temp=Integer.valueOf(getText);
        if(!ready){
            firstOne=temp;
            ready=true;
            usr.setText("");
            operation=i;
        }
        //when both numbers are ready
        //throw error

        else{
            usr.setText("err");
            firstOne= 0;
            ready=false;
            operation= 0;
        }
    }
    private void numPresser(int i){
        String getText=usr.getText();
        //if text is err clear when num is pressed
        if(getText.equals("err"))
            getText="";
        getText=getText+i;
        usr.setText(getText);
    }


    public static calc getInstance(){
        if(initialized==null){
            initialized=new calc();
        }
        return initialized;
    }


}
