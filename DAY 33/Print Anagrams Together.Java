class Solution {
    public List<List<String>> Anagrams(String[] string_list) {
        // Code here
        if(string_list.length == 0){
            return new ArrayList();
        }
        HashMap<String, List> ans =  new HashMap<>();
        for(String s : string_list){
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList());
                
            }
                ans.get(key).add(s);
    
            }
            return new ArrayList(ans.values());
        
    }
}
