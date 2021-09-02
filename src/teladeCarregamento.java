
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class teladeCarregamento extends JFrame {
	
	private JLabel fundo,person;
	private int load = 0;
	
	public teladeCarregamento() {
		// TODO Auto-generated constructor stub
		initComponentes();
		new Temporizador().start();
	}
	
	public void initComponentes() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(0,0,677,260); // tamanho do JFrame
		setUndecorated(true);
		setLocationRelativeTo(null); // tela fica centralizado
		
		person = new JLabel(new ImageIcon("res//Guri01.gif"));
		person.setBounds(305,150,64,64);
		add(person);
		
		fundo = new JLabel(new ImageIcon("res//LoadingBackground.png"));
		fundo.setBounds(0,0,677,260);
		add(fundo);
		
	}

	public static void main(String[] args) {
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
			    new teladeCarregamento().setVisible(true);
			}
		});
	}
	
	public class Temporizador extends Thread{
        public void run(){
            while( load <100){
                try {
                    sleep(50);
                    load +=1;
                    System.out.println(load);
                    // Quando chegar 100%, esta função chamarar outra tela.	
        			if(load >= 100) {
        				setVisible(false);
        			}
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}