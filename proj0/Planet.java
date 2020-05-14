public class Planet{
    public double xxPos, yyPos, xxVel, yyVel, mass;
    public String imgFileName;

    public Planet(double xP, double yP, double xV,
                  double yV, double m, String img){
      xxPos=xP;
      yyPos=yP;
      xxVel=xV;
      yyVel=yV;
      mass=m;
      imgFileName=img;
    }

    public Planet(Planet p){
        this.xxPos=p.xxPos;
        this.yyPos=p.yyPos;
        this.xxVel=p.xxVel;
        this.yyVel=p.yyVel;
        this.mass=p.mass;
        this.imgFileName=p.imgFileName;
    }

    public double calcDistance(Planet p){
        /*return Math.pow(Math.pow(this.xxPos-p.xxPos,2)
        +Math.pow(this.yyPos-p.yyPos,2),0.5);*/
        /*In Java, there is no built in operator that does squaring or exponentiation.
        We recommend simply multiplying a symbol by itself instead of using Math.pow,
        which will result in slower code.*/
        return Math.pow((this.xxPos-p.xxPos)*(this.xxPos-p.xxPos)
        +(this.yyPos-p.yyPos)*(this.yyPos-p.yyPos),0.5);
    }

    public double calcForceExertedBy(Planet p){
        double G=6.67e-11;
        return G*this.mass*p.mass/
        (this.calcDistance(p)*this.calcDistance(p));
    }

    public double calcForceExertedByX(Planet p){
        double dist=this.calcDistance(p);
        double force=this.calcForceExertedBy(p);
        return (p.xxPos-this.xxPos)*force/dist;
    }

    public double calcForceExertedByY(Planet p){
        double dist=this.calcDistance(p);
        double force=this.calcForceExertedBy(p);
        return (p.yyPos-this.yyPos)*force/dist;
    }

    public double calcNetForceExertedByX(Planet[] allPlanets){
        double netXForce=0.0;
        for (Planet p : allPlanets){
          if (this.equals(p)){
              continue;
          }else{
              netXForce = netXForce+this.calcForceExertedByX(p);
          }
        }
        return netXForce;
    }

    public double calcNetForceExertedByY(Planet[] allPlanets){
        double netYForce=0.0;
        for (Planet p : allPlanets){
            if (this.equals(p)){
                continue;
            }else{
                netYForce = netYForce+this.calcForceExertedByY(p);
            }
        }
        return netYForce;
    }

    public void update(double dt, double fX, double fY){
        double aNetX=fX/this.mass;
        double aNetY=fY/this.mass;
        this.xxVel=this.xxVel+dt*aNetX;
        this.yyVel=this.yyVel+dt*aNetY;
        this.xxPos=this.xxPos+dt*this.xxVel;
        this.yyPos=this.yyPos+dt*this.yyVel;
    }

    public void draw(){
        StdDraw.picture(this.xxPos,this.yyPos,"images/"+this.imgFileName);
    }
}
