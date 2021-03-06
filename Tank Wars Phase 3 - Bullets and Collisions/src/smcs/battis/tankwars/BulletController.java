package smcs.battis.tankwars;

import java.util.*;

/**
 * Animate the path of a bullet, checking to see if it hits anything
 * 
 * @author sethbattis
 *
 */
public class BulletController implements Runnable {

    public static final long DELAY = 250; // millis

    private Bullet bullet;
    private BulletView view;

    public BulletController(Bullet bullet, BulletView view) {
	this.bullet = bullet;
	this.view = view;

	/* start the bullet controller thread */
	new Thread(this).start();
    }

    @Override
    public void run() {
	Vector<SolidObject> hits;

	do {
	    view.draw();
	    try {
		Thread.sleep(DELAY);
	    } catch (InterruptedException e) {
		// do nothing
	    }
	} while ((hits = bullet.move()).isEmpty());
	view.draw();

	/* print out if any of the hits are a tank */
	for (Iterator<SolidObject> i = hits.iterator(); i.hasNext();) {
	    if (i.next().getClass() == Tank.class) {
		System.out.println("Hit a tank.");
	    }
	}

    }

}
