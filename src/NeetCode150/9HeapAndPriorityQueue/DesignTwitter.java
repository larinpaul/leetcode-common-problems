//// 2023/07/19 // 12:31 //

//// Design Twitter // Medium //

// Design a simplified version of Twitter where users can post tweets, follow/unfollow another
// user, and is able to see the 10 most recent tweets in the user's news feed.

// Implement the Twitter class:
// * Twitter() initializes your twitter object.
// * void postTweet(int userId, int tweetId) Composes a new tweet with ID tweetId
// by the user userId. Each call to this function will be made with a unique tweetId.
// * List<Integer> getNewsFeed(int userId) Retrieves the 10 most recent tweet IDs in
// the user's news feed. Each item in the news feed must be posted by users who the user
// followed or by the user themself. Tweets must be ordered from most recent to least
// recent.
// * void follow(int followerId, int followerId) The user with ID followerId
// started following the user with ID followedId.
// * void unfollow(int followerId, int followeeId) The user with ID followerId
// started unfollowing the user with ID followeeId.

// Example 1:
// Input
// ["Twitter", "postTweet", "getNewsFeed", "follow", "postTweet", "getNewsFeed", "unfollow", "getNewsFeed"]
// [[], [1, 5], [1], [1, 2], [2, 6], [1], [1, 2], [1]]
// Output
// [null, null, [5], null, null, [6, 5], null, [5]]
// Explanation
// Twitter twitter = new Twitter();
// twitter.postTweet(1, 5); // User 1 posts a new tweet (id = 5).
// twitter.getNewsFeed(1); // User 1's new feed should return a
// list with 1 tweet id -> [5]. return [5]
// twitter.follow(1,2); // User 1 follows user 2.
// twitter.postTweet(2, 6); // User 2 posts a new tweet (id = 6).
// twitter.getNewsFeed(1); // User 1's news feed should return a
// list with 2 tweet ids -> [6, 5]. Tweet id 6 should precede tweet
// id 5 because it is posted after tweet id 5.
// twitter.unfollow(1, 2); // User 1 unfollows user 2.
// twitter.getNewsFeed(1); // User 1's news feed should return a
// list with 1 tweet id -> [5], since user 1 is no longer following user 2.

// Constraints:
// * 1 <= userId, followerId, followeeId <= 500
// * 0 <= tweetId <= 10^4
// * All the tweets have unique IDs.
// * At most 3 * 10^4 calls will be made to postTweet, getNewsFeed, follow, and unfollow.

import java.util.*;

/**
 * Your twitter object will be instantiated and called as such:
 * Twitter obj = new Twitter();
 * obj.postTweet(userId,tweetId);
 * List<Integer> param_2 = obj.getNewsFeed(userId);
 * obj.follow(followerId,followeeId);
 * obj.unfollow(followerId,followeeId);
 */
class DesignTwitter {

    // This problem can be solved by using a combination of Data Structures:
    // HashMap, HashSet, and PriorityQueue.
    // Here is a general approach to solve this problem:
    // * HashMap userMap maintains the user and the people he/she follows.
    // * HashMap tweetMap maintains the user and his/her tweets.
    // * Each tweet has a timestamp to keep track of when it was posted.
    // * When getting the news feed, get all the tweets of the user and the people he/she follows,
    // and maintain a heap of size 10 to get the most recent 10 tweets.

    private static int timeStamp = 0;
    private Map<Integer, User> userMap;

    private class Tweet {
        public int id;
        public int time;
        public Tweet next;

        public Tweet(int id) {
            this.id = id;
            time = timeStamp++;
            next = null;
        }
    }

    private class User {
        public int id;
        public Set<Integer> followed;
        public Tweet tweet_head;

        public User(int id) {
            this.id = id;
            followed = new HashSet<>();
            follow(id);
            tweet_head = null;
        }

        public void follow(int id) {
            followed.add(id);
        }

        public void unfollow(int id) {
            followed.remove(id);
        }

        public void post(int id) {
            Tweet t = new Tweet(id);
            t.next = tweet_head;
            tweet_head = t;
        }
    }

    public Twitter() {
        userMap = new HashMap<Integer, User>();
    }

    public void postTweet(int userId, int tweetId) {
        if (!userMap.containsKey(userId)) {
            User u = new User(userId);
            userMap.put(userId, u);
        }
        userMap.get(userId).post(tweetId);
    }

    public List<Integer> getNewsFeed(int userId) {
        List<Integer> res = new LinkedList<>();

        if (!userMap.containsKey(userId)) return res;

        Set<Integer> users = userMap.get(userId).followed;
        PriorityQueue<Tweet> q = new PriorityQueue<Tweet>(users.size(), (a, b) -> (b.time - a.time));
        for (int user : users) {
            Tweet t = userMap.get(user).tweet_head;
            if (t != null) {
                q.add(t);
            }
        }
        int n = 0;
        while (!q.isEmpty() && n < 10) {
            Tweet t = q.poll();
            res.add(t.id);
            n++;
            if (t.next != null)
                q.add(t.next);
        }

        return res;
    }

    public void follow(int followerId, int followeeId) {
        if (!userMap.containsKey(followerId)) {
            User u = new User(followerId);
            userMap.put(followerId, u);
        }
        if (!userMap.containsKey(followeeId)) {
            User u = new User(followeeId);
            userMap.put(followeeId, u);
        }
        userMap.get(followerId).follow(followeeId);
    }

    public void unfollow(int followerId, int followeeId) {
        if (userMap.containsKey(followerId) && followerId != followeeId) {
            userMap.get(followerId).unfollow(followeeId);
        }
    }

    // Big O:

    // The time complexity of posting a tweet is O(1) because it only involves
    // inserting a new tweet at the head of the linked list.
    // The time complexity of follow and unfollow operations is also O(1)
    // because it only involves updating a HashSet.
    // The time complexity of getting a news feed is O(NlogK),
    // where N is the total number of tweets and K is the maximum number of tweets to be returned (in this case, 10).
    // This is because we are maintaining a heap of size K and traversing through all the tweets.

    // The space complexity is O(N + M), where N is the number of users and M is the number of tweets.
    // This is because we maintain a separate list of tweets and followed users for each user.

}
