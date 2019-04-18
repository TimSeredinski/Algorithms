package genetic;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public class Genetic {
    private int from = -100;
    private int to = 100;
    private Individual bestFromAll;
    private Individual bestFromThisPopulation;
    private int[] koefs;
    private int numberOfPopulation = 80;
    private int numberForSelection = 30;//Из скольки особей выбираем
    private int numberOfSelectionForOne = 10;//Сколько скрещиваний на одну особь
    private int repeats = 0;
    private int maxRepeat = 300;
    private double mutationVar = 0.1;
    private double nuclearBlastMutation = 0.7;


    private int pow(int elem, int pow) {
        int result = 1;
        for (int i = 0; i < pow; i++) {
            result *= elem;
        }
        return result;
    }

    public Genetic(int[] elems) {
        this.koefs = elems;
    }

    public Individual solve() {
        List<Individual> population = new ArrayList<>();
        for (int i = 0; i < numberOfPopulation; i++) {
            Individual individual = new Individual(from, to);
            population.add(individual);
            individual.setFa(findFaWithIndividual(individual));
        }
        population.sort(Comparator.comparing(Individual::getFa));
        bestFromAll = population.get(0);
        bestFromThisPopulation = population.get(0);
        double notNuclear = mutationVar;
        boolean isNuclearBlast = false;
        for (int i = 0; bestFromThisPopulation.getFa() != 0; i++) {
            if (repeats > maxRepeat) {
                isNuclearBlast = true;
                mutationVar = nuclearBlastMutation;
            }
            List<Individual> newPopulation = new ArrayList<>(changeGen(population));
            population.clear();
            population.addAll(newPopulation);
            bestFromThisPopulation = population.get(0);
            if (bestFromThisPopulation.getFa() < bestFromAll.getFa()) {
                bestFromAll = bestFromThisPopulation;
                repeats = 0;
            } else {
                repeats++;
            }
            System.out.println("Best from All: " + bestFromAll);
            System.out.println("Best from  gen " + (i+1) + ": " + bestFromThisPopulation);
            if (isNuclearBlast) {
                mutationVar = notNuclear;
                repeats = 0;
            }
        }
        return bestFromAll;
    }

    private List<Individual> changeGen(List<Individual> population) {
        List<Individual> newGen = new ArrayList<>();
        for (int start = 0; start < numberForSelection; start++) {
            List<Individual> popForSelect = new ArrayList<>();
            for (int j = 0; j < numberForSelection; j++) {
                popForSelect.add(population.get(j));
            }
            for (int j = 0; j < numberOfSelectionForOne; j++) {
                newGen.addAll(Crossbreeding(popForSelect.get(0), popForSelect.get(j)));
                popForSelect.remove(j);
            }
        }
        for (int i = 1; i <= newGen.size(); i++) {
            newGen.set(newGen.size() - i, mutation(newGen.get(newGen.size() - i)));
        }
        newGen.sort(Comparator.comparing(Individual::getFa));
        List<Individual> trueNewGen = new ArrayList<>();
        for (int i = 0; i < numberOfPopulation; i++) {
            trueNewGen.add(newGen.get(i));
        }
        return trueNewGen;
    }

    private List<Individual> Crossbreeding(Individual first, Individual second) {
        Individual firstChild = new Individual(first.getU(), first.getW(), second.getX(), second.getY(), second.getZ());
        Individual secondChild = new Individual(second.getU(), second.getW(), first.getX(), first.getY(), first.getZ());
        Individual thirdChild = new Individual(first.getU(), second.getW(), second.getX(), first.getY(), first.getZ());
        Individual fourthChild = new Individual(second.getU(), first.getW(), first.getX(), second.getY(), second.getZ());
        firstChild.setFa(findFaWithIndividual(firstChild));
        secondChild.setFa(findFaWithIndividual(secondChild));
        thirdChild.setFa(findFaWithIndividual(thirdChild));
        fourthChild.setFa(findFaWithIndividual(fourthChild));
        List<Individual> result = new ArrayList<>();
        result.add(firstChild);
        result.add(secondChild);
        result.add(thirdChild);
        result.add(fourthChild);
        return result;
    }

    private Individual mutation(Individual individual) {
        double newKoef = mutationVar * 10000;
        boolean isSomethingChange = false;
        Random random = new Random();
        int temp;
        temp = random.nextInt(10000);

        if (temp <= newKoef) {
            isSomethingChange = true;
            individual.setU(from + random.nextInt(to - from + 1));
        }
        temp = random.nextInt(10000);
        if (temp <= newKoef) {
            isSomethingChange = true;
            individual.setW(from + random.nextInt(to - from + 1));
        }
        temp = random.nextInt(10000);
        if (temp <= newKoef) {
            isSomethingChange = true;
            individual.setX(from + random.nextInt(to - from + 1));
        }
        temp = random.nextInt(10000);
        if (temp <= newKoef) {
            isSomethingChange = true;
            individual.setY(from + random.nextInt(to - from + 1));
        }
        temp = random.nextInt(10000);
        if (temp <= newKoef) {
            isSomethingChange = true;
            individual.setZ(from + random.nextInt(to - from + 1));
        }
        if (isSomethingChange) {
            individual.setFa(findFaWithIndividual(individual));
        }
        return individual;
    }

    private int findFaWithIndividual(Individual individual) {
        int resultOfMult = 1;
        int result = 0;
        for (int i = 0; i < 25; ) {
            resultOfMult *= pow(individual.getU(), koefs[i++]);
            resultOfMult *= pow(individual.getW(), koefs[i++]);
            resultOfMult *= pow(individual.getX(), koefs[i++]);
            resultOfMult *= pow(individual.getY(), koefs[i++]);
            resultOfMult *= pow(individual.getZ(), koefs[i++]);
            result += resultOfMult;
            resultOfMult = 1;
        }
        return Math.abs(result - koefs[25]);
    }

}
