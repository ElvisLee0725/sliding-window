/*
If Alex needs to get a seat in between 2 people => (p2 - p1) / 2
If first seat at index 0 is empty => first people's index
If last seat at index len - 1 is empty => len - 1 - last people's index

Sliding Window:
Use index i and j as start and end
Each round, check if seats[j] is 1? Then, move i to j
      - Check if i is 0 and seats[i] == 0? If so, update the max distance if possible
      - Get the distance between i and j divide by 2 and update max distance if possible
If j reaches the last index and seats[j] == 0, update max distance if possible
Keep moving index j until j reaches the end

Time: O(N), Space: O(1)
*/


class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().maxDistToClosest(new int[]{1,0,0,0,1,0,1}));
    }
    public int maxDistToClosest(int[] seats) {
        int i = 0;
        int j = 0;
        int maxDist = 0;
        while(j < seats.length) {
            if(seats[j] == 1) {
                if(i == 0 && seats[i] == 0) {
                    maxDist = Math.max(maxDist, j);
                }
                else {
                    maxDist = Math.max(maxDist, (j - i) / 2);
                }
                i = j;
            }

            if(j == seats.length-1 && seats[j] == 0) {
                maxDist = Math.max(maxDist, seats.length - 1 - i);
            }
            j++;
        }
        return maxDist;
    }
}
