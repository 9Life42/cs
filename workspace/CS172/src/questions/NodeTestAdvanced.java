package questions;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;

public class NodeTestAdvanced {

	private Node a;
	
	private Node b;
	
	private Node c;
	
	private Node d;
	
	private Node e;
	
	private Node f;
	
	private Node g;
	
	private Node h;
	
	private Node i;
	
	@Before
	public void setUp() {
		a = new Node("a");
		b = new Node("b");
		c = new Node("c");
		d = new Node("d");
		e = new Node("e");
		f = new Node("f");
		g = new Node("g");
		h = new Node("h");
		i = new Node("i");
		a.setLeft(b);
		b.setLeft(c);
		b.setRight(d);
		a.setRight(e);
		e.setRight(g);
		e.setLeft(f);
		g.setLeft(h);
		g.setRight(i);
	}

	@Test
	public void testChildGetters() {
		assertSame(b, a.getLeft());
		assertSame(e, a.getRight());
	}
	
	@Test
	public void testIsLeaf() {
		assertFalse(a.isLeaf());
		assertFalse(b.isLeaf());
		assertTrue(c.isLeaf());
		assertTrue(d.isLeaf());
		assertFalse(e.isLeaf());
		assertTrue(f.isLeaf());
		assertFalse(g.isLeaf());
		assertTrue(h.isLeaf());
		assertTrue(i.isLeaf());
	}
	
	@Test
	public void testHeight() {
		assertEquals(3, a.height());
		assertEquals(1, b.height());
		assertEquals(0, c.height());
		assertEquals(0, d.height());
		assertEquals(2, e.height());
		assertEquals(0, f.height());
		assertEquals(1, g.height());
		assertEquals(0, h.height());
		assertEquals(0, i.height());
	}
	
	@Test
	public void testToString() {
		assertEquals("a\n  b\n    c\n    d\n  e\n    f\n    g\n      h\n      i\n", a.toString());
	}

	@Test
	public void testAlternateConstructor() {
		Node root = new Node("Does it have a motor?",
				new Node("Does it store information?",
						new Node("a hard drive"),
						new Node("a car")),
				new Node("a giraffe"));
		assertEquals("Does it have a motor?\n  Does it store information?\n    a hard drive\n    a car\n  a giraffe\n", root.toString());
	}
	
	@Test
	public void testLearn() {
		Node root = new Node("Does it have a motor?",
				new Node("Does it store information?",
						new Node("a hard drive"),
						new Node("a car")),
				new Node("a giraffe"));
		root.getRight().learn("a whale", "Does it live in the ocean?");
		assertEquals("Does it have a motor?\n  Does it store information?\n    a hard drive\n    a car\n  Does it live in the ocean?\n    a whale\n    a giraffe\n", root.toString());				
	}

}
