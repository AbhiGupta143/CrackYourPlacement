class Solution {
    public int maxProfit(int[] prices) {
        // at  the beginning the miniuem price is the first price 
        int buy_price = prices[0];

        // at the beginning the minium profit is zero
        int profit = 0;

        for(int i = 0; i< prices.length; i++){

            // if the current price is less update the buy price
            if(prices[i] < buy_price){
                buy_price = prices[i];
            }
            else{
                // else check if we can get a better profit

                int current_profit = prices[i] - buy_price;
                profit = Math.max(current_profit, profit);
            }
        }
        return profit;
    }
}
