package tea.looca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ItemRelationShipClusters2 {
	

	static void processCluster() throws IOException {
		float thresh = -1.0f;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strLine = br.readLine();
		
		thresh = Float.parseFloat(strLine);
		//System.out.println(thresh);
		
		 strLine = br.readLine();
		 int rows = Integer.parseInt(strLine);
		 Map <String, Integer> itemClusterIDMap = new TreeMap<String, Integer>();
		 Map<Integer,Set<String>> clusters = new HashMap<Integer,Set<String>>();
		 
		 for (int i=0; i< rows; i++) {
			 strLine = br.readLine();
			 String [] arr = strLine.split("\\s+"); 
			 
			 // one item
			 if (arr.length == 1) {
				 String rhs = arr [0];
				 if (!itemClusterIDMap.keySet().contains(rhs)) {
					 //TODO build a new cluster
					 Set<String> cluster = new TreeSet<String> ();
					 Integer clusterId = new Integer(clusters.size());
					 cluster.add(rhs);
					 itemClusterIDMap.put(rhs, clusterId );
					 clusters.put(clusterId,cluster);
				 } else {
					 continue;
				 }
			 }
			 
			 String rhs = arr [0];
			 String lhs = arr [1];
			 float prob = Float.parseFloat(arr[2]);
			 if (prob < thresh) {
				 continue;
			 }
			 
			 if (itemClusterIDMap.keySet().contains(rhs) || itemClusterIDMap.keySet().contains(lhs) ){
				 String one = "";
				 String theOther = "";
				 if ( itemClusterIDMap.keySet().contains(rhs) ) {
					 one = rhs;
					 theOther = lhs;
				 } else {
					 one = lhs;
					 theOther = rhs;
				 }
				 // if theOthe belongs to another cluster, put all the other cluster to one's cluster
				 if (itemClusterIDMap.get(theOther) == null) {
					 // add the other to cluster
					 Integer oneId = itemClusterIDMap.get(one);
					 Set<String> cluster = clusters.get(oneId);
					 cluster.add(theOther);
					 itemClusterIDMap.put(theOther, oneId);
					 
				 } else {
					 //TODO merge tow clusters
					 // ignore already in same cluster
					 if (!itemClusterIDMap.get(theOther).equals(itemClusterIDMap.get(one))) {
						 Integer oneId = itemClusterIDMap.get(one);
						 Integer theOtherId  = itemClusterIDMap.get(theOther);
						 Set<String> cluster = clusters.get(oneId);
						 Set<String> otherCluster = clusters.get(theOtherId);
						 clusters.remove(theOtherId);
						 cluster.addAll(otherCluster);
						 for (String s: otherCluster) {
							 itemClusterIDMap.put(s, oneId);
						 }
					 }
				 }

			 } else {
				 //TODO build a new cluster
				 Set<String> cluster = new TreeSet<String> ();
				 Integer clusterId = new Integer(clusters.size());
				 cluster.add(rhs);
				 cluster.add(lhs);
				 itemClusterIDMap.put(rhs, clusterId );
				 itemClusterIDMap.put(lhs, clusterId );
				 clusters.put(clusterId,cluster);
			 }
		 }
		 List<Integer> maxClustersIDs = new ArrayList<Integer>();
		 int max = -1;
		 
		 for (Set<String> s: clusters.values()) {
			 if (max<s.size()) {
				 max = s.size();
			 }			 
		 }

		 Set<String> result = new TreeSet<String>();
		 for (Set<String> s: clusters.values()) {
			 
			 if (max==s.size()) {
				 String first = null;
				 for (String str: s) {
					 first = str;
					 break;
				 }
				 result.add(first);
			 }			 
		 }
		 String first = null;
		 for (String str: result) {
			 first = str;
			 break;
		 }
		 System.out.println(first);
		 
		 
		 br.close();
	}

	public static void main(String[] args) throws IOException {
		processCluster();

	}

}
/* input
0.15
4
Item1 Item2 0.2
Item2 Item3 0.1
Item4 Item5 0.3
Item5 Item6 0.4

//output
Item4

*/ 