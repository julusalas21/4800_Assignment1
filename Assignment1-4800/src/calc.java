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
    private int firstOne= Integer.parseInt(null);
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
            firstOne= Integer.parseInt(null);
            ready=false;
            operation= Integer.parseInt(null);
        }
    }
    private void numPresser(int i){
        
    }

    //if text is err clear when num is pressed
    public static calc getInstance(){
        if(initialized==null){
            initialized=new calc();
        }
        return initialized;
    }


}
