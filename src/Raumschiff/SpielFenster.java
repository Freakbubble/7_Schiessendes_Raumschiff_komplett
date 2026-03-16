package Raumschiff;

import javax.swing.JFrame;  
import javax.swing.JMenuBar;	
import javax.swing.JMenu;		
import javax.swing.JMenuItem;	
import java.awt.event.ActionListener;	
import java.awt.event.ActionEvent;		

import java.awt.event.WindowAdapter;	
import java.awt.event.WindowEvent;		


public class SpielFenster extends JFrame{ //Durch Ableiten von JFrame werden z.B.Fenstereigenschaften geerbt
										  //Darüber hinaus ist JFrame ein Container für andere Objekte (JPanel, Menu,..)
	private Spielfeld spielfeld;
	
	public SpielFenster() {
		
		//Spielfeld erzeugen
		spielfeld = new Spielfeld();		
		
		registerWindowListener();    // WindowListener registrieren (z.B. Schließen des Fensters)
		createMenu();  // Erzeugen des Menüs
		
		add(spielfeld);  //Hinzufügen des Spielfeldes zum SpielFenster ; (add() erben alle von Container)
		pack();  //Ideale Größe berechnen
		
		this.setTitle("Fliegender Ball");
		this.setLocation(10,10); //Linke obere Fensterecke festlegen
		this.setResizable(false);
		this.setVisible(true);
		
		
		repaint();
	}
	
	private void createMenu() {  
      
	    JMenuBar menuBar = new JMenuBar();  //Menüleiste erzeugen...
	    this.setJMenuBar(menuBar);	//...und dem JFrame hinzufügen
	         
	    JMenu fileMenu = new JMenu("Datei");  //Drei Menüs erzeugen...
	    JMenu gameMenu = new JMenu("Spiel");
	    JMenu prefMenu = new JMenu("Einstellungen");
	         
	    menuBar.add(fileMenu);    //... und zur Menüleiste hinzufügen    
	    menuBar.add(gameMenu);        
	    menuBar.add(prefMenu);
	        
	    addFileMenuItems(fileMenu); //Methode für Menüeintrag aufrufen
	    							// und Menüeintrag erzeugen
	    addSpielMenuItems(gameMenu);
	}
	     
	private void addFileMenuItems(JMenu fileMenu) {  
	         
	    JMenuItem quitItem = new JMenuItem("Ende");
	    fileMenu.add(quitItem); 
	    
	  // Ergänzen eines ActionListeners (um auf einen Mausklick zu reagieren)
	    quitItem.addActionListener(new ActionListener() {	//es wird eine anonyme Klasse (sie hat keinen Namen)
			//definiert und gleichzeitig ein Objekt der Klasse erzeugt. Nachdem nach "new" ein Schnittstellenname
			// ("Actionlistener") verwendet wird, wird in der anonymen Klasse das angegebene Interface implementiert.
	        @Override
	        public void actionPerformed(ActionEvent e) {	//Die anonyme Klasse besitzt diese Methode. Sie wird beim Anklicken ausgeführt.
	            System.exit(0);
	        }
	    }); 
	}
	
	private void addSpielMenuItems(JMenu gameMenu) {  
        
	    JMenuItem pauseItem = new JMenuItem("Pause");
	    gameMenu.add(pauseItem); 	    	  
	    pauseItem.addActionListener(new ActionListener() {	
	        @Override
	        public void actionPerformed(ActionEvent e) {	//Die anonyme Klasse besitzt diese Methode. Sie wird beim Anklicken ausgeführt.
	            spielfeld.pauseGame();
	        }
	    }); 
	    
	    JMenuItem continueItem = new JMenuItem("Fortsetzen");
	    gameMenu.add(continueItem); 	    	  
	    continueItem.addActionListener(new ActionListener() {	
	        @Override
	        public void actionPerformed(ActionEvent e) {	//Die anonyme Klasse besitzt diese Methode. Sie wird beim Anklicken ausgeführt.
	            spielfeld.continueGame();
	        }
	    }); 
	}
	
	private void registerWindowListener() {        
	    addWindowListener(new WindowAdapter() {  
	    	//Hier wird von der Abstrakten Klasse WindowAdapter, einer abstrakten Klasse,
	    	//abgeleitet, die Fensterereignisse empfängt.
			//Es müssen nur benötigte Methoden der Klasse ausprogrammiert werden (sonst bleiben sie leer).
	        @Override
	        public void windowClosing(WindowEvent e) { 	        	
	        	System.exit(0); 
	        }
	        @Override
	        public void windowDeactivated(WindowEvent e) {
	            // hier können wir unser Spiel pausieren                
	        }
	        @Override
	        public void windowActivated(WindowEvent e) {
	            // hier können wir unser Spiel wieder fortsetzen
	        }            
	    });        
	}
}
