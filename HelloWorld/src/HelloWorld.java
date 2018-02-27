import javax.swing.JOptionPane;

public class HelloWorld {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		// Creates input dialog box 
		String myName = JOptionPane.showInputDialog("Ge mig ditt namn!");
		
        System.out.println("HelloWorld");
       
        System.out.println("Hello" + " " + myName);
        
        int [] anArray = {0, 1, 2 ,3, 34};
        int i2;
        for (i2=0; i2<2; i2++) {
        	System.out.println(anArray[i2]);
        }
        
        System.out.println("Hello" + " " + myName);
        System.out.println(myName.length());
        System.out.println(myName.startsWith("Nils"));
        System.out.println(myName.endsWith("Åman"));       
    }	
}
	