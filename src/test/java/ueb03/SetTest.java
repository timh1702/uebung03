package ueb03;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class SetTest {
	@Test
	void testStringSet() {
		Set impl = new SetImpl();
		String str = "In Ulm und um Ulm und um Ulm herum";

		for (String c : str.split(" ")) {
			impl.add(c);
		}

		System.out.println(impl);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl.size());

		// Elemente testen
		assertTrue(impl.contains("In"));
		assertTrue(impl.contains("Ulm"));
		assertFalse(impl.contains(""));
		assertFalse(impl.contains("Hans"));

		// zwei herausnehmen
		impl.remove("Ulm");
		impl.remove("um");
		assertThrows(NoSuchElementException.class, () -> impl.remove("Hams"));

		assertEquals(3, impl.size());

		System.out.println(impl);

		// nochmal Elemente testen
		assertFalse(impl.contains("Ulm"));
		assertFalse(impl.contains("um"));
		assertFalse(impl.contains("Hans"));

		Set<String> impl2 = new SetImpl<>();
		String st = "In Ulm und um Ulm und um Ulm herum";

		for (String c : st.split(" ")) {
			impl2.add(c);
		}

		System.out.println(impl2);

		// sollte sein: In Ulm und um herum
		assertEquals(5, impl2.size());

		// Elemente testen
		assertTrue(impl2.contains("In"));
		assertTrue(impl2.contains("Ulm"));
		assertFalse(impl2.contains(""));
		assertFalse(impl2.contains("Hans"));

		// zwei herausnehmen
		impl2.remove("Ulm");
		impl2.remove("um");
		assertThrows(NoSuchElementException.class, () -> impl2.remove("Hams"));

		assertEquals(3, impl2.size());

		System.out.println(impl2);

		// nochmal Elemente testen
		assertFalse(impl2.contains("Ulm"));
		assertFalse(impl2.contains("um"));
		assertFalse(impl2.contains("Hans"));
	}

}