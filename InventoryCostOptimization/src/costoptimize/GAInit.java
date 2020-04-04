package costoptimize;

import org.jgap.impl.ChromosomePool;
import org.jgap.impl.DefaultConfiguration;
import org.jgap.impl.IntegerGene;

import java.awt.Choice;

import org.jgap.*;

public class GAInit {
	private static final int POPULATION_SIZE = 2000;
	public static void CaculateProfit(int n) throws InvalidConfigurationException
	{
		Configuration conf = new DefaultConfiguration();
		conf.getGeneticOperators().remove(0);
	    conf.setPreservFittestIndividual(true);
	    conf.setKeepPopulationSizeConstant(false);
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
		//Create popolation
		Population pop = new Population(conf,POPULATION_SIZE);
		Chromosome [] chrTemp = new Chromosome[POPULATION_SIZE];
		int checkY=0;
		int totalP=0;
		int count=0;
		Chromosome temp = new Chromosome(conf,6);
		Gene [] newGenes = new Gene[2*n];
		while(true)
		{
			totalP =0;
			checkY=0;
			RandomGenerator generator = conf.getRandomGenerator();
			for(int i=0;i<2*n;i++) {
				if(i<n) {
					newGenes[i]= sampleChromosome.getGene(i).newGene();
					newGenes[i].setToRandomValue(generator);
				}else {
					newGenes[i] = sampleChromosome.getGene(i).newGene();
					newGenes[i].setToRandomValue(generator);
					totalP+=getValueOfGene(newGenes[i]);
				}
			}
			for(int i=0;i<n;i++)
			{
				if(getValueOfGene(newGenes[i])>=getValueOfGene(newGenes[i+n])) checkY=1;
			}
			if(totalP<=P&&checkY==0) {
				 Chromosome chrom= new Chromosome(conf,6);
				 chrom.setGenes(newGenes);
				 pop.addChromosome((Chromosome) chrom.clone()); 
				 count++;
			}
			if(count==POPULATION_SIZE) {
				break;
			}
		}
		InventoryGenotype population = new InventoryGenotype(conf,pop);
		System.out.println("genotype size:"+population.getChromosomes().length);
		System.out.println("The chromosomes are:");
		population.printPopulation();
//		System.out.println(population.checkPopulation(pop));
		Chromosome kq = (Chromosome) population.getFittestChromosome();
		
		System.out.println("Best soluttion is");
		for(int i=0;i<2*n;i++)
		{
			System.out.println(FitnessFunctionOfPopulation.getValueOfGene(kq,i)+" ");
		}
		System.out.println("Maximum of profit is"+FitnessFunctionOfPopulation.caculateProfit(kq));
	}
	public static void swapChromosome(Chromosome c1,Chromosome c2) {
		Chromosome temp = c1;
		c1=c2;
		c2=temp;
	}
	public static void swapGene(Gene g1, Gene g2)
	{
		Gene temp = g1.newGene();
		temp = g1;
		g1=g2;
		g2=temp;
	}
	public static void printValue(Chromosome crs) {
		for(int i=0;i<crs.size();i++)
		{
			System.out.print(FitnessFunctionOfPopulation.getValueOfGene(crs,i) +"\t");;
		}
		System.out.println();
	}
	public static int getValueOfGene(Gene gen) {
		Integer value = (Integer) gen.getAllele();
		return value.intValue();
	}
	public static void main(String[] args) throws InvalidConfigurationException
	{
		CaculateProfit(FitnessFunctionOfPopulation.getN());
	}

}
