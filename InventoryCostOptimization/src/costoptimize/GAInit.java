package costoptimize;

import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;
import org.jgap.*;

public class GAInit {
	private static final int POPULATION_SIZE = 2000;
	public static void CaculateProfit(int n) throws InvalidConfigurationException
	{
		Configuration conf = new DefaultConfiguration();
		conf.reset();
		conf.setPreservFittestIndividual(true);//Co lay gia tri toi uu nhat
		FitnessFunction func = new FitnessFunctionOfPopulation();
		conf.setFitnessFunction(func);
		int P = FitnessFunctionOfPopulation.getP();
		int yMins[] = FitnessFunctionOfPopulation.getYmins();
		int yMaxs[] = FitnessFunctionOfPopulation.getYmaxs();
		Gene []sampleGenes = new Gene[2*n];
		for(int i=0;i<n;i++)
		{
			sampleGenes[i] = new IntegerGene(conf,yMins[i],yMaxs[i]);
			sampleGenes[i+n] = new IntegerGene(conf,yMins[i],P);
		}	
		Chromosome sampleChromosome = new Chromosome(conf,sampleGenes);
		conf.setSampleChromosome(sampleChromosome);
		conf.setPopulationSize(POPULATION_SIZE);
		Genotype population = Genotype.randomInitialGenotype(conf);
		for(int i=0;i<2000;i++)
		{
			population.evolve();
		}
		Chromosome kq = (Chromosome) population.getFittestChromosome();
		System.out.println("Best soluttion is");
		for(int i=0;i<2*n;i++)
		{
			System.out.println(FitnessFunctionOfPopulation.getValueOfGene(kq,i));
		}
		
	}
	public static void main(String[] args) throws InvalidConfigurationException
	{
		CaculateProfit(FitnessFunctionOfPopulation.getN());
	}

}
