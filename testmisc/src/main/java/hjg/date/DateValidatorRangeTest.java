package hjg.date;

import org.junit.*;
import static org.junit.Assert.*;
 
public class DateValidatorRangeTest {
 
	private DateValidator dateValidator;
 
	@Before
	public void init() {
		dateValidator = new DateValidator();
	}
 
	@Test
	public void testDateWithinRange_1() {
		assertTrue(dateValidator.isThisDateWithin3MonthsRange("30/04/2014", "dd/MM/yyyy"));
	}
 
	@Test
	public void testDateWithinRange_2() {
		assertFalse(dateValidator.isThisDateWithin3MonthsRange("31/01/2011", "dd/MM/yyyy"));
	}
 
	@Test
	public void testDateWithinRange_3() {
		assertTrue(dateValidator.isThisDateWithin3MonthsRange("20/02/2012", "dd/MM/yyyy"));
	}
 
	@Test
	public void testDateWithinRange_4() {
		assertFalse(dateValidator.isThisDateWithin3MonthsRange("21/05/2012", "dd/MM/yyyy"));
	}
 
}
