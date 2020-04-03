package costoptimize;

public class Vendor {
	private double hCost;//Inventory holding cost of the vendor (producer) at the independent mode
	private double sCost;//Setup cost of the vendor per order at the independent mode
	private double z;//Production cost per unit made by the vendor (producer)
	private int P;//Total production rate of the vendor (producer)
	public Vendor(double hCost, double sCost, double z, int p) {
		super();
		this.hCost = hCost;
		this.sCost = sCost;
		this.z = z;
		P = p;
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
	public double getZ() {
		return z;
	}
	public void setZ(double z) {
		this.z = z;
	}
	public int getP() {
		return P;
	}
	public void setP(int p) {
		P = p;
	}
	
}
