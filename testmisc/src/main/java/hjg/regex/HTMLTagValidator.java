package hjg.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class HTMLTagValidator {

	private Pattern pattern;
	private Matcher matcher;

	private static final String HTML_TAG_PATTERN = "<(\"[^\"]*\"|'[^']*'|[^'\">])*>";

	public HTMLTagValidator() {
		pattern = Pattern.compile(HTML_TAG_PATTERN);
	}

	/**
	 * Validate html tag with regular expression
	 * 
	 * @param tag
	 *            html tag for validation
	 * @return true valid html tag, false invalid html tag
	 */
	public boolean validate(final String tag) {
		matcher = pattern.matcher(tag);
		return matcher.matches();
	}

	public static void main(String[] args) {
		HTMLTagValidator tagValidator = new HTMLTagValidator();
		String tags[] = { 
				"<b>",
				"<input value='>'>", 
				"<input value='<'>", 
				"<b/>", 
				"<a href='http://www.google.com'>",
				"<br>", 
				"<br/>", 
				"<input value=\"\" id='test'>", 
				"<input value='' id='test'>",
				"<input value=\" id='test'>", 
				"<input value=' id='test'>", 
				"<input value=> >" };

		for (String t : tags) {
			System.out.println(t + " , " + tagValidator.validate(t));
		}
	}

}