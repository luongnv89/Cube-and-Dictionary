/**
 * 
 */
package louis.object;

import static org.lwjgl.opengl.GL11.*;

import java.util.Calendar;

import org.lwjgl.LWJGLException;
import org.lwjgl.Sys;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.Display;
import org.lwjgl.opengl.DisplayMode;

/**
 * @author luongnv89
 * 
 */
public class MyGame {

	float x = 100;
	float y = 100;

	float rotation = 0.0f;

	long last_frame;
	int fps;
	long last_fps;

	public void start() throws LWJGLException {
		Display.setDisplayMode(new DisplayMode(800, 600));
		Display.create();

		initGL();
		getDelta();
		last_fps = getTime();

		while (!Display.isCloseRequested()) {
			int delta = getDelta();
			update(delta);
			renderGL();
			Display.update();
			// Display.sync(60);
		}

		Display.destroy();
		System.exit(0);
	}

	private void renderGL() {
		glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);
		glColor3f(1.0f, 1.0f, 0.0f);

		glPushMatrix();
		// glTranslatef(x, y, 0);
		// glRotatef(rotation, 0f, 0f, 1f);
		// glTranslatef(-x, -y, 0);
		// drawQUAD();
		// drawAxis();
		drawClock();
		// drawSquareEqual(1, 6, 9);
		glPopMatrix();
	}

	private void drawSquareEqual(int a, int b, int c) {
		glColor3f(1.0f, 0.0f, 0.0f);
		for (int i = -100; i < 100; i++) {
			glPushMatrix();
			{
				glTranslatef(x, y, 0);
				glBegin(GL_LINES);
				float x0 = i;
				float y0 = a * x0 * x0 + b * x0 + c;
				float x1 = (i + 1);
				float y1 = a * x1 * x1 + b * x1 + c;
				glVertex2f(x0, y0);
				glVertex2f(x1, y1);
				glEnd();
			}
			glPopMatrix();
		}

	}

	private void drawAxis() {
		glBegin(GL_LINES);
		{
			glVertex2f(x, y);
			glVertex2f(x + 300, y);

			glVertex2f(x, y);
			glVertex2f(x, y + 200);

		}

		glEnd();
	}

	private void drawClock() {
		float x = 400f;
		float y = 300f;
		// display the 12 quads
		for (int i = 0; i < 12; i++) {
			glPushMatrix();
			glTranslatef(x, y, 0);
			glRotatef(i * 30, 0, 0, -1);
			// glScalef(2.0f, 2.0f, 2.0f);
			if (i % 3 == 0) {
				glBegin(GL_QUADS);
				glVertex2f(-5, 200);
				glVertex2f(-5, 200 + 10);
				glVertex2f(5, 200 + 10);
				glVertex2f(5, 200);
				glEnd();
			} else {
				glBegin(GL_QUADS);
				glVertex2f(-2, 200);
				glVertex2f(-2, 200 + 4);
				glVertex2f(2, 200 + 4);
				glVertex2f(2, 200);
				glEnd();
			}
			glPopMatrix();
		}
		// display the three pointers
		Calendar now = Calendar.getInstance();

		// hour
		float hour = now.get(Calendar.HOUR_OF_DAY) * 30;
		glPushMatrix();
		glTranslatef(x, y, 0);
		// glScalef(2.0f, 2.0f, 2.0f);
		glRotatef(hour, 0, 0, -1);
		glBegin(GL_TRIANGLES);
		glVertex2f(-5f, 0f);
		glVertex2f(0f, 100f);
		glVertex2f(5f, 0f);
		glEnd();
		glPopMatrix();

		// Min
		float min = now.get(Calendar.MINUTE) * 6;
		glPushMatrix();
		glTranslatef(x, y, 0);
		// glScalef(2.0f, 2.0f, 2.0f);
		glRotatef(min, 0, 0, -1);
		glBegin(GL_TRIANGLES);
		glVertex2f(-3, 0);
		glVertex2f(0, 150);
		glVertex2f(3, 0);
		glEnd();
		glPopMatrix();

		// Second
		float second = now.get(Calendar.SECOND) * 6;
		glPushMatrix();
		glTranslatef(x, y, 0);
		// glScalef(2.0f, 2.0f, 2.0f);
		glRotatef(second, 0, 0, -1);
		glBegin(GL_TRIANGLES);
		glVertex2f(-2f, 0f);
		glVertex2f(0f, 180f);
		glVertex2f(2f, 0f);
		glEnd();
		glPopMatrix();

	}

	/**
	 * 
	 */
	private void drawQUAD() {
		glBegin(GL_QUADS);
		{
			glVertex2f(x - 20, y - 20);
			glVertex2f(x + 20, y - 20);
			glVertex2f(x + 20, y + 20);
			glVertex2f(x - 20, y + 20);

		}

		glEnd();
	}

	private int getDelta() {
		long time = getTime();
		int delta = (int) (time - last_frame);
		last_frame = time;
		return delta;
	}

	private void update(int delta) {
		rotation += 0.15f * delta;
		if (Keyboard.isKeyDown(Keyboard.KEY_A)) {
			x -= 0.35f * delta;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_D)) {
			x += 0.35f * delta;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_W)) {
			y += 0.35f * delta;
		}

		if (Keyboard.isKeyDown(Keyboard.KEY_S)) {
			y -= 0.35f * delta;
		}

		if (x < 0)
			x = 0;
		if (x > 800)
			x = 800;
		if (y < 0)
			y = 0;
		if (y > 600)
			y = 600;

		updateFPS();
	}

	private void updateFPS() {
		if (getTime() - last_fps > 200) {
			Display.setTitle("FPS: " + fps);
			fps = 0;
			last_fps += 200;
		}

		fps++;
	}

	private long getTime() {
		return Sys.getTime() * 1000 / Sys.getTimerResolution();
	}

	private void initGL() {
		glMatrixMode(GL_PROJECTION);
		glLoadIdentity();
		glOrtho(0, 800, 0, 600, -1, 1);
		glMatrixMode(GL_MODELVIEW);

	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			LibraryLoader.loadNativeLibraries();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail to load library");
			System.exit(0);
		}

		System.out.println("Load library successfully!");

		try {
			new MyGame().start();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Fail to create Display");
			System.exit(0);
		}

	}

}