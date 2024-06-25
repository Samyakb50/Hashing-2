// Time Complexity :
// Space Complexity :
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
TC: O(n^2)
SC: O(1)
class Solution {
    public int subarraySum(int[] nums, int k) {
        int i = 0;
        int j = 0;
        int k1 = 0;
        int ans = 0;
        int n = nums.length;
        for (i=0;i<n;i++){
            for (j=i;j<n;j++){
                int sum = 0;
                for (k1=i;k1<=j;k1++){
                    sum += nums[k1];
                }
                if (sum == k)
                    ans++;
            }
        }
        return ans;
    }
}

Hashing based solution
TC: O(n)
SC: O(n)
class Solution {
    public:
        int subarraySum(vector<int>& nums, int k) {
            map<int, int> s;
            int i,n=nums.size(),sum=0,res=0;
            for(i=0;i<n;i++){
                sum+=nums[i];
                if(sum==k)
                    res++;
                if(s.find(sum-k)!=s.end()){
                    res+=s[sum-k];
                }
                s[sum]++;
            }
            return res;
        }
    };


    TC O(n)  where n is length of String
    SC O(n)

    public class Solution {
        public int longestPalindrome(String s) {
    
            HashSet<Character> charSet = new HashSet<>();
            int length = 0;
            for (char c : s.toCharArray()) {
                if (charSet.contains(c)) {
                    charSet.remove(c);
                    length += 2;
                } else {
                    charSet.add(c);
                }
            }
            
            if (!charSet.isEmpty()) {
                length += 1;
            }
            
            return length;
        }
    }


    TC O(n)
    SC O(n)
    class Solution {
        public int findMaxLength(int[] nums) {
            HashMap<Integer, Integer> sum = new HashMap<>();
            int s = 0;
            int longest = 0;
            sum.put(0, -1); // put 0 to the left
            for(int i = 0;i < nums.length;++i) {
                if(nums[i] == 0) {
                    s += -1;
                } else {
                    s += 1;
                }
                
                if(sum.containsKey(s)) {
                    longest = Math.max(longest, i - sum.get(s));       
                } else {
                    sum.put(s, i);
                }
            }
            
            return longest;
        
        }
    }