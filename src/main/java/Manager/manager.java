package Manager;

import resource.propertyreader;

public class manager 
{
	private static manager fileReaderManager = new manager();
	private static propertyreader configFileReader;

	private manager() {
	}

	 public static manager getInstance( ) {
	      return fileReaderManager;
	 }

	 public propertyreader getConfigReader() {
		 return (configFileReader == null) ? new propertyreader() : configFileReader;
	 }

}
