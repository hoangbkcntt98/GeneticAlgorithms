package costoptimize;
import org.jgap.Chromosome;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;
import costoptimize.GAInit;
public class FitnessFunctionOfPopulation extends FitnessFunction{
	private static int n=3;//Number of retailers.
	private static final int [] yMins = {1600,700,1200};
	private static final int [] yMaxs = {4800,1400,3600};
	private static final int [] a = {31,35,37};
	private static final double [] b = {0.008,0.004,0.006};
	private static final double [] hCostR = {8,10,10};
	private static final double [] sCostR = {24,11,29};
	private static final double [] w = {0.004,0.008,0.005};
	private static final double hCostV = 3;
	private static final double sCostV = 5;
	private static final double z = 5;
	private static final int P = 18000;
	@Override
	protected double evaluate(IChromosome crs) {
		return caculateProfit((Chromosome)crs);
	}
	public static int caculateProfit(Chromosome crs)
	{
		double totalProfit=0;
		double T = caculateT(crs);
		int tempP=0;
		for(int i=0;i<n;i++)
		{
			int y= getValueOfGene(crs,i);
			int p = getValueOfGene(crs,n+i);
			if(p==y) return 0;
			totalProfit += a[i]*y-b[i]*y*y-(z*y+w[i]*y*y/2)-((sCostV+sCostR[i])/T+(hCostV+hCostR[i])*T*y*(1-y/p)/2); 
//			totalProfit +=y*p;
		}
		if (tempP>P||totalProfit<0)return 0;
		return (int )Math.ceil(totalProfit);
	}
	public static double caculateT(Chromosome crs)
	{
		double temp=0;
		for(int i=0;i<n;i++)
		{
			int y= getValueOfGene(crs,i);
			int p = getValueOfGene(crs,n+i);
			if((y/p)==1) return 0;
			temp = (2*(sCostR[i]+sCostV))/(y*(hCostV+hCostR[i])*(1-y/p));
		}
		return Math.sqrt(temp);
	}
	public static int getValueOfGene(Chromosome crs,int pos)
	{
		Integer value = (Integer)crs.getGene(pos).getAllele();
		return value.intValue();
	}
	public static int getN() {
		return n;
	}
	public static void setN(int n) {
		FitnessFunctionOfPopulation.n = n;
	}
	public static int[] getYmins() {
		return yMins;
	}
	public static int[] getYmaxs() {
		return yMaxs;
	}
	public static int getP() {
		return P;
	}
}
