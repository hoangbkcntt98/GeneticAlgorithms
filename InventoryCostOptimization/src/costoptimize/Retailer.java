package costoptimize;

public class Retailer {
	private double hCost;//HoldingCost of the Retailer
	private double sCost;//Ordering (Setup) cost of the retailer
	private int a;//Intercept of the demand curve of the retailer 
	private double b;//Slope of the demand curve of the retailer
	private int yMax;// Maximum expected sales quantity of the retailer 
	private int yMin;// Mimimum expected sales quantity of the retailer 
	private int w;//Flow cost per unit from producer to the retailer
	
	public Retailer(double hCost, double sCost, int a, double b, int yMax, int yMin, int w) {
		super();
		this.hCost = hCost;
		this.sCost = sCost;
		this.a = a;
		this.b = b;
		this.yMax = yMax;
		this.yMin = yMin;
		this.w = w;
	}
	public double gethCost() {
		return hCost;
	}
	public void sethCost(double hCost) {
		this.hCost = hCost;
	}
	public double getsCost() {
		return sCost;
	}
	public void setsCost(double sCost) {
		this.sCost = sCost;
	}
	public int getA() {
		return a;
	}
	public void setA(int a) {
		this.a = a;
	}
	public double getB() {
		return b;
	}
	public void setB(double b) {
		this.b = b;
	}
	public int getyMax() {
		return yMax;
	}
	public void setyMax(int yMax) {
		this.yMax = yMax;
	}
	public int getyMin() {
		return yMin;
	}
	public void setyMin(int yMin) {
		this.yMin = yMin;
	}
	public int getW() {
		return w;
	}
	public void setW(int w) {
		this.w = w;
	}
	
	
}
