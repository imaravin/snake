import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Date;
import java.util.Random;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
public class snake extends JPanel
{
	private static final long serialVersionUID = 1L;
	private static JFrame frame;
	int x[]=new int[100];
	int y[]=new int[100];
	private int m;
	static Thread t;
	protected static AbstractAction downaction;
	protected  static AbstractAction upaction;
	protected  static AbstractAction right;
	protected static AbstractAction left;
	private static KeyStroke Bstroke;
	private static KeyStroke Vstroke;
	private static Action back;
	private static Action fwd;
	static int xv;
	static int yv;
	static int k=20;
	static int score;
	static int posx;
	static int posy;
	Thread audio;
	Date t1,t2;
	public snake()
	{
		m=20;
		k=100;
		int m=new Random().nextInt(1368);
		int n=new Random().nextInt(768);
		x[0]=m;
		y[0]=n;
		xv=5;
		yv=0;
		score=0;
		 t1=new Date();
		for(int i=1;i<100;i++)
		{
			x[i]=x[i-1]-5;
			y[i]=n;
		}
	//	 t=new background();
		posx=new Random().nextInt(1368);
		posy=new Random().nextInt(768);
		
	}
	@SuppressWarnings("deprecation")
	public void paint(Graphics g)
	{
		super.paint(g);
	//	 setOpaque(false);
		//if(!t.isAlive())
	//		t.start();
	
		//setBackground(new Color(0,0,0,125));
		//setBackground(getBackground());
		g.setColor(Color.WHITE);
		//g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
	 g.fillRect(0, 0, 1368, 768);
		g.setColor(Color.BLACK);
		
	//	g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
	 	g.fillRect(5, 5, 1358, 760);
	 	g.setColor(Color.WHITE);
	 	
		for(int i=0;i<30;i++)
		{
			if(i%2==0)
				g.setColor(Color.yellow);
			else
				g.setColor(Color.BLACK);
		//	g.setColor(new Color(new Random().nextInt(255),new Random().nextInt(255),new Random().nextInt(255)));
		//	g.setColor(new Color(new Random().nextInt()));
			g.fillOval(x[i], y[i], 5,5);
		}
		//g.fillOval(posx, posy, 5, 5);
		g.setColor(Color.BLACK);
		g.drawString("Score   "+score, 1225, 700);
	//	g.drawString("Coded by Aravinth", 1250, 750);
		//if((x[0]+15<posx &&y[0]+15<posy)&&(x[0]-15>posx &&y[0]-15>posy))
		{
			
			posx=new Random().nextInt(1368);
			posy=new Random().nextInt(768);
		}
		for(int i=99;i>0;i--)
		{
			x[i]=x[i-1];
			y[i]=y[i-1];
		}
		x[0]=x[0]+xv;
		y[0]=y[0]+yv;
		for(int i=0;i<100;i++)
		{
			if(x[i]<0)
				x[i]=1368;
			if(y[i]<0)
				y[i]=768;
			if(x[i]>1368)
				x[i]=0;
			if(y[i]>768)
				y[i]=0;
		}
		
		if(x[0]>1368-5||y[0]>768-5||y[0]<0||x[0]<0)
		{
		//	t.interrupt();
		//	JOptionPane.showMessageDialog(frame, "Your Score is "+score, "You Lost", JOptionPane.PLAIN_MESSAGE);	
		//	System.exit(0);
			
			
		}
		else
		{
			t2=new Date();
			score=(score+Math.abs(t2.getSeconds()-t1.getSeconds()));
			k=t2.getSeconds()-t1.getSeconds();
			
			if(k<10)
				k=10;
			if(m<0)
				m=1000;
			 if(k>100)
				k=100;
		}
		repaint();
	}

	public static void main(String[] args) throws UnsupportedAudioFileException, IOException, Exception
	{
		
		 frame=new JFrame();
		 
		// AudioInputStream audioInputStream =AudioSystem.getAudioInputStream(new File("C:\\Users\\aravinth\\workspace\\Clock\\Theme Of 3.mp3"));
		 frame.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\aravinth\\workspace\\Clock\\images.jpg"));
		 frame.setUndecorated(true);
		frame.setVisible(true);
	//	frame.getRootPane().setBackground(new Color(0,0,0,125));
		frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	 //	frame.setOpacity(0.2f);
		frame.add(new snake());
		KeyStroke escapeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE,0, false);
		KeyStroke upKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_UP,0, false);
		KeyStroke downKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_DOWN,0, false);
		KeyStroke rightKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_RIGHT,0, false);
		KeyStroke leftKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_LEFT,0, false);
		  Action escapeAction = new AbstractAction()
	        {
				private static final long serialVersionUID = 1L;

					public void actionPerformed(ActionEvent e) 
					{
	                System.exit(0);
	                }
	        };
	        upaction=new AbstractAction()
			{
				private static final long serialVersionUID = 1L;
				public void actionPerformed(ActionEvent arg0)
				{
					xv=0;yv=-5;
					setEnabled(false);
					downaction.setEnabled(false);
					right.setEnabled(true);
					left.setEnabled(true);
				}
			};
			   downaction =new AbstractAction()
				{
					private static final long serialVersionUID = 1L;

					@Override
					public void actionPerformed(ActionEvent arg0)
					{
				xv=0;yv=5;
							setEnabled(false);
							upaction.setEnabled(false);
							right.setEnabled(true);
							left.setEnabled(true);
					}
				};
				 right=new AbstractAction()
				{
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent arg0)
					{
						xv=5;
						yv=0;
		
							setEnabled(false);
							upaction.setEnabled(true);
							downaction.setEnabled(true);
							left.setEnabled(false);
					}
				};
				 left=new AbstractAction()
				{
					private static final long serialVersionUID = 1L;
					public void actionPerformed(ActionEvent arg0)
					{
						xv=-5;yv=0;
							setEnabled(false);
							right.setEnabled(false);
							upaction.setEnabled(true);
							downaction.setEnabled(true);
						
					}
				};
		        frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(escapeKeyStroke,"ESCAPE");
		        frame.getRootPane().getActionMap().put("ESCAPE", escapeAction);
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(upKeyStroke, "UP");
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(downKeyStroke, "DOWN");
				frame.getRootPane().getActionMap().put("UP", upaction);
				frame.getRootPane().getActionMap().put("DOWN", downaction);
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(rightKeyStroke,"RIGHT");
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(leftKeyStroke,"LEFT");
				frame.getRootPane().getActionMap().put("RIGHT", right);
				frame.getRootPane().getActionMap().put("LEFT", left);
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(Bstroke, "BACK");
				frame.getRootPane().getInputMap(JComponent.WHEN_IN_FOCUSED_WINDOW).put(Vstroke, "FWD");
				frame.getRootPane().getActionMap().put("BACK", back);
				frame.getRootPane().getActionMap().put("FWD", fwd);
				frame.setVisible(true);
				
				}
}
