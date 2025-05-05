class Solution {
    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    public List<List<String>> accountsMerge(List<List<String>> accounts) {
        Map<String, Integer> emailToIndex = new HashMap<>();

        // Initialize Disjoint Set
        for (int i = 0; i < accounts.size(); i++) {
            parent.add(i);
            size.add(1);
        }

        // Union all emails in the same account
        for (int i = 0; i < accounts.size(); i++) {
            for (int j = 1; j < accounts.get(i).size(); j++) {
                String email = accounts.get(i).get(j);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, i);
                } else {
                    unionBySize(i, emailToIndex.get(email));
                }
            }
        }

        // Group emails by their ultimate parent
        Map<Integer, Set<String>> mergedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToIndex.entrySet()) {
            String email = entry.getKey();
            int index = findParent(entry.getValue());
            mergedEmails.computeIfAbsent(index, k -> new TreeSet<>()).add(email);
        }

        // Build final result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, Set<String>> entry : mergedEmails.entrySet()) {
            List<String> list = new ArrayList<>();
            list.add(accounts.get(entry.getKey()).get(0)); // account name
            list.addAll(entry.getValue());
            result.add(list);
        }

        return result;
    }

    private int findParent(int node) {
        if (node != parent.get(node)) {
            parent.set(node, findParent(parent.get(node)));
        }
        return parent.get(node);
    }

    private void unionBySize(int u, int v) {
        int rootU = findParent(u);
        int rootV = findParent(v);

        if (rootU == rootV) return;

        if (size.get(rootU) < size.get(rootV)) {
            parent.set(rootU, rootV);
            size.set(rootV, size.get(rootU) + size.get(rootV));
        } else {
            parent.set(rootV, rootU);
            size.set(rootU, size.get(rootU) + size.get(rootV));
        }
    }
}
