import java.util.ArrayList;
import java.util.List;

public class NBody{
    public static double readRadius(String FileName){
        In in = new In(FileName);

        int N = in.readInt();
        double R = in.readDouble();
        return R;
    }

    public static Planet[] readPlanets(String FileName){
        In in = new In(FileName);
        List<Planet> allPlanets = new ArrayList<Planet>();
        int N = in.readInt();
        double R = in.readDouble();

        while (!in.isEmpty()){
            String xxPosString = in.readString();
            try{
                double xxPos = Double.parseDouble(xxPosString);
            } catch (Exception e){
                break;
            }
            double xxPos = Double.parseDouble(xxPosString);
            double yyPos = in.readDouble();
            double xxVel = in.readDouble();
            double yyVel = in.readDouble();
            double mass = in.readDouble();
            String imgFileName = in.readString();
            Planet p = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName);
            allPlanets.add(p);
        }
        Planet[] Planets = allPlanets.toArray(new Planet[allPlanets.size()]);
        return Planets;
    }

    public static void main(String[] args){
        double T = Double.parseDouble(args[0]);
        double dt = Double.parseDouble(args[1]);
        String filename = args[2];
        double radius = NBody.readRadius(filename);
        Planet[] allPlanets = NBody.readPlanets(filename);

        /**Plot BackGround and emotionless planets*/
        String imageToDraw = "images/starfield.jpg";
        StdDraw.setScale(-1*radius, radius);
        StdDraw.clear();
        StdDraw.picture(0,0,imageToDraw);
        for (Planet p: allPlanets){
            p.draw();
        }
        StdDraw.show();

        /**Creating an Animation*/
        StdDraw.enableDoubleBuffering();
        double waitTimeMilliseconds = 0.0;
        while (waitTimeMilliseconds <= T){
            double[] xForces = new double[allPlanets.length];
            double[] yForces = new double[allPlanets.length];
            for (int i = 0; i < allPlanets.length;i = i + 1){
                xForces[i] = allPlanets[i].calcNetForceExertedByX(allPlanets);
                yForces[i] = allPlanets[i].calcNetForceExertedByY(allPlanets);
            }
            for (int i = 0; i < allPlanets.length;i = i + 1){
                allPlanets[i].update(dt, xForces[i], yForces[i]);
            }
            StdDraw.clear();
            StdDraw.picture(0,0,imageToDraw);
            for (Planet p: allPlanets){
                p.draw();
            }
            StdDraw.show();
            StdDraw.pause(10);
            waitTimeMilliseconds = waitTimeMilliseconds + dt;
        }
        StdOut.printf("%d\n", allPlanets.length);
        StdOut.printf("%.2e\n", radius);
        for (Planet p: allPlanets) {
            StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                  p.xxPos, p.yyPos, p.xxVel,
                  p.yyVel, p.mass, p.imgFileName);
                }
    }
}
