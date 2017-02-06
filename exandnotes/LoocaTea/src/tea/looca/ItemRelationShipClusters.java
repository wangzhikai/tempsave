package tea.looca;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class ItemRelationShipClusters {
	

	static void processCluster() throws IOException {
		float thresh = -1.0f;
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String strLine = br.readLine();
		
		thresh = Float.parseFloat(strLine);
		//System.out.println(thresh);
		
		 strLine = br.readLine();
		 int rows = Integer.parseInt(strLine);
		 Map <String, Integer> itemClusterIDMap = new TreeMap<String, Integer>();
		 List<Set<String>> clusters = new ArrayList<Set<String>>();
		 
		 for (int i=0; i< rows; i++) {
			 strLine = br.readLine();
			 String [] arr = strLine.split("\\s+"); 
			 
			 String rhs = arr [0];
			 String lhs = arr [1];
			 float prob = Float.parseFloat(arr[2]);
			 if (prob < thresh) {
				 continue;
			 }
			 
			 if (itemClusterIDMap.keySet().contains(rhs) || itemClusterIDMap.keySet().contains(lhs) ){
				 // get cluster id starting with 0
				 Integer clusterId = itemClusterIDMap.get(rhs);
				 if (clusterId == null)
					 clusterId = itemClusterIDMap.get(lhs);
				 
				 Set<String> cluster = clusters.get(clusterId);
				 cluster.add(rhs);
				 cluster.add(lhs);
				 itemClusterIDMap.put(rhs, clusterId );
				 itemClusterIDMap.put(lhs, clusterId );

			 } else {
				 Set<String> cluster = new TreeSet<String> ();
				 Integer clusterId = new Integer(clusters.size());
				 cluster.add(rhs);
				 cluster.add(lhs);
				 itemClusterIDMap.put(rhs, clusterId );
				 itemClusterIDMap.put(lhs, clusterId );
				 clusters.add(cluster);
			 }
		 }
		 List<Integer> maxClustersIDs = new ArrayList<Integer>();
		 int max = -1;
		 
		 for (Set<String> s: clusters) {
			 if (max<s.size()) {
				 max = s.size();
			 }			 
		 }

		 Set<String> result = new TreeSet<String>();
		 for (Set<String> s: clusters) {
			 
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
