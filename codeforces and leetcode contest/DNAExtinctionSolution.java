import java.util.*;

public class DNAExtinctionSolution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        int n = scanner.nextInt(); // number of survivors
        int q = scanner.nextInt(); // number of test species
        int l = scanner.nextInt(); // length of DNA strings
        
        Set<String> survivors = new HashSet<>();
        
        // Read survivor DNA sequences
        for (int i = 0; i < n; i++) {
            survivors.add(scanner.next());
        }
        
        // Process each test species
        for (int i = 0; i < q; i++) {
            String testDNA = scanner.next();
            String result = classifySpecies(testDNA, survivors, l);
            System.out.println(result);
        }
        
        scanner.close();
    }
    
    public static String classifySpecies(String testDNA, Set<String> survivors, int l) {
        // Build the set of all genes that appear in survivors
        boolean[] survivorGenes = new boolean[l];
        for (String survivor : survivors) {
            for (int i = 0; i < l; i++) {
                if (survivor.charAt(i) == '1') {
                    survivorGenes[i] = true;
                }
            }
        }
        
        // For each possible extinction set, check if:
        // 1. It doesn't kill any survivor (valid extinction set)
        // 2. Whether it kills the test species
        
        boolean canSurvive = false;
        boolean canDie = false;
        
        // Try all possible non-empty subsets of genes
        for (int mask = 1; mask < (1 << l); mask++) {
            boolean validExtinctionSet = true;
            
            // Check if this extinction set kills any survivor
            for (String survivor : survivors) {
                boolean survivorDies = false;
                for (int i = 0; i < l; i++) {
                    if ((mask & (1 << i)) != 0 && survivor.charAt(i) == '1') {
                        survivorDies = true;
                        break;
                    }
                }
                if (survivorDies) {
                    validExtinctionSet = false;
                    break;
                }
            }
            
            if (validExtinctionSet) {
                // Check if this extinction set kills the test species
                boolean testDies = false;
                for (int i = 0; i < l; i++) {
                    if ((mask & (1 << i)) != 0 && testDNA.charAt(i) == '1') {
                        testDies = true;
                        break;
                    }
                }
                
                if (testDies) {
                    canDie = true;
                } else {
                    canSurvive = true;
                }
            }
        }
        
        if (canSurvive && canDie) {
            return "uncertain";
        } else if (canSurvive) {
            return "survives";
        } else {
            return "dies";
        }
    }
}
