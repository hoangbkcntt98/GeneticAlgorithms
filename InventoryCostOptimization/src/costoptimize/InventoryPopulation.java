package costoptimize;

import org.jgap.Chromosome;
import org.jgap.Configuration;
import org.jgap.InvalidConfigurationException;
import org.jgap.Population;

public class InventoryPopulation extends Population{

	public InventoryPopulation(Configuration a_config) throws InvalidConfigurationException {
		super(a_config);
		// TODO Auto-generated constructor stub
	}
	public void addChromosome(Chromosome newC) {
		this.getChromosomes().add(newC);
	}
}
