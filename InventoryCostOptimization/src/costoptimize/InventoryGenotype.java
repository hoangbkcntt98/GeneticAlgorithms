package costoptimize;

import javax.swing.text.html.HTMLDocument.Iterator;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.Genotype;
import org.jgap.IChromosome;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;
import org.jgap.impl.IntegerGene;

public class InventoryGenotype extends Genotype{
	private Population m_population;

	public InventoryGenotype(Configuration a_configuration,Population a_population) throws InvalidConfigurationException {
		super(a_configuration);
		this.m_population=a_population;
	}
	public InventoryGenotype(Configuration a_configuration) throws InvalidConfigurationException {
		super(a_configuration);
	}
	
	  public void setPopulation(Population pop)
	  {
		  this.m_population = pop;
	  }
	  public void printPopulation()
	  {
		  for(int i=0;i<getPopulation().size();i++)
		  {
			  System.out.print("Chromosome["+i+"]: ");
			  GAInit.printValue((Chromosome) m_population.getChromosome(i));
		  }
	  }
	  public Population getPopulation() {
		    return m_population;
		  }
	  public boolean checkPopulation(Population pop)
	  {
		  if(this.getPopulation()==pop) return true;
		  return false;
	  }
	  public void addChromosome(Chromosome [] newChromosome)
	  {
		  for(int i=0;i<newChromosome.length;i++)
		  m_population.setChromosome(i, newChromosome[i]);
	  }
	  public void addChromosome(Chromosome newChromosome)
	  {
		 m_population.addChromosome(newChromosome);
	  }


}
