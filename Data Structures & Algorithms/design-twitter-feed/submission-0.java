class Twitter {

    private static int timeStamp = 0;

    // user -> set of followees
    private Map<Integer, Set<Integer>> follows;

    // user -> list of tweets
    private Map<Integer, List<Tweet>> tweets;

    // Tweet structure
    private static class Tweet {
        int id;
        int time;

        Tweet(int id, int time) {
            this.id = id;
            this.time = time;
        }
    }

    public Twitter() {
        follows = new HashMap<>();
        tweets = new HashMap<>();
    }

    // User posts a tweet
    public void postTweet(int userId, int tweetId) {
        tweets.putIfAbsent(userId, new ArrayList<>());
        tweets.get(userId).add(new Tweet(tweetId, timeStamp++));
    }

    // Get 10 most recent tweets
    public List<Integer> getNewsFeed(int userId) {
        PriorityQueue<Tweet> maxHeap =
                new PriorityQueue<>((a, b) -> b.time - a.time);

        // Add user's own tweets
        if (tweets.containsKey(userId)) {
            for (Tweet t : tweets.get(userId)) {
                maxHeap.offer(t);
            }
        }

        // Add followees' tweets
        Set<Integer> followees = follows.getOrDefault(userId, new HashSet<>());
        for (int followee : followees) {
            if (tweets.containsKey(followee)) {
                for (Tweet t : tweets.get(followee)) {
                    maxHeap.offer(t);
                }
            }
        }

        // Extract top 10 tweets
        List<Integer> feed = new ArrayList<>();
        while (!maxHeap.isEmpty() && feed.size() < 10) {
            feed.add(maxHeap.poll().id);
        }

        return feed;
    }

    // Follow a user
    public void follow(int followerId, int followeeId) {
        if (followerId == followeeId) return;
        follows.putIfAbsent(followerId, new HashSet<>());
        follows.get(followerId).add(followeeId);
    }

    // Unfollow a user
    public void unfollow(int followerId, int followeeId) {
        if (follows.containsKey(followerId)) {
            follows.get(followerId).remove(followeeId);
        }
    }
}
