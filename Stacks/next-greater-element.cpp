// Given a circular integer array nums (i.e., the next element of nums[nums.length - 1] is nums[0]), return the next greater number for every element in nums.
// The next greater number of a number x is the first greater number to its traversing-order next in the array, which means you could search circularly to find 
// its next greater number. If it doesn't exist, return -1 for this number.

class nextGreaterElement {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> ans;
        stack<int> stk;
        int n = nums.size();
        for (int i = 2 * n - 1; i >= 0 ; i--)
        {
            while (!stk.empty() && stk.top() <= nums[i % n])
            {
                stk.pop();
            }
            if (i < n)
            {
                if (!stk.empty())
                {
                    ans.push_back(stk.top());
                }
                else
                {
                    ans.push_back(-1);
                }
            }
            stk.push(nums[i%n]);
        }
        reverse(ans.begin(), ans.end());
        return ans;
    }
};
