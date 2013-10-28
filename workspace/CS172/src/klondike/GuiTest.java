package klondike;

import static java.io.File.separator;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GuiTest {

	private Gui gui;
	
	@Before
	public void setUp() throws Exception {
		gui = new Gui();
	}

	@Test
	public void testImageFilename() {
		Card c = new Card(3, Card.HEARTS);
		assertEquals("card-images" + separator + "47.png", gui.imageFilename(c));
		c.setFaceUp(false);
		assertEquals("card-images" + separator + "b2fv.png", gui.imageFilename(c));		
	}

}
