
import java.util.ArrayList;
import java.util.List;

/**
 * @author Zhikai Wang/www.heteroclinic.net
 * This class is an example/exercise to provide a code base to compute k-combinations of a set, using functional programming features.
 * Given third party license acknowledged and this header kept or quoted, you can utilize this program at will.
 * Juggling elements among:
 * [spared][selected][remaining]
 */

public class Test01 {
	public interface ListPrintor {
		public boolean print (List<Integer> l, int segmentLength);
	}
	public interface Reeper {
		public boolean harvest(ListPrintor listPrintor, List<Integer> spared, List<Integer> choices, List<Integer> remaining, int K);

	}
	public interface KCombination {
		// Juggling elements among: [spared][selected][remaining]
		public void juggle ( Reeper r,ListPrintor listPrintor,List<Integer> spared, List<Integer> choices, List<Integer> remaining, int K);
	}
	public static void main(String[] args) {
		List<Integer> a = new ArrayList<Integer>();
		for (int i = 1; i<=5 ; i++) {
			a.add(i);
		} 
		ListPrintor lPrintor = (l,s)-> new Object () {
			public boolean run (List<Integer> l, int segmentLength) {
				for (int i:l) 
					System.out.print(i+ " ");
				System.out.println();
				return true;
			}
		}.run(l,s);
		Reeper reeper = (l,s,c,r,k) -> new Object () {
			public boolean run (ListPrintor listPrintor,List<Integer> spared, List<Integer> choices, List<Integer> remaining, int K ) {
				if ( choices.size() >= K ) {
					// Print choices
					listPrintor.print(choices,K);
					return true;
					
				} else if ( remaining.size() <= K - choices.size()) {
					// Print remaining + choices
					List<Integer> pl = new ArrayList<Integer>();
					pl.addAll(choices);
					pl.addAll(remaining);
					listPrintor.print(pl,K);
					return true;
				}
				return false;
			}
		}.run(l,s,c,r,k);
		KCombination kComb = (r,p,s,c,m,k) -> new Object () {
			public void choose ( Reeper r,ListPrintor listPrintor,List<Integer> spared, List<Integer> choices, List<Integer> remaining, int K) {
				if (r.harvest(listPrintor, spared, choices, remaining, K)) 
					return;
				// For the first element of the remaining
				if ( remaining.size() <= 0)
					return;
				int firstOfRemaining = remaining.get(0);
				
				// Choose it, call choose to pick one more
				choices.add(firstOfRemaining);
				remaining.remove(new Integer(firstOfRemaining));
				
				List<Integer> ns = new ArrayList<Integer>();
				ns.addAll(spared);
				List<Integer> nc = new ArrayList<Integer>();
				nc.addAll(choices);
				List<Integer> nr = new ArrayList<Integer>();
				nr.addAll(remaining);
				choose ( r, listPrintor,ns,nc, nr,  K);
						
				// Spare it, call choose to pick one more
				spared.add(firstOfRemaining);
				choices.remove(new Integer(firstOfRemaining));		
				ns = new ArrayList<Integer>();
				ns.addAll(spared);
				nc = new ArrayList<Integer>();
				nc.addAll(choices);
				nr = new ArrayList<Integer>();
				nr.addAll(remaining);
				choose ( r, listPrintor,  ns,nc, nr,  K);		

			}
		}.choose(r,p,s,c,m,k);
		kComb.juggle(reeper, lPrintor, new ArrayList<Integer> (), new ArrayList<Integer> (),a, 3);
		

	}

}