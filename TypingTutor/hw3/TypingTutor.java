package hw3;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class TypingTutor extends JFrame implements KeyListener{
	private final int WIDTH = 910, LENGTH = 560;
    
    private JTextArea noteBox, typeBox;
    private ArrayList<JButton> buttons;
    
    int[] line1 = {192,49,50,51,52,53,54,55,56,57,48,45,61,8}; // ~ to backspace
	int[] line2 = {9,81,87,69,82,84,89,85,73,79,80,91,93,92};	// tab to \ 
	int[] line3 = {KeyEvent.VK_CAPS_LOCK,65,83,68,70,71,72,74,75,76,59,222,10}; // cap to enter
	int[] line4 = {16,90,88,67,86,66,78,77,44,46,47,38}; // shift to ^
	int[] line5 = {32,37,40,39};	// white space to > 
	
	private Map<Integer, String> uncharMap = new HashMap<Integer, String>(); // ¯S®í¦r¤¸

    public TypingTutor() {
    	super("Typing Application");
    	
        setLayout(null);
        setVisible(true);
        addKeyListener(this);
     
        String note = new String("Type some text using your keyboard. "
        		+ "The keys you press will be highlighted and the text will be displayed.\n"
        		+ "Note Clicking the buttons with your mouse will not perform any action.");
        
        
        Container pane = getContentPane();
        // add note
        int x = 30,y = 10;
        noteBox = new JTextArea(note);
        noteBox.setBounds(x, y, WIDTH-75, 50);
        noteBox.setBackground(null);
        noteBox.setFocusable(false);
        
        pane.add(noteBox);
        y+=50;
        
        // add type space
        typeBox = new JTextArea(); 
        typeBox.setBounds(x, y, WIDTH-75, 150); 
        typeBox.setFocusable(false);
        pane.add(typeBox);
        y+=170;
        
        //add buttons
        buttons = new ArrayList<JButton>();
        
        setUnChar();
        int width = 50 , height = 50, startx = 0, space = 5;
     
		// line1
		int[] tmpKeyVal = new int[line1.length - 1];
		System.arraycopy(line1, 0, tmpKeyVal, 0, tmpKeyVal.length);
		setButton(tmpKeyVal,startx ,space, x, y, width, height);
	    //backspace
		tmpKeyVal = new int[]{line1[line1.length - 1]}; 
		startx = (width + space) *13;
		setButton(tmpKeyVal,startx,space, x, y, width *2 , height); 
		y += height + space;	
			
		// line2
		tmpKeyVal = new int[]{line2[0]}; // tab
		setButton(tmpKeyVal,0,space, x, y, width + width /2 , height); 
		startx = width + width / 2 + space  ;
		tmpKeyVal = new int[line2.length - 1];
		System.arraycopy(line2, 1, tmpKeyVal, 0, tmpKeyVal.length);
		setButton(tmpKeyVal,startx ,space, x, y, width, height);
		y += height + space;
		
		// line3				
		tmpKeyVal = new int[]{line3[0]}; //caps
		setButton(tmpKeyVal,0,space, x, y, width + width /2  , height);
		startx =  width + width / 2 + space;
		tmpKeyVal = new int[line3.length - 2];
		System.arraycopy(line3, 1, tmpKeyVal, 0, tmpKeyVal.length);
		setButton(tmpKeyVal,startx,space, x, y, width, height);
		tmpKeyVal =  new int[]{line3[line3.length - 1]};//enter
		startx += (width + space) *11;
		setButton(tmpKeyVal,startx,space, x, y, width*2+space, height);
		y += height + space;
		
		// line4
		tmpKeyVal = new int[]{line4[0]};//shift
		setButton(tmpKeyVal,0,space, x, y, width * 2 + width / 2 , height);
		startx = width * 2 + width / 2 + space;
		tmpKeyVal = new int[line4.length - 1];
		System.arraycopy(line4, 1, tmpKeyVal, 0, tmpKeyVal.length);
		setButton(tmpKeyVal,startx,space, x, y, width, height);
		y += height + space;
		
		// line5
		tmpKeyVal = new int[]{line5[0]};// white space
		x += width * 2 + width / 2 + space*3 + width*2 ;
		setButton(tmpKeyVal,0,space, x, y, width *6+ space*5  , height);
		startx =  width *7+ space*7 ;
		tmpKeyVal = new int[line5.length - 1];
		System.arraycopy(line5, 1, tmpKeyVal, 0, tmpKeyVal.length);
		setButton(tmpKeyVal,startx,space, x, y, width, height);
		
		for(int i=0;i<buttons.size();i++)
			pane.add(buttons.get(i));

        setSize(WIDTH, LENGTH);
    }
    
    //deal with tab, enter...(not char)
    public void setUnChar(){
		uncharMap.put(61, "+");
		uncharMap.put(47, "?");
		uncharMap.put(59, ":");
		uncharMap.put(9, "Tab");
		uncharMap.put(192, "~");
		uncharMap.put(8, "Backspace");
		uncharMap.put(222, "\"");
		uncharMap.put(KeyEvent.VK_CAPS_LOCK, "Caps");
		uncharMap.put(10, "Enter");
		uncharMap.put(16, "Shift");
		uncharMap.put(38, "^");
		uncharMap.put(37, "<");
		uncharMap.put(39, ">");
		uncharMap.put(40, "v");
	}	
    
    //turn the key value to the output char
    public String keyToChar(int key) {
    	if (key == 192)
    		return "~";
    	else if(key == 61)
    		return "+";
    	else if(key == 59)
    		return ":";
    	else if(key == 222)
    		return "\"";
    	else if(key == 47)
    		return "?";
    	else if(key == 32)
    		return " ";
    	else if(key == 10)
    		return "\n";
    	String s = KeyEvent.getKeyText(key);
    	if(s == "Minus") 
    		return "-";
    	else if(s == "Open Bracket")
    		return "[";
    	
    	else if(s == "Close Bracket")
    		return "]";
    		
    	else if(s == "Back Slash")
    		return "\\";
    		
    	else if(s == "Comma")
    		return ",";
    		
    	else if(s == "Period")
    		return ".";
    
    	
	    return s;
    
    }
    
    
    //get the arraylist index of key
    public int arrIndex(int key){
    	if(key == 192)
    		return 0;
    	else if (key >= 49 && key <= 57)
    		return key-48;
    	else if (key == 48)
    		return 10;
    	else if (key == 45)
    		return 11;
    	else if (key == 61)
    		return 12;
    	else if (key == 8)
    		return 13;
    	else if (key == 9)
    		return 14;
    	else if (key == 81)
    		return 15;
    	else if (key == 87)
    		return 16;
    	else if (key == 69)
    		return 17;
    	else if (key == 82)
    		return 18;
    	else if (key == 84)
    		return 19;
    	else if (key == 89)
    		return 20;
    	else if (key == 85)
    		return 21;
    	else if (key == 73)
    		return 22;
    	else if (key == 79)
    		return 23;
    	else if (key == 80)
    		return 24;
    	else if (key == 91)
    		return 25;
    	else if (key == 93)
    		return 26;
    	else if (key == 92)
    		return 27;
    	else if (key == KeyEvent.VK_CAPS_LOCK)
    		return 28;
    	else if (key == 65)
    		return 29;
    	else if (key == 83)
    		return 30;
    	else if (key == 68)
    		return 31;
    	else if (key >= 70 && key <= 72)
    		return key - 38;
    	else if (key >= 74 && key <= 76)
    		return key-39;
    	else if (key == 59)
    		return 38;
    	else if (key == 222)
    		return 39;
    	else if (key == 10)
    		return 40;
    	else if (key == 16)
    		return 41;
    	else if (key == 90)
    		return 42;
    	else if (key == 88)
    		return 43;
    	else if (key == 67)
    		return 44;
    	else if (key == 86)
    		return 45;
    	else if (key == 66)
    		return 46;
    	else if (key == 78)
    		return 47;
    	else if (key == 77)
    		return 48;
    	else if (key == 44)
    		return 49;
    	else if (key == 46)
    		return 50;
    	else if (key == 47)
    		return 51;
    	else if (key == 38)
    		return 52;
    	else if (key == 32)
    		return 53;
    	else if (key == 37)
    		return 54;
    	else if (key == 40)
    		return 55;
    	else if (key == 39)
    		return 56;
    	
    	return -1;
    }
    
    
    
    //add the button into JButton arraylist(buttons)
    public void setButton(int[] line,int startx,int cell,int x,int y ,int width,int height){
		for(int j = 0;j < line.length; j++){
			String keyStr = uncharMap.get(line[j]); 
			if(keyStr == null)
				keyStr = String.valueOf((char) line[j]);
	
			JButton jb = new JButton(keyStr);
			jb.setBounds(startx + x + (cell + width) * j  , y, width, height);
			jb.setFocusable(false);
			buttons.add(jb);
		}
	}
    
    /* when press
     * 1. print the enter text 
     * 2. change the button color 
    */
    @Override
    public void keyPressed (KeyEvent e) {
		int key = e.getKeyCode();
		int i = arrIndex(key);
		String text = keyToChar(key);
		if (key!=8 && key!= KeyEvent.VK_CAPS_LOCK  && key!= 16 && key!= 38 && key!= 37 && key!= 39 && key!= 40)
            typeBox.append(text);
		else if (key == 8) {
		    String tempStr = typeBox.getText();
		    typeBox.setText(tempStr.substring(0,tempStr.length() - 1));
		}
		if(i!=-1)
            buttons.get(i).setBackground(Color.WHITE);
    }
    
    /* when release 
     * 1. change the button color to null 
    */

    @Override
    public void keyReleased (KeyEvent e) {
    	int key = e.getKeyCode();
		int i = arrIndex(key);
		if(i!=-1)
		    buttons.get(i).setBackground(null);
    }

    
	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
	}
}