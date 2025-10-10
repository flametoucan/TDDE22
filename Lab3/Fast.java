import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.List;


/**
 * Brute force solution. To run: java brute.java < input.txt
 *
 * @author Magnus Nielsen
 * Largely based on existing C++-laborations by Tommy Olsson and Filip Strömbäck.
 */
public class Fast {
    /**
     * Clear the window and paint all the Points in the plane.
     *
     * @param frame - The window / frame.
     * @param points - The points to render.
     */
    private static void render(JFrame frame, ArrayList<Point> points) {
        frame.removeAll();
        frame.setVisible(true);

        for (Point p : points) {
            p.paintComponent(frame.getGraphics(), frame.getWidth(), frame.getHeight());
        }
    }

    /**
     * Draw a line between two points in the window / frame.
     *
     * @param frame - The frame / window in which you wish to draw the line.
     * @param p1 - The first Point.
     * @param p2 - The second Point.
     */
    private static void renderLine(JFrame frame, Point p1, Point p2) {
        p1.lineTo(p2, frame.getGraphics(), frame.getWidth(), frame.getHeight());
    }

    /**
     * Read all the points from the buffer in the input scanner.
     *
     * @param input - Scanner containing a buffer from which to read the points.
     * @return ArrayList<Point> containing all points defined in the file / buffer.
     */
    private static ArrayList<Point> getPoints(Scanner input) {
        int count = input.nextInt();
        ArrayList<Point> res = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            res.add(new Point(input.nextInt(), input.nextInt()));
        }

        return res;
    }

    public static void main(String[] args) throws InterruptedException {
        JFrame frame;
        Scanner input = null;
        File f;
        ArrayList<Point> points;
        ArrayList<Point> listOfPoints;
        ArrayList<Point> listOfLinkedPoints;

        if (args.length != 1) {
            System.out.println("Usage: java Brute <input.txt>\n" + "Replace <input.txt> with your input file of preference, and possibly the path.\n" + "Ex: java Brute data/input1000.txt");
            System.exit(0);
        }

        // Opening the file containing the points.
        f = new File(args[0]);
        try {
            input = new Scanner(f);
        } catch (FileNotFoundException e) {
            System.err.println("Failed to open file. Try giving a correct file / file path.");
        }

        // Creating frame for painting.
        frame = new JFrame();
        frame.setMinimumSize(new Dimension(512, 512));
        frame.setPreferredSize(new Dimension(512,512));

        // Getting the points and painting them in the window.
        points = getPoints(input);
        render(frame, points);

	// Sorting points by natural order (lexicographic order). Makes finding end points of line segments easy.
        Collections.sort(points, new NaturalOrderComparator());

        long start = System.currentTimeMillis();

	//////////////////////////////////////////////////////////////////////
	// Your code goes here. Draw any lines you find using the function  //
	//  renderLine. Look at Brute.java if you are unsure if how to use  //
	//                     any functions. Good luck!                    //
	//////////////////////////////////////////////////////////////////////

        int n = points.size();
        
        // Precompute base array och work array (snabbare än att kopiera listor) tror inte man behöver 2 listor men funkade
        Point[] base = points.toArray(new Point[0]);
        Point[] work = new Point[n];

        // Samla segment och rita efter beräkningen (minskar grafik-anrop under beräkning)
        ArrayList<Point[]> segments = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Point p = points.get(i);

            // Kopiera in i arbetsbuffert och sortera efter lutning mot p, finns bättre lösning här men funkade
            System.arraycopy(base, 0, work, 0, n);
            java.util.Arrays.sort(work, new NaturalOrderComparatorAngle(p));

            // Om p hamnar först (slope -INF), starta från index 1
            final int len = work.length;
            int j = (len > 0 && work[0] == p) ? 1 : 0;
            while (j < len) {
                // om färre än 3 punkter återstår kan vi inte bilda ett nytt segment
                if (len - j < 3) break;
                if (work[j] == p) { // hoppa över p om den dyker upp, ska inte ritas
                    j++;
                    continue;
                }
                double s = p.slopeTo(work[j]);
                int k = j + 1;
                while (k < len && Double.compare(p.slopeTo(work[k]), s) == 0) {
                    k++;
                }
                int run = k - j; // antal punkter (exkl p) med samma lutning
                if (run >= 3) {
                    Point min = p, max = p;
                    for (int t = j; t < k; t++) {
                        Point q = work[t];
                        if (q.lessThan(min)) min = q;
                        if (q.greaterThan(max)) max = q;
                    }
                    if (p == min) {
                        segments.add(new Point[]{min, max});
                    }
                }
                j = k; // nästa lutningsgrupp
            }
        }

        // Rita linjer efter beräkningen
        for (Point[] seg : segments) {
            renderLine(frame, seg[0], seg[1]);
        }

        long end = System.currentTimeMillis();
                System.out.println("Computing all the line segments took: " + (end - start) + " milliseconds.");
            }


    /**
     * Comparator class. Used to tell Collections.sort how to compare
     * objects of a non standard class. When you make your own
     * Comparator, keep in mind that this is a class like any other,
     * and can contain data and other methods if you deem it useful.
     */
    private static class NaturalOrderComparator implements Comparator<Point> {
        public int compare(Point a, Point b) {
            if (a.greaterThan(b)) {
                return 1;
            } else if (a.lessThan(b)) {
                return -1;
            }
            return 0;
        }
    }

    private static class NaturalOrderComparatorAngle implements Comparator<Point> {
        private Point p;

        public NaturalOrderComparatorAngle(Point p) {
            this.p = p;
        }

        public int compare(Point a, Point b) {
            return Double.compare(p.slopeTo(a), p.slopeTo(b));
        }
    }
}
