class Solution {

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        Map<String, List<String>> graph = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();

        // Step 1: Build the graph
        for (List<String> account : accounts) {

            String name = account.get(0);
            String firstEmail = account.get(1);

            for (int i = 1; i < account.size(); i++) {

                String email = account.get(i);

                // Store email -> name mapping
                emailToName.put(email, name);

                // Create graph nodes
                graph.putIfAbsent(firstEmail, new ArrayList<>());
                graph.putIfAbsent(email, new ArrayList<>());

                // Connect first email with current email
                graph.get(firstEmail).add(email);
                graph.get(email).add(firstEmail);
            }
        }

        Set<String> visited = new HashSet<>();
        List<List<String>> result = new ArrayList<>();

        // Step 2: Find connected components using DFS
        for (String email : graph.keySet()) {

            if (!visited.contains(email)) {

                List<String> mergedEmails = new ArrayList<>();

                dfs(email, graph, visited, mergedEmails);

                // Sort emails
                Collections.sort(mergedEmails);

                // Add person's name at index 0
                mergedEmails.add(0, emailToName.get(email));

                result.add(mergedEmails);
            }
        }

        return result;
    }


    private void dfs(
            String email,
            Map<String, List<String>> graph,
            Set<String> visited,
            List<String> mergedEmails) {

        visited.add(email);
        mergedEmails.add(email);

        for (String neighbor : graph.get(email)) {

            if (!visited.contains(neighbor)) {
                dfs(neighbor, graph, visited, mergedEmails);
            }
        }
    }
}