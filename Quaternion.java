package quaternions;

/**
 * Quaternion
 * 
 * @author Bjoern Luig
 * @version 3.11.2016
 */
public class Quaternion{
    
    private double a;
    private double b; //i
    private double c; //j
    private double d; //k

    /**
     * Constructor for Objects of the Class Quaternion
     * 
     * @param pA a Value
     * @param pB b Value
     * @param pC c Value
     * @param pD d Value
     */
    public Quaternion(double pA, double pB, double pC, double pD){
        a = pA;
        b = pB;
        c = pC;
        d = pD;
    }
    
    public double a(){
        return(a);
    }
    
    public double b(){
        return(b);
    }
    
    public double c(){
        return(c);
    }
    
    public double d(){
        return(d);
    }

    /**
     * Addition of two Quaternions
     * 
     * @param q1 first Quaternion
     * @param q2 second Quaternion
     * @return Sum of q1 + q2
     */
    public Quaternion sum(Quaternion q1, Quaternion q2){
        double a = q1.a() + q2.a();
        double b = q1.b() + q2.b();
        double c = q1.c() + q2.c();
        double d = q1.d() + q2.d();
        Quaternion q3 = new Quaternion(a, b, c, d);
        return(q3);
    }
    
    /**
     * Conjugation of a Quaternion
     * @param q1 Quaternion
     * @return Conjugation of q1
     */
    public Quaternion conjugate(Quaternion q1) {
    	double a = q1.a();
    	double b = - q1.b();
    	double c = - q1.c();
    	double d = - q1.d();
    	Quaternion q2 = new Quaternion(a, b, c, d);
    	return(q2);
    }

    /**
     * Multiplication of two Quaternionens
     * 
     * @param q1 first Quaternion
     * @param q2 second Quaternion
     * @return Product of q1 * q2
     */
    public Quaternion product(Quaternion q1, Quaternion q2){
        double a = q1.a() * q2.a() - q1.b() * q2.b() - q1.c() * q2.c() - q1.d() * q2.d();
        double b = q1.a() * q2.b() + q1.b() * q2.a() + q1.c() * q2.d() - q1.d() * q2.c();
        double c = q1.a() * q2.c() - q1.b() * q2.d() + q1.c() * q2.a() + q1.d() * q2.b();
        double d = q1.a() * q2.d() + q1.b() * q2.c() - q1.c() * q2.b() + q1.d() * q2.a();
        Quaternion q3 = new Quaternion(a, b, c, d);
        return(q3);
    }
}