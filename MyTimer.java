package togglebutton2;
import javax.swing.* ;
import java.awt.* ;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
class counter {
int M,S,Ms;

    counter() {
       M=0;S=0;Ms=0; 
    }
    
    void reset (JButton btn,JLabel l) {
    btn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              M=0;S=0;Ms=0;
              l.setText("00 : 00 : 000");
          }
    });
    }
}
public class MyTimer {
    public static void main(String[] args) throws InterruptedException {
      JFrame window = new JFrame ("Timer") ;
        window.setSize(500 , 400);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.setVisible(true);
        JPanel pan = new JPanel ();
        pan.setLayout(null);
        window.setContentPane(pan);
        JToggleButton tb = new JToggleButton ();
        tb.setBounds(100,200,100,50); 
        pan.add(tb);
        JButton btn = new JButton ("Reset") ;
        btn.setBounds(250,200,100,50);
        pan.add(btn);
        counter count = new counter ();
        JLabel timer = new JLabel ("00 : 00 : 000") ;
        timer.setLocation(100,100);
        timer.setSize(300,50);
        timer.setFont(new Font("Verdana", Font.BOLD, 40));
        pan.add(timer);
        count.reset(btn,timer);
        
        while(true) {
            if (tb.isSelected()){ 
               tb.setText("Pause");
               timer.setText(String.format("%02d", count.M)+" : "+String.format("%02d", count.S)+" : "+String.format("%03d", count.Ms)); 
               count.Ms++ ;
               Thread.sleep(1);
               if (count.Ms==999){
                   count.S++ ;
                   count.Ms=0 ;
               }
               if (count.S==59){
                   count.M++ ;
                   count.S=0;
               }
            }else tb.setText("Start");   
        }
        
    } 
}
