package hjg.local;

import java.util.Locale;

public class ListCountry {

	public static void main(String[] args) {

		ListCountry obj = new ListCountry();
//		obj.listCountryCodeName();

		obj.getListOfCountries(Locale.CHINESE);
		
		// display in frence
	    // obj.getListOfCountries(Locale.FRENCH);
	}

	public void listCountryCodeName() {
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			System.out.println("Country Code = " + obj.getCountry()	+ ", Country Name = " + obj.getDisplayCountry());
		}
		System.out.println("Done");
	}

	public void getListOfCountries(Locale locale) {
		String[] locales = Locale.getISOCountries();
		for (String countryCode : locales) {
			Locale obj = new Locale("", countryCode);
			System.out.println("Country Code = " + obj.getCountry()
					+ ", Country Name = " + obj.getDisplayCountry(locale));
		}

	}

}
