/**
 * 
 */
package louis.object;

import java.lang.reflect.Field;
import java.util.Arrays;

/**
 * @author luongnv89
 * 
 */
public class LibraryLoader {
	public static void loadNativeLibraries() throws Exception {
		if (System.getProperty("os.name").equals("Mac OS X")) {
			addLibraryPath("natives/macosx");
		} else if (System.getProperty("os.name").equals("Linux")) {
			addLibraryPath("natives/linux");
		} else if (System.getProperty("os.name").equals("Windows")) {
			addLibraryPath("natives/windows");
			if (System.getProperty("os.arch").equals("amd64")
					|| System.getProperty("os.arch").equals("x86_64")) {
				System.loadLibrary("OpenAL64");
			} else {
				System.loadLibrary("OpenAL32");
			}
		}
	}

	private static void addLibraryPath(String path) throws Exception {
		final Field usr_paths_field = ClassLoader.class
				.getDeclaredField("usr_paths");
		usr_paths_field.setAccessible(true);

		final String[] paths = (String[]) usr_paths_field.get(null);
		for (String pth : paths) {
			if (pth.equals(path)) {
				return;
			}
		}

		final String[] new_paths = Arrays.copyOf(paths, path.length() + 1);
		new_paths[paths.length - 1] = path;
		usr_paths_field.set(null, new_paths);
	}
}
