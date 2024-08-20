
class Solution
{
    //Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n)
    {
        Arrays.sort(arr,(o1,o2)->o2.profit-o1.profit);
        
        boolean slot[] = new boolean[n+1];
        int ans[] = new int[2];
        
        for(Job j:arr){
            for(int i=j.deadline; i>=1;i--){
                
                if(!slot[i]){
                    slot[i]=true;
                    ans[1]+=j.profit;
                    ans[0]++;
                    break;
                }
            }
        }
        return ans;
    }
}
